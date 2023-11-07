
SUMMARY = "gtk4-layer-shell"
HOMEPAGE = "https://github.com/wmww/gtk4-layer-shell"
BUGTRACKER = "https://github.com/wmww/gtk4-layer-shell/issues"
SECTION = "graphics"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


REQUIRED_DISTRO_FEATURES = "wayland"

DEPENDS += " \
	wlroots \
	cairo \
	libevdev \
	json-c \
	libdrm \
	libinput \
	libxkbcommon \
	pango \
	pcre \
	pixman \
	virtual/libgles2 \
	wayland \
	wayland-native \
	wayland-protocols \
	libpcre2 \
	xcb-util-wm \
	xcb-util \
	libxcb \
    gtk4 \
    gobject-introspection \
"
# sways default config makes use of it
RDEPENDS:${PN} ?= "swaybg python3 python-i3ipc pkgconfig"

# sudo apt install libwayland-dev libgtk-4-dev gobject-introspection libgirepository1.0-dev gtk-doc-tools python3 valac

# RRECOMMENDS:${PN} ?= " 
# 	jq 
# 	grim 
# 	slurp 
# 	wl-clipboard \
# "

SRC_URI = " \
	git://github.com/wmww/gtk4-layer-shell.git;protocol=https;branch=main \
"

# git@github.com:WillPower3309/swayfx.git

SRCREV = "98c693d0a7ea74620e3cec1115bbc66d33d8b843"
PV = "1.0.1"
S = "${WORKDIR}/git"

inherit meson pkgconfig features_check vala gobject-introspection

# PACKAGECONFIG[basu] = "-Dsd-bus-provider=basu,,basu"
# PACKAGECONFIG[default-wallpaper] = "-Ddefault-wallpaper=true,-Ddefault-wallpaper=false"
# PACKAGECONFIG[elogind] = "-Dsd-bus-provider=libelogind,,elogind"
# PACKAGECONFIG[gdk-pixbuf] = "-Dgdk-pixbuf=enabled,-Dgdk-pixbuf=disabled,gdk-pixbuf"
# PACKAGECONFIG[swaybar] = "-Dswaybar=true,-Dswaybar=false"
# PACKAGECONFIG[swaynag] = "-Dswaynag=true,-Dswaynag=false"
# PACKAGECONFIG[systemd] = "-Dsd-bus-provider=libsystemd,,systemd"
# PACKAGECONFIG[tray] = "-Dtray=enabled,-Dtray=disabled"
# PACKAGECONFIG[xwayland] = "-Dxwayland=enabled,-Dxwayland=disabled,libxcb"

# PACKAGECONFIG ?= " 
# 	${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)} 
# 	default-wallpaper 
# 	gdk-pixbuf 
# 	xwayland 
# "

# Reproducibility issue. Fix me!
CFLAGS:append = " -Wno-error=date-time"
EXTRA_OEMESON += "--buildtype release"

# do_install:append() {
# 	install -m 755 ${S}/contrib/grimshot ${D}${bindir}
# 	install -m 755 ${S}/contrib/autoname-workspaces.py ${D}${bindir}
# 	install -m 755 ${S}/contrib/inactive-windows-transparency.py ${D}${bindir}
# }

FILES:${PN}:append = " \
	${datadir} \
"

BBCLASSEXTEND = ""

