SUMMARY = "waysay"
HOMEPAGE = "https://github.com/JoshMcguigan/waysay"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit cargo_bin

# Enable network for the compile task allowing cargo to download dependencies
do_compile[network] = "1"

SRC_URI = "git://github.com/JoshMcguigan/waysay.git;protocol=https;branch=master"
SRCREV="7d2744d8de03d5a261ea4905efe67584ec8f07d3"

S = "${WORKDIR}/git"


