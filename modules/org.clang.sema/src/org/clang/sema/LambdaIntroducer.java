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

package org.clang.sema;

import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;


/// \brief Represents a complete lambda introducer.
//<editor-fold defaultstate="collapsed" desc="clang::LambdaIntroducer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2324,
 FQN="clang::LambdaIntroducer", NM="_ZN5clang16LambdaIntroducerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang16LambdaIntroducerE")
//</editor-fold>
public class/*struct*/ LambdaIntroducer implements Destructors.ClassWithDestructor {
  /// \brief An individual capture in a lambda introducer.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaIntroducer::LambdaCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2326,
   FQN="clang::LambdaIntroducer::LambdaCapture", NM="_ZN5clang16LambdaIntroducer13LambdaCaptureE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang16LambdaIntroducer13LambdaCaptureE")
  //</editor-fold>
  public static class/*struct*/ LambdaCapture implements NativePOD<LambdaCapture> {
    public LambdaCaptureKind Kind;
    public SourceLocation Loc;
    public IdentifierInfo /*P*/ Id;
    public SourceLocation EllipsisLoc;
    public LambdaCaptureInitKind InitKind;
    public ActionResultTTrue<Expr /*P*/ > Init;
    public OpaquePtr<QualType> InitCaptureType;
    //<editor-fold defaultstate="collapsed" desc="clang::LambdaIntroducer::LambdaCapture::LambdaCapture">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2334,
     FQN="clang::LambdaIntroducer::LambdaCapture::LambdaCapture", NM="_ZN5clang16LambdaIntroducer13LambdaCaptureC1ENS_17LambdaCaptureKindENS_14SourceLocationEPNS_14IdentifierInfoES3_NS_21LambdaCaptureInitKindENS_12ActionResultIPNS_4ExprELb1EEENS_9OpaquePtrINS_8QualTypeEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang16LambdaIntroducer13LambdaCaptureC1ENS_17LambdaCaptureKindENS_14SourceLocationEPNS_14IdentifierInfoES3_NS_21LambdaCaptureInitKindENS_12ActionResultIPNS_4ExprELb1EEENS_9OpaquePtrINS_8QualTypeEEE")
    //</editor-fold>
    public LambdaCapture(LambdaCaptureKind Kind, SourceLocation Loc, 
        IdentifierInfo /*P*/ Id, SourceLocation EllipsisLoc, 
        LambdaCaptureInitKind InitKind, ActionResultTTrue<Expr /*P*/ > Init, 
        OpaquePtr<QualType> InitCaptureType) {
      // : Kind(Kind), Loc(Loc), Id(Id), EllipsisLoc(EllipsisLoc), InitKind(InitKind), Init(Init), InitCaptureType(InitCaptureType) 
      //START JInit
      this.Kind = Kind;
      this.Loc = new SourceLocation(Loc);
      this.Id = Id;
      this.EllipsisLoc = new SourceLocation(EllipsisLoc);
      this.InitKind = InitKind;
      this.Init = new ActionResultTTrue<Expr /*P*/ >(Init);
      this.InitCaptureType = new OpaquePtr<QualType>(InitCaptureType);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::LambdaIntroducer::LambdaCapture::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2326,
     FQN="clang::LambdaIntroducer::LambdaCapture::operator=", NM="_ZN5clang16LambdaIntroducer13LambdaCaptureaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang16LambdaIntroducer13LambdaCaptureaSEOS1_")
    //</editor-fold>
    public /*inline*/ LambdaCapture /*&*/ $assignMove(final LambdaCapture /*&&*/$Prm0) {
      this.Kind = $Prm0.Kind;
      this.Loc.$assignMove($Prm0.Loc);
      this.Id = $Prm0.Id;
      this.EllipsisLoc.$assignMove($Prm0.EllipsisLoc);
      this.InitKind = $Prm0.InitKind;
      this.Init.$assignMove($Prm0.Init);
      this.InitCaptureType.$assignMove($Prm0.InitCaptureType);
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    /// Used for default values in collections, i.e. fill everything with zeroes
    private LambdaCapture() {
      this.Kind = Kind.LCK_This;
      this.Loc = new SourceLocation();
      this.Id = new IdentifierInfo(NativePointer.$EMPTY, 0);
      this.EllipsisLoc = new SourceLocation();
      this.InitKind = InitKind.NoInit;
      this.Init = new ActionResultTTrue();
      this.InitCaptureType = new OpaquePtr();
    }

    public /*inline*/ LambdaCapture /*&*/ $assign(final LambdaCapture /*&&*/$Prm0) {
      this.Kind = $Prm0.Kind;
      this.Loc.$assign($Prm0.Loc);
      this.Id = $Prm0.Id;
      this.EllipsisLoc.$assign($Prm0.EllipsisLoc);
      this.InitKind = $Prm0.InitKind;
      this.Init.$assign($Prm0.Init);
      this.InitCaptureType.$assign($Prm0.InitCaptureType);
      return /*Deref*/this;
    }
    
    @Override
    public LambdaCapture clone() {
      return new LambdaCapture().$assign(this);
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Kind=" + Kind // NOI18N
                + ", Loc=" + Loc // NOI18N
                + ", Id=" + Id // NOI18N
                + ", EllipsisLoc=" + EllipsisLoc // NOI18N
                + ", InitKind=" + InitKind // NOI18N
                + ", Init=" + Init // NOI18N
                + ", InitCaptureType=" + InitCaptureType; // NOI18N
    }
  };
  
  public SourceRange Range;
  public SourceLocation DefaultLoc;
  public LambdaCaptureDefault Default;
  public SmallVector<LambdaCapture> Captures;
  
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaIntroducer::LambdaIntroducer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2347,
   FQN="clang::LambdaIntroducer::LambdaIntroducer", NM="_ZN5clang16LambdaIntroducerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang16LambdaIntroducerC1Ev")
  //</editor-fold>
  public LambdaIntroducer() {
    // : Range(), DefaultLoc(), Default(LCD_None), Captures() 
    //START JInit
    this.Range = new SourceRange();
    this.DefaultLoc = new SourceLocation();
    this.Default = LambdaCaptureDefault.LCD_None;
    this.Captures = new SmallVector<LambdaCapture>(4, new LambdaCapture());
    //END JInit
  }

  
  /// \brief Append a capture in a lambda introducer.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaIntroducer::addCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2351,
   FQN="clang::LambdaIntroducer::addCapture", NM="_ZN5clang16LambdaIntroducer10addCaptureENS_17LambdaCaptureKindENS_14SourceLocationEPNS_14IdentifierInfoES2_NS_21LambdaCaptureInitKindENS_12ActionResultIPNS_4ExprELb1EEENS_9OpaquePtrINS_8QualTypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang16LambdaIntroducer10addCaptureENS_17LambdaCaptureKindENS_14SourceLocationEPNS_14IdentifierInfoES2_NS_21LambdaCaptureInitKindENS_12ActionResultIPNS_4ExprELb1EEENS_9OpaquePtrINS_8QualTypeEEE")
  //</editor-fold>
  public void addCapture(LambdaCaptureKind Kind, 
            SourceLocation Loc, 
            IdentifierInfo /*P*/ Id, 
            SourceLocation EllipsisLoc, 
            LambdaCaptureInitKind InitKind, 
            ActionResultTTrue<Expr /*P*/ > Init, 
            OpaquePtr<QualType> InitCaptureType) {
    Captures.push_back(new LambdaCapture(Kind, new SourceLocation(Loc), Id, new SourceLocation(EllipsisLoc), InitKind, new ActionResultTTrue<Expr /*P*/ >(Init), 
            new OpaquePtr<QualType>(InitCaptureType)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LambdaIntroducer::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2324,
   FQN="clang::LambdaIntroducer::operator=", NM="_ZN5clang16LambdaIntroduceraSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang16LambdaIntroduceraSEOS0_")
  //</editor-fold>
  public /*inline*/ LambdaIntroducer /*&*/ $assignMove(final LambdaIntroducer /*&&*/$Prm0) {
    this.Range.$assignMove($Prm0.Range);
    this.DefaultLoc.$assignMove($Prm0.DefaultLoc);
    this.Default = $Prm0.Default;
    this.Captures.$assignMove($Prm0.Captures);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LambdaIntroducer::~LambdaIntroducer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2324,
   FQN="clang::LambdaIntroducer::~LambdaIntroducer", NM="_ZN5clang16LambdaIntroducerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang16LambdaIntroducerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Captures.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Range=" + Range // NOI18N
              + ", DefaultLoc=" + DefaultLoc // NOI18N
              + ", Default=" + Default // NOI18N
              + ", Captures=" + Captures; // NOI18N
  }
}
