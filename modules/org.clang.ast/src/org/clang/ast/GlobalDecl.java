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
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.java.AstJavaDifferentiators.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// GlobalDecl - represents a global declaration. This can either be a
/// CXXConstructorDecl and the constructor type (Base, Complete).
/// a CXXDestructorDecl and the destructor type (Base, Complete) or
/// a VarDecl, a FunctionDecl or a BlockDecl.
//<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 29,
 FQN="clang::GlobalDecl", NM="_ZN5clang10GlobalDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang10GlobalDeclE")
//</editor-fold>
public class GlobalDecl implements NativeCloneable<GlobalDecl>, NativeHashable {
  private PointerIntPair</*const*/ Decl /*P*/ > Value;
  
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::Init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 32,
   FQN="clang::GlobalDecl::Init", NM="_ZN5clang10GlobalDecl4InitEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang10GlobalDecl4InitEPKNS_4DeclE")
  //</editor-fold>
  private void Init(/*const*/ Decl /*P*/ D) {
    assert (!isa_CXXConstructorDecl(D)) : "Use other ctor with ctor decls!";
    assert (!isa_CXXDestructorDecl(D)) : "Use other ctor with dtor decls!";
    
    Value.setPointer(D);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::GlobalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 40,
   FQN="clang::GlobalDecl::GlobalDecl", NM="_ZN5clang10GlobalDeclC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang10GlobalDeclC1Ev")
  //</editor-fold>
  public GlobalDecl() {
    // : Value() 
    //START JInit
    this.Value = new PointerIntPair</*const*/ Decl /*P*/ >();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::GlobalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 42,
   FQN="clang::GlobalDecl::GlobalDecl", NM="_ZN5clang10GlobalDeclC1EPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang10GlobalDeclC1EPKNS_7VarDeclE")
  //</editor-fold>
  public GlobalDecl(/*const*/ VarDecl /*P*/ D) {
    // : Value() 
    //START JInit
    this.Value = new PointerIntPair</*const*/ Decl /*P*/ >();
    //END JInit
    Init(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::GlobalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 43,
   FQN="clang::GlobalDecl::GlobalDecl", NM="_ZN5clang10GlobalDeclC1EPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang10GlobalDeclC1EPKNS_12FunctionDeclE")
  //</editor-fold>
  public GlobalDecl(/*const*/ FunctionDecl /*P*/ D) {
    // : Value() 
    //START JInit
    this.Value = new PointerIntPair</*const*/ Decl /*P*/ >();
    //END JInit
    Init(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::GlobalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 44,
   FQN="clang::GlobalDecl::GlobalDecl", NM="_ZN5clang10GlobalDeclC1EPKNS_9BlockDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang10GlobalDeclC1EPKNS_9BlockDeclE")
  //</editor-fold>
  public GlobalDecl(/*const*/ BlockDecl /*P*/ D) {
    // : Value() 
    //START JInit
    this.Value = new PointerIntPair</*const*/ Decl /*P*/ >();
    //END JInit
    Init(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::GlobalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 45,
   FQN="clang::GlobalDecl::GlobalDecl", NM="_ZN5clang10GlobalDeclC1EPKNS_12CapturedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang10GlobalDeclC1EPKNS_12CapturedDeclE")
  //</editor-fold>
  public GlobalDecl(/*const*/ CapturedDecl /*P*/ D) {
    // : Value() 
    //START JInit
    this.Value = new PointerIntPair</*const*/ Decl /*P*/ >();
    //END JInit
    Init(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::GlobalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 46,
   FQN="clang::GlobalDecl::GlobalDecl", NM="_ZN5clang10GlobalDeclC1EPKNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang10GlobalDeclC1EPKNS_14ObjCMethodDeclE")
  //</editor-fold>
  public GlobalDecl(/*const*/ ObjCMethodDecl /*P*/ D) {
    // : Value() 
    //START JInit
    this.Value = new PointerIntPair</*const*/ Decl /*P*/ >();
    //END JInit
    Init(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::GlobalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 47,
   FQN="clang::GlobalDecl::GlobalDecl", NM="_ZN5clang10GlobalDeclC1EPKNS_23OMPDeclareReductionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang10GlobalDeclC1EPKNS_23OMPDeclareReductionDeclE")
  //</editor-fold>
  public GlobalDecl(/*const*/ OMPDeclareReductionDecl /*P*/ D) {
    // : Value() 
    //START JInit
    this.Value = new PointerIntPair</*const*/ Decl /*P*/ >();
    //END JInit
    Init(D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::GlobalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 49,
   FQN="clang::GlobalDecl::GlobalDecl", NM="_ZN5clang10GlobalDeclC1EPKNS_18CXXConstructorDeclENS_11CXXCtorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang10GlobalDeclC1EPKNS_18CXXConstructorDeclENS_11CXXCtorTypeE")
  //</editor-fold>
  public GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType _dparam, /*const*/ CXXConstructorDecl /*P*/ D, CXXCtorType Type) {
    // : Value(D, Type) 
    //START JInit
    this.Value = new PointerIntPair</*const*/ Decl /*P*/ >(D, Type.getValue());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::GlobalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 51,
   FQN="clang::GlobalDecl::GlobalDecl", NM="_ZN5clang10GlobalDeclC1EPKNS_17CXXDestructorDeclENS_11CXXDtorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang10GlobalDeclC1EPKNS_17CXXDestructorDeclENS_11CXXDtorTypeE")
  //</editor-fold>
  public GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType _dparam, /*const*/ CXXDestructorDecl /*P*/ D, CXXDtorType Type) {
    // : Value(D, Type) 
    //START JInit
    this.Value = new PointerIntPair</*const*/ Decl /*P*/ >(D, Type.getValue());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 54,
   FQN="clang::GlobalDecl::getCanonicalDecl", NM="_ZNK5clang10GlobalDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang10GlobalDecl16getCanonicalDeclEv")
  //</editor-fold>
  public GlobalDecl getCanonicalDecl() /*const*/ {
    GlobalDecl CanonGD/*J*/= new GlobalDecl();
    CanonGD.Value.setPointer(Value.getPointer().getCanonicalDecl$Const());
    CanonGD.Value.setInt(Value.getInt());
    
    return CanonGD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 62,
   FQN="clang::GlobalDecl::getDecl", NM="_ZNK5clang10GlobalDecl7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang10GlobalDecl7getDeclEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getDecl() /*const*/ {
    return Value.getPointer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::getCtorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 64,
   FQN="clang::GlobalDecl::getCtorType", NM="_ZNK5clang10GlobalDecl11getCtorTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang10GlobalDecl11getCtorTypeEv")
  //</editor-fold>
  public CXXCtorType getCtorType() /*const*/ {
    assert (isa_CXXConstructorDecl(getDecl())) : "Decl is not a ctor!";
    return /*static_cast*/CXXCtorType.valueOf(Value.getInt());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::getDtorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 69,
   FQN="clang::GlobalDecl::getDtorType", NM="_ZNK5clang10GlobalDecl11getDtorTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang10GlobalDecl11getDtorTypeEv")
  //</editor-fold>
  public CXXDtorType getDtorType() /*const*/ {
    assert (isa_CXXDestructorDecl(getDecl())) : "Decl is not a dtor!";
    return /*static_cast*/CXXDtorType.valueOf(Value.getInt());
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 74,
   FQN="clang::operator==", NM="_ZN5clangeqERKNS_10GlobalDeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clangeqERKNS_10GlobalDeclES2_")
  //</editor-fold>
  public static boolean $eq_GlobalDecl$C(final /*const*/ GlobalDecl /*&*/ LHS, final /*const*/ GlobalDecl /*&*/ RHS) {
    return LHS.Value.$eq(RHS.Value);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::getAsOpaquePtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 78,
   FQN="clang::GlobalDecl::getAsOpaquePtr", NM="_ZNK5clang10GlobalDecl14getAsOpaquePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang10GlobalDecl14getAsOpaquePtrEv")
  //</editor-fold>
  public Object/*void P*/ getAsOpaquePtr() /*const*/ {
    return Value.getOpaqueValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::getFromOpaquePtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 80,
   FQN="clang::GlobalDecl::getFromOpaquePtr", NM="_ZN5clang10GlobalDecl16getFromOpaquePtrEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang10GlobalDecl16getFromOpaquePtrEPv")
  //</editor-fold>
  public static GlobalDecl getFromOpaquePtr(Object/*void P*/ P) {
    GlobalDecl GD/*J*/= new GlobalDecl();
    GD.Value.setFromOpaqueValue(P);
    return GD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::getWithDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 86,
   FQN="clang::GlobalDecl::getWithDecl", NM="_ZN5clang10GlobalDecl11getWithDeclEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang10GlobalDecl11getWithDeclEPKNS_4DeclE")
  //</editor-fold>
  public GlobalDecl getWithDecl(/*const*/ Decl /*P*/ D) {
    GlobalDecl Result/*J*/= new GlobalDecl(/*Deref*/this);
    Result.Value.setPointer(D);
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::GlobalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 29,
   FQN="clang::GlobalDecl::GlobalDecl", NM="_ZN5clang10GlobalDeclC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang10GlobalDeclC1ERKS0_")
  //</editor-fold>
  public /*inline*/ GlobalDecl(final /*const*/ GlobalDecl /*&*/ $Prm0) {
    // : Value(.Value) 
    //START JInit
    this.Value = new PointerIntPair</*const*/ Decl /*P*/ >($Prm0.Value);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::GlobalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 29,
   FQN="clang::GlobalDecl::GlobalDecl", NM="_ZN5clang10GlobalDeclC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang10GlobalDeclC1EOS0_")
  //</editor-fold>
  public /*inline*/ GlobalDecl(JD$Move _dparam, final GlobalDecl /*&&*/$Prm0) {
    // : Value(static_cast<GlobalDecl &&>().Value) 
    //START JInit
    this.Value = new PointerIntPair</*const*/ Decl /*P*/ >(JD$Move.INSTANCE, $Prm0.Value);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 29,
   FQN="clang::GlobalDecl::operator=", NM="_ZN5clang10GlobalDeclaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang10GlobalDeclaSERKS0_")
  //</editor-fold>
  public /*inline*/ GlobalDecl /*&*/ $assign(final /*const*/ GlobalDecl /*&*/ $Prm0) {
    this.Value.$assign($Prm0.Value);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GlobalDecl::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 29,
   FQN="clang::GlobalDecl::operator=", NM="_ZN5clang10GlobalDeclaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang10GlobalDeclaSEOS0_")
  //</editor-fold>
  public /*inline*/ GlobalDecl /*&*/ $assignMove(final GlobalDecl /*&&*/$Prm0) {
    this.Value.$assignMove($Prm0.Value);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

    @Override
    public GlobalDecl clone() {
      return new GlobalDecl(this);
    }
  
    @Override
    public int $hashcode() {
      return Value == null ? 0 : Value.$hashcode();
    }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Value=" + Value; // NOI18N
  }
}
