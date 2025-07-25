SUMMARY = "A library on top of GStreamer for building an RTSP server"
HOMEPAGE = "http://cgit.freedesktop.org/gstreamer/gst-rtsp-server/"
SECTION = "multimedia"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=69333daa044cb77e486cc36129f7a770"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base"

PNREAL = "gst-rtsp-server"

SRC_URI = "https://gstreamer.freedesktop.org/src/${PNREAL}/${PNREAL}-${@get_gst_ver("${PV}")}.tar.xz"

SRC_URI[sha256sum] = "5b0fa6b12ba95b1d336a4b274cbe19e982aa3e6819f1d97bfd8e0102b103ed9b"

S = "${UNPACKDIR}/${PNREAL}-${@get_gst_ver("${PV}")}"

inherit meson pkgconfig upstream-version-is-even gobject-introspection

EXTRA_OEMESON += " \
    -Ddoc=disabled \
    -Dexamples=disabled \
    -Dtests=disabled \
"

GIR_MESON_ENABLE_FLAG = "enabled"
GIR_MESON_DISABLE_FLAG = "disabled"

# Drop .imx from PV
def get_gst_ver(v):
    return oe.utils.trim_version(v, 3)

# Starting with 1.8.0 gst-rtsp-server includes dependency-less plugins as well
require gstreamer1.0-plugins-packaging.inc

CVE_PRODUCT += "gst-rtsp-server"

COMPATIBLE_MACHINE = "(imx-nxp-bsp)"

