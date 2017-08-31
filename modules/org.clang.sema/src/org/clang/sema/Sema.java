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
import java.util.Comparator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.analysis.analyses.threadSafety.*;
import org.clang.analysis.threadSafety.impl.BeforeSet;
import static org.clang.sema.Sema.*;
import static org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.sema.java.SemaRTTI.*;
import org.clang.basic.llvm.*;
import org.clang.sema.llvm.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.basic.java.OptionalNotes;


/// Sema - This implements semantic analysis and AST building for C.
//<editor-fold defaultstate="collapsed" desc="clang::Sema">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 263,
 FQN="clang::Sema", NM="_ZN5clang4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4SemaE")
//</editor-fold>
public class Sema extends Sema_SemaType implements Destructors.ClassWithDestructor {

  ///\brief Source of additional semantic information.
  protected/*private*/ ExternalSemaSource /*P*/ ExternalSource;
  
  ///\brief Whether Sema has generated a multiplexer and has to delete it.
  protected/*private*/ boolean isMultiplexExternalSource;  
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::shouldLinkPossiblyHiddenDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 277,
   FQN="clang::Sema::shouldLinkPossiblyHiddenDecl", NM="_ZN5clang4Sema28shouldLinkPossiblyHiddenDeclEPKNS_9NamedDeclES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema28shouldLinkPossiblyHiddenDeclEPKNS_9NamedDeclES3_")
  //</editor-fold>
  protected/*private*/ final boolean shouldLinkPossiblyHiddenDecl(/*const*/ NamedDecl /*P*/ Old, 
                              /*const*/ NamedDecl /*P*/ New) {
    // We are about to link these. It is now safe to compute the linkage of
    // the new decl. If the new decl has external linkage, we will
    // link it with the hidden decl (which also has external linkage) and
    // it will keep having external linkage. If it has internal linkage, we
    // will not link it. Since it has no previous decls, it will remain
    // with internal linkage.
    return isVisible(Old) || New.isExternallyVisible();
  }

  /*typedef OpaquePtr<DeclGroupRef> DeclGroupPtrTy*/
//  public final class DeclGroupPtrTy extends OpaquePtr<DeclGroupRef>{ };
  /*typedef OpaquePtr<TemplateName> TemplateTy*/
//  public final class TemplateTy extends OpaquePtr<TemplateName>{ };
  /*typedef OpaquePtr<QualType> TypeTy*/
//  public final class TypeTy extends OpaquePtr<QualType>{ };
  
  public OpenCLOptions OpenCLFeatures;
  public FPOptions FPFeatures;
  
  public/*friend*//*public*/ final /*const*/ LangOptions /*&*/ LangOpts;
  public/*public*/ final Preprocessor /*&*/ PP;
  /*friend*/public/*public*/ final ASTContext /*&*/ Context;
  public/*friend*//*public*/ final ASTConsumer /*&*/ Consumer;
  public/*friend*//*public*/ final DiagnosticsEngine /*&*/ Diags;
  public/*public*/ final SourceManager /*&*/ SourceMgr;
  
  /// \brief Flag indicating whether or not to collect detailed statistics.
  public boolean CollectStats;
  
  /// \brief Code-completion consumer.
  public CodeCompleteConsumer /*P*/ CodeCompleter;
  
  /// CurContext - This is the current declaration context of parsing.
  public/*friend*//*public*/ DeclContext /*P*/ CurContext;
  
  /// \brief Generally null except when we temporarily switch decl contexts,
  /// like in \see ActOnObjCTemporaryExitContainerContext.
  public DeclContext /*P*/ OriginalLexicalContext;
  
  /// VAListTagName - The declaration name corresponding to __va_list_tag.
  /// This is used as part of a hack to omit that class from ADL results.
  public DeclarationName VAListTagName;
  
  public boolean MSStructPragmaOn; // True when \#pragma ms_struct on
  
  /// \brief Controls member pointer representation format under the MS ABI.
  public LangOptions.PragmaMSPointersToMembersKind MSPointerToMemberRepresentationMethod;
  
  /// Stack of active SEH __finally scopes.  Can be empty.
  public SmallVector<Scope /*P*/ > CurrentSEHFinally;
  
  /// \brief Source location for newly created implicit MSInheritanceAttrs
  public SourceLocation ImplicitMSInheritanceAttrLoc;
  
  // FIXME: We should serialize / deserialize these if they occur in a PCH (but
  // we shouldn't do so if they're in a module).
  
  /// \brief Whether to insert vtordisps prior to virtual bases in the Microsoft
  /// C++ ABI.  Possible values are 0, 1, and 2, which mean:
  ///
  /// 0: Suppress all vtordisps
  /// 1: Insert vtordisps in the presence of vbase overrides and non-trivial
  ///    structors
  /// 2: Always insert vtordisps to support RTTI on partially constructed
  ///    objects
  public PragmaStack<MSVtorDispAttr.Mode> VtorDispStack;
  // #pragma pack.
  // Sentinel to represent when the stack is set to mac68k alignment.
  public static /*const*//*uint*/int kMac68kAlignmentSentinel = ~0/*U*/;
  public PragmaStackUInt PackStack;
  // Segment #pragmas.
  public PragmaStack<StringLiteral /*P*/ > DataSegStack;
  public PragmaStack<StringLiteral /*P*/ > BSSSegStack;
  public PragmaStack<StringLiteral /*P*/ > ConstSegStack;
  public PragmaStack<StringLiteral /*P*/ > CodeSegStack;
  
  /// A mapping that describes the nullability we've seen in each header file.
  public FileNullabilityMap NullabilityMap;
  
  /// Last section used with #pragma init_seg.
  public StringLiteral /*P*/ CurInitSeg;
  public SourceLocation CurInitSegLoc;
  
  /// VisContext - Manages the stack for \#pragma GCC visibility.
  public Object/*void P*/ VisContext; // Really a "PragmaVisStack*"
  
  /// \brief This represents the last location of a "#pragma clang optimize off"
  /// directive if such a directive has not been closed by an "on" yet. If
  /// optimizations are currently "on", this is set to an invalid location.
  public SourceLocation OptimizeOffPragmaLocation;
  
  /// \brief Flag indicating if Sema is building a recovery call expression.
  ///
  /// This flag is used to avoid building recovery call expressions
  /// if Sema is already doing so, which would cause infinite recursions.
  public boolean IsBuildingRecoveryCallExpr;
  
  /// Used to control the generation of ExprWithCleanups.
  public CleanupInfo Cleanup;
  
  /// ExprCleanupObjects - This is the stack of objects requiring
  /// cleanup that are created by the current full expression.  The
  /// element type here is ExprWithCleanups::Object.
  public SmallVector<BlockDecl /*P*/ > ExprCleanupObjects;
  
  /// \brief Store a list of either DeclRefExprs or MemberExprs
  ///  that contain a reference to a variable (constant) that may or may not
  ///  be odr-used in this Expr, and we won't know until all lvalue-to-rvalue
  ///  and discarded value conversions have been applied to all subexpressions 
  ///  of the enclosing full expression.  This is cleared at the end of each 
  ///  full expression. 
  public SmallPtrSet<Expr /*P*/ > MaybeODRUseExprs;
  
  /// \brief Stack containing information about each of the nested
  /// function, block, and method scopes that are currently active.
  ///
  /// This array is never empty.  Clients should ignore the first
  /// element, which is used to cache a single FunctionScopeInfo
  /// that's used to parse every top-level function.
  public SmallVector<FunctionScopeInfo /*P*/ > FunctionScopes;
  
  /*typedef LazyVector<TypedefNameDecl *, ExternalSemaSource, &FPtrExternalSemaSource::ReadExtVectorDecls, 2, 2> ExtVectorDeclsType*/
//  public final class ExtVectorDeclsType extends ExtVectorDeclsType{ };
  
  /// ExtVectorDecls - This is a list all the extended vector types. This allows
  /// us to associate a raw vector type with one of the ext_vector type names.
  /// This is only necessary for issuing pretty diagnostics.
  public ExtVectorDeclsType ExtVectorDecls;
  
  /// FieldCollector - Collects CXXFieldDecls during parsing of C++ classes.
  public std.unique_ptr<CXXFieldCollector> FieldCollector;
  
  /*typedef llvm::SmallSetVector<const NamedDecl *, 16> NamedDeclSetType*/
//  public final class NamedDeclSetType extends SmallSetVector</*const*/ NamedDecl /*P*/ >{ };
  
  /// \brief Set containing all declared private fields that are not used.
  public SmallSetVector</*const*/ NamedDecl /*P*/ > UnusedPrivateFields;
  
  /// \brief Set containing all typedefs that are likely unused.
  public SmallSetVector</*const*/ TypedefNameDecl /*P*/> UnusedLocalTypedefNameCandidates;
  
  /// \brief Delete-expressions to be analyzed at the end of translation unit
  ///
  /// This list contains class members, and locations of delete-expressions
  /// that could not be proven as to whether they mismatch with new-expression
  /// used in initializer of the field.
  /*typedef std::pair<SourceLocation, bool> DeleteExprLoc*/
//  public final class DeleteExprLoc extends std.pairTypeBool<SourceLocation>{ };
  /*typedef llvm::SmallVector<DeleteExprLoc, 4> DeleteLocs*/
//  public final class DeleteLocs extends SmallVector<std.pairTypeBool<SourceLocation>>{ };
  public MapVectorPtrType<FieldDecl /*P*/ , SmallVector<std.pairTypeBool<SourceLocation>> > DeleteExprs;
  
  /*typedef llvm::SmallPtrSet<const CXXRecordDecl *, 8> RecordDeclSetTy*/
//  public final class RecordDeclSetTy extends SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >{ };
  
  /// PureVirtualClassDiagSet - a set of class declarations which we have
  /// emitted a list of pure virtual functions. Used to prevent emitting the
  /// same list more than once.
  public std.unique_ptr<SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > > PureVirtualClassDiagSet;
  
  /// ParsingInitForAutoVars - a set of declarations with auto types for which
  /// we are currently parsing the initializer.
  public SmallPtrSet</*const*/ Decl /*P*/ > ParsingInitForAutoVars;
  
  /*typedef LazyVector<VarDecl *, ExternalSemaSource, &FPtrExternalSemaSource::ReadTentativeDefinitions, 2, 2> TentativeDefinitionsType*/
//  public final class TentativeDefinitionsType extends TentativeDefinitionsType{ };
  
  /// \brief All the tentative definitions encountered in the TU.
  public TentativeDefinitionsType TentativeDefinitions;
  
  /*typedef LazyVector<const DeclaratorDecl *, ExternalSemaSource, &FPtrExternalSemaSource::ReadUnusedFileScopedDecls, 2, 2> UnusedFileScopedDeclsType*/
//  public final class UnusedFileScopedDeclsType extends UnusedFileScopedDeclsType{ };
  
  /// \brief The set of file scoped decls seen so far that have not been used
  /// and must warn if not used. Only contains the first declaration.
  public UnusedFileScopedDeclsType UnusedFileScopedDecls;
  
  /*typedef LazyVector<CXXConstructorDecl *, ExternalSemaSource, &FPtrExternalSemaSource::ReadDelegatingConstructors, 2, 2> DelegatingCtorDeclsType*/
//  public final class DelegatingCtorDeclsType extends DelegatingCtorDeclsType{ };
  
  /// \brief All the delegating constructors seen so far in the file, used for
  /// cycle detection at the end of the TU.
  public DelegatingCtorDeclsType DelegatingCtorDecls;
  
  /// \brief All the overriding functions seen during a class definition
  /// that had their exception spec checks delayed, plus the overridden
  /// function.
  public SmallVector<std.pair</*const*/ CXXMethodDecl /*P*/ , /*const*/ CXXMethodDecl /*P*/ >> DelayedExceptionSpecChecks;
  
  /// \brief All the members seen during a class definition which were both
  /// explicitly defaulted and had explicitly-specified exception
  /// specifications, along with the function type containing their
  /// user-specified exception specification. Those exception specifications
  /// were overridden with the default specifications, but we still need to
  /// check whether they are compatible with the default specification, and
  /// we can't do that until the nesting set of class definitions is complete.
  public SmallVector<std.pair<CXXMethodDecl /*P*/ , /*const*/ FunctionProtoType /*P*/ >> DelayedDefaultedMemberExceptionSpecs;
  
  /*typedef llvm::MapVector<const FunctionDecl *, LateParsedTemplate *> LateParsedTemplateMapT*/
//  public final class LateParsedTemplateMapT extends MapVector</*const*/ FunctionDecl /*P*/ , LateParsedTemplate /*P*/ >{ };
  public MapVectorPtrPtr</*const*/ FunctionDecl /*P*/ , LateParsedTemplate /*P*/ > LateParsedTemplateMap;
  
  /// \brief Callback to the parser to parse templated functions when needed.
  /*typedef void (LateTemplateParserCB)(void *, LateParsedTemplate &)*/
//  public final class LateTemplateParserCB extends LateTemplateParserCB{ };
  /*typedef void (LateTemplateParserCleanupCB)(void *)*/
//  public final class LateTemplateParserCleanupCB extends VoidPtr2Void{ };
  public LateTemplateParserCB/*P*/ LateTemplateParser;
  public LateTemplateParserCleanupCB/*P*/ LateTemplateParserCleanup;
  public Object/*void P*/ OpaqueParser;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::SetLateTemplateParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 563,
   FQN="clang::Sema::SetLateTemplateParser", NM="_ZN5clang4Sema21SetLateTemplateParserEPFvPvRNS_18LateParsedTemplateEEPFvS1_ES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema21SetLateTemplateParserEPFvPvRNS_18LateParsedTemplateEEPFvS1_ES1_")
  //</editor-fold>
  public final void SetLateTemplateParser(LateTemplateParserCB/*P*/ LTP, 
                       LateTemplateParserCleanupCB/*P*/ LTPCleanup, 
                       Object/*void P*/ P) {
    LateTemplateParser = $tryClone(LTP);
    LateTemplateParserCleanup = $tryClone(LTPCleanup);
    OpaqueParser = P;
  }

  /*typedef DelayedDiagnosticsState ParsingDeclState*/
//  public final class ParsingDeclState extends DelayedDiagnosticsState{ };
  /*typedef DelayedDiagnosticsState ProcessingContextState*/
//  public final class ProcessingContextState extends DelayedDiagnosticsState{ };
  
  /// A class which encapsulates the logic for delaying diagnostics
  /// during parsing and other processing.
  public  DelayedDiagnostics DelayedDiagnostics;
  
  /// WeakUndeclaredIdentifiers - Identifiers contained in
  /// \#pragma weak before declared. rare. may alias another
  /// identifier, declared or undeclared
  public MapVectorPtrType<IdentifierInfo /*P*/ , WeakInfo> WeakUndeclaredIdentifiers;
  
  /// ExtnameUndeclaredIdentifiers - Identifiers contained in
  /// \#pragma redefine_extname before declared.  Used in Solaris system headers
  /// to define functions that occur in multiple standards to call the version
  /// in the currently selected standard.
  public DenseMap<IdentifierInfo /*P*/ , AsmLabelAttr /*P*/ > ExtnameUndeclaredIdentifiers;
  
  /// WeakTopLevelDecl - Translation-unit scoped declarations generated by
  /// \#pragma weak during processing of other Decls.
  /// I couldn't figure out a clean way to generate these in-line, so
  /// we store them here and handle separately -- which is a hack.
  /// It would be best to refactor this.
  public SmallVector<Decl /*P*/> WeakTopLevelDecl;
  
  public IdentifierResolver IdResolver;
  
  /// Translation Unit Scope - useful to Objective-C actions that need
  /// to lookup file scope declarations in the "ordinary" C decl namespace.
  /// For example, user-defined classes, built-in "id" type, etc.
  public Scope /*P*/ TUScope;
  
  /// \brief The C++ "std" namespace, where the standard library resides.
  public LazyDeclPtr StdNamespace;
  
  /// \brief The C++ "std::bad_alloc" class, which is defined by the C++
  /// standard library.
  public LazyDeclPtr StdBadAlloc;
  
  /// \brief The C++ "std::initializer_list" template, which is defined in
  /// \<initializer_list>.
  public ClassTemplateDecl /*P*/ StdInitializerList;
  
  /// \brief The C++ "type_info" declaration, which is defined in \<typeinfo>.
  public RecordDecl /*P*/ CXXTypeInfoDecl;
  
  /// \brief The MSVC "_GUID" struct, which is defined in MSVC header files.
  public RecordDecl /*P*/ MSVCGuidDecl;
  
  /// \brief Caches identifiers/selectors for NSFoundation APIs.
  public std.unique_ptr<NSAPI> NSAPIObj;
  
  /// \brief The declaration of the Objective-C NSNumber class.
  public ObjCInterfaceDecl /*P*/ NSNumberDecl;
  
  /// \brief The declaration of the Objective-C NSValue class.
  public ObjCInterfaceDecl /*P*/ NSValueDecl;
  
  /// \brief Pointer to NSNumber type (NSNumber *).
  public QualType NSNumberPointer;
  
  /// \brief Pointer to NSValue type (NSValue *).
  public QualType NSValuePointer;
  
  /// \brief The Objective-C NSNumber methods used to create NSNumber literals.
  public ObjCMethodDecl /*P*/ NSNumberLiteralMethods[/*15*/] = new ObjCMethodDecl /*P*/  [15];
  
  /// \brief The declaration of the Objective-C NSString class.
  public ObjCInterfaceDecl /*P*/ NSStringDecl;
  
  /// \brief Pointer to NSString type (NSString *).
  public QualType NSStringPointer;
  
  /// \brief The declaration of the stringWithUTF8String: method.
  public ObjCMethodDecl /*P*/ StringWithUTF8StringMethod;
  
  /// \brief The declaration of the valueWithBytes:objCType: method.
  public ObjCMethodDecl /*P*/ ValueWithBytesObjCTypeMethod;
  
  /// \brief The declaration of the Objective-C NSArray class.
  public ObjCInterfaceDecl /*P*/ NSArrayDecl;
  
  /// \brief The declaration of the arrayWithObjects:count: method.
  public ObjCMethodDecl /*P*/ ArrayWithObjectsMethod;
  
  /// \brief The declaration of the Objective-C NSDictionary class.
  public ObjCInterfaceDecl /*P*/ NSDictionaryDecl;
  
  /// \brief The declaration of the dictionaryWithObjects:forKeys:count: method.
  public ObjCMethodDecl /*P*/ DictionaryWithObjectsMethod;
  
  /// \brief id<NSCopying> type.
  public QualType QIDNSCopying;
  
  /// \brief will hold 'respondsToSelector:'
  public Selector RespondsToSelectorSel;
  
  /// \brief counter for internal MS Asm label names.
  public /*uint*/int MSAsmLabelNameCounter;
  
  /// A flag to remember whether the implicit forms of operator new and delete
  /// have been declared.
  public boolean GlobalNewDeleteDeclared;
  
  /// A flag to indicate that we're in a context that permits abstract
  /// references to fields.  This is really a 
  public boolean AllowAbstractFieldReference;
  
  /// A stack of expression evaluation contexts.
  public SmallVector<ExpressionEvaluationContextRecord> ExprEvalContexts;//PERF:init with null
  
  /// \brief A cache of special member function overload resolution results
  /// for C++ records.
  public FoldingSet<SpecialMemberOverloadResult> SpecialMemberCache;
  
  /// \brief A cache of the flags available in enumerations with the flag_bits
  /// attribute.
  public /*mutable */DenseMap</*const*/ EnumDecl /*P*/ , APInt> FlagBitsCache;
  
  /// \brief The kind of translation unit we are processing.
  ///
  /// When we're processing a complete translation unit, Sema will perform
  /// end-of-translation-unit semantic tasks (such as creating
  /// initializers for tentative definitions in C) once parsing has
  /// completed. Modules and precompiled headers perform different kinds of
  /// checks.
  public TranslationUnitKind TUKind;
  
  public BumpPtrAllocatorImpl BumpAlloc;
  
  /// \brief The number of SFINAE diagnostics that have been trapped.
  public /*uint*/int NumSFINAEErrors;
  
  /*typedef llvm::DenseMap<ParmVarDecl *, llvm::TinyPtrVector<ParmVarDecl *> > UnparsedDefaultArgInstantiationsMap*/
//  public final class UnparsedDefaultArgInstantiationsMap extends DenseMap<ParmVarDecl /*P*/ , TinyPtrVector<ParmVarDecl /*P*/ >>{ };
  
  /// \brief A mapping from parameters with unparsed default arguments to the
  /// set of instantiations of each parameter.
  ///
  /// This mapping is a temporary data structure used when parsing
  /// nested class templates or nested classes of class templates,
  /// where we might end up instantiating an inner class before the
  /// default arguments of its methods have been parsed.
  public DenseMap<ParmVarDecl /*P*/ , TinyPtrVector<ParmVarDecl /*P*/ >> UnparsedDefaultArgInstantiations;
  
  // Contains the locations of the beginning of unparsed default
  // argument locations.
  public DenseMap<ParmVarDecl /*P*/ , SourceLocation> UnparsedDefaultArgLocs;
  
  /// UndefinedInternals - all the used, undefined objects which require a
  /// definition in this translation unit.
  public MapVectorPtrType<NamedDecl /*P*/ , SourceLocation> UndefinedButUsed;
  
  /*typedef std::pair<ObjCMethodList, ObjCMethodList> GlobalMethods*/
//  public final class GlobalMethods extends std.pair<ObjCMethodList, ObjCMethodList>{ };
  /*typedef llvm::DenseMap<Selector, GlobalMethods> GlobalMethodPool*/
//  public final class GlobalMethodPool extends DenseMap<Selector, std.pair<ObjCMethodList, ObjCMethodList>>{ };
  
  /// Method Pool - allows efficient lookup when typechecking messages to "id".
  /// We need to maintain a list, since selectors can have differing signatures
  /// across classes. In Cocoa, this happens to be extremely uncommon (only 1%
  /// of selectors are "overloaded").
  /// At the head of the list it is recorded whether there were 0, 1, or >= 2
  /// methods inside categories with a particular selector.
  public DenseMap<Selector, std.pair<ObjCMethodList, ObjCMethodList>> MethodPool;
  
  /// Method selectors used in a \@selector expression. Used for implementation
  /// of -Wselector.
  public MapVectorTypeType<Selector, SourceLocation> ReferencedSelectors;
  
  /*typedef std::pair<CXXRecordDecl *, CXXSpecialMember> SpecialMemberDecl*/
//  public final class SpecialMemberDecl extends std.pair<CXXRecordDecl /*P*/ , CXXSpecialMember>{ };
  
  /// The C++ special members which we are currently in the process of
  /// declaring. If this process recursively triggers the declaration of the
  /// same special member, we should act as if it is not yet declared.
  public SmallSet<std.pair<CXXRecordDecl /*P*/ , CXXSpecialMember>> SpecialMembersBeingDeclared;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::Sema">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*inited some collections with NULLS and MapVector with default values*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 74,
   FQN="clang::Sema::Sema", NM="_ZN5clang4SemaC1ERNS_12PreprocessorERNS_10ASTContextERNS_11ASTConsumerENS_19TranslationUnitKindEPNS_20CodeCompleteConsumerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4SemaC1ERNS_12PreprocessorERNS_10ASTContextERNS_11ASTConsumerENS_19TranslationUnitKindEPNS_20CodeCompleteConsumerE")
  //</editor-fold>
  public Sema(final Preprocessor /*&*/ pp, final ASTContext /*&*/ ctxt, final ASTConsumer /*&*/ consumer) {
    this(pp, ctxt, consumer, 
      TranslationUnitKind.TU_Complete, 
      (CodeCompleteConsumer /*P*/ )null);
  }
  public Sema(final Preprocessor /*&*/ pp, final ASTContext /*&*/ ctxt, final ASTConsumer /*&*/ consumer, 
      TranslationUnitKind TUKind/*= TU_Complete*/) {
    this(pp, ctxt, consumer, 
      TUKind, 
      (CodeCompleteConsumer /*P*/ )null);
  }
  public Sema(final Preprocessor /*&*/ pp, final ASTContext /*&*/ ctxt, final ASTConsumer /*&*/ consumer, 
      TranslationUnitKind TUKind/*= TU_Complete*/, 
      CodeCompleteConsumer /*P*/ CodeCompleter/*= null*/) {
    // : ExternalSource(null), isMultiplexExternalSource(false), OpenCLFeatures(), FPFeatures(pp.getLangOpts()), LangOpts(pp.getLangOpts()), PP(pp), Context(ctxt), Consumer(consumer), Diags(PP.getDiagnostics()), SourceMgr(PP.getSourceManager()), CollectStats(false), CodeCompleter(CodeCompleter), CurContext(null), OriginalLexicalContext(null), VAListTagName(), MSStructPragmaOn(false), MSPointerToMemberRepresentationMethod(LangOpts.getMSPointerToMemberRepresentationMethod()), CurrentSEHFinally(), ImplicitMSInheritanceAttrLoc(), VtorDispStack(MSVtorDispAttr::Mode(LangOpts.VtorDispMode)), PackStack(0), DataSegStack(null), BSSSegStack(null), ConstSegStack(null), CodeSegStack(null), NullabilityMap(), CurInitSeg(null), CurInitSegLoc(), VisContext(null), OptimizeOffPragmaLocation(), IsBuildingRecoveryCallExpr(false), Cleanup(), ExprCleanupObjects(), MaybeODRUseExprs(), FunctionScopes(), ExtVectorDecls(), FieldCollector(), UnusedPrivateFields(), UnusedLocalTypedefNameCandidates(), DeleteExprs(), PureVirtualClassDiagSet(), ParsingInitForAutoVars(), TentativeDefinitions(), UnusedFileScopedDecls(), DelegatingCtorDecls(), DelayedExceptionSpecChecks(), DelayedDefaultedMemberExceptionSpecs(), LateParsedTemplateMap(), LateTemplateParser(null), LateTemplateParserCleanup(null), OpaqueParser(null), DelayedDiagnostics(), WeakUndeclaredIdentifiers(), ExtnameUndeclaredIdentifiers(), WeakTopLevelDecl(), IdResolver(pp), StdNamespace(), StdBadAlloc(), StdInitializerList(null), CXXTypeInfoDecl(null), MSVCGuidDecl(null), NSAPIObj(), NSNumberDecl(null), NSValueDecl(null), NSNumberPointer(), NSValuePointer(), NSStringDecl(null), NSStringPointer(), StringWithUTF8StringMethod(null), ValueWithBytesObjCTypeMethod(null), NSArrayDecl(null), ArrayWithObjectsMethod(null), NSDictionaryDecl(null), DictionaryWithObjectsMethod(null), QIDNSCopying(), RespondsToSelectorSel(), MSAsmLabelNameCounter(0), GlobalNewDeleteDeclared(false), ExprEvalContexts(), SpecialMemberCache(), FlagBitsCache(), TUKind(TUKind), BumpAlloc(), NumSFINAEErrors(0), UnparsedDefaultArgInstantiations(), UnparsedDefaultArgLocs(), UndefinedButUsed(), MethodPool(), ReferencedSelectors(), SpecialMembersBeingDeclared(), VisibleModules(), VisibleModulesStack(), CachedFakeTopLevelModule(null), DeclsInPrototypeScope(), ShadowingDecls(), DelayedTypos(), KnownNamespaces(), CXXThisTypeOverride(), VTableUses(), VTablesUsed(), AccessCheckingSFINAE(false), ActiveTemplateInstantiations(), ActiveTemplateInstantiationLookupModules(), LookupModulesCache(), VisibleNamespaceCache(), InNonInstantiationSFINAEContext(false), NonInstantiationEntries(0), LastTemplateInstantiationErrorContext(), ArgumentPackSubstitutionIndex(-1), SuppressedDiagnostics(), CurrentInstantiationScope(null), DisableTypoCorrection(false), TyposCorrected(0), TypoCorrectionFailures(), AnalysisWarnings(*this), ThreadSafetyDeclCache(null), PendingInstantiations(), PendingLocalImplicitInstantiations(), VarDataSharingAttributesStack(null), IsInOpenMPDeclareTargetContext(false), TypeTagForDatatypeMagicValues(), CurScope(null), Ident_super(null), Ident___float128(null), Ident__Nonnull(null), Ident__Nullable(null), Ident__Null_unspecified(null), Ident_NSError(null), CFError(null), DelayedDllExportClasses() 
    //START JInit
    this.ExternalSource = null;
    this.isMultiplexExternalSource = false;
    this.OpenCLFeatures = new OpenCLOptions();
    this.FPFeatures = new FPOptions(pp.getLangOpts());
    this./*&*/LangOpts=/*&*/pp.getLangOpts();
    this./*&*/PP=/*&*/pp;
    this./*&*/Context=/*&*/ctxt;
    this./*&*/Consumer=/*&*/consumer;
    this./*&*/Diags=/*&*/PP.getDiagnostics();
    this./*&*/SourceMgr=/*&*/PP.getSourceManager();
    this.CollectStats = false;
    this.CodeCompleter = CodeCompleter;
    this.CurContext = null;
    this.OriginalLexicalContext = null;
    this.VAListTagName = new DeclarationName();
    this.MSStructPragmaOn = false;
    this.MSPointerToMemberRepresentationMethod = LangOpts.getMSPointerToMemberRepresentationMethod();
    this.CurrentSEHFinally = new SmallVector<Scope /*P*/ >(2, (Scope /*P*/ )null);
    this.ImplicitMSInheritanceAttrLoc = new SourceLocation();
    this.VtorDispStack = new PragmaStack<MSVtorDispAttr.Mode>(MSVtorDispAttr.Mode.valueOf(LangOpts.VtorDispMode));
    this.PackStack = new PragmaStackUInt(0);
    this.DataSegStack = new PragmaStack<StringLiteral /*P*/ >((StringLiteral /*P*/ /*const*/)null);
    this.BSSSegStack = new PragmaStack<StringLiteral /*P*/ >((StringLiteral /*P*/ /*const*/)null);
    this.ConstSegStack = new PragmaStack<StringLiteral /*P*/ >((StringLiteral /*P*/ /*const*/)null);
    this.CodeSegStack = new PragmaStack<StringLiteral /*P*/ >((StringLiteral /*P*/ /*const*/)null);
    this.NullabilityMap = new FileNullabilityMap();
    this.CurInitSeg = null;
    this.CurInitSegLoc = new SourceLocation();
    this.VisContext = null;
    this.OptimizeOffPragmaLocation = new SourceLocation();
    this.IsBuildingRecoveryCallExpr = false;
    this.Cleanup = /*{ */new CleanupInfo()/* }*/;
    this.ExprCleanupObjects = new SmallVector<BlockDecl /*P*/ >(8, (BlockDecl /*P*/ )null);
    this.MaybeODRUseExprs = new SmallPtrSet<Expr /*P*/ >(DenseMapInfo$LikePtr.$Info(), 2);
    this.FunctionScopes = new SmallVector<FunctionScopeInfo /*P*/ >(4, (FunctionScopeInfo /*P*/ )null);
    this.ExtVectorDecls = new ExtVectorDeclsType();
    this.FieldCollector = new std.unique_ptr<CXXFieldCollector>();
    this.UnusedPrivateFields = new SmallSetVector</*const*/ NamedDecl /*P*/ >(16, (/*const*/ NamedDecl /*P*/ ) null);
    this.UnusedLocalTypedefNameCandidates = new SmallSetVector</*const*/ TypedefNameDecl /*P*/>(4, (/*const*/ TypedefNameDecl)null);
    this.DeleteExprs = new MapVectorPtrType<FieldDecl /*P*/ , SmallVector<std.pairTypeBool<SourceLocation>> >(DenseMapInfo$LikePtr.$Info(), new SmallVector<std.pairTypeBool<SourceLocation>>(0, new std.pairTypeBool(new SourceLocation(), false)));
    this.PureVirtualClassDiagSet = new std.unique_ptr<SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > >();
    this.ParsingInitForAutoVars = new SmallPtrSet</*const*/ Decl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    this.TentativeDefinitions = new TentativeDefinitionsType();
    this.UnusedFileScopedDecls = new UnusedFileScopedDeclsType();
    this.DelegatingCtorDecls = new DelegatingCtorDeclsType();
    this.DelayedExceptionSpecChecks = new SmallVector<std.pair</*const*/ CXXMethodDecl /*P*/ , /*const*/ CXXMethodDecl /*P*/ >>(2, new std.pairPtrPtr</*const*/ CXXMethodDecl /*P*/ , /*const*/ CXXMethodDecl /*P*/ >());
    this.DelayedDefaultedMemberExceptionSpecs = new SmallVector<std.pair<CXXMethodDecl /*P*/ , /*const*/ FunctionProtoType /*P*/ >>(2, new std.pairPtrPtr<CXXMethodDecl /*P*/ , /*const*/ FunctionProtoType /*P*/ >());
    this.LateParsedTemplateMap = new MapVectorPtrPtr</*const*/ FunctionDecl /*P*/ , LateParsedTemplate /*P*/ >(DenseMapInfo$LikePtr.$Info(), (LateParsedTemplate/*P*/)null);
    this.LateTemplateParser = null;
    this.LateTemplateParserCleanup = null;
    this.OpaqueParser = null;
    this.DelayedDiagnostics = new  DelayedDiagnostics();
    this.WeakUndeclaredIdentifiers = new MapVectorPtrType<IdentifierInfo /*P*/ , WeakInfo>(IdentifierInfo.DMI$IdentifierInfoPtr, new WeakInfo());
    this.ExtnameUndeclaredIdentifiers = new DenseMap<IdentifierInfo /*P*/ , AsmLabelAttr /*P*/ >(DenseMapInfo$LikePtr.$Info(), (AsmLabelAttr /*P*/ )null);
    this.WeakTopLevelDecl = new SmallVector<Decl /*P*/>(2, null);
    this.IdResolver = new IdentifierResolver(pp);
    this.StdNamespace = new LazyDeclPtr();
    this.StdBadAlloc = new LazyDeclPtr();
    this.StdInitializerList = null;
    this.CXXTypeInfoDecl = null;
    this.MSVCGuidDecl = null;
    this.NSAPIObj = new std.unique_ptr<NSAPI>();
    this.NSNumberDecl = null;
    this.NSValueDecl = null;
    this.NSNumberPointer = new QualType();
    this.NSValuePointer = new QualType();
    this.NSStringDecl = null;
    this.NSStringPointer = new QualType();
    this.StringWithUTF8StringMethod = null;
    this.ValueWithBytesObjCTypeMethod = null;
    this.NSArrayDecl = null;
    this.ArrayWithObjectsMethod = null;
    this.NSDictionaryDecl = null;
    this.DictionaryWithObjectsMethod = null;
    this.QIDNSCopying = new QualType();
    this.RespondsToSelectorSel = new Selector();
    this.MSAsmLabelNameCounter = 0;
    this.GlobalNewDeleteDeclared = false;
    this.ExprEvalContexts = new SmallVector<ExpressionEvaluationContextRecord>(8, /*PERF: ExpressionEvaluationContextRecord*/null);
    this.SpecialMemberCache = new FoldingSet<SpecialMemberOverloadResult>(SpecialMemberOverloadResult.TRAIT);
    this.FlagBitsCache = new DenseMap</*const*/ EnumDecl /*P*/ , APInt>(DenseMapInfo$LikePtr.$Info(), new APInt());
    this.TUKind = TUKind;
    this.BumpAlloc = new BumpPtrAllocatorImpl();
    this.NumSFINAEErrors = 0;
    this.UnparsedDefaultArgInstantiations = new DenseMap<ParmVarDecl /*P*/ , TinyPtrVector<ParmVarDecl /*P*/ >>(DenseMapInfo$LikePtr.$Info(), new TinyPtrVector<ParmVarDecl /*P*/ >());
    this.UnparsedDefaultArgLocs = new DenseMap<ParmVarDecl /*P*/ , SourceLocation>(DenseMapInfo$LikePtr.$Info(), new SourceLocation());
    this.UndefinedButUsed = new MapVectorPtrType<NamedDecl /*P*/ , SourceLocation>(DenseMapInfo$LikePtr.$Info(), new SourceLocation());
    this.MethodPool = new DenseMap<Selector, std.pair<ObjCMethodList, ObjCMethodList>>(DenseMapInfoSelector.$Info(), new std.pairTypeType<ObjCMethodList, ObjCMethodList>(new ObjCMethodList(), new ObjCMethodList()));
    this.ReferencedSelectors = new MapVectorTypeType<Selector, SourceLocation>(DenseMapInfoSelector.$Info(), new SourceLocation());
    this.SpecialMembersBeingDeclared = new SmallSet<std.pair<CXXRecordDecl /*P*/ , CXXSpecialMember>>(4, 
                                            new std.pairPtrType((CXXSpecialMember/*P*/)null, CXXSpecialMember.valueOf(0)),
                                            SpecialMembersBeingDeclared$Comparator);
    this.VisibleModules = new VisibleModuleSet();
    this.VisibleModulesStack = new SmallVector<VisibleModuleSet>(16, new VisibleModuleSet());
    this.CachedFakeTopLevelModule = null;
    this.DeclsInPrototypeScope = new std.vector<NamedDecl /*P*/ >((NamedDecl /*P*/ )null);
    this.ShadowingDecls = new DenseMap</*const*/ NamedDecl /*P*/ , /*const*/ NamedDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ NamedDecl /*P*/ )null);
    this.DelayedTypos = new MapVectorPtrType<TypoExpr /*P*/ , TypoExprState>(DenseMapInfo$LikePtr.$Info(), new TypoExprState());
    this.KnownNamespaces = new MapVectorPtrBool<NamespaceDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), false);
    this.CXXThisTypeOverride = new QualType();
    this.VTableUses = new SmallVector<std.pair<CXXRecordDecl /*P*/ , SourceLocation>>(16, new std.pairPtrType<CXXRecordDecl /*P*/ , SourceLocation>(null, new SourceLocation()));
    this.VTablesUsed = new DenseMapTypeBool<CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), false);
    this.AccessCheckingSFINAE = false;
    this.ActiveTemplateInstantiations = new SmallVector<ActiveTemplateInstantiation>(16, new ActiveTemplateInstantiation());
    this.ActiveTemplateInstantiationLookupModules = new SmallVector<Module /*P*/>(16, (Module /*P*/)null);
    this.LookupModulesCache = new DenseSet<Module /*P*/ >(DenseMapInfo$LikePtr.$Info());
    this.VisibleNamespaceCache = new DenseMap<NamedDecl /*P*/ , NamedDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (NamedDecl /*P*/ )null);
    this.InNonInstantiationSFINAEContext = false;
    this.NonInstantiationEntries = 0;
    this.LastTemplateInstantiationErrorContext = new ActiveTemplateInstantiation();
    this.ArgumentPackSubstitutionIndex = -1;
    this.SuppressedDiagnostics = new DenseMap<Decl /*P*/ , OptionalNotes>(DenseMapInfo$LikePtr.$Info(), OptionalNotes.DEFAULT);
    this.CurrentInstantiationScope = null;
    this.DisableTypoCorrection = false;
    this.TyposCorrected = 0;
    this.TypoCorrectionFailures = new DenseMap<IdentifierInfo /*P*/ , SmallSet<SourceLocation>>(IdentifierInfo.DMI$IdentifierInfoPtr, /*PERF: new SmallSet<SourceLocation>()*/null);
    this.AnalysisWarnings = new AnalysisBasedWarnings(/*Deref*/this);
    this.ThreadSafetyDeclCache = null;
    this.PendingInstantiations = new std.deque<std.pair<ValueDecl /*P*/ , SourceLocation> >(false);
    this.PendingLocalImplicitInstantiations = new std.deque<std.pair<ValueDecl /*P*/ , SourceLocation> >(false);
    this.VarDataSharingAttributesStack = null;
    /*InClass*/this.IsInOpenMPDeclareTargetContext = false;
    this.TypeTagForDatatypeMagicValues = new std.unique_ptr<DenseMap<std.pairTypeULong</*const*/ IdentifierInfo /*P*/ >, TypeTagData> >();
    this.CurScope = null;
    this.Ident_super = null;
    this.Ident___float128 = null;
    /*InClass*/this.Ident__Nonnull = null;
    /*InClass*/this.Ident__Nullable = null;
    /*InClass*/this.Ident__Null_unspecified = null;
    /*InClass*/this.Ident_NSError = null;
    /*InClass*/this.CFError = null;
    this.DelayedDllExportClasses = new SmallVector<CXXRecordDecl /*P*/ >(4, (CXXRecordDecl /*P*/ )null);
    //END JInit
    TUScope = null;

    LoadedExternalKnownNamespaces = false;
    for (/*uint*/int I = 0; I != NSAPI.NumNSNumberLiteralMethods; ++I)  {
      NSNumberLiteralMethods[I] = null;
    }
    if (getLangOpts().ObjC1) {
      NSAPIObj.reset(new NSAPI(Context));
    }
    if (getLangOpts().CPlusPlus) {
      FieldCollector.reset(new CXXFieldCollector());
    }

    // Tell diagnostics how to render things from the AST library.
    Diags.SetArgToStringFn(AstClangGlobals::/*AddrOf*//*FPtr*/FormatASTNodeDiagnosticArgument, $AddrOf(Context));

    ExprEvalContexts.push_back(/*JAVA*/new ExpressionEvaluationContextRecord(ExpressionEvaluationContext.PotentiallyEvaluated, 0, /*{ */new CleanupInfo()/* }*/, null, 
        false));

    FunctionScopes.push_back(new FunctionScopeInfo(Diags));

    // Initilization of data sharing attributes stack for OpenMP
    InitDataSharingAttributesStack();
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::~Sema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 262,
   FQN="clang::Sema::~Sema", NM="_ZN5clang4SemaD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4SemaD0Ev")
  //</editor-fold>
  public void $destroy() {
    llvm.DeleteContainerSeconds(LateParsedTemplateMap);
    if ((VisContext != null)) {
      FreeVisContext();
    }
    // Kill all the active scopes.
    for (/*uint*/int I = 1, E = FunctionScopes.size(); I != E; ++I)  {
      if (FunctionScopes.$at(I) != null) { FunctionScopes.$at(I).$destroy();};
    }
    if (FunctionScopes.size() == 1) {
      if (FunctionScopes.$at(0) != null) { FunctionScopes.$at(0).$destroy();};
    }
    {

      // Tell the SemaConsumer to forget about us; we're going out of scope.
      SemaConsumer /*P*/ SC = dyn_cast_SemaConsumer($AddrOf(Consumer));
      if ((SC != null)) {
        SC.ForgetSema();
      }
    }
    {

      // Detach from the external Sema source.
      ExternalSemaSource /*P*/ ExternalSema = dyn_cast_or_null_ExternalSemaSource(Context.getExternalSource());
      if ((ExternalSema != null)) {
        ExternalSema.ForgetSema();
      }
    }

    // If Sema's ExternalSource is the multiplexer - we own it.
    if (isMultiplexExternalSource) {
      if (ExternalSource != null) { ExternalSource.$destroy();};
    }

    ThreadSafetyGlobals.threadSafetyCleanup(ThreadSafetyDeclCache);

    // Destroys data sharing attributes stack for OpenMP
    DestroyDataSharingAttributesStack();
    assert (DelayedTypos.empty()) : "Uncorrected typos!";
    //START JDestroy
    DelayedDllExportClasses.$destroy();
    TypeTagForDatatypeMagicValues.$destroy();
    PendingLocalImplicitInstantiations.$destroy();
    PendingInstantiations.$destroy();
    AnalysisWarnings.$destroy();
    TypoCorrectionFailures.$destroy();
    SuppressedDiagnostics.$destroy();
    VisibleNamespaceCache.$destroy();
    LookupModulesCache.$destroy();
    ActiveTemplateInstantiationLookupModules.$destroy();
    ActiveTemplateInstantiations.$destroy();
    VTablesUsed.$destroy();
    VTableUses.$destroy();
    KnownNamespaces.$destroy();
    DelayedTypos.$destroy();
    ShadowingDecls.$destroy();
    DeclsInPrototypeScope.$destroy();
    VisibleModulesStack.$destroy();
    VisibleModules.$destroy();
    SpecialMembersBeingDeclared.$destroy();
    ReferencedSelectors.$destroy();
    MethodPool.$destroy();
    UndefinedButUsed.$destroy();
    UnparsedDefaultArgLocs.$destroy();
    UnparsedDefaultArgInstantiations.$destroy();
    BumpAlloc.$destroy();
    FlagBitsCache.$destroy();
    SpecialMemberCache.$destroy();
    ExprEvalContexts.$destroy();
    NSAPIObj.$destroy();
    IdResolver.$destroy();
    WeakTopLevelDecl.$destroy();
    ExtnameUndeclaredIdentifiers.$destroy();
    WeakUndeclaredIdentifiers.$destroy();
    LateParsedTemplateMap.$destroy();
    DelayedDefaultedMemberExceptionSpecs.$destroy();
    DelayedExceptionSpecChecks.$destroy();
    DelegatingCtorDecls.$destroy();
    UnusedFileScopedDecls.$destroy();
    TentativeDefinitions.$destroy();
    ParsingInitForAutoVars.$destroy();
    PureVirtualClassDiagSet.$destroy();
    DeleteExprs.$destroy();
    UnusedLocalTypedefNameCandidates.$destroy();
    UnusedPrivateFields.$destroy();
    FieldCollector.$destroy();
    ExtVectorDecls.$destroy();
    FunctionScopes.$destroy();
    MaybeODRUseExprs.$destroy();
    ExprCleanupObjects.$destroy();
    NullabilityMap.$destroy();
    CodeSegStack.$destroy();
    ConstSegStack.$destroy();
    BSSSegStack.$destroy();
    DataSegStack.$destroy();
    PackStack.$destroy();
    VtorDispStack.$destroy();
    CurrentSEHFinally.$destroy();
    //END JDestroy
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1062,
   FQN="clang::Sema::getLangOpts", NM="_ZNK5clang4Sema11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema11getLangOptsEv")
  //</editor-fold>
  public final /*const*/ LangOptions /*&*/ getLangOpts() /*const*/ {
    return LangOpts;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getOpenCLOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1063,
   FQN="clang::Sema::getOpenCLOptions", NM="_ZN5clang4Sema16getOpenCLOptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema16getOpenCLOptionsEv")
  //</editor-fold>
  public final OpenCLOptions /*&*/ getOpenCLOptions() {
    return OpenCLFeatures;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getFPOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1064,
   FQN="clang::Sema::getFPOptions", NM="_ZN5clang4Sema12getFPOptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12getFPOptionsEv")
  //</editor-fold>
  public final FPOptions /*&*/ getFPOptions() {
    return FPFeatures;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1066,
   FQN="clang::Sema::getDiagnostics", NM="_ZNK5clang4Sema14getDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema14getDiagnosticsEv")
  //</editor-fold>
  public final DiagnosticsEngine /*&*/ getDiagnostics() /*const*/ {
    return Diags;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1067,
   FQN="clang::Sema::getSourceManager", NM="_ZNK5clang4Sema16getSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema16getSourceManagerEv")
  //</editor-fold>
  public final SourceManager /*&*/ getSourceManager() /*const*/ {
    return SourceMgr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getPreprocessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1068,
   FQN="clang::Sema::getPreprocessor", NM="_ZNK5clang4Sema15getPreprocessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema15getPreprocessorEv")
  //</editor-fold>
  public final Preprocessor /*&*/ getPreprocessor() /*const*/ {
    return PP;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1069,
   FQN="clang::Sema::getASTContext", NM="_ZNK5clang4Sema13getASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema13getASTContextEv")
  //</editor-fold>
  public final ASTContext /*&*/ getASTContext() /*const*/ {
    return Context;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getASTConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1070,
   FQN="clang::Sema::getASTConsumer", NM="_ZNK5clang4Sema14getASTConsumerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema14getASTConsumerEv")
  //</editor-fold>
  public final ASTConsumer /*&*/ getASTConsumer() /*const*/ {
    return Consumer;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getExternalSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1072,
   FQN="clang::Sema::getExternalSource", NM="_ZNK5clang4Sema17getExternalSourceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema17getExternalSourceEv")
  //</editor-fold>
  public final ExternalSemaSource /*P*/ getExternalSource() /*const*/ {
    return ExternalSource;
  }

  
  /// \brief Emit a diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::Diag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1139,
   FQN="clang::Sema::Diag", NM="_ZN5clang4Sema4DiagENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema4DiagENS_14SourceLocationEj")
  //</editor-fold>
  public final SemaDiagnosticBuilder Diag(SourceLocation Loc, /*uint*/int DiagID) {
    DiagnosticBuilder DB = null;
    try {
      DB = Diags.Report(/*NO_COPY*/Loc, DiagID);
      return new SemaDiagnosticBuilder(DB, /*Deref*/this, DiagID);
    } finally {
      if (DB != null) { DB.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getCurFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1188,
   FQN="clang::Sema::getCurFunction", NM="_ZNK5clang4Sema14getCurFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema14getCurFunctionEv")
  //</editor-fold>
  public final FunctionScopeInfo /*P*/ getCurFunction() /*const*/ {
    return FunctionScopes.back$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getEnclosingFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1192,
   FQN="clang::Sema::getEnclosingFunction", NM="_ZNK5clang4Sema20getEnclosingFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema20getEnclosingFunctionEv")
  //</editor-fold>
  public final FunctionScopeInfo /*P*/ getEnclosingFunction() /*const*/ {
    if (FunctionScopes.empty()) {
      return null;
    }

    for (int e = FunctionScopes.size() - 1; e >= 0; --e) {
      if (isa_BlockScopeInfo(FunctionScopes.$at$Const(e))) {
        continue;
      }
      return FunctionScopes.$at$Const(e);
    }
    return null;
  }
  
  /*template <typename ExprT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::recordUseOfEvaluatedWeak">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1205,
   FQN="clang::Sema::recordUseOfEvaluatedWeak", NM="Tpl__ZN5clang4Sema24recordUseOfEvaluatedWeakEPKT_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=Tpl__ZN5clang4Sema24recordUseOfEvaluatedWeakEPKT_b")
  //</editor-fold>
  public final </*typename*/ ExprT extends Expr> void recordUseOfEvaluatedWeak(/*const*/ ExprT /*P*/ E) {
    recordUseOfEvaluatedWeak(E, true);
  }
  public final </*typename*/ ExprT extends Expr> void recordUseOfEvaluatedWeak(/*const*/ ExprT /*P*/ E, boolean IsRead/*= true*/) {
    if (!isUnevaluatedContext()) {
      getCurFunction().recordUseOfWeak$T(E, IsRead);
    }
  }

  
  /// WeakTopLevelDeclDecls - access to \#pragma weak-generated Decls
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::WeakTopLevelDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1230,
   FQN="clang::Sema::WeakTopLevelDecls", NM="_ZN5clang4Sema17WeakTopLevelDeclsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema17WeakTopLevelDeclsEv")
  //</editor-fold>
  public final SmallVectorImpl<Decl /*P*/ > /*&*/ WeakTopLevelDecls() {
    return WeakTopLevelDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getPrintable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1348,
   FQN="clang::Sema::getPrintable", NM="_ZN5clang4Sema12getPrintableEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12getPrintableEi")
  //</editor-fold>
  public static int getPrintable_int(int I) {
    return I;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getPrintable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1349,
   FQN="clang::Sema::getPrintable", NM="_ZN5clang4Sema12getPrintableEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12getPrintableEj")
  //</editor-fold>
  public static /*uint*/int getPrintable_uint(/*uint*/int I) {
    return I;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getPrintable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1350,
   FQN="clang::Sema::getPrintable", NM="_ZN5clang4Sema12getPrintableEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12getPrintableEb")
  //</editor-fold>
  public static boolean getPrintable(boolean B) {
    return B;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getPrintable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1351,
   FQN="clang::Sema::getPrintable", NM="_ZN5clang4Sema12getPrintableEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12getPrintableEPKc")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getPrintable(/*const*/char$ptr/*char P*/ S) {
    return S;
  }
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED)
  public static /*const*/String/*char P*/ getPrintable(/*const*/String/*char P*/ S) {
    return S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getPrintable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1352,
   FQN="clang::Sema::getPrintable", NM="_ZN5clang4Sema12getPrintableEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12getPrintableEN4llvm9StringRefE")
  //</editor-fold>
  public static StringRef getPrintable(StringRef S) {
    return new StringRef(JD$Move.INSTANCE, S);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getPrintable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1353,
   FQN="clang::Sema::getPrintable", NM="_ZN5clang4Sema12getPrintableERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12getPrintableERKSs")
  //</editor-fold>
  public static /*const*/std.string/*&*/ getPrintable(final /*const*/std.string/*&*/ S) {
    return S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getPrintable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1354,
   FQN="clang::Sema::getPrintable", NM="_ZN5clang4Sema12getPrintableEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12getPrintableEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public static /*const*/ IdentifierInfo /*P*/ getPrintable(/*const*/ IdentifierInfo /*P*/ II) {
    return II;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getPrintable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Selector*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1354,
   FQN="clang::Sema::getPrintable", NM="_ZN5clang4Sema12getPrintableEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12getPrintableEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public static /*const*/ DeclarationName /*P*/ getPrintable(/*const*/ Selector /*P*/ Val) {
    return new DeclarationName(new Selector(Val));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getPrintable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1357,
   FQN="clang::Sema::getPrintable", NM="_ZN5clang4Sema12getPrintableENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12getPrintableENS_15DeclarationNameE")
  //</editor-fold>
  public static DeclarationName getPrintable(DeclarationName N) {
    return new DeclarationName(JD$Move.INSTANCE, N);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getPrintable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1358,
   FQN="clang::Sema::getPrintable", NM="_ZN5clang4Sema12getPrintableENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12getPrintableENS_8QualTypeE")
  //</editor-fold>
  public static QualType getPrintable(QualType T) {
    return new QualType(JD$Move.INSTANCE, T);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getPrintable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1359,
   FQN="clang::Sema::getPrintable", NM="_ZN5clang4Sema12getPrintableENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12getPrintableENS_11SourceRangeE")
  //</editor-fold>
  public static SourceRange getPrintable(SourceRange R) {
    return new SourceRange(JD$Move.INSTANCE, R);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getPrintable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1360,
   FQN="clang::Sema::getPrintable", NM="_ZN5clang4Sema12getPrintableENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12getPrintableENS_14SourceLocationE")
  //</editor-fold>
  public static SourceRange getPrintable(SourceLocation L) {
    return new SourceRange(/*NO_COPY*/L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getPrintable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1361,
   FQN="clang::Sema::getPrintable", NM="_ZN5clang4Sema12getPrintableEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12getPrintableEPKNS_4ExprE")
  //</editor-fold>
  public static SourceRange getPrintable(/*const*/ Expr /*P*/ E) {
    return E.getSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getPrintable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1362,
   FQN="clang::Sema::getPrintable", NM="_ZN5clang4Sema12getPrintableENS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12getPrintableENS_7TypeLocE")
  //</editor-fold>
  public static SourceRange getPrintable(TypeLoc TL) {
    return TL.getSourceRange();
  }

  
  protected/*private*/ VisibleModuleSet VisibleModules;
  protected/*private*/ SmallVector<VisibleModuleSet> VisibleModulesStack;
  
  protected/*private*/ Module /*P*/ CachedFakeTopLevelModule;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::isModuleVisible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1406,
   FQN="clang::Sema::isModuleVisible", NM="_ZN5clang4Sema15isModuleVisibleEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema15isModuleVisibleEPNS_6ModuleE")
  //</editor-fold>
  public final boolean isModuleVisible(Module /*P*/ M) {
    return VisibleModules.isVisible(M);
  }

  
  /// Determine whether a declaration is visible to name lookup.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::isVisible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1409,
   FQN="clang::Sema::isVisible", NM="_ZN5clang4Sema9isVisibleEPKNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema9isVisibleEPKNS_9NamedDeclE")
  //</editor-fold>
  public final boolean isVisible(/*const*/ NamedDecl /*P*/ D) {
    return !D.isHidden() || isVisibleSlow(D);
  }

  
  /// Determine whether any declaration of an entity is visible.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::hasVisibleDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1414,
   FQN="clang::Sema::hasVisibleDeclaration", NM="_ZN5clang4Sema21hasVisibleDeclarationEPKNS_9NamedDeclEPN4llvm15SmallVectorImplIPNS_6ModuleEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema21hasVisibleDeclarationEPKNS_9NamedDeclEPN4llvm15SmallVectorImplIPNS_6ModuleEEE")
  //</editor-fold>
  public final boolean hasVisibleDeclaration(/*const*/ NamedDecl /*P*/ D) {
    return hasVisibleDeclaration(D, 
                       (SmallVectorImpl<Module /*P*/ > /*P*/ )null);
  }
  public final boolean hasVisibleDeclaration(/*const*/ NamedDecl /*P*/ D, 
                       SmallVectorImpl<Module /*P*/ > /*P*/ Modules/*= null*/) {
    return isVisible(D) || hasVisibleDeclarationSlow(D, Modules);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::hasVisibleDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1428,
   FQN="clang::Sema::hasVisibleDefinition", NM="_ZN5clang4Sema20hasVisibleDefinitionEPKNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema20hasVisibleDefinitionEPKNS_9NamedDeclE")
  //</editor-fold>
  public final boolean hasVisibleDefinition(/*const*/ NamedDecl /*P*/ D) {
    type$ptr<NamedDecl /*P*/ > Hidden = create_type$null$ptr();
    return hasVisibleDefinition(((/*const_cast*/NamedDecl /*P*/ )(D)), $AddrOf(Hidden));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::isCompleteType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1452,
   FQN="clang::Sema::isCompleteType", NM="_ZN5clang4Sema14isCompleteTypeENS_14SourceLocationENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema14isCompleteTypeENS_14SourceLocationENS_8QualTypeE")
  //</editor-fold>
  public final boolean isCompleteType(SourceLocation Loc, QualType T) {
    return !RequireCompleteTypeImpl(new SourceLocation(Loc), new QualType(T), (TypeDiagnoser /*P*/ )null);
  }

  
  /*template <typename ... Ts> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::RequireCompleteType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1461,
   FQN="clang::Sema::RequireCompleteType", NM="Tpl__ZN5clang4Sema19RequireCompleteTypeENS_14SourceLocationENS_8QualTypeEjDpRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=Tpl__ZN5clang4Sema19RequireCompleteTypeENS_14SourceLocationENS_8QualTypeEjDpRKT_")
  //</editor-fold>
  public final /*<typename ... Ts>*/ boolean RequireCompleteType$T(SourceLocation Loc, QualType T, /*uint*/int DiagID, 
                       /*const Ts*/ Object... /*&*/ Args) {
    BoundTypeDiagnoser/*<Ts...>*/ Diagnoser/*J*/= /*ParenList*/new BoundTypeDiagnoser/*<Ts...>*/(DiagID, Args/*...*/);
    return RequireCompleteType(Loc, T, Diagnoser);
  }

  
  /*template <typename ... Ts> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::RequireCompleteExprType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1472,
   FQN="clang::Sema::RequireCompleteExprType", NM="Tpl__ZN5clang4Sema23RequireCompleteExprTypeEPNS_4ExprEjDpRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=Tpl__ZN5clang4Sema23RequireCompleteExprTypeEPNS_4ExprEjDpRKT_")
  //</editor-fold>
  public final /*<typename ... Ts>*/ boolean RequireCompleteExprType$T(Expr /*P*/ E, /*uint*/int DiagID, /*const Ts*/ Object... /*&*/ Args) {
    BoundTypeDiagnoser/*<Ts...>*/ Diagnoser/*J*/= /*ParenList*/new BoundTypeDiagnoser/*<Ts...>*/(DiagID, Args/*...*/);
    return RequireCompleteExprType(E, Diagnoser);
  }

  
  /*template <typename ... Ts> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::RequireLiteralType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1482,
   FQN="clang::Sema::RequireLiteralType", NM="Tpl__ZN5clang4Sema18RequireLiteralTypeENS_14SourceLocationENS_8QualTypeEjDpRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=Tpl__ZN5clang4Sema18RequireLiteralTypeENS_14SourceLocationENS_8QualTypeEjDpRKT_")
  //</editor-fold>
  public final /*<typename ... Ts>*/ boolean RequireLiteralType$T(SourceLocation Loc, QualType T, /*uint*/int DiagID, 
                      /*const Ts &*/ Object...  Args) {
    BoundTypeDiagnoser/*<Ts...>*/ Diagnoser/*J*/= /*ParenList*/new BoundTypeDiagnoser/*<Ts...>*/(DiagID, Args/*...*/);
    return RequireLiteralType(Loc, T, Diagnoser);
  }

  
  /// List of decls defined in a function prototype. This contains EnumConstants
  /// that incorrectly end up in translation unit scope because there is no
  /// function to pin them on. ActOnFunctionDeclarator reads this list and patches
  /// them into the FunctionDecl.
  public std.vector<NamedDecl /*P*/ > DeclsInPrototypeScope;
  /// Map of current shadowing declarations to shadowed declarations. Warn if
  /// it looks like the user is trying to modify the shadowing declaration.
  protected/*private*/ DenseMap</*const*/ NamedDecl /*P*/ , /*const*/ NamedDecl /*P*/ > ShadowingDecls;
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::isObjCMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1796,
   FQN="clang::Sema::isObjCMethodDecl", NM="_ZN5clang4Sema16isObjCMethodDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema16isObjCMethodDeclEPNS_4DeclE")
  //</editor-fold>
  public final boolean isObjCMethodDecl(Decl /*P*/ D) {
    return (D != null) && isa_ObjCMethodDecl(D);
  }

  
  /// \brief Retrieve a suitable printing policy.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getPrintingPolicy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 1912,
   FQN="clang::Sema::getPrintingPolicy", NM="_ZNK5clang4Sema17getPrintingPolicyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema17getPrintingPolicyEv")
  //</editor-fold>
  public final PrintingPolicy getPrintingPolicy() /*const*/ {
    return getPrintingPolicy(Context, PP);
  }

  
  /*typedef void *SkippedDefinitionContext*/;
  
  // Members have to be NamespaceDecl* or TranslationUnitDecl*.
  // TODO: make this is a typesafe union.
  /*typedef llvm::SmallSetVector<DeclContext *, 16> AssociatedNamespaceSet*/
//  public final class AssociatedNamespaceSet extends SmallSetVector<DeclContext /*P*/ >{ };
  /*typedef llvm::SmallSetVector<CXXRecordDecl *, 16> AssociatedClassSet*/
//  public final class AssociatedClassSet extends SmallSetVector<CXXRecordDecl /*P*/ >{ };
  
  /*typedef std::function<void (const TypoCorrection &)> TypoDiagnosticGenerator*/
//  public final class TypoDiagnosticGenerator extends TypoDiagnosticGenerator{ };
  /*typedef std::function<ExprResult (Sema &, TypoExpr *, TypoCorrection)> TypoRecoveryCallback*/
//  public final class TypoRecoveryCallback extends TypoRecoveryCallback{ };
  
  /// \brief The set of unhandled TypoExprs and their associated state.
  protected/*private*/ MapVectorPtrType<TypoExpr /*P*/ , TypoExprState> DelayedTypos;
  
  // \brief The set of known/encountered (unique, canonicalized) NamespaceDecls.
  //
  // The boolean value will be true to indicate that the namespace was loaded
  // from an AST/PCH file, or false otherwise.
  /*friend*/public/*private*/ MapVectorPtrBool<NamespaceDecl /*P*/ > KnownNamespaces;
  
  /// \brief Whether we have already loaded known namespaces from an extenal
  /// source.
  protected/*private*/ boolean LoadedExternalKnownNamespaces;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::CorrectDelayedTyposInExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2947,
   FQN="clang::Sema::CorrectDelayedTyposInExpr", NM="_ZN5clang4Sema25CorrectDelayedTyposInExprEPNS_4ExprEN4llvm12function_refIFNS_12ActionResultIS2_Lb1EEES2_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema25CorrectDelayedTyposInExprEPNS_4ExprEN4llvm12function_refIFNS_12ActionResultIS2_Lb1EEES2_EEE")
  //</editor-fold>
  public final ActionResultTTrue<Expr /*P*/ > CorrectDelayedTyposInExpr(Expr /*P*/ E, 
                           Expr2ExprResult Filter) {
    return CorrectDelayedTyposInExpr(E, (VarDecl /*P*/ )null, /*FuncArg*/Filter);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::CorrectDelayedTyposInExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2953,
   FQN="clang::Sema::CorrectDelayedTyposInExpr", NM="_ZN5clang4Sema25CorrectDelayedTyposInExprENS_12ActionResultIPNS_4ExprELb1EEEPNS_7VarDeclEN4llvm12function_refIFS4_S3_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema25CorrectDelayedTyposInExprENS_12ActionResultIPNS_4ExprELb1EEEPNS_7VarDeclEN4llvm12function_refIFS4_S3_EEE")
  //</editor-fold>
  public final ActionResultTTrue<Expr /*P*/ > CorrectDelayedTyposInExpr(ActionResultTTrue<Expr /*P*/ > ER) {
    return CorrectDelayedTyposInExpr(ER, (VarDecl /*P*/ )null, 
                           /*FuncArg*//*[]*/ (Expr /*P*/ E) -> {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
      });
  }
  public final ActionResultTTrue<Expr /*P*/ > CorrectDelayedTyposInExpr(ActionResultTTrue<Expr /*P*/ > ER, VarDecl /*P*/ InitDecl/*= null*/) {
    return CorrectDelayedTyposInExpr(ER, InitDecl, 
                           /*FuncArg*//*[]*/ (Expr /*P*/ E) -> {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
      });
  }
  public final ActionResultTTrue<Expr /*P*/ > CorrectDelayedTyposInExpr(ActionResultTTrue<Expr /*P*/ > ER, VarDecl /*P*/ InitDecl/*= null*/, 
                           Expr2ExprResult Filter/*= FuncArg[] (Expr * E) -> ExprResult{
      return E;
    }*/) {
    return ER.isInvalid() ? new ActionResultTTrue<Expr /*P*/ >(ER) : CorrectDelayedTyposInExpr(ER.get(), /*FuncArg*/Filter);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::CorrectDelayedTyposInExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 2960,
   FQN="clang::Sema::CorrectDelayedTyposInExpr", NM="_ZN5clang4Sema25CorrectDelayedTyposInExprENS_12ActionResultIPNS_4ExprELb1EEEN4llvm12function_refIFS4_S3_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema25CorrectDelayedTyposInExprENS_12ActionResultIPNS_4ExprELb1EEEN4llvm12function_refIFS4_S3_EEE")
  //</editor-fold>
  public final ActionResultTTrue<Expr /*P*/ > CorrectDelayedTyposInExpr(ActionResultTTrue<Expr /*P*/ > ER, 
                           Expr2ExprResult Filter) {
    return CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(ER), (VarDecl /*P*/ )null, /*FuncArg*/Filter);
  }

  
  /*typedef llvm::SmallPtrSet<Selector, 8> SelectorSet*/
//  public final class SelectorSet extends SmallPtrSet<Selector>{ };
  /*typedef llvm::DenseMap<Selector, ObjCMethodDecl *> ProtocolsMethodsMap*/
//  public final class ProtocolsMethodsMap extends DenseMap<Selector, ObjCMethodDecl /*P*/ >{ };
  
  /// \brief Record the typo correction failure and return an empty correction.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::FailedCorrection">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*init value if absent*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3248,
   FQN="clang::Sema::FailedCorrection", NM="_ZN5clang4Sema16FailedCorrectionEPNS_14IdentifierInfoENS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema16FailedCorrectionEPNS_14IdentifierInfoENS_14SourceLocationEb")
  //</editor-fold>
  protected/*private*/ final TypoCorrection FailedCorrection(IdentifierInfo /*P*/ Typo, SourceLocation TypoLoc) {
    return FailedCorrection(Typo, TypoLoc, 
                  true);
  }
  protected/*private*/ final TypoCorrection FailedCorrection(IdentifierInfo /*P*/ Typo, SourceLocation TypoLoc, 
                  boolean RecordFailure/*= true*/) {
    if (RecordFailure) {
      // due to init with null vs SmallSet<SourceLocation> we need to create it here
      type$ref<SmallSet<SourceLocation>> ref$at = TypoCorrectionFailures.ref$at(Typo);
      SmallSet<SourceLocation> set = ref$at.$deref();
      if (set == null) {
        ref$at.$set(set = new SmallSet<SourceLocation>(2, SourceLocation.DEFAULT, SourceLocation.COMPARATOR));
      }
      set.insert(TypoLoc);
    }
    return new TypoCorrection();
  }

  /// AddInstanceMethodToGlobalPool - All instance methods in a translation
  /// unit are added to a global pool. This allows us to efficiently associate
  /// a selector with a method declaraation for purposes of typechecking
  /// messages sent to "id" (where the class of the object is unknown).
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::AddInstanceMethodToGlobalPool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3260,
   FQN="clang::Sema::AddInstanceMethodToGlobalPool", NM="_ZN5clang4Sema29AddInstanceMethodToGlobalPoolEPNS_14ObjCMethodDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema29AddInstanceMethodToGlobalPoolEPNS_14ObjCMethodDeclEb")
  //</editor-fold>
  public final void AddInstanceMethodToGlobalPool(ObjCMethodDecl /*P*/ Method) {
    AddInstanceMethodToGlobalPool(Method, false);
  }
  public final void AddInstanceMethodToGlobalPool(ObjCMethodDecl /*P*/ Method, boolean impl/*= false*/) {
    AddMethodToGlobalPool(Method, impl, /*instance*/ true);
  }

  
  /// AddFactoryMethodToGlobalPool - Same as above, but for factory methods.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::AddFactoryMethodToGlobalPool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3265,
   FQN="clang::Sema::AddFactoryMethodToGlobalPool", NM="_ZN5clang4Sema28AddFactoryMethodToGlobalPoolEPNS_14ObjCMethodDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema28AddFactoryMethodToGlobalPoolEPNS_14ObjCMethodDeclEb")
  //</editor-fold>
  public final void AddFactoryMethodToGlobalPool(ObjCMethodDecl /*P*/ Method) {
    AddFactoryMethodToGlobalPool(Method, false);
  }
  public final void AddFactoryMethodToGlobalPool(ObjCMethodDecl /*P*/ Method, boolean impl/*= false*/) {
    AddMethodToGlobalPool(Method, impl, /*instance*/ false);
  }

  
  /// LookupInstanceMethodInGlobalPool - Returns the method and warns if
  /// there are multiple signatures.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupInstanceMethodInGlobalPool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3275,
   FQN="clang::Sema::LookupInstanceMethodInGlobalPool", NM="_ZN5clang4Sema32LookupInstanceMethodInGlobalPoolENS_8SelectorENS_11SourceRangeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema32LookupInstanceMethodInGlobalPoolENS_8SelectorENS_11SourceRangeEb")
  //</editor-fold>
  public final ObjCMethodDecl /*P*/ LookupInstanceMethodInGlobalPool(Selector Sel, SourceRange R) {
    return LookupInstanceMethodInGlobalPool(Sel, R, 
                                  false);
  }
  public final ObjCMethodDecl /*P*/ LookupInstanceMethodInGlobalPool(Selector Sel, SourceRange R, 
                                  boolean receiverIdOrClass/*= false*/) {
    return LookupMethodInGlobalPool(new Selector(Sel), new SourceRange(R), receiverIdOrClass, 
        /*instance*/ true);
  }

  
  /// LookupFactoryMethodInGlobalPool - Returns the method and warns if
  /// there are multiple signatures.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupFactoryMethodInGlobalPool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3283,
   FQN="clang::Sema::LookupFactoryMethodInGlobalPool", NM="_ZN5clang4Sema31LookupFactoryMethodInGlobalPoolENS_8SelectorENS_11SourceRangeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema31LookupFactoryMethodInGlobalPoolENS_8SelectorENS_11SourceRangeEb")
  //</editor-fold>
  public final ObjCMethodDecl /*P*/ LookupFactoryMethodInGlobalPool(Selector Sel, SourceRange R) {
    return LookupFactoryMethodInGlobalPool(Sel, R, 
                                 false);
  }
  public final ObjCMethodDecl /*P*/ LookupFactoryMethodInGlobalPool(Selector Sel, SourceRange R, 
                                 boolean receiverIdOrClass/*= false*/) {
    return LookupMethodInGlobalPool(new Selector(Sel), new SourceRange(R), receiverIdOrClass, 
        /*instance*/ false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::MakeFullExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3328,
   FQN="clang::Sema::MakeFullExpr", NM="_ZN5clang4Sema12MakeFullExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12MakeFullExprEPNS_4ExprE")
  //</editor-fold>
  public final FullExprArg MakeFullExpr(Expr /*P*/ Arg) {
    return MakeFullExpr(Arg, (Arg != null) ? Arg.getExprLoc() : new SourceLocation());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::MakeFullExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3331,
   FQN="clang::Sema::MakeFullExpr", NM="_ZN5clang4Sema12MakeFullExprEPNS_4ExprENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12MakeFullExprEPNS_4ExprENS_14SourceLocationE")
  //</editor-fold>
  public final FullExprArg MakeFullExpr(Expr /*P*/ Arg, SourceLocation CC) {
    return new FullExprArg(ActOnFinishFullExpr(Arg, new SourceLocation(CC)).get());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::MakeFullDiscardedValueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3334,
   FQN="clang::Sema::MakeFullDiscardedValueExpr", NM="_ZN5clang4Sema26MakeFullDiscardedValueExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema26MakeFullDiscardedValueExprEPNS_4ExprE")
  //</editor-fold>
  public final FullExprArg MakeFullDiscardedValueExpr(Expr /*P*/ Arg) {
    ActionResultTTrue<Expr /*P*/ > FE = ActOnFinishFullExpr(Arg, (Arg != null) ? Arg.getExprLoc() : new SourceLocation(), 
        /*DiscardedValue*/ true);
    return new FullExprArg(FE.get());
  }

  /*typedef std::pair<StringRef, QualType> CapturedParamNameType*/
//  public final class CapturedParamNameType extends std.pair<StringRef, QualType>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::PushParsingDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3606,
   FQN="clang::Sema::PushParsingDeclaration", NM="_ZN5clang4Sema22PushParsingDeclarationERNS_4sema21DelayedDiagnosticPoolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema22PushParsingDeclarationERNS_4sema21DelayedDiagnosticPoolE")
  //</editor-fold>
  public final DelayedDiagnosticsState PushParsingDeclaration(final DelayedDiagnosticPool /*&*/ pool) {
    return DelayedDiagnostics.push(pool);
  }

  
  /*typedef ProcessingContextState ParsingClassState*/
//  public final class ParsingClassState extends DelayedDiagnosticsState{ };
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::PushParsingClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3612,
   FQN="clang::Sema::PushParsingClass", NM="_ZN5clang4Sema16PushParsingClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema16PushParsingClassEv")
  //</editor-fold>
  public final DelayedDiagnosticsState PushParsingClass() {
    return DelayedDiagnostics.pushUndelayed();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::PopParsingClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 3615,
   FQN="clang::Sema::PopParsingClass", NM="_ZN5clang4Sema15PopParsingClassENS0_23DelayedDiagnosticsStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema15PopParsingClassENS0_23DelayedDiagnosticsStateE")
  //</editor-fold>
  public final void PopParsingClass(DelayedDiagnosticsState state) {
    DelayedDiagnostics.popUndelayed(new DelayedDiagnosticsState(state));
  }

  
  /// \brief When non-NULL, the C++ 'this' expression is allowed despite the
  /// current context not being a non-static member function. In such cases,
  /// this provides the type used for 'this'.
  public QualType CXXThisTypeOverride;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishFullExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 4903,
   FQN="clang::Sema::ActOnFinishFullExpr", NM="_ZN5clang4Sema19ActOnFinishFullExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema19ActOnFinishFullExprEPNS_4ExprE")
  //</editor-fold>
  public final ActionResultTTrue<Expr /*P*/ > ActOnFinishFullExpr(Expr /*P*/ $Expr) {
    return ActOnFinishFullExpr($Expr, ($Expr != null) ? $Expr.getExprLoc() : new SourceLocation());
  }

  
  /// \brief Perform initialization analysis of the init-capture and perform
  /// any implicit conversions such as an lvalue-to-rvalue conversion if
  /// not being used to initialize a reference.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::actOnLambdaInitCaptureInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 5129,
   FQN="clang::Sema::actOnLambdaInitCaptureInitialization", NM="_ZN5clang4Sema36actOnLambdaInitCaptureInitializationENS_14SourceLocationEbPNS_14IdentifierInfoENS_21LambdaCaptureInitKindERPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema36actOnLambdaInitCaptureInitializationENS_14SourceLocationEbPNS_14IdentifierInfoENS_21LambdaCaptureInitKindERPNS_4ExprE")
  //</editor-fold>
  public final OpaquePtr<QualType> actOnLambdaInitCaptureInitialization(SourceLocation Loc, boolean ByRef, IdentifierInfo /*P*/ Id, 
                                      LambdaCaptureInitKind InitKind, final type$ref<Expr /*P*/ /*&*/> Init) {
    return OpaquePtr.<QualType>make(buildLambdaInitCaptureInitialization(new SourceLocation(Loc), ByRef, Id, InitKind != LambdaCaptureInitKind.CopyInit, Init));
  }

  
  /// \brief The list of classes whose vtables have been used within
  /// this translation unit, and the source locations at which the
  /// first use occurred.
  /*typedef std::pair<CXXRecordDecl *, SourceLocation> VTableUse*/
//  public final class VTableUse extends std.pair<CXXRecordDecl /*P*/ , SourceLocation>{ };
  
  /// \brief The list of vtables that are required but have not yet been
  /// materialized.
  public SmallVector<std.pair<CXXRecordDecl /*P*/ , SourceLocation>> VTableUses;
  
  /// \brief The set of classes whose vtables have been used within
  /// this translation unit, and a bit that will be true if the vtable is
  /// required to be emitted (otherwise, it should be emitted only if needed
  /// by code generation).
  public DenseMapTypeBool<CXXRecordDecl /*P*/ > VTablesUsed;
  
  /// \brief When true, access checking violations are treated as SFINAE
  /// failures rather than hard errors.
  public boolean AccessCheckingSFINAE;
  /*template <typename ... Ts> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::RequireNonAbstractType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 5638,
   FQN="clang::Sema::RequireNonAbstractType", NM="Tpl__ZN5clang4Sema22RequireNonAbstractTypeENS_14SourceLocationENS_8QualTypeEjDpRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=Tpl__ZN5clang4Sema22RequireNonAbstractTypeENS_14SourceLocationENS_8QualTypeEjDpRKT_")
  //</editor-fold>
  public final /*<typename ... Ts>*/ boolean RequireNonAbstractType$T(SourceLocation Loc, QualType T, /*uint*/int DiagID) {
    BoundTypeDiagnoser/*<Ts...>*/ Diagnoser/*J*/= /*ParenList*/new BoundTypeDiagnoser/*<Ts...>*/(DiagID);
    return RequireNonAbstractType(Loc, T, Diagnoser);
  }
  public final /*<typename ... Ts>*/ boolean RequireNonAbstractType$T(SourceLocation Loc, QualType T, /*uint*/int DiagID, 
                          /*const Ts*/ AbstractDiagSelID /*&*/ Args) {
    BoundUIntTypeDiagnoser/*<Ts...>*/ Diagnoser/*J*/= /*ParenList*/new BoundUIntTypeDiagnoser/*<Ts...>*/(DiagID, Args.getValue());
    return RequireNonAbstractType(Loc, T, Diagnoser);
  }
  public final /*<typename ... Ts>*/ boolean RequireNonAbstractType$T(SourceLocation Loc, QualType T, /*uint*/int DiagID, 
                          /*const Ts*/ TypeLoc /*&*/ Args) {
    BoundTypeDiagnoser/*<Ts...>*/ Diagnoser/*J*/= /*ParenList*/new BoundTypeDiagnoser/*<Ts...>*/(DiagID, Args/*...*/);
    return RequireNonAbstractType(Loc, T, Diagnoser);
  }
  public final /*<typename ... Ts>*/ boolean RequireNonAbstractType$T(SourceLocation Loc, QualType T, /*uint*/int DiagID, 
                          /*const Ts*/ Expr /***/ Args) {
    BoundTypeDiagnoser/*<Ts...>*/ Diagnoser/*J*/= /*ParenList*/new BoundTypeDiagnoser/*<Ts...>*/(DiagID, Args/*...*/);
    return RequireNonAbstractType(Loc, T, Diagnoser);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::MarkDeducedTemplateParameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6588,
   FQN="clang::Sema::MarkDeducedTemplateParameters", NM="_ZN5clang4Sema29MarkDeducedTemplateParametersEPKNS_20FunctionTemplateDeclERN4llvm14SmallBitVectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema29MarkDeducedTemplateParametersEPKNS_20FunctionTemplateDeclERN4llvm14SmallBitVectorE")
  //</editor-fold>
  public final void MarkDeducedTemplateParameters(/*const*/ FunctionTemplateDecl /*P*/ FunctionTemplate, 
                               final SmallBitVector /*&*/ Deduced) {
    MarkDeducedTemplateParameters(Context, FunctionTemplate, Deduced);
    /*JAVA:return*/return;
  }

  
  /// \brief List of active template instantiations.
  ///
  /// This vector is treated as a stack. As one template instantiation
  /// requires another template instantiation, additional
  /// instantiations are pushed onto the stack up to a
  /// user-configurable limit LangOptions::InstantiationDepth.
  public SmallVector<ActiveTemplateInstantiation> ActiveTemplateInstantiations;
  
  /// \brief Extra modules inspected when performing a lookup during a template
  /// instantiation. Computed lazily.
  public SmallVector<Module /*P*/> ActiveTemplateInstantiationLookupModules;
  
  /// \brief Cache of additional modules that should be used for name lookup
  /// within the current template instantiation. Computed lazily; use
  /// getLookupModules() to get a complete set.
  public DenseSet<Module /*P*/ > LookupModulesCache;
  
  /// \brief Map from the most recent declaration of a namespace to the most
  /// recent visible declaration of that namespace.
  public DenseMap<NamedDecl /*P*/ , NamedDecl /*P*/ > VisibleNamespaceCache;
  
  /// \brief Whether we are in a SFINAE context that is not associated with
  /// template instantiation.
  ///
  /// This is used when setting up a SFINAE trap (\c see SFINAETrap) outside
  /// of a template instantiation or template argument deduction.
  public boolean InNonInstantiationSFINAEContext;
  
  /// \brief The number of ActiveTemplateInstantiation entries in
  /// \c ActiveTemplateInstantiations that are not actual instantiations and,
  /// therefore, should not be counted as part of the instantiation depth.
  public /*uint*/int NonInstantiationEntries;
  
  /// \brief The last template from which a template instantiation
  /// error or warning was produced.
  ///
  /// This value is used to suppress printing of redundant template
  /// instantiation backtraces when there are multiple errors in the
  /// same instantiation. FIXME: Does this belong in Sema? It's tough
  /// to implement it anywhere else.
  public ActiveTemplateInstantiation LastTemplateInstantiationErrorContext;
  
  /// \brief The current index into pack expansion arguments that will be
  /// used for substitution of parameter packs.
  ///
  /// The pack expansion index will be -1 to indicate that parameter packs
  /// should be instantiated as themselves. Otherwise, the index specifies
  /// which argument within the parameter pack will be used for substitution.
  public int ArgumentPackSubstitutionIndex;
  
  /*friend  class ArgumentPackSubstitutionRAII*/
  
  /// \brief For each declaration that involved template argument deduction, the
  /// set of diagnostics that were suppressed during that template argument
  /// deduction.
  ///
  /// FIXME: Serialize this structure to the AST file.
  /*typedef llvm::DenseMap<Decl *, SmallVector<PartialDiagnosticAt, 1> > SuppressedDiagnosticsMap*/
//  public final class SuppressedDiagnosticsMap extends DenseMap<Decl /*P*/ , SmallVector<std.pair<SourceLocation, PartialDiagnostic>>>{ };
  public DenseMap<Decl /*P*/ , OptionalNotes> SuppressedDiagnostics;
  
  /// \brief Determines whether we are currently in a context that
  /// is not evaluated as per C++ [expr] p5.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::isUnevaluatedContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 6946,
   FQN="clang::Sema::isUnevaluatedContext", NM="_ZNK5clang4Sema20isUnevaluatedContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema20isUnevaluatedContextEv")
  //</editor-fold>
  public final boolean isUnevaluatedContext() /*const*/ {
    assert (!ExprEvalContexts.empty()) : "Must be in an expression evaluation context";
    return ExprEvalContexts.back$Const().isUnevaluated();
  }

  
  /// \brief The current instantiation scope used to store local
  /// variables.
  public LocalInstantiationScope /*P*/ CurrentInstantiationScope;
  
  /// \brief Tracks whether we are in a context where typo correction is
  /// disabled.
  public boolean DisableTypoCorrection;
  
  /// \brief The number of typos corrected by CorrectTypo.
  public /*uint*/int TyposCorrected;
  
  /*typedef llvm::SmallSet<SourceLocation, 2> SrcLocSet*/
//  public final class SrcLocSet extends SmallSet<SourceLocation>{ };
  /*typedef llvm::DenseMap<IdentifierInfo *, SrcLocSet> IdentifierSourceLocations*/
//  public final class IdentifierSourceLocations extends DenseMap<IdentifierInfo /*P*/ , SmallSet<SourceLocation>>{ };
  
  /// \brief A cache containing identifiers for which typo correction failed and
  /// their locations, so that repeated attempts to correct an identifier in a
  /// given location are ignored if typo correction already failed for it.
  public DenseMap<IdentifierInfo /*P*/ , SmallSet<SourceLocation>> TypoCorrectionFailures;//PERF:init with null
  
  /// \brief Worker object for performing CFG-based warnings.
  public AnalysisBasedWarnings AnalysisWarnings;
  public BeforeSet /*P*/ ThreadSafetyDeclCache;
  
  /// \brief An entity for which implicit template instantiation is required.
  ///
  /// The source location associated with the declaration is the first place in
  /// the source code where the declaration was "used". It is not necessarily
  /// the point of instantiation (which will be either before or after the
  /// namespace-scope declaration that triggered this implicit instantiation),
  /// However, it is the location that diagnostics should generally refer to,
  /// because users will need to know what code triggered the instantiation.
  /*typedef std::pair<ValueDecl *, SourceLocation> PendingImplicitInstantiation*/
//  public final class PendingImplicitInstantiation extends std.pair<ValueDecl /*P*/ , SourceLocation>{ };
  
  /// \brief The queue of implicit template instantiations that are required
  /// but have not yet been performed.
  public std.deque<std.pair<ValueDecl /*P*/ , SourceLocation> > PendingInstantiations;
  
  /// \brief The queue of implicit template instantiations that are required
  /// and must be performed within the current local scope.
  ///
  /// This queue is only used for member functions of local classes in
  /// templates, which must be instantiated in the same scope as their
  /// enclosing function, so that they can reference function-local
  /// types, static variables, enumerators, etc.
  public std.deque<std.pair<ValueDecl /*P*/ , SourceLocation> > PendingLocalImplicitInstantiations;
  /*typedef SmallVector<LateInstantiatedAttribute, 16> LateInstantiatedAttrVec*/
//  public final class LateInstantiatedAttrVec extends SmallVector<LateInstantiatedAttribute>{ };
  
  /// \brief Get the location for the currently active "\#pragma clang optimize
  /// off". If this location is invalid, then the state of the pragma is "on".
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getOptimizeOffPragmaLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 7864,
   FQN="clang::Sema::getOptimizeOffPragmaLocation", NM="_ZNK5clang4Sema28getOptimizeOffPragmaLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema28getOptimizeOffPragmaLocationEv")
  //</editor-fold>
  public final SourceLocation getOptimizeOffPragmaLocation() /*const*/ {
    return new SourceLocation(OptimizeOffPragmaLocation);
  }

  
  //===--------------------------------------------------------------------===//
  // OpenMP directives and clauses.
  //
  protected/*private*/ Object/*void P*/ VarDataSharingAttributesStack;
  /// Set to true inside '#pragma omp declare target' region.
  protected/*private*/ boolean IsInOpenMPDeclareTargetContext/* = false*/;
  /// Return true inside OpenMP target region.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::isInOpenMPDeclareTargetContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 8029,
   FQN="clang::Sema::isInOpenMPDeclareTargetContext", NM="_ZNK5clang4Sema30isInOpenMPDeclareTargetContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema30isInOpenMPDeclareTargetContextEv")
  //</editor-fold>
  public final boolean isInOpenMPDeclareTargetContext() /*const*/ {
    return IsInOpenMPDeclareTargetContext;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::FindCompositePointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 8811,
   FQN="clang::Sema::FindCompositePointerType", NM="_ZN5clang4Sema24FindCompositePointerTypeENS_14SourceLocationERNS_12ActionResultIPNS_4ExprELb1EEES6_Pb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema24FindCompositePointerTypeENS_14SourceLocationERNS_12ActionResultIPNS_4ExprELb1EEES6_Pb")
  //</editor-fold>
  public final QualType FindCompositePointerType(SourceLocation Loc, 
                          final ActionResultTTrue<Expr /*P*/ > /*&*/ E1, final ActionResultTTrue<Expr /*P*/ > /*&*/ E2) {
    return FindCompositePointerType(Loc, 
                          E1, E2, 
                          (bool$ptr/*bool P*/ )null);
  }
  public final QualType FindCompositePointerType(SourceLocation Loc, 
                          final ActionResultTTrue<Expr /*P*/ > /*&*/ E1, final ActionResultTTrue<Expr /*P*/ > /*&*/ E2, 
                          bool$ptr/*bool P*/ NonStandardCompositeType/*= null*/) {
    type$ref<Expr /*P*/ > E1Tmp = create_type$ref(E1.get());
    type$ref<Expr /*P*/ > E2Tmp = create_type$ref(E2.get());
    QualType Composite = FindCompositePointerType(new SourceLocation(Loc), E1Tmp, E2Tmp, 
        NonStandardCompositeType);
    E1.$assign(E1Tmp.$deref());
    E2.$assign(E2Tmp.$deref());
    return Composite;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::ConditionError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9007,
   FQN="clang::Sema::ConditionError", NM="_ZN5clang4Sema14ConditionErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema14ConditionErrorEv")
  //</editor-fold>
  public static ConditionResult ConditionError() {
    return new ConditionResult(true);
  }

  
  /// Determines whether Caller may invoke Callee, based on their CUDA
  /// host/device attributes.  Returns true if the call is not allowed.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCUDATarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9132,
   FQN="clang::Sema::CheckCUDATarget", NM="_ZN5clang4Sema15CheckCUDATargetEPKNS_12FunctionDeclES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema15CheckCUDATargetEPKNS_12FunctionDeclES3_")
  //</editor-fold>
  public final boolean CheckCUDATarget(/*const*/ FunctionDecl /*P*/ Caller, /*const*/ FunctionDecl /*P*/ Callee) {
    return IdentifyCUDAPreference(Caller, Callee) == CUDAFunctionPreference.CFP_Never;
  }

  
  /// A pair of ArgumentKind identifier and magic value.  This uniquely
  /// identifies the magic value.
  /*typedef std::pair<const IdentifierInfo *, uint64_t> TypeTagMagicValue*/
//  public final class TypeTagMagicValue extends std.pairTypeULong</*const*/ IdentifierInfo /*P*/ >{ };
  /// \brief A map from magic value to type information.
  protected/*private*/ std.unique_ptr<DenseMap<std.pairTypeULong</*const*/ IdentifierInfo /*P*/ >, TypeTagData> > TypeTagForDatatypeMagicValues;
  
  /// \brief The parser's current scope.
  ///
  /// The parser maintains this state here.
  public/*private*/ Scope /*P*/ CurScope;
  
  protected/*private*/ /*mutable */IdentifierInfo /*P*/ Ident_super;
  protected/*private*/ /*mutable */IdentifierInfo /*P*/ Ident___float128;
  
  /// Nullability type specifiers.
  protected/*private*/ IdentifierInfo /*P*/ Ident__Nonnull/* = null*/;
  protected/*private*/ IdentifierInfo /*P*/ Ident__Nullable/* = null*/;
  protected/*private*/ IdentifierInfo /*P*/ Ident__Null_unspecified/* = null*/;
  
  protected/*private*/ IdentifierInfo /*P*/ Ident_NSError/* = null*/;
  /*friend  class Parser*/
  /*friend  class InitializationSequence*/
  /*friend  class ASTReader*/
  /*friend  class ASTDeclReader*/
  /*friend  class ASTWriter*/
  
  /// The struct behind the CFErrorRef pointer.
  public RecordDecl /*P*/ CFError/* = null*/;
  
  /// \brief Retrieve the parser's current scope.
  ///
  /// This routine must only be used when it is certain that semantic analysis
  /// and the parser are in precisely the same context, which is not the case
  /// when, e.g., we are performing any kind of template instantiation.
  /// Therefore, the only safe places to use this scope are in the parser
  /// itself and in routines directly invoked from the parser and *never* from
  /// template substitution or instantiation.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getCurScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9565,
   FQN="clang::Sema::getCurScope", NM="_ZNK5clang4Sema11getCurScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema11getCurScopeEv")
  //</editor-fold>
  public final Scope /*P*/ getCurScope() /*const*/ {
    return CurScope;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::incrementMSManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9567,
   FQN="clang::Sema::incrementMSManglingNumber", NM="_ZNK5clang4Sema25incrementMSManglingNumberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema25incrementMSManglingNumberEv")
  //</editor-fold>
  public final void incrementMSManglingNumber() /*const*/ {
    CurScope.incrementMSManglingNumber();
    /*JAVA:return*/return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getCurLexicalContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9576,
   FQN="clang::Sema::getCurLexicalContext", NM="_ZNK5clang4Sema20getCurLexicalContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema20getCurLexicalContextEv")
  //</editor-fold>
  public final DeclContext /*P*/ getCurLexicalContext() /*const*/ {
    return (OriginalLexicalContext != null) ? OriginalLexicalContext : CurContext;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::getCurObjCLexicalContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9582,
   FQN="clang::Sema::getCurObjCLexicalContext", NM="_ZNK5clang4Sema24getCurObjCLexicalContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema24getCurObjCLexicalContextEv")
  //</editor-fold>
  public final /*const*/ DeclContext /*P*/ getCurObjCLexicalContext() /*const*/ {
    /*const*/ DeclContext /*P*/ DC = getCurLexicalContext();
    {
      // A category implicitly has the attribute of the interface.
      /*const*/ ObjCCategoryDecl /*P*/ CatD = dyn_cast_ObjCCategoryDecl(DC);
      if ((CatD != null)) {
        DC = CatD.getClassInterface$Const();
      }
    }
    return DC;
  }

  
  /// \brief To be used for checking whether the arguments being passed to
  /// function exceeds the number of parameters expected for it.
  //<editor-fold defaultstate="collapsed" desc="clang::Sema::TooManyArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9592,
   FQN="clang::Sema::TooManyArguments", NM="_ZN5clang4Sema16TooManyArgumentsEjjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema16TooManyArgumentsEjjb")
  //</editor-fold>
  public static boolean TooManyArguments(/*size_t*/int NumParams, /*size_t*/int NumArgs) {
    return TooManyArguments(NumParams, NumArgs, 
                  false);
  }
  public static boolean TooManyArguments(/*size_t*/int NumParams, /*size_t*/int NumArgs, 
                  boolean PartialOverloading/*= false*/) {
    // We check whether we're just after a comma in code-completion.
    if ($greater_uint(NumArgs, 0) && PartialOverloading) {
      return $greater_uint(NumArgs + 1, NumParams); // If so, we view as an extra argument.
    }
    return $greater_uint(NumArgs, NumParams);
  }

  
  // Emitting members of dllexported classes is delayed until the class
  // (including field initializers) is fully parsed.
  public SmallVector<CXXRecordDecl /*P*/ > DelayedDllExportClasses;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public void AddBuiltinCandidate(QualType ResultTy, QualType[] /*P*/ ParamTys, 
                     ArrayRef<Expr /*P*/ > Args, 
                     final OverloadCandidateSet /*&*/ CandidateSet) {
    AddBuiltinCandidate(ResultTy, create_type$ptr(ParamTys), Args, CandidateSet);
  }
  public void AddBuiltinCandidate(QualType ResultTy, QualType[] /*P*/ ParamTys, 
                     ArrayRef<Expr /*P*/ > Args, 
                     final OverloadCandidateSet /*&*/ CandidateSet,
                     boolean IsAssignmentOperator/*= false*/) {
    AddBuiltinCandidate(ResultTy, create_type$ptr(ParamTys), Args, CandidateSet, IsAssignmentOperator);
  }
  public void AddBuiltinCandidate(QualType ResultTy, QualType[] /*P*/ ParamTys, 
                     ArrayRef<Expr /*P*/ > Args, 
                     final OverloadCandidateSet /*&*/ CandidateSet,
                     boolean IsAssignmentOperator/*= false*/, 
         /*uint*/int NumContextualBoolArguments/*= 0*/) {
    AddBuiltinCandidate(ResultTy, create_type$ptr(ParamTys), Args, CandidateSet, IsAssignmentOperator, NumContextualBoolArguments);
  }
  public void AddBuiltinCandidate(QualType ResultTy, QualType /*P*/ ParamTy, 
                     ArrayRef<Expr /*P*/ > Args, 
                     final OverloadCandidateSet /*&*/ CandidateSet) {
    AddBuiltinCandidate(ResultTy, create_type$ptr(ParamTy), Args, CandidateSet);
  }
  public void AddBuiltinCandidate(QualType ResultTy, QualType /*P*/ ParamTy, 
                     ArrayRef<Expr /*P*/ > Args, 
                     final OverloadCandidateSet /*&*/ CandidateSet,
                     boolean IsAssignmentOperator/*= false*/) {
    AddBuiltinCandidate(ResultTy, create_type$ptr(ParamTy), Args, CandidateSet, IsAssignmentOperator);
  }
  public void AddBuiltinCandidate(QualType ResultTy, QualType /*P*/ ParamTy, 
                     ArrayRef<Expr /*P*/ > Args, 
                     final OverloadCandidateSet /*&*/ CandidateSet,
                     boolean IsAssignmentOperator/*= false*/,
         /*uint*/int NumContextualBoolArguments/*= 0*/) {
    AddBuiltinCandidate(ResultTy, create_type$ptr(ParamTy), Args, CandidateSet, IsAssignmentOperator, NumContextualBoolArguments);
  }

  private static final Comparator<pair<CXXRecordDecl, CXXSpecialMember>> SpecialMembersBeingDeclared$Comparator = new Comparator<pair<CXXRecordDecl, CXXSpecialMember>>() {
    @Override
    public int compare(pair<CXXRecordDecl/*P*/, CXXSpecialMember> lhs, pair<CXXRecordDecl/*P*/, CXXSpecialMember> rhs) {
      if (lhs.first == rhs.first) {
        return lhs.second.getValue() - rhs.second.getValue();
      } else {
        return System.identityHashCode(lhs.first) - System.identityHashCode(rhs.first);
      }
    }    
  };
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  
  @Override public String toString() {
    if (true) return "[Sema]";
    return "" + "ExternalSource=" + "[ExternalSemaSource]" // NOI18N
              + ", isMultiplexExternalSource=" + isMultiplexExternalSource // NOI18N
              + ", OpenCLFeatures=" + OpenCLFeatures // NOI18N
              + ", FPFeatures=" + FPFeatures // NOI18N
              + ", LangOpts=" + LangOpts // NOI18N
              + ", PP=" + "[Preprocessor]" // NOI18N
              + ", Context=" + "[ASTContext]" // NOI18N
              + ", Consumer=" + "[ASTConsumer]" // NOI18N
              + ", Diags=" + "[DiagnosticsEngine]" // NOI18N
              + ", SourceMgr=" + "[SourceManager]" // NOI18N
              + ", CollectStats=" + CollectStats // NOI18N
              + ", CodeCompleter=" + "[CodeCompleteConsumer]" // NOI18N
              + ", CurContext=" + "[DeclContext]" // NOI18N
              + ", OriginalLexicalContext=" + "[DeclContext]" // NOI18N
              + ", VAListTagName=" + VAListTagName // NOI18N
              + ", MSStructPragmaOn=" + MSStructPragmaOn // NOI18N
              + ", MSPointerToMemberRepresentationMethod=" + MSPointerToMemberRepresentationMethod // NOI18N
              + ", CurrentSEHFinally=" + CurrentSEHFinally // NOI18N
              + ", ImplicitMSInheritanceAttrLoc=" + ImplicitMSInheritanceAttrLoc // NOI18N
              + ", VtorDispStack=" + VtorDispStack // NOI18N
              + ", PackStack=" + PackStack // NOI18N
              + ", DataSegStack=" + DataSegStack // NOI18N
              + ", BSSSegStack=" + BSSSegStack // NOI18N
              + ", ConstSegStack=" + ConstSegStack // NOI18N
              + ", CodeSegStack=" + CodeSegStack // NOI18N
              + ", NullabilityMap=" + NullabilityMap // NOI18N
              + ", CurInitSeg=" + CurInitSeg // NOI18N
              + ", CurInitSegLoc=" + CurInitSegLoc // NOI18N
              + ", VisContext=" + VisContext // NOI18N
              + ", OptimizeOffPragmaLocation=" + OptimizeOffPragmaLocation // NOI18N
              + ", IsBuildingRecoveryCallExpr=" + IsBuildingRecoveryCallExpr // NOI18N
              + ", Cleanup=" + Cleanup // NOI18N
              + ", ExprCleanupObjects=" + ExprCleanupObjects // NOI18N
              + ", MaybeODRUseExprs=" + MaybeODRUseExprs // NOI18N
              + ", FunctionScopes=" + FunctionScopes // NOI18N
              + ", ExtVectorDecls=" + ExtVectorDecls // NOI18N
              + ", FieldCollector=" + FieldCollector // NOI18N
              + ", UnusedPrivateFields=" + UnusedPrivateFields // NOI18N
              + ", UnusedLocalTypedefNameCandidates=" + UnusedLocalTypedefNameCandidates // NOI18N
              + ", DeleteExprs=" + DeleteExprs // NOI18N
              + ", PureVirtualClassDiagSet=" + PureVirtualClassDiagSet // NOI18N
              + ", ParsingInitForAutoVars=" + ParsingInitForAutoVars // NOI18N
              + ", TentativeDefinitions=" + TentativeDefinitions // NOI18N
              + ", UnusedFileScopedDecls=" + UnusedFileScopedDecls // NOI18N
              + ", DelegatingCtorDecls=" + DelegatingCtorDecls // NOI18N
              + ", DelayedExceptionSpecChecks=" + DelayedExceptionSpecChecks // NOI18N
              + ", DelayedDefaultedMemberExceptionSpecs=" + DelayedDefaultedMemberExceptionSpecs // NOI18N
              + ", LateParsedTemplateMap=" + LateParsedTemplateMap // NOI18N
              + ", LateTemplateParser=" + LateTemplateParser // NOI18N
              + ", LateTemplateParserCleanup=" + LateTemplateParserCleanup // NOI18N
              + ", OpaqueParser=" + OpaqueParser // NOI18N
              + ", DelayedDiagnostics=" + DelayedDiagnostics // NOI18N
              + ", WeakUndeclaredIdentifiers=" + WeakUndeclaredIdentifiers // NOI18N
              + ", ExtnameUndeclaredIdentifiers=" + ExtnameUndeclaredIdentifiers // NOI18N
              + ", WeakTopLevelDecl=" + WeakTopLevelDecl // NOI18N
              + ", IdResolver=" + IdResolver // NOI18N
              + ", TUScope=" + TUScope // NOI18N
              + ", StdNamespace=" + StdNamespace // NOI18N
              + ", StdBadAlloc=" + StdBadAlloc // NOI18N
              + ", StdInitializerList=" + StdInitializerList // NOI18N
              + ", CXXTypeInfoDecl=" + CXXTypeInfoDecl // NOI18N
              + ", MSVCGuidDecl=" + MSVCGuidDecl // NOI18N
              + ", NSAPIObj=" + NSAPIObj // NOI18N
              + ", NSNumberDecl=" + NSNumberDecl // NOI18N
              + ", NSValueDecl=" + NSValueDecl // NOI18N
              + ", NSNumberPointer=" + NSNumberPointer // NOI18N
              + ", NSValuePointer=" + NSValuePointer // NOI18N
              + ", NSNumberLiteralMethods=" + NSNumberLiteralMethods // NOI18N
              + ", NSStringDecl=" + NSStringDecl // NOI18N
              + ", NSStringPointer=" + NSStringPointer // NOI18N
              + ", StringWithUTF8StringMethod=" + StringWithUTF8StringMethod // NOI18N
              + ", ValueWithBytesObjCTypeMethod=" + ValueWithBytesObjCTypeMethod // NOI18N
              + ", NSArrayDecl=" + NSArrayDecl // NOI18N
              + ", ArrayWithObjectsMethod=" + ArrayWithObjectsMethod // NOI18N
              + ", NSDictionaryDecl=" + NSDictionaryDecl // NOI18N
              + ", DictionaryWithObjectsMethod=" + DictionaryWithObjectsMethod // NOI18N
              + ", QIDNSCopying=" + QIDNSCopying // NOI18N
              + ", RespondsToSelectorSel=" + RespondsToSelectorSel // NOI18N
              + ", MSAsmLabelNameCounter=" + MSAsmLabelNameCounter // NOI18N
              + ", GlobalNewDeleteDeclared=" + GlobalNewDeleteDeclared // NOI18N
              + ", AllowAbstractFieldReference=" + AllowAbstractFieldReference // NOI18N
              + ", ExprEvalContexts=" + ExprEvalContexts // NOI18N
              + ", SpecialMemberCache=" + SpecialMemberCache // NOI18N
              + ", FlagBitsCache=" + FlagBitsCache // NOI18N
              + ", TUKind=" + TUKind // NOI18N
              + ", BumpAlloc=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", NumSFINAEErrors=" + NumSFINAEErrors // NOI18N
              + ", UnparsedDefaultArgInstantiations=" + UnparsedDefaultArgInstantiations // NOI18N
              + ", UnparsedDefaultArgLocs=" + UnparsedDefaultArgLocs // NOI18N
              + ", UndefinedButUsed=" + UndefinedButUsed // NOI18N
              + ", MethodPool=" + MethodPool // NOI18N
              + ", ReferencedSelectors=" + ReferencedSelectors // NOI18N
              + ", SpecialMembersBeingDeclared=" + SpecialMembersBeingDeclared // NOI18N
              + ", VisibleModules=" + VisibleModules // NOI18N
              + ", VisibleModulesStack=" + VisibleModulesStack // NOI18N
              + ", CachedFakeTopLevelModule=" + CachedFakeTopLevelModule // NOI18N
              + ", DeclsInPrototypeScope=" + DeclsInPrototypeScope // NOI18N
              + ", ShadowingDecls=" + ShadowingDecls // NOI18N
              + ", DelayedTypos=" + DelayedTypos // NOI18N
              + ", KnownNamespaces=" + KnownNamespaces // NOI18N
              + ", LoadedExternalKnownNamespaces=" + LoadedExternalKnownNamespaces // NOI18N
              + ", CXXThisTypeOverride=" + CXXThisTypeOverride // NOI18N
              + ", VTableUses=" + VTableUses // NOI18N
              + ", VTablesUsed=" + VTablesUsed // NOI18N
              + ", AccessCheckingSFINAE=" + AccessCheckingSFINAE // NOI18N
              + ", ActiveTemplateInstantiations=" + ActiveTemplateInstantiations // NOI18N
              + ", ActiveTemplateInstantiationLookupModules=" + ActiveTemplateInstantiationLookupModules // NOI18N
              + ", LookupModulesCache=" + LookupModulesCache // NOI18N
              + ", VisibleNamespaceCache=" + VisibleNamespaceCache // NOI18N
              + ", InNonInstantiationSFINAEContext=" + InNonInstantiationSFINAEContext // NOI18N
              + ", NonInstantiationEntries=" + NonInstantiationEntries // NOI18N
              + ", LastTemplateInstantiationErrorContext=" + LastTemplateInstantiationErrorContext // NOI18N
              + ", ArgumentPackSubstitutionIndex=" + ArgumentPackSubstitutionIndex // NOI18N
              + ", SuppressedDiagnostics=" + SuppressedDiagnostics // NOI18N
              + ", CurrentInstantiationScope=" + CurrentInstantiationScope // NOI18N
              + ", DisableTypoCorrection=" + DisableTypoCorrection // NOI18N
              + ", TyposCorrected=" + TyposCorrected // NOI18N
              + ", TypoCorrectionFailures=" + TypoCorrectionFailures // NOI18N
              + ", AnalysisWarnings=" + AnalysisWarnings // NOI18N
              + ", ThreadSafetyDeclCache=" + ThreadSafetyDeclCache // NOI18N
              + ", PendingInstantiations=" + PendingInstantiations // NOI18N
              + ", PendingLocalImplicitInstantiations=" + PendingLocalImplicitInstantiations // NOI18N
              + ", VarDataSharingAttributesStack=" + VarDataSharingAttributesStack // NOI18N
              + ", IsInOpenMPDeclareTargetContext=" + IsInOpenMPDeclareTargetContext // NOI18N
              + ", TypeTagForDatatypeMagicValues=" + TypeTagForDatatypeMagicValues // NOI18N
              + ", CurScope=" + CurScope // NOI18N
              + ", Ident_super=" + Ident_super // NOI18N
              + ", Ident___float128=" + Ident___float128 // NOI18N
              + ", Ident__Nonnull=" + Ident__Nonnull // NOI18N
              + ", Ident__Nullable=" + Ident__Nullable // NOI18N
              + ", Ident__Null_unspecified=" + Ident__Null_unspecified // NOI18N
              + ", Ident_NSError=" + Ident_NSError // NOI18N
              + ", CFError=" + CFError // NOI18N
              + ", DelayedDllExportClasses=" + DelayedDllExportClasses; // NOI18N
  }    
}
