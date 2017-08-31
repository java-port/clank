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
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;


/// \brief The context in which code completion occurred, so that the
/// code-completion consumer can process the results accordingly.
//<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 156,
 FQN="clang::CodeCompletionContext", NM="_ZN5clang21CodeCompletionContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionContextE")
//</editor-fold>
public class CodeCompletionContext {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionContext::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 158,
   FQN="clang::CodeCompletionContext::Kind", NM="_ZN5clang21CodeCompletionContext4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionContext4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    /// \brief An unspecified code-completion context.
    CCC_Other(0),
    /// \brief An unspecified code-completion context where we should also add
    /// macro completions.
    CCC_OtherWithMacros(CCC_Other.getValue() + 1),
    /// \brief Code completion occurred within a "top-level" completion context,
    /// e.g., at namespace or global scope.
    CCC_TopLevel(CCC_OtherWithMacros.getValue() + 1),
    /// \brief Code completion occurred within an Objective-C interface,
    /// protocol, or category interface.
    CCC_ObjCInterface(CCC_TopLevel.getValue() + 1),
    /// \brief Code completion occurred within an Objective-C implementation
    /// or category implementation.
    CCC_ObjCImplementation(CCC_ObjCInterface.getValue() + 1),
    /// \brief Code completion occurred within the instance variable list of
    /// an Objective-C interface, implementation, or category implementation.
    CCC_ObjCIvarList(CCC_ObjCImplementation.getValue() + 1),
    /// \brief Code completion occurred within a class, struct, or union.
    CCC_ClassStructUnion(CCC_ObjCIvarList.getValue() + 1),
    /// \brief Code completion occurred where a statement (or declaration) is
    /// expected in a function, method, or block.
    CCC_Statement(CCC_ClassStructUnion.getValue() + 1),
    /// \brief Code completion occurred where an expression is expected.
    CCC_Expression(CCC_Statement.getValue() + 1),
    /// \brief Code completion occurred where an Objective-C message receiver
    /// is expected.
    CCC_ObjCMessageReceiver(CCC_Expression.getValue() + 1),
    /// \brief Code completion occurred on the right-hand side of a member
    /// access expression using the dot operator.
    ///
    /// The results of this completion are the members of the type being
    /// accessed. The type itself is available via
    /// \c CodeCompletionContext::getType().
    CCC_DotMemberAccess(CCC_ObjCMessageReceiver.getValue() + 1),
    /// \brief Code completion occurred on the right-hand side of a member
    /// access expression using the arrow operator.
    ///
    /// The results of this completion are the members of the type being
    /// accessed. The type itself is available via
    /// \c CodeCompletionContext::getType().
    CCC_ArrowMemberAccess(CCC_DotMemberAccess.getValue() + 1),
    /// \brief Code completion occurred on the right-hand side of an Objective-C
    /// property access expression.
    ///
    /// The results of this completion are the members of the type being
    /// accessed. The type itself is available via
    /// \c CodeCompletionContext::getType().
    CCC_ObjCPropertyAccess(CCC_ArrowMemberAccess.getValue() + 1),
    /// \brief Code completion occurred after the "enum" keyword, to indicate
    /// an enumeration name.
    CCC_EnumTag(CCC_ObjCPropertyAccess.getValue() + 1),
    /// \brief Code completion occurred after the "union" keyword, to indicate
    /// a union name.
    CCC_UnionTag(CCC_EnumTag.getValue() + 1),
    /// \brief Code completion occurred after the "struct" or "class" keyword,
    /// to indicate a struct or class name.
    CCC_ClassOrStructTag(CCC_UnionTag.getValue() + 1),
    /// \brief Code completion occurred where a protocol name is expected.
    CCC_ObjCProtocolName(CCC_ClassOrStructTag.getValue() + 1),
    /// \brief Code completion occurred where a namespace or namespace alias
    /// is expected.
    CCC_Namespace(CCC_ObjCProtocolName.getValue() + 1),
    /// \brief Code completion occurred where a type name is expected.
    CCC_Type(CCC_Namespace.getValue() + 1),
    /// \brief Code completion occurred where a new name is expected.
    CCC_Name(CCC_Type.getValue() + 1),
    /// \brief Code completion occurred where a new name is expected and a
    /// qualified name is permissible.
    CCC_PotentiallyQualifiedName(CCC_Name.getValue() + 1),
    /// \brief Code completion occurred where an macro is being defined.
    CCC_MacroName(CCC_PotentiallyQualifiedName.getValue() + 1),
    /// \brief Code completion occurred where a macro name is expected
    /// (without any arguments, in the case of a function-like macro).
    CCC_MacroNameUse(CCC_MacroName.getValue() + 1),
    /// \brief Code completion occurred within a preprocessor expression.
    CCC_PreprocessorExpression(CCC_MacroNameUse.getValue() + 1),
    /// \brief Code completion occurred where a preprocessor directive is
    /// expected.
    CCC_PreprocessorDirective(CCC_PreprocessorExpression.getValue() + 1),
    /// \brief Code completion occurred in a context where natural language is
    /// expected, e.g., a comment or string literal.
    ///
    /// This context usually implies that no completions should be added,
    /// unless they come from an appropriate natural-language dictionary.
    CCC_NaturalLanguage(CCC_PreprocessorDirective.getValue() + 1),
    /// \brief Code completion for a selector, as in an \@selector expression.
    CCC_SelectorName(CCC_NaturalLanguage.getValue() + 1),
    /// \brief Code completion within a type-qualifier list.
    CCC_TypeQualifiers(CCC_SelectorName.getValue() + 1),
    /// \brief Code completion in a parenthesized expression, which means that
    /// we may also have types here in C and Objective-C (as well as in C++).
    CCC_ParenthesizedExpression(CCC_TypeQualifiers.getValue() + 1),
    /// \brief Code completion where an Objective-C instance message is
    /// expected.
    CCC_ObjCInstanceMessage(CCC_ParenthesizedExpression.getValue() + 1),
    /// \brief Code completion where an Objective-C class message is expected.
    CCC_ObjCClassMessage(CCC_ObjCInstanceMessage.getValue() + 1),
    /// \brief Code completion where the name of an Objective-C class is
    /// expected.
    CCC_ObjCInterfaceName(CCC_ObjCClassMessage.getValue() + 1),
    /// \brief Code completion where an Objective-C category name is expected.
    CCC_ObjCCategoryName(CCC_ObjCInterfaceName.getValue() + 1),
    /// \brief An unknown context, in which we are recovering from a parsing
    /// error and don't know which completions we should give.
    CCC_Recovery(CCC_ObjCCategoryName.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Kind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private  Kind _Kind;
  
  /// \brief The type that would prefer to see at this point (e.g., the type
  /// of an initializer or function parameter).
  private QualType PreferredType;
  
  /// \brief The type of the base object in a member access expression.
  private QualType BaseType;
  
  /// \brief The identifiers for Objective-C selector parts.
  private ArrayRef<IdentifierInfo /*P*/ > SelIdents;
/*public:*/
  /// \brief Construct a new code-completion context of the given kind.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionContext::CodeCompletionContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 281,
   FQN="clang::CodeCompletionContext::CodeCompletionContext", NM="_ZN5clang21CodeCompletionContextC1ENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionContextC1ENS0_4KindE")
  //</editor-fold>
  public CodeCompletionContext( Kind Kind) {
    // : Kind(Kind), PreferredType(), BaseType(), SelIdents(None) 
    //START JInit
    this._Kind = Kind;
    this.PreferredType = new QualType();
    this.BaseType = new QualType();
    this.SelIdents = new ArrayRef<IdentifierInfo /*P*/ >(None, true);
    //END JInit
  }

  
  /// \brief Construct a new code-completion context of the given kind.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionContext::CodeCompletionContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 284,
   FQN="clang::CodeCompletionContext::CodeCompletionContext", NM="_ZN5clang21CodeCompletionContextC1ENS0_4KindENS_8QualTypeEN4llvm8ArrayRefIPNS_14IdentifierInfoEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionContextC1ENS0_4KindENS_8QualTypeEN4llvm8ArrayRefIPNS_14IdentifierInfoEEE")
  //</editor-fold>
  public CodeCompletionContext( Kind Kind, QualType T) {
    this(Kind, T, 
      new ArrayRef<IdentifierInfo /*P*/ >(None, true));
  }
  public CodeCompletionContext( Kind Kind, QualType T, 
      ArrayRef<IdentifierInfo /*P*/ > SelIdents/*= None*/) {
    // : Kind(Kind), PreferredType(), BaseType(), SelIdents(SelIdents) 
    //START JInit
    this._Kind = Kind;
    this.PreferredType = new QualType();
    this.BaseType = new QualType();
    this.SelIdents = new ArrayRef<IdentifierInfo /*P*/ >(SelIdents);
    //END JInit
    if (Kind == Kind.CCC_DotMemberAccess || Kind == Kind.CCC_ArrowMemberAccess
       || Kind == Kind.CCC_ObjCPropertyAccess || Kind == Kind.CCC_ObjCClassMessage
       || Kind == Kind.CCC_ObjCInstanceMessage) {
      BaseType.$assign(T);
    } else {
      PreferredType.$assign(T);
    }
  }

  
  /// \brief Retrieve the kind of code-completion context.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionContext::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 297,
   FQN="clang::CodeCompletionContext::getKind", NM="_ZNK5clang21CodeCompletionContext7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang21CodeCompletionContext7getKindEv")
  //</editor-fold>
  public  Kind getKind() /*const*/ {
    return _Kind;
  }

  
  /// \brief Retrieve the type that this expression would prefer to have, e.g.,
  /// if the expression is a variable initializer or a function argument, the
  /// type of the corresponding variable or function parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionContext::getPreferredType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 302,
   FQN="clang::CodeCompletionContext::getPreferredType", NM="_ZNK5clang21CodeCompletionContext16getPreferredTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang21CodeCompletionContext16getPreferredTypeEv")
  //</editor-fold>
  public QualType getPreferredType() /*const*/ {
    return new QualType(PreferredType);
  }

  
  /// \brief Retrieve the type of the base object in a member-access
  /// expression.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionContext::getBaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 306,
   FQN="clang::CodeCompletionContext::getBaseType", NM="_ZNK5clang21CodeCompletionContext11getBaseTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang21CodeCompletionContext11getBaseTypeEv")
  //</editor-fold>
  public QualType getBaseType() /*const*/ {
    return new QualType(BaseType);
  }

  
  /// \brief Retrieve the Objective-C selector identifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionContext::getSelIdents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 309,
   FQN="clang::CodeCompletionContext::getSelIdents", NM="_ZNK5clang21CodeCompletionContext12getSelIdentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang21CodeCompletionContext12getSelIdentsEv")
  //</editor-fold>
  public ArrayRef<IdentifierInfo /*P*/ > getSelIdents() /*const*/ {
    return new ArrayRef<IdentifierInfo /*P*/ >(SelIdents);
  }

  
  /// \brief Determines whether we want C++ constructors as results within this
  /// context.
  
  //===----------------------------------------------------------------------===//
  // Code completion context implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionContext::wantConstructorResults">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 34,
   FQN="clang::CodeCompletionContext::wantConstructorResults", NM="_ZNK5clang21CodeCompletionContext22wantConstructorResultsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang21CodeCompletionContext22wantConstructorResultsEv")
  //</editor-fold>
  public boolean wantConstructorResults() /*const*/ {
    switch (_Kind) {
     case CCC_Recovery:
     case CCC_Statement:
     case CCC_Expression:
     case CCC_ObjCMessageReceiver:
     case CCC_ParenthesizedExpression:
      return true;
     case CCC_TopLevel:
     case CCC_ObjCInterface:
     case CCC_ObjCImplementation:
     case CCC_ObjCIvarList:
     case CCC_ClassStructUnion:
     case CCC_DotMemberAccess:
     case CCC_ArrowMemberAccess:
     case CCC_ObjCPropertyAccess:
     case CCC_EnumTag:
     case CCC_UnionTag:
     case CCC_ClassOrStructTag:
     case CCC_ObjCProtocolName:
     case CCC_Namespace:
     case CCC_Type:
     case CCC_Name:
     case CCC_PotentiallyQualifiedName:
     case CCC_MacroName:
     case CCC_MacroNameUse:
     case CCC_PreprocessorExpression:
     case CCC_PreprocessorDirective:
     case CCC_NaturalLanguage:
     case CCC_SelectorName:
     case CCC_TypeQualifiers:
     case CCC_Other:
     case CCC_OtherWithMacros:
     case CCC_ObjCInstanceMessage:
     case CCC_ObjCClassMessage:
     case CCC_ObjCInterfaceName:
     case CCC_ObjCCategoryName:
      return false;
    }
    throw new llvm_unreachable("Invalid CodeCompletionContext::Kind!");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionContext::CodeCompletionContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 156,
   FQN="clang::CodeCompletionContext::CodeCompletionContext", NM="_ZN5clang21CodeCompletionContextC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang21CodeCompletionContextC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CodeCompletionContext(final /*const*/ CodeCompletionContext /*&*/ $Prm0) {
    // : Kind(.Kind), PreferredType(.PreferredType), BaseType(.BaseType), SelIdents(.SelIdents) 
    //START JInit
    this._Kind = $Prm0._Kind;
    this.PreferredType = new QualType($Prm0.PreferredType);
    this.BaseType = new QualType($Prm0.BaseType);
    this.SelIdents = new ArrayRef<IdentifierInfo /*P*/ >($Prm0.SelIdents);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionContext::CodeCompletionContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 156,
   FQN="clang::CodeCompletionContext::CodeCompletionContext", NM="_ZN5clang21CodeCompletionContextC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang21CodeCompletionContextC1EOS0_")
  //</editor-fold>
  public /*inline*/ CodeCompletionContext(JD$Move _dparam, final CodeCompletionContext /*&&*/$Prm0) {
    // : Kind(static_cast<CodeCompletionContext &&>().Kind), PreferredType(static_cast<CodeCompletionContext &&>().PreferredType), BaseType(static_cast<CodeCompletionContext &&>().BaseType), SelIdents(static_cast<CodeCompletionContext &&>().SelIdents) 
    //START JInit
    this._Kind = $Prm0._Kind;
    this.PreferredType = new QualType(JD$Move.INSTANCE, $Prm0.PreferredType);
    this.BaseType = new QualType(JD$Move.INSTANCE, $Prm0.BaseType);
    this.SelIdents = new ArrayRef<IdentifierInfo /*P*/ >(JD$Move.INSTANCE, $Prm0.SelIdents);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionContext::~CodeCompletionContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 156,
   FQN="clang::CodeCompletionContext::~CodeCompletionContext", NM="_ZN5clang21CodeCompletionContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang21CodeCompletionContextD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
  }

  
  @Override public String toString() {
    return "" + "Kind=" + _Kind// NOI18N
              + ", PreferredType=" + PreferredType // NOI18N
              + ", BaseType=" + BaseType // NOI18N
              + ", SelIdents=" + SelIdents; // NOI18N
  }
}
