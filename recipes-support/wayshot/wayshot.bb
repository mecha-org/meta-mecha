SUMMARY = "wayshot"
HOMEPAGE = "https://github.com/waycrate/wayshot"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit cargo_bin

# Enable network for the compile task allowing cargo to download dependencies
do_compile[network] = "1"

SRC_URI = "git://github.com/waycrate/wayshot.git;protocol=https;branch=main"
SRCREV="edd1f14923cbe3da1d0a7c93d354d73c5004e06b"

S = "${WORKDIR}/git"

#RDEPENDS:${PN} = "glib-2.0"

#DEPENDS:append = " cairo pango gdk-pixbuf atk gtk+3 gtk-layer-shell"
