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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;


/// \brief Wrapper of type source information for a type with
/// no direct qualifiers.
//<editor-fold defaultstate="collapsed" desc="clang::UnqualTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 222,
 FQN="clang::UnqualTypeLoc", NM="_ZN5clang13UnqualTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13UnqualTypeLocE")
//</editor-fold>
public class UnqualTypeLoc<TypeClass extends Type> extends /*public*/ TypeLoc {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualTypeLoc::UnqualTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 224,
   FQN="clang::UnqualTypeLoc::UnqualTypeLoc", NM="_ZN5clang13UnqualTypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13UnqualTypeLocC1Ev")
  //</editor-fold>
  public UnqualTypeLoc() {
    // : TypeLoc() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnqualTypeLoc::UnqualTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 225,
   FQN="clang::UnqualTypeLoc::UnqualTypeLoc", NM="_ZN5clang13UnqualTypeLocC1EPKNS_4TypeEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13UnqualTypeLocC1EPKNS_4TypeEPv")
  //</editor-fold>
  public UnqualTypeLoc(/*const*/ TypeClass /*P*/ Ty, type$ptr<?>/*void P*/ Data) {
    // : TypeLoc(Ty, Data) 
    //START JInit
    super(Ty, Data);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualTypeLoc::getTypePtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 227,
   FQN="clang::UnqualTypeLoc::getTypePtr", NM="_ZNK5clang13UnqualTypeLoc10getTypePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang13UnqualTypeLoc10getTypePtrEv")
  //</editor-fold>
  public /*const*/ TypeClass /*P*/ getTypePtr() /*const*/ {
    // FIXME/JAVA: can't use reinterpret_cast w/o a class and can't use TypeClass.class => just cast
    return (TypeClass) Ty; // reinterpret_cast(/*const*/ Type /*P*/ .class, Ty);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualTypeLoc::getTypeLocClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 231,
   FQN="clang::UnqualTypeLoc::getTypeLocClass", NM="_ZNK5clang13UnqualTypeLoc15getTypeLocClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang13UnqualTypeLoc15getTypeLocClassEv")
  //</editor-fold>
  public TypeLocClass getTypeLocClass() /*const*/ {
    return TypeLocClass.valueOf(getTypePtr().getTypeClass().getValue());
  }

/*private:*/
  /*friend  class TypeLoc*/
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualTypeLoc::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 237,
   FQN="clang::UnqualTypeLoc::isKind", NM="_ZN5clang13UnqualTypeLoc6isKindERKNS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13UnqualTypeLoc6isKindERKNS_7TypeLocE")
  //</editor-fold>
  /*friend*//*private*/static boolean isKind(final /*const*/ TypeLoc /*&*/ TL) {
    return !TL.getType().hasLocalQualifiers();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnqualTypeLoc::UnqualTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 222,
   FQN="clang::UnqualTypeLoc::UnqualTypeLoc", NM="_ZN5clang13UnqualTypeLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13UnqualTypeLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ UnqualTypeLoc(final /*const*/ UnqualTypeLoc /*&*/ $Prm0) {
    // : TypeLoc() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnqualTypeLoc::UnqualTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 222,
   FQN="clang::UnqualTypeLoc::UnqualTypeLoc", NM="_ZN5clang13UnqualTypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13UnqualTypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ UnqualTypeLoc(JD$Move _dparam, final UnqualTypeLoc /*&&*/$Prm0) {
    // : TypeLoc(static_cast<UnqualTypeLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnqualTypeLoc::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 222,
   FQN="clang::UnqualTypeLoc::operator=", NM="_ZN5clang13UnqualTypeLocaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13UnqualTypeLocaSEOS0_")
  //</editor-fold>
  public /*inline*/ UnqualTypeLoc /*&*/ $assignMove(final UnqualTypeLoc /*&&*/$Prm0) {
    /*Deref*/super.$assignMove($Prm0);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
