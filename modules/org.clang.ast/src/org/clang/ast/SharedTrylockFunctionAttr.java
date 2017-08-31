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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::SharedTrylockFunctionAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6232,
 FQN="clang::SharedTrylockFunctionAttr", NM="_ZN5clang25SharedTrylockFunctionAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang25SharedTrylockFunctionAttrE")
//</editor-fold>
public class SharedTrylockFunctionAttr extends /*public*/ InheritableAttr implements org.clang.ast.java.ArgsAttrBase {
  private Expr /*P*/ successValue;
  
  private /*uint*/int args_Size;
  private type$ptr<Expr/*P*/> args_;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::SharedTrylockFunctionAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6239,
   FQN="clang::SharedTrylockFunctionAttr::CreateImplicit", NM="_ZN5clang25SharedTrylockFunctionAttr14CreateImplicitERNS_10ASTContextEPNS_4ExprEPS4_jNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang25SharedTrylockFunctionAttr14CreateImplicitERNS_10ASTContextEPNS_4ExprEPS4_jNS_11SourceRangeE")
  //</editor-fold>
  public static SharedTrylockFunctionAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Expr /*P*/ SuccessValue, type$ptr<Expr/*P*/> Args, /*uint*/int ArgsSize) {
    return CreateImplicit(Ctx, SuccessValue, Args, ArgsSize, new SourceRange());
  }
  public static SharedTrylockFunctionAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Expr /*P*/ SuccessValue, type$ptr<Expr/*P*/> Args, /*uint*/int ArgsSize, SourceRange Loc/*= SourceRange()*/) {
    SharedTrylockFunctionAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new SharedTrylockFunctionAttr(new SourceRange(Loc), Ctx, SuccessValue, Args, ArgsSize, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SharedTrylockFunctionAttr::SharedTrylockFunctionAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6245,
   FQN="clang::SharedTrylockFunctionAttr::SharedTrylockFunctionAttr", NM="_ZN5clang25SharedTrylockFunctionAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_4ExprEPS5_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang25SharedTrylockFunctionAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_4ExprEPS5_jj")
  //</editor-fold>
  public SharedTrylockFunctionAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      Expr /*P*/ SuccessValue, 
      type$ptr<Expr/*P*/> Args, /*uint*/int ArgsSize, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::SharedTrylockFunction, R, SI, true, true), successValue(SuccessValue), args_Size(ArgsSize), args_(new (Ctx, 16) new Expr * [args_Size]) 
    //START JInit
    super(attr.Kind.SharedTrylockFunction, new SourceRange(R), SI, true, true);
    this.successValue = SuccessValue;
    this.args_Size = ArgsSize;
    this.args_ = create_type$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 16)*/ new Expr /*P*/ [args_Size]);
    //END JInit
    std.copy(Args, Args.$add(args_Size), args_);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SharedTrylockFunctionAttr::SharedTrylockFunctionAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6257,
   FQN="clang::SharedTrylockFunctionAttr::SharedTrylockFunctionAttr", NM="_ZN5clang25SharedTrylockFunctionAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_4ExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang25SharedTrylockFunctionAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_4ExprEj")
  //</editor-fold>
  public SharedTrylockFunctionAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      Expr /*P*/ SuccessValue, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::SharedTrylockFunction, R, SI, true, true), successValue(SuccessValue), args_Size(0), args_(null) 
    //START JInit
    super(attr.Kind.SharedTrylockFunction, new SourceRange(R), SI, true, true);
    this.successValue = SuccessValue;
    this.args_Size = 0;
    this.args_ = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SharedTrylockFunctionAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 5852,
   FQN="clang::SharedTrylockFunctionAttr::clone", NM="_ZNK5clang25SharedTrylockFunctionAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang25SharedTrylockFunctionAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public SharedTrylockFunctionAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    SharedTrylockFunctionAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new SharedTrylockFunctionAttr(new SourceRange(getLocation()), C, successValue, args_, args_Size, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SharedTrylockFunctionAttr::printPretty">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 5860,
   FQN="clang::SharedTrylockFunctionAttr::printPretty", NM="_ZNK5clang25SharedTrylockFunctionAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang25SharedTrylockFunctionAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((shared_trylock_function(").$out(getSuccessValue()).$out(/*KEEP_STR*/$COMMA_SPACE);
        boolean isFirst = true;
        for (final Expr /*P*/ /*const*/ /*&*/ Val : args()) {
          if (isFirst) {
            isFirst = false;
          } else {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          OS.$out(Val);
        }
        OS.$out(/*KEEP_STR*/")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SharedTrylockFunctionAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 5879,
   FQN="clang::SharedTrylockFunctionAttr::getSpelling", NM="_ZNK5clang25SharedTrylockFunctionAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang25SharedTrylockFunctionAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("shared_trylock_function");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SharedTrylockFunctionAttr::getSuccessValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6271,
   FQN="clang::SharedTrylockFunctionAttr::getSuccessValue", NM="_ZNK5clang25SharedTrylockFunctionAttr15getSuccessValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang25SharedTrylockFunctionAttr15getSuccessValueEv")
  //</editor-fold>
  public Expr /*P*/ getSuccessValue() /*const*/ {
    return successValue;
  }

  
  /*typedef Expr **args_iterator*/
//  public final class args_iterator extends type$ptr<Expr/*P*/> { };
  //<editor-fold defaultstate="collapsed" desc="clang::SharedTrylockFunctionAttr::args_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6276,
   FQN="clang::SharedTrylockFunctionAttr::args_begin", NM="_ZNK5clang25SharedTrylockFunctionAttr10args_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang25SharedTrylockFunctionAttr10args_beginEv")
  //</editor-fold>
  public type$ptr<Expr/*P*/> args_begin() /*const*/ {
    return args_;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SharedTrylockFunctionAttr::args_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6277,
   FQN="clang::SharedTrylockFunctionAttr::args_end", NM="_ZNK5clang25SharedTrylockFunctionAttr8args_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang25SharedTrylockFunctionAttr8args_endEv")
  //</editor-fold>
  public type$ptr<Expr/*P*/> args_end() /*const*/ {
    return args_.$add(args_Size);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SharedTrylockFunctionAttr::args_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6278,
   FQN="clang::SharedTrylockFunctionAttr::args_size", NM="_ZNK5clang25SharedTrylockFunctionAttr9args_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang25SharedTrylockFunctionAttr9args_sizeEv")
  //</editor-fold>
  public /*uint*/int args_size() /*const*/ {
    return args_Size;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SharedTrylockFunctionAttr::args">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6279,
   FQN="clang::SharedTrylockFunctionAttr::args", NM="_ZNK5clang25SharedTrylockFunctionAttr4argsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang25SharedTrylockFunctionAttr4argsEv")
  //</editor-fold>
  public iterator_range<Expr/*P*/> args() /*const*/ {
    return llvm.make_range(args_begin(), args_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SharedTrylockFunctionAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6284,
   FQN="clang::SharedTrylockFunctionAttr::classof", NM="_ZN5clang25SharedTrylockFunctionAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang25SharedTrylockFunctionAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.SharedTrylockFunction;
  }

  
  @Override public String toString() {
    return "" + "successValue=" + successValue // NOI18N
              + ", args_Size=" + args_Size // NOI18N
              + ", args_=" + args_ // NOI18N
              + super.toString(); // NOI18N
  }
}
