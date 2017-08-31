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

package org.clang.ast;

import org.clank.support.*;
import org.llvm.adt.*;


/// \brief Base class that is common to both the \c ExtQuals and \c Type
/// classes, which allows \c QualType to access the common fields between the
/// two.
///
//<editor-fold defaultstate="collapsed" desc="clang::ExtQualsTypeCommonBase">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1144,
 FQN="clang::ExtQualsTypeCommonBase", NM="_ZN5clang22ExtQualsTypeCommonBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang22ExtQualsTypeCommonBaseE")
//</editor-fold>
public class ExtQualsTypeCommonBase extends FoldingSetImpl.ContextualNodeImpl<ASTContext> {
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  protected ExtQualsTypeCommonBase() { super(); }
  
  //<editor-fold defaultstate="collapsed" desc="clang::ExtQualsTypeCommonBase::ExtQualsTypeCommonBase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*added method to be called from derived constructors*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1145,
   FQN="clang::ExtQualsTypeCommonBase::ExtQualsTypeCommonBase", NM="_ZN5clang22ExtQualsTypeCommonBaseC1EPKNS_4TypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang22ExtQualsTypeCommonBaseC1EPKNS_4TypeENS_8QualTypeE")
  //</editor-fold>
  protected ExtQualsTypeCommonBase(/*const*/ Type /*P*/ baseType, QualType canon) {
    $ExtQualsTypeCommonBase(baseType, canon);
  }
  protected void $ExtQualsTypeCommonBase(/*const*/ Type /*P*/ baseType, QualType canon) {
    // : BaseType(baseType), CanonicalType(canon) 
    //START JInit
    this.BaseType = baseType;
    this.CanonicalType = new QualType(canon);
    //END JInit
  }
  
  /// \brief The "base" type of an extended qualifiers type (\c ExtQuals) or
  /// a self-referential pointer (for \c Type).
  ///
  /// This pointer allows an efficient mapping from a QualType to its
  /// underlying type pointer.
  public/*friend*//*private*/ /*const*/ Type /*P*/ /*const*/ BaseType;
  
  /// \brief The canonical type of this type.  A QualType.
  public/*friend*//*private*/ QualType CanonicalType;
  
  /*friend  class QualType*/
  /*friend  class Type*/
  /*friend  class ExtQuals*/
  
  @Override public String toString() {
    return "" + "BaseType=" + System.identityHashCode(BaseType) // NOI18N
              + ", CanonicalType=" + CanonicalType; // NOI18N
  }
}
