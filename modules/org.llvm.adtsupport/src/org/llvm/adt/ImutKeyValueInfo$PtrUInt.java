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

package org.llvm.adt;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


/// ImutKeyValueInfo -Traits class used by ImmutableMap.  While both the first
/// and second elements in a pair are used to generate profile information,
/// only the first element (the key) is used by isEqual and isLess.
/*template <typename T, typename S> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ImutKeyValueInfo">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 24,
 FQN="llvm::ImutKeyValueInfo", NM="_ZN4llvm16ImutKeyValueInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm16ImutKeyValueInfoE")
//</editor-fold>
public class/*struct*/ ImutKeyValueInfo$PtrUInt</*typename*/ T> implements ImutAVLTreeInfoPtrUIntType<T, std.pairTypeUInt<T>> {
  /*typedef const std::pair<T, S> value_type*/
//  public final class value_type extends /*const*/ std.pairTypeUInt<T>{ };
  /*typedef const value_type &value_type_ref*/
//  public final class value_type_ref extends /*const*/ std.pairTypeUInt<T> /*&*/ { };
  /*typedef const T key_type*/
//  public final class key_type extends /*const*/ T{ };
  /*typedef const T &key_type_ref*/
//  public final class key_type_ref extends /*const*/ T /*&*/ { };
  /*typedef const S data_type*/
//  public final class data_type extends /*const*/ S{ };
  /*typedef const S &data_type_ref*/
//  public final class data_type_ref extends /*const*/ S /*&*/ { };
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private final ImutContainerInfoT$P<T> $TInfo;
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private final ImutContainerInfoUInt $SInfo;
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static <T> ImutKeyValueInfo$PtrUInt<T> $Info()  {
    return new ImutKeyValueInfo$PtrUInt(new ImutContainerInfoT$P<T>(null), ImutContainerInfoUInt.$Info());
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public ImutKeyValueInfo$PtrUInt(ImutContainerInfoT$P<T> $TInfo, ImutContainerInfoUInt $SInfo) {
    this.$TInfo = $TInfo;
    this.$SInfo = $SInfo;
    assert $TInfo != null && $SInfo != null : "Fix me!";
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutKeyValueInfo::KeyOfValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 33,
   FQN="llvm::ImutKeyValueInfo::KeyOfValue", NM="_ZN4llvm16ImutKeyValueInfo10KeyOfValueERKSt4pairIT_T0_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm16ImutKeyValueInfo10KeyOfValueERKSt4pairIT_T0_E")
  //</editor-fold>
  public /*const*/ T /*&*/ KeyOfValue(final /*const*/ std.pairTypeUInt<T> /*&*/ V) {
    return V.first;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutKeyValueInfo::DataOfValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 37,
   FQN="llvm::ImutKeyValueInfo::DataOfValue", NM="_ZN4llvm16ImutKeyValueInfo11DataOfValueERKSt4pairIT_T0_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm16ImutKeyValueInfo11DataOfValueERKSt4pairIT_T0_E")
  //</editor-fold>
  public /*const*/ int /*&*/ DataOfValue(final /*const*/ std.pairTypeUInt<T> /*&*/ V) {
    return V.second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutKeyValueInfo::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 41,
   FQN="llvm::ImutKeyValueInfo::isEqual", NM="_ZN4llvm16ImutKeyValueInfo7isEqualERKT_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm16ImutKeyValueInfo7isEqualERKT_S3_")
  //</editor-fold>
  public boolean isEqual(final /*const*/ T /*&*/ L, final /*const*/ T /*&*/ R) {
    return $TInfo.isEqual(L, R);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImutKeyValueInfo::isLess">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 44,
   FQN="llvm::ImutKeyValueInfo::isLess", NM="_ZN4llvm16ImutKeyValueInfo6isLessERKT_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm16ImutKeyValueInfo6isLessERKT_S3_")
  //</editor-fold>
  public boolean isLess(final /*const*/ T /*&*/ L, final /*const*/ T /*&*/ R) {
    return $TInfo.isLess(L, R);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutKeyValueInfo::isDataEqual">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 48,
   FQN="llvm::ImutKeyValueInfo::isDataEqual", NM="_ZN4llvm16ImutKeyValueInfo11isDataEqualERKT0_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm16ImutKeyValueInfo11isDataEqualERKT0_S3_")
  //</editor-fold>
  public boolean isDataEqual(final /*const*/ int /*&*/ L, final /*const*/ int /*&*/ R) {
    return $SInfo.isEqual(L, R);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutKeyValueInfo::Profile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 52,
   FQN="llvm::ImutKeyValueInfo::Profile", NM="_ZN4llvm16ImutKeyValueInfo7ProfileERNS_16FoldingSetNodeIDERKSt4pairIT_T0_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm16ImutKeyValueInfo7ProfileERNS_16FoldingSetNodeIDERKSt4pairIT_T0_E")
  //</editor-fold>
  @Override
  public void Profile(final FoldingSetNodeID /*&*/ ID, final /*const*/ std.pairTypeUInt<T> /*&*/ V) {
    $TInfo.Profile(ID, V.first);
    $SInfo.Profile(ID, V.second);
  }

  @Override public String toString() {
    return ""; // NOI18N
  }
}
