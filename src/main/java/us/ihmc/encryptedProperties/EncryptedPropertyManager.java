package us.ihmc.encryptedProperties;

import nu.studer.java.util.OrderedProperties;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class EncryptedPropertyManager
{
   // from https://github.com/etiennestuder/gradle-credentials-plugin/blob/master/src/main/groovy/nu/studer/gradle/credentials/CredentialsPlugin.java
   public static final String DEFAULT_PASSPHRASE = ">>Default passphrase to encrypt passwords!<<";

   public static HashMap<String, String> loadEncryptedCredentials(Path enryptedPropertiesFile, String passphrase)
   {
      CredentialsEncryptor credentialsEncryptor = CredentialsEncryptor.withPassphrase(passphrase.toCharArray());
      File credentialsFile = enryptedPropertiesFile.toFile();
      CredentialsPersistenceManager credentialsPersistenceManager = new CredentialsPersistenceManager(credentialsFile);
      HashMap decryptedProperties = new HashMap<String, String>();
      OrderedProperties credentials = credentialsPersistenceManager.readCredentials();
      for (String name : credentials.stringPropertyNames())
      {
         decryptedProperties.put(name, credentialsEncryptor.decrypt(credentials.getProperty(name)));
      }
      return decryptedProperties;
   }

   public static HashMap<String, String> loadEncryptedCredentials()
   {
      return loadEncryptedCredentials(Paths.get(System.getProperty("user.home"), ".gradle", "gradle.encrypted.properties"), DEFAULT_PASSPHRASE);
   }
}
