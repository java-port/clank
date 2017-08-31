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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;
import static org.clang.ast.ASTContextGlobals.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.ast.DeclContext.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.ObjCInterfaceDecl.filtered_category_iterator.*;
import static org.clang.ast.impl.DeclObjCStatics.*;


/// \brief Represents an ObjC class declaration.
///
/// For example:
///
/// \code
///   // MostPrimitive declares no super class (not particularly useful).
///   \@interface MostPrimitive
///     // no instance variables or methods.
///   \@end
///
///   // NSResponder inherits from NSObject & implements NSCoding (a protocol).
///   \@interface NSResponder : NSObject \<NSCoding>
///   { // instance variables are represented by ObjCIvarDecl.
///     id nextResponder; // nextResponder instance variable.
///   }
///   - (NSResponder *)nextResponder; // return a pointer to NSResponder.
///   - (void)mouseMoved:(NSEvent *)theEvent; // return void, takes a pointer
///   \@end                                    // to an NSEvent.
/// \endcode
///
///   Unlike C/C++, forward class declarations are accomplished with \@class.
///   Unlike C/C++, \@class allows for a list of classes to be forward declared.
///   Unlike C++, ObjC is a single-rooted class model. In Cocoa, classes
///   typically inherit from NSObject (an exception is NSProxy).
///
//<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1091,
 FQN="clang::ObjCInterfaceDecl", NM="_ZN5clang17ObjCInterfaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDeclE")
//</editor-fold>
public class ObjCInterfaceDecl extends /*public*/ ObjCContainerDecl implements /*public*/ Redeclarable<ObjCInterfaceDecl>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 283,
   FQN="clang::ObjCInterfaceDecl::anchor", NM="_ZN5clang17ObjCInterfaceDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  /// TypeForDecl - This indicates the Type object that represents this
  /// TypeDecl.  It is a cache maintained by ASTContext::getObjCInterfaceType
  /*friend*/public/*private*/ /*mutable *//*const*/ Type /*P*/ TypeForDecl;
  /*friend  class ASTContext*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::DefinitionData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1100,
   FQN="clang::ObjCInterfaceDecl::DefinitionData", NM="_ZN5clang17ObjCInterfaceDecl14DefinitionDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl14DefinitionDataE")
  //</editor-fold>
  public/*private*/ static class/*struct*/ DefinitionData {
    /// \brief The definition of this class, for quick access from any 
    /// declaration.
    public ObjCInterfaceDecl /*P*/ Definition;
    
    /// When non-null, this is always an ObjCObjectType.
    public TypeSourceInfo /*P*/ SuperClassTInfo;
    
    /// Protocols referenced in the \@interface  declaration
    public ObjCProtocolList ReferencedProtocols;
    
    /// Protocols reference in both the \@interface and class extensions.
    public ObjCList<ObjCProtocolDecl> AllReferencedProtocols;
    
    /// \brief List of categories and class extensions defined for this class.
    ///
    /// Categories are stored as a linked list in the AST, since the categories
    /// and class extensions come long after the initial interface declaration,
    /// and we avoid dynamically-resized arrays in the AST wherever possible.
    public ObjCCategoryDecl /*P*/ CategoryList;
    
    /// IvarList - List of all ivars defined by this class; including class
    /// extensions and implementation. This list is built lazily.
    public ObjCIvarDecl /*P*/ IvarList;
    
    /// \brief Indicates that the contents of this Objective-C class will be
    /// completed by the external AST source when required.
    public /*mutable *//*JBIT unsigned int*/ boolean ExternallyCompleted /*: 1*/;
    
    /// \brief Indicates that the ivar cache does not yet include ivars
    /// declared in the implementation.
    public /*mutable *//*JBIT unsigned int*/ boolean IvarListMissingImplementation /*: 1*/;
    
    /// Indicates that this interface decl contains at least one initializer
    /// marked with the 'objc_designated_initializer' attribute.
    public /*JBIT unsigned int*/ boolean HasDesignatedInitializers /*: 1*/;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::DefinitionData::InheritedDesignatedInitializersState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1137,
     FQN="clang::ObjCInterfaceDecl::DefinitionData::InheritedDesignatedInitializersState", NM="_ZN5clang17ObjCInterfaceDecl14DefinitionData36InheritedDesignatedInitializersStateE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl14DefinitionData36InheritedDesignatedInitializersStateE")
    //</editor-fold>
    public enum InheritedDesignatedInitializersState implements Native.ComparableLower {
      /// We didn't calculate whether the designated initializers should be
      /// inherited or not.
      IDI_Unknown(0),
      /// Designated initializers are inherited for the super class.
      IDI_Inherited(1),
      /// The class does not inherit designated initializers.
      IDI_NotInherited(2);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static InheritedDesignatedInitializersState valueOf(int val) {
        InheritedDesignatedInitializersState out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final InheritedDesignatedInitializersState[] VALUES;
        private static final InheritedDesignatedInitializersState[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (InheritedDesignatedInitializersState kind : InheritedDesignatedInitializersState.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new InheritedDesignatedInitializersState[min < 0 ? (1-min) : 0];
          VALUES = new InheritedDesignatedInitializersState[max >= 0 ? (1+max) : 0];
          for (InheritedDesignatedInitializersState kind : InheritedDesignatedInitializersState.values()) {
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
      private InheritedDesignatedInitializersState(int val) { this.value = (/*uint*/int)val;}
      public /*uint*/int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((InheritedDesignatedInitializersState)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((InheritedDesignatedInitializersState)obj).value);}
      //</editor-fold>
    };
    /// One of the \c InheritedDesignatedInitializersState enumeratos.
    public /*mutable *//*JBYTE unsigned int*/ byte InheritedDesignatedInitializers /*: 2*/;
    
    /// \brief The location of the last location in this declaration, before
    /// the properties/methods. For example, this will be the '>', '}', or 
    /// identifier, 
    public SourceLocation EndLoc;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::DefinitionData::DefinitionData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1154,
     FQN="clang::ObjCInterfaceDecl::DefinitionData::DefinitionData", NM="_ZN5clang17ObjCInterfaceDecl14DefinitionDataC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl14DefinitionDataC1Ev")
    //</editor-fold>
    public DefinitionData() {
      // : Definition(implicit ObjCInterfaceDecl * ()), SuperClassTInfo(implicit TypeSourceInfo * ()), ReferencedProtocols(), AllReferencedProtocols(), CategoryList(implicit ObjCCategoryDecl * ()), IvarList(implicit ObjCIvarDecl * ()), ExternallyCompleted(implicit unsigned int()), IvarListMissingImplementation(true), HasDesignatedInitializers(implicit unsigned int()), InheritedDesignatedInitializers(IDI_Unknown), EndLoc() 
      //START JInit
      this.Definition = /*implicit-init*/((ObjCInterfaceDecl /*P*/ )/*zero-init*/null);
      this.SuperClassTInfo = /*implicit-init*/((TypeSourceInfo /*P*/ )/*zero-init*/null);
      this.ReferencedProtocols = new ObjCProtocolList();
      this.AllReferencedProtocols = new ObjCList<ObjCProtocolDecl>();
      this.CategoryList = /*implicit-init*/((ObjCCategoryDecl /*P*/ )/*zero-init*/null);
      this.IvarList = /*implicit-init*/((ObjCIvarDecl /*P*/ )/*zero-init*/null);
      this.ExternallyCompleted = $uint2uint_1bit(/*implicit-init*/((/*uint*/int)/*zero-init*/0));
      this.IvarListMissingImplementation = true;
      this.HasDesignatedInitializers = $uint2uint_1bit(/*implicit-init*/((/*uint*/int)/*zero-init*/0));
      this.InheritedDesignatedInitializers = $uint2uint_2bits(InheritedDesignatedInitializersState.IDI_Unknown.getValue());
      this.EndLoc = new SourceLocation();
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Definition=" + Definition // NOI18N
                + ", SuperClassTInfo=" + SuperClassTInfo // NOI18N
                + ", ReferencedProtocols=" + ReferencedProtocols // NOI18N
                + ", AllReferencedProtocols=" + AllReferencedProtocols // NOI18N
                + ", CategoryList=" + CategoryList // NOI18N
                + ", IvarList=" + IvarList // NOI18N
                + ", ExternallyCompleted=" + ExternallyCompleted // NOI18N
                + ", IvarListMissingImplementation=" + IvarListMissingImplementation // NOI18N
                + ", HasDesignatedInitializers=" + HasDesignatedInitializers // NOI18N
                + ", InheritedDesignatedInitializers=" + $uchar2uint(InheritedDesignatedInitializers) // NOI18N
                + ", EndLoc=" + EndLoc; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::ObjCInterfaceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1412,
   FQN="clang::ObjCInterfaceDecl::ObjCInterfaceDecl", NM="_ZN5clang17ObjCInterfaceDeclC1ERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoEPNS_17ObjCTypeParamListES6_PS0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDeclC1ERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoEPNS_17ObjCTypeParamListES6_PS0_b")
  //</editor-fold>
  private ObjCInterfaceDecl(final /*const*/ ASTContext /*&*/ C, DeclContext /*P*/ DC, 
      SourceLocation AtLoc, IdentifierInfo /*P*/ Id, 
      ObjCTypeParamList /*P*/ typeParamList, 
      SourceLocation CLoc, 
      ObjCInterfaceDecl /*P*/ PrevDecl, 
      boolean IsInternal) {
    // : ObjCContainerDecl(ObjCInterface, DC, Id, CLoc, AtLoc), redeclarable_base(C), TypeForDecl(null), TypeParamList(null), Data() 
    //START JInit
    super(Kind.ObjCInterface, DC, Id, new SourceLocation(CLoc), new SourceLocation(AtLoc));
    this.Redeclarable$Flds = $Redeclarable(C);
    this.TypeForDecl = null;
    this.TypeParamList = null;
    this.Data = new PointerBoolPair<DefinitionData /*P*/ >();
    //END JInit
    setPreviousDecl(PrevDecl);
    
    // Copy the 'data' pointer over.
    if ((PrevDecl != null)) {
      Data.$assign(PrevDecl.Data);
    }
    
    setImplicit(IsInternal);
    
    setTypeParamList(typeParamList);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::LoadExternalDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1432,
   FQN="clang::ObjCInterfaceDecl::LoadExternalDefinition", NM="_ZNK5clang17ObjCInterfaceDecl22LoadExternalDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl22LoadExternalDefinitionEv")
  //</editor-fold>
  private void LoadExternalDefinition() /*const*/ {
    assert (data().ExternallyCompleted) : "Class is not externally completed";
    data().ExternallyCompleted = false;
    getASTContext().getExternalSource().CompleteType(((/*const_cast*/ObjCInterfaceDecl /*P*/ )(this)));
  }

  
  /// The type parameters associated with this class, if any.
  /*friend*/public ObjCTypeParamList /*P*/ TypeParamList;
  
  /// \brief Contains a pointer to the data associated with this class,
  /// which will be NULL if this class has not yet been defined.
  ///
  /// The bit indicates when we don't need to check for out-of-date
  /// declarations. It will be set unless modules are enabled.
  /*friend*/public PointerBoolPair<DefinitionData /*P*/ > Data;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::data">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1178,
   FQN="clang::ObjCInterfaceDecl::data", NM="_ZNK5clang17ObjCInterfaceDecl4dataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl4dataEv")
  //</editor-fold>
  /*friend*/public DefinitionData /*&*/ data() /*const*/ {
    assert ((Data.getPointer() != null)) : "Declaration has no definition!";
    return $Deref(Data.getPointer());
  }

  
  /// \brief Allocate the definition data for this class.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::allocateDefinitionData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 571,
   FQN="clang::ObjCInterfaceDecl::allocateDefinitionData", NM="_ZN5clang17ObjCInterfaceDecl22allocateDefinitionDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl22allocateDefinitionDataEv")
  //</editor-fold>
  /*friend*/public void allocateDefinitionData() {
    assert (!hasDefinition()) : "ObjC class already has a definition";
    Data.setPointer(/*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (getASTContext())*/ $new_uint_ASTContext$C_uint(getASTContext(), (type$ptr<?> New$Mem)->{
            return new DefinitionData();
         }));
    Data.getPointer().Definition = this;
    
    // Make the type point at the definition, now that we have one.
    if ((TypeForDecl != null)) {
      cast_ObjCInterfaceType(TypeForDecl).Decl = this;
    }
  }

  
  /*typedef Redeclarable<ObjCInterfaceDecl> redeclarable_base*/
//  public final class redeclarable_base extends Redeclarable<ObjCInterfaceDecl>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getNextRedeclarationImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1187,
   FQN="clang::ObjCInterfaceDecl::getNextRedeclarationImpl", NM="_ZN5clang17ObjCInterfaceDecl24getNextRedeclarationImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl24getNextRedeclarationImplEv")
  //</editor-fold>
  @Override protected/*private*/ ObjCInterfaceDecl /*P*/ getNextRedeclarationImpl()/* override*/ {
    return getNextRedeclaration();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getPreviousDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1190,
   FQN="clang::ObjCInterfaceDecl::getPreviousDeclImpl", NM="_ZN5clang17ObjCInterfaceDecl19getPreviousDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl19getPreviousDeclImplEv")
  //</editor-fold>
  @Override protected/*private*/ ObjCInterfaceDecl /*P*/ getPreviousDeclImpl()/* override*/ {
    return getPreviousDecl$Redeclarable();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getMostRecentDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1193,
   FQN="clang::ObjCInterfaceDecl::getMostRecentDeclImpl", NM="_ZN5clang17ObjCInterfaceDecl21getMostRecentDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl21getMostRecentDeclImplEv")
  //</editor-fold>
  @Override protected/*private*/ ObjCInterfaceDecl /*P*/ getMostRecentDeclImpl()/* override*/ {
    return getMostRecentDecl$Redeclarable();
  }

/*public:*/
  
  //===----------------------------------------------------------------------===//
  // ObjCInterfaceDecl
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1384,
   FQN="clang::ObjCInterfaceDecl::Create", NM="_ZN5clang17ObjCInterfaceDecl6CreateERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoEPNS_17ObjCTypeParamListEPS0_S6_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl6CreateERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoEPNS_17ObjCTypeParamListEPS0_S6_b")
  //</editor-fold>
  public static ObjCInterfaceDecl /*P*/ Create(final /*const*/ ASTContext /*&*/ C, 
        DeclContext /*P*/ DC, 
        SourceLocation atLoc, 
        IdentifierInfo /*P*/ Id, 
        ObjCTypeParamList /*P*/ typeParamList, 
        ObjCInterfaceDecl /*P*/ PrevDecl) {
    return Create(C, 
        DC, 
        atLoc, 
        Id, 
        typeParamList, 
        PrevDecl, 
        new SourceLocation(), 
        false);
  }
  public static ObjCInterfaceDecl /*P*/ Create(final /*const*/ ASTContext /*&*/ C, 
        DeclContext /*P*/ DC, 
        SourceLocation atLoc, 
        IdentifierInfo /*P*/ Id, 
        ObjCTypeParamList /*P*/ typeParamList, 
        ObjCInterfaceDecl /*P*/ PrevDecl, 
        SourceLocation ClassLoc/*= SourceLocation()*/) {
    return Create(C, 
        DC, 
        atLoc, 
        Id, 
        typeParamList, 
        PrevDecl, 
        ClassLoc, 
        false);
  }
  public static ObjCInterfaceDecl /*P*/ Create(final /*const*/ ASTContext /*&*/ C, 
        DeclContext /*P*/ DC, 
        SourceLocation atLoc, 
        IdentifierInfo /*P*/ Id, 
        ObjCTypeParamList /*P*/ typeParamList, 
        ObjCInterfaceDecl /*P*/ PrevDecl, 
        SourceLocation ClassLoc/*= SourceLocation()*/, 
        boolean isInternal/*= false*/) {
    ObjCInterfaceDecl /*P*/ Result = /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> New$Mem)->{
        return new ObjCInterfaceDecl(C, DC, new SourceLocation(atLoc), Id, typeParamList, new SourceLocation(ClassLoc), PrevDecl, 
                isInternal);
     });
    Result.Data.setInt(!C.getLangOpts().Modules);
    C.getObjCInterfaceType(Result, PrevDecl);
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1400,
   FQN="clang::ObjCInterfaceDecl::CreateDeserialized", NM="_ZN5clang17ObjCInterfaceDecl18CreateDeserializedERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl18CreateDeserializedERKNS_10ASTContextEj")
  //</editor-fold>
  public static ObjCInterfaceDecl /*P*/ CreateDeserialized(final /*const*/ ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    ObjCInterfaceDecl /*P*/ Result = /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> New$Mem)->{
        return new ObjCInterfaceDecl(C, (DeclContext /*P*/ )null, 
                new SourceLocation(), 
                (IdentifierInfo /*P*/ )null, 
                (ObjCTypeParamList /*P*/ )null, 
                new SourceLocation(), 
                (ObjCInterfaceDecl /*P*/ )null, false);
     });
    Result.Data.setInt(!C.getLangOpts().Modules);
    return Result;
  }

  
  /// Retrieve the type parameters of this class.
  ///
  /// This function looks for a type parameter list for the given
  /// class; if the class has been declared (with \c \@class) but not
  /// defined (with \c \@interface), it will search for a declaration that
  /// has type parameters, skipping any declarations that do not.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getTypeParamList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 285,
   FQN="clang::ObjCInterfaceDecl::getTypeParamList", NM="_ZNK5clang17ObjCInterfaceDecl16getTypeParamListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl16getTypeParamListEv")
  //</editor-fold>
  public ObjCTypeParamList /*P*/ getTypeParamList() /*const*/ {
    {
      // If this particular declaration has a type parameter list, return it.
      ObjCTypeParamList /*P*/ written = getTypeParamListAsWritten();
      if ((written != null)) {
        return written;
      }
    }
    {
      
      // If there is a definition, return its type parameter list.
      /*const*/ ObjCInterfaceDecl /*P*/ def = getDefinition$Const();
      if ((def != null)) {
        return def.getTypeParamListAsWritten();
      }
    }
    
    // Otherwise, look at previous declarations to determine whether any
    // of them has a type parameter list, skipping over those
    // declarations that do not.
    for (/*const*/ ObjCInterfaceDecl /*P*/ decl = getMostRecentDecl$Redeclarable$Const(); (decl != null); decl = decl.getPreviousDecl$Redeclarable$Const()) {
      {
        ObjCTypeParamList /*P*/ written = decl.getTypeParamListAsWritten();
        if ((written != null)) {
          return written;
        }
      }
    }
    
    return null;
  }

  
  /// Set the type parameters of this class.
  ///
  /// This function is used by the AST importer, which must import the type
  /// parameters after creating their DeclContext to avoid loops.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::setTypeParamList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 305,
   FQN="clang::ObjCInterfaceDecl::setTypeParamList", NM="_ZN5clang17ObjCInterfaceDecl16setTypeParamListEPNS_17ObjCTypeParamListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl16setTypeParamListEPNS_17ObjCTypeParamListE")
  //</editor-fold>
  public void setTypeParamList(ObjCTypeParamList /*P*/ TPL) {
    TypeParamList = TPL;
    if (!(TPL != null)) {
      return;
    }
    // Set the declaration context of each of the type parameters.
    for (ObjCTypeParamDecl /*P*/ typeParam : $Deref(TypeParamList))  {
      typeParam.setDeclContext(this);
    }
  }

  
  /// Retrieve the type parameters written on this particular declaration of
  /// the class.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getTypeParamListAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1224,
   FQN="clang::ObjCInterfaceDecl::getTypeParamListAsWritten", NM="_ZNK5clang17ObjCInterfaceDecl25getTypeParamListAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl25getTypeParamListAsWrittenEv")
  //</editor-fold>
  public ObjCTypeParamList /*P*/ getTypeParamListAsWritten() /*const*/ {
    return TypeParamList;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1228,
   FQN="clang::ObjCInterfaceDecl::getSourceRange", NM="_ZNK5clang17ObjCInterfaceDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    if (isThisDeclarationADefinition()) {
      return super.getSourceRange();
    }
    
    return new SourceRange(getAtStartLoc(), getLocation());
  }

  
  /// \brief Indicate that this Objective-C class is complete, but that
  /// the external AST source will be responsible for filling in its contents
  /// when a complete class is required.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::setExternallyCompleted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1439,
   FQN="clang::ObjCInterfaceDecl::setExternallyCompleted", NM="_ZN5clang17ObjCInterfaceDecl22setExternallyCompletedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl22setExternallyCompletedEv")
  //</editor-fold>
  public void setExternallyCompleted() {
    assert ((getASTContext().getExternalSource() != null)) : "Class can't be externally completed without an external source";
    assert (hasDefinition()) : "Forward declarations can't be externally completed";
    data().ExternallyCompleted = true;
  }

  
  /// Indicate that this interface decl contains at least one initializer
  /// marked with the 'objc_designated_initializer' attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::setHasDesignatedInitializers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1447,
   FQN="clang::ObjCInterfaceDecl::setHasDesignatedInitializers", NM="_ZN5clang17ObjCInterfaceDecl28setHasDesignatedInitializersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl28setHasDesignatedInitializersEv")
  //</editor-fold>
  public void setHasDesignatedInitializers() {
    // Check for a complete definition and recover if not so.
    if (!isThisDeclarationADefinition()) {
      return;
    }
    data().HasDesignatedInitializers = true;
  }

  
  /// Returns true if this interface decl contains at least one initializer
  /// marked with the 'objc_designated_initializer' attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::hasDesignatedInitializers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1454,
   FQN="clang::ObjCInterfaceDecl::hasDesignatedInitializers", NM="_ZNK5clang17ObjCInterfaceDecl25hasDesignatedInitializersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl25hasDesignatedInitializersEv")
  //</editor-fold>
  public boolean hasDesignatedInitializers() /*const*/ {
    // Check for a complete definition and recover if not so.
    if (!isThisDeclarationADefinition()) {
      return false;
    }
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    
    return data().HasDesignatedInitializers;
  }

  
  /// Returns true if this interface decl declares a designated initializer
  /// or it inherites one from its super class.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::declaresOrInheritsDesignatedInitializers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1250,
   FQN="clang::ObjCInterfaceDecl::declaresOrInheritsDesignatedInitializers", NM="_ZNK5clang17ObjCInterfaceDecl40declaresOrInheritsDesignatedInitializersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl40declaresOrInheritsDesignatedInitializersEv")
  //</editor-fold>
  public boolean declaresOrInheritsDesignatedInitializers() /*const*/ {
    return hasDesignatedInitializers() || inheritsDesignatedInitializers();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getReferencedProtocols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1254,
   FQN="clang::ObjCInterfaceDecl::getReferencedProtocols", NM="_ZNK5clang17ObjCInterfaceDecl22getReferencedProtocolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl22getReferencedProtocolsEv")
  //</editor-fold>
  public /*const*/ ObjCProtocolList /*&*/ getReferencedProtocols() /*const*/ {
    assert (hasDefinition()) : "Caller did not check for forward reference!";
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    
    return data().ReferencedProtocols;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getImplementation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1481,
   FQN="clang::ObjCInterfaceDecl::getImplementation", NM="_ZNK5clang17ObjCInterfaceDecl17getImplementationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl17getImplementationEv")
  //</editor-fold>
  public ObjCImplementationDecl /*P*/ getImplementation() /*const*/ {
    {
      /*const*/ ObjCInterfaceDecl /*P*/ Def = getDefinition$Const();
      if ((Def != null)) {
        if (data().ExternallyCompleted) {
          LoadExternalDefinition();
        }
        
        return getASTContext().getObjCImplementation(((/*const_cast*/ObjCInterfaceDecl /*P*/ )(Def)));
      }
    }
    
    // FIXME: Should make sure no callers ever do this.
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::setImplementation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1494,
   FQN="clang::ObjCInterfaceDecl::setImplementation", NM="_ZN5clang17ObjCInterfaceDecl17setImplementationEPNS_22ObjCImplementationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl17setImplementationEPNS_22ObjCImplementationDeclE")
  //</editor-fold>
  public void setImplementation(ObjCImplementationDecl /*P*/ ImplD) {
    getASTContext().setObjCImplementation(getDefinition(), ImplD);
  }

  
  
  /// FindCategoryDeclaration - Finds category declaration in the list of
  /// categories for this class and returns it. Name of the category is passed
  /// in 'CategoryId'. If category not found, return 0;
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::FindCategoryDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1592,
   FQN="clang::ObjCInterfaceDecl::FindCategoryDeclaration", NM="_ZNK5clang17ObjCInterfaceDecl23FindCategoryDeclarationEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl23FindCategoryDeclarationEPNS_14IdentifierInfoE")
  //</editor-fold>
  public ObjCCategoryDecl /*P*/ FindCategoryDeclaration(IdentifierInfo /*P*/ CategoryId) /*const*/ {
    // FIXME: Should make sure no callers ever do this.
    if (!hasDefinition()) {
      return null;
    }
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    
    for (ObjCCategoryDecl /*P*/ Cat : visible_categories())  {
      if (Cat.getIdentifier() == CategoryId) {
        return Cat;
      }
    }
    
    return null;
  }

  
  // Get the local instance/class method declared in a category.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getCategoryInstanceMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1608,
   FQN="clang::ObjCInterfaceDecl::getCategoryInstanceMethod", NM="_ZNK5clang17ObjCInterfaceDecl25getCategoryInstanceMethodENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl25getCategoryInstanceMethodENS_8SelectorE")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ getCategoryInstanceMethod(Selector Sel) /*const*/ {
    for (/*const*/ ObjCCategoryDecl /*P*/ Cat : visible_categories()) {
      {
        ObjCCategoryImplDecl /*P*/ Impl = Cat.getImplementation();
        if ((Impl != null)) {
          {
            ObjCMethodDecl /*P*/ MD = Impl.getInstanceMethod(new Selector(Sel));
            if ((MD != null)) {
              return MD;
            }
          }
        }
      }
    }
    
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getCategoryClassMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1619,
   FQN="clang::ObjCInterfaceDecl::getCategoryClassMethod", NM="_ZNK5clang17ObjCInterfaceDecl22getCategoryClassMethodENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl22getCategoryClassMethodENS_8SelectorE")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ getCategoryClassMethod(Selector Sel) /*const*/ {
    for (/*const*/ ObjCCategoryDecl /*P*/ Cat : visible_categories()) {
      {
        ObjCCategoryImplDecl /*P*/ Impl = Cat.getImplementation();
        if ((Impl != null)) {
          {
            ObjCMethodDecl /*P*/ MD = Impl.getClassMethod(new Selector(Sel));
            if ((MD != null)) {
              return MD;
            }
          }
        }
      }
    }
    
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getCategoryMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1270,
   FQN="clang::ObjCInterfaceDecl::getCategoryMethod", NM="_ZNK5clang17ObjCInterfaceDecl17getCategoryMethodENS_8SelectorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl17getCategoryMethodENS_8SelectorEb")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ getCategoryMethod(Selector Sel, boolean isInstance) /*const*/ {
    return isInstance ? getCategoryInstanceMethod(new Selector(Sel)) : getCategoryClassMethod(new Selector(Sel));
  }

  
  /*typedef ObjCProtocolList::iterator protocol_iterator*/
//  public final class protocol_iterator extends type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/>{ };
  /*typedef llvm::iterator_range<protocol_iterator> protocol_range*/
//  public final class protocol_range extends iterator_range<ObjCProtocolDecl /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::protocols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1278,
   FQN="clang::ObjCInterfaceDecl::protocols", NM="_ZNK5clang17ObjCInterfaceDecl9protocolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl9protocolsEv")
  //</editor-fold>
  public iterator_range<ObjCProtocolDecl /*P*/ /*const*/> protocols() /*const*/ {
    return new iterator_range<ObjCProtocolDecl /*P*/ /*const*/>(protocol_begin(), protocol_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::protocol_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1281,
   FQN="clang::ObjCInterfaceDecl::protocol_begin", NM="_ZNK5clang17ObjCInterfaceDecl14protocol_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl14protocol_beginEv")
  //</editor-fold>
  public type$ptr<ObjCProtocolDecl>/*protocol_iterator*/ protocol_begin() /*const*/ {
    // FIXME: Should make sure no callers ever do this.
    if (!hasDefinition()) {
      return ((type$ptr<ObjCProtocolDecl>/*protocol_iterator*/)null);
    }
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    
    return data().ReferencedProtocols.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::protocol_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1291,
   FQN="clang::ObjCInterfaceDecl::protocol_end", NM="_ZNK5clang17ObjCInterfaceDecl12protocol_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl12protocol_endEv")
  //</editor-fold>
  public type$ptr<ObjCProtocolDecl>/*protocol_iterator*/ protocol_end() /*const*/ {
    // FIXME: Should make sure no callers ever do this.
    if (!hasDefinition()) {
      return ((type$ptr<ObjCProtocolDecl>/*protocol_iterator*/)null);
    }
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    
    return data().ReferencedProtocols.end();
  }

  
  /*typedef ObjCProtocolList::loc_iterator protocol_loc_iterator*/
//  public final class protocol_loc_iterator extends /*const*/type$ptr<SourceLocation> /*P*/ { };
  /*typedef llvm::iterator_range<protocol_loc_iterator> protocol_loc_range*/
//  public final class protocol_loc_range extends iterator_range</*const*/ SourceLocation>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::protocol_locs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1305,
   FQN="clang::ObjCInterfaceDecl::protocol_locs", NM="_ZNK5clang17ObjCInterfaceDecl13protocol_locsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl13protocol_locsEv")
  //</editor-fold>
  public iterator_range</*const*/ SourceLocation> protocol_locs() /*const*/ {
    return new iterator_range</*const*/ SourceLocation>(protocol_loc_begin(), protocol_loc_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::protocol_loc_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1308,
   FQN="clang::ObjCInterfaceDecl::protocol_loc_begin", NM="_ZNK5clang17ObjCInterfaceDecl18protocol_loc_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl18protocol_loc_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<SourceLocation> /*P*/ protocol_loc_begin() /*const*/ {
    // FIXME: Should make sure no callers ever do this.
    if (!hasDefinition()) {
      return ((/*const*/type$ptr<SourceLocation> /*P*/ )null);
    }
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    
    return data().ReferencedProtocols.loc_begin();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::protocol_loc_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1319,
   FQN="clang::ObjCInterfaceDecl::protocol_loc_end", NM="_ZNK5clang17ObjCInterfaceDecl16protocol_loc_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl16protocol_loc_endEv")
  //</editor-fold>
  public /*const*/type$ptr<SourceLocation> /*P*/ protocol_loc_end() /*const*/ {
    // FIXME: Should make sure no callers ever do this.
    if (!hasDefinition()) {
      return ((/*const*/type$ptr<SourceLocation> /*P*/ )null);
    }
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    
    return data().ReferencedProtocols.loc_end();
  }

  
  /*typedef ObjCList<ObjCProtocolDecl>::iterator all_protocol_iterator*/
//  public final class all_protocol_iterator extends type$ptr<ObjCProtocolDecl>{ };
  /*typedef llvm::iterator_range<all_protocol_iterator> all_protocol_range*/
//  public final class all_protocol_range extends iterator_range<ObjCProtocolDecl /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::all_referenced_protocols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1333,
   FQN="clang::ObjCInterfaceDecl::all_referenced_protocols", NM="_ZNK5clang17ObjCInterfaceDecl24all_referenced_protocolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl24all_referenced_protocolsEv")
  //</editor-fold>
  public iterator_range<ObjCProtocolDecl /*P*/ /*const*/> all_referenced_protocols() /*const*/ {
    return new iterator_range<ObjCProtocolDecl /*P*/ /*const*/>(all_referenced_protocol_begin(), 
        all_referenced_protocol_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::all_referenced_protocol_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1337,
   FQN="clang::ObjCInterfaceDecl::all_referenced_protocol_begin", NM="_ZNK5clang17ObjCInterfaceDecl29all_referenced_protocol_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl29all_referenced_protocol_beginEv")
  //</editor-fold>
  public type$ptr<ObjCProtocolDecl>/*all_protocol_iterator*/ all_referenced_protocol_begin() /*const*/ {
    // FIXME: Should make sure no callers ever do this.
    if (!hasDefinition()) {
      return ((type$ptr<ObjCProtocolDecl>/*all_protocol_iterator*/)null);
    }
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    
    return data().AllReferencedProtocols.empty() ? protocol_begin() : data().AllReferencedProtocols.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::all_referenced_protocol_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1349,
   FQN="clang::ObjCInterfaceDecl::all_referenced_protocol_end", NM="_ZNK5clang17ObjCInterfaceDecl27all_referenced_protocol_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl27all_referenced_protocol_endEv")
  //</editor-fold>
  public type$ptr<ObjCProtocolDecl>/*all_protocol_iterator*/ all_referenced_protocol_end() /*const*/ {
    // FIXME: Should make sure no callers ever do this.
    if (!hasDefinition()) {
      return ((type$ptr<ObjCProtocolDecl>/*all_protocol_iterator*/)null);
    }
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    
    return data().AllReferencedProtocols.empty() ? protocol_end() : data().AllReferencedProtocols.end();
  }

  
  /*typedef specific_decl_iterator<ObjCIvarDecl> ivar_iterator*/
//  public final class ivar_iterator extends specific_decl_iterator<ObjCIvarDecl>{ };
  /*typedef llvm::iterator_range<specific_decl_iterator<ObjCIvarDecl> > ivar_range*/
//  public final class ivar_range extends iterator_range<ObjCIvarDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::ivars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1365,
   FQN="clang::ObjCInterfaceDecl::ivars", NM="_ZNK5clang17ObjCInterfaceDecl5ivarsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl5ivarsEv")
  //</editor-fold>
  public iterator_range<ObjCIvarDecl /*P*/ > ivars() /*const*/ {
    return new iterator_range<ObjCIvarDecl /*P*/ >(ivar_begin(), ivar_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::ivar_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1366,
   FQN="clang::ObjCInterfaceDecl::ivar_begin", NM="_ZNK5clang17ObjCInterfaceDecl10ivar_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl10ivar_beginEv")
  //</editor-fold>
  public specific_decl_iterator<ObjCIvarDecl> ivar_begin() /*const*/ {
    {
      /*const*/ ObjCInterfaceDecl /*P*/ Def = getDefinition$Const();
      if ((Def != null)) {
        return new specific_decl_iterator<ObjCIvarDecl>(ObjCIvarDecl.class, Def.decls_begin());
      }
    }
    
    // FIXME: Should make sure no callers ever do this.
    return new specific_decl_iterator<ObjCIvarDecl>(ObjCIvarDecl.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::ivar_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1373,
   FQN="clang::ObjCInterfaceDecl::ivar_end", NM="_ZNK5clang17ObjCInterfaceDecl8ivar_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl8ivar_endEv")
  //</editor-fold>
  public specific_decl_iterator<ObjCIvarDecl> ivar_end() /*const*/ {
    {
      /*const*/ ObjCInterfaceDecl /*P*/ Def = getDefinition$Const();
      if ((Def != null)) {
        return new specific_decl_iterator<ObjCIvarDecl>(ObjCIvarDecl.class, Def.decls_end());
      }
    }
    
    // FIXME: Should make sure no callers ever do this.
    return new specific_decl_iterator<ObjCIvarDecl>(ObjCIvarDecl.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::ivar_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1381,
   FQN="clang::ObjCInterfaceDecl::ivar_size", NM="_ZNK5clang17ObjCInterfaceDecl9ivar_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl9ivar_sizeEv")
  //</editor-fold>
  public /*uint*/int ivar_size() /*const*/ {
    return std.distance(ivar_begin(), ivar_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::ivar_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1385,
   FQN="clang::ObjCInterfaceDecl::ivar_empty", NM="_ZNK5clang17ObjCInterfaceDecl10ivar_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl10ivar_emptyEv")
  //</editor-fold>
  public boolean ivar_empty() /*const*/ {
    return $eq_specific_decl_iterator$SpecificDecl$C(ivar_begin(), ivar_end());
  }

  
  
  /// all_declared_ivar_begin - return first ivar declared in this class,
  /// its extensions and its implementation. Lazily build the list on first
  /// access.
  ///
  /// Caveat: The list returned by this method reflects the current
  /// state of the parser. The cache will be updated for every ivar
  /// added by an extension or the implementation when they are
  /// encountered.
  /// See also ObjCIvarDecl::Create().
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::all_declared_ivar_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1521,
   FQN="clang::ObjCInterfaceDecl::all_declared_ivar_begin", NM="_ZN5clang17ObjCInterfaceDecl23all_declared_ivar_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl23all_declared_ivar_beginEv")
  //</editor-fold>
  public ObjCIvarDecl /*P*/ all_declared_ivar_begin() {
    // FIXME: Should make sure no callers ever do this.
    if (!hasDefinition()) {
      return null;
    }
    
    ObjCIvarDecl /*P*/ curIvar = null;
    if (!(data().IvarList != null)) {
      if (!ivar_empty()) {
        specific_decl_iterator<ObjCIvarDecl> I = ivar_begin();
        specific_decl_iterator<ObjCIvarDecl> E = ivar_end();
        data().IvarList = I.$star();
        I.$preInc();
        for (curIvar = data().IvarList; $noteq_specific_decl_iterator$SpecificDecl$C(I, E); curIvar = I.$star() , I.$preInc())  {
          curIvar.setNextIvar(I.$star());
        }
      }
      
      for (/*const*/ ObjCCategoryDecl /*P*/ Ext : known_extensions()) {
        if (!Ext.ivar_empty()) {
          specific_decl_iterator<ObjCIvarDecl> I = Ext.ivar_begin();
          specific_decl_iterator<ObjCIvarDecl> E = Ext.ivar_end();
          if (!(data().IvarList != null)) {
            data().IvarList = I.$star();
            I.$preInc();
            curIvar = data().IvarList;
          }
          for (; $noteq_specific_decl_iterator$SpecificDecl$C(I, E); curIvar = I.$star() , I.$preInc())  {
            curIvar.setNextIvar(I.$star());
          }
        }
      }
      data().IvarListMissingImplementation = true;
    }
    
    // cached and complete!
    if (!data().IvarListMissingImplementation) {
      return data().IvarList;
    }
    {
      
      ObjCImplementationDecl /*P*/ ImplDecl = getImplementation();
      if ((ImplDecl != null)) {
        data().IvarListMissingImplementation = false;
        if (!ImplDecl.ivar_empty()) {
          SmallVector<SynthesizeIvarChunk> layout/*J*/= new SmallVector<SynthesizeIvarChunk>(16, new SynthesizeIvarChunk());
          for (ObjCIvarDecl /*P*/ IV : ImplDecl.ivars()) {
            if (IV.getSynthesize() && !IV.isInvalidDecl()) {
              layout.push_back(new SynthesizeIvarChunk(IV.getASTContext().getTypeSize(IV.getType()), IV));
              continue;
            }
            if (!(data().IvarList != null)) {
              data().IvarList = IV;
            } else {
              curIvar.setNextIvar(IV);
            }
            curIvar = IV;
          }
          if (!layout.empty()) {
            // Order synthesized ivars by their size.
            std.stable_sort(layout.begin(), layout.end());
            /*uint*/int Ix = 0;
            /*uint*/int EIx = layout.size();
            if (!(data().IvarList != null)) {
              data().IvarList = layout.$at(0).Ivar;
              Ix++;
              curIvar = data().IvarList;
            }
            for (; Ix != EIx; curIvar = layout.$at(Ix).Ivar , Ix++)  {
              curIvar.setNextIvar(layout.$at(Ix).Ivar);
            }
          }
        }
      }
    }
    return data().IvarList;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::all_declared_ivar_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1388,
   FQN="clang::ObjCInterfaceDecl::all_declared_ivar_begin", NM="_ZNK5clang17ObjCInterfaceDecl23all_declared_ivar_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl23all_declared_ivar_beginEv")
  //</editor-fold>
  public /*const*/ ObjCIvarDecl /*P*/ all_declared_ivar_begin$Const() /*const*/ {
    // Even though this modifies IvarList, it's conceptually const:
    // the ivar chain is essentially a cached property of ObjCInterfaceDecl.
    return ((/*const_cast*/ObjCInterfaceDecl /*P*/ )(this)).all_declared_ivar_begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::setIvarList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1393,
   FQN="clang::ObjCInterfaceDecl::setIvarList", NM="_ZN5clang17ObjCInterfaceDecl11setIvarListEPNS_12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl11setIvarListEPNS_12ObjCIvarDeclE")
  //</editor-fold>
  public void setIvarList(ObjCIvarDecl /*P*/ ivar) {
    data().IvarList = ivar;
  }

  
  /// setProtocolList - Set the list of protocols that this interface
  /// implements.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::setProtocolList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1397,
   FQN="clang::ObjCInterfaceDecl::setProtocolList", NM="_ZN5clang17ObjCInterfaceDecl15setProtocolListEPKPNS_16ObjCProtocolDeclEjPKNS_14SourceLocationERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl15setProtocolListEPKPNS_16ObjCProtocolDeclEjPKNS_14SourceLocationERNS_10ASTContextE")
  //</editor-fold>
  public void setProtocolList(type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/> List, /*uint*/int Num, 
                 /*const*/type$ptr<SourceLocation> /*P*/ Locs, final ASTContext /*&*/ C) {
    data().ReferencedProtocols.set(List, Num, Locs, C);
  }

  
  /// mergeClassExtensionProtocolList - Merge class extension's protocol list
  /// into the protocol list for this class.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::mergeClassExtensionProtocolList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 410,
   FQN="clang::ObjCInterfaceDecl::mergeClassExtensionProtocolList", NM="_ZN5clang17ObjCInterfaceDecl31mergeClassExtensionProtocolListEPKPNS_16ObjCProtocolDeclEjRNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl31mergeClassExtensionProtocolListEPKPNS_16ObjCProtocolDeclEjRNS_10ASTContextE")
  //</editor-fold>
  public void mergeClassExtensionProtocolList(type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/> ExtList, /*uint*/int ExtNum, 
                                 final ASTContext /*&*/ C) {
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    if (data().AllReferencedProtocols.empty()
       && data().ReferencedProtocols.empty()) {
      data().AllReferencedProtocols.set(ExtList, ExtNum, C);
      return;
    }
    
    // Check for duplicate protocol in class's protocol list.
    // This is O(n*m). But it is extremely rare and number of protocols in
    // class or its extension are very few.
    SmallVector<ObjCProtocolDecl /*P*/ > ProtocolRefs/*J*/= new SmallVector<ObjCProtocolDecl /*P*/ >(8, (ObjCProtocolDecl /*P*/ )null);
    for (/*uint*/int i = 0; $less_uint(i, ExtNum); i++) {
      boolean protocolExists = false;
      ObjCProtocolDecl /*P*/ ProtoInExtension = ExtList.$at(i);
      for (ObjCProtocolDecl /*P*/ Proto : all_referenced_protocols()) {
        if (C.ProtocolCompatibleWithProtocol(ProtoInExtension, Proto)) {
          protocolExists = true;
          break;
        }
      }
      // Do we want to warn on a protocol in extension class which
      // already exist in the class? Probably not.
      if (!protocolExists) {
        ProtocolRefs.push_back(ProtoInExtension);
      }
    }
    if (ProtocolRefs.empty()) {
      return;
    }
    
    // Merge ProtocolRefs into class's protocol list;
    ProtocolRefs.append_T(all_referenced_protocol_begin(), 
        all_referenced_protocol_end());
    
    data().AllReferencedProtocols.set(ProtocolRefs.data(), ProtocolRefs.size(), C);
  }

  
  /// Produce a name to be used for class's metadata. It comes either via
  /// objc_runtime_name attribute or class name.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getObjCRuntimeNameAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1464,
   FQN="clang::ObjCInterfaceDecl::getObjCRuntimeNameAsString", NM="_ZNK5clang17ObjCInterfaceDecl26getObjCRuntimeNameAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl26getObjCRuntimeNameAsStringEv")
  //</editor-fold>
  public StringRef getObjCRuntimeNameAsString() /*const*/ {
    {
      ObjCRuntimeNameAttr /*P*/ ObjCRTName = getAttr(ObjCRuntimeNameAttr.class);
      if ((ObjCRTName != null)) {
        return ObjCRTName.getMetadataName();
      }
    }
    
    return getName();
  }

  
  /// Returns the designated initializers for the interface.
  ///
  /// If this declaration does not have methods marked as designated
  /// initializers then the interface inherits the designated initializers of
  /// its super class.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getDesignatedInitializers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 518,
   FQN="clang::ObjCInterfaceDecl::getDesignatedInitializers", NM="_ZNK5clang17ObjCInterfaceDecl25getDesignatedInitializersERN4llvm15SmallVectorImplIPKNS_14ObjCMethodDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl25getDesignatedInitializersERN4llvm15SmallVectorImplIPKNS_14ObjCMethodDeclEEE")
  //</editor-fold>
  public void getDesignatedInitializers(final SmallVectorImpl</*const*/ ObjCMethodDecl /*P*/ > /*&*/ Methods) /*const*/ {
    // Check for a complete definition and recover if not so.
    if (!isThisDeclarationADefinition()) {
      return;
    }
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    
    /*const*/ ObjCInterfaceDecl /*P*/ IFace = findInterfaceWithDesignatedInitializers();
    if (!(IFace != null)) {
      return;
    }
    
    for (/*const*/ ObjCMethodDecl /*P*/ MD : IFace.instance_methods())  {
      if (MD.isThisDeclarationADesignatedInitializer()) {
        Methods.push_back(MD);
      }
    }
    for (/*const*/ ObjCCategoryDecl /*P*/ Ext : IFace.visible_extensions()) {
      for (/*const*/ ObjCMethodDecl /*P*/ MD : Ext.instance_methods())  {
        if (MD.isThisDeclarationADesignatedInitializer()) {
          Methods.push_back(MD);
        }
      }
    }
  }

  
  /// Returns true if the given selector is a designated initializer for the
  /// interface.
  ///
  /// If this declaration does not have methods marked as designated
  /// initializers then the interface inherits the designated initializers of
  /// its super class.
  ///
  /// \param InitMethod if non-null and the function returns true, it receives
  /// the method that was marked as a designated initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::isDesignatedInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 540,
   FQN="clang::ObjCInterfaceDecl::isDesignatedInitializer", NM="_ZNK5clang17ObjCInterfaceDecl23isDesignatedInitializerENS_8SelectorEPPKNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl23isDesignatedInitializerENS_8SelectorEPPKNS_14ObjCMethodDeclE")
  //</editor-fold>
  public boolean isDesignatedInitializer(Selector Sel) /*const*/ {
    return isDesignatedInitializer(Sel, 
                         (type$ptr</*const*/ ObjCMethodDecl /*P*/ /*P*/>)null);
  }
  public boolean isDesignatedInitializer(Selector Sel, 
                         type$ptr</*const*/ ObjCMethodDecl /*P*/ /*P*/> InitMethod/*= null*/) /*const*/ {
    // Check for a complete definition and recover if not so.
    if (!isThisDeclarationADefinition()) {
      return false;
    }
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    
    /*const*/ ObjCInterfaceDecl /*P*/ IFace = findInterfaceWithDesignatedInitializers();
    if (!(IFace != null)) {
      return false;
    }
    {
      
      /*const*/ ObjCMethodDecl /*P*/ MD = IFace.getInstanceMethod(new Selector(Sel));
      if ((MD != null)) {
        if (MD.isThisDeclarationADesignatedInitializer()) {
          if (Native.$bool(InitMethod)) {
            InitMethod.$set(MD);
          }
          return true;
        }
      }
    }
    for (/*const*/ ObjCCategoryDecl /*P*/ Ext : IFace.visible_extensions()) {
      {
        /*const*/ ObjCMethodDecl /*P*/ MD = Ext.getInstanceMethod(new Selector(Sel));
        if ((MD != null)) {
          if (MD.isThisDeclarationADesignatedInitializer()) {
            if (Native.$bool(InitMethod)) {
              InitMethod.$set(MD);
            }
            return true;
          }
        }
      }
    }
    return false;
  }

  
  /// \brief Determine whether this particular declaration of this class is
  /// actually also a definition.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::isThisDeclarationADefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1435,
   FQN="clang::ObjCInterfaceDecl::isThisDeclarationADefinition", NM="_ZNK5clang17ObjCInterfaceDecl28isThisDeclarationADefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl28isThisDeclarationADefinitionEv")
  //</editor-fold>
  public boolean isThisDeclarationADefinition() /*const*/ {
    return getDefinition$Const() == this;
  }

  
  /// \brief Determine whether this class has been defined.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::hasDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1440,
   FQN="clang::ObjCInterfaceDecl::hasDefinition", NM="_ZNK5clang17ObjCInterfaceDecl13hasDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl13hasDefinitionEv")
  //</editor-fold>
  public boolean hasDefinition() /*const*/ {
    // If the name of this class is out-of-date, bring it up-to-date, which
    // might bring in a definition.
    // Note: a null value indicates that we don't have a definition and that
    // modules are enabled.
    if (!(Data.getOpaqueValue() != null)) {
      getMostRecentDecl$Redeclarable$Const();
    }
    
    return (Data.getPointer() != null);
  }

  
  /// \brief Retrieve the definition of this class, or NULL if this class 
  /// has been forward-declared (with \@class) but not yet defined (with 
  /// \@interface).
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1454,
   FQN="clang::ObjCInterfaceDecl::getDefinition", NM="_ZN5clang17ObjCInterfaceDecl13getDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl13getDefinitionEv")
  //</editor-fold>
  public ObjCInterfaceDecl /*P*/ getDefinition() {
    return hasDefinition() ? Data.getPointer().Definition : null;
  }

  
  /// \brief Retrieve the definition of this class, or NULL if this class 
  /// has been forward-declared (with \@class) but not yet defined (with 
  /// \@interface).
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1461,
   FQN="clang::ObjCInterfaceDecl::getDefinition", NM="_ZNK5clang17ObjCInterfaceDecl13getDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl13getDefinitionEv")
  //</editor-fold>
  public /*const*/ ObjCInterfaceDecl /*P*/ getDefinition$Const() /*const*/ {
    return hasDefinition() ? Data.getPointer().Definition : null;
  }

  
  /// \brief Starts the definition of this Objective-C class, taking it from
  /// a forward declaration (\@class) to a definition (\@interface).
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::startDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 581,
   FQN="clang::ObjCInterfaceDecl::startDefinition", NM="_ZN5clang17ObjCInterfaceDecl15startDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl15startDefinitionEv")
  //</editor-fold>
  public void startDefinition() {
    allocateDefinitionData();
    
    // Update all of the declarations with a pointer to the definition.
    for (ObjCInterfaceDecl /*P*/ RD : redeclarable_redecls()) {
      if (RD != this) {
        RD.Data.$assign(Data);
      }
    }
  }

  
  /// Retrieve the superclass type.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getSuperClassType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1470,
   FQN="clang::ObjCInterfaceDecl::getSuperClassType", NM="_ZNK5clang17ObjCInterfaceDecl17getSuperClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl17getSuperClassTypeEv")
  //</editor-fold>
  public /*const*/ ObjCObjectType /*P*/ getSuperClassType() /*const*/ {
    {
      TypeSourceInfo /*P*/ TInfo = getSuperClassTInfo();
      if ((TInfo != null)) {
        return TInfo.getType().$arrow().castAs(ObjCObjectType.class);
      }
    }
    
    return null;
  }

  
  // Retrieve the type source information for the superclass.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getSuperClassTInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1478,
   FQN="clang::ObjCInterfaceDecl::getSuperClassTInfo", NM="_ZNK5clang17ObjCInterfaceDecl18getSuperClassTInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl18getSuperClassTInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getSuperClassTInfo() /*const*/ {
    // FIXME: Should make sure no callers ever do this.
    if (!hasDefinition()) {
      return null;
    }
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    
    return data().SuperClassTInfo;
  }

  
  // Retrieve the declaration for the superclass of this class, which
  // does not include any type arguments that apply to the superclass.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getSuperClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 314,
   FQN="clang::ObjCInterfaceDecl::getSuperClass", NM="_ZNK5clang17ObjCInterfaceDecl13getSuperClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl13getSuperClassEv")
  //</editor-fold>
  public ObjCInterfaceDecl /*P*/ getSuperClass() /*const*/ {
    // FIXME: Should make sure no callers ever do this.
    if (!hasDefinition()) {
      return null;
    }
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    {
      
      /*const*/ ObjCObjectType /*P*/ superType = getSuperClassType();
      if ((superType != null)) {
        {
          ObjCInterfaceDecl /*P*/ superDecl = superType.getInterface();
          if ((superDecl != null)) {
            {
              ObjCInterfaceDecl /*P*/ superDef = superDecl.getDefinition();
              if ((superDef != null)) {
                return superDef;
              }
            }
            
            return superDecl;
          }
        }
      }
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::setSuperClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1493,
   FQN="clang::ObjCInterfaceDecl::setSuperClass", NM="_ZN5clang17ObjCInterfaceDecl13setSuperClassEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl13setSuperClassEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setSuperClass(TypeSourceInfo /*P*/ superClass) {
    data().SuperClassTInfo = superClass;
  }

  
  /// \brief Iterator that walks over the list of categories, filtering out
  /// those that do not meet specific criteria.
  ///
  /// This class template is used for the various permutations of category
  /// and extension iterators.
  /*template <bool (*)(ObjCCategoryDecl *) Filter> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::filtered_category_iterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1502,
   FQN="clang::ObjCInterfaceDecl::filtered_category_iterator", NM="_ZN5clang17ObjCInterfaceDecl26filtered_category_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl26filtered_category_iteratorE")
  //</editor-fold>
  public static class filtered_category_iterator/*<BoolPredicate<ObjCCategoryDecl> Filter>*/ implements type$iterator<filtered_category_iterator, ObjCCategoryDecl> {
    private ObjCCategoryDecl /*P*/ Current;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::filtered_category_iterator::findAcceptableCategory">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2763,
     FQN="clang::ObjCInterfaceDecl::filtered_category_iterator::findAcceptableCategory", NM="_ZN5clang17ObjCInterfaceDecl26filtered_category_iterator22findAcceptableCategoryEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl26filtered_category_iterator22findAcceptableCategoryEv")
    //</editor-fold>
    private void findAcceptableCategory() {
      while (Native.$bool(Current) && Native.$not(Filter.$call(Current))) {
        Current = Current.getNextClassCategoryRaw();
      }
    }

  /*public:*/
    /*typedef ObjCCategoryDecl *value_type*/
//    public final class value_type extends ObjCCategoryDecl /*P*/ { };
    /*typedef value_type reference*/
//    public final class reference extends ObjCCategoryDecl /*P*/ { };
    /*typedef value_type pointer*/
//    public final class pointer extends ObjCCategoryDecl /*P*/ { };
    /*typedef std::ptrdiff_t difference_type*/;
    /*typedef std::input_iterator_tag iterator_category*/
//    public final class iterator_category extends std.input_iterator_tag{ };
    
    //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::filtered_category_iterator::filtered_category_iterator<Filter>">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1515,
     FQN="clang::ObjCInterfaceDecl::filtered_category_iterator::filtered_category_iterator<Filter>", NM="_ZN5clang17ObjCInterfaceDecl26filtered_category_iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl26filtered_category_iteratorC1Ev")
    //</editor-fold>
    public filtered_category_iterator(BoolPredicate<ObjCCategoryDecl> Filter) {
      // : Current(null) 
      //START JInit
      this.Current = null;
      this.Filter = Filter;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::filtered_category_iterator::filtered_category_iterator<Filter>">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1516,
     FQN="clang::ObjCInterfaceDecl::filtered_category_iterator::filtered_category_iterator<Filter>", NM="_ZN5clang17ObjCInterfaceDecl26filtered_category_iteratorC1EPNS_16ObjCCategoryDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl26filtered_category_iteratorC1EPNS_16ObjCCategoryDeclE")
    //</editor-fold>
    public /*explicit*/ filtered_category_iterator(ObjCCategoryDecl /*P*/ Current, BoolPredicate<ObjCCategoryDecl> Filter) {
      // : Current(Current) 
      //START JInit
      this.Current = Current;
      this.Filter = Filter;
      //END JInit
      findAcceptableCategory();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::filtered_category_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1522,
     FQN="clang::ObjCInterfaceDecl::filtered_category_iterator::operator*", NM="_ZNK5clang17ObjCInterfaceDecl26filtered_category_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl26filtered_category_iteratordeEv")
    //</editor-fold>
    public ObjCCategoryDecl /*P*/ $star() /*const*/ {
      return Current;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::filtered_category_iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1523,
     FQN="clang::ObjCInterfaceDecl::filtered_category_iterator::operator->", NM="_ZNK5clang17ObjCInterfaceDecl26filtered_category_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl26filtered_category_iteratorptEv")
    //</editor-fold>
    public ObjCCategoryDecl /*P*/ $arrow() /*const*/ {
      return Current;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::filtered_category_iterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2771,
     FQN="clang::ObjCInterfaceDecl::filtered_category_iterator::operator++", NM="_ZN5clang17ObjCInterfaceDecl26filtered_category_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl26filtered_category_iteratorppEv")
    //</editor-fold>
    public /*inline*/ ObjCInterfaceDecl.filtered_category_iterator /*&*/ $preInc() {
      Current = Current.getNextClassCategoryRaw();
      findAcceptableCategory();
      return this; //Native.$star(this);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::filtered_category_iterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1527,
     FQN="clang::ObjCInterfaceDecl::filtered_category_iterator::operator++", NM="_ZN5clang17ObjCInterfaceDecl26filtered_category_iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl26filtered_category_iteratorppEi")
    //</editor-fold>
    public filtered_category_iterator/*<Filter>*/ $postInc(int $Prm0) {
      filtered_category_iterator/*<Filter>*/ Tmp = new filtered_category_iterator(Current, Filter); //Native.$star(this);
      this.$preInc(); //++(Native.$star(this));
      return Tmp;
    }

    
    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1533,
     FQN="clang::operator==", NM="_ZN5clangeqENS_17ObjCInterfaceDecl26filtered_category_iteratorIXT_EEES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clangeqENS_17ObjCInterfaceDecl26filtered_category_iteratorIXT_EEES3_")
    //</editor-fold>
    public static boolean $eq_filtered_category_iterator$Filter(filtered_category_iterator/*<Filter>*/ X, 
                                         filtered_category_iterator/*<Filter>*/ Y) {
      return X.Current == Y.Current;
    }

    
    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1538,
     FQN="clang::operator!=", NM="_ZN5clangneENS_17ObjCInterfaceDecl26filtered_category_iteratorIXT_EEES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clangneENS_17ObjCInterfaceDecl26filtered_category_iteratorIXT_EEES3_")
    //</editor-fold>
    public static boolean $noteq_filtered_category_iterator$Filter(filtered_category_iterator/*<Filter>*/ X, 
                                            filtered_category_iterator/*<Filter>*/ Y) {
      return X.Current != Y.Current;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    private final BoolPredicate<ObjCCategoryDecl> Filter;
    
    public filtered_category_iterator(filtered_category_iterator $Prm0) { this.Current = $Prm0.Current; this.Filter = $Prm0.Filter; }

    @Override public filtered_category_iterator clone() { return new filtered_category_iterator(this); }

    @Override public boolean $eq(Object other) { return $eq_filtered_category_iterator$Filter(this, (filtered_category_iterator)other); }
    
    @Override public boolean $noteq(Object other) { return $noteq_filtered_category_iterator$Filter(this, (filtered_category_iterator)other); }
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Current=" + Current; // NOI18N
    }
  };
/*private:*/
  /// \brief Test whether the given category is visible.
  ///
  /// Used in the \c visible_categories_iterator.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::isVisibleCategory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2779,
   FQN="clang::ObjCInterfaceDecl::isVisibleCategory", NM="_ZN5clang17ObjCInterfaceDecl17isVisibleCategoryEPNS_16ObjCCategoryDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl17isVisibleCategoryEPNS_16ObjCCategoryDeclE")
  //</editor-fold>
  private static /*inline*/ boolean isVisibleCategory(ObjCCategoryDecl /*P*/ Cat) {
    return !Cat.isHidden();
  }

/*public:*/
  /// \brief Iterator that walks over the list of categories and extensions
  /// that are visible, i.e., not hidden in a non-imported submodule.
  /*typedef filtered_category_iterator<isVisibleCategory> visible_categories_iterator*/
//  public final class visible_categories_iterator extends filtered_category_iterator{ };
  
  /*typedef llvm::iterator_range<visible_categories_iterator> visible_categories_range*/
//  public final class visible_categories_range extends iterator_range<ObjCCategoryDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::visible_categories">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1559,
   FQN="clang::ObjCInterfaceDecl::visible_categories", NM="_ZNK5clang17ObjCInterfaceDecl18visible_categoriesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl18visible_categoriesEv")
  //</editor-fold>
  public iterator_range<ObjCCategoryDecl /*P*/ > visible_categories() /*const*/ {
    return new iterator_range<ObjCCategoryDecl /*P*/ >(visible_categories_begin(), 
        visible_categories_end());
  }

  
  /// \brief Retrieve an iterator to the beginning of the visible-categories
  /// list.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::visible_categories_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1566,
   FQN="clang::ObjCInterfaceDecl::visible_categories_begin", NM="_ZNK5clang17ObjCInterfaceDecl24visible_categories_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl24visible_categories_beginEv")
  //</editor-fold>
  public filtered_category_iterator visible_categories_begin() /*const*/ {
    return new filtered_category_iterator(getCategoryListRaw(), ObjCInterfaceDecl::isVisibleCategory);
  }

  
  /// \brief Retrieve an iterator to the end of the visible-categories list.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::visible_categories_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1571,
   FQN="clang::ObjCInterfaceDecl::visible_categories_end", NM="_ZNK5clang17ObjCInterfaceDecl22visible_categories_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl22visible_categories_endEv")
  //</editor-fold>
  public filtered_category_iterator visible_categories_end() /*const*/ {
    return new filtered_category_iterator(ObjCInterfaceDecl::isVisibleCategory);
  }

  
  /// \brief Determine whether the visible-categories list is empty.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::visible_categories_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1576,
   FQN="clang::ObjCInterfaceDecl::visible_categories_empty", NM="_ZNK5clang17ObjCInterfaceDecl24visible_categories_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl24visible_categories_emptyEv")
  //</editor-fold>
  public boolean visible_categories_empty() /*const*/ {
    return $eq_filtered_category_iterator$Filter(visible_categories_begin(), visible_categories_end());
  }

/*private:*/
  /// \brief Test whether the given category... is a category.
  ///
  /// Used in the \c known_categories_iterator.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::isKnownCategory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1584,
   FQN="clang::ObjCInterfaceDecl::isKnownCategory", NM="_ZN5clang17ObjCInterfaceDecl15isKnownCategoryEPNS_16ObjCCategoryDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl15isKnownCategoryEPNS_16ObjCCategoryDeclE")
  //</editor-fold>
  private static boolean isKnownCategory(ObjCCategoryDecl /*P*/ $Prm0) {
    return true;
  }

/*public:*/
  /// \brief Iterator that walks over all of the known categories and
  /// extensions, including those that are hidden.
  /*typedef filtered_category_iterator<isKnownCategory> known_categories_iterator*/
//  public final class known_categories_iterator extends filtered_category_iterator{ };
  /*typedef llvm::iterator_range<known_categories_iterator> known_categories_range*/
//  public final class known_categories_range extends iterator_range<ObjCCategoryDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::known_categories">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1593,
   FQN="clang::ObjCInterfaceDecl::known_categories", NM="_ZNK5clang17ObjCInterfaceDecl16known_categoriesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl16known_categoriesEv")
  //</editor-fold>
  public iterator_range<ObjCCategoryDecl /*P*/ > known_categories() /*const*/ {
    return new iterator_range<ObjCCategoryDecl /*P*/ >(known_categories_begin(), 
        known_categories_end());
  }

  
  /// \brief Retrieve an iterator to the beginning of the known-categories
  /// list.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::known_categories_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1600,
   FQN="clang::ObjCInterfaceDecl::known_categories_begin", NM="_ZNK5clang17ObjCInterfaceDecl22known_categories_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl22known_categories_beginEv")
  //</editor-fold>
  public filtered_category_iterator known_categories_begin() /*const*/ {
    return new filtered_category_iterator(getCategoryListRaw(), ObjCInterfaceDecl::isKnownCategory);
  }

  
  /// \brief Retrieve an iterator to the end of the known-categories list.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::known_categories_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1605,
   FQN="clang::ObjCInterfaceDecl::known_categories_end", NM="_ZNK5clang17ObjCInterfaceDecl20known_categories_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl20known_categories_endEv")
  //</editor-fold>
  public filtered_category_iterator known_categories_end() /*const*/ {
    return new filtered_category_iterator(ObjCInterfaceDecl::isKnownCategory);
  }

  
  /// \brief Determine whether the known-categories list is empty.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::known_categories_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1610,
   FQN="clang::ObjCInterfaceDecl::known_categories_empty", NM="_ZNK5clang17ObjCInterfaceDecl22known_categories_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl22known_categories_emptyEv")
  //</editor-fold>
  public boolean known_categories_empty() /*const*/ {
    return $eq_filtered_category_iterator$Filter(known_categories_begin(), known_categories_end());
  }

/*private:*/
  /// \brief Test whether the given category is a visible extension.
  ///
  /// Used in the \c visible_extensions_iterator.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::isVisibleExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2783,
   FQN="clang::ObjCInterfaceDecl::isVisibleExtension", NM="_ZN5clang17ObjCInterfaceDecl18isVisibleExtensionEPNS_16ObjCCategoryDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl18isVisibleExtensionEPNS_16ObjCCategoryDeclE")
  //</editor-fold>
  private static /*inline*/ boolean isVisibleExtension(ObjCCategoryDecl /*P*/ Cat) {
    return Cat.IsClassExtension() && !Cat.isHidden();
  }

/*public:*/
  /// \brief Iterator that walks over all of the visible extensions, skipping
  /// any that are known but hidden.
  /*typedef filtered_category_iterator<isVisibleExtension> visible_extensions_iterator*/
//  public final class visible_extensions_iterator extends filtered_category_iterator{ };
  
  /*typedef llvm::iterator_range<visible_extensions_iterator> visible_extensions_range*/
//  public final class visible_extensions_range extends iterator_range<ObjCCategoryDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::visible_extensions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1629,
   FQN="clang::ObjCInterfaceDecl::visible_extensions", NM="_ZNK5clang17ObjCInterfaceDecl18visible_extensionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl18visible_extensionsEv")
  //</editor-fold>
  public iterator_range<ObjCCategoryDecl /*P*/ > visible_extensions() /*const*/ {
    return new iterator_range<ObjCCategoryDecl /*P*/ >(visible_extensions_begin(), 
        visible_extensions_end());
  }

  
  /// \brief Retrieve an iterator to the beginning of the visible-extensions
  /// list.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::visible_extensions_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1636,
   FQN="clang::ObjCInterfaceDecl::visible_extensions_begin", NM="_ZNK5clang17ObjCInterfaceDecl24visible_extensions_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl24visible_extensions_beginEv")
  //</editor-fold>
  public filtered_category_iterator visible_extensions_begin() /*const*/ {
    return new filtered_category_iterator(getCategoryListRaw(), ObjCInterfaceDecl::isVisibleExtension);
  }

  
  /// \brief Retrieve an iterator to the end of the visible-extensions list.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::visible_extensions_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1641,
   FQN="clang::ObjCInterfaceDecl::visible_extensions_end", NM="_ZNK5clang17ObjCInterfaceDecl22visible_extensions_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl22visible_extensions_endEv")
  //</editor-fold>
  public filtered_category_iterator visible_extensions_end() /*const*/ {
    return new filtered_category_iterator(ObjCInterfaceDecl::isVisibleExtension);
  }

  
  /// \brief Determine whether the visible-extensions list is empty.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::visible_extensions_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1646,
   FQN="clang::ObjCInterfaceDecl::visible_extensions_empty", NM="_ZNK5clang17ObjCInterfaceDecl24visible_extensions_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl24visible_extensions_emptyEv")
  //</editor-fold>
  public boolean visible_extensions_empty() /*const*/ {
    return $eq_filtered_category_iterator$Filter(visible_extensions_begin(), visible_extensions_end());
  }

/*private:*/
  /// \brief Test whether the given category is an extension.
  ///
  /// Used in the \c known_extensions_iterator.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::isKnownExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2787,
   FQN="clang::ObjCInterfaceDecl::isKnownExtension", NM="_ZN5clang17ObjCInterfaceDecl16isKnownExtensionEPNS_16ObjCCategoryDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl16isKnownExtensionEPNS_16ObjCCategoryDeclE")
  //</editor-fold>
  private static /*inline*/ boolean isKnownExtension(ObjCCategoryDecl /*P*/ Cat) {
    return Cat.IsClassExtension();
  }

/*public:*/
  /// \brief Iterator that walks over all of the known extensions.
  /*typedef filtered_category_iterator<isKnownExtension> known_extensions_iterator*/
//  public final class known_extensions_iterator extends filtered_category_iterator{ };
  /*typedef llvm::iterator_range<known_extensions_iterator> known_extensions_range*/
//  public final class known_extensions_range extends iterator_range<ObjCCategoryDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::known_extensions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1663,
   FQN="clang::ObjCInterfaceDecl::known_extensions", NM="_ZNK5clang17ObjCInterfaceDecl16known_extensionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl16known_extensionsEv")
  //</editor-fold>
  public iterator_range<ObjCCategoryDecl /*P*/ > known_extensions() /*const*/ {
    return new iterator_range<ObjCCategoryDecl /*P*/ >(known_extensions_begin(), 
        known_extensions_end());
  }

  
  /// \brief Retrieve an iterator to the beginning of the known-extensions
  /// list.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::known_extensions_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1670,
   FQN="clang::ObjCInterfaceDecl::known_extensions_begin", NM="_ZNK5clang17ObjCInterfaceDecl22known_extensions_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl22known_extensions_beginEv")
  //</editor-fold>
  public filtered_category_iterator known_extensions_begin() /*const*/ {
    return new filtered_category_iterator(getCategoryListRaw(), ObjCInterfaceDecl::isKnownExtension);
  }

  
  /// \brief Retrieve an iterator to the end of the known-extensions list.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::known_extensions_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1675,
   FQN="clang::ObjCInterfaceDecl::known_extensions_end", NM="_ZNK5clang17ObjCInterfaceDecl20known_extensions_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl20known_extensions_endEv")
  //</editor-fold>
  public filtered_category_iterator known_extensions_end() /*const*/ {
    return new filtered_category_iterator(ObjCInterfaceDecl::isKnownExtension);
  }

  
  /// \brief Determine whether the known-extensions list is empty.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::known_extensions_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1680,
   FQN="clang::ObjCInterfaceDecl::known_extensions_empty", NM="_ZNK5clang17ObjCInterfaceDecl22known_extensions_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl22known_extensions_emptyEv")
  //</editor-fold>
  public boolean known_extensions_empty() /*const*/ {
    return $eq_filtered_category_iterator$Filter(known_extensions_begin(), known_extensions_end());
  }

  
  /// \brief Retrieve the raw pointer to the start of the category/extension
  /// list.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getCategoryListRaw">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1686,
   FQN="clang::ObjCInterfaceDecl::getCategoryListRaw", NM="_ZNK5clang17ObjCInterfaceDecl18getCategoryListRawEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl18getCategoryListRawEv")
  //</editor-fold>
  public ObjCCategoryDecl /*P*/ getCategoryListRaw() /*const*/ {
    // FIXME: Should make sure no callers ever do this.
    if (!hasDefinition()) {
      return null;
    }
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    
    return data().CategoryList;
  }

  
  /// \brief Set the raw pointer to the start of the category/extension
  /// list.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::setCategoryListRaw">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1699,
   FQN="clang::ObjCInterfaceDecl::setCategoryListRaw", NM="_ZN5clang17ObjCInterfaceDecl18setCategoryListRawEPNS_16ObjCCategoryDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl18setCategoryListRawEPNS_16ObjCCategoryDeclE")
  //</editor-fold>
  public void setCategoryListRaw(ObjCCategoryDecl /*P*/ category) {
    data().CategoryList = category;
  }

  
  
  /// FindPropertyVisibleInPrimaryClass - Finds declaration of the property
  /// with name 'PropertyId' in the primary class; including those in protocols
  /// (direct or indirect) used by the primary class.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::FindPropertyVisibleInPrimaryClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 345,
   FQN="clang::ObjCInterfaceDecl::FindPropertyVisibleInPrimaryClass", NM="_ZNK5clang17ObjCInterfaceDecl33FindPropertyVisibleInPrimaryClassEPNS_14IdentifierInfoENS_21ObjCPropertyQueryKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl33FindPropertyVisibleInPrimaryClassEPNS_14IdentifierInfoENS_21ObjCPropertyQueryKindE")
  //</editor-fold>
  public ObjCPropertyDecl /*P*/ FindPropertyVisibleInPrimaryClass(IdentifierInfo /*P*/ PropertyId, 
                                   /*ObjCPropertyQueryKind*/byte/*uint8_t*/ QueryKind) /*const*/ {
    // FIXME: Should make sure no callers ever do this.
    if (!hasDefinition()) {
      return null;
    }
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    {
      
      ObjCPropertyDecl /*P*/ PD = ObjCPropertyDecl.findPropertyDecl(cast_DeclContext(this), PropertyId, 
          QueryKind);
      if ((PD != null)) {
        return PD;
      }
    }
    
    // Look through protocols.
    for (/*const*/ ObjCProtocolDecl /*P*/ I : all_referenced_protocols())  {
      {
        ObjCPropertyDecl /*P*/ P = I.FindPropertyDeclaration(PropertyId, 
            QueryKind);
        if ((P != null)) {
          return P;
        }
      }
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::collectPropertiesToImplement">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 370,
   FQN="clang::ObjCInterfaceDecl::collectPropertiesToImplement", NM="_ZNK5clang17ObjCInterfaceDecl28collectPropertiesToImplementERN4llvm8DenseMapISt4pairIPNS_14IdentifierInfoEjEPNS_16ObjCPropertyDeclENS1_12DenseMapInfoIS6_EENS1_6detail12DenseMapPairIS6_S8_EEEERNS1_11SmallVectorIS8_Lj8EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl28collectPropertiesToImplementERN4llvm8DenseMapISt4pairIPNS_14IdentifierInfoEjEPNS_16ObjCPropertyDeclENS1_12DenseMapInfoIS6_EENS1_6detail12DenseMapPairIS6_S8_EEEERNS1_11SmallVectorIS8_Lj8EEE")
  //</editor-fold>
  @Override public void collectPropertiesToImplement(final DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > /*&*/ PM, 
                              final SmallVector<ObjCPropertyDecl /*P*/ > /*&*/ PO) /*const*//* override*/ {
    for (ObjCPropertyDecl /*P*/ Prop : properties()) {
      PM.$set(std.make_pair_Ptr_bool2uint(Prop.getIdentifier(), Prop.isClassProperty()), Prop);
      PO.push_back(Prop);
    }
    for (/*const*/ ObjCCategoryDecl /*P*/ Ext : known_extensions()) {
      /*const*/ ObjCCategoryDecl /*P*/ ClassExt = Ext;
      for (ObjCPropertyDecl /*P*/ Prop : ClassExt.properties()) {
        PM.$set(std.make_pair_Ptr_bool2uint(Prop.getIdentifier(), Prop.isClassProperty()), Prop);
        PO.push_back(Prop);
      }
    }
    for (/*const*/ ObjCProtocolDecl /*P*/ PI : all_referenced_protocols())  {
      PI.collectPropertiesToImplement(PM, PO);
    }
    // Note, the properties declared only in class extensions are still copied
    // into the main @interface's property list, and therefore we don't
    // explicitly, have to search class extension properties.
  }

  
  /// isSuperClassOf - Return true if this class is the specified class or is a
  /// super class of the specified interface class.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::isSuperClassOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1712,
   FQN="clang::ObjCInterfaceDecl::isSuperClassOf", NM="_ZNK5clang17ObjCInterfaceDecl14isSuperClassOfEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl14isSuperClassOfEPKS0_")
  //</editor-fold>
  public boolean isSuperClassOf(/*const*/ ObjCInterfaceDecl /*P*/ I) /*const*/ {
    // If RHS is derived from LHS it is OK; else it is not OK.
    while (I != null) {
      if (declaresSameEntity(this, I)) {
        return true;
      }
      
      I = I.getSuperClass();
    }
    return false;
  }

  
  /// isArcWeakrefUnavailable - Checks for a class or one of its super classes
  /// to be incompatible with __weak references. Returns true if it is.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::isArcWeakrefUnavailable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 390,
   FQN="clang::ObjCInterfaceDecl::isArcWeakrefUnavailable", NM="_ZNK5clang17ObjCInterfaceDecl23isArcWeakrefUnavailableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl23isArcWeakrefUnavailableEv")
  //</editor-fold>
  public boolean isArcWeakrefUnavailable() /*const*/ {
    /*const*/ ObjCInterfaceDecl /*P*/ Class = this;
    while ((Class != null)) {
      if (Class.hasAttr(ArcWeakrefUnavailableAttr.class)) {
        return true;
      }
      Class = Class.getSuperClass();
    }
    return false;
  }

  
  /// isObjCRequiresPropertyDefs - Checks that a class or one of its super 
  /// classes must not be auto-synthesized. Returns class decl. if it must not
  /// be; 0, otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::isObjCRequiresPropertyDefs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 400,
   FQN="clang::ObjCInterfaceDecl::isObjCRequiresPropertyDefs", NM="_ZNK5clang17ObjCInterfaceDecl26isObjCRequiresPropertyDefsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl26isObjCRequiresPropertyDefsEv")
  //</editor-fold>
  public /*const*/ ObjCInterfaceDecl /*P*/ isObjCRequiresPropertyDefs() /*const*/ {
    /*const*/ ObjCInterfaceDecl /*P*/ Class = this;
    while ((Class != null)) {
      if (Class.hasAttr(ObjCRequiresPropertyDefsAttr.class)) {
        return Class;
      }
      Class = Class.getSuperClass();
    }
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::lookupInstanceVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 591,
   FQN="clang::ObjCInterfaceDecl::lookupInstanceVariable", NM="_ZN5clang17ObjCInterfaceDecl22lookupInstanceVariableEPNS_14IdentifierInfoERPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl22lookupInstanceVariableEPNS_14IdentifierInfoERPS0_")
  //</editor-fold>
  public ObjCIvarDecl /*P*/ lookupInstanceVariable(IdentifierInfo /*P*/ ID, 
                        final type$ref<ObjCInterfaceDecl /*P*/ /*&*/> clsDeclared) {
    // FIXME: Should make sure no callers ever do this.
    if (!hasDefinition()) {
      return null;
    }
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    
    ObjCInterfaceDecl /*P*/ ClassDecl = this;
    while (ClassDecl != null) {
      {
        ObjCIvarDecl /*P*/ I = ClassDecl.getIvarDecl(ID);
        if ((I != null)) {
          clsDeclared.$set(ClassDecl);
          return I;
        }
      }
      
      for (/*const*/ ObjCCategoryDecl /*P*/ Ext : ClassDecl.visible_extensions()) {
        {
          ObjCIvarDecl /*P*/ I = Ext.getIvarDecl(ID);
          if ((I != null)) {
            clsDeclared.$set(ClassDecl);
            return I;
          }
        }
      }
      
      ClassDecl = ClassDecl.getSuperClass();
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::lookupInstanceVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1734,
   FQN="clang::ObjCInterfaceDecl::lookupInstanceVariable", NM="_ZN5clang17ObjCInterfaceDecl22lookupInstanceVariableEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl22lookupInstanceVariableEPNS_14IdentifierInfoE")
  //</editor-fold>
  public ObjCIvarDecl /*P*/ lookupInstanceVariable(IdentifierInfo /*P*/ IVarName) {
    type$ref<ObjCInterfaceDecl /*P*/ > ClassDeclared = create_type$ref();
    return lookupInstanceVariable(IVarName, ClassDeclared);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::lookupNestedProtocol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 640,
   FQN="clang::ObjCInterfaceDecl::lookupNestedProtocol", NM="_ZN5clang17ObjCInterfaceDecl20lookupNestedProtocolEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl20lookupNestedProtocolEPNS_14IdentifierInfoE")
  //</editor-fold>
  public ObjCProtocolDecl /*P*/ lookupNestedProtocol(IdentifierInfo /*P*/ Name) {
    for (ObjCProtocolDecl /*P*/ P : all_referenced_protocols())  {
      if ((P.lookupProtocolNamed(Name) != null)) {
        return P;
      }
    }
    ObjCInterfaceDecl /*P*/ SuperClass = getSuperClass();
    return (SuperClass != null) ? SuperClass.lookupNestedProtocol(Name) : null;
  }

  
  // Lookup a method. First, we search locally. If a method isn't
  // found, we search referenced protocols and class categories.
  
  /// lookupMethod - This method returns an instance/class method by looking in
  /// the class, its categories, and its super classes (using a linear search).
  /// When argument category "C" is specified, any implicit method found
  /// in this category is ignored.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::lookupMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 653,
   FQN="clang::ObjCInterfaceDecl::lookupMethod", NM="_ZNK5clang17ObjCInterfaceDecl12lookupMethodENS_8SelectorEbbbPKNS_16ObjCCategoryDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl12lookupMethodENS_8SelectorEbbbPKNS_16ObjCCategoryDeclE")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ lookupMethod(Selector Sel, 
              boolean isInstance) /*const*/ {
    return lookupMethod(Sel, 
              isInstance, 
              false, 
              true, 
              (/*const*/ ObjCCategoryDecl /*P*/ )null);
  }
  public ObjCMethodDecl /*P*/ lookupMethod(Selector Sel, 
              boolean isInstance, 
              boolean shallowCategoryLookup/*= false*/) /*const*/ {
    return lookupMethod(Sel, 
              isInstance, 
              shallowCategoryLookup, 
              true, 
              (/*const*/ ObjCCategoryDecl /*P*/ )null);
  }
  public ObjCMethodDecl /*P*/ lookupMethod(Selector Sel, 
              boolean isInstance, 
              boolean shallowCategoryLookup/*= false*/, 
              boolean followSuper/*= true*/) /*const*/ {
    return lookupMethod(Sel, 
              isInstance, 
              shallowCategoryLookup, 
              followSuper, 
              (/*const*/ ObjCCategoryDecl /*P*/ )null);
  }
  public ObjCMethodDecl /*P*/ lookupMethod(Selector Sel, 
              boolean isInstance, 
              boolean shallowCategoryLookup/*= false*/, 
              boolean followSuper/*= true*/, 
              /*const*/ ObjCCategoryDecl /*P*/ C/*= null*/) /*const*/ {
    // FIXME: Should make sure no callers ever do this.
    if (!hasDefinition()) {
      return null;
    }
    
    /*const*/ ObjCInterfaceDecl /*P*/ ClassDecl = this;
    ObjCMethodDecl /*P*/ MethodDecl = null;
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    while ((ClassDecl != null)) {
      // 1. Look through primary class.
      if (((MethodDecl = ClassDecl.getMethod(new Selector(Sel), isInstance)) != null)) {
        return MethodDecl;
      }
      
      // 2. Didn't find one yet - now look through categories.
      for (/*const*/ ObjCCategoryDecl /*P*/ Cat : ClassDecl.visible_categories())  {
        if (((MethodDecl = Cat.getMethod(new Selector(Sel), isInstance)) != null)) {
          if (C != Cat || !MethodDecl.isImplicit()) {
            return MethodDecl;
          }
        }
      }
      
      // 3. Didn't find one yet - look through primary class's protocols.
      for (/*const*/ ObjCProtocolDecl /*P*/ I : ClassDecl.protocols())  {
        if (((MethodDecl = I.lookupMethod(new Selector(Sel), isInstance)) != null)) {
          return MethodDecl;
        }
      }
      
      // 4. Didn't find one yet - now look through categories' protocols
      if (!shallowCategoryLookup) {
        for (/*const*/ ObjCCategoryDecl /*P*/ Cat : ClassDecl.visible_categories()) {
          // Didn't find one yet - look through protocols.
          final /*const*/ ObjCList<ObjCProtocolDecl> /*&*/ Protocols = Cat.getReferencedProtocols();
          for (type$ptr<ObjCProtocolDecl> I = $tryClone(Protocols.begin()), 
              /*P*/ /*const*/ /*P*/ E = $tryClone(Protocols.end()); $noteq_ptr(I, E); I.$preInc())  {
            if (((MethodDecl = (I.$star()).lookupMethod(new Selector(Sel), isInstance)) != null)) {
              if (C != Cat || !MethodDecl.isImplicit()) {
                return MethodDecl;
              }
            }
          }
        }
      }
      if (!followSuper) {
        return null;
      }
      
      // 5. Get to the super class (if any).
      ClassDecl = ClassDecl.getSuperClass();
    }
    return null;
  }

  
  /// Lookup an instance method for a given selector.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::lookupInstanceMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1749,
   FQN="clang::ObjCInterfaceDecl::lookupInstanceMethod", NM="_ZNK5clang17ObjCInterfaceDecl20lookupInstanceMethodENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl20lookupInstanceMethodENS_8SelectorE")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ lookupInstanceMethod(Selector Sel) /*const*/ {
    return lookupMethod(new Selector(Sel), true/*isInstance*/);
  }

  
  /// Lookup a class method for a given selector.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::lookupClassMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1754,
   FQN="clang::ObjCInterfaceDecl::lookupClassMethod", NM="_ZNK5clang17ObjCInterfaceDecl17lookupClassMethodENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl17lookupClassMethodENS_8SelectorE")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ lookupClassMethod(Selector Sel) /*const*/ {
    return lookupMethod(new Selector(Sel), false/*isInstance*/);
  }

  
  /// lookupInheritedClass - This method returns ObjCInterfaceDecl * of the super
  /// class whose name is passed as argument. If it is not one of the super classes
  /// the it returns NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::lookupInheritedClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 622,
   FQN="clang::ObjCInterfaceDecl::lookupInheritedClass", NM="_ZN5clang17ObjCInterfaceDecl20lookupInheritedClassEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl20lookupInheritedClassEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public ObjCInterfaceDecl /*P*/ lookupInheritedClass(/*const*/ IdentifierInfo /*P*/ ICName) {
    // FIXME: Should make sure no callers ever do this.
    if (!hasDefinition()) {
      return null;
    }
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    
    ObjCInterfaceDecl /*P*/ ClassDecl = this;
    while (ClassDecl != null) {
      if (ClassDecl.getIdentifier() == ICName) {
        return ClassDecl;
      }
      ClassDecl = ClassDecl.getSuperClass();
    }
    return null;
  }

  
  /// \brief Lookup a method in the classes implementation hierarchy.
  
  // Will search "local" class/category implementations for a method decl.
  // If failed, then we search in class's root for an instance method.
  // Returns 0 if no method is found.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::lookupPrivateMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 711,
   FQN="clang::ObjCInterfaceDecl::lookupPrivateMethod", NM="_ZNK5clang17ObjCInterfaceDecl19lookupPrivateMethodERKNS_8SelectorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl19lookupPrivateMethodERKNS_8SelectorEb")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ lookupPrivateMethod(final /*const*/ Selector /*&*/ Sel) /*const*/ {
    return lookupPrivateMethod(Sel, 
                     true);
  }
  public ObjCMethodDecl /*P*/ lookupPrivateMethod(final /*const*/ Selector /*&*/ Sel, 
                     boolean Instance/*= true*/) /*const*/ {
    // FIXME: Should make sure no callers ever do this.
    if (!hasDefinition()) {
      return null;
    }
    if (data().ExternallyCompleted) {
      LoadExternalDefinition();
    }
    
    ObjCMethodDecl /*P*/ Method = null;
    {
      ObjCImplementationDecl /*P*/ ImpDecl = getImplementation();
      if ((ImpDecl != null)) {
        Method = Instance ? ImpDecl.getInstanceMethod(new Selector(Sel)) : ImpDecl.getClassMethod(new Selector(Sel));
      }
    }
    
    // Look through local category implementations associated with the class.
    if (!(Method != null)) {
      Method = getCategoryMethod(new Selector(Sel), Instance);
    }
    
    // Before we give up, check if the selector is an instance method.
    // But only in the root. This matches gcc's behavior and what the
    // runtime expects.
    if (!Instance && !(Method != null) && !(getSuperClass() != null)) {
      Method = lookupInstanceMethod(new Selector(Sel));
      // Look through local category implementations associated
      // with the root class.
      if (!(Method != null)) {
        Method = lookupPrivateMethod(Sel, true);
      }
    }
    if (!(Method != null) && (getSuperClass() != null)) {
      return getSuperClass().lookupPrivateMethod(Sel, Instance);
    }
    return Method;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::lookupPrivateClassMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1763,
   FQN="clang::ObjCInterfaceDecl::lookupPrivateClassMethod", NM="_ZN5clang17ObjCInterfaceDecl24lookupPrivateClassMethodERKNS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl24lookupPrivateClassMethodERKNS_8SelectorE")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ lookupPrivateClassMethod(final /*const*/ Selector /*&*/ Sel) {
    return lookupPrivateMethod(Sel, false);
  }

  
  /// \brief Lookup a setter or getter in the class hierarchy,
  /// including in all categories except for category passed
  /// as argument.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::lookupPropertyAccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1770,
   FQN="clang::ObjCInterfaceDecl::lookupPropertyAccessor", NM="_ZNK5clang17ObjCInterfaceDecl22lookupPropertyAccessorENS_8SelectorEPKNS_16ObjCCategoryDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl22lookupPropertyAccessorENS_8SelectorEPKNS_16ObjCCategoryDeclEb")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ lookupPropertyAccessor(/*const*/ Selector Sel, 
                        /*const*/ ObjCCategoryDecl /*P*/ Cat, 
                        boolean IsClassProperty) /*const*/ {
    return lookupMethod(new Selector(Sel), !IsClassProperty/*isInstance*/, 
        false/*shallowCategoryLookup*/, 
        true/* followsSuper */, 
        Cat);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getEndOfDefinitionLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1779,
   FQN="clang::ObjCInterfaceDecl::getEndOfDefinitionLoc", NM="_ZNK5clang17ObjCInterfaceDecl21getEndOfDefinitionLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl21getEndOfDefinitionLocEv")
  //</editor-fold>
  public SourceLocation getEndOfDefinitionLoc() /*const*/ {
    if (!hasDefinition()) {
      return getLocation();
    }
    
    return new SourceLocation(data().EndLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::setEndOfDefinitionLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1786,
   FQN="clang::ObjCInterfaceDecl::setEndOfDefinitionLoc", NM="_ZN5clang17ObjCInterfaceDecl21setEndOfDefinitionLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl21setEndOfDefinitionLocENS_14SourceLocationE")
  //</editor-fold>
  public void setEndOfDefinitionLoc(SourceLocation LE) {
    data().EndLoc.$assign(LE);
  }

  
  /// Retrieve the starting location of the superclass.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getSuperClassLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 334,
   FQN="clang::ObjCInterfaceDecl::getSuperClassLoc", NM="_ZNK5clang17ObjCInterfaceDecl16getSuperClassLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl16getSuperClassLocEv")
  //</editor-fold>
  public SourceLocation getSuperClassLoc() /*const*/ {
    {
      TypeSourceInfo /*P*/ superTInfo = getSuperClassTInfo();
      if ((superTInfo != null)) {
        return superTInfo.getTypeLoc().getLocStart();
      }
    }
    
    return new SourceLocation();
  }

  
  /// isImplicitInterfaceDecl - check that this is an implicitly declared
  /// ObjCInterfaceDecl node. This is for legacy objective-c \@implementation
  /// declaration without an \@interface declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::isImplicitInterfaceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1794,
   FQN="clang::ObjCInterfaceDecl::isImplicitInterfaceDecl", NM="_ZNK5clang17ObjCInterfaceDecl23isImplicitInterfaceDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl23isImplicitInterfaceDeclEv")
  //</editor-fold>
  public boolean isImplicitInterfaceDecl() /*const*/ {
    return hasDefinition() ? data().Definition.isImplicit() : isImplicit();
  }

  
  /// ClassImplementsProtocol - Checks that 'lProto' protocol
  /// has been implemented in IDecl class, its super class or categories (if
  /// lookupCategory is true).
  
  /// ClassImplementsProtocol - Checks that 'lProto' protocol
  /// has been implemented in IDecl class, its super class or categories (if
  /// lookupCategory is true).
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::ClassImplementsProtocol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1632,
   FQN="clang::ObjCInterfaceDecl::ClassImplementsProtocol", NM="_ZN5clang17ObjCInterfaceDecl23ClassImplementsProtocolEPNS_16ObjCProtocolDeclEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl23ClassImplementsProtocolEPNS_16ObjCProtocolDeclEbb")
  //</editor-fold>
  public boolean ClassImplementsProtocol(ObjCProtocolDecl /*P*/ lProto, 
                         boolean lookupCategory) {
    return ClassImplementsProtocol(lProto, 
                         lookupCategory, 
                         false);
  }
  public boolean ClassImplementsProtocol(ObjCProtocolDecl /*P*/ lProto, 
                         boolean lookupCategory, 
                         boolean RHSIsQualifiedID/*= false*/) {
    if (!hasDefinition()) {
      return false;
    }
    
    ObjCInterfaceDecl /*P*/ IDecl = this;
    // 1st, look up the class.
    for (ObjCProtocolDecl /*P*/ PI : IDecl.protocols()) {
      if (getASTContext().ProtocolCompatibleWithProtocol(lProto, PI)) {
        return true;
      }
      // This is dubious and is added to be compatible with gcc.  In gcc, it is
      // also allowed assigning a protocol-qualified 'id' type to a LHS object
      // when protocol in qualified LHS is in list of protocols in the rhs 'id'
      // object. This IMO, should be a bug.
      // FIXME: Treat this as an extension, and flag this as an error when GCC
      // extensions are not enabled.
      if (RHSIsQualifiedID
         && getASTContext().ProtocolCompatibleWithProtocol(PI, lProto)) {
        return true;
      }
    }
    
    // 2nd, look up the category.
    if (lookupCategory) {
      for (/*const*/ ObjCCategoryDecl /*P*/ Cat : visible_categories()) {
        for (ObjCProtocolDecl /*P*/ PI : Cat.protocols())  {
          if (getASTContext().ProtocolCompatibleWithProtocol(lProto, PI)) {
            return true;
          }
        }
      }
    }
    
    // 3rd, look up the super class(s)
    if ((IDecl.getSuperClass() != null)) {
      return IDecl.getSuperClass().ClassImplementsProtocol(lProto, lookupCategory, 
          RHSIsQualifiedID);
    }
    
    return false;
  }

  
  /*typedef redeclarable_base::redecl_range redecl_range*/
//  public final class redecl_range extends iterator_range<ObjCInterfaceDecl /*P*/ >{ };
  /*typedef redeclarable_base::redecl_iterator redecl_iterator*/
//  public final class redecl_iterator extends Redeclarable.<ObjCInterfaceDecl>redecl_iterator{ };
  //JAVA: using Redeclarable<ObjCInterfaceDecl>::redecls_begin;
  //JAVA: using Redeclarable<ObjCInterfaceDecl>::redecls_end;
  //JAVA: using Redeclarable<ObjCInterfaceDecl>::redecls;
  //JAVA: using Redeclarable<ObjCInterfaceDecl>::getPreviousDecl;
  //JAVA: using Redeclarable<ObjCInterfaceDecl>::getMostRecentDecl;
  //JAVA: using Redeclarable<ObjCInterfaceDecl>::isFirstDecl;
  
  /// Retrieves the canonical declaration of this Objective-C class.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1815,
   FQN="clang::ObjCInterfaceDecl::getCanonicalDecl", NM="_ZN5clang17ObjCInterfaceDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public ObjCInterfaceDecl /*P*/ getCanonicalDecl()/* override*/ {
    return getFirstDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1816,
   FQN="clang::ObjCInterfaceDecl::getCanonicalDecl", NM="_ZNK5clang17ObjCInterfaceDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ ObjCInterfaceDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return getFirstDecl$Const();
  }

  
  // Low-level accessor
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::getTypeForDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1819,
   FQN="clang::ObjCInterfaceDecl::getTypeForDecl", NM="_ZNK5clang17ObjCInterfaceDecl14getTypeForDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl14getTypeForDeclEv")
  //</editor-fold>
  public /*const*/ Type /*P*/ getTypeForDecl() /*const*/ {
    return TypeForDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::setTypeForDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1820,
   FQN="clang::ObjCInterfaceDecl::setTypeForDecl", NM="_ZNK5clang17ObjCInterfaceDecl14setTypeForDeclEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl14setTypeForDeclEPKNS_4TypeE")
  //</editor-fold>
  public void setTypeForDecl(/*const*/ Type /*P*/ TD) /*const*/ {
    TypeForDecl = TD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1822,
   FQN="clang::ObjCInterfaceDecl::classof", NM="_ZN5clang17ObjCInterfaceDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1823,
   FQN="clang::ObjCInterfaceDecl::classofKind", NM="_ZN5clang17ObjCInterfaceDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.ObjCInterface;
  }

  
  /*friend  class ASTReader*/
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::findInterfaceWithDesignatedInitializers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 452,
   FQN="clang::ObjCInterfaceDecl::findInterfaceWithDesignatedInitializers", NM="_ZNK5clang17ObjCInterfaceDecl39findInterfaceWithDesignatedInitializersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl39findInterfaceWithDesignatedInitializersEv")
  //</editor-fold>
  private /*const*/ ObjCInterfaceDecl /*P*/ findInterfaceWithDesignatedInitializers() /*const*/ {
    /*const*/ ObjCInterfaceDecl /*P*/ IFace = this;
    while ((IFace != null)) {
      if (IFace.hasDesignatedInitializers()) {
        return IFace;
      }
      if (!IFace.inheritsDesignatedInitializers()) {
        break;
      }
      IFace = IFace.getSuperClass();
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::inheritsDesignatedInitializers">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 485,
   FQN="clang::ObjCInterfaceDecl::inheritsDesignatedInitializers", NM="_ZNK5clang17ObjCInterfaceDecl30inheritsDesignatedInitializersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCInterfaceDecl30inheritsDesignatedInitializersEv")
  //</editor-fold>
  private boolean inheritsDesignatedInitializers() /*const*/ {
    switch (ObjCInterfaceDecl.DefinitionData.InheritedDesignatedInitializersState.valueOf(data().InheritedDesignatedInitializers)) {
     case IDI_Inherited:
      return true;
     case IDI_NotInherited:
      return false;
     case IDI_Unknown:
      {
        // If the class introduced initializers we conservatively assume that we
        // don't know if any of them is a designated initializer to avoid possible
        // misleading warnings.
        if (isIntroducingInitializers(this)) {
          data().InheritedDesignatedInitializers = $uint2uint_2bits(DefinitionData.InheritedDesignatedInitializersState.IDI_NotInherited.getValue());
        } else {
          {
            ObjCInterfaceDecl /*P*/ SuperD = getSuperClass();
            if ((SuperD != null)) {
              data().InheritedDesignatedInitializers
                 = $uint2uint_2bits(SuperD.declaresOrInheritsDesignatedInitializers() ? DefinitionData.InheritedDesignatedInitializersState.IDI_Inherited.getValue() : DefinitionData.InheritedDesignatedInitializersState.IDI_NotInherited.getValue());
            } else {
              data().InheritedDesignatedInitializers
                 = $uint2uint_2bits(DefinitionData.InheritedDesignatedInitializersState.IDI_NotInherited.getValue());
            }
          }
        }
        assert (data().InheritedDesignatedInitializers != $int2uint_2bits(DefinitionData.InheritedDesignatedInitializersState.IDI_Unknown.getValue()));
        return data().InheritedDesignatedInitializers
           == $int2uint_2bits(DefinitionData.InheritedDesignatedInitializersState.IDI_Inherited.getValue());
      }
    }
    throw new llvm_unreachable("unexpected InheritedDesignatedInitializers value");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceDecl::~ObjCInterfaceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1091,
   FQN="clang::ObjCInterfaceDecl::~ObjCInterfaceDecl", NM="_ZN5clang17ObjCInterfaceDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCInterfaceDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    Redeclarable.super.$destroy$Redeclarable();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override 
  public final ObjCInterfaceDecl getPreviousDecl() { 
    return (ObjCInterfaceDecl)Redeclarable.super.getPreviousDecl$Redeclarable(); 
  } 
  
  @Override 
  public final ObjCInterfaceDecl getPreviousDecl$Const() { 
    return (ObjCInterfaceDecl)Redeclarable.super.getPreviousDecl$Redeclarable$Const(); 
  } 
   
  @Override 
  public final ObjCInterfaceDecl getMostRecentDecl() { 
    return (ObjCInterfaceDecl)Redeclarable.super.getMostRecentDecl$Redeclarable(); 
  } 
  
  @Override 
  public final ObjCInterfaceDecl getMostRecentDecl$Const() { 
    return (ObjCInterfaceDecl)Redeclarable.super.getMostRecentDecl$Redeclarable$Const(); 
  } 
  
  @Override 
  public final boolean isFirstDecl() { 
    return Redeclarable.super.isFirstDecl$Redeclarable(); 
  } 


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  private final Redeclarable$Fields Redeclarable$Flds;// use return value of $Redeclarable();
  @Override public final Redeclarable$Fields $Redeclarable$Fields() { return Redeclarable$Flds; }
  
  @Override public String toString() {
    return "" + "TypeForDecl=" + TypeForDecl // NOI18N
              + ", TypeParamList=" + TypeParamList // NOI18N
              + ", Data=" + Data.getBool() + ":" + NativeTrace.getIdentityStr(Data.getPointer()) // NOI18N
              + super.toString(); // NOI18N
  }
}
