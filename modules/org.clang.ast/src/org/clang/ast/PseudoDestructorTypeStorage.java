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
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief Stores the type being destroyed by a pseudo-destructor expression.
//<editor-fold defaultstate="collapsed" desc="clang::PseudoDestructorTypeStorage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2078,
 FQN="clang::PseudoDestructorTypeStorage", NM="_ZN5clang27PseudoDestructorTypeStorageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang27PseudoDestructorTypeStorageE")
//</editor-fold>
public class PseudoDestructorTypeStorage {
  /// \brief Either the type source information or the name of the type, if
  /// it couldn't be resolved due to type-dependence.
  private PointerUnion<TypeSourceInfo /*P*/ , IdentifierInfo /*P*/ > Type;
  
  /// \brief The starting source location of the pseudo-destructor type.
  private SourceLocation Location;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoDestructorTypeStorage::PseudoDestructorTypeStorage">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2087,
   FQN="clang::PseudoDestructorTypeStorage::PseudoDestructorTypeStorage", NM="_ZN5clang27PseudoDestructorTypeStorageC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang27PseudoDestructorTypeStorageC1Ev")
  //</editor-fold>
  public PseudoDestructorTypeStorage() {
    // : Type(), Location() 
    //START JInit
    this.Type = new PointerUnion<TypeSourceInfo /*P*/ , IdentifierInfo /*P*/ >(TypeSourceInfo.class);
    this.Location = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoDestructorTypeStorage::PseudoDestructorTypeStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2089,
   FQN="clang::PseudoDestructorTypeStorage::PseudoDestructorTypeStorage", NM="_ZN5clang27PseudoDestructorTypeStorageC1EPNS_14IdentifierInfoENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang27PseudoDestructorTypeStorageC1EPNS_14IdentifierInfoENS_14SourceLocationE")
  //</editor-fold>
  public PseudoDestructorTypeStorage(IdentifierInfo /*P*/ II, SourceLocation Loc) {
    // : Type(II), Location(Loc) 
    //START JInit
    this.Type = new PointerUnion<TypeSourceInfo /*P*/ , IdentifierInfo /*P*/ >(JD$T1.INSTANCE, IdentifierInfo /*P*/ .class, II);
    this.Location = new SourceLocation(Loc);
    //END JInit
  }

  
  
  // CXXPseudoDestructorExpr
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoDestructorTypeStorage::PseudoDestructorTypeStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 156,
   FQN="clang::PseudoDestructorTypeStorage::PseudoDestructorTypeStorage", NM="_ZN5clang27PseudoDestructorTypeStorageC1EPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang27PseudoDestructorTypeStorageC1EPNS_14TypeSourceInfoE")
  //</editor-fold>
  public PseudoDestructorTypeStorage(TypeSourceInfo /*P*/ Info) {
    // : Type(Info), Location() 
    //START JInit
    this.Type = new PointerUnion<TypeSourceInfo /*P*/ , IdentifierInfo /*P*/ >(JD$T.INSTANCE, TypeSourceInfo /*P*/ .class, Info);
    this.Location = new SourceLocation();
    //END JInit
    Location.$assignMove(Info.getTypeLoc().getLocalSourceRange().getBegin());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoDestructorTypeStorage::getTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2094,
   FQN="clang::PseudoDestructorTypeStorage::getTypeSourceInfo", NM="_ZNK5clang27PseudoDestructorTypeStorage17getTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27PseudoDestructorTypeStorage17getTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeSourceInfo() /*const*/ {
    return Type.dyn_cast(TypeSourceInfo /*P*/.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoDestructorTypeStorage::getIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2098,
   FQN="clang::PseudoDestructorTypeStorage::getIdentifier", NM="_ZNK5clang27PseudoDestructorTypeStorage13getIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27PseudoDestructorTypeStorage13getIdentifierEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getIdentifier() /*const*/ {
    return Type.dyn_cast(IdentifierInfo /*P*/.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoDestructorTypeStorage::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2102,
   FQN="clang::PseudoDestructorTypeStorage::getLocation", NM="_ZNK5clang27PseudoDestructorTypeStorage11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27PseudoDestructorTypeStorage11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return new SourceLocation(Location);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PseudoDestructorTypeStorage::PseudoDestructorTypeStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2078,
   FQN="clang::PseudoDestructorTypeStorage::PseudoDestructorTypeStorage", NM="_ZN5clang27PseudoDestructorTypeStorageC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang27PseudoDestructorTypeStorageC1ERKS0_")
  //</editor-fold>
  public /*inline*/ PseudoDestructorTypeStorage(final /*const*/ PseudoDestructorTypeStorage /*&*/ $Prm0) {
    // : Type(.Type), Location(.Location) 
    //START JInit
    this.Type = new PointerUnion<TypeSourceInfo /*P*/ , IdentifierInfo /*P*/ >($Prm0.Type);
    this.Location = new SourceLocation($Prm0.Location);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PseudoDestructorTypeStorage::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2078,
   FQN="clang::PseudoDestructorTypeStorage::operator=", NM="_ZN5clang27PseudoDestructorTypeStorageaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang27PseudoDestructorTypeStorageaSEOS0_")
  //</editor-fold>
  public /*inline*/ PseudoDestructorTypeStorage /*&*/ $assignMove(final PseudoDestructorTypeStorage /*&&*/$Prm0) {
    this.Type.$assignMove($Prm0.Type);
    this.Location.$assignMove($Prm0.Location);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Type=" + Type // NOI18N
              + ", Location=" + Location; // NOI18N
  }
}
