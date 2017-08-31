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

//<editor-fold defaultstate="collapsed" desc="clang::ConstructorAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1868,
 FQN="clang::ConstructorAttr", NM="_ZN5clang15ConstructorAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang15ConstructorAttrE")
//</editor-fold>
public class ConstructorAttr extends /*public*/ InheritableAttr {
  private int priority;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1872,
   FQN="clang::ConstructorAttr::CreateImplicit", NM="_ZN5clang15ConstructorAttr14CreateImplicitERNS_10ASTContextEiNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang15ConstructorAttr14CreateImplicitERNS_10ASTContextEiNS_11SourceRangeE")
  //</editor-fold>
  public static ConstructorAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, int Priority) {
    return CreateImplicit(Ctx, Priority, new SourceRange());
  }
  public static ConstructorAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, int Priority, SourceRange Loc/*= SourceRange()*/) {
    ConstructorAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new ConstructorAttr(new SourceRange(Loc), Ctx, Priority, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorAttr::ConstructorAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1878,
   FQN="clang::ConstructorAttr::ConstructorAttr", NM="_ZN5clang15ConstructorAttrC1ENS_11SourceRangeERNS_10ASTContextEij",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang15ConstructorAttrC1ENS_11SourceRangeERNS_10ASTContextEij")
  //</editor-fold>
  public ConstructorAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      int Priority, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Constructor, R, SI, false, false), priority(Priority) 
    //START JInit
    super(attr.Kind.Constructor, new SourceRange(R), SI, false, false);
    this.priority = Priority;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorAttr::ConstructorAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1887,
   FQN="clang::ConstructorAttr::ConstructorAttr", NM="_ZN5clang15ConstructorAttrC1ENS_11SourceRangeERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang15ConstructorAttrC1ENS_11SourceRangeERNS_10ASTContextEj")
  //</editor-fold>
  public ConstructorAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Constructor, R, SI, false, false), priority(implicit int()) 
    //START JInit
    super(attr.Kind.Constructor, new SourceRange(R), SI, false, false);
    this.priority = /*implicit-init*/((int)/*zero-init*/0);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 1691,
   FQN="clang::ConstructorAttr::clone", NM="_ZNK5clang15ConstructorAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang15ConstructorAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public ConstructorAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    ConstructorAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new ConstructorAttr(new SourceRange(getLocation()), C, priority, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 1699,
   FQN="clang::ConstructorAttr::printPretty", NM="_ZNK5clang15ConstructorAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang15ConstructorAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((constructor(").$out_int(getPriority()).$out(/*KEEP_STR*/")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[gnu::constructor(").$out_int(getPriority()).$out(/*KEEP_STR*/")]]");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 1715,
   FQN="clang::ConstructorAttr::getSpelling", NM="_ZNK5clang15ConstructorAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang15ConstructorAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("constructor");
     case 1:
      return $("constructor");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorAttr::getPriority">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1899,
   FQN="clang::ConstructorAttr::getPriority", NM="_ZNK5clang15ConstructorAttr11getPriorityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang15ConstructorAttr11getPriorityEv")
  //</editor-fold>
  public int getPriority() /*const*/ {
    return priority;
  }

  
  public static /*const*/int DefaultPriority = 65535;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ConstructorAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1907,
   FQN="clang::ConstructorAttr::classof", NM="_ZN5clang15ConstructorAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang15ConstructorAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.Constructor;
  }

  
  @Override public String toString() {
    return "" + "priority=" + priority // NOI18N
              + super.toString(); // NOI18N
  }
}
