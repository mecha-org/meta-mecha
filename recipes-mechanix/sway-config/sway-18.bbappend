FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " file://config"

do_install:append() {
    install -d ${D}${sysconfdir}/sway
    install -c -m 0644 ${WORKDIR}/config ${D}${sysconfdir}/sway
}

FILES:${PN} += "/etc/*"