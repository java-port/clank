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

package org.clang.ast.aliases;

import org.clank.support.Converted;
import org.clang.ast.*;

// JAVA: Generated specialization

/// \brief Canonical proxy type returned when retrieving the members of a
/// canonical type or as the result of the @c CanQual<T>::getAs member
/// function.
///
/// The CanProxy type mainly exists as a proxy through which operator-> will
/// look to either map down to a raw T* (e.g., PointerType*) or to a proxy
/// type that provides canonical-type access to the fields of the type.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::CanProxy<RecordType>">
@Converted(kind = Converted.Kind.MANUAL_ADDED/*Java specialization for RecordType*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 332,
 FQN="clang::CanProxy<RecordType>", NM="_ZN5clang8CanProxyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang8CanProxyE")
//</editor-fold>
public class CanProxyRecordType  extends /*public*/ CanProxyAdaptorRecordType implements CanProxy<RecordType>{
/*public:*/
  /// \brief Build a NULL proxy.
  //<editor-fold defaultstate="collapsed" desc="clang::CanProxy::CanProxy<T>">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 336,
   FQN="clang::CanProxy<RecordType>::CanProxy<RecordType>", NM="_ZN5clang8CanProxyC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang8CanProxyC1Ev")
  //</editor-fold>
  public CanProxyRecordType() {
  }

  
  /// \brief Build a proxy to the given canonical type.
  //<editor-fold defaultstate="collapsed" desc="clang::CanProxy::CanProxy<T>">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 339,
   FQN="clang::CanProxy<RecordType>::CanProxy<RecordType>", NM="_ZN5clang8CanProxyC1ENS_7CanQualIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang8CanProxyC1ENS_7CanQualIT_EE")
  //</editor-fold>
  public CanProxyRecordType(CanQual<RecordType> Stored) {
    this.Stored = Stored;
  }

  
  /// \brief Implicit conversion to the stored canonical type.
  //<editor-fold defaultstate="collapsed" desc="clang::CanProxy::operator CanQual<type-parameter-0-0>">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 342,
   FQN="clang::CanProxy<RecordType>::operator CanQual<type-parameter-0-0>", NM="_ZNK5clang8CanProxycvNS_7CanQualIT_EEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang8CanProxycvNS_7CanQualIT_EEEv")
  //</editor-fold>
  public CanQual<RecordType> $CanQual$T() /*const*/ {
    return this.Stored;
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED/*overridden to have precize specialization as return type*/)
  @Override public /*const*/ CanProxyAdaptorRecordType /*P*/ $arrow() /*const*/ {
    return this;
  }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
