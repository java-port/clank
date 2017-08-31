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

import org.clank.support.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.impl.SemaTypeStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaratorLocFiller">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4988,
 FQN="(anonymous namespace)::DeclaratorLocFiller", NM="_ZN12_GLOBAL__N_119DeclaratorLocFillerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119DeclaratorLocFillerE")
//</editor-fold>
public class DeclaratorLocFiller implements /*public*/ TypeLocVisitorVoid<DeclaratorLocFiller> {
  private final ASTContext /*&*/ Context;
  private final /*const*/ DeclaratorChunk /*&*/ Chunk;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaratorLocFiller::DeclaratorLocFiller">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4993,
   FQN="(anonymous namespace)::DeclaratorLocFiller::DeclaratorLocFiller", NM="_ZN12_GLOBAL__N_119DeclaratorLocFillerC1ERN5clang10ASTContextERKNS1_15DeclaratorChunkE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119DeclaratorLocFillerC1ERN5clang10ASTContextERKNS1_15DeclaratorChunkE")
  //</editor-fold>
  public DeclaratorLocFiller(final ASTContext /*&*/ Context, final /*const*/ DeclaratorChunk /*&*/ Chunk) {
    // : TypeLocVisitor<DeclaratorLocFiller>(), Context(Context), Chunk(Chunk) 
    //START JInit
    $TypeLocVisitor();
    this./*&*/Context=/*&*/Context;
    this./*&*/Chunk=/*&*/Chunk;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaratorLocFiller::VisitQualifiedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4996,
   FQN="(anonymous namespace)::DeclaratorLocFiller::VisitQualifiedTypeLoc", NM="_ZN12_GLOBAL__N_119DeclaratorLocFiller21VisitQualifiedTypeLocEN5clang16QualifiedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119DeclaratorLocFiller21VisitQualifiedTypeLocEN5clang16QualifiedTypeLocE")
  //</editor-fold>
  public void VisitQualifiedTypeLoc(QualifiedTypeLoc TL) {
    throw new llvm_unreachable("qualified type locs not expected here!");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaratorLocFiller::VisitDecayedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4999,
   FQN="(anonymous namespace)::DeclaratorLocFiller::VisitDecayedTypeLoc", NM="_ZN12_GLOBAL__N_119DeclaratorLocFiller19VisitDecayedTypeLocEN5clang14DecayedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119DeclaratorLocFiller19VisitDecayedTypeLocEN5clang14DecayedTypeLocE")
  //</editor-fold>
  public void VisitDecayedTypeLoc(DecayedTypeLoc TL) {
    throw new llvm_unreachable("decayed type locs not expected here!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaratorLocFiller::VisitAttributedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5003,
   FQN="(anonymous namespace)::DeclaratorLocFiller::VisitAttributedTypeLoc", NM="_ZN12_GLOBAL__N_119DeclaratorLocFiller22VisitAttributedTypeLocEN5clang17AttributedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119DeclaratorLocFiller22VisitAttributedTypeLocEN5clang17AttributedTypeLocE")
  //</editor-fold>
  public void VisitAttributedTypeLoc(AttributedTypeLoc TL) {
    fillAttributedTypeLoc(new AttributedTypeLoc(TL), Chunk.getAttrs());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaratorLocFiller::VisitAdjustedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5006,
   FQN="(anonymous namespace)::DeclaratorLocFiller::VisitAdjustedTypeLoc", NM="_ZN12_GLOBAL__N_119DeclaratorLocFiller20VisitAdjustedTypeLocEN5clang15AdjustedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119DeclaratorLocFiller20VisitAdjustedTypeLocEN5clang15AdjustedTypeLocE")
  //</editor-fold>
  public void VisitAdjustedTypeLoc(AdjustedTypeLoc TL) {
    // nothing
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaratorLocFiller::VisitBlockPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5009,
   FQN="(anonymous namespace)::DeclaratorLocFiller::VisitBlockPointerTypeLoc", NM="_ZN12_GLOBAL__N_119DeclaratorLocFiller24VisitBlockPointerTypeLocEN5clang19BlockPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119DeclaratorLocFiller24VisitBlockPointerTypeLocEN5clang19BlockPointerTypeLocE")
  //</editor-fold>
  public void VisitBlockPointerTypeLoc(BlockPointerTypeLoc TL) {
    assert (Chunk.Kind == DeclaratorChunk.Unnamed_enum.BlockPointer);
    TL.setCaretLoc(new SourceLocation(Chunk.Loc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaratorLocFiller::VisitPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5013,
   FQN="(anonymous namespace)::DeclaratorLocFiller::VisitPointerTypeLoc", NM="_ZN12_GLOBAL__N_119DeclaratorLocFiller19VisitPointerTypeLocEN5clang14PointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119DeclaratorLocFiller19VisitPointerTypeLocEN5clang14PointerTypeLocE")
  //</editor-fold>
  public void VisitPointerTypeLoc(PointerTypeLoc TL) {
    assert (Chunk.Kind == DeclaratorChunk.Unnamed_enum.Pointer);
    TL.setStarLoc(new SourceLocation(Chunk.Loc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaratorLocFiller::VisitObjCObjectPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5017,
   FQN="(anonymous namespace)::DeclaratorLocFiller::VisitObjCObjectPointerTypeLoc", NM="_ZN12_GLOBAL__N_119DeclaratorLocFiller29VisitObjCObjectPointerTypeLocEN5clang24ObjCObjectPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119DeclaratorLocFiller29VisitObjCObjectPointerTypeLocEN5clang24ObjCObjectPointerTypeLocE")
  //</editor-fold>
  public void VisitObjCObjectPointerTypeLoc(ObjCObjectPointerTypeLoc TL) {
    assert (Chunk.Kind == DeclaratorChunk.Unnamed_enum.Pointer);
    TL.setStarLoc(new SourceLocation(Chunk.Loc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaratorLocFiller::VisitMemberPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5021,
   FQN="(anonymous namespace)::DeclaratorLocFiller::VisitMemberPointerTypeLoc", NM="_ZN12_GLOBAL__N_119DeclaratorLocFiller25VisitMemberPointerTypeLocEN5clang20MemberPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119DeclaratorLocFiller25VisitMemberPointerTypeLocEN5clang20MemberPointerTypeLocE")
  //</editor-fold>
  public void VisitMemberPointerTypeLoc(MemberPointerTypeLoc TL) {
    assert (Chunk.Kind == DeclaratorChunk.Unnamed_enum.MemberPointer);
    final /*const*/ CXXScopeSpec /*&*/ SS = Chunk.Unnamed_field3.Mem.Scope$Const();
    NestedNameSpecifierLoc NNSLoc = SS.getWithLocInContext(Context);
    
    /*const*/ Type /*P*/ ClsTy = TL.__getClass();
    QualType ClsQT = new QualType(ClsTy, 0);
    TypeSourceInfo /*P*/ ClsTInfo = Context.CreateTypeSourceInfo(new QualType(ClsQT), 0);
    // Now copy source location info into the type loc component.
    TypeLoc ClsTL = ClsTInfo.getTypeLoc();
    switch (NNSLoc.getNestedNameSpecifier().getKind()) {
     case Identifier:
      assert (isa_DependentNameType(ClsTy)) : "Unexpected TypeLoc";
      {
        DependentNameTypeLoc DNTLoc = ClsTL.castAs(DependentNameTypeLoc.class);
        DNTLoc.setElaboratedKeywordLoc(new SourceLocation());
        DNTLoc.setQualifierLoc(NNSLoc.getPrefix());
        DNTLoc.setNameLoc(NNSLoc.getLocalBeginLoc());
      }
      break;
     case TypeSpec:
     case TypeSpecWithTemplate:
      if (isa_ElaboratedType(ClsTy)) {
        ElaboratedTypeLoc ETLoc = ClsTL.castAs(ElaboratedTypeLoc.class);
        ETLoc.setElaboratedKeywordLoc(new SourceLocation());
        ETLoc.setQualifierLoc(NNSLoc.getPrefix());
        TypeLoc NamedTL = ETLoc.getNamedTypeLoc();
        NamedTL.initializeFullCopy(NNSLoc.getTypeLoc());
      } else {
        ClsTL.initializeFullCopy(NNSLoc.getTypeLoc());
      }
      break;
     case Namespace:
     case NamespaceAlias:
     case Global:
     case Super:
      throw new llvm_unreachable("Nested-name-specifier must name a type");
    }
    
    // Finally fill in MemberPointerLocInfo fields.
    TL.setStarLoc(new SourceLocation(Chunk.Loc));
    TL.setClassTInfo(ClsTInfo);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaratorLocFiller::VisitLValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5066,
   FQN="(anonymous namespace)::DeclaratorLocFiller::VisitLValueReferenceTypeLoc", NM="_ZN12_GLOBAL__N_119DeclaratorLocFiller27VisitLValueReferenceTypeLocEN5clang22LValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119DeclaratorLocFiller27VisitLValueReferenceTypeLocEN5clang22LValueReferenceTypeLocE")
  //</editor-fold>
  public void VisitLValueReferenceTypeLoc(LValueReferenceTypeLoc TL) {
    assert (Chunk.Kind == DeclaratorChunk.Unnamed_enum.Reference);
    // 'Amp' is misleading: this might have been originally
    /// spelled with AmpAmp.
    TL.setAmpLoc(new SourceLocation(Chunk.Loc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaratorLocFiller::VisitRValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5072,
   FQN="(anonymous namespace)::DeclaratorLocFiller::VisitRValueReferenceTypeLoc", NM="_ZN12_GLOBAL__N_119DeclaratorLocFiller27VisitRValueReferenceTypeLocEN5clang22RValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119DeclaratorLocFiller27VisitRValueReferenceTypeLocEN5clang22RValueReferenceTypeLocE")
  //</editor-fold>
  public void VisitRValueReferenceTypeLoc(RValueReferenceTypeLoc TL) {
    assert (Chunk.Kind == DeclaratorChunk.Unnamed_enum.Reference);
    assert (!Chunk.Unnamed_field3.Ref.LValueRef);
    TL.setAmpAmpLoc(new SourceLocation(Chunk.Loc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaratorLocFiller::VisitArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5077,
   FQN="(anonymous namespace)::DeclaratorLocFiller::VisitArrayTypeLoc", NM="_ZN12_GLOBAL__N_119DeclaratorLocFiller17VisitArrayTypeLocEN5clang12ArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119DeclaratorLocFiller17VisitArrayTypeLocEN5clang12ArrayTypeLocE")
  //</editor-fold>
  public void VisitArrayTypeLoc(ArrayTypeLoc TL) {
    assert (Chunk.Kind == DeclaratorChunk.Unnamed_enum.Array);
    TL.setLBracketLoc(new SourceLocation(Chunk.Loc));
    TL.setRBracketLoc(new SourceLocation(Chunk.EndLoc));
    TL.setSizeExpr(((/*static_cast*/Expr /*P*/ )(Chunk.Unnamed_field3.Arr.NumElts)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaratorLocFiller::VisitFunctionTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5083,
   FQN="(anonymous namespace)::DeclaratorLocFiller::VisitFunctionTypeLoc", NM="_ZN12_GLOBAL__N_119DeclaratorLocFiller20VisitFunctionTypeLocEN5clang15FunctionTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119DeclaratorLocFiller20VisitFunctionTypeLocEN5clang15FunctionTypeLocE")
  //</editor-fold>
  public void VisitFunctionTypeLoc(FunctionTypeLoc TL) {
    assert (Chunk.Kind == DeclaratorChunk.Unnamed_enum.Function);
    TL.setLocalRangeBegin(new SourceLocation(Chunk.Loc));
    TL.setLocalRangeEnd(new SourceLocation(Chunk.EndLoc));
    
    final /*const*/ DeclaratorChunk.FunctionTypeInfo /*&*/ FTI = Chunk.Unnamed_field3.Fun;
    TL.setLParenLoc(FTI.getLParenLoc());
    TL.setRParenLoc(FTI.getRParenLoc());
    for (/*uint*/int i = 0, e = TL.getNumParams(), tpi = 0; i != e; ++i) {
      ParmVarDecl /*P*/ Param = cast_ParmVarDecl(FTI.Params.$at(i).Param);
      TL.setParam(tpi++, Param);
    }
    // FIXME: exception specs
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaratorLocFiller::VisitParenTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5097,
   FQN="(anonymous namespace)::DeclaratorLocFiller::VisitParenTypeLoc", NM="_ZN12_GLOBAL__N_119DeclaratorLocFiller17VisitParenTypeLocEN5clang12ParenTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119DeclaratorLocFiller17VisitParenTypeLocEN5clang12ParenTypeLocE")
  //</editor-fold>
  public void VisitParenTypeLoc(ParenTypeLoc TL) {
    assert (Chunk.Kind == DeclaratorChunk.Unnamed_enum.Paren);
    TL.setLParenLoc(new SourceLocation(Chunk.Loc));
    TL.setRParenLoc(new SourceLocation(Chunk.EndLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaratorLocFiller::VisitPipeTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5102,
   FQN="(anonymous namespace)::DeclaratorLocFiller::VisitPipeTypeLoc", NM="_ZN12_GLOBAL__N_119DeclaratorLocFiller16VisitPipeTypeLocEN5clang11PipeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119DeclaratorLocFiller16VisitPipeTypeLocEN5clang11PipeTypeLocE")
  //</editor-fold>
  public void VisitPipeTypeLoc(PipeTypeLoc TL) {
    assert (Chunk.Kind == DeclaratorChunk.Unnamed_enum.Pipe);
    TL.setKWLoc(new SourceLocation(Chunk.Loc));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaratorLocFiller::VisitTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5107,
   FQN="(anonymous namespace)::DeclaratorLocFiller::VisitTypeLoc", NM="_ZN12_GLOBAL__N_119DeclaratorLocFiller12VisitTypeLocEN5clang7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119DeclaratorLocFiller12VisitTypeLocEN5clang7TypeLocE")
  //</editor-fold>
  public void VisitTypeLoc(TypeLoc TL) {
    throw new llvm_unreachable("unsupported TypeLoc kind in declarator!");
  }

  
  @Override public String toString() {
    return "" + "Context=" + "[ASTContext]" // NOI18N
              + ", Chunk=" + Chunk // NOI18N
              + super.toString(); // NOI18N
  }
}
