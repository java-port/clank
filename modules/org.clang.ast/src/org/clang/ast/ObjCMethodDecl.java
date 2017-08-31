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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.ast.DeclContext.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.basic.SourceLocation.*;
import static org.clang.ast.impl.DeclObjCStatics.*;
import org.clang.ast.java.ParamTypeObjC;


/// ObjCMethodDecl - Represents an instance or class method declaration.
/// ObjC methods can be declared within 4 contexts: class interfaces,
/// categories, protocols, and class implementations. While C++ member
/// functions leverage C syntax, Objective-C method syntax is modeled after
/// Smalltalk (using colons to specify argument types/expressions).
/// Here are some brief examples:
///
/// Setter/getter instance methods:
/// - (void)setMenu:(NSMenu *)menu;
/// - (NSMenu *)menu;
///
/// Instance method that takes 2 NSView arguments:
/// - (void)replaceSubview:(NSView *)oldView with:(NSView *)newView;
///
/// Getter class method:
/// + (NSMenu *)defaultMenu;
///
/// A selector represents a unique name for a method. The selector names for
/// the above methods are setMenu:, menu, replaceSubview:with:, and defaultMenu.
///
//<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 113,
 FQN="clang::ObjCMethodDecl", NM="_ZN5clang14ObjCMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDeclE")
//</editor-fold>
public class ObjCMethodDecl extends /*public*/ NamedDecl implements /*public*/ DeclContext, Destructors.ClassWithDestructor, ParamTypeObjC {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::ImplementationControl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 115,
   FQN="clang::ObjCMethodDecl::ImplementationControl", NM="_ZN5clang14ObjCMethodDecl21ImplementationControlE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl21ImplementationControlE")
  //</editor-fold>
  public enum ImplementationControl implements Native.ComparableLower {
    None(0),
    Required(None.getValue() + 1),
    Optional(Required.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ImplementationControl valueOf(int val) {
      ImplementationControl out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ImplementationControl[] VALUES;
      private static final ImplementationControl[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ImplementationControl kind : ImplementationControl.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ImplementationControl[min < 0 ? (1-min) : 0];
        VALUES = new ImplementationControl[max >= 0 ? (1+max) : 0];
        for (ImplementationControl kind : ImplementationControl.values()) {
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
    private ImplementationControl(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ImplementationControl)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ImplementationControl)obj).value);}
    //</editor-fold>
  };
/*private:*/
  // The conventional meaning of this method; an ObjCMethodFamily.
  // This is not serialized; instead, it is computed on demand and
  // cached.
  private /*mutable *//*JBYTE unsigned int*/ byte Family /*: ObjCMethodFamilyBitWidth*/;
  
  /// instance (true) or class (false) method.
  private /*JBIT unsigned int*/ boolean IsInstance /*: 1*/;
  private /*JBIT unsigned int*/ boolean IsVariadic /*: 1*/;
  
  /// True if this method is the getter or setter for an explicit property.
  private /*JBIT unsigned int*/ boolean IsPropertyAccessor /*: 1*/;
  
  // Method has a definition.
  private /*JBIT unsigned int*/ boolean IsDefined /*: 1*/;
  
  /// \brief Method redeclaration in the same interface.
  /*friend*/public /*JBIT unsigned int*/ boolean IsRedeclaration /*: 1*/;
  
  /// \brief Is redeclared in the same interface.
  /*friend*/public /*mutable *//*JBIT unsigned int*/ boolean HasRedeclaration /*: 1*/;
  
  // NOTE: VC++ treats enums as signed, avoid using ImplementationControl enum
  /// \@required/\@optional
  private /*JBYTE unsigned int*/ byte DeclImplementation /*: 2*/;
  
  // NOTE: VC++ treats enums as signed, avoid using the ObjCDeclQualifier enum
  /// in, inout, etc.
  private /*JBYTE unsigned int*/ byte objcDeclQualifier /*: 7*/;
  
  /// \brief Indicates whether this method has a related result type.
  private /*JBIT unsigned int*/ boolean RelatedResultType /*: 1*/;
  
  /// \brief Whether the locations of the selector identifiers are in a
  /// "standard" position, a enum SelectorLocationsKind.
  /*friend*/public /*JBYTE unsigned int*/ byte SelLocsKind /*: 2*/;
  
  /// \brief Whether this method overrides any other in the class hierarchy.
  ///
  /// A method is said to override any method in the class's
  /// base classes, its protocols, or its categories' protocols, that has
  /// the same selector and is of the same kind (class or instance).
  /// A method in an implementation is not considered as overriding the same
  /// method in the interface or its categories.
  /*friend*/public /*JBIT unsigned int*/ boolean IsOverriding /*: 1*/;
  
  /// \brief Indicates if the method was a definition but its body was skipped.
  /*friend*/public /*JBIT unsigned int*/ boolean HasSkippedBody /*: 1*/;
  
  // Return type of this method.
  private QualType MethodDeclType;
  
  // Type source information for the return type.
  private TypeSourceInfo /*P*/ ReturnTInfo;
  
  /// \brief Array of ParmVarDecls for the formal parameters of this method
  /// and optionally followed by selector locations.
  private type$ptr<?>/*void P*/ ParamsAndSelLocs;
  private /*uint*/int NumParams;
  
  /// List of attributes for this method declaration.
  /*friend*/public SourceLocation DeclEndLoc; // the location of the ';' or '{'.
  
  // The following are only used for method definitions, null otherwise.
  private LazyDeclStmtPtr Body;
  
  /// SelfDecl - Decl for the implicit self parameter. This is lazily
  /// constructed by createImplicitParams.
  private ImplicitParamDecl /*P*/ SelfDecl;
  /// CmdDecl - Decl for the implicit _cmd parameter. This is lazily
  /// constructed by createImplicitParams.
  private ImplicitParamDecl /*P*/ CmdDecl;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getSelLocsKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 189,
   FQN="clang::ObjCMethodDecl::getSelLocsKind", NM="_ZNK5clang14ObjCMethodDecl14getSelLocsKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl14getSelLocsKindEv")
  //</editor-fold>
  private SelectorLocationsKind getSelLocsKind() /*const*/ {
    return SelectorLocationsKind.valueOf(SelLocsKind);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::hasStandardSelLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 192,
   FQN="clang::ObjCMethodDecl::hasStandardSelLocs", NM="_ZNK5clang14ObjCMethodDecl18hasStandardSelLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl18hasStandardSelLocsEv")
  //</editor-fold>
  private boolean hasStandardSelLocs() /*const*/ {
    return getSelLocsKind() != SelectorLocationsKind.SelLoc_NonStandard;
  }

  
  /// \brief Get a pointer to the stored selector identifiers locations array.
  /// No locations will be stored if HasStandardSelLocs is true.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getStoredSelLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 198,
   FQN="clang::ObjCMethodDecl::getStoredSelLocs", NM="_ZN5clang14ObjCMethodDecl16getStoredSelLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl16getStoredSelLocsEv")
  //</editor-fold>
  /*friend*/public type$ptr<SourceLocation> /*P*/ getStoredSelLocs() {
    return ((type$ptr<SourceLocation> /*P*/ )reinterpret_cast(type$ptr.class, getParams().$add(NumParams)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getStoredSelLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 201,
   FQN="clang::ObjCMethodDecl::getStoredSelLocs", NM="_ZNK5clang14ObjCMethodDecl16getStoredSelLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl16getStoredSelLocsEv")
  //</editor-fold>
  private /*const*/type$ptr<SourceLocation> /*P*/ getStoredSelLocs$Const() /*const*/ {
    return ((/*const*/type$ptr<SourceLocation> /*P*/ )reinterpret_cast(/*const*/type$ptr.class, getParams$Const().$add(NumParams)));
  }

  
  /// \brief Get a pointer to the stored selector identifiers locations array.
  /// No locations will be stored if HasStandardSelLocs is true.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 207,
   FQN="clang::ObjCMethodDecl::getParams", NM="_ZN5clang14ObjCMethodDecl9getParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl9getParamsEv")
  //</editor-fold>
  private type$ptr<ParmVarDecl /*P*/ /*P*/> getParams() {
    return ((type$ptr<ParmVarDecl /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, ParamsAndSelLocs));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 210,
   FQN="clang::ObjCMethodDecl::getParams", NM="_ZNK5clang14ObjCMethodDecl9getParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl9getParamsEv")
  //</editor-fold>
  private type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/> getParams$Const() /*const*/ {
    return ((type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, ParamsAndSelLocs));
  }

  
  /// \brief Get the number of stored selector identifiers locations.
  /// No locations will be stored if HasStandardSelLocs is true.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getNumStoredSelLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 216,
   FQN="clang::ObjCMethodDecl::getNumStoredSelLocs", NM="_ZNK5clang14ObjCMethodDecl19getNumStoredSelLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl19getNumStoredSelLocsEv")
  //</editor-fold>
  /*friend*/public /*uint*/int getNumStoredSelLocs() /*const*/ {
    if (hasStandardSelLocs()) {
      return 0;
    }
    return getNumSelectorLocs();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::setParamsAndSelLocs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 795,
   FQN="clang::ObjCMethodDecl::setParamsAndSelLocs", NM="_ZN5clang14ObjCMethodDecl19setParamsAndSelLocsERNS_10ASTContextEN4llvm8ArrayRefIPNS_11ParmVarDeclEEENS4_INS_14SourceLocationEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl19setParamsAndSelLocsERNS_10ASTContextEN4llvm8ArrayRefIPNS_11ParmVarDeclEEENS4_INS_14SourceLocationEEE")
  //</editor-fold>
  /*friend*/public void setParamsAndSelLocs(final ASTContext /*&*/ C, 
                     ArrayRef<ParmVarDecl /*P*/ > Params, 
                     ArrayRef<SourceLocation> SelLocs) {
    ParamsAndSelLocs = create_type$ptr((Object[])null);
    NumParams = Params.size();
    if (Params.empty() && SelLocs.empty()) {
      return;
    }
    
    static_assert(Unsigned.$greatereq_uint(alignOf(ParmVarDecl/*P*/.class)
      , alignOf(SourceLocation.class)), $("Alignment not sufficient for SourceLocation"));
    
    // JAVA: MEMORY
    /*uint*/int Size;
    if (false) {
      Size = $sizeof_ptr(/*ParmVarDecl  */) * NumParams
              + $sizeof_SourceLocation() * SelLocs.size();
      ParamsAndSelLocs = (type$ptr)C.Allocate(Size);
    } else {
      // in Java objects occupies just one slot
      Size = 1 * NumParams
              + 1 * SelLocs.size();
      ParamsAndSelLocs = C.Allocate$JavaRef(Size);
      // SourceLocation are stored as values, not pointers, so prepare the memory
      for (int idx = NumParams, count = 0; count < SelLocs.size(); idx++, count++) {
        ((type$ptr)ParamsAndSelLocs).$set(idx, new SourceLocation());
      }
    }
    std.copy(Params.begin(), Params.end(), getParams());
    std.copy(SelLocs.begin(), SelLocs.end(), getStoredSelLocs());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::ObjCMethodDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*create null ptr*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 226,
   FQN="clang::ObjCMethodDecl::ObjCMethodDecl", NM="_ZN5clang14ObjCMethodDeclC1ENS_14SourceLocationES1_NS_8SelectorENS_8QualTypeEPNS_14TypeSourceInfoEPNS_11DeclContextEbbbbbNS0_21ImplementationControlEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDeclC1ENS_14SourceLocationES1_NS_8SelectorENS_8QualTypeEPNS_14TypeSourceInfoEPNS_11DeclContextEbbbbbNS0_21ImplementationControlEb")
  //</editor-fold>
  private ObjCMethodDecl(SourceLocation beginLoc, SourceLocation endLoc, 
      Selector SelInfo, QualType T, TypeSourceInfo /*P*/ ReturnTInfo, 
      DeclContext /*P*/ contextDecl) {
    this(beginLoc, endLoc, 
      SelInfo, T, ReturnTInfo, 
      contextDecl, true, 
      false, false, 
      false, false, 
      ImplementationControl.None, 
      false);
  }
  private ObjCMethodDecl(SourceLocation beginLoc, SourceLocation endLoc, 
      Selector SelInfo, QualType T, TypeSourceInfo /*P*/ ReturnTInfo, 
      DeclContext /*P*/ contextDecl, boolean isInstance/*= true*/) {
    this(beginLoc, endLoc, 
      SelInfo, T, ReturnTInfo, 
      contextDecl, isInstance, 
      false, false, 
      false, false, 
      ImplementationControl.None, 
      false);
  }
  private ObjCMethodDecl(SourceLocation beginLoc, SourceLocation endLoc, 
      Selector SelInfo, QualType T, TypeSourceInfo /*P*/ ReturnTInfo, 
      DeclContext /*P*/ contextDecl, boolean isInstance/*= true*/, 
      boolean isVariadic/*= false*/) {
    this(beginLoc, endLoc, 
      SelInfo, T, ReturnTInfo, 
      contextDecl, isInstance, 
      isVariadic, false, 
      false, false, 
      ImplementationControl.None, 
      false);
  }
  private ObjCMethodDecl(SourceLocation beginLoc, SourceLocation endLoc, 
      Selector SelInfo, QualType T, TypeSourceInfo /*P*/ ReturnTInfo, 
      DeclContext /*P*/ contextDecl, boolean isInstance/*= true*/, 
      boolean isVariadic/*= false*/, boolean isPropertyAccessor/*= false*/) {
    this(beginLoc, endLoc, 
      SelInfo, T, ReturnTInfo, 
      contextDecl, isInstance, 
      isVariadic, isPropertyAccessor, 
      false, false, 
      ImplementationControl.None, 
      false);
  }
  private ObjCMethodDecl(SourceLocation beginLoc, SourceLocation endLoc, 
      Selector SelInfo, QualType T, TypeSourceInfo /*P*/ ReturnTInfo, 
      DeclContext /*P*/ contextDecl, boolean isInstance/*= true*/, 
      boolean isVariadic/*= false*/, boolean isPropertyAccessor/*= false*/, 
      boolean isImplicitlyDeclared/*= false*/) {
    this(beginLoc, endLoc, 
      SelInfo, T, ReturnTInfo, 
      contextDecl, isInstance, 
      isVariadic, isPropertyAccessor, 
      isImplicitlyDeclared, false, 
      ImplementationControl.None, 
      false);
  }
  private ObjCMethodDecl(SourceLocation beginLoc, SourceLocation endLoc, 
      Selector SelInfo, QualType T, TypeSourceInfo /*P*/ ReturnTInfo, 
      DeclContext /*P*/ contextDecl, boolean isInstance/*= true*/, 
      boolean isVariadic/*= false*/, boolean isPropertyAccessor/*= false*/, 
      boolean isImplicitlyDeclared/*= false*/, boolean isDefined/*= false*/) {
    this(beginLoc, endLoc, 
      SelInfo, T, ReturnTInfo, 
      contextDecl, isInstance, 
      isVariadic, isPropertyAccessor, 
      isImplicitlyDeclared, isDefined, 
      ImplementationControl.None, 
      false);
  }
  private ObjCMethodDecl(SourceLocation beginLoc, SourceLocation endLoc, 
      Selector SelInfo, QualType T, TypeSourceInfo /*P*/ ReturnTInfo, 
      DeclContext /*P*/ contextDecl, boolean isInstance/*= true*/, 
      boolean isVariadic/*= false*/, boolean isPropertyAccessor/*= false*/, 
      boolean isImplicitlyDeclared/*= false*/, boolean isDefined/*= false*/, 
      ImplementationControl impControl/*= None*/) {
    this(beginLoc, endLoc, 
      SelInfo, T, ReturnTInfo, 
      contextDecl, isInstance, 
      isVariadic, isPropertyAccessor, 
      isImplicitlyDeclared, isDefined, 
      impControl, 
      false);
  }
  private ObjCMethodDecl(SourceLocation beginLoc, SourceLocation endLoc, 
      Selector SelInfo, QualType T, TypeSourceInfo /*P*/ ReturnTInfo, 
      DeclContext /*P*/ contextDecl, boolean isInstance/*= true*/, 
      boolean isVariadic/*= false*/, boolean isPropertyAccessor/*= false*/, 
      boolean isImplicitlyDeclared/*= false*/, boolean isDefined/*= false*/, 
      ImplementationControl impControl/*= None*/, 
      boolean HasRelatedResultType/*= false*/) {
    // : NamedDecl(ObjCMethod, contextDecl, beginLoc, SelInfo), DeclContext(ObjCMethod), Family(InvalidObjCMethodFamily), IsInstance(isInstance), IsVariadic(isVariadic), IsPropertyAccessor(isPropertyAccessor), IsDefined(isDefined), IsRedeclaration(0), HasRedeclaration(0), DeclImplementation(impControl), objcDeclQualifier(OBJC_TQ_None), RelatedResultType(HasRelatedResultType), SelLocsKind(SelLoc_StandardNoSpace), IsOverriding(0), HasSkippedBody(0), MethodDeclType(T), ReturnTInfo(ReturnTInfo), ParamsAndSelLocs(null), NumParams(0), DeclEndLoc(endLoc), Body(), SelfDecl(null), CmdDecl(null) 
    //START JInit
    super(Kind.ObjCMethod, contextDecl, new SourceLocation(beginLoc), new DeclarationName(new Selector(SelInfo)));
    this.DeclContext$Flds = $DeclContext(Kind.ObjCMethod);
    this.Family = $uint2uint_4bits(InvalidObjCMethodFamily);
    this.IsInstance = isInstance;
    this.IsVariadic = isVariadic;
    this.IsPropertyAccessor = isPropertyAccessor;
    this.IsDefined = isDefined;
    this.IsRedeclaration = false;
    this.HasRedeclaration = false;
    this.DeclImplementation = $uint2uint_2bits(impControl.getValue());
    this.objcDeclQualifier = $uint2uint_7bits(ObjCDeclQualifier.OBJC_TQ_None);
    this.RelatedResultType = HasRelatedResultType;
    this.SelLocsKind = $uint2uint_2bits(SelectorLocationsKind.SelLoc_StandardNoSpace.getValue());
    this.IsOverriding = false;
    this.HasSkippedBody = false;
    this.MethodDeclType = new QualType(T);
    this.ReturnTInfo = ReturnTInfo;
    this.ParamsAndSelLocs = create_type$ptr((Object[])null);
    this.NumParams = 0;
    this.DeclEndLoc = new SourceLocation(endLoc);
    this.Body = new LazyDeclStmtPtr();
    this.SelfDecl = null;
    this.CmdDecl = null;
    //END JInit
    setImplicit(isImplicitlyDeclared);
  }

  
  /// \brief A definition will return its interface declaration.
  /// An interface declaration will return its definition.
  /// Otherwise it will return itself.
  
  /// \brief A definition will return its interface declaration.
  /// An interface declaration will return its definition.
  /// Otherwise it will return itself.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getNextRedeclarationImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 839,
   FQN="clang::ObjCMethodDecl::getNextRedeclarationImpl", NM="_ZN5clang14ObjCMethodDecl24getNextRedeclarationImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl24getNextRedeclarationImplEv")
  //</editor-fold>
  @Override protected/*private*/ ObjCMethodDecl /*P*/ getNextRedeclarationImpl()/* override*/ {
    final ASTContext /*&*/ Ctx = getASTContext();
    ObjCMethodDecl /*P*/ Redecl = null;
    if (HasRedeclaration) {
      Redecl = ((/*const_cast*/ObjCMethodDecl /*P*/ )(Ctx.getObjCMethodRedeclaration(this)));
    }
    if ((Redecl != null)) {
      return Redecl;
    }
    
    Decl /*P*/ CtxD = cast_Decl(getDeclContext());
    if (!CtxD.isInvalidDecl()) {
      {
        ObjCInterfaceDecl /*P*/ IFD = dyn_cast_ObjCInterfaceDecl(CtxD);
        if ((IFD != null)) {
          {
            ObjCImplementationDecl /*P*/ ImplD = Ctx.getObjCImplementation(IFD);
            if ((ImplD != null)) {
              if (!ImplD.isInvalidDecl()) {
                Redecl = ImplD.getMethod(getSelector(), isInstanceMethod());
              }
            }
          }
        } else {
          ObjCCategoryDecl /*P*/ CD = dyn_cast_ObjCCategoryDecl(CtxD);
          if ((CD != null)) {
            {
              ObjCCategoryImplDecl /*P*/ ImplD = Ctx.getObjCImplementation(CD);
              if ((ImplD != null)) {
                if (!ImplD.isInvalidDecl()) {
                  Redecl = ImplD.getMethod(getSelector(), isInstanceMethod());
                }
              }
            }
          } else {
            ObjCImplementationDecl /*P*/ ImplD = dyn_cast_ObjCImplementationDecl(CtxD);
            if ((ImplD != null)) {
              {
                ObjCInterfaceDecl /*P*/ IFD$1 = ImplD.getClassInterface();
                if ((IFD$1 != null)) {
                  if (!IFD$1.isInvalidDecl()) {
                    Redecl = IFD$1.getMethod(getSelector(), isInstanceMethod());
                  }
                }
              }
            } else {
              ObjCCategoryImplDecl /*P*/ CImplD = dyn_cast_ObjCCategoryImplDecl(CtxD);
              if ((CImplD != null)) {
                {
                  ObjCCategoryDecl /*P*/ CatD = CImplD.getCategoryDecl();
                  if ((CatD != null)) {
                    if (!CatD.isInvalidDecl()) {
                      Redecl = CatD.getMethod(getSelector(), isInstanceMethod());
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if (!(Redecl != null) && isRedeclaration()) {
      // This is the last redeclaration, go back to the first method.
      return cast_ObjCContainerDecl(CtxD).getMethod(getSelector(), 
          isInstanceMethod());
    }
    
    return (Redecl != null) ? Redecl : this;
  }

/*public:*/
  
  //===----------------------------------------------------------------------===//
  // ObjCMethodDecl
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 750,
   FQN="clang::ObjCMethodDecl::Create", NM="_ZN5clang14ObjCMethodDecl6CreateERNS_10ASTContextENS_14SourceLocationES3_NS_8SelectorENS_8QualTypeEPNS_14TypeSourceInfoEPNS_11DeclContextEbbbbbNS0_21ImplementationControlEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl6CreateERNS_10ASTContextENS_14SourceLocationES3_NS_8SelectorENS_8QualTypeEPNS_14TypeSourceInfoEPNS_11DeclContextEbbbbbNS0_21ImplementationControlEb")
  //</editor-fold>
  public static ObjCMethodDecl /*P*/ Create(final ASTContext /*&*/ C, SourceLocation beginLoc, SourceLocation endLoc, 
        Selector SelInfo, QualType T, TypeSourceInfo /*P*/ ReturnTInfo, 
        DeclContext /*P*/ contextDecl) {
    return Create(C, beginLoc, endLoc, 
        SelInfo, T, ReturnTInfo, 
        contextDecl, true, false, 
        false, false, false, 
        ImplementationControl.None, false);
  }
  public static ObjCMethodDecl /*P*/ Create(final ASTContext /*&*/ C, SourceLocation beginLoc, SourceLocation endLoc, 
        Selector SelInfo, QualType T, TypeSourceInfo /*P*/ ReturnTInfo, 
        DeclContext /*P*/ contextDecl, boolean isInstance/*= true*/) {
    return Create(C, beginLoc, endLoc, 
        SelInfo, T, ReturnTInfo, 
        contextDecl, isInstance, false, 
        false, false, false, 
        ImplementationControl.None, false);
  }
  public static ObjCMethodDecl /*P*/ Create(final ASTContext /*&*/ C, SourceLocation beginLoc, SourceLocation endLoc, 
        Selector SelInfo, QualType T, TypeSourceInfo /*P*/ ReturnTInfo, 
        DeclContext /*P*/ contextDecl, boolean isInstance/*= true*/, boolean isVariadic/*= false*/) {
    return Create(C, beginLoc, endLoc, 
        SelInfo, T, ReturnTInfo, 
        contextDecl, isInstance, isVariadic, 
        false, false, false, 
        ImplementationControl.None, false);
  }
  public static ObjCMethodDecl /*P*/ Create(final ASTContext /*&*/ C, SourceLocation beginLoc, SourceLocation endLoc, 
        Selector SelInfo, QualType T, TypeSourceInfo /*P*/ ReturnTInfo, 
        DeclContext /*P*/ contextDecl, boolean isInstance/*= true*/, boolean isVariadic/*= false*/, 
        boolean isPropertyAccessor/*= false*/) {
    return Create(C, beginLoc, endLoc, 
        SelInfo, T, ReturnTInfo, 
        contextDecl, isInstance, isVariadic, 
        isPropertyAccessor, false, false, 
        ImplementationControl.None, false);
  }
  public static ObjCMethodDecl /*P*/ Create(final ASTContext /*&*/ C, SourceLocation beginLoc, SourceLocation endLoc, 
        Selector SelInfo, QualType T, TypeSourceInfo /*P*/ ReturnTInfo, 
        DeclContext /*P*/ contextDecl, boolean isInstance/*= true*/, boolean isVariadic/*= false*/, 
        boolean isPropertyAccessor/*= false*/, boolean isImplicitlyDeclared/*= false*/) {
    return Create(C, beginLoc, endLoc, 
        SelInfo, T, ReturnTInfo, 
        contextDecl, isInstance, isVariadic, 
        isPropertyAccessor, isImplicitlyDeclared, false, 
        ImplementationControl.None, false);
  }
  public static ObjCMethodDecl /*P*/ Create(final ASTContext /*&*/ C, SourceLocation beginLoc, SourceLocation endLoc, 
        Selector SelInfo, QualType T, TypeSourceInfo /*P*/ ReturnTInfo, 
        DeclContext /*P*/ contextDecl, boolean isInstance/*= true*/, boolean isVariadic/*= false*/, 
        boolean isPropertyAccessor/*= false*/, boolean isImplicitlyDeclared/*= false*/, boolean isDefined/*= false*/) {
    return Create(C, beginLoc, endLoc, 
        SelInfo, T, ReturnTInfo, 
        contextDecl, isInstance, isVariadic, 
        isPropertyAccessor, isImplicitlyDeclared, isDefined, 
        ImplementationControl.None, false);
  }
  public static ObjCMethodDecl /*P*/ Create(final ASTContext /*&*/ C, SourceLocation beginLoc, SourceLocation endLoc, 
        Selector SelInfo, QualType T, TypeSourceInfo /*P*/ ReturnTInfo, 
        DeclContext /*P*/ contextDecl, boolean isInstance/*= true*/, boolean isVariadic/*= false*/, 
        boolean isPropertyAccessor/*= false*/, boolean isImplicitlyDeclared/*= false*/, boolean isDefined/*= false*/, 
        ImplementationControl impControl/*= None*/) {
    return Create(C, beginLoc, endLoc, 
        SelInfo, T, ReturnTInfo, 
        contextDecl, isInstance, isVariadic, 
        isPropertyAccessor, isImplicitlyDeclared, isDefined, 
        impControl, false);
  }
  public static ObjCMethodDecl /*P*/ Create(final ASTContext /*&*/ C, SourceLocation beginLoc, SourceLocation endLoc, 
        Selector SelInfo, QualType T, TypeSourceInfo /*P*/ ReturnTInfo, 
        DeclContext /*P*/ contextDecl, boolean isInstance/*= true*/, boolean isVariadic/*= false*/, 
        boolean isPropertyAccessor/*= false*/, boolean isImplicitlyDeclared/*= false*/, boolean isDefined/*= false*/, 
        ImplementationControl impControl/*= None*/, boolean HasRelatedResultType/*= false*/) {
    return /*NEW_EXPR [Decl::new]*//*new (C, contextDecl)*/ Decl.$new(C, contextDecl, (type$ptr<?> New$Mem)->{
        return new ObjCMethodDecl(new SourceLocation(beginLoc), new SourceLocation(endLoc), new Selector(SelInfo), new QualType(T), ReturnTInfo, contextDecl, isInstance, 
                isVariadic, isPropertyAccessor, isImplicitlyDeclared, isDefined, 
                impControl, HasRelatedResultType);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 762,
   FQN="clang::ObjCMethodDecl::CreateDeserialized", NM="_ZN5clang14ObjCMethodDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static ObjCMethodDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> New$Mem)->{
        return new ObjCMethodDecl(new SourceLocation(), new SourceLocation(), 
                new Selector(), new QualType(), (TypeSourceInfo /*P*/ )null, (DeclContext /*P*/ )null);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 883,
   FQN="clang::ObjCMethodDecl::getCanonicalDecl", NM="_ZN5clang14ObjCMethodDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public ObjCMethodDecl /*P*/ getCanonicalDecl()/* override*/ {
    Decl /*P*/ CtxD = cast_Decl(getDeclContext());
    {
      
      ObjCImplementationDecl /*P*/ ImplD = dyn_cast_ObjCImplementationDecl(CtxD);
      if ((ImplD != null)) {
        {
          ObjCInterfaceDecl /*P*/ IFD = ImplD.getClassInterface();
          if ((IFD != null)) {
            {
              ObjCMethodDecl /*P*/ MD = IFD.getMethod(getSelector(), 
                  isInstanceMethod());
              if ((MD != null)) {
                return MD;
              }
            }
          }
        }
      } else {
        ObjCCategoryImplDecl /*P*/ CImplD = dyn_cast_ObjCCategoryImplDecl(CtxD);
        if ((CImplD != null)) {
          {
            ObjCCategoryDecl /*P*/ CatD = CImplD.getCategoryDecl();
            if ((CatD != null)) {
              {
                ObjCMethodDecl /*P*/ MD = CatD.getMethod(getSelector(), 
                    isInstanceMethod());
                if ((MD != null)) {
                  return MD;
                }
              }
            }
          }
        }
      }
    }
    if (isRedeclaration()) {
      return cast_ObjCContainerDecl(CtxD).getMethod(getSelector(), 
          isInstanceMethod());
    }
    
    return this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 265,
   FQN="clang::ObjCMethodDecl::getCanonicalDecl", NM="_ZNK5clang14ObjCMethodDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ ObjCMethodDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return ((/*const_cast*/ObjCMethodDecl /*P*/ )(this)).getCanonicalDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getObjCDeclQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 269,
   FQN="clang::ObjCMethodDecl::getObjCDeclQualifier", NM="_ZNK5clang14ObjCMethodDecl20getObjCDeclQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl20getObjCDeclQualifierEv")
  //</editor-fold>
  public /*ObjCDeclQualifier*//*uint*/int getObjCDeclQualifier() /*const*/ {
    return ((/*ObjCDeclQualifier*//*uint*/int)(objcDeclQualifier));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::setObjCDeclQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 272,
   FQN="clang::ObjCMethodDecl::setObjCDeclQualifier", NM="_ZN5clang14ObjCMethodDecl20setObjCDeclQualifierENS_4Decl17ObjCDeclQualifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl20setObjCDeclQualifierENS_4Decl17ObjCDeclQualifierE")
  //</editor-fold>
  public void setObjCDeclQualifier(/*ObjCDeclQualifier*//*uint*/int QV) {
    objcDeclQualifier = $uint2uint_7bits(QV);
  }

  
  /// \brief Determine whether this method has a result type that is related
  /// to the message receiver's type.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::hasRelatedResultType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 276,
   FQN="clang::ObjCMethodDecl::hasRelatedResultType", NM="_ZNK5clang14ObjCMethodDecl20hasRelatedResultTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl20hasRelatedResultTypeEv")
  //</editor-fold>
  public boolean hasRelatedResultType() /*const*/ {
    return RelatedResultType;
  }

  
  /// \brief Note whether this method has a related result type.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::SetRelatedResultType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 279,
   FQN="clang::ObjCMethodDecl::SetRelatedResultType", NM="_ZN5clang14ObjCMethodDecl20SetRelatedResultTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl20SetRelatedResultTypeEb")
  //</editor-fold>
  public void SetRelatedResultType() {
    SetRelatedResultType(true);
  }
  public void SetRelatedResultType(boolean RRT/*= true*/) {
    RelatedResultType = RRT;
  }

  
  /// \brief True if this is a method redeclaration in the same interface.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::isRedeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 282,
   FQN="clang::ObjCMethodDecl::isRedeclaration", NM="_ZNK5clang14ObjCMethodDecl15isRedeclarationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl15isRedeclarationEv")
  //</editor-fold>
  public boolean isRedeclaration() /*const*/ {
    return IsRedeclaration;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::setAsRedeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 788,
   FQN="clang::ObjCMethodDecl::setAsRedeclaration", NM="_ZN5clang14ObjCMethodDecl18setAsRedeclarationEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl18setAsRedeclarationEPKS0_")
  //</editor-fold>
  public void setAsRedeclaration(/*const*/ ObjCMethodDecl /*P*/ PrevMethod) {
    assert Native.$bool(PrevMethod);
    getASTContext().setObjCMethodRedeclaration(PrevMethod, this);
    IsRedeclaration = true;
    PrevMethod.HasRedeclaration = true;
  }

  
  /// \brief Returns the location where the declarator ends. It will be
  /// the location of ';' for a method declaration and the location of '{'
  /// for a method definition.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getDeclaratorEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 288,
   FQN="clang::ObjCMethodDecl::getDeclaratorEndLoc", NM="_ZNK5clang14ObjCMethodDecl19getDeclaratorEndLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl19getDeclaratorEndLocEv")
  //</editor-fold>
  public SourceLocation getDeclaratorEndLoc() /*const*/ {
    return new SourceLocation(DeclEndLoc);
  }

  
  // Location information, modeled after the Stmt API.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 291,
   FQN="clang::ObjCMethodDecl::getLocStart", NM="_ZNK5clang14ObjCMethodDecl11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getLocation();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 907,
   FQN="clang::ObjCMethodDecl::getLocEnd", NM="_ZNK5clang14ObjCMethodDecl9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    {
      Stmt /*P*/ Body = getBody();
      if ((Body != null)) {
        return Body.getLocEnd();
      }
    }
    return new SourceLocation(DeclEndLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 293,
   FQN="clang::ObjCMethodDecl::getSourceRange", NM="_ZNK5clang14ObjCMethodDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    return new SourceRange(getLocation(), getLocEnd());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getSelectorStartLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 297,
   FQN="clang::ObjCMethodDecl::getSelectorStartLoc", NM="_ZNK5clang14ObjCMethodDecl19getSelectorStartLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl19getSelectorStartLocEv")
  //</editor-fold>
  public SourceLocation getSelectorStartLoc() /*const*/ {
    if (isImplicit()) {
      return getLocStart();
    }
    return getSelectorLoc(0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getSelectorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 302,
   FQN="clang::ObjCMethodDecl::getSelectorLoc", NM="_ZNK5clang14ObjCMethodDecl14getSelectorLocEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl14getSelectorLocEj")
  //</editor-fold>
  public SourceLocation getSelectorLoc(/*uint*/int Index) /*const*/ {
    assert ($less_uint(Index, getNumSelectorLocs())) : "Index out of range!";
    if (hasStandardSelLocs()) {
      return getStandardSelectorLocParmVarDecls(Index, getSelector(), 
          getSelLocsKind() == SelectorLocationsKind.SelLoc_StandardWithSpace, 
          parameters(), 
          new SourceLocation(DeclEndLoc));
    }
    return new SourceLocation(getStoredSelLocs$Const().$at(Index));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getSelectorLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 814,
   FQN="clang::ObjCMethodDecl::getSelectorLocs", NM="_ZNK5clang14ObjCMethodDecl15getSelectorLocsERN4llvm15SmallVectorImplINS_14SourceLocationEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl15getSelectorLocsERN4llvm15SmallVectorImplINS_14SourceLocationEEE")
  //</editor-fold>
  public void getSelectorLocs(final SmallVectorImpl<SourceLocation> /*&*/ SelLocs) /*const*/ {
    for (/*uint*/int i = 0, e = getNumSelectorLocs(); i != e; ++i)  {
      SelLocs.push_back(getSelectorLoc(i));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getNumSelectorLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 314,
   FQN="clang::ObjCMethodDecl::getNumSelectorLocs", NM="_ZNK5clang14ObjCMethodDecl18getNumSelectorLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl18getNumSelectorLocsEv")
  //</editor-fold>
  public /*uint*/int getNumSelectorLocs() /*const*/ {
    if (isImplicit()) {
      return 0;
    }
    Selector Sel = getSelector();
    if (Sel.isUnarySelector()) {
      return 1;
    }
    return Sel.getNumArgs();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getClassInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1071,
   FQN="clang::ObjCMethodDecl::getClassInterface", NM="_ZN5clang14ObjCMethodDecl17getClassInterfaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl17getClassInterfaceEv")
  //</editor-fold>
  public ObjCInterfaceDecl /*P*/ getClassInterface() {
    {
      ObjCInterfaceDecl /*P*/ ID = dyn_cast_ObjCInterfaceDecl(getDeclContext());
      if ((ID != null)) {
        return ID;
      }
    }
    {
      ObjCCategoryDecl /*P*/ CD = dyn_cast_ObjCCategoryDecl(getDeclContext());
      if ((CD != null)) {
        return CD.getClassInterface();
      }
    }
    {
      ObjCImplDecl /*P*/ IMD = dyn_cast_ObjCImplDecl(getDeclContext());
      if ((IMD != null)) {
        return IMD.getClassInterface();
      }
    }
    if (isa_ObjCProtocolDecl(getDeclContext())) {
      return null;
    }
    throw new llvm_unreachable("unknown method context");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getClassInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 324,
   FQN="clang::ObjCMethodDecl::getClassInterface", NM="_ZNK5clang14ObjCMethodDecl17getClassInterfaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl17getClassInterfaceEv")
  //</editor-fold>
  public /*const*/ ObjCInterfaceDecl /*P*/ getClassInterface$Const() /*const*/ {
    return ((/*const_cast*/ObjCMethodDecl /*P*/ )(this)).getClassInterface();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 328,
   FQN="clang::ObjCMethodDecl::getSelector", NM="_ZNK5clang14ObjCMethodDecl11getSelectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl11getSelectorEv")
  //</editor-fold>
  public Selector getSelector() /*const*/ {
    return getDeclName().getObjCSelector();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 330,
   FQN="clang::ObjCMethodDecl::getReturnType", NM="_ZNK5clang14ObjCMethodDecl13getReturnTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl13getReturnTypeEv")
  //</editor-fold>
  public QualType getReturnType() /*const*/ {
    return new QualType(MethodDeclType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::setReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 331,
   FQN="clang::ObjCMethodDecl::setReturnType", NM="_ZN5clang14ObjCMethodDecl13setReturnTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl13setReturnTypeENS_8QualTypeE")
  //</editor-fold>
  public void setReturnType(QualType T) {
    MethodDeclType.$assign(T);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getReturnTypeSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1083,
   FQN="clang::ObjCMethodDecl::getReturnTypeSourceRange", NM="_ZNK5clang14ObjCMethodDecl24getReturnTypeSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl24getReturnTypeSourceRangeEv")
  //</editor-fold>
  public SourceRange getReturnTypeSourceRange() /*const*/ {
    /*const*/ TypeSourceInfo /*P*/ TSI = getReturnTypeSourceInfo();
    if ((TSI != null)) {
      return TSI.getTypeLoc().getSourceRange();
    }
    return new SourceRange();
  }

  
  /// \brief Determine the type of an expression that sends a message to this
  /// function. This replaces the type parameters with the types they would
  /// get if the receiver was parameterless (e.g. it may replace the type
  /// parameter with 'id').
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getSendResultType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1090,
   FQN="clang::ObjCMethodDecl::getSendResultType", NM="_ZNK5clang14ObjCMethodDecl17getSendResultTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl17getSendResultTypeEv")
  //</editor-fold>
  public QualType getSendResultType() /*const*/ {
    final ASTContext /*&*/ Ctx = getASTContext();
    return getReturnType().getNonLValueExprType(Ctx).
        substObjCTypeArgs(Ctx, /*{ */new ArrayRef<QualType>(false)/* }*/, ObjCSubstitutionContext.Result);
  }

  
  /// Determine the type of an expression that sends a message to this
  /// function with the given receiver type.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getSendResultType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1096,
   FQN="clang::ObjCMethodDecl::getSendResultType", NM="_ZNK5clang14ObjCMethodDecl17getSendResultTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl17getSendResultTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getSendResultType(QualType receiverType) /*const*/ {
    // FIXME: Handle related result types here.
    return getReturnType().getNonLValueExprType(getASTContext()).
        substObjCMemberType(new QualType(receiverType), getDeclContext$Const(), 
        ObjCSubstitutionContext.Result);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getReturnTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 344,
   FQN="clang::ObjCMethodDecl::getReturnTypeSourceInfo", NM="_ZNK5clang14ObjCMethodDecl23getReturnTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl23getReturnTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getReturnTypeSourceInfo() /*const*/ {
    return ReturnTInfo;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::setReturnTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 345,
   FQN="clang::ObjCMethodDecl::setReturnTypeSourceInfo", NM="_ZN5clang14ObjCMethodDecl23setReturnTypeSourceInfoEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl23setReturnTypeSourceInfoEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setReturnTypeSourceInfo(TypeSourceInfo /*P*/ TInfo) {
    ReturnTInfo = TInfo;
  }

  
  // Iterator access to formal parameters.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::param_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 348,
   FQN="clang::ObjCMethodDecl::param_size", NM="_ZNK5clang14ObjCMethodDecl10param_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl10param_sizeEv")
  //</editor-fold>
  public /*uint*/int param_size() /*const*/ {
    return NumParams;
  }

  /*typedef const ParmVarDecl *const *param_const_iterator*/
//  public final class param_const_iterator extends type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/>{ };
  /*typedef ParmVarDecl *const *param_iterator*/
//  public final class param_iterator extends type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/>{ };
  /*typedef llvm::iterator_range<param_iterator> param_range*/
//  public final class param_range extends iterator_range<ParmVarDecl /*P*/ /*const*/>{ };
  /*typedef llvm::iterator_range<param_const_iterator> param_const_range*/
//  public final class param_const_range extends iterator_range</*const*/ ParmVarDecl /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::param_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 354,
   FQN="clang::ObjCMethodDecl::param_begin", NM="_ZNK5clang14ObjCMethodDecl11param_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl11param_beginEv")
  //</editor-fold>
  public type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/> param_begin$Const() /*const*/ {
    return ((type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/>)(getParams$Const()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::param_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 357,
   FQN="clang::ObjCMethodDecl::param_end", NM="_ZNK5clang14ObjCMethodDecl9param_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl9param_endEv")
  //</editor-fold>
  public type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/> param_end$Const() /*const*/ {
    return ((type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/>)(getParams$Const().$add(NumParams)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::param_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 360,
   FQN="clang::ObjCMethodDecl::param_begin", NM="_ZN5clang14ObjCMethodDecl11param_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl11param_beginEv")
  //</editor-fold>
  public type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> param_begin() {
    return ((type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/>)(getParams()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::param_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 361,
   FQN="clang::ObjCMethodDecl::param_end", NM="_ZN5clang14ObjCMethodDecl9param_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl9param_endEv")
  //</editor-fold>
  public type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> param_end() {
    return ((type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/>)(getParams().$add(NumParams)));
  }

  
  // This method returns and of the parameters which are part of the selector
  // name mangling requirements.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::sel_param_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 365,
   FQN="clang::ObjCMethodDecl::sel_param_end", NM="_ZNK5clang14ObjCMethodDecl13sel_param_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl13sel_param_endEv")
  //</editor-fold>
  public type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/> sel_param_end() /*const*/ {
    return param_begin$Const().$add(getSelector().getNumArgs());
  }

  
  // ArrayRef access to formal parameters.  This should eventually
  // replace the iterator interface above.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::parameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 371,
   FQN="clang::ObjCMethodDecl::parameters", NM="_ZNK5clang14ObjCMethodDecl10parametersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl10parametersEv")
  //</editor-fold>
  public ArrayRef<ParmVarDecl /*P*/ > parameters() /*const*/ {
    return llvm.makeArrayRef(((/*const_cast*/type$ptr<ParmVarDecl /*P*/ /*P*/>)(getParams$Const())), 
        NumParams);
  }

  
  /// \brief Sets the method's parameters and selector source locations.
  /// If the method is implicit (not coming from source) \p SelLocs is
  /// ignored.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::setMethodParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 820,
   FQN="clang::ObjCMethodDecl::setMethodParams", NM="_ZN5clang14ObjCMethodDecl15setMethodParamsERNS_10ASTContextEN4llvm8ArrayRefIPNS_11ParmVarDeclEEENS4_INS_14SourceLocationEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl15setMethodParamsERNS_10ASTContextEN4llvm8ArrayRefIPNS_11ParmVarDeclEEENS4_INS_14SourceLocationEEE")
  //</editor-fold>
  public void setMethodParams(final ASTContext /*&*/ C, 
                 ArrayRef<ParmVarDecl /*P*/ > Params) {
    setMethodParams(C, 
                 Params, 
                 new ArrayRef<SourceLocation>(llvm.None, false));
  }
  public void setMethodParams(final ASTContext /*&*/ C, 
                 ArrayRef<ParmVarDecl /*P*/ > Params, 
                 ArrayRef<SourceLocation> SelLocs/*= llvm::None*/) {
    assert ((!SelLocs.empty() || isImplicit())) : "No selector locs for non-implicit method";
    if (isImplicit()) {
      setParamsAndSelLocs(C, new ArrayRef<ParmVarDecl /*P*/ >(Params), new ArrayRef<SourceLocation>(llvm.None, false));
      /*JAVA:return*/return;
    }
    
    SelLocsKind = $uint2uint_2bits(hasStandardSelectorLocsParmVarDecls(getSelector(), new ArrayRef<SourceLocation>(SelLocs), new ArrayRef<ParmVarDecl /*P*/ >(Params), 
        new SourceLocation(DeclEndLoc)).getValue());
    if (SelLocsKind != $int2uint_2bits(SelectorLocationsKind.SelLoc_NonStandard.getValue())) {
      setParamsAndSelLocs(C, new ArrayRef<ParmVarDecl /*P*/ >(Params), new ArrayRef<SourceLocation>(llvm.None, false));
      /*JAVA:return*/return;
    }
    
    setParamsAndSelLocs(C, new ArrayRef<ParmVarDecl /*P*/ >(Params), new ArrayRef<SourceLocation>(SelLocs));
  }

  
  // Iterator access to parameter types.
  /*typedef std::const_mem_fun_t<QualType, ParmVarDecl> deref_fun*/
//  public final class deref_fun extends std.const_mem_fun_t<QualType, ParmVarDecl>{ };
  /*typedef llvm::mapped_iterator<param_const_iterator, deref_fun> param_type_iterator*/
//  public final class param_type_iterator extends mapped_iterator<ParmVarDecl/*P*/, QualType>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::param_type_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 388,
   FQN="clang::ObjCMethodDecl::param_type_begin", NM="_ZNK5clang14ObjCMethodDecl16param_type_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl16param_type_beginEv")
  //</editor-fold>
  public mapped_iterator<ParmVarDecl/*P*/, QualType> param_type_begin() /*const*/ {
    return llvm.map_iterator(param_begin$Const(), /*FuncArg*//*AddrOf*//*FPtr*/ParmVarDecl::getType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::param_type_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 391,
   FQN="clang::ObjCMethodDecl::param_type_end", NM="_ZNK5clang14ObjCMethodDecl14param_type_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl14param_type_endEv")
  //</editor-fold>
  public mapped_iterator<ParmVarDecl/*P*/, QualType> param_type_end() /*const*/ {
    return llvm.map_iterator(param_end$Const(), /*FuncArg*//*AddrOf*//*FPtr*/ParmVarDecl::getType);
  }

  
  /// createImplicitParams - Used to lazily create the self and cmd
  /// implict parameters. This must be called prior to using getSelfDecl()
  /// or getCmdDecl(). The call is ignored if the implicit paramters
  /// have already been created.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::createImplicitParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1050,
   FQN="clang::ObjCMethodDecl::createImplicitParams", NM="_ZN5clang14ObjCMethodDecl20createImplicitParamsERNS_10ASTContextEPKNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl20createImplicitParamsERNS_10ASTContextEPKNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  public void createImplicitParams(final ASTContext /*&*/ Context, 
                      /*const*/ ObjCInterfaceDecl /*P*/ OID) {
    bool$ref selfIsPseudoStrong = create_bool$ref();
    bool$ref selfIsConsumed = create_bool$ref();
    QualType selfTy = getSelfType(Context, OID, selfIsPseudoStrong, selfIsConsumed);
    ImplicitParamDecl /*P*/ self = ImplicitParamDecl.Create(Context, this, new SourceLocation(), 
        $AddrOf(Context.Idents.get(new StringRef(/*KEEP_STR*/"self"))), new QualType(selfTy));
    setSelfDecl(self);
    if (selfIsConsumed.$deref()) {
      self.addAttr(NSConsumedAttr.CreateImplicit(Context));
    }
    if (selfIsPseudoStrong.$deref()) {
      self.setARCPseudoStrong(true);
    }
    
    setCmdDecl(ImplicitParamDecl.Create(Context, this, new SourceLocation(), 
            $AddrOf(Context.Idents.get(new StringRef(/*KEEP_STR*/"_cmd"))), 
            Context.getObjCSelType()));
  }

  
  /// \return the type for \c self and set \arg selfIsPseudoStrong and
  /// \arg selfIsConsumed accordingly.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getSelfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1005,
   FQN="clang::ObjCMethodDecl::getSelfType", NM="_ZN5clang14ObjCMethodDecl11getSelfTypeERNS_10ASTContextEPKNS_17ObjCInterfaceDeclERbS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl11getSelfTypeERNS_10ASTContextEPKNS_17ObjCInterfaceDeclERbS6_")
  //</editor-fold>
  public QualType getSelfType(final ASTContext /*&*/ Context, 
             /*const*/ ObjCInterfaceDecl /*P*/ OID, 
             final bool$ref/*bool &*/ selfIsPseudoStrong, 
             final bool$ref/*bool &*/ selfIsConsumed) {
    QualType selfTy/*J*/= new QualType();
    selfIsPseudoStrong.$set(false);
    selfIsConsumed.$set(false);
    if (isInstanceMethod()) {
      // There may be no interface context due to error in declaration
      // of the interface (which has been reported). Recover gracefully.
      if ((OID != null)) {
        selfTy.$assignMove(Context.getObjCInterfaceType(OID));
        selfTy.$assignMove(Context.getObjCObjectPointerType(new QualType(selfTy)));
      } else {
        selfTy.$assignMove(Context.getObjCIdType());
      }
    } else { // we have a factory method.
      selfTy.$assignMove(Context.getObjCClassType());
    }
    if (Context.getLangOpts().ObjCAutoRefCount) {
      if (isInstanceMethod()) {
        selfIsConsumed.$set(hasAttr(NSConsumesSelfAttr.class));
        
        // 'self' is always __strong.  It's actually pseudo-strong except
        // in init methods (or methods labeled ns_consumes_self), though.
        Qualifiers qs/*J*/= new Qualifiers();
        qs.setObjCLifetime(Qualifiers.ObjCLifetime.OCL_Strong);
        selfTy.$assignMove(Context.getQualifiedType(new QualType(selfTy), new Qualifiers(qs)));
        
        // In addition, 'self' is const unless this is an init method.
        if (getMethodFamily() != ObjCMethodFamily.OMF_init && !selfIsConsumed.$deref()) {
          selfTy.$assignMove(selfTy.withConst());
          selfIsPseudoStrong.$set(true);
        }
      } else {
        assert (isClassMethod());
        // 'self' is always const in class methods.
        selfTy.$assignMove(selfTy.withConst());
        selfIsPseudoStrong.$set(true);
      }
    }
    return selfTy;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getSelfDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 406,
   FQN="clang::ObjCMethodDecl::getSelfDecl", NM="_ZNK5clang14ObjCMethodDecl11getSelfDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl11getSelfDeclEv")
  //</editor-fold>
  public ImplicitParamDecl /*P*/ getSelfDecl() /*const*/ {
    return SelfDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::setSelfDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 407,
   FQN="clang::ObjCMethodDecl::setSelfDecl", NM="_ZN5clang14ObjCMethodDecl11setSelfDeclEPNS_17ImplicitParamDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl11setSelfDeclEPNS_17ImplicitParamDeclE")
  //</editor-fold>
  public void setSelfDecl(ImplicitParamDecl /*P*/ SD) {
    SelfDecl = SD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getCmdDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 408,
   FQN="clang::ObjCMethodDecl::getCmdDecl", NM="_ZNK5clang14ObjCMethodDecl10getCmdDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl10getCmdDeclEv")
  //</editor-fold>
  public ImplicitParamDecl /*P*/ getCmdDecl() /*const*/ {
    return CmdDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::setCmdDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 409,
   FQN="clang::ObjCMethodDecl::setCmdDecl", NM="_ZN5clang14ObjCMethodDecl10setCmdDeclEPNS_17ImplicitParamDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl10setCmdDeclEPNS_17ImplicitParamDeclE")
  //</editor-fold>
  public void setCmdDecl(ImplicitParamDecl /*P*/ CD) {
    CmdDecl = CD;
  }

  
  /// Determines the family of this method.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getMethodFamily">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 913,
   FQN="clang::ObjCMethodDecl::getMethodFamily", NM="_ZNK5clang14ObjCMethodDecl15getMethodFamilyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl15getMethodFamilyEv")
  //</editor-fold>
  public ObjCMethodFamily getMethodFamily() /*const*/ {
    ObjCMethodFamily family = /*static_cast*/ObjCMethodFamily.valueOf(Family);
    if (family.getValue() != ((/*static_cast*//*uint*/int)(InvalidObjCMethodFamily))) {
      return family;
    }
    {
      
      // Check for an explicit attribute.
      /*const*/ ObjCMethodFamilyAttr /*P*/ attr = getAttr(ObjCMethodFamilyAttr.class);
      if ((attr != null)) {
        // The unfortunate necessity of mapping between enums here is due
        // to the attributes framework.
        switch (attr.getFamily()) {
         case OMF_None:
          family = ObjCMethodFamily.OMF_None;
          break;
         case OMF_alloc:
          family = ObjCMethodFamily.OMF_alloc;
          break;
         case OMF_copy:
          family = ObjCMethodFamily.OMF_copy;
          break;
         case OMF_init:
          family = ObjCMethodFamily.OMF_init;
          break;
         case OMF_mutableCopy:
          family = ObjCMethodFamily.OMF_mutableCopy;
          break;
         case OMF_new:
          family = ObjCMethodFamily.OMF_new;
          break;
        }
        Family = $uint2uint_4bits(((/*static_cast*//*uint*/int)(family.getValue())));
        return family;
      }
    }
    
    family = getSelector().getMethodFamily();
    switch (family) {
     case OMF_None:
      break;
     case OMF_init:
      
      // init only has a conventional meaning for an instance method, and
      // it has to return an object.
      if (!isInstanceMethod() || !getReturnType().$arrow().isObjCObjectPointerType()) {
        family = ObjCMethodFamily.OMF_None;
      }
      break;
     case OMF_alloc:
     case OMF_copy:
     case OMF_mutableCopy:
     case OMF_new:
      
      // alloc/copy/new have a conventional meaning for both class and
      // instance methods, but they require an object return.
      if (!getReturnType().$arrow().isObjCObjectPointerType()) {
        family = ObjCMethodFamily.OMF_None;
      }
      break;
     case OMF_dealloc:
     case OMF_finalize:
     case OMF_retain:
     case OMF_release:
     case OMF_autorelease:
     case OMF_retainCount:
     case OMF_self:
      
      // These selectors have a conventional meaning only for instance methods.
      if (!isInstanceMethod()) {
        family = ObjCMethodFamily.OMF_None;
      }
      break;
     case OMF_initialize:
      if (isInstanceMethod() || !getReturnType().$arrow().isVoidType()) {
        family = ObjCMethodFamily.OMF_None;
      }
      break;
     case OMF_performSelector:
      if (!isInstanceMethod() || !getReturnType().$arrow().isObjCIdType()) {
        family = ObjCMethodFamily.OMF_None;
      } else {
        /*uint*/int noParams = param_size();
        if ($less_uint(noParams, 1) || $greater_uint(noParams, 3)) {
          family = ObjCMethodFamily.OMF_None;
        } else {
          mapped_iterator<ParmVarDecl/*P*/, QualType> it = param_type_begin();
          QualType ArgT = (it.$star());
          if (!ArgT.$arrow().isObjCSelType()) {
            family = ObjCMethodFamily.OMF_None;
            break;
          }
          while ((--noParams != 0)) {
            it.$postInc(0);
            ArgT.$assignMove((it.$star()));
            if (!ArgT.$arrow().isObjCIdType()) {
              family = ObjCMethodFamily.OMF_None;
              break;
            }
          }
        }
      }
      break;
    }
    
    // Cache the result.
    Family = $uint2uint_4bits(((/*static_cast*//*uint*/int)(family.getValue())));
    return family;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::isInstanceMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 414,
   FQN="clang::ObjCMethodDecl::isInstanceMethod", NM="_ZNK5clang14ObjCMethodDecl16isInstanceMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl16isInstanceMethodEv")
  //</editor-fold>
  public boolean isInstanceMethod() /*const*/ {
    return IsInstance;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::setInstanceMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 415,
   FQN="clang::ObjCMethodDecl::setInstanceMethod", NM="_ZN5clang14ObjCMethodDecl17setInstanceMethodEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl17setInstanceMethodEb")
  //</editor-fold>
  public void setInstanceMethod(boolean isInst) {
    IsInstance = isInst;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::isVariadic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 416,
   FQN="clang::ObjCMethodDecl::isVariadic", NM="_ZNK5clang14ObjCMethodDecl10isVariadicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl10isVariadicEv")
  //</editor-fold>
  public boolean isVariadic() /*const*/ {
    return IsVariadic;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::setVariadic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 417,
   FQN="clang::ObjCMethodDecl::setVariadic", NM="_ZN5clang14ObjCMethodDecl11setVariadicEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl11setVariadicEb")
  //</editor-fold>
  public void setVariadic(boolean isVar) {
    IsVariadic = isVar;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::isClassMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 419,
   FQN="clang::ObjCMethodDecl::isClassMethod", NM="_ZNK5clang14ObjCMethodDecl13isClassMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl13isClassMethodEv")
  //</editor-fold>
  public boolean isClassMethod() /*const*/ {
    return !IsInstance;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::isPropertyAccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 421,
   FQN="clang::ObjCMethodDecl::isPropertyAccessor", NM="_ZNK5clang14ObjCMethodDecl18isPropertyAccessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl18isPropertyAccessorEv")
  //</editor-fold>
  public boolean isPropertyAccessor() /*const*/ {
    return IsPropertyAccessor;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::setPropertyAccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 422,
   FQN="clang::ObjCMethodDecl::setPropertyAccessor", NM="_ZN5clang14ObjCMethodDecl19setPropertyAccessorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl19setPropertyAccessorEb")
  //</editor-fold>
  public void setPropertyAccessor(boolean isAccessor) {
    IsPropertyAccessor = isAccessor;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::isDefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 424,
   FQN="clang::ObjCMethodDecl::isDefined", NM="_ZNK5clang14ObjCMethodDecl9isDefinedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl9isDefinedEv")
  //</editor-fold>
  public boolean isDefined() /*const*/ {
    return IsDefined;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::setDefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 425,
   FQN="clang::ObjCMethodDecl::setDefined", NM="_ZN5clang14ObjCMethodDecl10setDefinedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl10setDefinedEb")
  //</editor-fold>
  public void setDefined(boolean isDefined) {
    IsDefined = isDefined;
  }

  
  /// \brief Whether this method overrides any other in the class hierarchy.
  ///
  /// A method is said to override any method in the class's
  /// base classes, its protocols, or its categories' protocols, that has
  /// the same selector and is of the same kind (class or instance).
  /// A method in an implementation is not considered as overriding the same
  /// method in the interface or its categories.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::isOverriding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 434,
   FQN="clang::ObjCMethodDecl::isOverriding", NM="_ZNK5clang14ObjCMethodDecl12isOverridingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl12isOverridingEv")
  //</editor-fold>
  public boolean isOverriding() /*const*/ {
    return IsOverriding;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::setOverriding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 435,
   FQN="clang::ObjCMethodDecl::setOverriding", NM="_ZN5clang14ObjCMethodDecl13setOverridingEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl13setOverridingEb")
  //</editor-fold>
  public void setOverriding(boolean isOverriding) {
    IsOverriding = isOverriding;
  }

  
  /// \brief Return overridden methods for the given \p Method.
  ///
  /// An ObjC method is considered to override any method in the class's
  /// base classes (and base's categories), its protocols, or its categories'
  /// protocols, that has
  /// the same selector and is of the same kind (class or instance).
  /// A method in an implementation is not considered as overriding the same
  /// method in the interface or its categories.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getOverriddenMethods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1214,
   FQN="clang::ObjCMethodDecl::getOverriddenMethods", NM="_ZNK5clang14ObjCMethodDecl20getOverriddenMethodsERN4llvm15SmallVectorImplIPKS0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl20getOverriddenMethodsERN4llvm15SmallVectorImplIPKS0_EE")
  //</editor-fold>
  public void getOverriddenMethods(final SmallVectorImpl</*const*/ ObjCMethodDecl /*P*/ > /*&*/ Overridden) /*const*/ {
    /*const*/ ObjCMethodDecl /*P*/ Method = this;
    if (Method.isRedeclaration()) {
      Method = cast_ObjCContainerDecl(Method.getDeclContext$Const()).
          getMethod(Method.getSelector(), Method.isInstanceMethod());
    }
    if (Method.isOverriding()) {
      collectOverriddenMethodsSlow(Method, Overridden);
      assert (!Overridden.empty()) : "ObjCMethodDecl's overriding bit is not as expected";
    }
  }

  
  /// \brief True if the method was a definition but its body was skipped.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::hasSkippedBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 449,
   FQN="clang::ObjCMethodDecl::hasSkippedBody", NM="_ZNK5clang14ObjCMethodDecl14hasSkippedBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl14hasSkippedBodyEv")
  //</editor-fold>
  public boolean hasSkippedBody() /*const*/ {
    return HasSkippedBody;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::setHasSkippedBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 450,
   FQN="clang::ObjCMethodDecl::setHasSkippedBody", NM="_ZN5clang14ObjCMethodDecl17setHasSkippedBodyEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl17setHasSkippedBodyEb")
  //</editor-fold>
  public void setHasSkippedBody() {
    setHasSkippedBody(true);
  }
  public void setHasSkippedBody(boolean Skipped/*= true*/) {
    HasSkippedBody = Skipped;
  }

  
  /// \brief Returns the property associated with this method's selector.
  ///
  /// Note that even if this particular method is not marked as a property
  /// accessor, it is still possible for it to match a property declared in a
  /// superclass. Pass \c false if you only want to check the current class.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::findPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1230,
   FQN="clang::ObjCMethodDecl::findPropertyDecl", NM="_ZNK5clang14ObjCMethodDecl16findPropertyDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl16findPropertyDeclEb")
  //</editor-fold>
  public /*const*/ ObjCPropertyDecl /*P*/ findPropertyDecl() /*const*/ {
    return findPropertyDecl(true);
  }
  public /*const*/ ObjCPropertyDecl /*P*/ findPropertyDecl(boolean CheckOverrides/*= true*/) /*const*/ {
    Selector Sel = getSelector();
    /*uint*/int NumArgs = Sel.getNumArgs();
    if ($greater_uint(NumArgs, 1)) {
      return null;
    }
    if (isPropertyAccessor()) {
      /*const*/ ObjCContainerDecl /*P*/ Container = cast_ObjCContainerDecl(getParent$Const());
      boolean IsGetter = (NumArgs == 0);
      boolean IsInstance = isInstanceMethod();
      
      /// Local function that attempts to find a matching property within the
      /// given Objective-C container.
      ObjCPropertyDecl2ObjCContainerDecl findMatchingProperty = /*[&, &IsInstance, &IsGetter, &Sel]*/ (/*const*/ ObjCContainerDecl /*P*/ Container$1) -> {
            if (IsInstance) {
              for (/*const*/ ObjCPropertyDecl /*P*/ I : Container$1.instance_properties()) {
                Selector NextSel = IsGetter ? I.getGetterName() : I.getSetterName();
                if (NextSel.$eq(/*NO_COPY*/Sel)) {
                  return I;
                }
              }
            } else {
              for (/*const*/ ObjCPropertyDecl /*P*/ I : Container$1.class_properties()) {
                Selector NextSel = IsGetter ? I.getGetterName() : I.getSetterName();
                if (NextSel.$eq(/*NO_COPY*/Sel)) {
                  return I;
                }
              }
            }
            
            return null;
          };
      {
        
        // Look in the container we were given.
        /*const*/ ObjCPropertyDecl /*P*/ Found = findMatchingProperty.$call(Container);
        if ((Found != null)) {
          return Found;
        }
      }
      
      // If we're in a category or extension, look in the main class.
      /*const*/ ObjCInterfaceDecl /*P*/ ClassDecl = null;
      {
        /*const*/ ObjCCategoryDecl /*P*/ Category = dyn_cast_ObjCCategoryDecl(Container);
        if ((Category != null)) {
          ClassDecl = Category.getClassInterface$Const();
          {
            /*const*/ ObjCPropertyDecl /*P*/ Found = findMatchingProperty.$call(ClassDecl);
            if ((Found != null)) {
              return Found;
            }
          }
        } else {
          // Determine whether the container is a class.
          ClassDecl = dyn_cast_ObjCInterfaceDecl(Container);
        }
      }
      
      // If we have a class, check its visible extensions.
      if ((ClassDecl != null)) {
        for (/*const*/ ObjCCategoryDecl /*P*/ Ext : ClassDecl.visible_extensions()) {
          if (Ext == Container) {
            continue;
          }
          {
            
            /*const*/ ObjCPropertyDecl /*P*/ Found = findMatchingProperty.$call(Ext);
            if ((Found != null)) {
              return Found;
            }
          }
        }
      }
      throw new llvm_unreachable("Marked as a property accessor but no property found!");
    }
    if (!CheckOverrides) {
      return null;
    }
    
    /*typedef SmallVector<const ObjCMethodDecl *, 8> OverridesTy*/
//    final class OverridesTy extends SmallVector</*const*/ ObjCMethodDecl /*P*/ >{ };
    SmallVector</*const*/ ObjCMethodDecl /*P*/ > Overrides/*J*/= new SmallVector</*const*/ ObjCMethodDecl /*P*/ >(8, (/*const*/ ObjCMethodDecl /*P*/ )null);
    getOverriddenMethods(Overrides);
    for (type$ptr</*const*/ ObjCMethodDecl /*P*/ /*const*/ /*P*/> I = $tryClone(Overrides.begin()), /*P*/ E = $tryClone(Overrides.end());
         $noteq_ptr(I, E); I.$preInc()) {
      {
        /*const*/ ObjCPropertyDecl /*P*/ Prop = (I.$star()).findPropertyDecl(false);
        if ((Prop != null)) {
          return Prop;
        }
      }
    }
    
    return null;
  }

  
  // Related to protocols declared in  \@protocol
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::setDeclImplementation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 460,
   FQN="clang::ObjCMethodDecl::setDeclImplementation", NM="_ZN5clang14ObjCMethodDecl21setDeclImplementationENS0_21ImplementationControlE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl21setDeclImplementationENS0_21ImplementationControlE")
  //</editor-fold>
  public void setDeclImplementation(ImplementationControl ic) {
    DeclImplementation = $uint2uint_2bits(ic.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getImplementationControl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 463,
   FQN="clang::ObjCMethodDecl::getImplementationControl", NM="_ZNK5clang14ObjCMethodDecl24getImplementationControlEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl24getImplementationControlEv")
  //</editor-fold>
  public ImplementationControl getImplementationControl() /*const*/ {
    return ImplementationControl.valueOf(DeclImplementation);
  }

  
  /// Returns true if this specific method declaration is marked with the
  /// designated initializer attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::isThisDeclarationADesignatedInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 767,
   FQN="clang::ObjCMethodDecl::isThisDeclarationADesignatedInitializer", NM="_ZNK5clang14ObjCMethodDecl39isThisDeclarationADesignatedInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl39isThisDeclarationADesignatedInitializerEv")
  //</editor-fold>
  public boolean isThisDeclarationADesignatedInitializer() /*const*/ {
    return getMethodFamily() == ObjCMethodFamily.OMF_init
       && hasAttr(ObjCDesignatedInitializerAttr.class);
  }

  
  /// Returns true if the method selector resolves to a designated initializer
  /// in the class's interface.
  ///
  /// \param InitMethod if non-null and the function returns true, it receives
  /// the method declaration that was marked with the designated initializer
  /// attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::isDesignatedInitializerForTheInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 772,
   FQN="clang::ObjCMethodDecl::isDesignatedInitializerForTheInterface", NM="_ZNK5clang14ObjCMethodDecl38isDesignatedInitializerForTheInterfaceEPPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl38isDesignatedInitializerForTheInterfaceEPPKS0_")
  //</editor-fold>
  public boolean isDesignatedInitializerForTheInterface() /*const*/ {
    return isDesignatedInitializerForTheInterface((type$ptr</*const*/ ObjCMethodDecl /*P*/ /*P*/>)null);
  }
  public boolean isDesignatedInitializerForTheInterface(type$ptr</*const*/ ObjCMethodDecl /*P*/ /*P*/> InitMethod/*= null*/) /*const*/ {
    if (getMethodFamily() != ObjCMethodFamily.OMF_init) {
      return false;
    }
    /*const*/ DeclContext /*P*/ DC = getDeclContext$Const();
    if (isa_ObjCProtocolDecl(DC)) {
      return false;
    }
    {
      /*const*/ ObjCInterfaceDecl /*P*/ ID = getClassInterface$Const();
      if ((ID != null)) {
        return ID.isDesignatedInitializer(getSelector(), InitMethod);
      }
    }
    return false;
  }

  
  /// \brief Determine whether this method has a body.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::hasBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 481,
   FQN="clang::ObjCMethodDecl::hasBody", NM="_ZNK5clang14ObjCMethodDecl7hasBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl7hasBodyEv")
  //</editor-fold>
  @Override public boolean hasBody() /*const*//* override*/ {
    return Body.isValid();
  }

  
  /// \brief Retrieve the body of this method, if it has one.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 784,
   FQN="clang::ObjCMethodDecl::getBody", NM="_ZNK5clang14ObjCMethodDecl7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl7getBodyEv")
  //</editor-fold>
  @Override public Stmt /*P*/ getBody() /*const*//* override*/ {
    return Body.get(getASTContext().getExternalSource());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::setLazyBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 486,
   FQN="clang::ObjCMethodDecl::setLazyBody", NM="_ZN5clang14ObjCMethodDecl11setLazyBodyEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl11setLazyBodyEy")
  //</editor-fold>
  public void setLazyBody(long/*uint64_t*/ Offset) {
    Body.$assign(Offset);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::getCompoundBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 488,
   FQN="clang::ObjCMethodDecl::getCompoundBody", NM="_ZN5clang14ObjCMethodDecl15getCompoundBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl15getCompoundBodyEv")
  //</editor-fold>
  public CompoundStmt /*P*/ getCompoundBody() {
    return (CompoundStmt /*P*/ )getBody();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::setBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 489,
   FQN="clang::ObjCMethodDecl::setBody", NM="_ZN5clang14ObjCMethodDecl7setBodyEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl7setBodyEPNS_4StmtE")
  //</editor-fold>
  public void setBody(Stmt /*P*/ B) {
    Body.$assign(B);
  }

  
  /// \brief Returns whether this specific method is a definition.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::isThisDeclarationADefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 492,
   FQN="clang::ObjCMethodDecl::isThisDeclarationADefinition", NM="_ZNK5clang14ObjCMethodDecl28isThisDeclarationADefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang14ObjCMethodDecl28isThisDeclarationADefinitionEv")
  //</editor-fold>
  public boolean isThisDeclarationADefinition() /*const*/ {
    return hasBody();
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 495,
   FQN="clang::ObjCMethodDecl::classof", NM="_ZN5clang14ObjCMethodDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 496,
   FQN="clang::ObjCMethodDecl::classofKind", NM="_ZN5clang14ObjCMethodDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.ObjCMethod;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::castToDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 497,
   FQN="clang::ObjCMethodDecl::castToDeclContext", NM="_ZN5clang14ObjCMethodDecl17castToDeclContextEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl17castToDeclContextEPKS0_")
  //</editor-fold>
  public static DeclContext /*P*/ castToDeclContext(/*const*/ ObjCMethodDecl /*P*/ D) {
    return ((/*static_cast*/DeclContext /*P*/ )(((/*const_cast*/ObjCMethodDecl /*P*/ )(D))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::castFromDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 500,
   FQN="clang::ObjCMethodDecl::castFromDeclContext", NM="_ZN5clang14ObjCMethodDecl19castFromDeclContextEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDecl19castFromDeclContextEPKNS_11DeclContextE")
  //</editor-fold>
  public static ObjCMethodDecl /*P*/ castFromDeclContext(/*const*/ DeclContext /*P*/ DC) {
    return ((/*static_cast*/ObjCMethodDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(DC))));
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodDecl::~ObjCMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 113,
   FQN="clang::ObjCMethodDecl::~ObjCMethodDecl", NM="_ZN5clang14ObjCMethodDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang14ObjCMethodDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    DeclContext.super.$destroy$DeclContext();
  }

  
  private final DeclContext$Fields DeclContext$Flds;// use return value of $DeclContext();
  @Override public final DeclContext$Fields $DeclContext$Fields() { return DeclContext$Flds; }
  
  @Override public String toString() {
    return "" + "Family=" + $uchar2uint(Family) // NOI18N
              + ", IsInstance=" + IsInstance // NOI18N
              + ", IsVariadic=" + IsVariadic // NOI18N
              + ", IsPropertyAccessor=" + IsPropertyAccessor // NOI18N
              + ", IsDefined=" + IsDefined // NOI18N
              + ", IsRedeclaration=" + IsRedeclaration // NOI18N
              + ", HasRedeclaration=" + HasRedeclaration // NOI18N
              + ", DeclImplementation=" + $uchar2uint(DeclImplementation) // NOI18N
              + ", objcDeclQualifier=" + $uchar2uint(objcDeclQualifier) // NOI18N
              + ", RelatedResultType=" + RelatedResultType // NOI18N
              + ", SelLocsKind=" + $uchar2uint(SelLocsKind) // NOI18N
              + ", IsOverriding=" + IsOverriding // NOI18N
              + ", HasSkippedBody=" + HasSkippedBody // NOI18N
              + ", MethodDeclType=" + MethodDeclType // NOI18N
              + ", ReturnTInfo=" + ReturnTInfo // NOI18N
              + ", ParamsAndSelLocs=" + ParamsAndSelLocs // NOI18N
              + ", NumParams=" + NumParams // NOI18N
              + ", DeclEndLoc=" + DeclEndLoc // NOI18N
              + ", Body=" + Body // NOI18N
              + ", SelfDecl=" + SelfDecl // NOI18N
              + ", CmdDecl=" + CmdDecl // NOI18N
              + super.toString(); // NOI18N
  }
}
