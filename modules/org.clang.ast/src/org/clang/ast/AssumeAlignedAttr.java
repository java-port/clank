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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::AssumeAlignedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 952,
 FQN="clang::AssumeAlignedAttr", NM="_ZN5clang17AssumeAlignedAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17AssumeAlignedAttrE")
//</editor-fold>
public class AssumeAlignedAttr extends /*public*/ InheritableAttr {
  private Expr /*P*/ alignment;
  
  private Expr /*P*/ offset;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AssumeAlignedAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 958,
   FQN="clang::AssumeAlignedAttr::CreateImplicit", NM="_ZN5clang17AssumeAlignedAttr14CreateImplicitERNS_10ASTContextEPNS_4ExprES4_NS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17AssumeAlignedAttr14CreateImplicitERNS_10ASTContextEPNS_4ExprES4_NS_11SourceRangeE")
  //</editor-fold>
  public static AssumeAlignedAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Expr /*P*/ Alignment, Expr /*P*/ Offset) {
    return CreateImplicit(Ctx, Alignment, Offset, new SourceRange());
  }
  public static AssumeAlignedAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Expr /*P*/ Alignment, Expr /*P*/ Offset, SourceRange Loc/*= SourceRange()*/) {
    AssumeAlignedAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new AssumeAlignedAttr(new SourceRange(Loc), Ctx, Alignment, Offset, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AssumeAlignedAttr::AssumeAlignedAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 964,
   FQN="clang::AssumeAlignedAttr::AssumeAlignedAttr", NM="_ZN5clang17AssumeAlignedAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_4ExprES5_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17AssumeAlignedAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_4ExprES5_j")
  //</editor-fold>
  public AssumeAlignedAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      Expr /*P*/ Alignment, 
      Expr /*P*/ Offset, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::AssumeAligned, R, SI, false, false), alignment(Alignment), offset(Offset) 
    //START JInit
    super(attr.Kind.AssumeAligned, new SourceRange(R), SI, false, false);
    this.alignment = Alignment;
    this.offset = Offset;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AssumeAlignedAttr::AssumeAlignedAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 975,
   FQN="clang::AssumeAlignedAttr::AssumeAlignedAttr", NM="_ZN5clang17AssumeAlignedAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_4ExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17AssumeAlignedAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_4ExprEj")
  //</editor-fold>
  public AssumeAlignedAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      Expr /*P*/ Alignment, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::AssumeAligned, R, SI, false, false), alignment(Alignment), offset(implicit Expr * ()) 
    //START JInit
    super(attr.Kind.AssumeAligned, new SourceRange(R), SI, false, false);
    this.alignment = Alignment;
    this.offset = /*implicit-init*/((Expr /*P*/ )/*zero-init*/null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AssumeAlignedAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 844,
   FQN="clang::AssumeAlignedAttr::clone", NM="_ZNK5clang17AssumeAlignedAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang17AssumeAlignedAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public AssumeAlignedAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    AssumeAlignedAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new AssumeAlignedAttr(new SourceRange(getLocation()), C, alignment, offset, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AssumeAlignedAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 852,
   FQN="clang::AssumeAlignedAttr::printPretty", NM="_ZNK5clang17AssumeAlignedAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang17AssumeAlignedAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((assume_aligned(").$out(getAlignment()).$out(/*KEEP_STR*/$COMMA_SPACE).$out(getOffset()).$out(/*KEEP_STR*/")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[gnu::assume_aligned(").$out(getAlignment()).$out(/*KEEP_STR*/$COMMA_SPACE).$out(getOffset()).$out(/*KEEP_STR*/")]]");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AssumeAlignedAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 868,
   FQN="clang::AssumeAlignedAttr::getSpelling", NM="_ZNK5clang17AssumeAlignedAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang17AssumeAlignedAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("assume_aligned");
     case 1:
      return $("assume_aligned");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AssumeAlignedAttr::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 989,
   FQN="clang::AssumeAlignedAttr::getAlignment", NM="_ZNK5clang17AssumeAlignedAttr12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang17AssumeAlignedAttr12getAlignmentEv")
  //</editor-fold>
  public Expr /*P*/ getAlignment() /*const*/ {
    return alignment;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AssumeAlignedAttr::getOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 993,
   FQN="clang::AssumeAlignedAttr::getOffset", NM="_ZNK5clang17AssumeAlignedAttr9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang17AssumeAlignedAttr9getOffsetEv")
  //</editor-fold>
  public Expr /*P*/ getOffset() /*const*/ {
    return offset;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AssumeAlignedAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 999,
   FQN="clang::AssumeAlignedAttr::classof", NM="_ZN5clang17AssumeAlignedAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17AssumeAlignedAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.AssumeAligned;
  }

  
  @Override public String toString() {
    return "" + "alignment=" + alignment // NOI18N
              + ", offset=" + offset // NOI18N
              + super.toString(); // NOI18N
  }
}
