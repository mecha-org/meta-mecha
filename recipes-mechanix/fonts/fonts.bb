DESCRIPTION = "Mechanix fonts"
SUMMARY = "fonts and wallpapers"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


SRC_URI = "git://github.com/mecha-org/mechanix-assets.git;protocol=https;branch=main"
SRCREV="ffcba1b3b75f3a4f3571b6ba394698bf6ec160a3"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${datadir}/mechanix-shell/wallpapers
    install -m 0755 ${S}/wallpapers/*  ${D}${datadir}/mechanix-shell/wallpapers

    install -d ${D}${datadir}/fonts
    cp -r ${S}/fonts/*  ${D}${datadir}/fonts
}
 
FILES:${PN} += "${datadir}/*"

# ${datadir} = /usr/share