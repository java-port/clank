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
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;


/// A metaprogramming class designed for concrete subtypes of abstract
/// types where all subtypes share equivalently-structured source
/// information.  See the note on ConcreteTypeLoc.
/*template <class Base, class Derived, class TypeClass> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::InheritingConcreteTypeLoc">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*used as specialization for InheritingConcreteTypeLoc<AdjustedTypeLoc, ...>*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 457,
 FQN="clang::InheritingConcreteTypeLoc", NM="_ZN5clang25InheritingConcreteTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang25InheritingConcreteTypeLocE")
//</editor-fold>
public abstract class InheritingConcrete$AdjustedTypeLoc</*class Base, *//*class*/ Derived extends InheritingConcrete$AdjustedTypeLoc, /*class*/ TypeClass extends AdjustedType>  
        /*extends own template param public Base*/extends AdjustedTypeLoc {
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  protected InheritingConcrete$AdjustedTypeLoc() {
    super();
//    throw new UnsupportedOperationException("replacemethod for super() called in derived class");
  }
  protected InheritingConcrete$AdjustedTypeLoc(Derived $Prm0) {
    super($Prm0);
//    throw new UnsupportedOperationException("replacemethod for super-copy() called in derived class");
  }
  protected InheritingConcrete$AdjustedTypeLoc(JD$Move _dparam, Derived $Prm0) {
    super(JD$Move.INSTANCE, $Prm0);
//    throw new UnsupportedOperationException("replacemethod for super-move() called in derived class");
  }
  
  /*friend  class TypeLoc*/
  //<editor-fold defaultstate="collapsed" desc="clang::InheritingConcreteTypeLoc::classofType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 460,
   FQN="clang::InheritingConcreteTypeLoc::classofType", NM="_ZN5clang25InheritingConcreteTypeLoc11classofTypeEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang25InheritingConcreteTypeLoc11classofTypeEPKNS_4TypeE")
  //</editor-fold>
  /*friend*//*private*/ static boolean classofType(/*const*/ Type /*P*/ Ty) {
    //return TypeClass::classof(Ty);
    throw new UnsupportedOperationException("TypeLoc.isKind should be used");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InheritingConcreteTypeLoc::isKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 464,
   FQN="clang::InheritingConcreteTypeLoc::isKind", NM="_ZN5clang25InheritingConcreteTypeLoc6isKindERKNS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang25InheritingConcreteTypeLoc6isKindERKNS_7TypeLocE")
  //</editor-fold>
  /*friend*//*private*/ static boolean isKind(/*const*/ TypeLoc /*&*/ TL) {
    throw new UnsupportedOperationException("TypeLoc.isKind should be used");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InheritingConcreteTypeLoc::isKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 468,
   FQN="clang::InheritingConcreteTypeLoc::isKind", NM="_ZN5clang25InheritingConcreteTypeLoc6isKindERKNS_13UnqualTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang25InheritingConcreteTypeLoc6isKindERKNS_13UnqualTypeLocE")
  //</editor-fold>
  /*friend*//*private*/ static boolean isKind(/*const*/ UnqualTypeLoc /*&*/ TL) {
    throw new UnsupportedOperationException("TypeLoc.isKind should be used");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::InheritingConcreteTypeLoc::getTypePtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 473,
   FQN="clang::InheritingConcreteTypeLoc::getTypePtr", NM="_ZNK5clang25InheritingConcreteTypeLoc10getTypePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang25InheritingConcreteTypeLoc10getTypePtrEv")
  //</editor-fold>
  public /*const*/ TypeClass /*P*/ getTypePtr() /*const*/ {
    return (TypeClass)cast(getTypeClass(), super.getTypePtr());
  }

  @Override protected abstract Class<? extends TypeClass> getTypeClass();
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
