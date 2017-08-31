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
import org.clang.basic.*;


/// DeclarationNameLoc - Additional source/type location info
/// for a declaration name. Needs a DeclarationName in order
/// to be interpreted correctly.
//<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 393,
 FQN="clang::DeclarationNameLoc", NM="_ZN5clang18DeclarationNameLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang18DeclarationNameLocE")
//</editor-fold>
public class/*struct*/ DeclarationNameLoc {
  // The source location for identifier stored elsewhere.
  // struct {} Identifier;
  
  // Type info for constructors, destructors and conversion functions.
  // Locations (if any) for the tilde (destructor) or operator keyword
  // (conversion) are stored elsewhere.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::NT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 400,
   FQN="clang::DeclarationNameLoc::NT", NM="_ZN5clang18DeclarationNameLoc2NTE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang18DeclarationNameLoc2NTE")
  //</editor-fold>
  public static class/*struct*/ NT {
    public TypeSourceInfo /*P*/ TInfo;
    //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::NT::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 400,
     FQN="clang::DeclarationNameLoc::NT::operator=", NM="_ZN5clang18DeclarationNameLoc2NTaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang18DeclarationNameLoc2NTaSERKS1_")
    //</editor-fold>
    public /*inline*/ NT /*&*/ $assign(final /*const*/ NT /*&*/ $Prm0) {
      this.TInfo = $Prm0.TInfo;
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::NT::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 400,
     FQN="clang::DeclarationNameLoc::NT::operator=", NM="_ZN5clang18DeclarationNameLoc2NTaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang18DeclarationNameLoc2NTaSEOS1_")
    //</editor-fold>
    public /*inline*/ NT /*&*/ $assignMove(final NT /*&&*/$Prm0) {
      assert this != $Prm0;
      this.TInfo = $Prm0.TInfo;
      $Prm0.TInfo = null;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "TInfo=" + TInfo; // NOI18N
    }
  };
  
  // The location (if any) of the operator keyword is stored elsewhere.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::CXXOpName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 405,
   FQN="clang::DeclarationNameLoc::CXXOpName", NM="_ZN5clang18DeclarationNameLoc9CXXOpNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang18DeclarationNameLoc9CXXOpNameE")
  //</editor-fold>
  public static class/*struct*/ CXXOpName {
    public /*uint*/int BeginOpNameLoc;
    public /*uint*/int EndOpNameLoc;
    //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::CXXOpName::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 405,
     FQN="clang::DeclarationNameLoc::CXXOpName::operator=", NM="_ZN5clang18DeclarationNameLoc9CXXOpNameaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang18DeclarationNameLoc9CXXOpNameaSERKS1_")
    //</editor-fold>
    public /*inline*/ CXXOpName /*&*/ $assign(final /*const*/ CXXOpName /*&*/ $Prm0) {
      this.BeginOpNameLoc = $Prm0.BeginOpNameLoc;
      this.EndOpNameLoc = $Prm0.EndOpNameLoc;
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::CXXOpName::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 405,
     FQN="clang::DeclarationNameLoc::CXXOpName::operator=", NM="_ZN5clang18DeclarationNameLoc9CXXOpNameaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang18DeclarationNameLoc9CXXOpNameaSEOS1_")
    //</editor-fold>
    public /*inline*/ CXXOpName /*&*/ $assignMove(final CXXOpName /*&&*/$Prm0) {
      assert this != $Prm0;
      this.BeginOpNameLoc = $Prm0.BeginOpNameLoc;
      this.EndOpNameLoc = $Prm0.EndOpNameLoc;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "BeginOpNameLoc=" + BeginOpNameLoc // NOI18N
                + ", EndOpNameLoc=" + EndOpNameLoc; // NOI18N
    }
  };
  
  // The location (if any) of the operator keyword is stored elsewhere.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::CXXLitOpName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 411,
   FQN="clang::DeclarationNameLoc::CXXLitOpName", NM="_ZN5clang18DeclarationNameLoc12CXXLitOpNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang18DeclarationNameLoc12CXXLitOpNameE")
  //</editor-fold>
  public static class/*struct*/ CXXLitOpName {
    public /*uint*/int OpNameLoc;
    //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::CXXLitOpName::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 411,
     FQN="clang::DeclarationNameLoc::CXXLitOpName::operator=", NM="_ZN5clang18DeclarationNameLoc12CXXLitOpNameaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang18DeclarationNameLoc12CXXLitOpNameaSERKS1_")
    //</editor-fold>
    public /*inline*/ CXXLitOpName /*&*/ $assign(final /*const*/ CXXLitOpName /*&*/ $Prm0) {
      this.OpNameLoc = $Prm0.OpNameLoc;
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::CXXLitOpName::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 411,
     FQN="clang::DeclarationNameLoc::CXXLitOpName::operator=", NM="_ZN5clang18DeclarationNameLoc12CXXLitOpNameaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang18DeclarationNameLoc12CXXLitOpNameaSEOS1_")
    //</editor-fold>
    public /*inline*/ CXXLitOpName /*&*/ $assignMove(final CXXLitOpName /*&&*/$Prm0) {
      this.OpNameLoc = $Prm0.OpNameLoc;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "OpNameLoc=" + OpNameLoc; // NOI18N
    }
  };
  
  // struct {} CXXUsingDirective;
  // struct {} ObjCZeroArgSelector;
  // struct {} ObjCOneArgSelector;
  // struct {} ObjCMultiArgSelector;
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL/*init fields*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 419,
   FQN="clang::DeclarationNameLoc::(anonymous)", NM="_ZN5clang18DeclarationNameLocE_Unnamed_union4",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang18DeclarationNameLocE_Unnamed_union4")
  //</editor-fold>
  public static class/*union*/ Unnamed_union4 {
    public /*final*/ NT NamedType = new NT();
    public /*final*/ CXXOpName CXXOperatorName = new CXXOpName();
    public /*final*/ CXXLitOpName CXXLiteralOperatorName = new CXXLitOpName();
    //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::(anonymous union)::">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 419,
     FQN="clang::DeclarationNameLoc::(anonymous union)::", NM="_ZN5clang18DeclarationNameLocUt_C1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang18DeclarationNameLocUt_C1ERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union4(final Unnamed_union4 $Prm0) {
      $assign($Prm0);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::(anonymous union)::">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 419,
     FQN="clang::DeclarationNameLoc::(anonymous union)::", NM="_ZN5clang18DeclarationNameLocUt_C1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang18DeclarationNameLocUt_C1EOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union4(JD$Move _dparam, final Unnamed_union4 $Prm0) {
      $assignMove($Prm0);
    }

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    private Unnamed_union4() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 419,
     FQN="clang::DeclarationNameLoc::(anonymous union)::operator=", NM="_ZN5clang18DeclarationNameLocUt_aSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang18DeclarationNameLocUt_aSERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union4 $assign(final Unnamed_union4 $Prm0) {
      this.NamedType.$assign($Prm0.NamedType);
      this.CXXOperatorName.$assign($Prm0.CXXOperatorName);
      this.CXXLiteralOperatorName.$assign($Prm0.CXXLiteralOperatorName);
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 419,
     FQN="clang::DeclarationNameLoc::(anonymous union)::operator=", NM="_ZN5clang18DeclarationNameLocUt_aSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang18DeclarationNameLocUt_aSEOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union4 $assignMove(final Unnamed_union4 $Prm0) {
      assert this != $Prm0;
      this.NamedType.$assignMove($Prm0.NamedType);
      $Prm0.NamedType = null;
      this.CXXOperatorName.$assignMove($Prm0.CXXOperatorName);
      $Prm0.CXXOperatorName = null;
      this.CXXLiteralOperatorName.$assignMove($Prm0.CXXLiteralOperatorName);
      $Prm0.CXXLiteralOperatorName = null;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "NamedType=" + NamedType // NOI18N
                + ", CXXOperatorName=" + CXXOperatorName // NOI18N
                + ", CXXLiteralOperatorName=" + CXXLiteralOperatorName; // NOI18N
    }
  };
  public Unnamed_union4 Unnamed_field = new Unnamed_union4();
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::DeclarationNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 472,
   FQN="clang::DeclarationNameLoc::DeclarationNameLoc", NM="_ZN5clang18DeclarationNameLocC1ENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang18DeclarationNameLocC1ENS_15DeclarationNameE")
  //</editor-fold>
  public DeclarationNameLoc(DeclarationName Name) {
    switch (Name.getNameKind()) {
     case Identifier:
      break;
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXConversionFunctionName:
      Unnamed_field.NamedType.TInfo = null;
      break;
     case CXXOperatorName:
      Unnamed_field.CXXOperatorName.BeginOpNameLoc = new SourceLocation().getRawEncoding();
      Unnamed_field.CXXOperatorName.EndOpNameLoc = new SourceLocation().getRawEncoding();
      break;
     case CXXLiteralOperatorName:
      Unnamed_field.CXXLiteralOperatorName.OpNameLoc = new SourceLocation().getRawEncoding();
      break;
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
      // FIXME: ?
      break;
     case CXXUsingDirective:
      break;
    }
  }

  // FIXME: this should go away once all DNLocs are properly initialized.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::DeclarationNameLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 427,
   FQN="clang::DeclarationNameLoc::DeclarationNameLoc", NM="_ZN5clang18DeclarationNameLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang18DeclarationNameLocC1Ev")
  //</editor-fold>
  public DeclarationNameLoc() {
//    memset(reinterpret_cast(Object/*void P*/ .class, this), 0, sizeof(/*Deref*/this));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::DeclarationNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 393,
   FQN="clang::DeclarationNameLoc::DeclarationNameLoc", NM="_ZN5clang18DeclarationNameLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang18DeclarationNameLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DeclarationNameLoc(final /*const*/ DeclarationNameLoc /*&*/ $Prm0) {
    // : Unnamed_field(.) 
    //START JInit
    this.Unnamed_field.$assign($Prm0.Unnamed_field);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::DeclarationNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 393,
   FQN="clang::DeclarationNameLoc::DeclarationNameLoc", NM="_ZN5clang18DeclarationNameLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang18DeclarationNameLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ DeclarationNameLoc(JD$Move _dparam, final DeclarationNameLoc /*&&*/$Prm0) {
    // : Unnamed_field(static_cast<DeclarationNameLoc &&>().) 
    //START JInit
    this.Unnamed_field.$assignMove($Prm0.Unnamed_field);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 393,
   FQN="clang::DeclarationNameLoc::operator=", NM="_ZN5clang18DeclarationNameLocaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang18DeclarationNameLocaSERKS0_")
  //</editor-fold>
  public /*inline*/ DeclarationNameLoc /*&*/ $assign(final /*const*/ DeclarationNameLoc /*&*/ $Prm0) {
    this.Unnamed_field.$assign($Prm0.Unnamed_field);
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameLoc::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 393,
   FQN="clang::DeclarationNameLoc::operator=", NM="_ZN5clang18DeclarationNameLocaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang18DeclarationNameLocaSEOS0_")
  //</editor-fold>
  public /*inline*/ DeclarationNameLoc /*&*/ $assignMove(final DeclarationNameLoc /*&&*/$Prm0) {
    assert this != $Prm0;
    this.Unnamed_field.$assignMove($Prm0.Unnamed_field);
    $Prm0.Unnamed_field = null;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Unnamed_field=" + Unnamed_field; // NOI18N
  }
}
