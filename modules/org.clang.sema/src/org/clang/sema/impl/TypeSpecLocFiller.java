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

package org.clang.sema.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.sema.impl.SemaTypeStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4821,
 FQN="(anonymous namespace)::TypeSpecLocFiller", NM="_ZN12_GLOBAL__N_117TypeSpecLocFillerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFillerE")
//</editor-fold>
public class TypeSpecLocFiller implements /*public*/ TypeLocVisitorVoid<TypeSpecLocFiller> {
  private final ASTContext /*&*/ Context;
  private final /*const*/ DeclSpec /*&*/ DS;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::TypeSpecLocFiller">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4826,
   FQN="(anonymous namespace)::TypeSpecLocFiller::TypeSpecLocFiller", NM="_ZN12_GLOBAL__N_117TypeSpecLocFillerC1ERN5clang10ASTContextERKNS1_8DeclSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFillerC1ERN5clang10ASTContextERKNS1_8DeclSpecE")
  //</editor-fold>
  public TypeSpecLocFiller(final ASTContext /*&*/ Context, final /*const*/ DeclSpec /*&*/ DS) {
    // : TypeLocVisitor<TypeSpecLocFiller>(), Context(Context), DS(DS) 
    //START JInit
    $TypeLocVisitor();
    this./*&*/Context=/*&*/Context;
    this./*&*/DS=/*&*/DS;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::VisitAttributedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4829,
   FQN="(anonymous namespace)::TypeSpecLocFiller::VisitAttributedTypeLoc", NM="_ZN12_GLOBAL__N_117TypeSpecLocFiller22VisitAttributedTypeLocEN5clang17AttributedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFiller22VisitAttributedTypeLocEN5clang17AttributedTypeLocE")
  //</editor-fold>
  public void VisitAttributedTypeLoc(AttributedTypeLoc TL) {
    fillAttributedTypeLoc(new AttributedTypeLoc(TL), DS.getAttributes$Const().getList());
    Visit(TL.getModifiedLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::VisitQualifiedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4833,
   FQN="(anonymous namespace)::TypeSpecLocFiller::VisitQualifiedTypeLoc", NM="_ZN12_GLOBAL__N_117TypeSpecLocFiller21VisitQualifiedTypeLocEN5clang16QualifiedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFiller21VisitQualifiedTypeLocEN5clang16QualifiedTypeLocE")
  //</editor-fold>
  public void VisitQualifiedTypeLoc(QualifiedTypeLoc TL) {
    Visit(TL.getUnqualifiedLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::VisitTypedefTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4836,
   FQN="(anonymous namespace)::TypeSpecLocFiller::VisitTypedefTypeLoc", NM="_ZN12_GLOBAL__N_117TypeSpecLocFiller19VisitTypedefTypeLocEN5clang14TypedefTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFiller19VisitTypedefTypeLocEN5clang14TypedefTypeLocE")
  //</editor-fold>
  public void VisitTypedefTypeLoc(TypedefTypeLoc TL) {
    TL.setNameLoc(DS.getTypeSpecTypeLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::VisitObjCInterfaceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4839,
   FQN="(anonymous namespace)::TypeSpecLocFiller::VisitObjCInterfaceTypeLoc", NM="_ZN12_GLOBAL__N_117TypeSpecLocFiller25VisitObjCInterfaceTypeLocEN5clang20ObjCInterfaceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFiller25VisitObjCInterfaceTypeLocEN5clang20ObjCInterfaceTypeLocE")
  //</editor-fold>
  public void VisitObjCInterfaceTypeLoc(ObjCInterfaceTypeLoc TL) {
    TL.setNameLoc(DS.getTypeSpecTypeLoc());
    // FIXME. We should have DS.getTypeSpecTypeEndLoc(). But, it requires
    // addition field. What we have is good enough for dispay of location
    // of 'fixit' on interface name.
    TL.setNameEndLoc(DS.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::VisitObjCObjectTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4846,
   FQN="(anonymous namespace)::TypeSpecLocFiller::VisitObjCObjectTypeLoc", NM="_ZN12_GLOBAL__N_117TypeSpecLocFiller22VisitObjCObjectTypeLocEN5clang17ObjCObjectTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFiller22VisitObjCObjectTypeLocEN5clang17ObjCObjectTypeLocE")
  //</editor-fold>
  public void VisitObjCObjectTypeLoc(ObjCObjectTypeLoc TL) {
    type$ptr<TypeSourceInfo /*P*/ > RepTInfo = create_type$null$ptr(null);
    Sema.GetTypeFromParser(DS.getRepAsType(), $AddrOf(RepTInfo));
    TL.copy(RepTInfo.$star().getTypeLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::VisitObjCObjectPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4851,
   FQN="(anonymous namespace)::TypeSpecLocFiller::VisitObjCObjectPointerTypeLoc", NM="_ZN12_GLOBAL__N_117TypeSpecLocFiller29VisitObjCObjectPointerTypeLocEN5clang24ObjCObjectPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFiller29VisitObjCObjectPointerTypeLocEN5clang24ObjCObjectPointerTypeLocE")
  //</editor-fold>
  public void VisitObjCObjectPointerTypeLoc(ObjCObjectPointerTypeLoc TL) {
    type$ptr<TypeSourceInfo /*P*/ > RepTInfo = create_type$null$ptr(null);
    Sema.GetTypeFromParser(DS.getRepAsType(), $AddrOf(RepTInfo));
    TL.copy(RepTInfo.$star().getTypeLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::VisitTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4856,
   FQN="(anonymous namespace)::TypeSpecLocFiller::VisitTemplateSpecializationTypeLoc", NM="_ZN12_GLOBAL__N_117TypeSpecLocFiller34VisitTemplateSpecializationTypeLocEN5clang29TemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFiller34VisitTemplateSpecializationTypeLocEN5clang29TemplateSpecializationTypeLocE")
  //</editor-fold>
  public void VisitTemplateSpecializationTypeLoc(TemplateSpecializationTypeLoc TL) {
    type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr(null);
    Sema.GetTypeFromParser(DS.getRepAsType(), $AddrOf(TInfo));
    
    // If we got no declarator info from previous Sema routines,
    // just fill with the typespec loc.
    if (!(TInfo.$star() != null)) {
      TL.initialize(Context, DS.getTypeSpecTypeNameLoc());
      return;
    }
    
    TypeLoc OldTL = TInfo.$star().getTypeLoc();
    if ((TInfo.$star().getType().$arrow().getAs(ElaboratedType.class) != null)) {
      ElaboratedTypeLoc ElabTL = OldTL.castAs(ElaboratedTypeLoc.class);
      TemplateSpecializationTypeLoc NamedTL = ElabTL.getNamedTypeLoc().castAs(TemplateSpecializationTypeLoc.class);
      TL.copy(new TemplateSpecializationTypeLoc(NamedTL));
    } else {
      TL.copy(OldTL.castAs(TemplateSpecializationTypeLoc.class));
      assert ($eq_SourceLocation$C(TL.getRAngleLoc(), OldTL.castAs(TemplateSpecializationTypeLoc.class).getRAngleLoc()));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::VisitTypeOfExprTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4879,
   FQN="(anonymous namespace)::TypeSpecLocFiller::VisitTypeOfExprTypeLoc", NM="_ZN12_GLOBAL__N_117TypeSpecLocFiller22VisitTypeOfExprTypeLocEN5clang17TypeOfExprTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFiller22VisitTypeOfExprTypeLocEN5clang17TypeOfExprTypeLocE")
  //</editor-fold>
  public void VisitTypeOfExprTypeLoc(TypeOfExprTypeLoc TL) {
    assert (DS.getTypeSpecType() == DeclSpec.TST_typeofExpr);
    TL.setTypeofLoc(DS.getTypeSpecTypeLoc());
    TL.setParensRange(DS.getTypeofParensRange());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::VisitTypeOfTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4884,
   FQN="(anonymous namespace)::TypeSpecLocFiller::VisitTypeOfTypeLoc", NM="_ZN12_GLOBAL__N_117TypeSpecLocFiller18VisitTypeOfTypeLocEN5clang13TypeOfTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFiller18VisitTypeOfTypeLocEN5clang13TypeOfTypeLocE")
  //</editor-fold>
  public void VisitTypeOfTypeLoc(TypeOfTypeLoc TL) {
    assert (DS.getTypeSpecType() == DeclSpec.TST_typeofType);
    TL.setTypeofLoc(DS.getTypeSpecTypeLoc());
    TL.setParensRange(DS.getTypeofParensRange());
    assert ((DS.getRepAsType()).$bool());
    type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr(null);
    Sema.GetTypeFromParser(DS.getRepAsType(), $AddrOf(TInfo));
    TL.setUnderlyingTInfo(TInfo.$star());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::VisitUnaryTransformTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4893,
   FQN="(anonymous namespace)::TypeSpecLocFiller::VisitUnaryTransformTypeLoc", NM="_ZN12_GLOBAL__N_117TypeSpecLocFiller26VisitUnaryTransformTypeLocEN5clang21UnaryTransformTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFiller26VisitUnaryTransformTypeLocEN5clang21UnaryTransformTypeLocE")
  //</editor-fold>
  public void VisitUnaryTransformTypeLoc(UnaryTransformTypeLoc TL) {
    // FIXME: This holds only because we only have one unary transform.
    assert (DS.getTypeSpecType() == DeclSpec.TST_underlyingType);
    TL.setKWLoc(DS.getTypeSpecTypeLoc());
    TL.setParensRange(DS.getTypeofParensRange());
    assert ((DS.getRepAsType()).$bool());
    type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr(null);
    Sema.GetTypeFromParser(DS.getRepAsType(), $AddrOf(TInfo));
    TL.setUnderlyingTInfo(TInfo.$star());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::VisitBuiltinTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4903,
   FQN="(anonymous namespace)::TypeSpecLocFiller::VisitBuiltinTypeLoc", NM="_ZN12_GLOBAL__N_117TypeSpecLocFiller19VisitBuiltinTypeLocEN5clang14BuiltinTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFiller19VisitBuiltinTypeLocEN5clang14BuiltinTypeLocE")
  //</editor-fold>
  public void VisitBuiltinTypeLoc(BuiltinTypeLoc TL) {
    // By default, use the source location of the type specifier.
    TL.setBuiltinLoc(DS.getTypeSpecTypeLoc());
    if (TL.needsExtraLocalData()) {
      // Set info for the written builtin specifiers.
      TL.getWrittenBuiltinSpecs().$assign(DS.getWrittenBuiltinSpecs());
      // Try to have a meaningful source location.
      if (TL.getWrittenSignSpec() != TypeSpecifierSign.TSS_unspecified) {
        // Sign spec loc overrides the others (e.g., 'unsigned long').
        TL.setBuiltinLoc(DS.getTypeSpecSignLoc());
      } else if (TL.getWrittenWidthSpec() != TypeSpecifierWidth.TSW_unspecified) {
        // Width spec loc overrides type spec loc (e.g., 'short int').
        TL.setBuiltinLoc(DS.getTypeSpecWidthLoc());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::VisitElaboratedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4918,
   FQN="(anonymous namespace)::TypeSpecLocFiller::VisitElaboratedTypeLoc", NM="_ZN12_GLOBAL__N_117TypeSpecLocFiller22VisitElaboratedTypeLocEN5clang17ElaboratedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFiller22VisitElaboratedTypeLocEN5clang17ElaboratedTypeLocE")
  //</editor-fold>
  public void VisitElaboratedTypeLoc(ElaboratedTypeLoc TL) {
    ElaboratedTypeKeyword Keyword = TypeWithKeyword.getKeywordForTypeSpec(DS.getTypeSpecType().getValue());
    if (DS.getTypeSpecType() == TypeSpecifierType.TST_typename) {
      type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr(null);
      Sema.GetTypeFromParser(DS.getRepAsType(), $AddrOf(TInfo));
      if ((TInfo.$star() != null)) {
        TL.copy(TInfo.$star().getTypeLoc().castAs(ElaboratedTypeLoc.class));
        return;
      }
    }
    TL.setElaboratedKeywordLoc(Keyword != ElaboratedTypeKeyword.ETK_None ? DS.getTypeSpecTypeLoc() : new SourceLocation());
    final /*const*/ CXXScopeSpec /*&*/ SS = DS.getTypeSpecScope$Const();
    TL.setQualifierLoc(SS.getWithLocInContext(Context));
    Visit(TL.getNextTypeLoc().getUnqualifiedLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::VisitDependentNameTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4936,
   FQN="(anonymous namespace)::TypeSpecLocFiller::VisitDependentNameTypeLoc", NM="_ZN12_GLOBAL__N_117TypeSpecLocFiller25VisitDependentNameTypeLocEN5clang20DependentNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFiller25VisitDependentNameTypeLocEN5clang20DependentNameTypeLocE")
  //</editor-fold>
  public void VisitDependentNameTypeLoc(DependentNameTypeLoc TL) {
    assert (DS.getTypeSpecType() == TypeSpecifierType.TST_typename);
    type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr(null);
    Sema.GetTypeFromParser(DS.getRepAsType(), $AddrOf(TInfo));
    assert Native.$bool(TInfo);
    TL.copy(TInfo.$star().getTypeLoc().castAs(DependentNameTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::VisitDependentTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4943,
   FQN="(anonymous namespace)::TypeSpecLocFiller::VisitDependentTemplateSpecializationTypeLoc", NM="_ZN12_GLOBAL__N_117TypeSpecLocFiller43VisitDependentTemplateSpecializationTypeLocEN5clang38DependentTemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFiller43VisitDependentTemplateSpecializationTypeLocEN5clang38DependentTemplateSpecializationTypeLocE")
  //</editor-fold>
  public void VisitDependentTemplateSpecializationTypeLoc(DependentTemplateSpecializationTypeLoc TL) {
    assert (DS.getTypeSpecType() == TypeSpecifierType.TST_typename);
    type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr(null);
    Sema.GetTypeFromParser(DS.getRepAsType(), $AddrOf(TInfo));
    assert Native.$bool(TInfo);
    TL.copy(TInfo.$star().getTypeLoc().castAs(DependentTemplateSpecializationTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::VisitTagTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4952,
   FQN="(anonymous namespace)::TypeSpecLocFiller::VisitTagTypeLoc", NM="_ZN12_GLOBAL__N_117TypeSpecLocFiller15VisitTagTypeLocEN5clang10TagTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFiller15VisitTagTypeLocEN5clang10TagTypeLocE")
  //</editor-fold>
  public void VisitTagTypeLoc(TagTypeLoc TL) {
    TL.setNameLoc(DS.getTypeSpecTypeNameLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::VisitAtomicTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4955,
   FQN="(anonymous namespace)::TypeSpecLocFiller::VisitAtomicTypeLoc", NM="_ZN12_GLOBAL__N_117TypeSpecLocFiller18VisitAtomicTypeLocEN5clang13AtomicTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFiller18VisitAtomicTypeLocEN5clang13AtomicTypeLocE")
  //</editor-fold>
  public void VisitAtomicTypeLoc(AtomicTypeLoc TL) {
    // An AtomicTypeLoc can come from either an _Atomic(...) type specifier
    // or an _Atomic qualifier.
    if (DS.getTypeSpecType() == DeclSpec.TST_atomic) {
      TL.setKWLoc(DS.getTypeSpecTypeLoc());
      TL.setParensRange(DS.getTypeofParensRange());
      
      type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr(null);
      Sema.GetTypeFromParser(DS.getRepAsType(), $AddrOf(TInfo));
      assert Native.$bool(TInfo);
      TL.getValueLoc().initializeFullCopy(TInfo.$star().getTypeLoc());
    } else {
      TL.setKWLoc(DS.getAtomicSpecLoc());
      // No parens, to indicate this was spelled as an _Atomic qualifier.
      TL.setParensRange(new SourceRange());
      Visit(TL.getValueLoc());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::VisitPipeTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4974,
   FQN="(anonymous namespace)::TypeSpecLocFiller::VisitPipeTypeLoc", NM="_ZN12_GLOBAL__N_117TypeSpecLocFiller16VisitPipeTypeLocEN5clang11PipeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFiller16VisitPipeTypeLocEN5clang11PipeTypeLocE")
  //</editor-fold>
  public void VisitPipeTypeLoc(PipeTypeLoc TL) {
    TL.setKWLoc(DS.getTypeSpecTypeLoc());
    
    type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr(null);
    Sema.GetTypeFromParser(DS.getRepAsType(), $AddrOf(TInfo));
    TL.getValueLoc().initializeFullCopy(TInfo.$star().getTypeLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSpecLocFiller::VisitTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4982,
   FQN="(anonymous namespace)::TypeSpecLocFiller::VisitTypeLoc", NM="_ZN12_GLOBAL__N_117TypeSpecLocFiller12VisitTypeLocEN5clang7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_117TypeSpecLocFiller12VisitTypeLocEN5clang7TypeLocE")
  //</editor-fold>
  public void VisitTypeLoc(TypeLoc TL) {
    // FIXME: add other typespec types and change this to an assert.
    TL.initialize(Context, DS.getTypeSpecTypeLoc());
  }

  
  @Override public String toString() {
    return "" + "Context=" + "[ASTContext]" // NOI18N
              + ", DS=" + DS // NOI18N
              + super.toString(); // NOI18N
  }
}
