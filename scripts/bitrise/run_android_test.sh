#!/usr/bin/env bash
set -ex

mvn -DtestNGFile='config\testng_appium.xml' clean -f pom.xml
