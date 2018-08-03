# Encrypted Properties

[ ![Download](https://api.bintray.com/packages/ihmcrobotics/maven-release/encrypted-properties/images/download.svg) ](https://bintray.com/ihmcrobotics/maven-release/encrypted-properties/_latestVersion)

Load and store encrypted values from .properties files from Java.

To use, add the following to your `build.gradle`:
```groovy
compile group: "us.ihmc", name: "encrypted-properties", version: "0.1.0"
```

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

#### Install on Linux CLI

```bash
$ curl -skL https://github.com/ihmcrobotics/encrypted-properties/releases/download/0.1.0/encrypted-properties-0.1.0.zip -o encrypted-properties.zip
$ unzip encrypted-properties.zip
$ rm -r encrypted-properties.zip
```
