package us.ihmc.encryptedProperties;

import nu.studer.java.util.OrderedProperties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class EncryptedPropertyAdder
{
   public EncryptedPropertyAdder(String key, String value)
   {
      CredentialsEncryptor credentialsEncryptor = CredentialsEncryptor.withPassphrase(EncryptedPropertyManager.DEFAULT_PASSPHRASE.toCharArray());
      File credentialsFile = Paths.get(System.getProperty("user.home"), ".gradle", "gradle.encrypted.properties").toFile();
      CredentialsPersistenceManager credentialsPersistenceManager = new CredentialsPersistenceManager(credentialsFile);
      OrderedProperties credentials = credentialsPersistenceManager.readCredentials();
      credentials.setProperty(key, credentialsEncryptor.encrypt(value));

      try
      {
         FileOutputStream propertiesFileOutputStream = new FileOutputStream(credentialsFile);
         try
         {
            credentials.store(propertiesFileOutputStream, null);
         } finally
         {
            propertiesFileOutputStream.close();

            System.out.println("Wrote " + key + "=***** to " + credentialsFile.toPath().toAbsolutePath());
         }
      }
      catch (IOException e)
      {
         throw new RuntimeException(e);
      }
   }

   public static void main(String[] args)
   {
      if (args.length != 2)
      {
         System.out.println("Usage:");
         System.out.println("> ./encrypted-properties-adder <key> <value>");
      }
      else
      {
         new EncryptedPropertyAdder(args[0], args[1]);
      }
   }
}

