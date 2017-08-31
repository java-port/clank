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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.ast.aliases.*;


//----------------------------------------------------------------------------//
// Canonical proxy adaptors for canonical type nodes.
//----------------------------------------------------------------------------//

/// \brief Iterator adaptor that turns an iterator over canonical QualTypes
/// into an iterator over CanQualTypes.
/*template <typename InputIterator> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::CanTypeIterator">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 384,
 FQN="clang::CanTypeIterator", NM="_ZN5clang15CanTypeIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang15CanTypeIteratorE")
//</editor-fold>
public class/*struct*/ CanTypeIterator</*typename*/ InputIterator extends type$iterator<?, QualType>>  extends /**/ iterator_adaptor_base<CanTypeIterator<InputIterator>, InputIterator,  std.random_access_iterator_tag/*iterator_traits<InputIterator>.iterator_category*/, CanProxyType, CanQual<Type>> {
  //<editor-fold defaultstate="collapsed" desc="clang::CanTypeIterator::CanTypeIterator<InputIterator>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 392,
   FQN="clang::CanTypeIterator::CanTypeIterator<InputIterator>", NM="_ZN5clang15CanTypeIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang15CanTypeIteratorC1Ev")
  //</editor-fold>
  public CanTypeIterator() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanTypeIterator::CanTypeIterator<InputIterator>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 393,
   FQN="clang::CanTypeIterator::CanTypeIterator<InputIterator>", NM="_ZN5clang15CanTypeIteratorC1ET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang15CanTypeIteratorC1ET_")
  //</editor-fold>
  public /*explicit*/ CanTypeIterator(InputIterator Iter) {
    // : CanTypeIterator<InputIterator>::iterator_adaptor_base(std::move(Iter)) 
    //START JInit
    /*ParenListExpr*/super(JD$NotBaseOfRemoveCVRef.INSTANCE, std.move(Iter));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CanTypeIterator::operator*">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 396,
   FQN="clang::CanTypeIterator::operator*", NM="_ZNK5clang15CanTypeIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanTypeIteratordeEv")
  //</editor-fold>
  public CanQual<Type> $star() /*const*/ {
    return CanQual.<Type>CreateUnsafe(this.I.$star());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanTypeIterator::operator->">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 660,
   FQN="clang::CanTypeIterator::operator->", NM="_ZNK5clang15CanTypeIteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZNK5clang15CanTypeIteratorptEv")
  //</editor-fold>
  public CanProxyType $arrow() /*const*/ {
    return new CanProxyType($star());
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public CanTypeIterator(CanTypeIterator $Prm0) { super(JD$BaseOf.INSTANCE, $Prm0); }
  
  public CanTypeIterator(JD$Move _dparm, CanTypeIterator $Prm0) { super(JD$Move.INSTANCE, $Prm0); }
  
  @Override public CanTypeIterator clone() { return new CanTypeIterator(this); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
