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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;


/// \brief Information about one declarator, including the parsed type
/// information and the identifier.
///
/// When the declarator is fully formed, this is turned into the appropriate
/// Decl object.
///
/// Declarators come in two types: normal declarators and abstract declarators.
/// Abstract declarators are used when parsing types, and don't have an
/// identifier.  Normal declarators do have ID's.
///
/// Instances of this class should be a transient object that lives on the
/// stack, not objects that are allocated in large quantities on the heap.
//<editor-fold defaultstate="collapsed" desc="clang::Declarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1624,
 FQN="clang::Declarator", NM="_ZN5clang10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10DeclaratorE")
//</editor-fold>
public class Declarator implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::TheContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1626,
   FQN="clang::Declarator::TheContext", NM="_ZN5clang10Declarator10TheContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator10TheContextE")
  //</editor-fold>
  public enum TheContext implements Native.ComparableLower {
    FileContext(0), // File scope declaration.
    PrototypeContext(FileContext.getValue() + 1), // Within a function prototype.
    ObjCResultContext(PrototypeContext.getValue() + 1), // An ObjC method result type.
    ObjCParameterContext(ObjCResultContext.getValue() + 1), // An ObjC method parameter type.
    KNRTypeListContext(ObjCParameterContext.getValue() + 1), // K&R type definition list for formals.
    TypeNameContext(KNRTypeListContext.getValue() + 1), // Abstract declarator for types.
    MemberContext(TypeNameContext.getValue() + 1), // Struct/Union field.
    BlockContext(MemberContext.getValue() + 1), // Declaration within a block in a function.
    ForContext(BlockContext.getValue() + 1), // Declaration within first part of a for loop.
    InitStmtContext(ForContext.getValue() + 1), // Declaration within optional init stmt of if/switch.
    ConditionContext(InitStmtContext.getValue() + 1), // Condition declaration in a C++ if/switch/while/for.
    TemplateParamContext(ConditionContext.getValue() + 1), // Within a template parameter list.
    CXXNewContext(TemplateParamContext.getValue() + 1), // C++ new-expression.
    CXXCatchContext(CXXNewContext.getValue() + 1), // C++ catch exception-declaration
    ObjCCatchContext(CXXCatchContext.getValue() + 1), // Objective-C catch exception-declaration
    BlockLiteralContext(ObjCCatchContext.getValue() + 1), // Block literal declarator.
    LambdaExprContext(BlockLiteralContext.getValue() + 1), // Lambda-expression declarator.
    LambdaExprParameterContext(LambdaExprContext.getValue() + 1), // Lambda-expression parameter declarator.
    ConversionIdContext(LambdaExprParameterContext.getValue() + 1), // C++ conversion-type-id.
    TrailingReturnContext(ConversionIdContext.getValue() + 1), // C++11 trailing-type-specifier.
    TemplateTypeArgContext(TrailingReturnContext.getValue() + 1), // Template type argument.
    AliasDeclContext(TemplateTypeArgContext.getValue() + 1), // C++11 alias-declaration.
    AliasTemplateContext(AliasDeclContext.getValue() + 1); // C++11 alias-declaration template.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TheContext valueOf(int val) {
      TheContext out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final TheContext[] VALUES;
      private static final TheContext[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TheContext kind : TheContext.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TheContext[min < 0 ? (1-min) : 0];
        VALUES = new TheContext[max >= 0 ? (1+max) : 0];
        for (TheContext kind : TheContext.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private TheContext(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TheContext)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TheContext)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private final /*const*/ DeclSpec /*&*/ DS;
  private CXXScopeSpec SS;
  private UnqualifiedId Name;
  private SourceRange Range;
  
  /// \brief Where we are parsing this declarator.
  private TheContext Context;
  
  /// DeclTypeInfo - This holds each type that the declarator includes as it is
  /// parsed.  This is pushed from the identifier out, which means that element
  /// #0 will be the most closely bound to the identifier, and
  /// DeclTypeInfo.back() will be the least closely bound.
  private SmallVector<DeclaratorChunk> DeclTypeInfo;
  
  /// InvalidType - Set by Sema::GetTypeForDeclarator().
  private /*JBIT unsigned int*/ boolean InvalidType /*: 1*/;
  
  /// GroupingParens - Set by Parser::ParseParenDeclarator().
  private /*JBIT unsigned int*/ boolean GroupingParens /*: 1*/;
  
  /// FunctionDefinition - Is this Declarator for a function or member 
  /// definition and, if so, what kind?
  ///
  /// Actually a FunctionDefinitionKind.
  private /*JBYTE unsigned int*/ byte FunctionDefinition /*: 2*/;
  
  /// \brief Is this Declarator a redeclaration?
  private /*JBIT unsigned int*/ boolean Redeclaration /*: 1*/;
  
  /// Attrs - Attributes.
  private ParsedAttributes Attrs;
  
  /// \brief The asm label, if specified.
  private Expr /*P*/ AsmLabel;
  
  /// InlineParams - This is a local array used for the first function decl
  /// chunk to avoid going to the heap for the common case when we have one
  /// function chunk in the declarator.
  /*friend*//*private*/ DeclaratorChunk.ParamInfo InlineParams[/*16*/] = new$T(new DeclaratorChunk.ParamInfo [16], DeclaratorChunk.ParamInfo::new);
  /*friend*//*private*/ boolean InlineParamsUsed;
  
  /// \brief true if the declaration is preceded by \c __extension__.
  private /*JBIT unsigned int*/ boolean Extension /*: 1*/;
  
  /// Indicates whether this is an Objective-C instance variable.
  private /*JBIT unsigned int*/ boolean ObjCIvar /*: 1*/;
  
  /// Indicates whether this is an Objective-C 'weak' property.
  private /*JBIT unsigned int*/ boolean ObjCWeakProperty /*: 1*/;
  
  /// \brief If this is the second or subsequent declarator in this declaration,
  /// the location of the comma before this declarator.
  private SourceLocation CommaLoc;
  
  /// \brief If provided, the source location of the ellipsis used to describe
  /// this declarator as a parameter pack.
  private SourceLocation EllipsisLoc;
  
  /*friend  struct DeclaratorChunk*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::Declarator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1714,
   FQN="clang::Declarator::Declarator", NM="_ZN5clang10DeclaratorC1ERKNS_8DeclSpecENS0_10TheContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10DeclaratorC1ERKNS_8DeclSpecENS0_10TheContextE")
  //</editor-fold>
  public Declarator(final /*const*/ DeclSpec /*&*/ ds, TheContext C) {
    // : DS(ds), SS(), Name(), Range(ds.getSourceRange()), Context(C), DeclTypeInfo(), InvalidType(DS.getTypeSpecType() == DeclSpec::TST_error), GroupingParens(false), FunctionDefinition(FDK_Declaration), Redeclaration(false), Attrs(ds.getAttributePool().getFactory()), AsmLabel(null), InlineParams(), InlineParamsUsed(false), Extension(false), ObjCIvar(false), ObjCWeakProperty(false), CommaLoc(), EllipsisLoc() 
    //START JInit
    this./*&*/DS=/*&*/ds;
    this.SS = new CXXScopeSpec();
    this.Name = new UnqualifiedId();
    this.Range = ds.getSourceRange();
    this.Context = C;
    this.DeclTypeInfo = new SmallVector<DeclaratorChunk>(8, new DeclaratorChunk());
    this.InvalidType = DS.getTypeSpecType() == DeclSpec.TST_error;
    this.GroupingParens = false;
    this.FunctionDefinition = $uint2uint_2bits(FunctionDefinitionKind.FDK_Declaration.getValue());
    this.Redeclaration = false;
    this.Attrs = new ParsedAttributes(ds.getAttributePool().getFactory());
    this.AsmLabel = null;
    this.InlineParams = new$T(new DeclaratorChunk.ParamInfo [16], ()->new DeclaratorChunk.ParamInfo());
    this.InlineParamsUsed = false;
    this.Extension = false;
    this.ObjCIvar = false;
    this.ObjCWeakProperty = false;
    this.CommaLoc = new SourceLocation();
    this.EllipsisLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::~Declarator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1724,
   FQN="clang::Declarator::~Declarator", NM="_ZN5clang10DeclaratorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10DeclaratorD0Ev")
  //</editor-fold>
  public void $destroy() {
    clear$Declarator();
    //START JDestroy
    Attrs.$destroy();
    DeclTypeInfo.$destroy();
    SS.$destroy();
    //END JDestroy
  }

  /// getDeclSpec - Return the declaration-specifier that this declarator was
  /// declared with.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getDeclSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1729,
   FQN="clang::Declarator::getDeclSpec", NM="_ZNK5clang10Declarator11getDeclSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator11getDeclSpecEv")
  //</editor-fold>
  public /*const*/ DeclSpec /*&*/ getDeclSpec() /*const*/ {
    return DS;
  }

  
  /// getMutableDeclSpec - Return a non-const version of the DeclSpec.  This
  /// should be used with extreme care: declspecs can often be shared between
  /// multiple declarators, so mutating the DeclSpec affects all of the
  /// Declarators.  This should only be done when the declspec is known to not
  /// be shared or when in error recovery etc.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getMutableDeclSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1736,
   FQN="clang::Declarator::getMutableDeclSpec", NM="_ZN5clang10Declarator18getMutableDeclSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator18getMutableDeclSpecEv")
  //</editor-fold>
  public DeclSpec /*&*/ getMutableDeclSpec() {
    return ((/*const_cast*/DeclSpec /*&*/ )(DS));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getAttributePool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1738,
   FQN="clang::Declarator::getAttributePool", NM="_ZNK5clang10Declarator16getAttributePoolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator16getAttributePoolEv")
  //</editor-fold>
  public AttributePool /*&*/ getAttributePool() /*const*/ {
    return Attrs.getPool();
  }

  
  /// getCXXScopeSpec - Return the C++ scope specifier (global scope or
  /// nested-name-specifier) that is part of the declarator-id.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getCXXScopeSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1744,
   FQN="clang::Declarator::getCXXScopeSpec", NM="_ZNK5clang10Declarator15getCXXScopeSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator15getCXXScopeSpecEv")
  //</editor-fold>
  public /*const*/ CXXScopeSpec /*&*/ getCXXScopeSpec$Const() /*const*/ {
    return SS;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getCXXScopeSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1745,
   FQN="clang::Declarator::getCXXScopeSpec", NM="_ZN5clang10Declarator15getCXXScopeSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator15getCXXScopeSpecEv")
  //</editor-fold>
  public CXXScopeSpec /*&*/ getCXXScopeSpec() {
    return SS;
  }

  
  /// \brief Retrieve the name specified by this declarator.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1748,
   FQN="clang::Declarator::getName", NM="_ZN5clang10Declarator7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator7getNameEv")
  //</editor-fold>
  public UnqualifiedId /*&*/ getName() {
    return Name;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1750,
   FQN="clang::Declarator::getContext", NM="_ZNK5clang10Declarator10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator10getContextEv")
  //</editor-fold>
  public TheContext getContext() /*const*/ {
    return Context;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::isPrototypeContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1752,
   FQN="clang::Declarator::isPrototypeContext", NM="_ZNK5clang10Declarator18isPrototypeContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator18isPrototypeContextEv")
  //</editor-fold>
  public boolean isPrototypeContext() /*const*/ {
    return (Context == TheContext.PrototypeContext
       || Context == TheContext.ObjCParameterContext
       || Context == TheContext.ObjCResultContext
       || Context == TheContext.LambdaExprParameterContext);
  }

  
  /// \brief Get the source range that spans this declarator.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1760,
   FQN="clang::Declarator::getSourceRange", NM="_ZNK5clang10Declarator14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(Range);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1761,
   FQN="clang::Declarator::getLocStart", NM="_ZNK5clang10Declarator11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return Range.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1762,
   FQN="clang::Declarator::getLocEnd", NM="_ZNK5clang10Declarator9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return Range.getEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::SetSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1764,
   FQN="clang::Declarator::SetSourceRange", NM="_ZN5clang10Declarator14SetSourceRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator14SetSourceRangeENS_11SourceRangeE")
  //</editor-fold>
  public void SetSourceRange(SourceRange R) {
    Range.$assign(R);
  }

  /// SetRangeBegin - Set the start of the source range to Loc, unless it's
  /// invalid.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::SetRangeBegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1767,
   FQN="clang::Declarator::SetRangeBegin", NM="_ZN5clang10Declarator13SetRangeBeginENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator13SetRangeBeginENS_14SourceLocationE")
  //</editor-fold>
  public void SetRangeBegin(SourceLocation Loc) {
    if (!Loc.isInvalid()) {
      Range.setBegin(/*NO_COPY*/Loc);
    }
  }

  /// SetRangeEnd - Set the end of the source range to Loc, unless it's invalid.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::SetRangeEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1772,
   FQN="clang::Declarator::SetRangeEnd", NM="_ZN5clang10Declarator11SetRangeEndENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator11SetRangeEndENS_14SourceLocationE")
  //</editor-fold>
  public void SetRangeEnd(SourceLocation Loc) {
    if (!Loc.isInvalid()) {
      Range.setEnd(/*NO_COPY*/Loc);
    }
  }

  /// ExtendWithDeclSpec - Extend the declarator source range to include the
  /// given declspec, unless its location is invalid. Adopts the range start if
  /// the current range start is invalid.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::ExtendWithDeclSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1779,
   FQN="clang::Declarator::ExtendWithDeclSpec", NM="_ZN5clang10Declarator18ExtendWithDeclSpecERKNS_8DeclSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator18ExtendWithDeclSpecERKNS_8DeclSpecE")
  //</editor-fold>
  public void ExtendWithDeclSpec(final /*const*/ DeclSpec /*&*/ DS) {
    SourceRange SR = DS.getSourceRange();
    if (Range.getBegin().isInvalid()) {
      Range.setBegin(SR.getBegin());
    }
    if (!SR.getEnd().isInvalid()) {
      Range.setEnd(SR.getEnd());
    }
  }

  
  /// \brief Reset the contents of this Declarator.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1788,
   FQN="clang::Declarator::clear", NM="_ZN5clang10Declarator5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator5clearEv")
  //</editor-fold>
  public final void clear$Declarator() {
    SS.clear();
    Name.clear();
    Range.$assignMove(DS.getSourceRange());
    
    for (/*uint*/int i = 0, e = DeclTypeInfo.size(); i != e; ++i)  {
      DeclTypeInfo.$at(i).destroy();
    }
    DeclTypeInfo.clear();
    Attrs.clear();
    AsmLabel = null;
    InlineParamsUsed = false;
    ObjCIvar = false;
    ObjCWeakProperty = false;
    CommaLoc.$assignMove(new SourceLocation());
    EllipsisLoc.$assignMove(new SourceLocation());
  }

  
  /// mayOmitIdentifier - Return true if the identifier is either optional or
  /// not allowed.  This is true for typenames, prototypes, and template
  /// parameter lists.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::mayOmitIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1808,
   FQN="clang::Declarator::mayOmitIdentifier", NM="_ZNK5clang10Declarator17mayOmitIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator17mayOmitIdentifierEv")
  //</editor-fold>
  public boolean mayOmitIdentifier() /*const*/ {
    switch (Context) {
     case FileContext:
     case KNRTypeListContext:
     case MemberContext:
     case BlockContext:
     case ForContext:
     case InitStmtContext:
     case ConditionContext:
      return false;
     case TypeNameContext:
     case AliasDeclContext:
     case AliasTemplateContext:
     case PrototypeContext:
     case LambdaExprParameterContext:
     case ObjCParameterContext:
     case ObjCResultContext:
     case TemplateParamContext:
     case CXXNewContext:
     case CXXCatchContext:
     case ObjCCatchContext:
     case BlockLiteralContext:
     case LambdaExprContext:
     case ConversionIdContext:
     case TemplateTypeArgContext:
     case TrailingReturnContext:
      return true;
    }
    throw new llvm_unreachable("unknown context kind!");
  }

  
  /// mayHaveIdentifier - Return true if the identifier is either optional or
  /// required.  This is true for normal declarators and prototypes, but not
  /// typenames.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::mayHaveIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1843,
   FQN="clang::Declarator::mayHaveIdentifier", NM="_ZNK5clang10Declarator17mayHaveIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator17mayHaveIdentifierEv")
  //</editor-fold>
  public boolean mayHaveIdentifier() /*const*/ {
    switch (Context) {
     case FileContext:
     case KNRTypeListContext:
     case MemberContext:
     case BlockContext:
     case ForContext:
     case InitStmtContext:
     case ConditionContext:
     case PrototypeContext:
     case LambdaExprParameterContext:
     case TemplateParamContext:
     case CXXCatchContext:
     case ObjCCatchContext:
      return true;
     case TypeNameContext:
     case CXXNewContext:
     case AliasDeclContext:
     case AliasTemplateContext:
     case ObjCParameterContext:
     case ObjCResultContext:
     case BlockLiteralContext:
     case LambdaExprContext:
     case ConversionIdContext:
     case TemplateTypeArgContext:
     case TrailingReturnContext:
      return false;
    }
    throw new llvm_unreachable("unknown context kind!");
  }

  
  /// diagnoseIdentifier - Return true if the identifier is prohibited and
  /// should be diagnosed (because it cannot be anything else).
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::diagnoseIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1877,
   FQN="clang::Declarator::diagnoseIdentifier", NM="_ZNK5clang10Declarator18diagnoseIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator18diagnoseIdentifierEv")
  //</editor-fold>
  public boolean diagnoseIdentifier() /*const*/ {
    switch (Context) {
     case FileContext:
     case KNRTypeListContext:
     case MemberContext:
     case BlockContext:
     case ForContext:
     case InitStmtContext:
     case ConditionContext:
     case PrototypeContext:
     case LambdaExprParameterContext:
     case TemplateParamContext:
     case CXXCatchContext:
     case ObjCCatchContext:
     case TypeNameContext:
     case ConversionIdContext:
     case ObjCParameterContext:
     case ObjCResultContext:
     case BlockLiteralContext:
     case CXXNewContext:
     case LambdaExprContext:
      return false;
     case AliasDeclContext:
     case AliasTemplateContext:
     case TemplateTypeArgContext:
     case TrailingReturnContext:
      return true;
    }
    throw new llvm_unreachable("unknown context kind!");
  }

  
  /// mayBeFollowedByCXXDirectInit - Return true if the declarator can be
  /// followed by a C++ direct initializer, e.g. "int x(1);".
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::mayBeFollowedByCXXDirectInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1911,
   FQN="clang::Declarator::mayBeFollowedByCXXDirectInit", NM="_ZNK5clang10Declarator28mayBeFollowedByCXXDirectInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator28mayBeFollowedByCXXDirectInitEv")
  //</editor-fold>
  public boolean mayBeFollowedByCXXDirectInit() /*const*/ {
    if (hasGroupingParens()) {
      return false;
    }
    if (getDeclSpec().getStorageClassSpec() == DeclSpec.SCS.SCS_typedef) {
      return false;
    }
    if (getDeclSpec().getStorageClassSpec() == DeclSpec.SCS.SCS_extern
       && Context != TheContext.FileContext) {
      return false;
    }
    
    // Special names can't have direct initializers.
    if (Name.getKind() != UnqualifiedId.IdKind.IK_Identifier) {
      return false;
    }
    switch (Context) {
     case FileContext:
     case BlockContext:
     case ForContext:
     case InitStmtContext:
      return true;
     case ConditionContext:
      // This may not be followed by a direct initializer, but it can't be a
      // function declaration either, and we'd prefer to perform a tentative
      // parse in order to produce the right diagnostic.
      return true;
     case KNRTypeListContext:
     case MemberContext:
     case PrototypeContext:
     case LambdaExprParameterContext:
     case ObjCParameterContext:
     case ObjCResultContext:
     case TemplateParamContext:
     case CXXCatchContext:
     case ObjCCatchContext:
     case TypeNameContext:
     case CXXNewContext:
     case AliasDeclContext:
     case AliasTemplateContext:
     case BlockLiteralContext:
     case LambdaExprContext:
     case ConversionIdContext:
     case TemplateTypeArgContext:
     case TrailingReturnContext:
      return false;
    }
    throw new llvm_unreachable("unknown context kind!");
  }

  
  /// isPastIdentifier - Return true if we have parsed beyond the point where
  /// the
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::isPastIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1963,
   FQN="clang::Declarator::isPastIdentifier", NM="_ZNK5clang10Declarator16isPastIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator16isPastIdentifierEv")
  //</editor-fold>
  public boolean isPastIdentifier() /*const*/ {
    return Name.isValid();
  }

  
  /// hasName - Whether this declarator has a name, which might be an
  /// identifier (accessible via getIdentifier()) or some kind of
  /// special C++ name (constructor, destructor, etc.).
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::hasName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1968,
   FQN="clang::Declarator::hasName", NM="_ZNK5clang10Declarator7hasNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator7hasNameEv")
  //</editor-fold>
  public boolean hasName() /*const*/ {
    return Name.getKind() != UnqualifiedId.IdKind.IK_Identifier || (Name.Unnamed_field1.Identifier != null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1972,
   FQN="clang::Declarator::getIdentifier", NM="_ZNK5clang10Declarator13getIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator13getIdentifierEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getIdentifier() /*const*/ {
    if (Name.getKind() == UnqualifiedId.IdKind.IK_Identifier) {
      return Name.Unnamed_field1.Identifier;
    }
    
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getIdentifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1978,
   FQN="clang::Declarator::getIdentifierLoc", NM="_ZNK5clang10Declarator16getIdentifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator16getIdentifierLocEv")
  //</editor-fold>
  public SourceLocation getIdentifierLoc() /*const*/ {
    return new SourceLocation(Name.StartLocation);
  }

  
  /// \brief Set the name of this declarator to be the given identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::SetIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1981,
   FQN="clang::Declarator::SetIdentifier", NM="_ZN5clang10Declarator13SetIdentifierEPNS_14IdentifierInfoENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator13SetIdentifierEPNS_14IdentifierInfoENS_14SourceLocationE")
  //</editor-fold>
  public void SetIdentifier(IdentifierInfo /*P*/ Id, SourceLocation IdLoc) {
    Name.setIdentifier(Id, new SourceLocation(IdLoc));
  }

  
  /// AddTypeInfo - Add a chunk to this declarator. Also extend the range to
  /// EndLoc, which should be the last token of the chunk.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::AddTypeInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1987,
   FQN="clang::Declarator::AddTypeInfo", NM="_ZN5clang10Declarator11AddTypeInfoERKNS_15DeclaratorChunkERNS_16ParsedAttributesENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator11AddTypeInfoERKNS_15DeclaratorChunkERNS_16ParsedAttributesENS_14SourceLocationE")
  //</editor-fold>
  public void AddTypeInfo(final /*const*/ DeclaratorChunk /*&*/ TI, 
             final ParsedAttributes /*&*/ attrs, 
             SourceLocation EndLoc) {
    DeclTypeInfo.push_back(TI);
    DeclTypeInfo.back().getAttrListRef().$set(attrs.getList());
    getAttributePool().takeAllFrom(attrs.getPool());
    if (!EndLoc.isInvalid()) {
      SetRangeEnd(new SourceLocation(EndLoc));
    }
  }

  
  /// \brief Add a new innermost chunk to this declarator.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::AddInnermostTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1999,
   FQN="clang::Declarator::AddInnermostTypeInfo", NM="_ZN5clang10Declarator20AddInnermostTypeInfoERKNS_15DeclaratorChunkE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator20AddInnermostTypeInfoERKNS_15DeclaratorChunkE")
  //</editor-fold>
  public void AddInnermostTypeInfo(final /*const*/ DeclaratorChunk /*&*/ TI) {
    DeclTypeInfo.insert(DeclTypeInfo.begin(), TI);
  }

  
  /// \brief Return the number of types applied to this declarator.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getNumTypeObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2004,
   FQN="clang::Declarator::getNumTypeObjects", NM="_ZNK5clang10Declarator17getNumTypeObjectsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator17getNumTypeObjectsEv")
  //</editor-fold>
  public /*uint*/int getNumTypeObjects() /*const*/ {
    return DeclTypeInfo.size();
  }

  
  /// Return the specified TypeInfo from this declarator.  TypeInfo #0 is
  /// closest to the identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getTypeObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2008,
   FQN="clang::Declarator::getTypeObject", NM="_ZNK5clang10Declarator13getTypeObjectEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator13getTypeObjectEj")
  //</editor-fold>
  public /*const*/ DeclaratorChunk /*&*/ getTypeObject$Const(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, DeclTypeInfo.size())) : "Invalid type chunk";
    return DeclTypeInfo.$at$Const(i);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getTypeObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2012,
   FQN="clang::Declarator::getTypeObject", NM="_ZN5clang10Declarator13getTypeObjectEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator13getTypeObjectEj")
  //</editor-fold>
  public DeclaratorChunk /*&*/ getTypeObject(/*uint*/int i) {
    assert ($less_uint(i, DeclTypeInfo.size())) : "Invalid type chunk";
    return DeclTypeInfo.$at(i);
  }

  
  /*typedef SmallVectorImpl<DeclaratorChunk>::const_iterator type_object_iterator*/
//  public final class type_object_iterator extends type$ptr<DeclaratorChunk>{ };
  /*typedef llvm::iterator_range<type_object_iterator> type_object_range*/
//  public final class type_object_range extends iterator_range<type$ptr<DeclaratorChunk> >{ };
  
  /// Returns the range of type objects, from the identifier outwards.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::type_objects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2021,
   FQN="clang::Declarator::type_objects", NM="_ZNK5clang10Declarator12type_objectsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator12type_objectsEv")
  //</editor-fold>
  public iterator_range<DeclaratorChunk> type_objects() /*const*/ {
    return new iterator_range<DeclaratorChunk>(DeclTypeInfo.begin$Const(), DeclTypeInfo.end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::DropFirstTypeObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2025,
   FQN="clang::Declarator::DropFirstTypeObject", NM="_ZN5clang10Declarator19DropFirstTypeObjectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator19DropFirstTypeObjectEv")
  //</editor-fold>
  public void DropFirstTypeObject() {
    assert (!DeclTypeInfo.empty()) : "No type chunks to drop.";
    DeclTypeInfo.front().destroy();
    DeclTypeInfo.erase(DeclTypeInfo.begin());
  }

  
  /// Return the innermost (closest to the declarator) chunk of this
  /// declarator that is not a parens chunk, or null if there are no
  /// non-parens chunks.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getInnermostNonParenChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2034,
   FQN="clang::Declarator::getInnermostNonParenChunk", NM="_ZNK5clang10Declarator25getInnermostNonParenChunkEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator25getInnermostNonParenChunkEv")
  //</editor-fold>
  public /*const*/ DeclaratorChunk /*P*/ getInnermostNonParenChunk() /*const*/ {
    for (/*uint*/int i = 0, i_end = DeclTypeInfo.size(); $less_uint(i, i_end); ++i) {
      if (!DeclTypeInfo.$at$Const(i).isParen()) {
        return $AddrOf(DeclTypeInfo.$at$Const(i));
      }
    }
    return null;
  }

  
  /// Return the outermost (furthest from the declarator) chunk of
  /// this declarator that is not a parens chunk, or null if there are
  /// no non-parens chunks.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getOutermostNonParenChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2045,
   FQN="clang::Declarator::getOutermostNonParenChunk", NM="_ZNK5clang10Declarator25getOutermostNonParenChunkEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator25getOutermostNonParenChunkEv")
  //</editor-fold>
  public /*const*/ DeclaratorChunk /*P*/ getOutermostNonParenChunk() /*const*/ {
    for (/*uint*/int i = DeclTypeInfo.size(), i_end = 0; i != i_end; --i) {
      if (!DeclTypeInfo.$at$Const(i - 1).isParen()) {
        return $AddrOf(DeclTypeInfo.$at$Const(i - 1));
      }
    }
    return null;
  }

  
  /// isArrayOfUnknownBound - This method returns true if the declarator
  /// is a declarator for an array of unknown bound (looking through
  /// parentheses).
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::isArrayOfUnknownBound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2056,
   FQN="clang::Declarator::isArrayOfUnknownBound", NM="_ZNK5clang10Declarator21isArrayOfUnknownBoundEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator21isArrayOfUnknownBoundEv")
  //</editor-fold>
  public boolean isArrayOfUnknownBound() /*const*/ {
    /*const*/ DeclaratorChunk /*P*/ chunk = getInnermostNonParenChunk();
    return ((chunk != null) && chunk.Kind == DeclaratorChunk.Unnamed_enum.Array
       && !(chunk.Unnamed_field3.Arr.NumElts != null));
  }

  
  /// isFunctionDeclarator - This method returns true if the declarator
  /// is a function declarator (looking through parentheses).
  /// If true is returned, then the reference type parameter idx is
  /// assigned with the index of the declaration chunk.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::isFunctionDeclarator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2066,
   FQN="clang::Declarator::isFunctionDeclarator", NM="_ZNK5clang10Declarator20isFunctionDeclaratorERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator20isFunctionDeclaratorERj")
  //</editor-fold>
  public boolean isFunctionDeclarator(final uint$ref/*uint &*/ idx) /*const*/ {
    for (/*uint*/int i = 0, i_end = DeclTypeInfo.size(); $less_uint(i, i_end); ++i) {
      switch (DeclTypeInfo.$at$Const(i).Kind) {
       case Function:
        idx.$set(i);
        return true;
       case Paren:
        continue;
       case Pointer:
       case Reference:
       case Array:
       case BlockPointer:
       case MemberPointer:
       case Pipe:
        return false;
      }
      throw new llvm_unreachable("Invalid type chunk");
    }
    return false;
  }

  
  /// isFunctionDeclarator - Once this declarator is fully parsed and formed,
  /// this method returns true if the identifier is a function declarator
  /// (looking through parentheses).
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::isFunctionDeclarator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2090,
   FQN="clang::Declarator::isFunctionDeclarator", NM="_ZNK5clang10Declarator20isFunctionDeclaratorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator20isFunctionDeclaratorEv")
  //</editor-fold>
  public boolean isFunctionDeclarator() /*const*/ {
    /*uint*/uint$ref index = create_uint$ref();
    return isFunctionDeclarator(index);
  }

  
  /// getFunctionTypeInfo - Retrieves the function type info object
  /// (looking through parentheses).
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getFunctionTypeInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2097,
   FQN="clang::Declarator::getFunctionTypeInfo", NM="_ZN5clang10Declarator19getFunctionTypeInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator19getFunctionTypeInfoEv")
  //</editor-fold>
  public DeclaratorChunk.FunctionTypeInfo /*&*/ getFunctionTypeInfo() {
    assert (isFunctionDeclarator()) : "Not a function declarator!";
    /*uint*/uint$ref index = create_uint$ref(0);
    isFunctionDeclarator(index);
    return DeclTypeInfo.$at(index.$deref()).Unnamed_field3.Fun;
  }

  
  /// getFunctionTypeInfo - Retrieves the function type info object
  /// (looking through parentheses).
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getFunctionTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2106,
   FQN="clang::Declarator::getFunctionTypeInfo", NM="_ZNK5clang10Declarator19getFunctionTypeInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator19getFunctionTypeInfoEv")
  //</editor-fold>
  public /*const*/ DeclaratorChunk.FunctionTypeInfo /*&*/ getFunctionTypeInfo$Const() /*const*/ {
    return ((/*const_cast*/Declarator /*P*/ )(this)).getFunctionTypeInfo();
  }

  
  /// \brief Determine whether the declaration that will be produced from 
  /// this declaration will be a function.
  /// 
  /// A declaration can declare a function even if the declarator itself
  /// isn't a function declarator, if the type specifier refers to a function
  /// type. This routine checks for both cases.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::isDeclarationOfFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 261,
   FQN="clang::Declarator::isDeclarationOfFunction", NM="_ZNK5clang10Declarator23isDeclarationOfFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator23isDeclarationOfFunctionEv")
  //</editor-fold>
  public boolean isDeclarationOfFunction() /*const*/ {
    for (/*uint*/int i = 0, i_end = DeclTypeInfo.size(); $less_uint(i, i_end); ++i) {
      switch (DeclTypeInfo.$at$Const(i).Kind) {
       case Function:
        return true;
       case Paren:
        continue;
       case Pointer:
       case Reference:
       case Array:
       case BlockPointer:
       case MemberPointer:
       case Pipe:
        return false;
      }
      throw new llvm_unreachable("Invalid type chunk");
    }
    switch (DS.getTypeSpecType()) {
     case TST_atomic:
     case TST_auto:
     case TST_auto_type:
     case TST_bool:
     case TST_char:
     case TST_char16:
     case TST_char32:
     case TST_class:
     case TST_decimal128:
     case TST_decimal32:
     case TST_decimal64:
     case TST_double:
     case TST_float128:
     case TST_enum:
     case TST_error:
     case TST_float:
     case TST_half:
     case TST_int:
     case TST_int128:
     case TST_struct:
     case TST_interface:
     case TST_union:
     case TST_unknown_anytype:
     case TST_unspecified:
     case TST_void:
     case TST_wchar:
     case TST_image1d_t:
     case TST_image1d_array_t:
     case TST_image1d_buffer_t:
     case TST_image2d_t:
     case TST_image2d_array_t:
     case TST_image2d_depth_t:
     case TST_image2d_array_depth_t:
     case TST_image2d_msaa_t:
     case TST_image2d_array_msaa_t:
     case TST_image2d_msaa_depth_t:
     case TST_image2d_array_msaa_depth_t:
     case TST_image3d_t:
      return false;
     case TST_decltype_auto:
      // This must have an initializer, so can't be a function declaration,
      // even if the initializer has function type.
      return false;
     case TST_decltype:
     case TST_typeofExpr:
      {
        Expr /*P*/ E = DS.getRepAsExpr();
        if ((E != null)) {
          return E.getType().$arrow().isFunctionType();
        }
      }
      return false;
     case TST_underlyingType:
     case TST_typename:
     case TST_typeofType:
      {
        QualType QT = DS.getRepAsType().getQualType();
        if (QT.isNull()) {
          return false;
        }
        {
          
          /*const*/ LocInfoType /*P*/ LIT = dyn_cast(LocInfoType.class, QT);
          if ((LIT != null)) {
            QT.$assignMove(LIT.getType());
          }
        }
        if (QT.isNull()) {
          return false;
        }
        
        return QT.$arrow().isFunctionType();
      }
    }
    throw new llvm_unreachable("Invalid TypeSpecType!");
  }

  
  /// \brief Return true if this declaration appears in a context where a
  /// function declarator would be a function declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::isFunctionDeclarationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2120,
   FQN="clang::Declarator::isFunctionDeclarationContext", NM="_ZNK5clang10Declarator28isFunctionDeclarationContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator28isFunctionDeclarationContextEv")
  //</editor-fold>
  public boolean isFunctionDeclarationContext() /*const*/ {
    if (getDeclSpec().getStorageClassSpec() == DeclSpec.SCS.SCS_typedef) {
      return false;
    }
    switch (Context) {
     case FileContext:
     case MemberContext:
     case BlockContext:
     case ForContext:
     case InitStmtContext:
      return true;
     case ConditionContext:
     case KNRTypeListContext:
     case TypeNameContext:
     case AliasDeclContext:
     case AliasTemplateContext:
     case PrototypeContext:
     case LambdaExprParameterContext:
     case ObjCParameterContext:
     case ObjCResultContext:
     case TemplateParamContext:
     case CXXNewContext:
     case CXXCatchContext:
     case ObjCCatchContext:
     case BlockLiteralContext:
     case LambdaExprContext:
     case ConversionIdContext:
     case TemplateTypeArgContext:
     case TrailingReturnContext:
      return false;
    }
    throw new llvm_unreachable("unknown context kind!");
  }

  
  /// \brief Return true if a function declarator at this position would be a
  /// function declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::isFunctionDeclaratorAFunctionDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2157,
   FQN="clang::Declarator::isFunctionDeclaratorAFunctionDeclaration", NM="_ZNK5clang10Declarator40isFunctionDeclaratorAFunctionDeclarationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator40isFunctionDeclaratorAFunctionDeclarationEv")
  //</editor-fold>
  public boolean isFunctionDeclaratorAFunctionDeclaration() /*const*/ {
    if (!isFunctionDeclarationContext()) {
      return false;
    }
    
    for (/*uint*/int I = 0, N = getNumTypeObjects(); I != N; ++I)  {
      if (getTypeObject$Const(I).Kind != DeclaratorChunk.Unnamed_enum.Paren) {
        return false;
      }
    }
    
    return true;
  }

  
  /// takeAttributes - Takes attributes from the given parsed-attributes
  /// set and add them to this declarator.
  ///
  /// These examples both add 3 attributes to "var":
  ///  short int var __attribute__((aligned(16),common,deprecated));
  ///  short int x, __attribute__((aligned(16)) var
  ///                                 __attribute__((common,deprecated));
  ///
  /// Also extends the range of the declarator.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::takeAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2177,
   FQN="clang::Declarator::takeAttributes", NM="_ZN5clang10Declarator14takeAttributesERNS_16ParsedAttributesENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator14takeAttributesERNS_16ParsedAttributesENS_14SourceLocationE")
  //</editor-fold>
  public void takeAttributes(final ParsedAttributes /*&*/ attrs, SourceLocation lastLoc) {
    Attrs.takeAllFrom(attrs);
    if (!lastLoc.isInvalid()) {
      SetRangeEnd(new SourceLocation(lastLoc));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2184,
   FQN="clang::Declarator::getAttributes", NM="_ZNK5clang10Declarator13getAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator13getAttributesEv")
  //</editor-fold>
  public /*const*/ AttributeList /*P*/ getAttributes$Const() /*const*/ {
    return Attrs.getList();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2185,
   FQN="clang::Declarator::getAttributes", NM="_ZN5clang10Declarator13getAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator13getAttributesEv")
  //</editor-fold>
  public AttributeList /*P*/ getAttributes() {
    return Attrs.getList();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getAttrListRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2187,
   FQN="clang::Declarator::getAttrListRef", NM="_ZN5clang10Declarator14getAttrListRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator14getAttrListRefEv")
  //</editor-fold>
  public type$ref<AttributeList/*P*/>/*&*/ getAttrListRef() {
    return Attrs.getListRef();
  }

  
  /// hasAttributes - do we contain any attributes?
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::hasAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2190,
   FQN="clang::Declarator::hasAttributes", NM="_ZNK5clang10Declarator13hasAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator13hasAttributesEv")
  //</editor-fold>
  public boolean hasAttributes() /*const*/ {
    if ((getAttributes$Const() != null) || getDeclSpec().hasAttributes()) {
      return true;
    }
    for (/*uint*/int i = 0, e = getNumTypeObjects(); i != e; ++i)  {
      if ((getTypeObject$Const(i).getAttrs() != null)) {
        return true;
      }
    }
    return false;
  }

  
  /// \brief Return a source range list of C++11 attributes associated
  /// with the declarator.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getCXX11AttributeRanges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2200,
   FQN="clang::Declarator::getCXX11AttributeRanges", NM="_ZN5clang10Declarator23getCXX11AttributeRangesERN4llvm15SmallVectorImplINS_11SourceRangeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator23getCXX11AttributeRangesERN4llvm15SmallVectorImplINS_11SourceRangeEEE")
  //</editor-fold>
  public void getCXX11AttributeRanges(final SmallVectorImpl<SourceRange> /*&*/ Ranges) {
    AttributeList /*P*/ AttrList = Attrs.getList();
    while ((AttrList != null)) {
      if (AttrList.isCXX11Attribute()) {
        Ranges.push_back(AttrList.getRange());
      }
      AttrList = AttrList.getNext();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::setAsmLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2209,
   FQN="clang::Declarator::setAsmLabel", NM="_ZN5clang10Declarator11setAsmLabelEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator11setAsmLabelEPNS_4ExprE")
  //</editor-fold>
  public void setAsmLabel(Expr /*P*/ E) {
    AsmLabel = E;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getAsmLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2210,
   FQN="clang::Declarator::getAsmLabel", NM="_ZNK5clang10Declarator11getAsmLabelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator11getAsmLabelEv")
  //</editor-fold>
  public Expr /*P*/ getAsmLabel() /*const*/ {
    return AsmLabel;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::setExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2212,
   FQN="clang::Declarator::setExtension", NM="_ZN5clang10Declarator12setExtensionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator12setExtensionEb")
  //</editor-fold>
  public void setExtension() {
    setExtension(true);
  }
  public void setExtension(boolean Val/*= true*/) {
    Extension = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2213,
   FQN="clang::Declarator::getExtension", NM="_ZNK5clang10Declarator12getExtensionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator12getExtensionEv")
  //</editor-fold>
  public boolean getExtension() /*const*/ {
    return Extension;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::setObjCIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2215,
   FQN="clang::Declarator::setObjCIvar", NM="_ZN5clang10Declarator11setObjCIvarEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator11setObjCIvarEb")
  //</editor-fold>
  public void setObjCIvar() {
    setObjCIvar(true);
  }
  public void setObjCIvar(boolean Val/*= true*/) {
    ObjCIvar = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::isObjCIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2216,
   FQN="clang::Declarator::isObjCIvar", NM="_ZNK5clang10Declarator10isObjCIvarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator10isObjCIvarEv")
  //</editor-fold>
  public boolean isObjCIvar() /*const*/ {
    return ObjCIvar;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::setObjCWeakProperty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2218,
   FQN="clang::Declarator::setObjCWeakProperty", NM="_ZN5clang10Declarator19setObjCWeakPropertyEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator19setObjCWeakPropertyEb")
  //</editor-fold>
  public void setObjCWeakProperty() {
    setObjCWeakProperty(true);
  }
  public void setObjCWeakProperty(boolean Val/*= true*/) {
    ObjCWeakProperty = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::isObjCWeakProperty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2219,
   FQN="clang::Declarator::isObjCWeakProperty", NM="_ZNK5clang10Declarator18isObjCWeakPropertyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator18isObjCWeakPropertyEv")
  //</editor-fold>
  public boolean isObjCWeakProperty() /*const*/ {
    return ObjCWeakProperty;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::setInvalidType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2221,
   FQN="clang::Declarator::setInvalidType", NM="_ZN5clang10Declarator14setInvalidTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator14setInvalidTypeEb")
  //</editor-fold>
  public void setInvalidType() {
    setInvalidType(true);
  }
  public void setInvalidType(boolean Val/*= true*/) {
    InvalidType = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::isInvalidType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2222,
   FQN="clang::Declarator::isInvalidType", NM="_ZNK5clang10Declarator13isInvalidTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator13isInvalidTypeEv")
  //</editor-fold>
  public boolean isInvalidType() /*const*/ {
    return InvalidType || DS.getTypeSpecType() == DeclSpec.TST_error;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::setGroupingParens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2226,
   FQN="clang::Declarator::setGroupingParens", NM="_ZN5clang10Declarator17setGroupingParensEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator17setGroupingParensEb")
  //</editor-fold>
  public void setGroupingParens(boolean flag) {
    GroupingParens = flag;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::hasGroupingParens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2227,
   FQN="clang::Declarator::hasGroupingParens", NM="_ZNK5clang10Declarator17hasGroupingParensEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator17hasGroupingParensEv")
  //</editor-fold>
  public boolean hasGroupingParens() /*const*/ {
    return GroupingParens;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::isFirstDeclarator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2229,
   FQN="clang::Declarator::isFirstDeclarator", NM="_ZNK5clang10Declarator17isFirstDeclaratorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator17isFirstDeclaratorEv")
  //</editor-fold>
  public boolean isFirstDeclarator() /*const*/ {
    return !CommaLoc.isValid();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getCommaLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2230,
   FQN="clang::Declarator::getCommaLoc", NM="_ZNK5clang10Declarator11getCommaLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator11getCommaLocEv")
  //</editor-fold>
  public SourceLocation getCommaLoc() /*const*/ {
    return new SourceLocation(CommaLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::setCommaLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2231,
   FQN="clang::Declarator::setCommaLoc", NM="_ZN5clang10Declarator11setCommaLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator11setCommaLocENS_14SourceLocationE")
  //</editor-fold>
  public void setCommaLoc(SourceLocation CL) {
    CommaLoc.$assign(CL);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::hasEllipsis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2233,
   FQN="clang::Declarator::hasEllipsis", NM="_ZNK5clang10Declarator11hasEllipsisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator11hasEllipsisEv")
  //</editor-fold>
  public boolean hasEllipsis() /*const*/ {
    return EllipsisLoc.isValid();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getEllipsisLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2234,
   FQN="clang::Declarator::getEllipsisLoc", NM="_ZNK5clang10Declarator14getEllipsisLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator14getEllipsisLocEv")
  //</editor-fold>
  public SourceLocation getEllipsisLoc() /*const*/ {
    return new SourceLocation(EllipsisLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::setEllipsisLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2235,
   FQN="clang::Declarator::setEllipsisLoc", NM="_ZN5clang10Declarator14setEllipsisLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator14setEllipsisLocENS_14SourceLocationE")
  //</editor-fold>
  public void setEllipsisLoc(SourceLocation EL) {
    EllipsisLoc.$assign(EL);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::setFunctionDefinitionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2237,
   FQN="clang::Declarator::setFunctionDefinitionKind", NM="_ZN5clang10Declarator25setFunctionDefinitionKindENS_22FunctionDefinitionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator25setFunctionDefinitionKindENS_22FunctionDefinitionKindE")
  //</editor-fold>
  public void setFunctionDefinitionKind(FunctionDefinitionKind Val) {
    FunctionDefinition = $uint2uint_2bits(Val.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::isFunctionDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2241,
   FQN="clang::Declarator::isFunctionDefinition", NM="_ZNK5clang10Declarator20isFunctionDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator20isFunctionDefinitionEv")
  //</editor-fold>
  public boolean isFunctionDefinition() /*const*/ {
    return getFunctionDefinitionKind() != FunctionDefinitionKind.FDK_Declaration;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::getFunctionDefinitionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2245,
   FQN="clang::Declarator::getFunctionDefinitionKind", NM="_ZNK5clang10Declarator25getFunctionDefinitionKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator25getFunctionDefinitionKindEv")
  //</editor-fold>
  public FunctionDefinitionKind getFunctionDefinitionKind() /*const*/ {
    return FunctionDefinitionKind.valueOf(FunctionDefinition);
  }

  
  /// Returns true if this declares a real member and not a friend.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::isFirstDeclarationOfMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2250,
   FQN="clang::Declarator::isFirstDeclarationOfMember", NM="_ZN5clang10Declarator26isFirstDeclarationOfMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator26isFirstDeclarationOfMemberEv")
  //</editor-fold>
  public boolean isFirstDeclarationOfMember() {
    return getContext() == TheContext.MemberContext && !getDeclSpec().isFriendSpecified();
  }

  
  /// Returns true if this declares a static member.  This cannot be called on a
  /// declarator outside of a MemberContext because we won't know until
  /// redeclaration time if the decl is static.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::isStaticMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 341,
   FQN="clang::Declarator::isStaticMember", NM="_ZN5clang10Declarator14isStaticMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator14isStaticMemberEv")
  //</editor-fold>
  public boolean isStaticMember() {
    assert (getContext() == TheContext.MemberContext);
    return getDeclSpec().getStorageClassSpec() == DeclSpec.SCS.SCS_static
       || (getName().Kind == UnqualifiedId.IdKind.IK_OperatorFunctionId
       && CXXMethodDecl.isStaticOverloadedOperator(getName().Unnamed_field1.OperatorFunctionId.Operator));
  }

  
  /// Returns true if this declares a constructor or a destructor.
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::isCtorOrDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 349,
   FQN="clang::Declarator::isCtorOrDtor", NM="_ZN5clang10Declarator12isCtorOrDtorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator12isCtorOrDtorEv")
  //</editor-fold>
  public boolean isCtorOrDtor() {
    return (getName().getKind() == UnqualifiedId.IdKind.IK_ConstructorName)
       || (getName().getKind() == UnqualifiedId.IdKind.IK_DestructorName);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::setRedeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2262,
   FQN="clang::Declarator::setRedeclaration", NM="_ZN5clang10Declarator16setRedeclarationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang10Declarator16setRedeclarationEb")
  //</editor-fold>
  public void setRedeclaration(boolean Val) {
    Redeclaration = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Declarator::isRedeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2263,
   FQN="clang::Declarator::isRedeclaration", NM="_ZNK5clang10Declarator15isRedeclarationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang10Declarator15isRedeclarationEv")
  //</editor-fold>
  public boolean isRedeclaration() /*const*/ {
    return Redeclaration;
  }

  
  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", DS=" + DS // NOI18N
              + ", SS=" + SS // NOI18N
              + ", Range=" + Range // NOI18N
              + ", Context=" + Context // NOI18N
              + ", DeclTypeInfo=" + DeclTypeInfo // NOI18N
              + ", InvalidType=" + InvalidType // NOI18N
              + ", GroupingParens=" + GroupingParens // NOI18N
              + ", FunctionDefinition=" + $uchar2uint(FunctionDefinition) // NOI18N
              + ", Redeclaration=" + Redeclaration // NOI18N
              + ", Attrs=" + Attrs // NOI18N
              + ", AsmLabel=" + AsmLabel // NOI18N
              + ", InlineParams=" + InlineParams // NOI18N
              + ", InlineParamsUsed=" + InlineParamsUsed // NOI18N
              + ", Extension=" + Extension // NOI18N
              + ", ObjCIvar=" + ObjCIvar // NOI18N
              + ", ObjCWeakProperty=" + ObjCWeakProperty // NOI18N
              + ", CommaLoc=" + CommaLoc // NOI18N
              + ", EllipsisLoc=" + EllipsisLoc; // NOI18N
  }
}
