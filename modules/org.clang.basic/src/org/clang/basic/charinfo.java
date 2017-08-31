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
package org.clang.basic;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;


//<editor-fold defaultstate="collapsed" desc="static type charinfo">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clang8charinfo9InfoTableE;_ZN5clang8charinfoE_CharInfo_h_Unnamed_enum;_ZN5clang8charinfoE_CharInfo_h_Unnamed_enum1; -static-type=charinfo -package=org.clang.basic ")
//</editor-fold>
public final class charinfo {

//<editor-fold defaultstate="collapsed" desc="clang::charinfo::(anonymous)">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 22,
 FQN="clang::charinfo::(anonymous)", NM="_ZN5clang8charinfoE_CharInfo_h_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clang8charinfoE_CharInfo_h_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int CHAR_HORZ_WS = 0x0001; // '\t', '\f', '\v'.  Note, no '\0'
  public static final /*uint*/int CHAR_VERT_WS = 0x0002; // '\r', '\n'
  public static final /*uint*/int CHAR_SPACE = 0x0004; // ' '
  public static final /*uint*/int CHAR_DIGIT = 0x0008; // 0-9
  public static final /*uint*/int CHAR_XLETTER = 0x0010; // a-f,A-F
  public static final /*uint*/int CHAR_UPPER = 0x0020; // A-Z
  public static final /*uint*/int CHAR_LOWER = 0x0040; // a-z
  public static final /*uint*/int CHAR_UNDER = 0x0080; // _
  public static final /*uint*/int CHAR_PERIOD = 0x0100; // .
  public static final /*uint*/int CHAR_RAWDEL = 0x0200; // {}[]#<>%:;?*+-/^&|~!=,"'
  public static final /*uint*/int CHAR_PUNCT = 0x0400; // `$@()
/*}*/
//<editor-fold defaultstate="collapsed" desc="clang::charinfo::(anonymous)">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 36,
 FQN="clang::charinfo::(anonymous)", NM="_ZN5clang8charinfoE_CharInfo_h_Unnamed_enum1",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clang8charinfoE_CharInfo_h_Unnamed_enum1")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int CHAR_XUPPER = CHAR_XLETTER | CHAR_UPPER;
  public static final /*uint*/int CHAR_XLOWER = CHAR_XLETTER | CHAR_LOWER;
/*}*/

// Statically initialize CharInfo table based on ASCII character set
// Reference: FreeBSD 7.2 /usr/share/misc/ascii
//<editor-fold defaultstate="collapsed" desc="clang::charinfo::InfoTable">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp", line = 16,
 FQN="clang::charinfo::InfoTable", NM="_ZN5clang8charinfo9InfoTableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clang8charinfo9InfoTableE")
//</editor-fold>
// JAVA: initialize 256 elements and init the first 128 of them
public static final/*const*/char/*uint16_t*/ InfoTable[/*256*/] = new$ushort(256);
private final static/*const*/char/*uint16_t*/ InfoTable_[/*256*/] = new /*const*/char/*uint16_t*/ [/*256*/] {
  // 0 NUL         1 SOH         2 STX         3 ETX
  // 4 EOT         5 ENQ         6 ACK         7 BEL
  0, 0, 0, 0, 
  0, 0, 0, 0, 
  // 8 BS          9 HT         10 NL         11 VT
  //12 NP         13 CR         14 SO         15 SI
  0, $uint2ushort(CHAR_HORZ_WS), $uint2ushort(CHAR_VERT_WS), $uint2ushort(CHAR_HORZ_WS), 
  $uint2ushort(CHAR_HORZ_WS), $uint2ushort(CHAR_VERT_WS), 0, 0, 
  //16 DLE        17 DC1        18 DC2        19 DC3
  //20 DC4        21 NAK        22 SYN        23 ETB
  0, 0, 0, 0, 
  0, 0, 0, 0, 
  //24 CAN        25 EM         26 SUB        27 ESC
  //28 FS         29 GS         30 RS         31 US
  0, 0, 0, 0, 
  0, 0, 0, 0, 
  //32 SP         33  !         34  "         35  #
  //36  $         37  %         38  &         39  '
  $uint2ushort(CHAR_SPACE), $uint2ushort(CHAR_RAWDEL), $uint2ushort(CHAR_RAWDEL), $uint2ushort(CHAR_RAWDEL), 
  $uint2ushort(CHAR_PUNCT), $uint2ushort(CHAR_RAWDEL), $uint2ushort(CHAR_RAWDEL), $uint2ushort(CHAR_RAWDEL), 
  //40  (         41  )         42  *         43  +
  //44  ,         45  -         46  .         47  /
  $uint2ushort(CHAR_PUNCT), $uint2ushort(CHAR_PUNCT), $uint2ushort(CHAR_RAWDEL), $uint2ushort(CHAR_RAWDEL), 
  $uint2ushort(CHAR_RAWDEL), $uint2ushort(CHAR_RAWDEL), $uint2ushort(CHAR_PERIOD), $uint2ushort(CHAR_RAWDEL), 
  //48  0         49  1         50  2         51  3
  //52  4         53  5         54  6         55  7
  $uint2ushort(CHAR_DIGIT), $uint2ushort(CHAR_DIGIT), $uint2ushort(CHAR_DIGIT), $uint2ushort(CHAR_DIGIT), 
  $uint2ushort(CHAR_DIGIT), $uint2ushort(CHAR_DIGIT), $uint2ushort(CHAR_DIGIT), $uint2ushort(CHAR_DIGIT), 
  //56  8         57  9         58  :         59  ;
  //60  <         61  =         62  >         63  ?
  $uint2ushort(CHAR_DIGIT), $uint2ushort(CHAR_DIGIT), $uint2ushort(CHAR_RAWDEL), $uint2ushort(CHAR_RAWDEL), 
  $uint2ushort(CHAR_RAWDEL), $uint2ushort(CHAR_RAWDEL), $uint2ushort(CHAR_RAWDEL), $uint2ushort(CHAR_RAWDEL), 
  //64  @         65  A         66  B         67  C
  //68  D         69  E         70  F         71  G
  $uint2ushort(CHAR_PUNCT), $uint2ushort(CHAR_XUPPER), $uint2ushort(CHAR_XUPPER), $uint2ushort(CHAR_XUPPER), 
  $uint2ushort(CHAR_XUPPER), $uint2ushort(CHAR_XUPPER), $uint2ushort(CHAR_XUPPER), $uint2ushort(CHAR_UPPER), 
  //72  H         73  I         74  J         75  K
  //76  L         77  M         78  N         79  O
  $uint2ushort(CHAR_UPPER), $uint2ushort(CHAR_UPPER), $uint2ushort(CHAR_UPPER), $uint2ushort(CHAR_UPPER), 
  $uint2ushort(CHAR_UPPER), $uint2ushort(CHAR_UPPER), $uint2ushort(CHAR_UPPER), $uint2ushort(CHAR_UPPER), 
  //80  P         81  Q         82  R         83  S
  //84  T         85  U         86  V         87  W
  $uint2ushort(CHAR_UPPER), $uint2ushort(CHAR_UPPER), $uint2ushort(CHAR_UPPER), $uint2ushort(CHAR_UPPER), 
  $uint2ushort(CHAR_UPPER), $uint2ushort(CHAR_UPPER), $uint2ushort(CHAR_UPPER), $uint2ushort(CHAR_UPPER), 
  //88  X         89  Y         90  Z         91  [
  //92  \         93  ]         94  ^         95  _
  $uint2ushort(CHAR_UPPER), $uint2ushort(CHAR_UPPER), $uint2ushort(CHAR_UPPER), $uint2ushort(CHAR_RAWDEL), 
  $uint2ushort(CHAR_PUNCT), $uint2ushort(CHAR_RAWDEL), $uint2ushort(CHAR_RAWDEL), $uint2ushort(CHAR_UNDER), 
  //96  `         97  a         98  b         99  c
  //100  d       101  e        102  f        103  g
  $uint2ushort(CHAR_PUNCT), $uint2ushort(CHAR_XLOWER), $uint2ushort(CHAR_XLOWER), $uint2ushort(CHAR_XLOWER), 
  $uint2ushort(CHAR_XLOWER), $uint2ushort(CHAR_XLOWER), $uint2ushort(CHAR_XLOWER), $uint2ushort(CHAR_LOWER), 
  //104  h       105  i        106  j        107  k
  //108  l       109  m        110  n        111  o
  $uint2ushort(CHAR_LOWER), $uint2ushort(CHAR_LOWER), $uint2ushort(CHAR_LOWER), $uint2ushort(CHAR_LOWER), 
  $uint2ushort(CHAR_LOWER), $uint2ushort(CHAR_LOWER), $uint2ushort(CHAR_LOWER), $uint2ushort(CHAR_LOWER), 
  //112  p       113  q        114  r        115  s
  //116  t       117  u        118  v        119  w
  $uint2ushort(CHAR_LOWER), $uint2ushort(CHAR_LOWER), $uint2ushort(CHAR_LOWER), $uint2ushort(CHAR_LOWER), 
  $uint2ushort(CHAR_LOWER), $uint2ushort(CHAR_LOWER), $uint2ushort(CHAR_LOWER), $uint2ushort(CHAR_LOWER), 
  //120  x       121  y        122  z        123  {
  //124  |       125  }        126  ~        127 DEL
  $uint2ushort(CHAR_LOWER), $uint2ushort(CHAR_LOWER), $uint2ushort(CHAR_LOWER), $uint2ushort(CHAR_RAWDEL), 
  $uint2ushort(CHAR_RAWDEL), $uint2ushort(CHAR_RAWDEL), $uint2ushort(CHAR_RAWDEL), 0
};
static {
  copy$Object(InfoTable_, 0, InfoTable, 0, InfoTable_.length);
}
} // END OF class charinfo
