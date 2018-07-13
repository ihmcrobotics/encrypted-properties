package us.ihmc.encryptedProperties;

import java.util.HashMap;

public class PrintAllPropertiesDemo
{
   public static void main(String[] args)
   {
      HashMap<String, String> stringStringHashMap = EncryptedPropertyManager.loadEncryptedCredentials();

      for (String key: stringStringHashMap.keySet())
      {
         System.out.println(key + " = " + stringStringHashMap.get(key));
      }
   }
}
