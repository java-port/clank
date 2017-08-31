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
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.DeclContext.*;
import org.clank.java.std;
import org.llvm.support.TrailingObjects.*;


/// \brief This represents the body of a CapturedStmt, and serves as its
/// DeclContext.
//<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3625,
 FQN="clang::CapturedDecl", NM="_ZN5clang12CapturedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12CapturedDeclE")
//</editor-fold>
public final class CapturedDecl extends /*public*/ Decl implements /*public*/ DeclContext, /*private*/ TrailingObjects<CapturedDecl, ImplicitParamDecl /*P*/ >, Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3630,
   FQN="clang::CapturedDecl::numTrailingObjects", NM="_ZN5clang12CapturedDecl18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_17ImplicitParamDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12CapturedDecl18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_17ImplicitParamDeclEEE")
  //</editor-fold>
  protected /*size_t*/int numTrailingObjects(OverloadToken<ImplicitParamDecl> $Prm0) {
    return NumParams;
  }

/*private:*/
  /// \brief The number of parameters to the outlined function.
  /*friend*/public /*uint*/int NumParams;
  /// \brief The position of context parameter in list of parameters.
  private /*uint*/int ContextParam;
  /// \brief The body of the outlined function.
  private PointerBoolPair<Stmt /*P*/ > BodyAndNothrow;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::CapturedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4058,
   FQN="clang::CapturedDecl::CapturedDecl", NM="_ZN5clang12CapturedDeclC1EPNS_11DeclContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12CapturedDeclC1EPNS_11DeclContextEj")
  //</editor-fold>
  private CapturedDecl(DeclContext /*P*/ DC, /*uint*/int NumParams) {
    // : Decl(Captured, DC, SourceLocation()), DeclContext(Captured), TrailingObjects<CapturedDecl, ImplicitParamDecl * >(), NumParams(NumParams), ContextParam(0), BodyAndNothrow(null, false) 
    //START JInit
    super(Kind.Captured, DC, new SourceLocation());
    this.DeclContext$Flds = $DeclContext(Kind.Captured);
    $TrailingObjects();
    this.NumParams = NumParams;
    this.ContextParam = 0;
    this.BodyAndNothrow = new PointerBoolPair<Stmt /*P*/ >((Stmt /*P*/ )null, false);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::getParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3644,
   FQN="clang::CapturedDecl::getParams", NM="_ZNK5clang12CapturedDecl9getParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12CapturedDecl9getParamsEv")
  //</editor-fold>
  private type$ptr<ImplicitParamDecl /*P*/ /*const*/ /*P*/> getParams$Const() /*const*/ {
    return getTrailingObjects$Const(ImplicitParamDecl /*P*/.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::getParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3648,
   FQN="clang::CapturedDecl::getParams", NM="_ZN5clang12CapturedDecl9getParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12CapturedDecl9getParamsEv")
  //</editor-fold>
  private type$ptr<ImplicitParamDecl /*P*/ /*P*/> getParams() {
    return getTrailingObjects(ImplicitParamDecl /*P*/.class);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4062,
   FQN="clang::CapturedDecl::Create", NM="_ZN5clang12CapturedDecl6CreateERNS_10ASTContextEPNS_11DeclContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12CapturedDecl6CreateERNS_10ASTContextEPNS_11DeclContextEj")
  //</editor-fold>
  public static CapturedDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        /*uint*/int NumParams) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC, additionalSizeToAlloc<ImplicitParamDecl *>(NumParams))*/ Decl.$new(C, DC, TrailingObjects.additionalSizeToAlloc$Same(ImplicitParamDecl.class, NumParams), (type$ptr<?> New$Mem)->{
        return new CapturedDecl(DC, NumParams);
     },
        new std.pairIntPtr<>(NumParams, ()->null) // for ImplicitParamDecl *
    );
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4068,
   FQN="clang::CapturedDecl::CreateDeserialized", NM="_ZN5clang12CapturedDecl18CreateDeserializedERNS_10ASTContextEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12CapturedDecl18CreateDeserializedERNS_10ASTContextEjj")
  //</editor-fold>
  public static CapturedDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID, 
                    /*uint*/int NumParams) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID, additionalSizeToAlloc<ImplicitParamDecl *>(NumParams))*/ Decl.$new(C, ID, TrailingObjects.additionalSizeToAlloc$Same(ImplicitParamDecl.class, NumParams), (type$ptr<?> New$Mem)->{
        return new CapturedDecl((DeclContext /*P*/ )null, NumParams);
     },
        new std.pairIntPtr<>(NumParams, ()->null) // for ImplicitParamDecl *
    );
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4074,
   FQN="clang::CapturedDecl::getBody", NM="_ZNK5clang12CapturedDecl7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12CapturedDecl7getBodyEv")
  //</editor-fold>
  @Override public Stmt /*P*/ getBody() /*const*//* override*/ {
    return BodyAndNothrow.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::setBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4075,
   FQN="clang::CapturedDecl::setBody", NM="_ZN5clang12CapturedDecl7setBodyEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12CapturedDecl7setBodyEPNS_4StmtE")
  //</editor-fold>
  public void setBody(Stmt /*P*/ B) {
    BodyAndNothrow.setPointer(B);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::isNothrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4077,
   FQN="clang::CapturedDecl::isNothrow", NM="_ZNK5clang12CapturedDecl9isNothrowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12CapturedDecl9isNothrowEv")
  //</editor-fold>
  public boolean isNothrow() /*const*/ {
    return BodyAndNothrow.getInt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::setNothrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4078,
   FQN="clang::CapturedDecl::setNothrow", NM="_ZN5clang12CapturedDecl10setNothrowEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12CapturedDecl10setNothrowEb")
  //</editor-fold>
  public void setNothrow() {
    setNothrow(true);
  }
  public void setNothrow(boolean Nothrow/*= true*/) {
    BodyAndNothrow.setInt(Nothrow);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::getNumParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3664,
   FQN="clang::CapturedDecl::getNumParams", NM="_ZNK5clang12CapturedDecl12getNumParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12CapturedDecl12getNumParamsEv")
  //</editor-fold>
  public /*uint*/int getNumParams() /*const*/ {
    return NumParams;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::getParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3666,
   FQN="clang::CapturedDecl::getParam", NM="_ZNK5clang12CapturedDecl8getParamEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12CapturedDecl8getParamEj")
  //</editor-fold>
  public ImplicitParamDecl /*P*/ getParam(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, NumParams));
    return getParams$Const().$at(i);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::setParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3670,
   FQN="clang::CapturedDecl::setParam", NM="_ZN5clang12CapturedDecl8setParamEjPNS_17ImplicitParamDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12CapturedDecl8setParamEjPNS_17ImplicitParamDeclE")
  //</editor-fold>
  public void setParam(/*uint*/int i, ImplicitParamDecl /*P*/ P) {
    assert ($less_uint(i, NumParams));
    getParams().$set(i, P);
  }

  
  // ArrayRef interface to parameters.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::parameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3676,
   FQN="clang::CapturedDecl::parameters", NM="_ZNK5clang12CapturedDecl10parametersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12CapturedDecl10parametersEv")
  //</editor-fold>
  public ArrayRef<ImplicitParamDecl /*P*/ > parameters$Const() /*const*/ {
    return /*{ */new ArrayRef<ImplicitParamDecl /*P*/ >(getParams$Const(), getNumParams(), true)/* }*/;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::parameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3679,
   FQN="clang::CapturedDecl::parameters", NM="_ZN5clang12CapturedDecl10parametersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12CapturedDecl10parametersEv")
  //</editor-fold>
  public MutableArrayRef<ImplicitParamDecl /*P*/ > parameters() {
    return /*{ */new MutableArrayRef<ImplicitParamDecl /*P*/ >(getParams(), getNumParams(), true)/* }*/;
  }

  
  /// \brief Retrieve the parameter containing captured variables.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::getContextParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3684,
   FQN="clang::CapturedDecl::getContextParam", NM="_ZNK5clang12CapturedDecl15getContextParamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12CapturedDecl15getContextParamEv")
  //</editor-fold>
  public ImplicitParamDecl /*P*/ getContextParam() /*const*/ {
    assert ($less_uint(ContextParam, NumParams));
    return getParam(ContextParam);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::setContextParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3688,
   FQN="clang::CapturedDecl::setContextParam", NM="_ZN5clang12CapturedDecl15setContextParamEjPNS_17ImplicitParamDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12CapturedDecl15setContextParamEjPNS_17ImplicitParamDeclE")
  //</editor-fold>
  public void setContextParam(/*uint*/int i, ImplicitParamDecl /*P*/ P) {
    assert ($less_uint(i, NumParams));
    ContextParam = i;
    setParam(i, P);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::getContextParamPosition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3693,
   FQN="clang::CapturedDecl::getContextParamPosition", NM="_ZNK5clang12CapturedDecl23getContextParamPositionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12CapturedDecl23getContextParamPositionEv")
  //</editor-fold>
  public /*uint*/int getContextParamPosition() /*const*/ {
    return ContextParam;
  }

  
  /*typedef ImplicitParamDecl *const *param_iterator*/
//  public final class param_iterator extends type$ptr<ImplicitParamDecl /*P*/ /*const*/ /*P*/>{ };
  /*typedef llvm::iterator_range<param_iterator> param_range*/
//  public final class param_range extends iterator_range<ImplicitParamDecl /*P*/ /*const*/>{ };
  
  /// \brief Retrieve an iterator pointing to the first parameter decl.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::param_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3699,
   FQN="clang::CapturedDecl::param_begin", NM="_ZNK5clang12CapturedDecl11param_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12CapturedDecl11param_beginEv")
  //</editor-fold>
  public type$ptr<ImplicitParamDecl /*P*/ /*const*/ /*P*/> param_begin() /*const*/ {
    return getParams$Const();
  }

  /// \brief Retrieve an iterator one past the last parameter decl.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::param_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3701,
   FQN="clang::CapturedDecl::param_end", NM="_ZNK5clang12CapturedDecl9param_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12CapturedDecl9param_endEv")
  //</editor-fold>
  public type$ptr<ImplicitParamDecl /*P*/ /*const*/ /*P*/> param_end() /*const*/ {
    return getParams$Const().$add(NumParams);
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3704,
   FQN="clang::CapturedDecl::classof", NM="_ZN5clang12CapturedDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12CapturedDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3705,
   FQN="clang::CapturedDecl::classofKind", NM="_ZN5clang12CapturedDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12CapturedDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.Captured;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::castToDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3706,
   FQN="clang::CapturedDecl::castToDeclContext", NM="_ZN5clang12CapturedDecl17castToDeclContextEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12CapturedDecl17castToDeclContextEPKS0_")
  //</editor-fold>
  public static DeclContext /*P*/ castToDeclContext(/*const*/ CapturedDecl /*P*/ D) {
    return ((/*static_cast*/DeclContext /*P*/ )(((/*const_cast*/CapturedDecl /*P*/ )(D))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::castFromDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3709,
   FQN="clang::CapturedDecl::castFromDeclContext", NM="_ZN5clang12CapturedDecl19castFromDeclContextEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12CapturedDecl19castFromDeclContextEPKNS_11DeclContextE")
  //</editor-fold>
  public static CapturedDecl /*P*/ castFromDeclContext(/*const*/ DeclContext /*P*/ DC) {
    return ((/*static_cast*/CapturedDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(DC))));
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  /*friend  TrailingObjects<CapturedDecl, ImplicitParamDecl *>*/
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedDecl::~CapturedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3625,
   FQN="clang::CapturedDecl::~CapturedDecl", NM="_ZN5clang12CapturedDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12CapturedDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    DeclContext.super.$destroy$DeclContext();
    TrailingObjects.super.$destroy$TrailingObjects();
  }

  
  private final DeclContext$Fields DeclContext$Flds;// use return value of $DeclContext();
  @Override public final DeclContext$Fields $DeclContext$Fields() { return DeclContext$Flds; }
  
  @Override
  public type$ptr<?> $TrailingObjects() {
    return $This$Ptr().$add(1); // skip this class
  }

  @Override
  public int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == ImplicitParamDecl.class;
    return 0;
  }

  @Override public String toString() {
    return "" + "NumParams=" + NumParams // NOI18N
              + ", ContextParam=" + ContextParam // NOI18N
              + ", BodyAndNothrow=" + BodyAndNothrow // NOI18N
              + super.toString(); // NOI18N
  }
}
