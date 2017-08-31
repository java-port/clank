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

package org.clang.ast.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.QualType.*;
import static org.clang.basic.BasicClangGlobals.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 460,
 FQN="(anonymous namespace)::TemplateDiff", NM="_ZN12_GLOBAL__N_112TemplateDiffE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiffE")
//</editor-fold>
public class TemplateDiff implements Destructors.ClassWithDestructor {
  /// Context - The ASTContext which is used for comparing template arguments.
  private final ASTContext /*&*/ Context;
  
  /// Policy - Used during expression printing.
  private PrintingPolicy Policy;
  
  /// ElideType - Option to elide identical types.
  private boolean ElideType;
  
  /// PrintTree - Format output string as a tree.
  private boolean PrintTree;
  
  /// ShowColor - Diagnostics support color, so bolding will be used.
  private boolean ShowColor;
  
  /// FromTemplateType - When single type printing is selected, this is the
  /// type to be be printed.  When tree printing is selected, this type will
  /// show up first in the tree.
  private QualType FromTemplateType;
  
  /// ToTemplateType - The type that FromType is compared to.  Only in tree
  /// printing will this type be outputed.
  private QualType ToTemplateType;
  
  /// OS - The stream used to construct the output strings.
  private final raw_ostream /*&*/ OS;
  
  /// IsBold - Keeps track of the bold formatting for the output string.
  private boolean IsBold;
  
  /// DiffTree - A tree representation the differences between two types.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 492,
   FQN="(anonymous namespace)::TemplateDiff::DiffTree", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTreeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTreeE")
  //</editor-fold>
  private static class DiffTree implements Destructors.ClassWithDestructor {
  /*public:*/
    /// DiffKind - The difference in a DiffNode.  Fields of
    /// TemplateArgumentInfo needed by each difference can be found in the
    /// Set* and Get* functions.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::DiffKind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 497,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::DiffKind", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree8DiffKindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree8DiffKindE")
    //</editor-fold>
    public enum DiffKind implements Native.ComparableLower {
      /// Incomplete or invalid node.
      Invalid(0),
      /// Another level of templates
      Template(Invalid.getValue() + 1),
      /// Type difference, all type differences except those falling under
      /// the Template difference.
      Type(Template.getValue() + 1),
      /// Expression difference, this is only when both arguments are
      /// expressions.  If one argument is an expression and the other is
      /// Integer or Declaration, then use that diff type instead.
      Expression(Type.getValue() + 1),
      /// Template argument difference
      TemplateTemplate(Expression.getValue() + 1),
      /// Integer difference
      Integer(TemplateTemplate.getValue() + 1),
      /// Declaration difference, nullptr arguments are included here
      Declaration(Integer.getValue() + 1),
      /// One argument being integer and the other being declaration
      FromIntegerAndToDeclaration(Declaration.getValue() + 1),
      FromDeclarationAndToInteger(FromIntegerAndToDeclaration.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static DiffKind valueOf(int val) {
        DiffKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final DiffKind[] VALUES;
        private static final DiffKind[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (DiffKind kind : DiffKind.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new DiffKind[min < 0 ? (1-min) : 0];
          VALUES = new DiffKind[max >= 0 ? (1+max) : 0];
          for (DiffKind kind : DiffKind.values()) {
            if (kind.value < 0) {
              if (_VALUES[-kind.value] == null) {
                _VALUES[-kind.value] = kind;
              } else {
                assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
              }
            } else {
              if (VALUES[kind.value] == null) {
                VALUES[kind.value] = kind;
              } else {
                assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
              }
            }
          }
        }
      }

      private final /*uint*/int value;
      private DiffKind(int val) { this.value = (/*uint*/int)val;}
      public /*uint*/int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((DiffKind)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((DiffKind)obj).value);}
      //</editor-fold>
    };
  /*private:*/
    /// TemplateArgumentInfo - All the information needed to pretty print
    /// a template argument.  See the Set* and Get* functions to see which
    /// fields are used for each DiffKind.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::TemplateArgumentInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 524,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::TemplateArgumentInfo", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree20TemplateArgumentInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree20TemplateArgumentInfoE")
    //</editor-fold>
    private static class/*struct*/ TemplateArgumentInfo implements Destructors.ClassWithDestructor {
      public QualType ArgType;
      public Qualifiers Qual;
      public APSInt Val;
      public boolean IsValidInt/* = false*/;
      public Expr /*P*/ ArgExpr/* = null*/;
      public TemplateDecl /*P*/ TD/* = null*/;
      public ValueDecl /*P*/ VD/* = null*/;
      public boolean NeedAddressOf/* = false*/;
      public boolean IsNullPtr/* = false*/;
      public boolean IsDefault/* = false*/;
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::TemplateArgumentInfo::TemplateArgumentInfo">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 524,
       FQN="(anonymous namespace)::TemplateDiff::DiffTree::TemplateArgumentInfo::TemplateArgumentInfo", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree20TemplateArgumentInfoC1Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree20TemplateArgumentInfoC1Ev")
      //</editor-fold>
      public /*inline*/ TemplateArgumentInfo() {
        // : ArgType(), Qual(), Val(), IsValidInt(false), ArgExpr(null), TD(null), VD(null), NeedAddressOf(false), IsNullPtr(false), IsDefault(false) 
        //START JInit
        this.ArgType = new QualType();
        this.Qual = new Qualifiers();
        this.Val = new APSInt();
        /*InClass*/this.IsValidInt = false;
        /*InClass*/this.ArgExpr = null;
        /*InClass*/this.TD = null;
        /*InClass*/this.VD = null;
        /*InClass*/this.NeedAddressOf = false;
        /*InClass*/this.IsNullPtr = false;
        /*InClass*/this.IsDefault = false;
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::TemplateArgumentInfo::TemplateArgumentInfo">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 524,
       FQN="(anonymous namespace)::TemplateDiff::DiffTree::TemplateArgumentInfo::TemplateArgumentInfo", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree20TemplateArgumentInfoC1EOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree20TemplateArgumentInfoC1EOS2_")
      //</editor-fold>
      public /*inline*/ TemplateArgumentInfo(JD$Move _dparam, final TemplateArgumentInfo /*&&*/$Prm0) {
        // : ArgType(static_cast<TemplateArgumentInfo &&>().ArgType), Qual(static_cast<TemplateArgumentInfo &&>().Qual), Val(static_cast<TemplateArgumentInfo &&>().Val), IsValidInt(static_cast<TemplateArgumentInfo &&>().IsValidInt), ArgExpr(static_cast<TemplateArgumentInfo &&>().ArgExpr), TD(static_cast<TemplateArgumentInfo &&>().TD), VD(static_cast<TemplateArgumentInfo &&>().VD), NeedAddressOf(static_cast<TemplateArgumentInfo &&>().NeedAddressOf), IsNullPtr(static_cast<TemplateArgumentInfo &&>().IsNullPtr), IsDefault(static_cast<TemplateArgumentInfo &&>().IsDefault) 
        //START JInit
        this.ArgType = new QualType(JD$Move.INSTANCE, $Prm0.ArgType);
        this.Qual = new Qualifiers(JD$Move.INSTANCE, $Prm0.Qual);
        this.Val = new APSInt(JD$Move.INSTANCE, $Prm0.Val);
        this.IsValidInt = $Prm0.IsValidInt;
        this.ArgExpr = $Prm0.ArgExpr;
        this.TD = $Prm0.TD;
        this.VD = $Prm0.VD;
        this.NeedAddressOf = $Prm0.NeedAddressOf;
        this.IsNullPtr = $Prm0.IsNullPtr;
        this.IsDefault = $Prm0.IsDefault;
        //END JInit
      }
      
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::TemplateArgumentInfo::TemplateArgumentInfo">
      @Converted(kind = Converted.Kind.MANUAL_ADDED,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 524,
       FQN="(anonymous namespace)::TemplateDiff::DiffTree::TemplateArgumentInfo::TemplateArgumentInfo", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree20TemplateArgumentInfoC1EOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree20TemplateArgumentInfoC1EOS2_")
      //</editor-fold>      
      public /*inline*/ TemplateArgumentInfo(final TemplateArgumentInfo /*&*/$Prm0) {
        // : ArgType(static_cast<TemplateArgumentInfo &&>().ArgType), Qual(static_cast<TemplateArgumentInfo &&>().Qual), Val(static_cast<TemplateArgumentInfo &&>().Val), IsValidInt(static_cast<TemplateArgumentInfo &&>().IsValidInt), ArgExpr(static_cast<TemplateArgumentInfo &&>().ArgExpr), TD(static_cast<TemplateArgumentInfo &&>().TD), VD(static_cast<TemplateArgumentInfo &&>().VD), NeedAddressOf(static_cast<TemplateArgumentInfo &&>().NeedAddressOf), IsNullPtr(static_cast<TemplateArgumentInfo &&>().IsNullPtr), IsDefault(static_cast<TemplateArgumentInfo &&>().IsDefault) 
        //START JInit
        this.ArgType = new QualType($Prm0.ArgType);
        this.Qual = new Qualifiers($Prm0.Qual);
        this.Val = new APSInt($Prm0.Val);
        this.IsValidInt = $Prm0.IsValidInt;
        this.ArgExpr = $Prm0.ArgExpr;
        this.TD = $Prm0.TD;
        this.VD = $Prm0.VD;
        this.NeedAddressOf = $Prm0.NeedAddressOf;
        this.IsNullPtr = $Prm0.IsNullPtr;
        this.IsDefault = $Prm0.IsDefault;
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::TemplateArgumentInfo::~TemplateArgumentInfo">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 524,
       FQN="(anonymous namespace)::TemplateDiff::DiffTree::TemplateArgumentInfo::~TemplateArgumentInfo", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree20TemplateArgumentInfoD0Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree20TemplateArgumentInfoD0Ev")
      //</editor-fold>
      public /*inline*/ void $destroy() {
        //START JDestroy
        Val.$destroy();
        //END JDestroy
      }

      
      @Override public String toString() {
        return "" + "ArgType=" + ArgType // NOI18N
                  + ", Qual=" + Qual // NOI18N
                  + ", Val=" + Val // NOI18N
                  + ", IsValidInt=" + IsValidInt // NOI18N
                  + ", ArgExpr=" + ArgExpr // NOI18N
                  + ", TD=" + TD // NOI18N
                  + ", VD=" + VD // NOI18N
                  + ", NeedAddressOf=" + NeedAddressOf // NOI18N
                  + ", IsNullPtr=" + IsNullPtr // NOI18N
                  + ", IsDefault=" + IsDefault; // NOI18N
      }
    };
    
    /// DiffNode - The root node stores the original type.  Each child node
    /// stores template arguments of their parents.  For templated types, the
    /// template decl is also stored.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::DiffNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 540,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::DiffNode", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree8DiffNodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree8DiffNodeE")
    //</editor-fold>
    private static class/*struct*/ DiffNode implements Destructors.ClassWithDestructor, NativeCloneable<DiffNode>, NativeMoveable<DiffNode> {
      public DiffKind Kind/* = Invalid*/;
      
      /// NextNode - The index of the next sibling node or 0.
      public /*uint*/int NextNode/* = 0*/;
      
      /// ChildNode - The index of the first child node or 0.
      public /*uint*/int ChildNode/* = 0*/;
      
      /// ParentNode - The index of the parent node.
      public /*uint*/int ParentNode/* = 0*/;
      
      public TemplateArgumentInfo FromArgInfo;
      
      public TemplateArgumentInfo ToArgInfo;
      
      /// Same - Whether the two arguments evaluate to the same value.
      public boolean Same/* = false*/;
      
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::DiffNode::DiffNode">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 557,
       FQN="(anonymous namespace)::TemplateDiff::DiffTree::DiffNode::DiffNode", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree8DiffNodeC1Ej",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree8DiffNodeC1Ej")
      //</editor-fold>
      public DiffNode() {
        this(0);
      }
      public DiffNode(/*uint*/int ParentNode/*= 0*/) {
        // : Kind(Invalid), NextNode(0), ChildNode(0), ParentNode(ParentNode), FromArgInfo(), ToArgInfo(), Same(false) 
        //START JInit
        /*InClass*/this.Kind = DiffKind.Invalid;
        /*InClass*/this.NextNode = 0;
        /*InClass*/this.ChildNode = 0;
        this.ParentNode = ParentNode;
        this.FromArgInfo = new TemplateArgumentInfo();
        this.ToArgInfo = new TemplateArgumentInfo();
        /*InClass*/this.Same = false;
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::DiffNode::DiffNode">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 540,
       FQN="(anonymous namespace)::TemplateDiff::DiffTree::DiffNode::DiffNode", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree8DiffNodeC1EOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree8DiffNodeC1EOS2_")
      //</editor-fold>
      public /*inline*/ DiffNode(JD$Move _dparam, final DiffNode /*&&*/$Prm0) {
        // : Kind(static_cast<DiffNode &&>().Kind), NextNode(static_cast<DiffNode &&>().NextNode), ChildNode(static_cast<DiffNode &&>().ChildNode), ParentNode(static_cast<DiffNode &&>().ParentNode), FromArgInfo(static_cast<DiffNode &&>().FromArgInfo), ToArgInfo(static_cast<DiffNode &&>().ToArgInfo), Same(static_cast<DiffNode &&>().Same) 
        //START JInit
        this.Kind = $Prm0.Kind;
        this.NextNode = $Prm0.NextNode;
        this.ChildNode = $Prm0.ChildNode;
        this.ParentNode = $Prm0.ParentNode;
        this.FromArgInfo = new TemplateArgumentInfo(JD$Move.INSTANCE, $Prm0.FromArgInfo);
        this.ToArgInfo = new TemplateArgumentInfo(JD$Move.INSTANCE, $Prm0.ToArgInfo);
        this.Same = $Prm0.Same;
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::DiffNode::~DiffNode">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 540,
       FQN="(anonymous namespace)::TemplateDiff::DiffTree::DiffNode::~DiffNode", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree8DiffNodeD0Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree8DiffNodeD0Ev")
      //</editor-fold>
      public /*inline*/ void $destroy() {
        //START JDestroy
        ToArgInfo.$destroy();
        FromArgInfo.$destroy();
        //END JDestroy
      }

      public /*inline*/ DiffNode(final DiffNode /*&*/$Prm0) {
        // : Kind(static_cast<DiffNode &&>().Kind), NextNode(static_cast<DiffNode &&>().NextNode), ChildNode(static_cast<DiffNode &&>().ChildNode), ParentNode(static_cast<DiffNode &&>().ParentNode), FromArgInfo(static_cast<DiffNode &&>().FromArgInfo), ToArgInfo(static_cast<DiffNode &&>().ToArgInfo), Same(static_cast<DiffNode &&>().Same) 
        //START JInit
        this.Kind = $Prm0.Kind;
        this.NextNode = $Prm0.NextNode;
        this.ChildNode = $Prm0.ChildNode;
        this.ParentNode = $Prm0.ParentNode;
        this.FromArgInfo = new TemplateArgumentInfo($Prm0.FromArgInfo);
        this.ToArgInfo = new TemplateArgumentInfo($Prm0.ToArgInfo);
        this.Same = $Prm0.Same;
        //END JInit
      }
      
      @Override public DiffNode clone() {
        return new DiffNode(this);
      }
      
      @Override public DiffNode move() {
        return new DiffNode(JD$Move.INSTANCE, this);
      }
      
      @Override public String toString() {
        return "" + "Kind=" + Kind // NOI18N
                  + ", NextNode=" + NextNode // NOI18N
                  + ", ChildNode=" + ChildNode // NOI18N
                  + ", ParentNode=" + ParentNode // NOI18N
                  + ", FromArgInfo=" + FromArgInfo // NOI18N
                  + ", ToArgInfo=" + ToArgInfo // NOI18N
                  + ", Same=" + Same; // NOI18N
      }
    };
    
    /// FlatTree - A flattened tree used to store the DiffNodes.
    private SmallVector<DiffNode> FlatTree;
    
    /// CurrentNode - The index of the current node being used.
    private /*uint*/int CurrentNode;
    
    /// NextFreeNode - The index of the next unused node.  Used when creating
    /// child nodes.
    private /*uint*/int NextFreeNode;
    
    /// ReadNode - The index of the current node being read.
    private /*uint*/int ReadNode;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::DiffTree">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 574,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::DiffTree", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTreeC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTreeC1Ev")
    //</editor-fold>
    public DiffTree() {
      // : FlatTree(), CurrentNode(0), NextFreeNode(1) 
      //START JInit
      this.FlatTree = new SmallVector<DiffNode>(16, new DiffNode());
      this.CurrentNode = 0;
      this.NextFreeNode = 1;
      //END JInit
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        FlatTree.push_back_T$RR($c$.track(new DiffNode())); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }

    
    // Node writing functions, one for each valid DiffKind element.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::SetTemplateDiff">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 580,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::SetTemplateDiff", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree15SetTemplateDiffEPN5clang12TemplateDeclES4_NS2_10QualifiersES5_bb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree15SetTemplateDiffEPN5clang12TemplateDeclES4_NS2_10QualifiersES5_bb")
    //</editor-fold>
    public void SetTemplateDiff(TemplateDecl /*P*/ FromTD, TemplateDecl /*P*/ ToTD, 
                   Qualifiers FromQual, Qualifiers ToQual, 
                   boolean FromDefault, boolean ToDefault) {
      assert (FlatTree.$at(CurrentNode).Kind == DiffKind.Invalid) : "Node is not empty.";
      FlatTree.$at(CurrentNode).Kind = DiffKind.Template;
      FlatTree.$at(CurrentNode).FromArgInfo.TD = FromTD;
      FlatTree.$at(CurrentNode).ToArgInfo.TD = ToTD;
      FlatTree.$at(CurrentNode).FromArgInfo.Qual.$assign(FromQual);
      FlatTree.$at(CurrentNode).ToArgInfo.Qual.$assign(ToQual);
      SetDefault(FromDefault, ToDefault);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::SetTypeDiff">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 592,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::SetTypeDiff", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree11SetTypeDiffEN5clang8QualTypeES3_bb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree11SetTypeDiffEN5clang8QualTypeES3_bb")
    //</editor-fold>
    public void SetTypeDiff(QualType FromType, QualType ToType, boolean FromDefault, 
               boolean ToDefault) {
      assert (FlatTree.$at(CurrentNode).Kind == DiffKind.Invalid) : "Node is not empty.";
      FlatTree.$at(CurrentNode).Kind = DiffKind.Type;
      FlatTree.$at(CurrentNode).FromArgInfo.ArgType.$assign(FromType);
      FlatTree.$at(CurrentNode).ToArgInfo.ArgType.$assign(ToType);
      SetDefault(FromDefault, ToDefault);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::SetExpressionDiff">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 601,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::SetExpressionDiff", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree17SetExpressionDiffEPN5clang4ExprES4_bb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree17SetExpressionDiffEPN5clang4ExprES4_bb")
    //</editor-fold>
    public void SetExpressionDiff(Expr /*P*/ FromExpr, Expr /*P*/ ToExpr, boolean FromDefault, 
                     boolean ToDefault) {
      assert (FlatTree.$at(CurrentNode).Kind == DiffKind.Invalid) : "Node is not empty.";
      FlatTree.$at(CurrentNode).Kind = DiffKind.Expression;
      FlatTree.$at(CurrentNode).FromArgInfo.ArgExpr = FromExpr;
      FlatTree.$at(CurrentNode).ToArgInfo.ArgExpr = ToExpr;
      SetDefault(FromDefault, ToDefault);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::SetTemplateTemplateDiff">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 610,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::SetTemplateTemplateDiff", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree23SetTemplateTemplateDiffEPN5clang12TemplateDeclES4_bb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree23SetTemplateTemplateDiffEPN5clang12TemplateDeclES4_bb")
    //</editor-fold>
    public void SetTemplateTemplateDiff(TemplateDecl /*P*/ FromTD, TemplateDecl /*P*/ ToTD, 
                           boolean FromDefault, boolean ToDefault) {
      assert (FlatTree.$at(CurrentNode).Kind == DiffKind.Invalid) : "Node is not empty.";
      FlatTree.$at(CurrentNode).Kind = DiffKind.TemplateTemplate;
      FlatTree.$at(CurrentNode).FromArgInfo.TD = FromTD;
      FlatTree.$at(CurrentNode).ToArgInfo.TD = ToTD;
      SetDefault(FromDefault, ToDefault);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::SetIntegerDiff">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 619,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::SetIntegerDiff", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree14SetIntegerDiffERKN4llvm6APSIntES5_bbN5clang8QualTypeES7_PNS6_4ExprES9_bb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree14SetIntegerDiffERKN4llvm6APSIntES5_bbN5clang8QualTypeES7_PNS6_4ExprES9_bb")
    //</editor-fold>
    public void SetIntegerDiff(final /*const*/ APSInt /*&*/ FromInt, final /*const*/ APSInt /*&*/ ToInt, 
                  boolean IsValidFromInt, boolean IsValidToInt, 
                  QualType FromIntType, QualType ToIntType, 
                  Expr /*P*/ FromExpr, Expr /*P*/ ToExpr, boolean FromDefault, 
                  boolean ToDefault) {
      assert (FlatTree.$at(CurrentNode).Kind == DiffKind.Invalid) : "Node is not empty.";
      FlatTree.$at(CurrentNode).Kind = DiffKind.Integer;
      FlatTree.$at(CurrentNode).FromArgInfo.Val.$assign(FromInt);
      FlatTree.$at(CurrentNode).ToArgInfo.Val.$assign(ToInt);
      FlatTree.$at(CurrentNode).FromArgInfo.IsValidInt = IsValidFromInt;
      FlatTree.$at(CurrentNode).ToArgInfo.IsValidInt = IsValidToInt;
      FlatTree.$at(CurrentNode).FromArgInfo.ArgType.$assign(FromIntType);
      FlatTree.$at(CurrentNode).ToArgInfo.ArgType.$assign(ToIntType);
      FlatTree.$at(CurrentNode).FromArgInfo.ArgExpr = FromExpr;
      FlatTree.$at(CurrentNode).ToArgInfo.ArgExpr = ToExpr;
      SetDefault(FromDefault, ToDefault);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::SetDeclarationDiff">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 637,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::SetDeclarationDiff", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree18SetDeclarationDiffEPN5clang9ValueDeclES4_bbbbPNS2_4ExprES6_bb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree18SetDeclarationDiffEPN5clang9ValueDeclES4_bbbbPNS2_4ExprES6_bb")
    //</editor-fold>
    public void SetDeclarationDiff(ValueDecl /*P*/ FromValueDecl, ValueDecl /*P*/ ToValueDecl, 
                      boolean FromAddressOf, boolean ToAddressOf, 
                      boolean FromNullPtr, boolean ToNullPtr, Expr /*P*/ FromExpr, 
                      Expr /*P*/ ToExpr, boolean FromDefault, boolean ToDefault) {
      assert (FlatTree.$at(CurrentNode).Kind == DiffKind.Invalid) : "Node is not empty.";
      FlatTree.$at(CurrentNode).Kind = DiffKind.Declaration;
      FlatTree.$at(CurrentNode).FromArgInfo.VD = FromValueDecl;
      FlatTree.$at(CurrentNode).ToArgInfo.VD = ToValueDecl;
      FlatTree.$at(CurrentNode).FromArgInfo.NeedAddressOf = FromAddressOf;
      FlatTree.$at(CurrentNode).ToArgInfo.NeedAddressOf = ToAddressOf;
      FlatTree.$at(CurrentNode).FromArgInfo.IsNullPtr = FromNullPtr;
      FlatTree.$at(CurrentNode).ToArgInfo.IsNullPtr = ToNullPtr;
      FlatTree.$at(CurrentNode).FromArgInfo.ArgExpr = FromExpr;
      FlatTree.$at(CurrentNode).ToArgInfo.ArgExpr = ToExpr;
      SetDefault(FromDefault, ToDefault);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::SetFromDeclarationAndToIntegerDiff">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 654,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::SetFromDeclarationAndToIntegerDiff", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree34SetFromDeclarationAndToIntegerDiffEPN5clang9ValueDeclEbbPNS2_4ExprERKN4llvm6APSIntEbNS2_8QualTypeES6_bb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree34SetFromDeclarationAndToIntegerDiffEPN5clang9ValueDeclEbbPNS2_4ExprERKN4llvm6APSIntEbNS2_8QualTypeES6_bb")
    //</editor-fold>
    public void SetFromDeclarationAndToIntegerDiff(ValueDecl /*P*/ FromValueDecl, boolean FromAddressOf, boolean FromNullPtr, 
                                      Expr /*P*/ FromExpr, final /*const*/ APSInt /*&*/ ToInt, boolean IsValidToInt, 
                                      QualType ToIntType, Expr /*P*/ ToExpr, boolean FromDefault, boolean ToDefault) {
      assert (FlatTree.$at(CurrentNode).Kind == DiffKind.Invalid) : "Node is not empty.";
      FlatTree.$at(CurrentNode).Kind = DiffKind.FromDeclarationAndToInteger;
      FlatTree.$at(CurrentNode).FromArgInfo.VD = FromValueDecl;
      FlatTree.$at(CurrentNode).FromArgInfo.NeedAddressOf = FromAddressOf;
      FlatTree.$at(CurrentNode).FromArgInfo.IsNullPtr = FromNullPtr;
      FlatTree.$at(CurrentNode).FromArgInfo.ArgExpr = FromExpr;
      FlatTree.$at(CurrentNode).ToArgInfo.Val.$assign(ToInt);
      FlatTree.$at(CurrentNode).ToArgInfo.IsValidInt = IsValidToInt;
      FlatTree.$at(CurrentNode).ToArgInfo.ArgType.$assign(ToIntType);
      FlatTree.$at(CurrentNode).ToArgInfo.ArgExpr = ToExpr;
      SetDefault(FromDefault, ToDefault);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::SetFromIntegerAndToDeclarationDiff">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 671,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::SetFromIntegerAndToDeclarationDiff", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree34SetFromIntegerAndToDeclarationDiffERKN4llvm6APSIntEbN5clang8QualTypeEPNS6_4ExprEPNS6_9ValueDeclEbbS9_bb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree34SetFromIntegerAndToDeclarationDiffERKN4llvm6APSIntEbN5clang8QualTypeEPNS6_4ExprEPNS6_9ValueDeclEbbS9_bb")
    //</editor-fold>
    public void SetFromIntegerAndToDeclarationDiff(final /*const*/ APSInt /*&*/ FromInt, boolean IsValidFromInt, QualType FromIntType, 
                                      Expr /*P*/ FromExpr, ValueDecl /*P*/ ToValueDecl, boolean ToAddressOf, 
                                      boolean ToNullPtr, Expr /*P*/ ToExpr, boolean FromDefault, boolean ToDefault) {
      assert (FlatTree.$at(CurrentNode).Kind == DiffKind.Invalid) : "Node is not empty.";
      FlatTree.$at(CurrentNode).Kind = DiffKind.FromIntegerAndToDeclaration;
      FlatTree.$at(CurrentNode).FromArgInfo.Val.$assign(FromInt);
      FlatTree.$at(CurrentNode).FromArgInfo.IsValidInt = IsValidFromInt;
      FlatTree.$at(CurrentNode).FromArgInfo.ArgType.$assign(FromIntType);
      FlatTree.$at(CurrentNode).FromArgInfo.ArgExpr = FromExpr;
      FlatTree.$at(CurrentNode).ToArgInfo.VD = ToValueDecl;
      FlatTree.$at(CurrentNode).ToArgInfo.NeedAddressOf = ToAddressOf;
      FlatTree.$at(CurrentNode).ToArgInfo.IsNullPtr = ToNullPtr;
      FlatTree.$at(CurrentNode).ToArgInfo.ArgExpr = ToExpr;
      SetDefault(FromDefault, ToDefault);
    }

    
    /// SetDefault - Sets FromDefault and ToDefault flags of the current node.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::SetDefault">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 689,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::SetDefault", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree10SetDefaultEbb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree10SetDefaultEbb")
    //</editor-fold>
    public void SetDefault(boolean FromDefault, boolean ToDefault) {
      assert ((!FromDefault || !ToDefault)) : "Both arguments cannot be default.";
      FlatTree.$at(CurrentNode).FromArgInfo.IsDefault = FromDefault;
      FlatTree.$at(CurrentNode).ToArgInfo.IsDefault = ToDefault;
    }

    
    /// SetSame - Sets the same flag of the current node.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::SetSame">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 696,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::SetSame", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree7SetSameEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree7SetSameEb")
    //</editor-fold>
    public void SetSame(boolean Same) {
      FlatTree.$at(CurrentNode).Same = Same;
    }

    
    /// SetKind - Sets the current node's type.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::SetKind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 701,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::SetKind", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree7SetKindENS1_8DiffKindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree7SetKindENS1_8DiffKindE")
    //</editor-fold>
    public void SetKind(DiffKind Kind) {
      FlatTree.$at(CurrentNode).Kind = Kind;
    }

    
    /// Up - Changes the node to the parent of the current node.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::Up">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 706,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::Up", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree2UpEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree2UpEv")
    //</editor-fold>
    public void Up() {
      assert (FlatTree.$at(CurrentNode).Kind != DiffKind.Invalid) : "Cannot exit node before setting node information.";
      CurrentNode = FlatTree.$at(CurrentNode).ParentNode;
    }

    
    /// AddNode - Adds a child node to the current node, then sets that node
    /// node as the current node.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::AddNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 714,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::AddNode", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree7AddNodeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree7AddNodeEv")
    //</editor-fold>
    public void AddNode() {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        assert (FlatTree.$at(CurrentNode).Kind == DiffKind.Template) : "Only Template nodes can have children nodes.";
        FlatTree.push_back_T$RR($c$.track(new DiffNode(CurrentNode))); $c$.clean();
        final DiffNode /*&*/ Node = FlatTree.$at(CurrentNode);
        if (Node.ChildNode == 0) {
          // If a child node doesn't exist, add one.
          Node.ChildNode = NextFreeNode;
        } else {
          // If a child node exists, find the last child node and add a
          // next node to it.
          /*uint*/int i;
          for (i = Node.ChildNode; FlatTree.$at(i).NextNode != 0;
               i = FlatTree.$at(i).NextNode) {
          }
          FlatTree.$at(i).NextNode = NextFreeNode;
        }
        CurrentNode = NextFreeNode;
        ++NextFreeNode;
      } finally {
        $c$.$destroy();
      }
    }

    
    // Node reading functions.
    /// StartTraverse - Prepares the tree for recursive traversal.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::StartTraverse">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 737,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::StartTraverse", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree13StartTraverseEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree13StartTraverseEv")
    //</editor-fold>
    public void StartTraverse() {
      ReadNode = 0;
      CurrentNode = NextFreeNode;
      NextFreeNode = 0;
    }

    
    /// Parent - Move the current read node to its parent.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::Parent">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 744,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::Parent", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree6ParentEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree6ParentEv")
    //</editor-fold>
    public void Parent() {
      ReadNode = FlatTree.$at(ReadNode).ParentNode;
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::GetTemplateDiff">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 748,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::GetTemplateDiff", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree15GetTemplateDiffERPN5clang12TemplateDeclES5_RNS2_10QualifiersES7_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree15GetTemplateDiffERPN5clang12TemplateDeclES5_RNS2_10QualifiersES7_")
    //</editor-fold>
    public void GetTemplateDiff(final type$ref<TemplateDecl /*P*/ /*&*/> FromTD, final type$ref<TemplateDecl /*P*/ /*&*/> ToTD, 
                   final Qualifiers /*&*/ FromQual, final Qualifiers /*&*/ ToQual) {
      assert (FlatTree.$at(ReadNode).Kind == DiffKind.Template) : "Unexpected kind.";
      FromTD.$set(FlatTree.$at(ReadNode).FromArgInfo.TD);
      ToTD.$set(FlatTree.$at(ReadNode).ToArgInfo.TD);
      FromQual.$assign(FlatTree.$at(ReadNode).FromArgInfo.Qual);
      ToQual.$assign(FlatTree.$at(ReadNode).ToArgInfo.Qual);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::GetTypeDiff">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 757,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::GetTypeDiff", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree11GetTypeDiffERN5clang8QualTypeES4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree11GetTypeDiffERN5clang8QualTypeES4_")
    //</editor-fold>
    public void GetTypeDiff(final QualType /*&*/ FromType, final QualType /*&*/ ToType) {
      assert (FlatTree.$at(ReadNode).Kind == DiffKind.Type) : "Unexpected kind";
      FromType.$assign(FlatTree.$at(ReadNode).FromArgInfo.ArgType);
      ToType.$assign(FlatTree.$at(ReadNode).ToArgInfo.ArgType);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::GetExpressionDiff">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 763,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::GetExpressionDiff", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree17GetExpressionDiffERPN5clang4ExprES5_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree17GetExpressionDiffERPN5clang4ExprES5_")
    //</editor-fold>
    public void GetExpressionDiff(final type$ref<Expr /*P*/ /*&*/> FromExpr, final type$ref<Expr /*P*/ /*&*/> ToExpr) {
      assert (FlatTree.$at(ReadNode).Kind == DiffKind.Expression) : "Unexpected kind";
      FromExpr.$set(FlatTree.$at(ReadNode).FromArgInfo.ArgExpr);
      ToExpr.$set(FlatTree.$at(ReadNode).ToArgInfo.ArgExpr);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::GetTemplateTemplateDiff">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 769,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::GetTemplateTemplateDiff", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree23GetTemplateTemplateDiffERPN5clang12TemplateDeclES5_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree23GetTemplateTemplateDiffERPN5clang12TemplateDeclES5_")
    //</editor-fold>
    public void GetTemplateTemplateDiff(final type$ref<TemplateDecl /*P*/ /*&*/> FromTD, final type$ref<TemplateDecl /*P*/ /*&*/> ToTD) {
      assert (FlatTree.$at(ReadNode).Kind == DiffKind.TemplateTemplate) : "Unexpected kind.";
      FromTD.$set(FlatTree.$at(ReadNode).FromArgInfo.TD);
      ToTD.$set(FlatTree.$at(ReadNode).ToArgInfo.TD);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::GetIntegerDiff">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 775,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::GetIntegerDiff", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree14GetIntegerDiffERN4llvm6APSIntES4_RbS5_RN5clang8QualTypeES8_RPNS6_4ExprESB_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree14GetIntegerDiffERN4llvm6APSIntES4_RbS5_RN5clang8QualTypeES8_RPNS6_4ExprESB_")
    //</editor-fold>
    public void GetIntegerDiff(final APSInt /*&*/ FromInt, final APSInt /*&*/ ToInt, 
                  final bool$ref/*bool &*/ IsValidFromInt, final bool$ref/*bool &*/ IsValidToInt, 
                  final QualType /*&*/ FromIntType, final QualType /*&*/ ToIntType, 
                  final type$ref<Expr /*P*/ /*&*/> FromExpr, final type$ref<Expr /*P*/ /*&*/> ToExpr) {
      assert (FlatTree.$at(ReadNode).Kind == DiffKind.Integer) : "Unexpected kind.";
      FromInt.$assign(FlatTree.$at(ReadNode).FromArgInfo.Val);
      ToInt.$assign(FlatTree.$at(ReadNode).ToArgInfo.Val);
      IsValidFromInt.$set(FlatTree.$at(ReadNode).FromArgInfo.IsValidInt);
      IsValidToInt.$set(FlatTree.$at(ReadNode).ToArgInfo.IsValidInt);
      FromIntType.$assign(FlatTree.$at(ReadNode).FromArgInfo.ArgType);
      ToIntType.$assign(FlatTree.$at(ReadNode).ToArgInfo.ArgType);
      FromExpr.$set(FlatTree.$at(ReadNode).FromArgInfo.ArgExpr);
      ToExpr.$set(FlatTree.$at(ReadNode).ToArgInfo.ArgExpr);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::GetDeclarationDiff">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 790,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::GetDeclarationDiff", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree18GetDeclarationDiffERPN5clang9ValueDeclES5_RbS6_S6_S6_RPNS2_4ExprES9_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree18GetDeclarationDiffERPN5clang9ValueDeclES5_RbS6_S6_S6_RPNS2_4ExprES9_")
    //</editor-fold>
    public void GetDeclarationDiff(final type$ref<ValueDecl /*P*/ /*&*/> FromValueDecl, final type$ref<ValueDecl /*P*/ /*&*/> ToValueDecl, 
                      final bool$ref/*bool &*/ FromAddressOf, final bool$ref/*bool &*/ ToAddressOf, 
                      final bool$ref/*bool &*/ FromNullPtr, final bool$ref/*bool &*/ ToNullPtr, final type$ref<Expr /*P*/ /*&*/> FromExpr, 
                      final type$ref<Expr /*P*/ /*&*/> ToExpr) {
      assert (FlatTree.$at(ReadNode).Kind == DiffKind.Declaration) : "Unexpected kind.";
      FromValueDecl.$set(FlatTree.$at(ReadNode).FromArgInfo.VD);
      ToValueDecl.$set(FlatTree.$at(ReadNode).ToArgInfo.VD);
      FromAddressOf.$set(FlatTree.$at(ReadNode).FromArgInfo.NeedAddressOf);
      ToAddressOf.$set(FlatTree.$at(ReadNode).ToArgInfo.NeedAddressOf);
      FromNullPtr.$set(FlatTree.$at(ReadNode).FromArgInfo.IsNullPtr);
      ToNullPtr.$set(FlatTree.$at(ReadNode).ToArgInfo.IsNullPtr);
      FromExpr.$set(FlatTree.$at(ReadNode).FromArgInfo.ArgExpr);
      ToExpr.$set(FlatTree.$at(ReadNode).ToArgInfo.ArgExpr);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::GetFromDeclarationAndToIntegerDiff">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 805,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::GetFromDeclarationAndToIntegerDiff", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree34GetFromDeclarationAndToIntegerDiffERPN5clang9ValueDeclERbS6_RPNS2_4ExprERN4llvm6APSIntES6_RNS2_8QualTypeES9_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree34GetFromDeclarationAndToIntegerDiffERPN5clang9ValueDeclERbS6_RPNS2_4ExprERN4llvm6APSIntES6_RNS2_8QualTypeES9_")
    //</editor-fold>
    public void GetFromDeclarationAndToIntegerDiff(final type$ref<ValueDecl /*P*/ /*&*/> FromValueDecl, final bool$ref/*bool &*/ FromAddressOf, final bool$ref/*bool &*/ FromNullPtr, 
                                      final type$ref<Expr /*P*/ /*&*/> FromExpr, final APSInt /*&*/ ToInt, final bool$ref/*bool &*/ IsValidToInt, 
                                      final QualType /*&*/ ToIntType, final type$ref<Expr /*P*/ /*&*/> ToExpr) {
      assert (FlatTree.$at(ReadNode).Kind == DiffKind.FromDeclarationAndToInteger) : "Unexpected kind.";
      FromValueDecl.$set(FlatTree.$at(ReadNode).FromArgInfo.VD);
      FromAddressOf.$set(FlatTree.$at(ReadNode).FromArgInfo.NeedAddressOf);
      FromNullPtr.$set(FlatTree.$at(ReadNode).FromArgInfo.IsNullPtr);
      FromExpr.$set(FlatTree.$at(ReadNode).FromArgInfo.ArgExpr);
      ToInt.$assign(FlatTree.$at(ReadNode).ToArgInfo.Val);
      IsValidToInt.$set(FlatTree.$at(ReadNode).ToArgInfo.IsValidInt);
      ToIntType.$assign(FlatTree.$at(ReadNode).ToArgInfo.ArgType);
      ToExpr.$set(FlatTree.$at(ReadNode).ToArgInfo.ArgExpr);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::GetFromIntegerAndToDeclarationDiff">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 821,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::GetFromIntegerAndToDeclarationDiff", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree34GetFromIntegerAndToDeclarationDiffERN4llvm6APSIntERbRN5clang8QualTypeERPNS6_4ExprERPNS6_9ValueDeclES5_S5_SB_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree34GetFromIntegerAndToDeclarationDiffERN4llvm6APSIntERbRN5clang8QualTypeERPNS6_4ExprERPNS6_9ValueDeclES5_S5_SB_")
    //</editor-fold>
    public void GetFromIntegerAndToDeclarationDiff(final APSInt /*&*/ FromInt, final bool$ref/*bool &*/ IsValidFromInt, final QualType /*&*/ FromIntType, 
                                      final type$ref<Expr /*P*/ /*&*/> FromExpr, final type$ref<ValueDecl /*P*/ /*&*/> ToValueDecl, final bool$ref/*bool &*/ ToAddressOf, 
                                      final bool$ref/*bool &*/ ToNullPtr, final type$ref<Expr /*P*/ /*&*/> ToExpr) {
      assert (FlatTree.$at(ReadNode).Kind == DiffKind.FromIntegerAndToDeclaration) : "Unexpected kind.";
      FromInt.$assign(FlatTree.$at(ReadNode).FromArgInfo.Val);
      IsValidFromInt.$set(FlatTree.$at(ReadNode).FromArgInfo.IsValidInt);
      FromIntType.$assign(FlatTree.$at(ReadNode).FromArgInfo.ArgType);
      FromExpr.$set(FlatTree.$at(ReadNode).FromArgInfo.ArgExpr);
      ToValueDecl.$set(FlatTree.$at(ReadNode).ToArgInfo.VD);
      ToAddressOf.$set(FlatTree.$at(ReadNode).ToArgInfo.NeedAddressOf);
      ToNullPtr.$set(FlatTree.$at(ReadNode).ToArgInfo.IsNullPtr);
      ToExpr.$set(FlatTree.$at(ReadNode).ToArgInfo.ArgExpr);
    }

    
    /// FromDefault - Return true if the from argument is the default.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::FromDefault">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 838,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::FromDefault", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree11FromDefaultEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree11FromDefaultEv")
    //</editor-fold>
    public boolean FromDefault() {
      return FlatTree.$at(ReadNode).FromArgInfo.IsDefault;
    }

    
    /// ToDefault - Return true if the to argument is the default.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::ToDefault">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 843,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::ToDefault", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree9ToDefaultEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree9ToDefaultEv")
    //</editor-fold>
    public boolean ToDefault() {
      return FlatTree.$at(ReadNode).ToArgInfo.IsDefault;
    }

    
    /// NodeIsSame - Returns true the arguments are the same.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::NodeIsSame">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 848,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::NodeIsSame", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree10NodeIsSameEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree10NodeIsSameEv")
    //</editor-fold>
    public boolean NodeIsSame() {
      return FlatTree.$at(ReadNode).Same;
    }

    
    /// HasChildrend - Returns true if the node has children.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::HasChildren">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 853,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::HasChildren", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree11HasChildrenEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree11HasChildrenEv")
    //</editor-fold>
    public boolean HasChildren() {
      return FlatTree.$at(ReadNode).ChildNode != 0;
    }

    
    /// MoveToChild - Moves from the current node to its child.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::MoveToChild">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 858,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::MoveToChild", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree11MoveToChildEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree11MoveToChildEv")
    //</editor-fold>
    public void MoveToChild() {
      ReadNode = FlatTree.$at(ReadNode).ChildNode;
    }

    
    /// AdvanceSibling - If there is a next sibling, advance to it and return
    /// true.  Otherwise, return false.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::AdvanceSibling">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 864,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::AdvanceSibling", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree14AdvanceSiblingEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree14AdvanceSiblingEv")
    //</editor-fold>
    public boolean AdvanceSibling() {
      if (FlatTree.$at(ReadNode).NextNode == 0) {
        return false;
      }
      
      ReadNode = FlatTree.$at(ReadNode).NextNode;
      return true;
    }

    
    /// HasNextSibling - Return true if the node has a next sibling.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::HasNextSibling">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 873,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::HasNextSibling", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree14HasNextSiblingEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree14HasNextSiblingEv")
    //</editor-fold>
    public boolean HasNextSibling() {
      return FlatTree.$at(ReadNode).NextNode != 0;
    }

    
    /// Empty - Returns true if the tree has no information.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::Empty">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 878,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::Empty", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree5EmptyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree5EmptyEv")
    //</editor-fold>
    public boolean Empty() {
      return GetKind() == DiffKind.Invalid;
    }

    
    /// GetKind - Returns the current node's type.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::GetKind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 883,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::GetKind", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree7GetKindEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree7GetKindEv")
    //</editor-fold>
    public DiffKind GetKind() {
      return FlatTree.$at(ReadNode).Kind;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::~DiffTree">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 492,
     FQN="(anonymous namespace)::TemplateDiff::DiffTree::~DiffTree", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTreeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTreeD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      FlatTree.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "FlatTree=" + FlatTree // NOI18N
                + ", CurrentNode=" + CurrentNode // NOI18N
                + ", NextFreeNode=" + NextFreeNode // NOI18N
                + ", ReadNode=" + ReadNode; // NOI18N
    }
  };
  
  private DiffTree Tree;
  
  /// TSTiterator - a pair of iterators that walks the
  /// TemplateSpecializationType and the desugared TemplateSpecializationType.
  /// The deseguared TemplateArgument should provide the canonical argument
  /// for comparisons.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TSTiterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 894,
   FQN="(anonymous namespace)::TemplateDiff::TSTiterator", NM="_ZN12_GLOBAL__N_112TemplateDiff11TSTiteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff11TSTiteratorE")
  //</editor-fold>
  private static class TSTiterator implements type$iterator<TSTiterator, TemplateArgument> {
    /*typedef const TemplateArgument &reference*/
//    public final class reference extends /*const*/ TemplateArgument /*&*/ { };
    /*typedef const TemplateArgument *pointer*/
//    public final class pointer extends /*const*/type$ptr<TemplateArgument/*P*/> { };
    
    /// InternalIterator - an iterator that is used to enter a
    /// TemplateSpecializationType and read TemplateArguments inside template
    /// parameter packs in order with the rest of the TemplateArguments.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TSTiterator::InternalIterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 901,
     FQN="(anonymous namespace)::TemplateDiff::TSTiterator::InternalIterator", NM="_ZN12_GLOBAL__N_112TemplateDiff11TSTiterator16InternalIteratorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff11TSTiterator16InternalIteratorE")
    //</editor-fold>
    private static class/*struct*/ InternalIterator implements type$iterator<InternalIterator, TemplateArgument> {
      /// TST - the template specialization whose arguments this iterator
      /// traverse over.
      public /*const*/ TemplateSpecializationType /*P*/ TST;
      
      /// Index - the index of the template argument in TST.
      public /*uint*/int Index;
      
      /// CurrentTA - if CurrentTA is not the same as EndTA, then CurrentTA
      /// points to a TemplateArgument within a parameter pack.
      public type$ptr<TemplateArgument>/*pack_iterator*/ CurrentTA;
      
      /// EndTA - the end iterator of a parameter pack
      public type$ptr<TemplateArgument>/*pack_iterator*/ EndTA;
      
      /// InternalIterator - Constructs an iterator and sets it to the first
      /// template argument.
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TSTiterator::InternalIterator::InternalIterator">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 918,
       FQN="(anonymous namespace)::TemplateDiff::TSTiterator::InternalIterator::InternalIterator", NM="_ZN12_GLOBAL__N_112TemplateDiff11TSTiterator16InternalIteratorC1EPKN5clang26TemplateSpecializationTypeE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff11TSTiterator16InternalIteratorC1EPKN5clang26TemplateSpecializationTypeE")
      //</editor-fold>
      public InternalIterator(/*const*/ TemplateSpecializationType /*P*/ TST) {
        // : TST(TST), Index(0), CurrentTA(null), EndTA(null) 
        //START JInit
        this.TST = TST;
        this.Index = 0;
        this.CurrentTA = null;
        this.EndTA = null;
        //END JInit
        if (!(TST != null)) {
          return;
        }
        if (isEnd()) {
          return;
        }
        
        // Set to first template argument.  If not a parameter pack, done.
        TemplateArgument TA = new TemplateArgument(TST.getArg(0));
        if (TA.getKind() != TemplateArgument.ArgKind.Pack) {
          return;
        }
        
        // Start looking into the parameter pack.
        CurrentTA = $tryClone(TA.pack_begin());
        EndTA = $tryClone(TA.pack_end());
        
        // Found a valid template argument.
        if ($noteq_ptr(CurrentTA, EndTA)) {
          return;
        }
        
        // Parameter pack is empty, use the increment to get to a valid
        // template argument.
        (/*Deref*/this).$preInc();
      }

      
      /// isEnd - Returns true if the iterator is one past the end.
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TSTiterator::InternalIterator::isEnd">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 941,
       FQN="(anonymous namespace)::TemplateDiff::TSTiterator::InternalIterator::isEnd", NM="_ZNK12_GLOBAL__N_112TemplateDiff11TSTiterator16InternalIterator5isEndEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZNK12_GLOBAL__N_112TemplateDiff11TSTiterator16InternalIterator5isEndEv")
      //</editor-fold>
      public boolean isEnd() /*const*/ {
        assert ((TST != null)) : "InternalIterator is invalid with a null TST.";
        return $greatereq_uint(Index, TST.getNumArgs());
      }

      
      /// &operator++ - Increment the iterator to the next template argument.
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TSTiterator::InternalIterator::operator++">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 947,
       FQN="(anonymous namespace)::TemplateDiff::TSTiterator::InternalIterator::operator++", NM="_ZN12_GLOBAL__N_112TemplateDiff11TSTiterator16InternalIteratorppEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff11TSTiterator16InternalIteratorppEv")
      //</editor-fold>
      public InternalIterator /*&*/ $preInc() {
        assert ((TST != null)) : "InternalIterator is invalid with a null TST.";
        if (isEnd()) {
          return /*Deref*/this;
        }
        
        // If in a parameter pack, advance in the parameter pack.
        if ($noteq_ptr(CurrentTA, EndTA)) {
          CurrentTA.$preInc();
          if ($noteq_ptr(CurrentTA, EndTA)) {
            return /*Deref*/this;
          }
        }
        
        // Loop until a template argument is found, or the end is reached.
        while (true) {
          // Advance to the next template argument.  Break if reached the end.
          if (++Index == TST.getNumArgs()) {
            break;
          }
          
          // If the TemplateArgument is not a parameter pack, done.
          TemplateArgument TA = new TemplateArgument(TST.getArg(Index));
          if (TA.getKind() != TemplateArgument.ArgKind.Pack) {
            break;
          }
          
          // Handle parameter packs.
          CurrentTA = $tryClone(TA.pack_begin());
          EndTA = $tryClone(TA.pack_end());
          
          // If the parameter pack is empty, try to advance again.
          if ($noteq_ptr(CurrentTA, EndTA)) {
            break;
          }
        }
        return /*Deref*/this;
      }

      
      /// operator* - Returns the appropriate TemplateArgument.
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TSTiterator::InternalIterator::operator*">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 983,
       FQN="(anonymous namespace)::TemplateDiff::TSTiterator::InternalIterator::operator*", NM="_ZNK12_GLOBAL__N_112TemplateDiff11TSTiterator16InternalIteratordeEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZNK12_GLOBAL__N_112TemplateDiff11TSTiterator16InternalIteratordeEv")
      //</editor-fold>
      public /*const*/ TemplateArgument /*&*/ $star() /*const*/ {
        assert ((TST != null)) : "InternalIterator is invalid with a null TST.";
        assert (!isEnd()) : "Index exceeds number of arguments.";
        if ($eq_ptr(CurrentTA, EndTA)) {
          return TST.getArg(Index);
        } else {
          return CurrentTA.$star();
        }
      }

      
      /// operator-> - Allow access to the underlying TemplateArgument.
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TSTiterator::InternalIterator::operator->">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 993,
       FQN="(anonymous namespace)::TemplateDiff::TSTiterator::InternalIterator::operator->", NM="_ZNK12_GLOBAL__N_112TemplateDiff11TSTiterator16InternalIteratorptEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZNK12_GLOBAL__N_112TemplateDiff11TSTiterator16InternalIteratorptEv")
      //</editor-fold>
      public /*const*/TemplateArgument/*P*/ $arrow() /*const*/ {
        assert ((TST != null)) : "InternalIterator is invalid with a null TST.";
        return $AddrOf($star());
      }
      
      //////////////////////////////////////////////////////////////
      // EXTRA MEMBERS: BEGIN

      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TSTiterator::InternalIterator::InternalIterator">
      @Converted(kind = Converted.Kind.MANUAL,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 901,
       FQN="(anonymous namespace)::TemplateDiff::TSTiterator::InternalIterator::InternalIterator", NM="_ZN12_GLOBAL__N_112TemplateDiff11TSTiterator16InternalIteratorC1ERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff11TSTiterator16InternalIteratorC1ERKS2_")
      //</editor-fold>
      public /*inline*/ InternalIterator(final /*const*/ InternalIterator /*&*/ $Prm0) {
        this.TST = $Prm0.TST;
        this.Index = $Prm0.Index;
        this.CurrentTA = $tryClone($Prm0.CurrentTA);
        this.EndTA = $tryClone($Prm0.EndTA);
      }

      @Override
      public InternalIterator clone() {
        return new InternalIterator(this);
      }

      @Override
      public boolean $eq(Object obj) {
        if (this == obj) {
          return true;
        }
        if (obj == null) {
          return false;
        }
        final InternalIterator other = (InternalIterator) obj;
        if (this.Index != other.Index) {
          return false;
        }
        if (this.TST != other.TST) {
          return false;
        }
        if (!Native.$eq_ptr(this.CurrentTA, other.CurrentTA)) {
          return false;
        }
        if (!Native.$eq_ptr(this.EndTA, other.EndTA)) {
          return false;
        }
        return true;
      }
      
      // EXTRA MEMBERS: END
      //////////////////////////////////////////////////////////////
      
      @Override public String toString() {
        return "" + "TST=" + TST // NOI18N
                  + ", Index=" + Index // NOI18N
                  + ", CurrentTA=" + CurrentTA // NOI18N
                  + ", EndTA=" + EndTA; // NOI18N
      }
    };
    
    private boolean UseDesugaredIterator;
    private InternalIterator SugaredIterator;
    private InternalIterator DesugaredIterator;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TSTiterator::TSTiterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1004,
     FQN="(anonymous namespace)::TemplateDiff::TSTiterator::TSTiterator", NM="_ZN12_GLOBAL__N_112TemplateDiff11TSTiteratorC1ERN5clang10ASTContextEPKNS2_26TemplateSpecializationTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff11TSTiteratorC1ERN5clang10ASTContextEPKNS2_26TemplateSpecializationTypeE")
    //</editor-fold>
    public TSTiterator(final ASTContext /*&*/ Context, /*const*/ TemplateSpecializationType /*P*/ TST) {
      // : UseDesugaredIterator(TST->isSugared() && !TST->isTypeAlias()), SugaredIterator(TST), DesugaredIterator(GetTemplateSpecializationType(Context, TST->desugar())) 
      //START JInit
      this.UseDesugaredIterator = TST.isSugared() && !TST.isTypeAlias();
      this.SugaredIterator = $tryClone(new InternalIterator(TST));
      this.DesugaredIterator = $tryClone(new InternalIterator(GetTemplateSpecializationType(Context, TST.desugar())));
      //END JInit
    }

    
    /// &operator++ - Increment the iterator to the next template argument.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TSTiterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1011,
     FQN="(anonymous namespace)::TemplateDiff::TSTiterator::operator++", NM="_ZN12_GLOBAL__N_112TemplateDiff11TSTiteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff11TSTiteratorppEv")
    //</editor-fold>
    public TSTiterator /*&*/ $preInc() {
      SugaredIterator.$preInc();
      if (UseDesugaredIterator) {
        DesugaredIterator.$preInc();
      }
      return /*Deref*/this;
    }

    
    /// operator* - Returns the appropriate TemplateArgument.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TSTiterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1019,
     FQN="(anonymous namespace)::TemplateDiff::TSTiterator::operator*", NM="_ZNK12_GLOBAL__N_112TemplateDiff11TSTiteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZNK12_GLOBAL__N_112TemplateDiff11TSTiteratordeEv")
    //</editor-fold>
    public /*const*/ TemplateArgument /*&*/ $star() /*const*/ {
      return SugaredIterator.$star();
    }

    
    /// operator-> - Allow access to the underlying TemplateArgument.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TSTiterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1024,
     FQN="(anonymous namespace)::TemplateDiff::TSTiterator::operator->", NM="_ZNK12_GLOBAL__N_112TemplateDiff11TSTiteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZNK12_GLOBAL__N_112TemplateDiff11TSTiteratorptEv")
    //</editor-fold>
    public /*const*/TemplateArgument/*P*/ $arrow() /*const*/ {
      return $AddrOf($star());
    }

    
    /// isEnd - Returns true if no more TemplateArguments are available.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TSTiterator::isEnd">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1029,
     FQN="(anonymous namespace)::TemplateDiff::TSTiterator::isEnd", NM="_ZNK12_GLOBAL__N_112TemplateDiff11TSTiterator5isEndEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZNK12_GLOBAL__N_112TemplateDiff11TSTiterator5isEndEv")
    //</editor-fold>
    public boolean isEnd() /*const*/ {
      return SugaredIterator.isEnd();
    }

    
    /// hasDesugaredTA - Returns true if there is another TemplateArgument
    /// available.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TSTiterator::hasDesugaredTA">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1035,
     FQN="(anonymous namespace)::TemplateDiff::TSTiterator::hasDesugaredTA", NM="_ZNK12_GLOBAL__N_112TemplateDiff11TSTiterator14hasDesugaredTAEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZNK12_GLOBAL__N_112TemplateDiff11TSTiterator14hasDesugaredTAEv")
    //</editor-fold>
    public boolean hasDesugaredTA() /*const*/ {
      return UseDesugaredIterator && !DesugaredIterator.isEnd();
    }

    
    /// getDesugaredTA - Returns the desugared TemplateArgument.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TSTiterator::getDesugaredTA">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1040,
     FQN="(anonymous namespace)::TemplateDiff::TSTiterator::getDesugaredTA", NM="_ZNK12_GLOBAL__N_112TemplateDiff11TSTiterator14getDesugaredTAEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZNK12_GLOBAL__N_112TemplateDiff11TSTiterator14getDesugaredTAEv")
    //</editor-fold>
    public /*const*/ TemplateArgument /*&*/ getDesugaredTA() /*const*/ {
      assert (UseDesugaredIterator) : "Desugared TemplateArgument should not be used.";
      return DesugaredIterator.$star();
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TSTiterator::TSTiterator">
    @Converted(kind = Converted.Kind.MANUAL_ADDED,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 894,
     FQN="(anonymous namespace)::TemplateDiff::TSTiterator::TSTiterator", NM="_ZN12_GLOBAL__N_112TemplateDiff11TSTiteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff11TSTiteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ TSTiterator(final /*const*/ TSTiterator /*&*/ $Prm0) {
      this.UseDesugaredIterator = $Prm0.UseDesugaredIterator;
      this.SugaredIterator = $tryClone($Prm0.SugaredIterator);
      this.DesugaredIterator = $tryClone($Prm0.DesugaredIterator);
    }

    @Override
    public TSTiterator clone() {
      return new TSTiterator(this);
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "UseDesugaredIterator=" + UseDesugaredIterator // NOI18N
                + ", SugaredIterator=" + SugaredIterator // NOI18N
                + ", DesugaredIterator=" + DesugaredIterator; // NOI18N
    }
  };
  
  // These functions build up the template diff tree, including functions to
  // retrieve and compare template arguments.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::GetTemplateSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1050,
   FQN="(anonymous namespace)::TemplateDiff::GetTemplateSpecializationType", NM="_ZN12_GLOBAL__N_112TemplateDiff29GetTemplateSpecializationTypeERN5clang10ASTContextENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff29GetTemplateSpecializationTypeERN5clang10ASTContextENS1_8QualTypeE")
  //</editor-fold>
  private static /*const*/ TemplateSpecializationType /*P*/ GetTemplateSpecializationType(final ASTContext /*&*/ Context, QualType Ty) {
    {
      /*const*/ TemplateSpecializationType /*P*/ TST = Ty.$arrow().getAs$TemplateSpecializationType();
      if ((TST != null)) {
        return TST;
      }
    }
    
    /*const*/ RecordType /*P*/ RT = Ty.$arrow().getAs$RecordType();
    if (!(RT != null)) {
      return null;
    }
    
    /*const*/ ClassTemplateSpecializationDecl /*P*/ CTSD = dyn_cast_ClassTemplateSpecializationDecl(RT.getDecl());
    if (!(CTSD != null)) {
      return null;
    }
    
    Ty.$assignMove(Context.getTemplateSpecializationType(new TemplateName(CTSD.getSpecializedTemplate()), 
            CTSD.getTemplateArgs().asArray(), 
            Ty.getLocalUnqualifiedType().getCanonicalType()));
    
    return Ty.$arrow().getAs$TemplateSpecializationType();
  }

  
  /// Returns true if the DiffType is Type and false for Template.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::OnlyPerformTypeDiff">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1076,
   FQN="(anonymous namespace)::TemplateDiff::OnlyPerformTypeDiff", NM="_ZN12_GLOBAL__N_112TemplateDiff19OnlyPerformTypeDiffERN5clang10ASTContextENS1_8QualTypeES4_RPKNS1_26TemplateSpecializationTypeES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff19OnlyPerformTypeDiffERN5clang10ASTContextENS1_8QualTypeES4_RPKNS1_26TemplateSpecializationTypeES8_")
  //</editor-fold>
  private static boolean OnlyPerformTypeDiff(final ASTContext /*&*/ Context, QualType FromType, 
                     QualType ToType, 
                     final type$ref</*const*/ TemplateSpecializationType /*P*/ /*&*/> FromArgTST, 
                     final type$ref</*const*/ TemplateSpecializationType /*P*/ /*&*/> ToArgTST) {
    if (FromType.isNull() || ToType.isNull()) {
      return true;
    }
    if (Context.hasSameType(new QualType(FromType), new QualType(ToType))) {
      return true;
    }
    
    FromArgTST.$set(GetTemplateSpecializationType(Context, new QualType(FromType)));
    ToArgTST.$set(GetTemplateSpecializationType(Context, new QualType(ToType)));
    if (!(FromArgTST.$deref() != null) || !(ToArgTST.$deref() != null)) {
      return true;
    }
    if (!hasSameTemplate(FromArgTST, ToArgTST)) {
      return true;
    }
    
    return false;
  }

  
  /// DiffTypes - Fills a DiffNode with information about a type difference.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1099,
   FQN="(anonymous namespace)::TemplateDiff::DiffTypes", NM="_ZN12_GLOBAL__N_112TemplateDiff9DiffTypesERKNS0_11TSTiteratorES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff9DiffTypesERKNS0_11TSTiteratorES3_")
  //</editor-fold>
  private void DiffTypes(final /*const*/ TSTiterator /*&*/ FromIter, final /*const*/ TSTiterator /*&*/ ToIter) {
    QualType FromType = GetType(FromIter);
    QualType ToType = GetType(ToIter);
    
    boolean FromDefault = FromIter.isEnd() && !FromType.isNull();
    boolean ToDefault = ToIter.isEnd() && !ToType.isNull();
    
    type$ref</*const*/ TemplateSpecializationType /*P*/ > FromArgTST = create_type$null$ref(null);
    type$ref</*const*/ TemplateSpecializationType /*P*/ > ToArgTST = create_type$null$ref(null);
    if (OnlyPerformTypeDiff(Context, new QualType(FromType), new QualType(ToType), FromArgTST, ToArgTST)) {
      Tree.SetTypeDiff(new QualType(FromType), new QualType(ToType), FromDefault, ToDefault);
      Tree.SetSame(!FromType.isNull() && !ToType.isNull()
             && Context.hasSameType(new QualType(FromType), new QualType(ToType)));
    } else {
      assert ((FromArgTST.$deref() != null) && (ToArgTST.$deref() != null)) : "Both template specializations need to be valid.";
      Qualifiers FromQual = FromType.getQualifiers();
      Qualifiers ToQual = ToType.getQualifiers();
      FromQual.$minusassign(new QualType(FromArgTST.$deref(), 0).getQualifiers());
      ToQual.$minusassign(new QualType(ToArgTST.$deref(), 0).getQualifiers());
      Tree.SetTemplateDiff(FromArgTST.$deref().getTemplateName().getAsTemplateDecl(), 
          ToArgTST.$deref().getTemplateName().getAsTemplateDecl(), 
          new Qualifiers(FromQual), new Qualifiers(ToQual), FromDefault, ToDefault);
      DiffTemplate(FromArgTST.$deref(), ToArgTST.$deref());
    }
  }

  
  /// DiffTemplateTemplates - Fills a DiffNode with information about a
  /// template template difference.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTemplateTemplates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1128,
   FQN="(anonymous namespace)::TemplateDiff::DiffTemplateTemplates", NM="_ZN12_GLOBAL__N_112TemplateDiff21DiffTemplateTemplatesERKNS0_11TSTiteratorES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff21DiffTemplateTemplatesERKNS0_11TSTiteratorES3_")
  //</editor-fold>
  private void DiffTemplateTemplates(final /*const*/ TSTiterator /*&*/ FromIter, 
                       final /*const*/ TSTiterator /*&*/ ToIter) {
    TemplateDecl /*P*/ FromDecl = GetTemplateDecl(FromIter);
    TemplateDecl /*P*/ ToDecl = GetTemplateDecl(ToIter);
    Tree.SetTemplateTemplateDiff(FromDecl, ToDecl, FromIter.isEnd() && (FromDecl != null), 
        ToIter.isEnd() && (ToDecl != null));
    Tree.SetSame((FromDecl != null) && (ToDecl != null)
           && FromDecl.getCanonicalDecl() == ToDecl.getCanonicalDecl());
  }

  
  /// InitializeNonTypeDiffVariables - Helper function for DiffNonTypes
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::InitializeNonTypeDiffVariables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1139,
   FQN="(anonymous namespace)::TemplateDiff::InitializeNonTypeDiffVariables", NM="_ZN12_GLOBAL__N_112TemplateDiff30InitializeNonTypeDiffVariablesERN5clang10ASTContextERKNS0_11TSTiteratorEPNS1_23NonTypeTemplateParmDeclERN4llvm6APSIntERbRNS1_8QualTypeESC_RPNS1_4ExprERPNS1_9ValueDeclESC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff30InitializeNonTypeDiffVariablesERN5clang10ASTContextERKNS0_11TSTiteratorEPNS1_23NonTypeTemplateParmDeclERN4llvm6APSIntERbRNS1_8QualTypeESC_RPNS1_4ExprERPNS1_9ValueDeclESC_")
  //</editor-fold>
  private static void InitializeNonTypeDiffVariables(final ASTContext /*&*/ Context, 
                                final /*const*/ TSTiterator /*&*/ Iter, 
                                NonTypeTemplateParmDecl /*P*/ Default, 
                                final APSInt /*&*/ Value, final bool$ref/*bool &*/ HasInt, 
                                final QualType /*&*/ IntType, final bool$ref/*bool &*/ IsNullPtr, 
                                final type$ref<Expr /*P*/ /*&*/> E, final type$ref<ValueDecl /*P*/ /*&*/> VD, 
                                final bool$ref/*bool &*/ NeedAddressOf) {
    if (!Iter.isEnd()) {
      switch (Iter.$arrow().getKind()) {
       default:
        throw new llvm_unreachable("unknown ArgumentKind");
       case Integral:
        Value.$assignMove(Iter.$arrow().getAsIntegral());
        HasInt.$set(true);
        IntType.$assignMove(Iter.$arrow().getIntegralType());
        return;
       case Declaration:
        {
          VD.$set(Iter.$arrow().getAsDecl());
          QualType ArgType = Iter.$arrow().getParamTypeForDecl();
          QualType VDType = VD.$deref().getType();
          if (ArgType.$arrow().isPointerType()
             && Context.hasSameType(ArgType.$arrow().getPointeeType(), new QualType(VDType))) {
            NeedAddressOf.$set(true);
          }
          return;
        }
       case NullPtr:
        IsNullPtr.$set(true);
        return;
       case Expression:
        E.$set(Iter.$arrow().getAsExpr());
      }
    } else if (!Default.isParameterPack()) {
      E.$set(Default.getDefaultArgument());
    }
    if (!Iter.hasDesugaredTA()) {
      return;
    }
    
    final /*const*/ TemplateArgument /*&*/ TA = Iter.getDesugaredTA();
    switch (TA.getKind()) {
     default:
      throw new llvm_unreachable("unknown ArgumentKind");
     case Integral:
      Value.$assignMove(TA.getAsIntegral());
      HasInt.$set(true);
      IntType.$assignMove(TA.getIntegralType());
      return;
     case Declaration:
      {
        VD.$set(TA.getAsDecl());
        QualType ArgType = TA.getParamTypeForDecl();
        QualType VDType = VD.$deref().getType();
        if (ArgType.$arrow().isPointerType()
           && Context.hasSameType(ArgType.$arrow().getPointeeType(), new QualType(VDType))) {
          NeedAddressOf.$set(true);
        }
        return;
      }
     case NullPtr:
      IsNullPtr.$set(true);
      return;
     case Expression:
      // TODO: Sometimes, the desugared template argument Expr differs from
      // the sugared template argument Expr.  It may be useful in the future
      // but for now, it is just discarded.
      if (!(E.$deref() != null)) {
        E.$set(TA.getAsExpr());
      }
      return;
    }
  }

  
  /// DiffNonTypes - Handles any template parameters not handled by DiffTypes
  /// of DiffTemplatesTemplates, such as integer and declaration parameters.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffNonTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1209,
   FQN="(anonymous namespace)::TemplateDiff::DiffNonTypes", NM="_ZN12_GLOBAL__N_112TemplateDiff12DiffNonTypesERKNS0_11TSTiteratorES3_PN5clang23NonTypeTemplateParmDeclES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff12DiffNonTypesERKNS0_11TSTiteratorES3_PN5clang23NonTypeTemplateParmDeclES6_")
  //</editor-fold>
  private void DiffNonTypes(final /*const*/ TSTiterator /*&*/ FromIter, final /*const*/ TSTiterator /*&*/ ToIter, 
              NonTypeTemplateParmDecl /*P*/ FromDefaultNonTypeDecl, 
              NonTypeTemplateParmDecl /*P*/ ToDefaultNonTypeDecl) {
    type$ref<Expr /*P*/ > FromExpr = create_type$null$ref(null);
    type$ref<Expr /*P*/ > ToExpr = create_type$null$ref(null);
    APSInt FromInt/*J*/= new APSInt();
    APSInt ToInt/*J*/= new APSInt();
    QualType FromIntType/*J*/= new QualType();
    QualType ToIntType/*J*/= new QualType();
    type$ref<ValueDecl /*P*/ > FromValueDecl = create_type$null$ref(null);
    type$ref<ValueDecl /*P*/ > ToValueDecl = create_type$null$ref(null);
    bool$ref HasFromInt = create_bool$ref(false);
    bool$ref HasToInt = create_bool$ref(false);
    bool$ref FromNullPtr = create_bool$ref(false);
    bool$ref ToNullPtr = create_bool$ref(false);
    bool$ref NeedFromAddressOf = create_bool$ref(false);
    bool$ref NeedToAddressOf = create_bool$ref(false);
    InitializeNonTypeDiffVariables(Context, FromIter, FromDefaultNonTypeDecl, FromInt, HasFromInt, 
        FromIntType, FromNullPtr, FromExpr, FromValueDecl, NeedFromAddressOf);
    InitializeNonTypeDiffVariables(Context, ToIter, ToDefaultNonTypeDecl, ToInt, 
        HasToInt, ToIntType, ToNullPtr, ToExpr, 
        ToValueDecl, NeedToAddressOf);
    
    boolean FromDefault = FromIter.isEnd()
       && ((FromExpr.$deref() != null) || (FromValueDecl.$deref() != null) || HasFromInt.$deref() || FromNullPtr.$deref());
    boolean ToDefault = ToIter.isEnd()
       && ((ToExpr.$deref() != null) || (ToValueDecl.$deref() != null) || HasToInt.$deref() || ToNullPtr.$deref());
    
    boolean FromDeclaration = (FromValueDecl.$deref() != null) || FromNullPtr.$deref();
    boolean ToDeclaration = (ToValueDecl.$deref() != null) || ToNullPtr.$deref();
    if (FromDeclaration && HasToInt.$deref()) {
      Tree.SetFromDeclarationAndToIntegerDiff(FromValueDecl.$deref(), NeedFromAddressOf.$deref(), FromNullPtr.$deref(), FromExpr.$deref(), ToInt, 
          HasToInt.$deref(), new QualType(ToIntType), ToExpr.$deref(), FromDefault, ToDefault);
      Tree.SetSame(false);
      return;
    }
    if (HasFromInt.$deref() && ToDeclaration) {
      Tree.SetFromIntegerAndToDeclarationDiff(FromInt, HasFromInt.$deref(), new QualType(FromIntType), FromExpr.$deref(), ToValueDecl.$deref(), 
          NeedToAddressOf.$deref(), ToNullPtr.$deref(), ToExpr.$deref(), FromDefault, ToDefault);
      Tree.SetSame(false);
      return;
    }
    if (HasFromInt.$deref() || HasToInt.$deref()) {
      Tree.SetIntegerDiff(FromInt, ToInt, HasFromInt.$deref(), HasToInt.$deref(), new QualType(FromIntType), 
          new QualType(ToIntType), FromExpr.$deref(), ToExpr.$deref(), FromDefault, ToDefault);
      if (HasFromInt.$deref() && HasToInt.$deref()) {
        Tree.SetSame(Context.hasSameType(new QualType(FromIntType), new QualType(ToIntType))
               && FromInt.$eq(ToInt));
      }
      return;
    }
    if (FromDeclaration || ToDeclaration) {
      Tree.SetDeclarationDiff(FromValueDecl.$deref(), ToValueDecl.$deref(), NeedFromAddressOf.$deref(), 
          NeedToAddressOf.$deref(), FromNullPtr.$deref(), ToNullPtr.$deref(), FromExpr.$deref(), 
          ToExpr.$deref(), FromDefault, ToDefault);
      boolean BothNull = FromNullPtr.$deref() && ToNullPtr.$deref();
      boolean SameValueDecl = (FromValueDecl.$deref() != null) && (ToValueDecl.$deref() != null)
         && NeedFromAddressOf.$deref() == NeedToAddressOf.$deref()
         && FromValueDecl.$deref().getCanonicalDecl() == ToValueDecl.$deref().getCanonicalDecl();
      Tree.SetSame(BothNull || SameValueDecl);
      return;
    }
    assert (((FromExpr.$deref() != null) || (ToExpr.$deref() != null))) : "Both template arguments cannot be empty.";
    Tree.SetExpressionDiff(FromExpr.$deref(), ToExpr.$deref(), FromDefault, ToDefault);
    Tree.SetSame(IsEqualExpr(Context, FromExpr.$deref(), ToExpr.$deref()));
  }

  
  /// DiffTemplate - recursively visits template arguments and stores the
  /// argument info into a tree.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1280,
   FQN="(anonymous namespace)::TemplateDiff::DiffTemplate", NM="_ZN12_GLOBAL__N_112TemplateDiff12DiffTemplateEPKN5clang26TemplateSpecializationTypeES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff12DiffTemplateEPKN5clang26TemplateSpecializationTypeES4_")
  //</editor-fold>
  private void DiffTemplate(/*const*/ TemplateSpecializationType /*P*/ FromTST, 
              /*const*/ TemplateSpecializationType /*P*/ ToTST) {
    // Begin descent into diffing template tree.
    TemplateParameterList /*P*/ ParamsFrom = FromTST.getTemplateName().getAsTemplateDecl().getTemplateParameters();
    TemplateParameterList /*P*/ ParamsTo = ToTST.getTemplateName().getAsTemplateDecl().getTemplateParameters();
    /*uint*/int TotalArgs = 0;
    for (TSTiterator FromIter/*J*/= new TSTiterator(Context, FromTST), ToIter/*J*/= new TSTiterator(Context, ToTST);
         !FromIter.isEnd() || !ToIter.isEnd(); ++TotalArgs) {
      Tree.AddNode();
      
      // Get the parameter at index TotalArgs.  If index is larger
      // than the total number of parameters, then there is an
      // argument pack, so re-use the last parameter.
      /*uint*/int FromParamIndex = std.min_uint(TotalArgs, ParamsFrom.size() - 1);
      /*uint*/int ToParamIndex = std.min_uint(TotalArgs, ParamsTo.size() - 1);
      NamedDecl /*P*/ FromParamND = ParamsFrom.getParam(FromParamIndex);
      NamedDecl /*P*/ ToParamND = ParamsTo.getParam(ToParamIndex);
      assert (FromParamND.getKind() == ToParamND.getKind()) : "Parameter Decl are not the same kind.";
      if (isa_TemplateTypeParmDecl(FromParamND)) {
        DiffTypes(FromIter, ToIter);
      } else if (isa_TemplateTemplateParmDecl(FromParamND)) {
        DiffTemplateTemplates(FromIter, ToIter);
      } else if (isa_NonTypeTemplateParmDecl(FromParamND)) {
        NonTypeTemplateParmDecl /*P*/ FromDefaultNonTypeDecl = cast_NonTypeTemplateParmDecl(FromParamND);
        NonTypeTemplateParmDecl /*P*/ ToDefaultNonTypeDecl = cast_NonTypeTemplateParmDecl(ToParamND);
        DiffNonTypes(FromIter, ToIter, FromDefaultNonTypeDecl, 
            ToDefaultNonTypeDecl);
      } else {
        throw new llvm_unreachable("Unexpected Decl type.");
      }
      
      FromIter.$preInc();
      ToIter.$preInc();
      Tree.Up();
    }
  }

  
  /// makeTemplateList - Dump every template alias into the vector.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::makeTemplateList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1325,
   FQN="(anonymous namespace)::TemplateDiff::makeTemplateList", NM="_ZN12_GLOBAL__N_112TemplateDiff16makeTemplateListERN4llvm15SmallVectorImplIPKN5clang26TemplateSpecializationTypeEEES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff16makeTemplateListERN4llvm15SmallVectorImplIPKN5clang26TemplateSpecializationTypeEEES6_")
  //</editor-fold>
  private static void makeTemplateList(final SmallVectorImpl</*const*/ TemplateSpecializationType /*P*/ > /*&*/ TemplateList, 
                  /*const*/ TemplateSpecializationType /*P*/ TST) {
    while ((TST != null)) {
      TemplateList.push_back(TST);
      if (!TST.isTypeAlias()) {
        return;
      }
      TST = TST.getAliasedType().$arrow().getAs$TemplateSpecializationType();
    }
  }

  
  /// hasSameBaseTemplate - Returns true when the base templates are the same,
  /// even if the template arguments are not.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::hasSameBaseTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1338,
   FQN="(anonymous namespace)::TemplateDiff::hasSameBaseTemplate", NM="_ZN12_GLOBAL__N_112TemplateDiff19hasSameBaseTemplateEPKN5clang26TemplateSpecializationTypeES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff19hasSameBaseTemplateEPKN5clang26TemplateSpecializationTypeES4_")
  //</editor-fold>
  private static boolean hasSameBaseTemplate(/*const*/ TemplateSpecializationType /*P*/ FromTST, 
                     /*const*/ TemplateSpecializationType /*P*/ ToTST) {
    return FromTST.getTemplateName().getAsTemplateDecl().getCanonicalDecl()
       == ToTST.getTemplateName().getAsTemplateDecl().getCanonicalDecl();
  }

  
  /// hasSameTemplate - Returns true if both types are specialized from the
  /// same template declaration.  If they come from different template aliases,
  /// do a parallel ascension search to determine the highest template alias in
  /// common and set the arguments to them.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::hasSameTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1348,
   FQN="(anonymous namespace)::TemplateDiff::hasSameTemplate", NM="_ZN12_GLOBAL__N_112TemplateDiff15hasSameTemplateERPKN5clang26TemplateSpecializationTypeES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff15hasSameTemplateERPKN5clang26TemplateSpecializationTypeES5_")
  //</editor-fold>
  private static boolean hasSameTemplate(final type$ref</*const*/ TemplateSpecializationType /*P*/ /*&*/> FromTST, 
                 final type$ref</*const*/ TemplateSpecializationType /*P*/ /*&*/> ToTST) {
    // Check the top templates if they are the same.
    if (hasSameBaseTemplate(FromTST.$deref(), ToTST.$deref())) {
      return true;
    }
    
    // Create vectors of template aliases.
    SmallVector</*const*/ TemplateSpecializationType /*P*/ > FromTemplateList/*J*/= new SmallVector</*const*/ TemplateSpecializationType /*P*/ >(1, (/*const*/ TemplateSpecializationType /*P*/ )null);
    SmallVector</*const*/ TemplateSpecializationType /*P*/ > ToTemplateList/*J*/= new SmallVector</*const*/ TemplateSpecializationType /*P*/ >(1, (/*const*/ TemplateSpecializationType /*P*/ )null);
    
    makeTemplateList(FromTemplateList, FromTST.$deref());
    makeTemplateList(ToTemplateList, ToTST.$deref());
    
    std.reverse_iterator</*const*/ TemplateSpecializationType /*P*/ > FromIter = FromTemplateList.rbegin();
    std.reverse_iterator</*const*/ TemplateSpecializationType /*P*/ > FromEnd = FromTemplateList.rend();
    std.reverse_iterator</*const*/ TemplateSpecializationType /*P*/ > ToIter = ToTemplateList.rbegin();
    std.reverse_iterator</*const*/ TemplateSpecializationType /*P*/ > ToEnd = ToTemplateList.rend();
    
    // Check if the lowest template types are the same.  If not, return.
    if (!hasSameBaseTemplate(FromIter.$star(), ToIter.$star())) {
      return false;
    }
    
    // Begin searching up the template aliases.  The bottom most template
    // matches so move up until one pair does not match.  Use the template
    // right before that one.
    for (; $noteq_reverse_iterator$C(FromIter, FromEnd) && $noteq_reverse_iterator$C(ToIter, ToEnd); FromIter.$preInc() , ToIter.$preInc()) {
      if (!hasSameBaseTemplate(FromIter.$star(), ToIter.$star())) {
        break;
      }
    }
    
    FromTST.$set(FromIter.$dec(1).$star());
    ToTST.$set(ToIter.$dec(1).$star());
    
    return true;
  }

  
  /// GetType - Retrieves the template type arguments, including default
  /// arguments.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::GetType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1385,
   FQN="(anonymous namespace)::TemplateDiff::GetType", NM="_ZN12_GLOBAL__N_112TemplateDiff7GetTypeERKNS0_11TSTiteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff7GetTypeERKNS0_11TSTiteratorE")
  //</editor-fold>
  private static QualType GetType(final /*const*/ TSTiterator /*&*/ Iter) {
    if (!Iter.isEnd()) {
      return Iter.$arrow().getAsType();
    }
    if (Iter.hasDesugaredTA()) {
      return Iter.getDesugaredTA().getAsType();
    }
    return new QualType();
  }

  
  /// GetTemplateDecl - Retrieves the template template arguments, including
  /// default arguments.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::GetTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1395,
   FQN="(anonymous namespace)::TemplateDiff::GetTemplateDecl", NM="_ZN12_GLOBAL__N_112TemplateDiff15GetTemplateDeclERKNS0_11TSTiteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff15GetTemplateDeclERKNS0_11TSTiteratorE")
  //</editor-fold>
  private static TemplateDecl /*P*/ GetTemplateDecl(final /*const*/ TSTiterator /*&*/ Iter) {
    if (!Iter.isEnd()) {
      return Iter.$arrow().getAsTemplate().getAsTemplateDecl();
    }
    if (Iter.hasDesugaredTA()) {
      return Iter.getDesugaredTA().getAsTemplate().getAsTemplateDecl();
    }
    return null;
  }

  
  /// IsEqualExpr - Returns true if the expressions are the same in regards to
  /// template arguments.  These expressions are dependent, so profile them
  /// instead of trying to evaluate them.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::IsEqualExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1406,
   FQN="(anonymous namespace)::TemplateDiff::IsEqualExpr", NM="_ZN12_GLOBAL__N_112TemplateDiff11IsEqualExprERN5clang10ASTContextEPNS1_4ExprES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff11IsEqualExprERN5clang10ASTContextEPNS1_4ExprES5_")
  //</editor-fold>
  private static boolean IsEqualExpr(final ASTContext /*&*/ Context, Expr /*P*/ FromExpr, Expr /*P*/ ToExpr) {
    if (FromExpr == ToExpr) {
      return true;
    }
    if (!(FromExpr != null) || !(ToExpr != null)) {
      return false;
    }
    
    FoldingSetNodeID FromID/*J*/= new FoldingSetNodeID();
    FoldingSetNodeID ToID/*J*/= new FoldingSetNodeID();
    FromExpr.Profile(FromID, Context, true);
    ToExpr.Profile(ToID, Context, true);
    return FromID.$eq(ToID);
  }

  
  // These functions converts the tree representation of the template
  // differences into the internal character vector.
  
  /// TreeToString - Converts the Tree object into a character stream which
  /// will later be turned into the output string.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TreeToString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1424,
   FQN="(anonymous namespace)::TemplateDiff::TreeToString", NM="_ZN12_GLOBAL__N_112TemplateDiff12TreeToStringEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff12TreeToStringEi")
  //</editor-fold>
  private void TreeToString() {
    TreeToString(1);
  }
  private void TreeToString(int Indent/*= 1*/) {
    if (PrintTree) {
      OS.$out_char($$LF);
      OS.indent(2 * Indent);
      ++Indent;
    }
    
    // Handle cases where the difference is not templates with different
    // arguments.
    switch (Tree.GetKind()) {
     case Invalid:
      throw new llvm_unreachable("Template diffing failed with bad DiffNode");
     case Type:
      {
        QualType FromType/*J*/= new QualType();
        QualType ToType/*J*/= new QualType();
        Tree.GetTypeDiff(FromType, ToType);
        PrintTypeNames(new QualType(FromType), new QualType(ToType), Tree.FromDefault(), Tree.ToDefault(), 
            Tree.NodeIsSame());
        return;
      }
     case Expression:
      {
        type$ref<Expr /*P*/ > FromExpr = create_type$ref();
        type$ref<Expr /*P*/ > ToExpr = create_type$ref();
        Tree.GetExpressionDiff(FromExpr, ToExpr);
        PrintExpr(FromExpr.$deref(), ToExpr.$deref(), Tree.FromDefault(), Tree.ToDefault(), 
            Tree.NodeIsSame());
        return;
      }
     case TemplateTemplate:
      {
        type$ref<TemplateDecl /*P*/ > FromTD = create_type$ref();
        type$ref<TemplateDecl /*P*/ > ToTD = create_type$ref();
        Tree.GetTemplateTemplateDiff(FromTD, ToTD);
        PrintTemplateTemplate(FromTD.$deref(), ToTD.$deref(), Tree.FromDefault(), 
            Tree.ToDefault(), Tree.NodeIsSame());
        return;
      }
     case Integer:
      {
        APSInt FromInt/*J*/= new APSInt();
        APSInt ToInt/*J*/= new APSInt();
        type$ref<Expr /*P*/ > FromExpr = create_type$ref();
        type$ref<Expr /*P*/ > ToExpr = create_type$ref();
        bool$ref IsValidFromInt = create_bool$ref();
        bool$ref IsValidToInt = create_bool$ref();
        QualType FromIntType/*J*/= new QualType();
        QualType ToIntType/*J*/= new QualType();
        Tree.GetIntegerDiff(FromInt, ToInt, IsValidFromInt, IsValidToInt, 
            FromIntType, ToIntType, FromExpr, ToExpr);
        PrintAPSInt(FromInt, ToInt, IsValidFromInt.$deref(), IsValidToInt.$deref(), new QualType(FromIntType), 
            new QualType(ToIntType), FromExpr.$deref(), ToExpr.$deref(), Tree.FromDefault(), 
            Tree.ToDefault(), Tree.NodeIsSame());
        return;
      }
     case Declaration:
      {
        type$ref<ValueDecl /*P*/ > FromValueDecl = create_type$ref();
        type$ref<ValueDecl /*P*/ > ToValueDecl = create_type$ref();
        bool$ref FromAddressOf = create_bool$ref();
        bool$ref ToAddressOf = create_bool$ref();
        bool$ref FromNullPtr = create_bool$ref();
        bool$ref ToNullPtr = create_bool$ref();
        type$ref<Expr /*P*/ > FromExpr = create_type$ref();
        type$ref<Expr /*P*/ > ToExpr = create_type$ref();
        Tree.GetDeclarationDiff(FromValueDecl, ToValueDecl, FromAddressOf, 
            ToAddressOf, FromNullPtr, ToNullPtr, FromExpr, 
            ToExpr);
        PrintValueDecl(FromValueDecl.$deref(), ToValueDecl.$deref(), FromAddressOf.$deref(), ToAddressOf.$deref(), 
            FromNullPtr.$deref(), ToNullPtr.$deref(), FromExpr.$deref(), ToExpr.$deref(), 
            Tree.FromDefault(), Tree.ToDefault(), Tree.NodeIsSame());
        return;
      }
     case FromDeclarationAndToInteger:
      {
        type$ref<ValueDecl /*P*/ > FromValueDecl = create_type$ref();
        bool$ref FromAddressOf = create_bool$ref();
        bool$ref FromNullPtr = create_bool$ref();
        type$ref<Expr /*P*/ > FromExpr = create_type$ref();
        APSInt ToInt/*J*/= new APSInt();
        bool$ref IsValidToInt = create_bool$ref();
        QualType ToIntType/*J*/= new QualType();
        type$ref<Expr /*P*/ > ToExpr = create_type$ref();
        Tree.GetFromDeclarationAndToIntegerDiff(FromValueDecl, FromAddressOf, FromNullPtr, FromExpr, ToInt, 
            IsValidToInt, ToIntType, ToExpr);
        assert (((FromValueDecl.$deref() != null) || FromNullPtr.$deref()) && IsValidToInt.$deref());
        PrintValueDeclAndInteger(FromValueDecl.$deref(), FromAddressOf.$deref(), FromNullPtr.$deref(), 
            FromExpr.$deref(), Tree.FromDefault(), ToInt, new QualType(ToIntType), 
            ToExpr.$deref(), Tree.ToDefault());
        return;
      }
     case FromIntegerAndToDeclaration:
      {
        APSInt FromInt/*J*/= new APSInt();
        bool$ref IsValidFromInt = create_bool$ref();
        QualType FromIntType/*J*/= new QualType();
        type$ref<Expr /*P*/ > FromExpr = create_type$ref();
        type$ref<ValueDecl /*P*/ > ToValueDecl = create_type$ref();
        bool$ref ToAddressOf = create_bool$ref();
        bool$ref ToNullPtr = create_bool$ref();
        type$ref<Expr /*P*/ > ToExpr = create_type$ref();
        Tree.GetFromIntegerAndToDeclarationDiff(FromInt, IsValidFromInt, FromIntType, FromExpr, ToValueDecl, 
            ToAddressOf, ToNullPtr, ToExpr);
        assert (IsValidFromInt.$deref() && ((ToValueDecl.$deref() != null) || ToNullPtr.$deref()));
        PrintIntegerAndValueDecl(FromInt, new QualType(FromIntType), FromExpr.$deref(), 
            Tree.FromDefault(), ToValueDecl.$deref(), ToAddressOf.$deref(), 
            ToNullPtr.$deref(), ToExpr.$deref(), Tree.ToDefault());
        return;
      }
     case Template:
      {
        // Node is root of template.  Recurse on children.
        type$ref<TemplateDecl /*P*/ > FromTD = create_type$ref();
        type$ref<TemplateDecl /*P*/ > ToTD = create_type$ref();
        Qualifiers FromQual/*J*/= new Qualifiers();
        Qualifiers ToQual/*J*/= new Qualifiers();
        Tree.GetTemplateDiff(FromTD, ToTD, FromQual, ToQual);
        
        PrintQualifiers(new Qualifiers(FromQual), new Qualifiers(ToQual));
        if (!Tree.HasChildren()) {
          // If we're dealing with a template specialization with zero
          // arguments, there are no children; special-case this.
          OS.$out(FromTD.$deref().getNameAsString()).$out(/*KEEP_STR*/"<>");
          return;
        }
        
        OS.$out(FromTD.$deref().getNameAsString()).$out_char($$LT);
        Tree.MoveToChild();
        /*uint*/int NumElideArgs = 0;
        boolean AllArgsElided = true;
        do {
          if (ElideType) {
            if (Tree.NodeIsSame()) {
              ++NumElideArgs;
              continue;
            }
            AllArgsElided = false;
            if ($greater_uint(NumElideArgs, 0)) {
              PrintElideArgs(NumElideArgs, Indent);
              NumElideArgs = 0;
              OS.$out(/*KEEP_STR*/$COMMA_SPACE);
            }
          }
          TreeToString(Indent);
          if (Tree.HasNextSibling()) {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
        } while (Tree.AdvanceSibling());
        if ($greater_uint(NumElideArgs, 0)) {
          if (AllArgsElided) {
            OS.$out(/*KEEP_STR*/$ELLIPSIS);
          } else {
            PrintElideArgs(NumElideArgs, Indent);
          }
        }
        
        Tree.Parent();
        OS.$out(/*KEEP_STR*/$GT);
        return;
      }
    }
  }

  
  // To signal to the text printer that a certain text needs to be bolded,
  // a special character is injected into the character stream which the
  // text printer will later strip out.
  
  /// Bold - Start bolding text.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::Bold">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1573,
   FQN="(anonymous namespace)::TemplateDiff::Bold", NM="_ZN12_GLOBAL__N_112TemplateDiff4BoldEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff4BoldEv")
  //</editor-fold>
  private void Bold() {
    assert (!IsBold) : "Attempting to bold text that is already bold.";
    IsBold = true;
    if (ShowColor) {
      OS.$out_char(ToggleHighlight);
    }
  }

  
  /// Unbold - Stop bolding text.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::Unbold">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1581,
   FQN="(anonymous namespace)::TemplateDiff::Unbold", NM="_ZN12_GLOBAL__N_112TemplateDiff6UnboldEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff6UnboldEv")
  //</editor-fold>
  private void Unbold() {
    assert (IsBold) : "Attempting to remove bold from unbold text.";
    IsBold = false;
    if (ShowColor) {
      OS.$out_char(ToggleHighlight);
    }
  }

  
  // Functions to print out the arguments and highlighting the difference.
  
  /// PrintTypeNames - prints the typenames, bolding differences.  Will detect
  /// typenames that are the same and attempt to disambiguate them by using
  /// canonical typenames.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::PrintTypeNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1593,
   FQN="(anonymous namespace)::TemplateDiff::PrintTypeNames", NM="_ZN12_GLOBAL__N_112TemplateDiff14PrintTypeNamesEN5clang8QualTypeES2_bbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff14PrintTypeNamesEN5clang8QualTypeES2_bbb")
  //</editor-fold>
  private void PrintTypeNames(QualType FromType, QualType ToType, 
                boolean FromDefault, boolean ToDefault, boolean Same) {
    assert ((!FromType.isNull() || !ToType.isNull())) : "Only one template argument may be missing.";
    if (Same) {
      OS.$out(FromType.getAsString(Policy));
      return;
    }
    if (!FromType.isNull() && !ToType.isNull()
       && $eq_QualType$C(FromType.getLocalUnqualifiedType(), 
        ToType.getLocalUnqualifiedType())) {
      Qualifiers FromQual = FromType.getLocalQualifiers();
      Qualifiers ToQual = ToType.getLocalQualifiers();
      PrintQualifiers(new Qualifiers(FromQual), new Qualifiers(ToQual));
      FromType.getLocalUnqualifiedType().print(OS, Policy);
      return;
    }
    
    std.string FromTypeStr = FromType.isNull() ? new std.string(/*KEEP_STR*/"(no argument)") : FromType.getAsString(Policy);
    std.string ToTypeStr = ToType.isNull() ? new std.string(/*KEEP_STR*/"(no argument)") : ToType.getAsString(Policy);
    // Switch to canonical typename if it is better.
    // TODO: merge this with other aka printing above.
    if ($eq_str$C(FromTypeStr, ToTypeStr)) {
      std.string FromCanTypeStr = FromType.getCanonicalType().getAsString(Policy);
      std.string ToCanTypeStr = ToType.getCanonicalType().getAsString(Policy);
      if ($noteq_string$C(FromCanTypeStr, ToCanTypeStr)) {
        FromTypeStr.$assign(FromCanTypeStr);
        ToTypeStr.$assign(ToCanTypeStr);
      }
    }
    if (PrintTree) {
      OS.$out_char($$LSQUARE);
    }
    OS.$out((FromDefault ? $("(default) ") : $EMPTY));
    Bold();
    OS.$out(FromTypeStr);
    Unbold();
    if (PrintTree) {
      OS.$out(/*KEEP_STR*/" != ").$out((ToDefault ? $("(default) ") : $EMPTY));
      Bold();
      OS.$out(ToTypeStr);
      Unbold();
      OS.$out(/*KEEP_STR*/$RSQUARE);
    }
  }

  
  /// PrintExpr - Prints out the expr template arguments, highlighting argument
  /// differences.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::PrintExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1645,
   FQN="(anonymous namespace)::TemplateDiff::PrintExpr", NM="_ZN12_GLOBAL__N_112TemplateDiff9PrintExprEPKN5clang4ExprES4_bbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff9PrintExprEPKN5clang4ExprES4_bbb")
  //</editor-fold>
  private void PrintExpr(/*const*/ Expr /*P*/ FromExpr, /*const*/ Expr /*P*/ ToExpr, boolean FromDefault, 
           boolean ToDefault, boolean Same) {
    assert (((FromExpr != null) || (ToExpr != null))) : "Only one template argument may be missing.";
    if (Same) {
      PrintExpr(FromExpr);
    } else if (!PrintTree) {
      OS.$out((FromDefault ? $("(default) ") : $EMPTY));
      Bold();
      PrintExpr(FromExpr);
      Unbold();
    } else {
      OS.$out((FromDefault ? $("[(default) ") : $LSQUARE));
      Bold();
      PrintExpr(FromExpr);
      Unbold();
      OS.$out(/*KEEP_STR*/" != ").$out((ToDefault ? $("(default) ") : $EMPTY));
      Bold();
      PrintExpr(ToExpr);
      Unbold();
      OS.$out_char($$RSQUARE);
    }
  }

  
  /// PrintExpr - Actual formatting and printing of expressions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::PrintExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1670,
   FQN="(anonymous namespace)::TemplateDiff::PrintExpr", NM="_ZN12_GLOBAL__N_112TemplateDiff9PrintExprEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff9PrintExprEPKN5clang4ExprE")
  //</editor-fold>
  private void PrintExpr(/*const*/ Expr /*P*/ E) {
    if ((E != null)) {
      E.printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
      return;
    }
    OS.$out(/*KEEP_STR*/"(no argument)");
  }

  
  /// PrintTemplateTemplate - Handles printing of template template arguments,
  /// highlighting argument differences.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::PrintTemplateTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1680,
   FQN="(anonymous namespace)::TemplateDiff::PrintTemplateTemplate", NM="_ZN12_GLOBAL__N_112TemplateDiff21PrintTemplateTemplateEPN5clang12TemplateDeclES3_bbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff21PrintTemplateTemplateEPN5clang12TemplateDeclES3_bbb")
  //</editor-fold>
  private void PrintTemplateTemplate(TemplateDecl /*P*/ FromTD, TemplateDecl /*P*/ ToTD, 
                       boolean FromDefault, boolean ToDefault, boolean Same) {
    assert (((FromTD != null) || (ToTD != null))) : "Only one template argument may be missing.";
    
    std.string FromName = ((FromTD != null) ? FromTD.getName() : new StringRef(/*KEEP_STR*/"(no argument)")).$string();
    std.string ToName = ((ToTD != null) ? ToTD.getName() : new StringRef(/*KEEP_STR*/"(no argument)")).$string();
    if ((FromTD != null) && (ToTD != null) && $eq_str$C(FromName, ToName)) {
      FromName.$assignMove(FromTD.getQualifiedNameAsString());
      ToName.$assignMove(ToTD.getQualifiedNameAsString());
    }
    if (Same) {
      OS.$out(/*KEEP_STR*/"template ").$out(FromTD.getNameAsString());
    } else if (!PrintTree) {
      OS.$out((FromDefault ? $("(default) template ") : $("template ")));
      Bold();
      OS.$out(FromName);
      Unbold();
    } else {
      OS.$out((FromDefault ? $("[(default) template ") : $("[template ")));
      Bold();
      OS.$out(FromName);
      Unbold();
      OS.$out(/*KEEP_STR*/" != ").$out((ToDefault ? $("(default) template ") : $("template ")));
      Bold();
      OS.$out(ToName);
      Unbold();
      OS.$out_char($$RSQUARE);
    }
  }

  
  /// PrintAPSInt - Handles printing of integral arguments, highlighting
  /// argument differences.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::PrintAPSInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1713,
   FQN="(anonymous namespace)::TemplateDiff::PrintAPSInt", NM="_ZN12_GLOBAL__N_112TemplateDiff11PrintAPSIntERKN4llvm6APSIntES4_bbN5clang8QualTypeES6_PNS5_4ExprES8_bbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff11PrintAPSIntERKN4llvm6APSIntES4_bbN5clang8QualTypeES6_PNS5_4ExprES8_bbb")
  //</editor-fold>
  private void PrintAPSInt(final /*const*/ APSInt /*&*/ FromInt, final /*const*/ APSInt /*&*/ ToInt, 
             boolean IsValidFromInt, boolean IsValidToInt, QualType FromIntType, 
             QualType ToIntType, Expr /*P*/ FromExpr, Expr /*P*/ ToExpr, 
             boolean FromDefault, boolean ToDefault, boolean Same) {
    assert ((IsValidFromInt || IsValidToInt)) : "Only one integral argument may be missing.";
    if (Same) {
      if (FromIntType.$arrow().isBooleanType()) {
        OS.$out(((FromInt.$eq(0)) ? $false : $true));
      } else {
        OS.$out(FromInt.__toString(10));
      }
      return;
    }
    
    boolean PrintType = IsValidFromInt && IsValidToInt
       && !Context.hasSameType(new QualType(FromIntType), new QualType(ToIntType));
    if (!PrintTree) {
      OS.$out((FromDefault ? $("(default) ") : $EMPTY));
      PrintAPSInt(FromInt, FromExpr, IsValidFromInt, new QualType(FromIntType), PrintType);
    } else {
      OS.$out((FromDefault ? $("[(default) ") : $LSQUARE));
      PrintAPSInt(FromInt, FromExpr, IsValidFromInt, new QualType(FromIntType), PrintType);
      OS.$out(/*KEEP_STR*/" != ").$out((ToDefault ? $("(default) ") : $EMPTY));
      PrintAPSInt(ToInt, ToExpr, IsValidToInt, new QualType(ToIntType), PrintType);
      OS.$out_char($$RSQUARE);
    }
  }

  
  /// PrintAPSInt - If valid, print the APSInt.  If the expression is
  /// gives more information, print it too.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::PrintAPSInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1746,
   FQN="(anonymous namespace)::TemplateDiff::PrintAPSInt", NM="_ZN12_GLOBAL__N_112TemplateDiff11PrintAPSIntERKN4llvm6APSIntEPN5clang4ExprEbNS5_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff11PrintAPSIntERKN4llvm6APSIntEPN5clang4ExprEbNS5_8QualTypeEb")
  //</editor-fold>
  private void PrintAPSInt(final /*const*/ APSInt /*&*/ Val, Expr /*P*/ E, boolean Valid, 
             QualType IntType, boolean PrintType) {
    Bold();
    if (Valid) {
      if (HasExtraInfo(E)) {
        PrintExpr(E);
        Unbold();
        OS.$out(/*KEEP_STR*/" aka ");
        Bold();
      }
      if (PrintType) {
        Unbold();
        OS.$out(/*KEEP_STR*/$LPAREN);
        Bold();
        IntType.print(OS, Context.getPrintingPolicy());
        Unbold();
        OS.$out(/*KEEP_STR*/") ");
        Bold();
      }
      if (IntType.$arrow().isBooleanType()) {
        OS.$out(((Val.$eq(0)) ? $false : $true));
      } else {
        OS.$out(Val.__toString(10));
      }
    } else if ((E != null)) {
      PrintExpr(E);
    } else {
      OS.$out(/*KEEP_STR*/"(no argument)");
    }
    Unbold();
  }

  
  /// HasExtraInfo - Returns true if E is not an integer literal, the
  /// negation of an integer literal, or a boolean literal.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::HasExtraInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1780,
   FQN="(anonymous namespace)::TemplateDiff::HasExtraInfo", NM="_ZN12_GLOBAL__N_112TemplateDiff12HasExtraInfoEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff12HasExtraInfoEPN5clang4ExprE")
  //</editor-fold>
  private boolean HasExtraInfo(Expr /*P*/ E) {
    if (!(E != null)) {
      return false;
    }
    
    E = E.IgnoreImpCasts();
    if (isa_IntegerLiteral(E)) {
      return false;
    }
    {
      
      UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(E);
      if ((UO != null)) {
        if (UO.getOpcode() == UnaryOperatorKind.UO_Minus) {
          if (isa_IntegerLiteral(UO.getSubExpr())) {
            return false;
          }
        }
      }
    }
    if (isa_CXXBoolLiteralExpr(E)) {
      return false;
    }
    
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::PrintValueDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1798,
   FQN="(anonymous namespace)::TemplateDiff::PrintValueDecl", NM="_ZN12_GLOBAL__N_112TemplateDiff14PrintValueDeclEPN5clang9ValueDeclEbPNS1_4ExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff14PrintValueDeclEPN5clang9ValueDeclEbPNS1_4ExprEb")
  //</editor-fold>
  private void PrintValueDecl(ValueDecl /*P*/ VD, boolean AddressOf, Expr /*P*/ E, boolean NullPtr) {
    if ((VD != null)) {
      if (AddressOf) {
        OS.$out(/*KEEP_STR*/$AMP);
      }
      OS.$out(VD.getName());
      return;
    }
    if (NullPtr) {
      if ((E != null) && !isa_CXXNullPtrLiteralExpr(E)) {
        PrintExpr(E);
        if (IsBold) {
          Unbold();
          OS.$out(/*KEEP_STR*/" aka ");
          Bold();
        } else {
          OS.$out(/*KEEP_STR*/" aka ");
        }
      }
      
      OS.$out(/*KEEP_STR*/$nullptr);
      return;
    }
    
    OS.$out(/*KEEP_STR*/"(no argument)");
  }

  
  /// PrintDecl - Handles printing of Decl arguments, highlighting
  /// argument differences.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::PrintValueDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1827,
   FQN="(anonymous namespace)::TemplateDiff::PrintValueDecl", NM="_ZN12_GLOBAL__N_112TemplateDiff14PrintValueDeclEPN5clang9ValueDeclES3_bbbbPNS1_4ExprES5_bbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff14PrintValueDeclEPN5clang9ValueDeclES3_bbbbPNS1_4ExprES5_bbb")
  //</editor-fold>
  private void PrintValueDecl(ValueDecl /*P*/ FromValueDecl, ValueDecl /*P*/ ToValueDecl, 
                boolean FromAddressOf, boolean ToAddressOf, boolean FromNullPtr, 
                boolean ToNullPtr, Expr /*P*/ FromExpr, Expr /*P*/ ToExpr, 
                boolean FromDefault, boolean ToDefault, boolean Same) {
    assert (((FromValueDecl != null) || FromNullPtr || (ToValueDecl != null) || ToNullPtr)) : "Only one Decl argument may be NULL";
    if (Same) {
      PrintValueDecl(FromValueDecl, FromAddressOf, FromExpr, FromNullPtr);
    } else if (!PrintTree) {
      OS.$out((FromDefault ? $("(default) ") : $EMPTY));
      Bold();
      PrintValueDecl(FromValueDecl, FromAddressOf, FromExpr, FromNullPtr);
      Unbold();
    } else {
      OS.$out((FromDefault ? $("[(default) ") : $LSQUARE));
      Bold();
      PrintValueDecl(FromValueDecl, FromAddressOf, FromExpr, FromNullPtr);
      Unbold();
      OS.$out(/*KEEP_STR*/" != ").$out((ToDefault ? $("(default) ") : $EMPTY));
      Bold();
      PrintValueDecl(ToValueDecl, ToAddressOf, ToExpr, ToNullPtr);
      Unbold();
      OS.$out_char($$RSQUARE);
    }
  }

  
  /// PrintValueDeclAndInteger - Uses the print functions for ValueDecl and
  /// APSInt to print a mixed difference.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::PrintValueDeclAndInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1856,
   FQN="(anonymous namespace)::TemplateDiff::PrintValueDeclAndInteger", NM="_ZN12_GLOBAL__N_112TemplateDiff24PrintValueDeclAndIntegerEPN5clang9ValueDeclEbbPNS1_4ExprEbRKN4llvm6APSIntENS1_8QualTypeES5_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff24PrintValueDeclAndIntegerEPN5clang9ValueDeclEbbPNS1_4ExprEbRKN4llvm6APSIntENS1_8QualTypeES5_b")
  //</editor-fold>
  private void PrintValueDeclAndInteger(ValueDecl /*P*/ VD, boolean NeedAddressOf, 
                          boolean IsNullPtr, Expr /*P*/ VDExpr, boolean DefaultDecl, 
                          final /*const*/ APSInt /*&*/ Val, QualType IntType, 
                          Expr /*P*/ IntExpr, boolean DefaultInt) {
    if (!PrintTree) {
      OS.$out((DefaultDecl ? $("(default) ") : $EMPTY));
      Bold();
      PrintValueDecl(VD, NeedAddressOf, VDExpr, IsNullPtr);
      Unbold();
    } else {
      OS.$out((DefaultDecl ? $("[(default) ") : $LSQUARE));
      Bold();
      PrintValueDecl(VD, NeedAddressOf, VDExpr, IsNullPtr);
      Unbold();
      OS.$out(/*KEEP_STR*/" != ").$out((DefaultInt ? $("(default) ") : $EMPTY));
      PrintAPSInt(Val, IntExpr, true/*Valid*/, new QualType(IntType), false/*PrintType*/);
      OS.$out_char($$RSQUARE);
    }
  }

  
  /// PrintIntegerAndValueDecl - Uses the print functions for APSInt and
  /// ValueDecl to print a mixed difference.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::PrintIntegerAndValueDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1878,
   FQN="(anonymous namespace)::TemplateDiff::PrintIntegerAndValueDecl", NM="_ZN12_GLOBAL__N_112TemplateDiff24PrintIntegerAndValueDeclERKN4llvm6APSIntEN5clang8QualTypeEPNS5_4ExprEbPNS5_9ValueDeclEbbS8_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff24PrintIntegerAndValueDeclERKN4llvm6APSIntEN5clang8QualTypeEPNS5_4ExprEbPNS5_9ValueDeclEbbS8_b")
  //</editor-fold>
  private void PrintIntegerAndValueDecl(final /*const*/ APSInt /*&*/ Val, QualType IntType, 
                          Expr /*P*/ IntExpr, boolean DefaultInt, ValueDecl /*P*/ VD, 
                          boolean NeedAddressOf, boolean IsNullPtr, 
                          Expr /*P*/ VDExpr, boolean DefaultDecl) {
    if (!PrintTree) {
      OS.$out((DefaultInt ? $("(default) ") : $EMPTY));
      PrintAPSInt(Val, IntExpr, true/*Valid*/, new QualType(IntType), false/*PrintType*/);
    } else {
      OS.$out((DefaultInt ? $("[(default) ") : $LSQUARE));
      PrintAPSInt(Val, IntExpr, true/*Valid*/, new QualType(IntType), false/*PrintType*/);
      OS.$out(/*KEEP_STR*/" != ").$out((DefaultDecl ? $("(default) ") : $EMPTY));
      Bold();
      PrintValueDecl(VD, NeedAddressOf, VDExpr, IsNullPtr);
      Unbold();
      OS.$out_char($$RSQUARE);
    }
  }

  
  // Prints the appropriate placeholder for elided template arguments.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::PrintElideArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1897,
   FQN="(anonymous namespace)::TemplateDiff::PrintElideArgs", NM="_ZN12_GLOBAL__N_112TemplateDiff14PrintElideArgsEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff14PrintElideArgsEjj")
  //</editor-fold>
  private void PrintElideArgs(/*uint*/int NumElideArgs, /*uint*/int Indent) {
    if (PrintTree) {
      OS.$out_char($$LF);
      for (/*uint*/int i = 0; $less_uint(i, Indent); ++i)  {
        OS.$out(/*KEEP_STR*/"  ");
      }
    }
    if (NumElideArgs == 0) {
      return;
    }
    if (NumElideArgs == 1) {
      OS.$out(/*KEEP_STR*/"[...]");
    } else {
      OS.$out(/*KEEP_STR*/$LSQUARE).$out_uint(NumElideArgs).$out(/*KEEP_STR*/" * ...]");
    }
  }

  
  // Prints and highlights differences in Qualifiers.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::PrintQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1911,
   FQN="(anonymous namespace)::TemplateDiff::PrintQualifiers", NM="_ZN12_GLOBAL__N_112TemplateDiff15PrintQualifiersEN5clang10QualifiersES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff15PrintQualifiersEN5clang10QualifiersES2_")
  //</editor-fold>
  private void PrintQualifiers(Qualifiers FromQual, Qualifiers ToQual) {
    // Both types have no qualifiers
    if (FromQual.empty() && ToQual.empty()) {
      return;
    }
    
    // Both types have same qualifiers
    if (FromQual.$eq(/*NO_COPY*/ToQual)) {
      PrintQualifier(new Qualifiers(FromQual), /*ApplyBold*/ false);
      return;
    }
    
    // Find common qualifiers and strip them from FromQual and ToQual.
    Qualifiers CommonQual = Qualifiers.removeCommonQualifiers(FromQual, 
        ToQual);
    
    // The qualifiers are printed before the template name.
    // Inline printing:
    // The common qualifiers are printed.  Then, qualifiers only in this type
    // are printed and highlighted.  Finally, qualifiers only in the other
    // type are printed and highlighted inside parentheses after "missing".
    // Tree printing:
    // Qualifiers are printed next to each other, inside brackets, and
    // separated by "!=".  The printing order is:
    // common qualifiers, highlighted from qualifiers, "!=",
    // common qualifiers, highlighted to qualifiers
    if (PrintTree) {
      OS.$out(/*KEEP_STR*/$LSQUARE);
      if (CommonQual.empty() && FromQual.empty()) {
        Bold();
        OS.$out(/*KEEP_STR*/"(no qualifiers) ");
        Unbold();
      } else {
        PrintQualifier(new Qualifiers(CommonQual), /*ApplyBold*/ false);
        PrintQualifier(new Qualifiers(FromQual), /*ApplyBold*/ true);
      }
      OS.$out(/*KEEP_STR*/"!= ");
      if (CommonQual.empty() && ToQual.empty()) {
        Bold();
        OS.$out(/*KEEP_STR*/"(no qualifiers)");
        Unbold();
      } else {
        PrintQualifier(new Qualifiers(CommonQual), /*ApplyBold*/ false, 
            /*appendSpaceIfNonEmpty*/ !ToQual.empty());
        PrintQualifier(new Qualifiers(ToQual), /*ApplyBold*/ true, 
            /*appendSpaceIfNonEmpty*/ false);
      }
      OS.$out(/*KEEP_STR*/"] ");
    } else {
      PrintQualifier(new Qualifiers(CommonQual), /*ApplyBold*/ false);
      PrintQualifier(new Qualifiers(FromQual), /*ApplyBold*/ true);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::PrintQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1964,
   FQN="(anonymous namespace)::TemplateDiff::PrintQualifier", NM="_ZN12_GLOBAL__N_112TemplateDiff14PrintQualifierEN5clang10QualifiersEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff14PrintQualifierEN5clang10QualifiersEbb")
  //</editor-fold>
  private void PrintQualifier(Qualifiers Q, boolean ApplyBold) {
    PrintQualifier(Q, ApplyBold, 
                true);
  }
  private void PrintQualifier(Qualifiers Q, boolean ApplyBold, 
                boolean AppendSpaceIfNonEmpty/*= true*/) {
    if (Q.empty()) {
      return;
    }
    if (ApplyBold) {
      Bold();
    }
    Q.print(OS, Policy, AppendSpaceIfNonEmpty);
    if (ApplyBold) {
      Unbold();
    }
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TemplateDiff">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1974,
   FQN="(anonymous namespace)::TemplateDiff::TemplateDiff", NM="_ZN12_GLOBAL__N_112TemplateDiffC1ERN4llvm11raw_ostreamERN5clang10ASTContextENS4_8QualTypeES7_bbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiffC1ERN4llvm11raw_ostreamERN5clang10ASTContextENS4_8QualTypeES7_bbbb")
  //</editor-fold>
  public TemplateDiff(final raw_ostream /*&*/ OS, final ASTContext /*&*/ Context, QualType FromType, 
      QualType ToType, boolean PrintTree, boolean PrintFromType, 
      boolean ElideType, boolean ShowColor) {
    // : Context(Context), Policy(Context.getLangOpts()), ElideType(ElideType), PrintTree(PrintTree), ShowColor(ShowColor), FromTemplateType(PrintFromType ? FromType : ToType), ToTemplateType(PrintFromType ? ToType : FromType), OS(OS), IsBold(false), Tree() 
    //START JInit
    this./*&*/Context=/*&*/Context;
    this.Policy = new PrintingPolicy(Context.getLangOpts());
    this.ElideType = ElideType;
    this.PrintTree = PrintTree;
    this.ShowColor = ShowColor;
    this.FromTemplateType = new QualType(PrintFromType ? FromType : ToType);
    this.ToTemplateType = new QualType(PrintFromType ? ToType : FromType);
    this./*&*/OS=/*&*/OS;
    this.IsBold = false;
    this.Tree = new DiffTree();
    //END JInit
  }

  
  /// DiffTemplate - Start the template type diffing.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 1990,
   FQN="(anonymous namespace)::TemplateDiff::DiffTemplate", NM="_ZN12_GLOBAL__N_112TemplateDiff12DiffTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff12DiffTemplateEv")
  //</editor-fold>
  public void DiffTemplate() {
    Qualifiers FromQual = FromTemplateType.getQualifiers();
    Qualifiers ToQual = ToTemplateType.getQualifiers();
    
    type$ref</*const*/ TemplateSpecializationType /*P*/ > FromOrigTST = create_type$ref(GetTemplateSpecializationType(Context, new QualType(FromTemplateType)));
    type$ref</*const*/ TemplateSpecializationType /*P*/ > ToOrigTST = create_type$ref(GetTemplateSpecializationType(Context, new QualType(ToTemplateType)));
    
    // Only checking templates.
    if (!(FromOrigTST.$deref() != null) || !(ToOrigTST.$deref() != null)) {
      return;
    }
    
    // Different base templates.
    if (!hasSameTemplate(FromOrigTST, ToOrigTST)) {
      return;
    }
    
    FromQual.$minusassign(new QualType(FromOrigTST.$deref(), 0).getQualifiers());
    ToQual.$minusassign(new QualType(ToOrigTST.$deref(), 0).getQualifiers());
    
    // Same base template, but different arguments.
    Tree.SetTemplateDiff(FromOrigTST.$deref().getTemplateName().getAsTemplateDecl(), 
        ToOrigTST.$deref().getTemplateName().getAsTemplateDecl(), 
        new Qualifiers(FromQual), new Qualifiers(ToQual), false/*FromDefault*/, 
        false/*ToDefault*/);
    
    DiffTemplate(FromOrigTST.$deref(), ToOrigTST.$deref());
  }

  
  /// Emit - When the two types given are templated types with the same
  /// base template, a string representation of the type difference will be
  /// emitted to the stream and return true.  Otherwise, return false.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 2023,
   FQN="(anonymous namespace)::TemplateDiff::Emit", NM="_ZN12_GLOBAL__N_112TemplateDiff4EmitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff4EmitEv")
  //</editor-fold>
  public boolean Emit() {
    Tree.StartTraverse();
    if (Tree.Empty()) {
      return false;
    }
    
    TreeToString();
    assert (!IsBold) : "Bold is applied to end of string.";
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::~TemplateDiff">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 460,
   FQN="(anonymous namespace)::TemplateDiff::~TemplateDiff", NM="_ZN12_GLOBAL__N_112TemplateDiffD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiffD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Tree.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Context=" + "[ASTContext]" // NOI18N
              + ", Policy=" + Policy // NOI18N
              + ", ElideType=" + ElideType // NOI18N
              + ", PrintTree=" + PrintTree // NOI18N
              + ", ShowColor=" + ShowColor // NOI18N
              + ", FromTemplateType=" + FromTemplateType // NOI18N
              + ", ToTemplateType=" + ToTemplateType // NOI18N
              + ", OS=" + OS // NOI18N
              + ", IsBold=" + IsBold // NOI18N
              + ", Tree=" + Tree; // NOI18N
  }
}
