# Encrypted Properties

Load and store encrypted values from .properties files from JVM.

### Loading properties

```java
// load from ~/.gradle/gradle.encrypted.properties w/ default passphrase
HashMap<String, String> stringStringHashMap = EncryptedPropertyManager.loadEncryptedCredentials();

for (String key: stringStringHashMap.keySet())
{
   System.out.println(key + " = " + stringStringHashMap.get(key));
}
```

### Storing properties

Download and install [encrypted-properties-0.1.0.zip](https://github.com/ihmcrobotics/encrypted-properties/releases/download/0.1.0/encrypted-properties-0.1.0.zip).

#### Linux

```bash
$ ./bin/encrypted-properties <key> <value>
```

#### Windows

```bash
$ bin/encrypted-properties.bat <key> <value>
```

