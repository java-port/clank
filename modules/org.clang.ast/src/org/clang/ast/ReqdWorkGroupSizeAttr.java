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

//<editor-fold defaultstate="collapsed" desc="clang::ReqdWorkGroupSizeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5751,
 FQN="clang::ReqdWorkGroupSizeAttr", NM="_ZN5clang21ReqdWorkGroupSizeAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang21ReqdWorkGroupSizeAttrE")
//</editor-fold>
public class ReqdWorkGroupSizeAttr extends /*public*/ InheritableAttr {
  private /*uint*/int xDim;
  
  private /*uint*/int yDim;
  
  private /*uint*/int zDim;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ReqdWorkGroupSizeAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5759,
   FQN="clang::ReqdWorkGroupSizeAttr::CreateImplicit", NM="_ZN5clang21ReqdWorkGroupSizeAttr14CreateImplicitERNS_10ASTContextEjjjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang21ReqdWorkGroupSizeAttr14CreateImplicitERNS_10ASTContextEjjjNS_11SourceRangeE")
  //</editor-fold>
  public static ReqdWorkGroupSizeAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, /*uint*/int XDim, /*uint*/int YDim, /*uint*/int ZDim) {
    return CreateImplicit(Ctx, XDim, YDim, ZDim, new SourceRange());
  }
  public static ReqdWorkGroupSizeAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, /*uint*/int XDim, /*uint*/int YDim, /*uint*/int ZDim, SourceRange Loc/*= SourceRange()*/) {
    ReqdWorkGroupSizeAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new ReqdWorkGroupSizeAttr(new SourceRange(Loc), Ctx, XDim, YDim, ZDim, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ReqdWorkGroupSizeAttr::ReqdWorkGroupSizeAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5765,
   FQN="clang::ReqdWorkGroupSizeAttr::ReqdWorkGroupSizeAttr", NM="_ZN5clang21ReqdWorkGroupSizeAttrC1ENS_11SourceRangeERNS_10ASTContextEjjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang21ReqdWorkGroupSizeAttrC1ENS_11SourceRangeERNS_10ASTContextEjjjj")
  //</editor-fold>
  public ReqdWorkGroupSizeAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      /*uint*/int XDim, 
      /*uint*/int YDim, 
      /*uint*/int ZDim, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::ReqdWorkGroupSize, R, SI, false, false), xDim(XDim), yDim(YDim), zDim(ZDim) 
    //START JInit
    super(attr.Kind.ReqdWorkGroupSize, new SourceRange(R), SI, false, false);
    this.xDim = XDim;
    this.yDim = YDim;
    this.zDim = ZDim;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ReqdWorkGroupSizeAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 5408,
   FQN="clang::ReqdWorkGroupSizeAttr::clone", NM="_ZNK5clang21ReqdWorkGroupSizeAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang21ReqdWorkGroupSizeAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public ReqdWorkGroupSizeAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    ReqdWorkGroupSizeAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new ReqdWorkGroupSizeAttr(new SourceRange(getLocation()), C, xDim, yDim, zDim, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ReqdWorkGroupSizeAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 5416,
   FQN="clang::ReqdWorkGroupSizeAttr::printPretty", NM="_ZNK5clang21ReqdWorkGroupSizeAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang21ReqdWorkGroupSizeAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((reqd_work_group_size(").$out_uint(getXDim()).$out(/*KEEP_STR*/$COMMA_SPACE).$out_uint(getYDim()).$out(/*KEEP_STR*/$COMMA_SPACE).$out_uint(getZDim()).$out(/*KEEP_STR*/")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ReqdWorkGroupSizeAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 5428,
   FQN="clang::ReqdWorkGroupSizeAttr::getSpelling", NM="_ZNK5clang21ReqdWorkGroupSizeAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang21ReqdWorkGroupSizeAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("reqd_work_group_size");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ReqdWorkGroupSizeAttr::getXDim">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5782,
   FQN="clang::ReqdWorkGroupSizeAttr::getXDim", NM="_ZNK5clang21ReqdWorkGroupSizeAttr7getXDimEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang21ReqdWorkGroupSizeAttr7getXDimEv")
  //</editor-fold>
  public /*uint*/int getXDim() /*const*/ {
    return xDim;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ReqdWorkGroupSizeAttr::getYDim">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5786,
   FQN="clang::ReqdWorkGroupSizeAttr::getYDim", NM="_ZNK5clang21ReqdWorkGroupSizeAttr7getYDimEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang21ReqdWorkGroupSizeAttr7getYDimEv")
  //</editor-fold>
  public /*uint*/int getYDim() /*const*/ {
    return yDim;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ReqdWorkGroupSizeAttr::getZDim">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5790,
   FQN="clang::ReqdWorkGroupSizeAttr::getZDim", NM="_ZNK5clang21ReqdWorkGroupSizeAttr7getZDimEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang21ReqdWorkGroupSizeAttr7getZDimEv")
  //</editor-fold>
  public /*uint*/int getZDim() /*const*/ {
    return zDim;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ReqdWorkGroupSizeAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5796,
   FQN="clang::ReqdWorkGroupSizeAttr::classof", NM="_ZN5clang21ReqdWorkGroupSizeAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang21ReqdWorkGroupSizeAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.ReqdWorkGroupSize;
  }

  
  @Override public String toString() {
    return "" + "xDim=" + xDim // NOI18N
              + ", yDim=" + yDim // NOI18N
              + ", zDim=" + zDim // NOI18N
              + super.toString(); // NOI18N
  }
}
