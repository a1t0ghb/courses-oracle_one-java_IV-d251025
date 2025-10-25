#!/usr/bin/env bash

#  Update distro.: 'https://askubuntu.com/questions/94102/what-is-the-difference-between-apt-get-update-and-upgrade/94104#94104', 'https://askubuntu.com/questions/94102/what-is-the-difference-between-apt-get-update-and-upgrade/1471053#1471053'.
echo -e "\n-----\n[LOG] Updating distro."
sudo apt update && sudo apt --yes upgrade && sudo apt autoremove

#  Install Java SDK 17.
echo -e "\n-----\n[LOG] Installing Java SDK 17."
sudo apt --yes install openjdk-17-jdk

#  [OPTIONAL] Define java environment setup.

# #  1. [MANUAL] Validation of java installation directory; usually '/usr/lib/jvm/<version>'.
# sudo update-alternatives --config java      #  In this case '/usr/lib/jvm/java-17-openjdk-amd64/bin/java'.

#  2. Set ENVIRONMENT variable 'JAVA_HOME'. Act as a POITNER for any IDE or development tool to find JDK tools apps: 'java' (for running Java), 'javac' (for compiling Java), and 'jar' (for packaging Java jar files).
#  - JAVA_HOME vs. PATH     : 'https://tomgregory.com/gradle/java-home-vs-path-environment-variables/'.
#  - Format example         : 'https://www.r-bloggers.com/2024/11/linux-environment-variables-a-beginners-guide-to-printenv-set-export-and-alias/'.
echo -e "\n-----\n[LOG] Setting environment variables: 'JAVA_HOME', and 'PATH'."
# #  NOTE: definition of ENVIRONMENT VARIABLES using devcontainers is done in the 'devcontainer.json' file. Ref.: 'https://github.com/devcontainers/spec/issues/233#issuecomment-1530069229'.
# export JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"
# export PATH="$PATH:$JAVA_HOME/bin"
echo "JAVA_HOME: $JAVA_HOME"
echo "PATH: $PATH"

# #  3. [OPTIONAL | MANUAL] Validation of ENVIRONMENT variable creation: 'https://www.r-bloggers.com/2024/11/linux-environment-variables-a-beginners-guide-to-printenv-set-export-and-alias/'.
# printenv | more
# printenv JAVA_HOME          #  If doesn't find a match, it throws ERROR.
# printenv | grep "java"      #  IMPORTANT: it's CASE SENSITIVE!.

#  Validate installation.
echo -e "\n-----\n[LOG] Validating java installation."
java --version
javac --version
# EOF.