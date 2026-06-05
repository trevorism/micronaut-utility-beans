# 2.0.0

Upgrade dependency on micronaut security utils to version 3.0.0.

## 1.8.1
Bumped security-utils dependency
Upgrade dependencies -- micronaut is now at version 5.

## 1.7.2
Update dependencies including java to version 21

## 1.6.0
Update micronaut-security-utils dependency to latest

## 1.5.0
Update dependencies, now using latest secure utils and micronaut security utils

## 1.4.0 
Removed correlation provider. Updated dependencies.

## 1.3.0
Fix a bug with the `PassThruSecureHttpClient` when the auth header was missing.
Added bean name `passThruSecureHttpClient` in case another implementation of `SecureHttpClient` exists.

## 1.2.0
Update to Micronaut 4.2.0.
Allow unauthenticated requests to pass through the authenticated filter without an exception being thrown.

## 1.1.0
Allow injecting authentication from cookies

## 1.0.0
Upgrade micronaut utility beans to be compatible with Micronaut 4

## 0.1.0
Initial release
