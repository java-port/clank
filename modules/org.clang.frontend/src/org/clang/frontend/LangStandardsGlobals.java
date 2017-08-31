/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */
package org.clang.frontend;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.clang.frontend.*;
import org.clang.frontend.frontend.LangFeatures;


//<editor-fold defaultstate="collapsed" desc="static type LangStandardsGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL10Lang_cxx03;_ZL10Lang_cxx0x;_ZL10Lang_cxx11;_ZL10Lang_cxx14;_ZL10Lang_cxx1y;_ZL10Lang_cxx1z;_ZL10Lang_cxx98;_ZL10Lang_gnu11;_ZL10Lang_gnu1x;_ZL10Lang_gnu89;_ZL10Lang_gnu90;_ZL10Lang_gnu99;_ZL10Lang_gnu9x;_ZL11Lang_opencl;_ZL13Lang_gnucxx0x;_ZL13Lang_gnucxx11;_ZL13Lang_gnucxx14;_ZL13Lang_gnucxx1y;_ZL13Lang_gnucxx1z;_ZL13Lang_gnucxx98;_ZL13Lang_opencl11;_ZL13Lang_opencl12;_ZL13Lang_opencl20;_ZL17Lang_iso9899_1990;_ZL17Lang_iso9899_1999;_ZL17Lang_iso9899_199x;_ZL17Lang_iso9899_2011;_ZL17Lang_iso9899_201x;_ZL8Lang_c11;_ZL8Lang_c1x;_ZL8Lang_c89;_ZL8Lang_c90;_ZL8Lang_c94;_ZL8Lang_c99;_ZL8Lang_c9x;_ZL9Lang_cuda; -static-type=LangStandardsGlobals -package=org.clang.frontend")
//</editor-fold>
public final class LangStandardsGlobals {


// C89-ish modes.
//<editor-fold defaultstate="collapsed" desc="Lang_c89">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 31,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 23,
 FQN="Lang_c89", NM="_ZL8Lang_c89",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL8Lang_c89")
//</editor-fold>
public static /*const*/ LangStandard Lang_c89 = new LangStandard($("c89"), $("ISO C 1990"), LangFeatures.C89 | LangFeatures.ImplicitInt);
//<editor-fold defaultstate="collapsed" desc="Lang_c90">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 34,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 26,
 FQN="Lang_c90", NM="_ZL8Lang_c90",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL8Lang_c90")
//</editor-fold>
public static /*const*/ LangStandard Lang_c90 = new LangStandard($("c90"), $("ISO C 1990"), LangFeatures.C89 | LangFeatures.ImplicitInt);
//<editor-fold defaultstate="collapsed" desc="Lang_iso9899_1990">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 37,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 29,
 FQN="Lang_iso9899_1990", NM="_ZL17Lang_iso9899_1990",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL17Lang_iso9899_1990")
//</editor-fold>
public static /*const*/ LangStandard Lang_iso9899_1990 = new LangStandard($("iso9899:1990"), $("ISO C 1990"), LangFeatures.C89 | LangFeatures.ImplicitInt);
//<editor-fold defaultstate="collapsed" desc="Lang_c94">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 41,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 33,
 FQN="Lang_c94", NM="_ZL8Lang_c94",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL8Lang_c94")
//</editor-fold>
public static /*const*/ LangStandard Lang_c94 = new LangStandard($("iso9899:199409"), $("ISO C 1990 with amendment 1"), LangFeatures.C89 | LangFeatures.Digraphs | LangFeatures.ImplicitInt);
//<editor-fold defaultstate="collapsed" desc="Lang_gnu89">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 45,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 37,
 FQN="Lang_gnu89", NM="_ZL10Lang_gnu89",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL10Lang_gnu89")
//</editor-fold>
public static /*const*/ LangStandard Lang_gnu89 = new LangStandard($("gnu89"), $("ISO C 1990 with GNU extensions"), LangFeatures.LineComment | LangFeatures.C89 | LangFeatures.Digraphs | LangFeatures.GNUMode | LangFeatures.ImplicitInt);
//<editor-fold defaultstate="collapsed" desc="Lang_gnu90">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 48,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 40,
 FQN="Lang_gnu90", NM="_ZL10Lang_gnu90",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL10Lang_gnu90")
//</editor-fold>
public static /*const*/ LangStandard Lang_gnu90 = new LangStandard($("gnu90"), $("ISO C 1990 with GNU extensions"), LangFeatures.LineComment | LangFeatures.C89 | LangFeatures.Digraphs | LangFeatures.GNUMode | LangFeatures.ImplicitInt);

// C99-ish modes
//<editor-fold defaultstate="collapsed" desc="Lang_c99">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 53,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 45,
 FQN="Lang_c99", NM="_ZL8Lang_c99",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL8Lang_c99")
//</editor-fold>
public static /*const*/ LangStandard Lang_c99 = new LangStandard($("c99"), $("ISO C 1999"), LangFeatures.LineComment | LangFeatures.C99 | LangFeatures.Digraphs | LangFeatures.HexFloat);
//<editor-fold defaultstate="collapsed" desc="Lang_c9x">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 56,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 48,
 FQN="Lang_c9x", NM="_ZL8Lang_c9x",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL8Lang_c9x")
//</editor-fold>
public static /*const*/ LangStandard Lang_c9x = new LangStandard($("c9x"), $("ISO C 1999"), LangFeatures.LineComment | LangFeatures.C99 | LangFeatures.Digraphs | LangFeatures.HexFloat);
//<editor-fold defaultstate="collapsed" desc="Lang_iso9899_1999">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 59,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 51,
 FQN="Lang_iso9899_1999", NM="_ZL17Lang_iso9899_1999",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL17Lang_iso9899_1999")
//</editor-fold>
public static /*const*/ LangStandard Lang_iso9899_1999 = new LangStandard($("iso9899:1999"), $("ISO C 1999"), LangFeatures.LineComment | LangFeatures.C99 | LangFeatures.Digraphs | LangFeatures.HexFloat);
//<editor-fold defaultstate="collapsed" desc="Lang_iso9899_199x">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 62,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 54,
 FQN="Lang_iso9899_199x", NM="_ZL17Lang_iso9899_199x",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL17Lang_iso9899_199x")
//</editor-fold>
public static /*const*/ LangStandard Lang_iso9899_199x = new LangStandard($("iso9899:199x"), $("ISO C 1999"), LangFeatures.LineComment | LangFeatures.C99 | LangFeatures.Digraphs | LangFeatures.HexFloat);
//<editor-fold defaultstate="collapsed" desc="Lang_gnu99">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 66,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 58,
 FQN="Lang_gnu99", NM="_ZL10Lang_gnu99",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL10Lang_gnu99")
//</editor-fold>
public static /*const*/ LangStandard Lang_gnu99 = new LangStandard($("gnu99"), $("ISO C 1999 with GNU extensions"), LangFeatures.LineComment | LangFeatures.C99 | LangFeatures.Digraphs | LangFeatures.GNUMode | LangFeatures.HexFloat);
//<editor-fold defaultstate="collapsed" desc="Lang_gnu9x">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 69,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 61,
 FQN="Lang_gnu9x", NM="_ZL10Lang_gnu9x",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL10Lang_gnu9x")
//</editor-fold>
public static /*const*/ LangStandard Lang_gnu9x = new LangStandard($("gnu9x"), $("ISO C 1999 with GNU extensions"), LangFeatures.LineComment | LangFeatures.C99 | LangFeatures.Digraphs | LangFeatures.GNUMode | LangFeatures.HexFloat);

// C11 modes
//<editor-fold defaultstate="collapsed" desc="Lang_c11">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 74,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 66,
 FQN="Lang_c11", NM="_ZL8Lang_c11",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL8Lang_c11")
//</editor-fold>
public static /*const*/ LangStandard Lang_c11 = new LangStandard($("c11"), $("ISO C 2011"), LangFeatures.LineComment | LangFeatures.C99 | LangFeatures.C11 | LangFeatures.Digraphs | LangFeatures.HexFloat);
//<editor-fold defaultstate="collapsed" desc="Lang_c1x">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 77,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 69,
 FQN="Lang_c1x", NM="_ZL8Lang_c1x",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL8Lang_c1x")
//</editor-fold>
public static /*const*/ LangStandard Lang_c1x = new LangStandard($("c1x"), $("ISO C 2011"), LangFeatures.LineComment | LangFeatures.C99 | LangFeatures.C11 | LangFeatures.Digraphs | LangFeatures.HexFloat);
//<editor-fold defaultstate="collapsed" desc="Lang_iso9899_2011">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 80,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 72,
 FQN="Lang_iso9899_2011", NM="_ZL17Lang_iso9899_2011",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL17Lang_iso9899_2011")
//</editor-fold>
public static /*const*/ LangStandard Lang_iso9899_2011 = new LangStandard($("iso9899:2011"), $("ISO C 2011"), LangFeatures.LineComment | LangFeatures.C99 | LangFeatures.C11 | LangFeatures.Digraphs | LangFeatures.HexFloat);
//<editor-fold defaultstate="collapsed" desc="Lang_iso9899_201x">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 83,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 75,
 FQN="Lang_iso9899_201x", NM="_ZL17Lang_iso9899_201x",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL17Lang_iso9899_201x")
//</editor-fold>
public static /*const*/ LangStandard Lang_iso9899_201x = new LangStandard($("iso9899:2011"), $("ISO C 2011"), LangFeatures.LineComment | LangFeatures.C99 | LangFeatures.C11 | LangFeatures.Digraphs | LangFeatures.HexFloat);
//<editor-fold defaultstate="collapsed" desc="Lang_gnu11">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 87,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 79,
 FQN="Lang_gnu11", NM="_ZL10Lang_gnu11",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL10Lang_gnu11")
//</editor-fold>
public static /*const*/ LangStandard Lang_gnu11 = new LangStandard($("gnu11"), $("ISO C 2011 with GNU extensions"), LangFeatures.LineComment | LangFeatures.C99 | LangFeatures.C11 | LangFeatures.Digraphs | LangFeatures.GNUMode | LangFeatures.HexFloat);
//<editor-fold defaultstate="collapsed" desc="Lang_gnu1x">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 90,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 82,
 FQN="Lang_gnu1x", NM="_ZL10Lang_gnu1x",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL10Lang_gnu1x")
//</editor-fold>
public static /*const*/ LangStandard Lang_gnu1x = new LangStandard($("gnu1x"), $("ISO C 2011 with GNU extensions"), LangFeatures.LineComment | LangFeatures.C99 | LangFeatures.C11 | LangFeatures.Digraphs | LangFeatures.GNUMode | LangFeatures.HexFloat);

// C++ modes
//<editor-fold defaultstate="collapsed" desc="Lang_cxx98">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 95,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 87,
 FQN="Lang_cxx98", NM="_ZL10Lang_cxx98",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL10Lang_cxx98")
//</editor-fold>
public static /*const*/ LangStandard Lang_cxx98 = new LangStandard($("c++98"), $("ISO C++ 1998 with amendments"), LangFeatures.LineComment | LangFeatures.CPlusPlus | LangFeatures.Digraphs);
//<editor-fold defaultstate="collapsed" desc="Lang_cxx03">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 98,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 90,
 FQN="Lang_cxx03", NM="_ZL10Lang_cxx03",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL10Lang_cxx03")
//</editor-fold>
public static /*const*/ LangStandard Lang_cxx03 = new LangStandard($("c++03"), $("ISO C++ 1998 with amendments"), LangFeatures.LineComment | LangFeatures.CPlusPlus | LangFeatures.Digraphs);
//<editor-fold defaultstate="collapsed" desc="Lang_gnucxx98">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 101,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 93,
 FQN="Lang_gnucxx98", NM="_ZL13Lang_gnucxx98",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL13Lang_gnucxx98")
//</editor-fold>
public static /*const*/ LangStandard Lang_gnucxx98 = new LangStandard($("gnu++98"), $("ISO C++ 1998 with amendments and GNU extensions"), LangFeatures.LineComment | LangFeatures.CPlusPlus | LangFeatures.Digraphs | LangFeatures.GNUMode);
//<editor-fold defaultstate="collapsed" desc="Lang_cxx0x">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 105,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 97,
 FQN="Lang_cxx0x", NM="_ZL10Lang_cxx0x",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL10Lang_cxx0x")
//</editor-fold>
public static /*const*/ LangStandard Lang_cxx0x = new LangStandard($("c++0x"), $("ISO C++ 2011 with amendments"), LangFeatures.LineComment | LangFeatures.CPlusPlus | LangFeatures.CPlusPlus11 | LangFeatures.Digraphs);
//<editor-fold defaultstate="collapsed" desc="Lang_cxx11">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 108,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 100,
 FQN="Lang_cxx11", NM="_ZL10Lang_cxx11",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL10Lang_cxx11")
//</editor-fold>
public static /*const*/ LangStandard Lang_cxx11 = new LangStandard($("c++11"), $("ISO C++ 2011 with amendments"), LangFeatures.LineComment | LangFeatures.CPlusPlus | LangFeatures.CPlusPlus11 | LangFeatures.Digraphs);
//<editor-fold defaultstate="collapsed" desc="Lang_gnucxx0x">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 111,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 103,
 FQN="Lang_gnucxx0x", NM="_ZL13Lang_gnucxx0x",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL13Lang_gnucxx0x")
//</editor-fold>
public static /*const*/ LangStandard Lang_gnucxx0x = new LangStandard($("gnu++0x"), $("ISO C++ 2011 with amendments and GNU extensions"), LangFeatures.LineComment | LangFeatures.CPlusPlus | LangFeatures.CPlusPlus11 | LangFeatures.Digraphs | LangFeatures.GNUMode);
//<editor-fold defaultstate="collapsed" desc="Lang_gnucxx11">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 114,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 106,
 FQN="Lang_gnucxx11", NM="_ZL13Lang_gnucxx11",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL13Lang_gnucxx11")
//</editor-fold>
public static /*const*/ LangStandard Lang_gnucxx11 = new LangStandard($("gnu++11"), $("ISO C++ 2011 with amendments and GNU extensions"), LangFeatures.LineComment | LangFeatures.CPlusPlus | LangFeatures.CPlusPlus11 | LangFeatures.Digraphs | LangFeatures.GNUMode);
//<editor-fold defaultstate="collapsed" desc="Lang_cxx1y">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 118,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 110,
 FQN="Lang_cxx1y", NM="_ZL10Lang_cxx1y",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL10Lang_cxx1y")
//</editor-fold>
public static /*const*/ LangStandard Lang_cxx1y = new LangStandard($("c++1y"), $("ISO C++ 2014 with amendments"), LangFeatures.LineComment | LangFeatures.CPlusPlus | LangFeatures.CPlusPlus11 | LangFeatures.CPlusPlus14 | LangFeatures.Digraphs);
//<editor-fold defaultstate="collapsed" desc="Lang_cxx14">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 121,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 113,
 FQN="Lang_cxx14", NM="_ZL10Lang_cxx14",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL10Lang_cxx14")
//</editor-fold>
public static /*const*/ LangStandard Lang_cxx14 = new LangStandard($("c++14"), $("ISO C++ 2014 with amendments"), LangFeatures.LineComment | LangFeatures.CPlusPlus | LangFeatures.CPlusPlus11 | LangFeatures.CPlusPlus14 | LangFeatures.Digraphs);
//<editor-fold defaultstate="collapsed" desc="Lang_gnucxx1y">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 124,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 116,
 FQN="Lang_gnucxx1y", NM="_ZL13Lang_gnucxx1y",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL13Lang_gnucxx1y")
//</editor-fold>
public static /*const*/ LangStandard Lang_gnucxx1y = new LangStandard($("gnu++1y"), $("ISO C++ 2014 with amendments and GNU extensions"), LangFeatures.LineComment | LangFeatures.CPlusPlus | LangFeatures.CPlusPlus11 | LangFeatures.CPlusPlus14 | LangFeatures.Digraphs | LangFeatures.GNUMode);
//<editor-fold defaultstate="collapsed" desc="Lang_gnucxx14">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 128,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 120,
 FQN="Lang_gnucxx14", NM="_ZL13Lang_gnucxx14",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL13Lang_gnucxx14")
//</editor-fold>
public static /*const*/ LangStandard Lang_gnucxx14 = new LangStandard($("gnu++14"), $("ISO C++ 2014 with amendments and GNU extensions"), LangFeatures.LineComment | LangFeatures.CPlusPlus | LangFeatures.CPlusPlus11 | LangFeatures.CPlusPlus14 | LangFeatures.Digraphs | LangFeatures.GNUMode);
//<editor-fold defaultstate="collapsed" desc="Lang_cxx1z">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 133,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 125,
 FQN="Lang_cxx1z", NM="_ZL10Lang_cxx1z",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL10Lang_cxx1z")
//</editor-fold>
public static /*const*/ LangStandard Lang_cxx1z = new LangStandard($("c++1z"), $("Working draft for ISO C++ 2017"), LangFeatures.LineComment | LangFeatures.CPlusPlus | LangFeatures.CPlusPlus11 | LangFeatures.CPlusPlus14 | LangFeatures.CPlusPlus1z | LangFeatures.Digraphs | LangFeatures.HexFloat);
//<editor-fold defaultstate="collapsed" desc="Lang_gnucxx1z">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 137,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 129,
 FQN="Lang_gnucxx1z", NM="_ZL13Lang_gnucxx1z",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL13Lang_gnucxx1z")
//</editor-fold>
public static /*const*/ LangStandard Lang_gnucxx1z = new LangStandard($("gnu++1z"), $("Working draft for ISO C++ 2017 with GNU extensions"), LangFeatures.LineComment | LangFeatures.CPlusPlus | LangFeatures.CPlusPlus11 | LangFeatures.CPlusPlus14 | LangFeatures.CPlusPlus1z | LangFeatures.Digraphs | LangFeatures.HexFloat | LangFeatures.GNUMode);

// OpenCL
//<editor-fold defaultstate="collapsed" desc="Lang_opencl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 143,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 135,
 FQN="Lang_opencl", NM="_ZL11Lang_opencl",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL11Lang_opencl")
//</editor-fold>
public static /*const*/ LangStandard Lang_opencl = new LangStandard($("cl"), $("OpenCL 1.0"), LangFeatures.LineComment | LangFeatures.C99 | LangFeatures.Digraphs | LangFeatures.HexFloat);
//<editor-fold defaultstate="collapsed" desc="Lang_opencl11">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 146,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 138,
 FQN="Lang_opencl11", NM="_ZL13Lang_opencl11",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL13Lang_opencl11")
//</editor-fold>
public static /*const*/ LangStandard Lang_opencl11 = new LangStandard($("cl1.1"), $("OpenCL 1.1"), LangFeatures.LineComment | LangFeatures.C99 | LangFeatures.Digraphs | LangFeatures.HexFloat);
//<editor-fold defaultstate="collapsed" desc="Lang_opencl12">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 149,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 141,
 FQN="Lang_opencl12", NM="_ZL13Lang_opencl12",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL13Lang_opencl12")
//</editor-fold>
public static /*const*/ LangStandard Lang_opencl12 = new LangStandard($("cl1.2"), $("OpenCL 1.2"), LangFeatures.LineComment | LangFeatures.C99 | LangFeatures.Digraphs | LangFeatures.HexFloat);
//<editor-fold defaultstate="collapsed" desc="Lang_opencl20">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 152,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 144,
 FQN="Lang_opencl20", NM="_ZL13Lang_opencl20",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL13Lang_opencl20")
//</editor-fold>
public static /*const*/ LangStandard Lang_opencl20 = new LangStandard($("cl2.0"), $("OpenCL 2.0"), LangFeatures.LineComment | LangFeatures.C99 | LangFeatures.Digraphs | LangFeatures.HexFloat);

// CUDA
//<editor-fold defaultstate="collapsed" desc="Lang_cuda">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", line = 162,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandards.def", old_line = 149,
 FQN="Lang_cuda", NM="_ZL9Lang_cuda",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZL9Lang_cuda")
//</editor-fold>
public static /*const*/ LangStandard Lang_cuda = new LangStandard($("cuda"), $("NVIDIA CUDA(tm)"), LangFeatures.LineComment | LangFeatures.CPlusPlus | LangFeatures.Digraphs);
} // END OF class LangStandardsGlobals
