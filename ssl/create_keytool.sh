keytool -genkey -keysize 2048 -keyalg RSA -alias tdpsynopsis -keystore tdpsynopsis.jks -dname "CN=tdpsynopsis.onmicrosoft.com, O=Synopsis, L=Lima, ST=Lima, C=PE"
keytool -certreq -alias tdpsynopsis -file tdpsynopsis.csr -keystore tdpsynopsis.jks
keytool -genkeypair -alias tdpsynopsis -keyalg RSA -storetype PKCS12 -keystore tdpsynopsis.p12
keytool -keystore tdpsynopsis.p12 -storetype pkcs12 -exportcert -file tdpsynopsis.crt -rfc -alias tdpsynopsis
pwd S1n0ps1s2021$$