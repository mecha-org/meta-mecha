SUMMARY = "swww"
HOMEPAGE = "https://github.com/Horus645/swww"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit cargo_bin

# Enable network for the compile task allowing cargo to download dependencies
do_compile[network] = "1"

SRC_URI = "git://github.com/Horus645/swww.git;protocol=https;branch=main"
SRCREV="0908f36050d545a0eb97ca0cbfc40c47fc50d6ba"

S = "${WORKDIR}/git"

