#ifndef SVGC_HEADER_H
#define SVGC_HEADER_H

#include <stdint.h>

#define SVGC_MAGIC 0x53564743 // "SVGC" in Hex [cite: 2026-02-07]
#define SVGC_VERSION 100

typedef struct {
    uint32_t magic;
    uint16_t version;
    uint32_t path_count;
    uint16_t width;
    uint16_t height;
} SVGCHeader;

#endif
