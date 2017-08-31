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

import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


//===----------------------------------------------------------------------===//
// Trait classes that contain element comparison operators and type
//  definitions used by ImutAVLTree, ImmutableSet, and ImmutableMap.  These
//  inherit from the profile traits (ImutProfileInfo) to include operations
//  for element profiling.
//===----------------------------------------------------------------------===//

/// ImutContainerInfo - Generic definition of comparison operations for
///   elements of immutable containers that defaults to using
///   std::equal_to<> and std::less<> to perform comparison of elements.
/*template <typename int> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ImutContainerInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 908,
 FQN="llvm::ImutContainerInfo", NM="_ZN4llvm17ImutContainerInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm17ImutContainerInfoE")
//</editor-fold>
public class/*struct*/ ImutContainerInfoLong extends /*public*/ ImutProfileInfoLong implements ImutAVLTreeInfoLongBoolLong {
  /*typedef typename ImutProfileInfo<int>::value_type value_type*/
//  public final class value_type extends  ImutProfileInfo.value_type<int>{ };
  /*typedef typename ImutProfileInfo<int>::value_type_ref value_type_ref*/
//  public final class value_type_ref extends int{ };
  /*typedef value_type key_type*/
//  public final class key_type extends  ImutProfileInfo.value_type<int>{ };
  /*typedef value_type_ref key_type_ref*/
//  public final class key_type_ref extends int{ };
  /*typedef bool data_type;*/
  /*typedef bool data_type_ref;*/
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static final ImutContainerInfoLong INFO = new ImutContainerInfoLong();

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private ImutContainerInfoLong() {
    super();
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutContainerInfo::KeyOfValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 917,
   FQN="llvm::ImutContainerInfo::KeyOfValue", NM="_ZN4llvm17ImutContainerInfo10KeyOfValueENS_15ImutProfileInfoIT_E14value_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm17ImutContainerInfo10KeyOfValueENS_15ImutProfileInfoIT_E14value_type_refE")
  //</editor-fold>
  public /*interface*/ long KeyOfValue(long D) {
    return D;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImutContainerInfo::DataOfValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 918,
   FQN="llvm::ImutContainerInfo::DataOfValue", NM="_ZN4llvm17ImutContainerInfo11DataOfValueENS_15ImutProfileInfoIT_E14value_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm17ImutContainerInfo11DataOfValueENS_15ImutProfileInfoIT_E14value_type_refE")
  //</editor-fold>
  public /*interface*/ boolean DataOfValue(long $Prm0) {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutContainerInfo::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 920,
   FQN="llvm::ImutContainerInfo::isEqual", NM="_ZN4llvm17ImutContainerInfo7isEqualENS_15ImutProfileInfoIT_E14value_type_refES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm17ImutContainerInfo7isEqualENS_15ImutProfileInfoIT_E14value_type_refES4_")
  //</editor-fold>
  public /*interface*/ boolean isEqual(long LHS, long RHS) {
    return LHS == RHS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutContainerInfo::isLess">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 924,
   FQN="llvm::ImutContainerInfo::isLess", NM="_ZN4llvm17ImutContainerInfo6isLessENS_15ImutProfileInfoIT_E14value_type_refES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm17ImutContainerInfo6isLessENS_15ImutProfileInfoIT_E14value_type_refES4_")
  //</editor-fold>
  public /*interface*/ boolean isLess(long LHS, long RHS) {
    return LHS < RHS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutContainerInfo::isDataEqual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 928,
   FQN="llvm::ImutContainerInfo::isDataEqual", NM="_ZN4llvm17ImutContainerInfo11isDataEqualEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm17ImutContainerInfo11isDataEqualEbb")
  //</editor-fold>
  public /*interface*/ boolean isDataEqual(boolean $Prm0, boolean $Prm1) {
    return true;
  }
}
