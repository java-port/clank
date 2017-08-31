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
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstTypesRTTI.*;


/// \brief Wrapper for source info for functions.
//<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1255,
 FQN="clang::FunctionTypeLoc", NM="_ZN5clang15FunctionTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang15FunctionTypeLocE")
//</editor-fold>
public class FunctionTypeLoc extends /*public*/ Concrete$UnqualTypeLoc<FunctionTypeLoc, FunctionType, FunctionLocInfo> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::getLocalRangeBegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1260,
   FQN="clang::FunctionTypeLoc::getLocalRangeBegin", NM="_ZNK5clang15FunctionTypeLoc18getLocalRangeBeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang15FunctionTypeLoc18getLocalRangeBeginEv")
  //</editor-fold>
  public SourceLocation getLocalRangeBegin() /*const*/ {
    return new SourceLocation(getLocalData().LocalRangeBegin);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::setLocalRangeBegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1263,
   FQN="clang::FunctionTypeLoc::setLocalRangeBegin", NM="_ZN5clang15FunctionTypeLoc18setLocalRangeBeginENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang15FunctionTypeLoc18setLocalRangeBeginENS_14SourceLocationE")
  //</editor-fold>
  public void setLocalRangeBegin(SourceLocation L) {
    getLocalData().LocalRangeBegin.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::getLocalRangeEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1267,
   FQN="clang::FunctionTypeLoc::getLocalRangeEnd", NM="_ZNK5clang15FunctionTypeLoc16getLocalRangeEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang15FunctionTypeLoc16getLocalRangeEndEv")
  //</editor-fold>
  public SourceLocation getLocalRangeEnd() /*const*/ {
    return new SourceLocation(getLocalData().LocalRangeEnd);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::setLocalRangeEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1270,
   FQN="clang::FunctionTypeLoc::setLocalRangeEnd", NM="_ZN5clang15FunctionTypeLoc16setLocalRangeEndENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang15FunctionTypeLoc16setLocalRangeEndENS_14SourceLocationE")
  //</editor-fold>
  public void setLocalRangeEnd(SourceLocation L) {
    getLocalData().LocalRangeEnd.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1274,
   FQN="clang::FunctionTypeLoc::getLParenLoc", NM="_ZNK5clang15FunctionTypeLoc12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang15FunctionTypeLoc12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(this.getLocalData().LParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1277,
   FQN="clang::FunctionTypeLoc::setLParenLoc", NM="_ZN5clang15FunctionTypeLoc12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang15FunctionTypeLoc12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLParenLoc(SourceLocation Loc) {
    this.getLocalData().LParenLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1281,
   FQN="clang::FunctionTypeLoc::getRParenLoc", NM="_ZNK5clang15FunctionTypeLoc12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang15FunctionTypeLoc12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(this.getLocalData().RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1284,
   FQN="clang::FunctionTypeLoc::setRParenLoc", NM="_ZN5clang15FunctionTypeLoc12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang15FunctionTypeLoc12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation Loc) {
    this.getLocalData().RParenLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::getParensRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1288,
   FQN="clang::FunctionTypeLoc::getParensRange", NM="_ZNK5clang15FunctionTypeLoc14getParensRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang15FunctionTypeLoc14getParensRangeEv")
  //</editor-fold>
  public SourceRange getParensRange() /*const*/ {
    return new SourceRange(getLParenLoc(), getRParenLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::getParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1292,
   FQN="clang::FunctionTypeLoc::getParams", NM="_ZNK5clang15FunctionTypeLoc9getParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang15FunctionTypeLoc9getParamsEv")
  //</editor-fold>
  public ArrayRef<ParmVarDecl /*P*/ > getParams() /*const*/ {
    return llvm.makeArrayRef(getParmArray(), getNumParams());
  }

  
  // ParmVarDecls* are stored after Info, one for each parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::getParmArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1297,
   FQN="clang::FunctionTypeLoc::getParmArray", NM="_ZNK5clang15FunctionTypeLoc12getParmArrayEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang15FunctionTypeLoc12getParmArrayEv")
  //</editor-fold>
  public type$ptr<ParmVarDecl /*P*/ /*P*/> getParmArray() /*const*/ {
    return (type$ptr<ParmVarDecl /*P*/ /*P*/>)getExtraLocalData();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::getNumParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1301,
   FQN="clang::FunctionTypeLoc::getNumParams", NM="_ZNK5clang15FunctionTypeLoc12getNumParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang15FunctionTypeLoc12getNumParamsEv")
  //</editor-fold>
  public /*uint*/int getNumParams() /*const*/ {
    if (isa_FunctionNoProtoType(getTypePtr())) {
      return 0;
    }
    return cast_FunctionProtoType(getTypePtr()).getNumParams();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::getParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1306,
   FQN="clang::FunctionTypeLoc::getParam", NM="_ZNK5clang15FunctionTypeLoc8getParamEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang15FunctionTypeLoc8getParamEj")
  //</editor-fold>
  public ParmVarDecl /*P*/ getParam(/*uint*/int i) /*const*/ {
    return getParmArray().$at(i);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::setParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1307,
   FQN="clang::FunctionTypeLoc::setParam", NM="_ZN5clang15FunctionTypeLoc8setParamEjPNS_11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang15FunctionTypeLoc8setParamEjPNS_11ParmVarDeclE")
  //</editor-fold>
  public void setParam(/*uint*/int i, ParmVarDecl /*P*/ VD) {
    getParmArray().$set(i, VD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::getReturnLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1309,
   FQN="clang::FunctionTypeLoc::getReturnLoc", NM="_ZNK5clang15FunctionTypeLoc12getReturnLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang15FunctionTypeLoc12getReturnLocEv")
  //</editor-fold>
  public TypeLoc getReturnLoc() /*const*/ {
    return getInnerTypeLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1313,
   FQN="clang::FunctionTypeLoc::getLocalSourceRange", NM="_ZNK5clang15FunctionTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang15FunctionTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    return new SourceRange(getLocalRangeBegin(), getLocalRangeEnd());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::initializeLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1317,
   FQN="clang::FunctionTypeLoc::initializeLocal", NM="_ZN5clang15FunctionTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang15FunctionTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public void initializeLocal(final ASTContext /*&*/ Context, SourceLocation Loc) {
    setLocalRangeBegin(/*NO_COPY*/Loc);
    setLParenLoc(/*NO_COPY*/Loc);
    setRParenLoc(/*NO_COPY*/Loc);
    setLocalRangeEnd(/*NO_COPY*/Loc);
    for (/*uint*/int i = 0, e = getNumParams(); i != e; ++i)  {
      setParam(i, (ParmVarDecl /*P*/ )null);
    }
  }

  
  /// \brief Returns the size of the type source info data block that is
  /// specific to this type.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::getExtraLocalDataSize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1328,
   FQN="clang::FunctionTypeLoc::getExtraLocalDataSize", NM="_ZNK5clang15FunctionTypeLoc21getExtraLocalDataSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang15FunctionTypeLoc21getExtraLocalDataSizeEv")
  //</editor-fold>
  public /*uint*/int getExtraLocalDataSize() /*const*/ {
    return getNumParams() * (true/*JAVA*/ ? 1 : $sizeof_ptr_ParmVarDecl(/*ParmVarDecl P */));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::getExtraLocalDataAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1332,
   FQN="clang::FunctionTypeLoc::getExtraLocalDataAlignment", NM="_ZNK5clang15FunctionTypeLoc26getExtraLocalDataAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang15FunctionTypeLoc26getExtraLocalDataAlignmentEv")
  //</editor-fold>
  public /*uint*/int getExtraLocalDataAlignment() /*const*/ {
    return alignOf(ParmVarDecl.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::getInnerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1336,
   FQN="clang::FunctionTypeLoc::getInnerType", NM="_ZNK5clang15FunctionTypeLoc12getInnerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang15FunctionTypeLoc12getInnerTypeEv")
  //</editor-fold>
  public QualType getInnerType() /*const*/ {
    return getTypePtr().getReturnType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::FunctionTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1255,
   FQN="clang::FunctionTypeLoc::FunctionTypeLoc", NM="_ZN5clang15FunctionTypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang15FunctionTypeLocC1Ev")
  //</editor-fold>
  public /*inline*/ FunctionTypeLoc() {
    // : ConcreteTypeLoc<UnqualTypeLoc, FunctionTypeLoc, FunctionType, FunctionLocInfo>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::FunctionTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1255,
   FQN="clang::FunctionTypeLoc::FunctionTypeLoc", NM="_ZN5clang15FunctionTypeLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang15FunctionTypeLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ FunctionTypeLoc(final /*const*/ FunctionTypeLoc /*&*/ $Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, FunctionTypeLoc, FunctionType, FunctionLocInfo>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::FunctionTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1255,
   FQN="clang::FunctionTypeLoc::FunctionTypeLoc", NM="_ZN5clang15FunctionTypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang15FunctionTypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ FunctionTypeLoc(JD$Move _dparam, final FunctionTypeLoc /*&&*/$Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, FunctionTypeLoc, FunctionType, FunctionLocInfo>(static_cast<FunctionTypeLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTypeLoc::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1255,
   FQN="clang::FunctionTypeLoc::operator=", NM="_ZN5clang15FunctionTypeLocaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang15FunctionTypeLocaSEOS0_")
  //</editor-fold>
  public /*inline*/ FunctionTypeLoc /*&*/ $assignMove(final FunctionTypeLoc /*&&*/$Prm0) {
    /*Deref*/super.$assignMove($Prm0);
    return /*Deref*/this;
  }

  protected static int $sizeof_ptr_ParmVarDecl() { return 1; }
  
  @Override protected final FunctionLocInfo createJavaEmptyLocalTypeLocInfo() { return new FunctionLocInfo(); }
  
  @Override protected Class<? extends FunctionType> getTypeClass() { return FunctionType.class; }
  
  @Override protected final void initJavaExtraLocalData(type$ptr extraLocalData$Ptr, int NumExtra) {
    assert NumExtra == getNumParams() : "expect request for extra data for param pointers only";
    if (NativeTrace.isDebugMode()) {
      assert !NativeCloneable.class.isAssignableFrom(ParmVarDecl.class) : "(see TypeLoc.DATA_DEEP_COPY) ParmVarDecl must not be cloneable, otherwise we clone values vs. keep pointers ";
      // as extra data we keep ParmVarDecl pointers, check that array size is enough and contains nulls
      for (int idx = 0; idx < NumExtra; idx++) {
        assert extraLocalData$Ptr.$at(idx) == null : "must be not occupied placeholder for ParmVarDecl *";
      }
    }
  }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
