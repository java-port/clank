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
package org.llvm.ir.gen;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.ir.intrinsic.impl.IntrinsicsIntrinsicGlobals;


//<editor-fold defaultstate="collapsed" desc="static type IntrinsicsGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.gen.IntrinsicsGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZL11TargetInfos;_ZL21IIT_LongEncodingTable;_ZL9IIT_Table; -static-type=IntrinsicsGlobals -package=org.llvm.ir.gen")
//</editor-fold>
public final class IntrinsicsGlobals {

//<editor-fold defaultstate="collapsed" desc="TargetInfos">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/include/llvm/IR/Intrinsics.gen", line = 6110,
 FQN="TargetInfos", NM="_ZL11TargetInfos",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZL11TargetInfos")
//</editor-fold>
public static /*const*/ IntrinsicTargetInfo TargetInfos[/*14*/] = new /*const*/ IntrinsicTargetInfo [/*14*/] {
  new IntrinsicTargetInfo($EMPTY, 0, 124), 
  new IntrinsicTargetInfo($("aarch64"), 124, 190), 
  new IntrinsicTargetInfo($("amdgcn"), 314, 89), 
  new IntrinsicTargetInfo($("arm"), 403, 172), 
  new IntrinsicTargetInfo($("bpf"), 575, 4), 
  new IntrinsicTargetInfo($("hexagon"), 579, 1489), 
  new IntrinsicTargetInfo($("mips"), 2068, 667), 
  new IntrinsicTargetInfo($("nvvm"), 2735, 917), 
  new IntrinsicTargetInfo($("ppc"), 3652, 341), 
  new IntrinsicTargetInfo($("r600"), 3993, 21), 
  new IntrinsicTargetInfo($("s390"), 4014, 205), 
  new IntrinsicTargetInfo($("wasm"), 4219, 2), 
  new IntrinsicTargetInfo($("x86"), 4221, 1808), 
  new IntrinsicTargetInfo($("xcore"), 6029, 53)
};
//<editor-fold defaultstate="collapsed" desc="IIT_Table">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/build/include/llvm/IR/Intrinsics.gen", line = 12986,
 FQN="IIT_Table", NM="_ZL9IIT_Table",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZL9IIT_Table")
//</editor-fold>
  private static final int[] readIIT_Table(String resource, int length) throws URISyntaxException, IOException {
    InputStream is = IntrinsicsIntrinsicGlobals.class.getResourceAsStream(resource);
    int res[] = new int[length];
    for(int i = 0; i < length; i++) {
      int id = is.read()+ (is.read())<<8 + (is.read())<<16 + (is.read())<<24;
      res[i] = id;
    }
    is.close();
    return res;
  }
  public static /*const*//*uint*/int IIT_Table[/*6083*/];
  static {
    int res[] = new int[0];
    try {
      res = readIIT_Table("/org/llvm/ir/resources/IIT_Table", 6083);
    } catch (Exception ex) {
      Logger.getLogger(IntrinsicsIntrinsicGlobals.class.getName()).log(Level.SEVERE, null, ex);
    }
    IIT_Table = res;
  }
//<editor-fold defaultstate="collapsed" desc="IIT_LongEncodingTable">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/build/include/llvm/IR/Intrinsics.gen", line = 13750,
 FQN="IIT_LongEncodingTable", NM="_ZL21IIT_LongEncodingTable",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZL21IIT_LongEncodingTable")
//</editor-fold>
public static /*const*//*uchar*/byte IIT_LongEncodingTable[/*3769*/] = new /*const*//*uchar*/byte [/*3769*/] {
  /* 0 */ 0, 10, 7, 15, 1, 11, 4, 4, 1, 1, 1, 1, 0, 
  /* 13 */ 4, 4, 4, 15, 1, 11, 4, 1, 1, 1, 0, 
  /* 24 */ 0, 15, 2, 10, 4, 4, 4, 1, 1, 0, 
  /* 34 */ 21, 15, 2, 1, 15, 2, 15, 2, 1, 0, 
  /* 44 */ 15, 2, 15, 2, 15, 2, 15, 2, 1, 0, 
  /* 54 */ 0, 15, 3, 33, 3, 4, 31, 3, 1, 0, 
  /* 64 */ 0, 15, 3, 15, 12, 4, 31, 3, 1, 0, 
  /* 74 */ 0, 15, 4, 15, 12, 15, 17, 4, 1, 0, 
  /* 84 */ 21, 15, 1, 1, 15, 1, 15, 1, 0, 
  /* 93 */ 0, 19, 15, 1, 0, 
  /* 98 */ 15, 1, 25, 1, 0, 
  /* 103 */ 35, 1, 35, 1, 35, 1, 0, 
  /* 110 */ 36, 1, 36, 1, 36, 1, 0, 
  /* 117 */ 27, 2, 2, 0, 
  /* 121 */ 11, 3, 12, 2, 12, 2, 11, 3, 2, 0, 
  /* 131 */ 11, 3, 11, 3, 11, 3, 11, 3, 2, 0, 
  /* 141 */ 11, 3, 12, 2, 12, 2, 4, 11, 3, 2, 0, 
  /* 152 */ 11, 3, 10, 4, 10, 4, 11, 3, 2, 0, 
  /* 162 */ 12, 2, 12, 2, 4, 12, 2, 4, 2, 0, 
  /* 172 */ 10, 4, 10, 4, 10, 4, 10, 4, 4, 2, 0, 
  /* 183 */ 10, 7, 10, 7, 10, 7, 10, 4, 4, 2, 0, 
  /* 194 */ 11, 4, 11, 4, 11, 4, 11, 4, 4, 2, 0, 
  /* 205 */ 11, 7, 11, 7, 11, 7, 11, 4, 4, 2, 0, 
  /* 216 */ 9, 5, 9, 5, 9, 5, 9, 5, 4, 2, 0, 
  /* 227 */ 9, 8, 9, 8, 9, 8, 9, 5, 4, 2, 0, 
  /* 238 */ 10, 5, 10, 5, 10, 5, 10, 5, 4, 2, 0, 
  /* 249 */ 10, 8, 10, 8, 10, 8, 10, 5, 4, 2, 0, 
  /* 260 */ 11, 5, 11, 5, 11, 5, 11, 5, 4, 2, 0, 
  /* 271 */ 10, 4, 11, 3, 11, 3, 10, 4, 2, 0, 
  /* 281 */ 10, 4, 10, 4, 10, 4, 4, 10, 4, 2, 0, 
  /* 292 */ 10, 4, 10, 4, 14, 2, 10, 4, 10, 4, 2, 0, 
  /* 304 */ 10, 4, 10, 4, 10, 4, 10, 4, 2, 0, 
  /* 314 */ 10, 4, 10, 4, 14, 2, 9, 5, 10, 4, 2, 0, 
  /* 326 */ 10, 4, 10, 4, 14, 2, 10, 5, 10, 4, 2, 0, 
  /* 338 */ 10, 7, 10, 7, 10, 7, 10, 4, 2, 0, 
  /* 348 */ 11, 4, 12, 3, 12, 3, 11, 4, 2, 0, 
  /* 358 */ 11, 4, 11, 4, 10, 4, 4, 11, 4, 2, 0, 
  /* 369 */ 11, 4, 11, 4, 11, 4, 4, 11, 4, 2, 0, 
  /* 380 */ 11, 4, 11, 4, 10, 4, 11, 4, 2, 0, 
  /* 390 */ 11, 4, 11, 4, 14, 2, 11, 4, 11, 4, 2, 0, 
  /* 402 */ 11, 4, 11, 4, 11, 4, 11, 4, 2, 0, 
  /* 412 */ 11, 7, 11, 7, 11, 7, 11, 4, 2, 0, 
  /* 422 */ 9, 5, 9, 5, 9, 5, 4, 9, 5, 2, 0, 
  /* 433 */ 9, 5, 9, 5, 14, 2, 10, 4, 9, 5, 2, 0, 
  /* 445 */ 9, 5, 10, 4, 10, 4, 9, 5, 2, 0, 
  /* 455 */ 9, 5, 9, 5, 14, 2, 9, 5, 9, 5, 2, 0, 
  /* 467 */ 9, 5, 9, 5, 9, 5, 9, 5, 2, 0, 
  /* 477 */ 9, 8, 9, 8, 9, 8, 9, 5, 2, 0, 
  /* 487 */ 10, 5, 10, 5, 9, 5, 4, 10, 5, 2, 0, 
  /* 498 */ 10, 5, 10, 5, 10, 5, 4, 10, 5, 2, 0, 
  /* 509 */ 10, 5, 10, 5, 14, 2, 10, 4, 10, 5, 2, 0, 
  /* 521 */ 10, 5, 11, 4, 11, 4, 10, 5, 2, 0, 
  /* 531 */ 10, 5, 10, 5, 9, 5, 10, 5, 2, 0, 
  /* 541 */ 10, 5, 10, 5, 14, 2, 10, 5, 10, 5, 2, 0, 
  /* 553 */ 10, 5, 10, 5, 10, 5, 10, 5, 2, 0, 
  /* 563 */ 10, 8, 10, 8, 10, 8, 10, 5, 2, 0, 
  /* 573 */ 11, 5, 11, 5, 9, 5, 4, 11, 5, 2, 0, 
  /* 584 */ 11, 5, 11, 5, 10, 5, 4, 11, 5, 2, 0, 
  /* 595 */ 11, 5, 11, 5, 11, 5, 4, 11, 5, 2, 0, 
  /* 606 */ 11, 5, 12, 4, 12, 4, 11, 5, 2, 0, 
  /* 616 */ 11, 5, 11, 5, 9, 5, 11, 5, 2, 0, 
  /* 626 */ 11, 5, 11, 5, 11, 5, 11, 5, 2, 0, 
  /* 636 */ 10, 7, 10, 7, 10, 7, 4, 10, 7, 2, 0, 
  /* 647 */ 10, 7, 10, 7, 14, 2, 10, 4, 10, 7, 2, 0, 
  /* 659 */ 10, 7, 10, 7, 10, 4, 10, 7, 2, 0, 
  /* 669 */ 10, 7, 10, 7, 14, 2, 9, 5, 10, 7, 2, 0, 
  /* 681 */ 10, 7, 10, 7, 14, 2, 10, 5, 10, 7, 2, 0, 
  /* 693 */ 10, 7, 10, 4, 10, 7, 10, 7, 2, 0, 
  /* 703 */ 10, 7, 10, 7, 10, 7, 10, 7, 2, 0, 
  /* 713 */ 11, 7, 11, 7, 10, 7, 4, 11, 7, 2, 0, 
  /* 724 */ 11, 7, 11, 7, 11, 7, 4, 11, 7, 2, 0, 
  /* 735 */ 11, 7, 11, 7, 14, 2, 11, 4, 11, 7, 2, 0, 
  /* 747 */ 11, 7, 11, 7, 11, 4, 11, 7, 2, 0, 
  /* 757 */ 11, 7, 11, 4, 11, 7, 11, 7, 2, 0, 
  /* 767 */ 11, 7, 11, 7, 11, 7, 11, 7, 2, 0, 
  /* 777 */ 27, 7, 2, 0, 
  /* 781 */ 9, 8, 9, 8, 9, 8, 4, 9, 8, 2, 0, 
  /* 792 */ 9, 8, 9, 8, 14, 2, 10, 4, 9, 8, 2, 0, 
  /* 804 */ 9, 8, 9, 8, 14, 2, 9, 5, 9, 8, 2, 0, 
  /* 816 */ 9, 8, 9, 8, 9, 5, 9, 8, 2, 0, 
  /* 826 */ 9, 8, 9, 5, 9, 8, 9, 8, 2, 0, 
  /* 836 */ 9, 8, 9, 8, 9, 8, 9, 8, 2, 0, 
  /* 846 */ 10, 8, 10, 8, 9, 8, 4, 10, 8, 2, 0, 
  /* 857 */ 10, 8, 10, 8, 10, 8, 4, 10, 8, 2, 0, 
  /* 868 */ 10, 8, 10, 8, 14, 2, 10, 4, 10, 8, 2, 0, 
  /* 880 */ 10, 8, 10, 8, 14, 2, 10, 5, 10, 8, 2, 0, 
  /* 892 */ 10, 8, 10, 8, 10, 5, 10, 8, 2, 0, 
  /* 902 */ 10, 8, 10, 5, 10, 8, 10, 8, 2, 0, 
  /* 912 */ 10, 8, 10, 8, 10, 8, 10, 8, 2, 0, 
  /* 922 */ 11, 8, 11, 8, 9, 8, 4, 11, 8, 2, 0, 
  /* 933 */ 11, 8, 11, 8, 10, 8, 4, 11, 8, 2, 0, 
  /* 944 */ 11, 8, 11, 8, 11, 8, 4, 11, 8, 2, 0, 
  /* 955 */ 11, 8, 11, 8, 11, 5, 11, 8, 2, 0, 
  /* 965 */ 11, 8, 11, 5, 11, 8, 11, 8, 2, 0, 
  /* 975 */ 11, 8, 11, 8, 11, 8, 11, 8, 2, 0, 
  /* 985 */ 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 0, 
  /* 1000 */ 21, 12, 2, 4, 12, 2, 12, 2, 0, 
  /* 1009 */ 21, 12, 2, 4, 12, 2, 0, 
  /* 1016 */ 21, 4, 4, 14, 2, 0, 
  /* 1022 */ 21, 5, 5, 14, 2, 0, 
  /* 1028 */ 0, 14, 20, 5, 14, 2, 0, 
  /* 1035 */ 0, 17, 17, 14, 2, 0, 
  /* 1041 */ 11, 5, 16, 2, 16, 2, 0, 
  /* 1048 */ 5, 16, 2, 0, 
  /* 1052 */ 17, 17, 17, 2, 0, 
  /* 1057 */ 12, 2, 12, 2, 12, 2, 12, 2, 3, 0, 
  /* 1067 */ 12, 2, 11, 3, 11, 3, 12, 2, 3, 0, 
  /* 1077 */ 0, 5, 4, 4, 4, 3, 3, 3, 3, 0, 
  /* 1087 */ 12, 3, 13, 2, 13, 2, 12, 3, 3, 0, 
  /* 1097 */ 12, 3, 12, 3, 11, 3, 12, 3, 3, 0, 
  /* 1107 */ 12, 3, 12, 3, 12, 3, 12, 3, 3, 0, 
  /* 1117 */ 12, 3, 13, 2, 13, 2, 4, 12, 3, 3, 0, 
  /* 1128 */ 12, 3, 11, 4, 11, 4, 12, 3, 3, 0, 
  /* 1138 */ 12, 4, 12, 4, 12, 4, 12, 4, 4, 3, 0, 
  /* 1149 */ 12, 4, 13, 3, 13, 3, 12, 4, 3, 0, 
  /* 1159 */ 12, 4, 12, 4, 10, 4, 4, 12, 4, 3, 0, 
  /* 1170 */ 12, 4, 12, 4, 11, 4, 4, 12, 4, 3, 0, 
  /* 1181 */ 12, 4, 12, 4, 12, 4, 4, 12, 4, 3, 0, 
  /* 1192 */ 12, 4, 12, 4, 10, 4, 12, 4, 3, 0, 
  /* 1202 */ 12, 4, 12, 4, 12, 4, 12, 4, 3, 0, 
  /* 1212 */ 12, 7, 12, 7, 10, 7, 4, 12, 7, 3, 0, 
  /* 1223 */ 12, 7, 12, 7, 11, 7, 4, 12, 7, 3, 0, 
  /* 1234 */ 12, 7, 12, 7, 12, 7, 4, 12, 7, 3, 0, 
  /* 1245 */ 12, 7, 12, 7, 12, 4, 12, 7, 3, 0, 
  /* 1255 */ 12, 7, 12, 4, 12, 7, 12, 7, 3, 0, 
  /* 1265 */ 12, 7, 12, 7, 12, 7, 12, 7, 3, 0, 
  /* 1275 */ 21, 12, 2, 4, 11, 3, 11, 3, 0, 
  /* 1284 */ 21, 11, 3, 4, 11, 3, 11, 3, 0, 
  /* 1293 */ 21, 11, 3, 4, 11, 3, 0, 
  /* 1300 */ 15, 3, 33, 3, 4, 31, 3, 1, 15, 3, 0, 
  /* 1311 */ 15, 3, 15, 12, 4, 31, 3, 1, 15, 3, 0, 
  /* 1322 */ 15, 3, 15, 3, 12, 2, 12, 2, 12, 2, 12, 2, 15, 3, 0, 
  /* 1337 */ 15, 3, 15, 3, 12, 2, 12, 2, 12, 2, 15, 3, 0, 
  /* 1350 */ 15, 3, 15, 3, 12, 2, 12, 2, 15, 3, 0, 
  /* 1361 */ 15, 3, 25, 3, 0, 
  /* 1366 */ 15, 3, 25, 3, 25, 3, 0, 
  /* 1373 */ 15, 3, 26, 3, 0, 
  /* 1378 */ 15, 3, 26, 3, 26, 3, 0, 
  /* 1385 */ 15, 1, 25, 1, 4, 0, 
  /* 1391 */ 12, 4, 12, 4, 35, 1, 4, 0, 
  /* 1399 */ 13, 4, 13, 4, 36, 1, 4, 0, 
  /* 1407 */ 10, 7, 10, 7, 10, 7, 10, 4, 4, 2, 4, 0, 
  /* 1419 */ 9, 8, 9, 8, 9, 8, 9, 5, 4, 2, 4, 0, 
  /* 1431 */ 11, 8, 11, 8, 11, 8, 11, 5, 4, 2, 4, 0, 
  /* 1443 */ 10, 4, 10, 4, 14, 2, 10, 4, 2, 4, 0, 
  /* 1454 */ 10, 4, 9, 5, 14, 2, 10, 4, 2, 4, 0, 
  /* 1465 */ 11, 4, 10, 5, 14, 2, 10, 4, 2, 4, 0, 
  /* 1476 */ 10, 7, 10, 7, 14, 2, 10, 4, 2, 4, 0, 
  /* 1487 */ 9, 8, 9, 8, 14, 2, 10, 4, 2, 4, 0, 
  /* 1498 */ 10, 8, 10, 8, 14, 2, 10, 4, 2, 4, 0, 
  /* 1509 */ 11, 4, 11, 4, 14, 2, 11, 4, 2, 4, 0, 
  /* 1520 */ 11, 5, 11, 5, 14, 2, 11, 4, 2, 4, 0, 
  /* 1531 */ 11, 7, 11, 7, 14, 2, 11, 4, 2, 4, 0, 
  /* 1542 */ 11, 8, 11, 8, 14, 2, 11, 4, 2, 4, 0, 
  /* 1553 */ 10, 4, 10, 4, 14, 2, 9, 5, 2, 4, 0, 
  /* 1564 */ 10, 4, 9, 5, 14, 2, 9, 5, 2, 4, 0, 
  /* 1575 */ 10, 7, 10, 7, 14, 2, 9, 5, 2, 4, 0, 
  /* 1586 */ 9, 8, 9, 8, 14, 2, 9, 5, 2, 4, 0, 
  /* 1597 */ 10, 4, 10, 4, 14, 2, 10, 5, 2, 4, 0, 
  /* 1608 */ 11, 4, 10, 5, 14, 2, 10, 5, 2, 4, 0, 
  /* 1619 */ 10, 7, 10, 7, 14, 2, 10, 5, 2, 4, 0, 
  /* 1630 */ 10, 8, 10, 8, 14, 2, 10, 5, 2, 4, 0, 
  /* 1641 */ 11, 4, 11, 4, 14, 2, 11, 5, 2, 4, 0, 
  /* 1652 */ 11, 5, 11, 5, 14, 2, 11, 5, 2, 4, 0, 
  /* 1663 */ 11, 7, 11, 7, 14, 2, 11, 5, 2, 4, 0, 
  /* 1674 */ 11, 8, 11, 8, 14, 2, 11, 5, 2, 4, 0, 
  /* 1685 */ 10, 7, 10, 7, 10, 7, 4, 10, 7, 2, 4, 0, 
  /* 1697 */ 10, 7, 10, 7, 10, 7, 10, 7, 2, 4, 0, 
  /* 1708 */ 10, 7, 10, 7, 9, 8, 10, 7, 2, 4, 0, 
  /* 1719 */ 9, 8, 9, 8, 9, 8, 4, 9, 8, 2, 4, 0, 
  /* 1731 */ 9, 8, 9, 8, 10, 7, 9, 8, 2, 4, 0, 
  /* 1742 */ 9, 8, 9, 8, 9, 8, 9, 8, 2, 4, 0, 
  /* 1753 */ 11, 8, 11, 8, 11, 8, 4, 11, 8, 2, 4, 0, 
  /* 1765 */ 11, 8, 11, 8, 11, 8, 11, 8, 2, 4, 0, 
  /* 1776 */ 12, 2, 12, 2, 12, 2, 12, 2, 4, 0, 
  /* 1786 */ 21, 12, 2, 4, 12, 2, 12, 2, 12, 2, 4, 0, 
  /* 1798 */ 21, 12, 2, 4, 12, 2, 12, 2, 4, 0, 
  /* 1808 */ 13, 2, 13, 2, 13, 2, 13, 2, 4, 0, 
  /* 1818 */ 13, 2, 12, 3, 12, 3, 13, 2, 4, 0, 
  /* 1828 */ 15, 1, 15, 1, 14, 2, 14, 2, 4, 0, 
  /* 1838 */ 15, 4, 15, 4, 14, 2, 14, 2, 4, 0, 
  /* 1848 */ 12, 7, 12, 7, 12, 7, 12, 4, 4, 3, 4, 0, 
  /* 1860 */ 12, 4, 12, 4, 14, 2, 12, 4, 3, 4, 0, 
  /* 1871 */ 12, 7, 12, 7, 14, 2, 12, 4, 3, 4, 0, 
  /* 1882 */ 12, 7, 12, 7, 12, 7, 4, 12, 7, 3, 4, 0, 
  /* 1894 */ 12, 7, 12, 7, 12, 7, 12, 7, 3, 4, 0, 
  /* 1905 */ 11, 3, 11, 3, 11, 3, 11, 3, 4, 0, 
  /* 1915 */ 21, 11, 3, 4, 11, 3, 11, 3, 11, 3, 4, 0, 
  /* 1927 */ 21, 11, 3, 4, 11, 3, 11, 3, 4, 0, 
  /* 1937 */ 13, 3, 16, 2, 16, 2, 13, 3, 4, 0, 
  /* 1947 */ 13, 3, 13, 3, 11, 3, 13, 3, 4, 0, 
  /* 1957 */ 13, 3, 13, 3, 13, 3, 13, 3, 4, 0, 
  /* 1967 */ 13, 3, 16, 2, 16, 2, 4, 13, 3, 4, 0, 
  /* 1978 */ 13, 3, 12, 4, 12, 4, 13, 3, 4, 0, 
  /* 1988 */ 21, 3, 4, 0, 
  /* 1992 */ 15, 3, 26, 3, 4, 0, 
  /* 1998 */ 10, 7, 10, 7, 10, 7, 10, 7, 2, 4, 4, 0, 
  /* 2010 */ 9, 8, 9, 8, 9, 8, 9, 8, 2, 4, 4, 0, 
  /* 2022 */ 23, 15, 3, 15, 3, 15, 3, 15, 3, 15, 12, 15, 3, 15, 3, 15, 3, 15, 3, 4, 4, 0, 
  /* 2044 */ 22, 15, 3, 15, 3, 15, 3, 15, 12, 15, 3, 15, 3, 15, 3, 4, 4, 0, 
  /* 2062 */ 21, 15, 3, 15, 3, 15, 12, 15, 3, 15, 3, 4, 4, 0, 
  /* 2076 */ 0, 5, 4, 4, 4, 4, 4, 4, 4, 0, 
  /* 2086 */ 21, 4, 4, 4, 4, 4, 0, 
  /* 2093 */ 23, 3, 3, 3, 3, 5, 4, 4, 4, 0, 
  /* 2103 */ 21, 3, 3, 5, 4, 4, 4, 0, 
  /* 2111 */ 23, 4, 4, 4, 4, 5, 4, 4, 4, 0, 
  /* 2121 */ 21, 4, 4, 5, 4, 4, 4, 0, 
  /* 2129 */ 23, 4, 4, 4, 4, 5, 5, 4, 4, 4, 0, 
  /* 2140 */ 21, 5, 5, 5, 4, 4, 4, 0, 
  /* 2148 */ 23, 7, 7, 7, 7, 5, 5, 4, 4, 4, 0, 
  /* 2159 */ 23, 7, 7, 7, 7, 5, 4, 4, 4, 0, 
  /* 2169 */ 16, 4, 16, 4, 16, 4, 4, 4, 0, 
  /* 2178 */ 23, 3, 3, 3, 3, 5, 4, 4, 0, 
  /* 2187 */ 21, 3, 3, 5, 4, 4, 0, 
  /* 2194 */ 23, 4, 4, 4, 4, 5, 4, 4, 0, 
  /* 2203 */ 21, 4, 4, 5, 4, 4, 0, 
  /* 2210 */ 23, 4, 4, 4, 4, 5, 5, 4, 4, 0, 
  /* 2220 */ 21, 5, 5, 5, 4, 4, 0, 
  /* 2227 */ 23, 7, 7, 7, 7, 5, 5, 4, 4, 0, 
  /* 2237 */ 23, 7, 7, 7, 7, 5, 4, 4, 0, 
  /* 2246 */ 0, 14, 2, 2, 10, 4, 10, 4, 4, 0, 
  /* 2256 */ 21, 10, 4, 4, 10, 4, 10, 4, 4, 0, 
  /* 2266 */ 21, 10, 4, 4, 10, 4, 10, 4, 10, 4, 4, 0, 
  /* 2278 */ 10, 4, 10, 4, 10, 4, 10, 4, 4, 0, 
  /* 2288 */ 0, 14, 2, 2, 9, 5, 10, 4, 4, 0, 
  /* 2298 */ 0, 14, 2, 2, 10, 5, 10, 4, 4, 0, 
  /* 2308 */ 0, 14, 2, 2, 11, 4, 11, 4, 4, 0, 
  /* 2318 */ 0, 14, 2, 2, 11, 5, 11, 4, 4, 0, 
  /* 2328 */ 0, 15, 4, 15, 11, 15, 11, 4, 4, 0, 
  /* 2338 */ 0, 15, 4, 15, 11, 15, 11, 15, 11, 4, 4, 0, 
  /* 2350 */ 0, 15, 4, 15, 11, 15, 11, 15, 11, 15, 11, 4, 4, 0, 
  /* 2364 */ 35, 1, 35, 1, 12, 4, 4, 0, 
  /* 2372 */ 0, 14, 2, 3, 12, 4, 12, 4, 4, 0, 
  /* 2382 */ 12, 4, 12, 4, 12, 4, 12, 4, 4, 0, 
  /* 2392 */ 13, 4, 13, 4, 12, 4, 12, 4, 4, 0, 
  /* 2402 */ 36, 1, 36, 1, 13, 4, 4, 0, 
  /* 2410 */ 13, 4, 13, 4, 13, 4, 13, 4, 4, 0, 
  /* 2420 */ 16, 4, 16, 4, 13, 4, 13, 4, 4, 0, 
  /* 2430 */ 16, 4, 16, 4, 13, 4, 4, 0, 
  /* 2438 */ 13, 4, 13, 4, 16, 4, 4, 0, 
  /* 2446 */ 16, 4, 16, 4, 16, 4, 4, 0, 
  /* 2454 */ 17, 17, 4, 4, 0, 
  /* 2459 */ 15, 0, 18, 4, 4, 0, 
  /* 2465 */ 21, 4, 4, 0, 
  /* 2469 */ 23, 3, 3, 3, 3, 5, 4, 0, 
  /* 2477 */ 21, 3, 3, 5, 4, 0, 
  /* 2483 */ 23, 4, 4, 4, 4, 5, 4, 0, 
  /* 2491 */ 21, 4, 4, 5, 4, 0, 
  /* 2497 */ 16, 4, 16, 4, 16, 4, 5, 4, 0, 
  /* 2506 */ 23, 4, 4, 4, 4, 5, 5, 4, 0, 
  /* 2515 */ 21, 5, 5, 5, 4, 0, 
  /* 2521 */ 23, 7, 7, 7, 7, 5, 5, 4, 0, 
  /* 2530 */ 23, 7, 7, 7, 7, 5, 4, 0, 
  /* 2538 */ 0, 14, 2, 2, 10, 4, 9, 5, 4, 0, 
  /* 2548 */ 0, 14, 2, 2, 9, 5, 9, 5, 4, 0, 
  /* 2558 */ 9, 5, 9, 5, 9, 5, 9, 5, 4, 0, 
  /* 2568 */ 0, 14, 2, 2, 10, 4, 10, 5, 4, 0, 
  /* 2578 */ 0, 14, 2, 2, 10, 5, 10, 5, 4, 0, 
  /* 2588 */ 0, 14, 2, 2, 11, 4, 11, 5, 4, 0, 
  /* 2598 */ 0, 14, 2, 2, 11, 5, 11, 5, 4, 0, 
  /* 2608 */ 21, 5, 4, 0, 
  /* 2612 */ 0, 14, 2, 2, 10, 4, 10, 7, 4, 0, 
  /* 2622 */ 0, 14, 2, 2, 9, 5, 10, 7, 4, 0, 
  /* 2632 */ 0, 14, 2, 2, 10, 5, 10, 7, 4, 0, 
  /* 2642 */ 0, 14, 2, 2, 11, 4, 11, 7, 4, 0, 
  /* 2652 */ 0, 14, 2, 2, 11, 5, 11, 7, 4, 0, 
  /* 2662 */ 0, 14, 2, 3, 12, 4, 12, 7, 4, 0, 
  /* 2672 */ 21, 9, 5, 4, 9, 8, 4, 0, 
  /* 2680 */ 0, 14, 2, 2, 10, 4, 9, 8, 4, 0, 
  /* 2690 */ 0, 14, 2, 2, 9, 5, 9, 8, 4, 0, 
  /* 2700 */ 0, 14, 2, 2, 10, 4, 10, 8, 4, 0, 
  /* 2710 */ 0, 14, 2, 2, 10, 5, 10, 8, 4, 0, 
  /* 2720 */ 0, 14, 2, 2, 11, 4, 11, 8, 4, 0, 
  /* 2730 */ 0, 14, 2, 2, 11, 5, 11, 8, 4, 0, 
  /* 2740 */ 21, 10, 4, 4, 10, 4, 0, 
  /* 2747 */ 21, 11, 3, 4, 10, 4, 10, 4, 0, 
  /* 2756 */ 21, 10, 4, 4, 10, 4, 10, 4, 0, 
  /* 2765 */ 0, 15, 4, 15, 11, 15, 11, 15, 11, 4, 0, 
  /* 2776 */ 0, 15, 4, 15, 11, 15, 11, 15, 11, 15, 11, 4, 0, 
  /* 2789 */ 35, 1, 35, 1, 12, 4, 12, 4, 0, 
  /* 2798 */ 12, 4, 35, 1, 12, 4, 12, 4, 0, 
  /* 2807 */ 13, 4, 35, 1, 12, 4, 12, 4, 0, 
  /* 2816 */ 23, 15, 3, 15, 3, 15, 3, 15, 3, 15, 12, 4, 0, 
  /* 2829 */ 22, 15, 3, 15, 3, 15, 3, 15, 12, 4, 0, 
  /* 2840 */ 21, 15, 3, 15, 3, 15, 12, 4, 0, 
  /* 2849 */ 36, 1, 36, 1, 13, 4, 13, 4, 0, 
  /* 2858 */ 13, 4, 36, 1, 13, 4, 13, 4, 0, 
  /* 2867 */ 16, 4, 36, 1, 13, 4, 13, 4, 0, 
  /* 2876 */ 16, 4, 16, 4, 13, 4, 13, 4, 0, 
  /* 2885 */ 16, 4, 16, 4, 13, 4, 0, 
  /* 2892 */ 5, 19, 15, 4, 0, 
  /* 2897 */ 13, 4, 16, 4, 0, 
  /* 2902 */ 16, 4, 16, 4, 16, 4, 0, 
  /* 2909 */ 4, 17, 4, 0, 
  /* 2913 */ 17, 17, 4, 0, 
  /* 2917 */ 16, 2, 2, 16, 2, 5, 0, 
  /* 2924 */ 16, 2, 16, 2, 16, 2, 16, 2, 5, 0, 
  /* 2934 */ 5, 16, 2, 16, 2, 5, 0, 
  /* 2941 */ 16, 2, 13, 3, 13, 3, 16, 2, 5, 0, 
  /* 2951 */ 5, 16, 2, 16, 2, 4, 5, 0, 
  /* 2959 */ 21, 10, 4, 4, 9, 5, 9, 5, 0, 
  /* 2968 */ 21, 9, 5, 4, 9, 5, 9, 5, 0, 
  /* 2977 */ 23, 4, 4, 4, 4, 5, 4, 7, 0, 
  /* 2986 */ 23, 4, 4, 4, 4, 5, 5, 4, 7, 0, 
  /* 2996 */ 23, 7, 7, 7, 7, 5, 5, 4, 7, 0, 
  /* 3006 */ 23, 7, 7, 7, 7, 5, 4, 7, 0, 
  /* 3015 */ 23, 4, 4, 4, 4, 5, 7, 0, 
  /* 3023 */ 23, 4, 4, 4, 4, 5, 5, 7, 0, 
  /* 3032 */ 23, 7, 7, 7, 7, 5, 5, 7, 0, 
  /* 3041 */ 23, 7, 7, 7, 7, 5, 7, 0, 
  /* 3049 */ 23, 4, 4, 4, 4, 5, 4, 7, 7, 0, 
  /* 3059 */ 23, 4, 4, 4, 4, 5, 5, 4, 7, 7, 0, 
  /* 3070 */ 23, 7, 7, 7, 7, 5, 5, 4, 7, 7, 0, 
  /* 3081 */ 23, 7, 7, 7, 7, 5, 4, 7, 7, 0, 
  /* 3091 */ 23, 4, 4, 4, 4, 5, 7, 7, 0, 
  /* 3100 */ 23, 4, 4, 4, 4, 5, 5, 7, 7, 0, 
  /* 3110 */ 23, 7, 7, 7, 7, 5, 5, 7, 7, 0, 
  /* 3120 */ 23, 7, 7, 7, 7, 5, 7, 7, 0, 
  /* 3129 */ 23, 4, 4, 4, 4, 5, 4, 7, 7, 7, 0, 
  /* 3140 */ 23, 4, 4, 4, 4, 5, 5, 4, 7, 7, 7, 0, 
  /* 3152 */ 23, 7, 7, 7, 7, 5, 5, 4, 7, 7, 7, 0, 
  /* 3164 */ 23, 7, 7, 7, 7, 5, 4, 7, 7, 7, 0, 
  /* 3175 */ 23, 4, 4, 4, 4, 5, 7, 7, 7, 0, 
  /* 3185 */ 23, 4, 4, 4, 4, 5, 5, 7, 7, 7, 0, 
  /* 3196 */ 23, 7, 7, 7, 7, 5, 5, 7, 7, 7, 0, 
  /* 3207 */ 23, 7, 7, 7, 7, 5, 7, 7, 7, 0, 
  /* 3217 */ 23, 4, 4, 4, 4, 5, 4, 7, 7, 7, 7, 0, 
  /* 3229 */ 23, 4, 4, 4, 4, 5, 5, 4, 7, 7, 7, 7, 0, 
  /* 3242 */ 23, 7, 7, 7, 7, 5, 5, 4, 7, 7, 7, 7, 0, 
  /* 3255 */ 23, 7, 7, 7, 7, 5, 4, 7, 7, 7, 7, 0, 
  /* 3267 */ 23, 4, 4, 4, 4, 5, 7, 7, 7, 7, 0, 
  /* 3278 */ 23, 4, 4, 4, 4, 5, 5, 7, 7, 7, 7, 0, 
  /* 3290 */ 23, 7, 7, 7, 7, 5, 5, 7, 7, 7, 7, 0, 
  /* 3302 */ 23, 7, 7, 7, 7, 5, 7, 7, 7, 7, 0, 
  /* 3313 */ 23, 4, 4, 4, 4, 5, 4, 7, 7, 7, 7, 7, 7, 0, 
  /* 3327 */ 23, 4, 4, 4, 4, 5, 5, 4, 7, 7, 7, 7, 7, 7, 0, 
  /* 3342 */ 23, 7, 7, 7, 7, 5, 5, 4, 7, 7, 7, 7, 7, 7, 0, 
  /* 3357 */ 23, 7, 7, 7, 7, 5, 4, 7, 7, 7, 7, 7, 7, 0, 
  /* 3371 */ 23, 4, 4, 4, 4, 5, 7, 7, 7, 7, 7, 7, 0, 
  /* 3384 */ 23, 4, 4, 4, 4, 5, 5, 7, 7, 7, 7, 7, 7, 0, 
  /* 3398 */ 23, 7, 7, 7, 7, 5, 5, 7, 7, 7, 7, 7, 7, 0, 
  /* 3412 */ 23, 7, 7, 7, 7, 5, 7, 7, 7, 7, 7, 7, 0, 
  /* 3425 */ 23, 4, 4, 4, 4, 5, 7, 7, 7, 7, 7, 7, 7, 7, 7, 0, 
  /* 3441 */ 23, 4, 4, 4, 4, 5, 5, 7, 7, 7, 7, 7, 7, 7, 7, 7, 0, 
  /* 3458 */ 23, 7, 7, 7, 7, 5, 5, 7, 7, 7, 7, 7, 7, 7, 7, 7, 0, 
  /* 3475 */ 23, 7, 7, 7, 7, 5, 7, 7, 7, 7, 7, 7, 7, 7, 7, 0, 
  /* 3491 */ 17, 10, 7, 0, 
  /* 3495 */ 21, 9, 5, 4, 9, 8, 9, 8, 0, 
  /* 3504 */ 9, 8, 9, 8, 9, 8, 9, 8, 0, 
  /* 3513 */ 17, 9, 8, 0, 
  /* 3517 */ 10, 8, 10, 8, 10, 8, 10, 8, 0, 
  /* 3526 */ 0, 15, 3, 15, 3, 15, 3, 15, 12, 0, 
  /* 3536 */ 0, 15, 3, 15, 3, 15, 3, 15, 3, 15, 12, 0, 
  /* 3548 */ 23, 15, 3, 15, 3, 15, 3, 15, 3, 15, 12, 0, 
  /* 3560 */ 22, 15, 3, 15, 3, 15, 3, 15, 12, 0, 
  /* 3570 */ 21, 15, 3, 15, 3, 15, 12, 0, 
  /* 3578 */ 0, 15, 3, 15, 3, 5, 15, 12, 0, 
  /* 3587 */ 0, 15, 3, 15, 3, 15, 3, 5, 15, 12, 0, 
  /* 3598 */ 0, 15, 3, 15, 3, 15, 3, 15, 3, 5, 15, 12, 0, 
  /* 3611 */ 23, 15, 3, 15, 3, 15, 3, 15, 3, 15, 3, 15, 3, 15, 3, 15, 3, 5, 15, 12, 0, 
  /* 3632 */ 22, 15, 3, 15, 3, 15, 3, 15, 3, 15, 3, 15, 3, 5, 15, 12, 0, 
  /* 3649 */ 21, 15, 3, 15, 3, 15, 3, 15, 3, 5, 15, 12, 0, 
  /* 3662 */ 4, 17, 0, 
  /* 3665 */ 10, 7, 10, 7, 17, 0, 
  /* 3671 */ 9, 8, 17, 0, 
  /* 3675 */ 0, 14, 17, 17, 0, 
  /* 3680 */ 17, 17, 17, 0, 
  /* 3684 */ 15, 0, 18, 0, 
  /* 3688 */ 15, 4, 18, 0, 
  /* 3692 */ 15, 1, 19, 0, 
  /* 3696 */ 1, 14, 2, 19, 0, 
  /* 3701 */ 21, 14, 2, 1, 14, 2, 4, 19, 0, 
  /* 3710 */ 0, 19, 5, 19, 19, 0, 
  /* 3716 */ 0, 19, 19, 19, 0, 
  /* 3721 */ 15, 0, 29, 0, 
  /* 3725 */ 0, 1, 29, 0, 
  /* 3729 */ 0, 5, 4, 14, 2, 4, 29, 0, 
  /* 3737 */ 5, 5, 4, 14, 2, 4, 29, 0, 
  /* 3745 */ 18, 5, 4, 15, 4, 4, 4, 29, 0, 
  /* 3754 */ 0, 5, 4, 29, 0, 
  /* 3759 */ 28, 34, 28, 34, 28, 34, 28, 34, 0, 
  -1
};
} // END OF class IntrinsicsGlobals
