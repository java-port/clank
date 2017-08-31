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
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.ASTContextGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


/// \brief Represents a C++ nested name specifier, such as
/// "\::std::vector<int>::".
///
/// C++ nested name specifiers are the prefixes to qualified
/// namespaces. For example, "foo::" in "foo::x" is a nested name
/// specifier. Nested name specifiers are made up of a sequence of
/// specifiers, each of which can be a namespace, type, identifier
/// (for dependent names), decltype specifier, or the global specifier ('::').
/// The last two specifiers can only appear at the start of a 
/// nested-namespace-specifier.
//<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 44,
 FQN="clang::NestedNameSpecifier", NM="_ZN5clang19NestedNameSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang19NestedNameSpecifierE")
//</editor-fold>
public class NestedNameSpecifier extends FoldingSetImpl.NodeImpl implements /*public*/ FoldingSetImpl.Node {
  
  /// \brief Enumeration describing
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::StoredSpecifierKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 47,
   FQN="clang::NestedNameSpecifier::StoredSpecifierKind", NM="_ZN5clang19NestedNameSpecifier19StoredSpecifierKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang19NestedNameSpecifier19StoredSpecifierKindE")
  //</editor-fold>
  private enum StoredSpecifierKind implements Native.ComparableLower {
    StoredIdentifier(0),
    StoredDecl(1),
    StoredTypeSpec(2),
    StoredTypeSpecWithTemplate(3);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static StoredSpecifierKind valueOf(int val) {
      StoredSpecifierKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final StoredSpecifierKind[] VALUES;
      private static final StoredSpecifierKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (StoredSpecifierKind kind : StoredSpecifierKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new StoredSpecifierKind[min < 0 ? (1-min) : 0];
        VALUES = new StoredSpecifierKind[max >= 0 ? (1+max) : 0];
        for (StoredSpecifierKind kind : StoredSpecifierKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private StoredSpecifierKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((StoredSpecifierKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((StoredSpecifierKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief The nested name specifier that precedes this nested name
  /// specifier.
  ///
  /// The pointer is the nested-name-specifier that precedes this
  /// one. The integer stores one of the first four values of type
  /// SpecifierKind.
  private PointerEnum2Pair<NestedNameSpecifier /*P*/, StoredSpecifierKind> Prefix;
  
  /// \brief The last component in the nested name specifier, which
  /// can be an identifier, a declaration, or a type.
  ///
  /// When the pointer is NULL, this specifier represents the global
  /// specifier '::'. Otherwise, the pointer is one of
  /// IdentifierInfo*, Namespace*, or Type*, depending on the kind of
  /// specifier as encoded within the prefix.
  private Object/*void P*/ Specifier;
/*public:*/
  /// \brief The kind of specifier that completes this nested name
  /// specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::SpecifierKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 74,
   FQN="clang::NestedNameSpecifier::SpecifierKind", NM="_ZN5clang19NestedNameSpecifier13SpecifierKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang19NestedNameSpecifier13SpecifierKindE")
  //</editor-fold>
  public enum SpecifierKind implements Native.ComparableLower {
    /// \brief An identifier, stored as an IdentifierInfo*.
    Identifier(0),
    /// \brief A namespace, stored as a NamespaceDecl*.
    Namespace(Identifier.getValue() + 1),
    /// \brief A namespace alias, stored as a NamespaceAliasDecl*.
    NamespaceAlias(Namespace.getValue() + 1),
    /// \brief A type, stored as a Type*.
    TypeSpec(NamespaceAlias.getValue() + 1),
    /// \brief A type that was preceded by the 'template' keyword,
    /// stored as a Type*.
    TypeSpecWithTemplate(TypeSpec.getValue() + 1),
    /// \brief The global specifier '::'. There is no stored value.
    Global(TypeSpecWithTemplate.getValue() + 1),
    /// \brief Microsoft's '__super' specifier, stored as a CXXRecordDecl* of
    /// the class it appeared in.
    Super(Global.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SpecifierKind valueOf(int val) {
      SpecifierKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SpecifierKind[] VALUES;
      private static final SpecifierKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SpecifierKind kind : SpecifierKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SpecifierKind[min < 0 ? (1-min) : 0];
        VALUES = new SpecifierKind[max >= 0 ? (1+max) : 0];
        for (SpecifierKind kind : SpecifierKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private SpecifierKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((SpecifierKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((SpecifierKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  /// \brief Builds the global specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::NestedNameSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 95,
   FQN="clang::NestedNameSpecifier::NestedNameSpecifier", NM="_ZN5clang19NestedNameSpecifierC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang19NestedNameSpecifierC1Ev")
  //</editor-fold>
  private NestedNameSpecifier() {
    // : FoldingSetNode(), Prefix(null, StoredIdentifier), Specifier(null) 
    //START JInit
    $Node();
    this.Prefix = new PointerEnum2Pair<NestedNameSpecifier /*P*/, StoredSpecifierKind>((NestedNameSpecifier /*P*/ )null, StoredSpecifierKind.StoredIdentifier);
    this.Specifier = null;
    //END JInit
  }

  
  /// \brief Copy constructor used internally to clone nested name
  /// specifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::NestedNameSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 100,
   FQN="clang::NestedNameSpecifier::NestedNameSpecifier", NM="_ZN5clang19NestedNameSpecifierC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang19NestedNameSpecifierC1ERKS0_")
  //</editor-fold>
  private NestedNameSpecifier(final /*const*/ NestedNameSpecifier /*&*/ Other) {
    // : FoldingSetNode(Other), Prefix(Other.Prefix), Specifier(Other.Specifier) 
    //START JInit
    $Node(Other);
    this.Prefix = new PointerEnum2Pair<NestedNameSpecifier /*P*/, StoredSpecifierKind>(Other.Prefix);
    this.Specifier = Other.Specifier;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 105,
   FQN="clang::NestedNameSpecifier::operator=", NM="_ZN5clang19NestedNameSpecifieraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang19NestedNameSpecifieraSERKS0_")
  //</editor-fold>
  private void $assign(final /*const*/ NestedNameSpecifier /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  /// \brief Either find or insert the given nested name specifier
  /// mockup in the given context.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::FindOrInsert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 27,
   FQN="clang::NestedNameSpecifier::FindOrInsert", NM="_ZN5clang19NestedNameSpecifier12FindOrInsertERKNS_10ASTContextERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang19NestedNameSpecifier12FindOrInsertERKNS_10ASTContextERKS0_")
  //</editor-fold>
  private static NestedNameSpecifier /*P*/ FindOrInsert(final /*const*/ ASTContext /*&*/ Context, 
              final /*const*/ NestedNameSpecifier /*&*/ Mockup) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    Mockup.Profile(ID);
    
    final type$ref<type$ptr<NestedNameSpecifier /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    NestedNameSpecifier /*P*/ NNS = Context.NestedNameSpecifiers.FindNodeOrInsertPos(ID, InsertPos);
    if (!(NNS != null)) {
      NNS = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context, llvm::alignOf<NestedNameSpecifier>())*/ $new_uint_ASTContext$C_uint(Context, alignOf(NestedNameSpecifier.class), (type$ptr<?> New$Mem)->{
          return new NestedNameSpecifier(Mockup);
       });
      Context.NestedNameSpecifiers.InsertNode(NNS, InsertPos.$deref());
    }
    
    return NNS;
  }

/*public:*/
  /// \brief Builds a specifier combining a prefix and an identifier.
  ///
  /// The prefix must be dependent, since nested name specifiers
  /// referencing an identifier are only permitted when the identifier
  /// cannot be resolved.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 45,
   FQN="clang::NestedNameSpecifier::Create", NM="_ZN5clang19NestedNameSpecifier6CreateERKNS_10ASTContextEPS0_PNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang19NestedNameSpecifier6CreateERKNS_10ASTContextEPS0_PNS_14IdentifierInfoE")
  //</editor-fold>
  public static NestedNameSpecifier /*P*/ Create(final /*const*/ ASTContext /*&*/ Context, 
        NestedNameSpecifier /*P*/ Prefix, IdentifierInfo /*P*/ II) {
    assert ((II != null)) : "Identifier cannot be NULL";
    assert ((!(Prefix != null) || Prefix.isDependent())) : "Prefix must be dependent";
    
    NestedNameSpecifier Mockup/*J*/= new NestedNameSpecifier();
    Mockup.Prefix.setPointer(Prefix);
    Mockup.Prefix.setInt(StoredSpecifierKind.StoredIdentifier);
    Mockup.Specifier = II;
    return FindOrInsert(Context, Mockup);
  }

  
  /// \brief Builds a nested name specifier that names a namespace.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 58,
   FQN="clang::NestedNameSpecifier::Create", NM="_ZN5clang19NestedNameSpecifier6CreateERKNS_10ASTContextEPS0_PKNS_13NamespaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang19NestedNameSpecifier6CreateERKNS_10ASTContextEPS0_PKNS_13NamespaceDeclE")
  //</editor-fold>
  public static NestedNameSpecifier /*P*/ Create(final /*const*/ ASTContext /*&*/ Context, 
        NestedNameSpecifier /*P*/ Prefix, 
        /*const*/ NamespaceDecl /*P*/ NS) {
    assert ((NS != null)) : "Namespace cannot be NULL";
    assert ((!(Prefix != null) || (Prefix.getAsType() == null && Prefix.getAsIdentifier() == null))) : "Broken nested name specifier";
    NestedNameSpecifier Mockup/*J*/= new NestedNameSpecifier();
    Mockup.Prefix.setPointer(Prefix);
    Mockup.Prefix.setInt(StoredSpecifierKind.StoredDecl);
    Mockup.Specifier = ((/*const_cast*/NamespaceDecl /*P*/ )(NS));
    return FindOrInsert(Context, Mockup);
  }

  
  /// \brief Builds a nested name specifier that names a namespace alias.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 74,
   FQN="clang::NestedNameSpecifier::Create", NM="_ZN5clang19NestedNameSpecifier6CreateERKNS_10ASTContextEPS0_PNS_18NamespaceAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang19NestedNameSpecifier6CreateERKNS_10ASTContextEPS0_PNS_18NamespaceAliasDeclE")
  //</editor-fold>
  public static NestedNameSpecifier /*P*/ Create(final /*const*/ ASTContext /*&*/ Context, 
        NestedNameSpecifier /*P*/ Prefix, 
        NamespaceAliasDecl /*P*/ Alias) {
    assert ((Alias != null)) : "Namespace alias cannot be NULL";
    assert ((!(Prefix != null) || (Prefix.getAsType() == null && Prefix.getAsIdentifier() == null))) : "Broken nested name specifier";
    NestedNameSpecifier Mockup/*J*/= new NestedNameSpecifier();
    Mockup.Prefix.setPointer(Prefix);
    Mockup.Prefix.setInt(StoredSpecifierKind.StoredDecl);
    Mockup.Specifier = Alias;
    return FindOrInsert(Context, Mockup);
  }

  
  /// \brief Builds a nested name specifier that names a type.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 90,
   FQN="clang::NestedNameSpecifier::Create", NM="_ZN5clang19NestedNameSpecifier6CreateERKNS_10ASTContextEPS0_bPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang19NestedNameSpecifier6CreateERKNS_10ASTContextEPS0_bPKNS_4TypeE")
  //</editor-fold>
  public static NestedNameSpecifier /*P*/ Create(final /*const*/ ASTContext /*&*/ Context, 
        NestedNameSpecifier /*P*/ Prefix, 
        boolean Template, /*const*/ Type /*P*/ T) {
    assert ((T != null)) : "Type cannot be NULL";
    NestedNameSpecifier Mockup/*J*/= new NestedNameSpecifier();
    Mockup.Prefix.setPointer(Prefix);
    Mockup.Prefix.setInt(Template ? StoredSpecifierKind.StoredTypeSpecWithTemplate : StoredSpecifierKind.StoredTypeSpec);
    Mockup.Specifier = ((/*const_cast*/Type /*P*/ )(T));
    return FindOrInsert(Context, Mockup);
  }

  
  /// \brief Builds a specifier that consists of just an identifier.
  ///
  /// The nested-name-specifier is assumed to be dependent, but has no
  /// prefix because the prefix is implied by something outside of the
  /// nested name specifier, e.g., in "x->Base::f", the "x" has a dependent
  /// type.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 102,
   FQN="clang::NestedNameSpecifier::Create", NM="_ZN5clang19NestedNameSpecifier6CreateERKNS_10ASTContextEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang19NestedNameSpecifier6CreateERKNS_10ASTContextEPNS_14IdentifierInfoE")
  //</editor-fold>
  public static NestedNameSpecifier /*P*/ Create(final /*const*/ ASTContext /*&*/ Context, IdentifierInfo /*P*/ II) {
    assert ((II != null)) : "Identifier cannot be NULL";
    NestedNameSpecifier Mockup/*J*/= new NestedNameSpecifier();
    Mockup.Prefix.setPointer((NestedNameSpecifier /*P*/ )null);
    Mockup.Prefix.setInt(StoredSpecifierKind.StoredIdentifier);
    Mockup.Specifier = II;
    return FindOrInsert(Context, Mockup);
  }

  
  /// \brief Returns the nested name specifier representing the global
  /// scope.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::GlobalSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 112,
   FQN="clang::NestedNameSpecifier::GlobalSpecifier", NM="_ZN5clang19NestedNameSpecifier15GlobalSpecifierERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang19NestedNameSpecifier15GlobalSpecifierERKNS_10ASTContextE")
  //</editor-fold>
  public static NestedNameSpecifier /*P*/ GlobalSpecifier(final /*const*/ ASTContext /*&*/ Context) {
    if (!(Context.GlobalNestedNameSpecifier != null)) {
      Context.GlobalNestedNameSpecifier
         = /*FIXME:NEW_EXPR*//*new (Context, llvm::alignOf<NestedNameSpecifier>())*/ new NestedNameSpecifier();
    }
    return Context.GlobalNestedNameSpecifier;
  }

  
  /// \brief Returns the nested name specifier representing the __super scope
  /// for the given CXXRecordDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::SuperSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 121,
   FQN="clang::NestedNameSpecifier::SuperSpecifier", NM="_ZN5clang19NestedNameSpecifier14SuperSpecifierERKNS_10ASTContextEPNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang19NestedNameSpecifier14SuperSpecifierERKNS_10ASTContextEPNS_13CXXRecordDeclE")
  //</editor-fold>
  public static NestedNameSpecifier /*P*/ SuperSpecifier(final /*const*/ ASTContext /*&*/ Context, 
                CXXRecordDecl /*P*/ RD) {
    NestedNameSpecifier Mockup/*J*/= new NestedNameSpecifier();
    Mockup.Prefix.setPointer((NestedNameSpecifier /*P*/ )null);
    Mockup.Prefix.setInt(StoredSpecifierKind.StoredDecl);
    Mockup.Specifier = RD;
    return FindOrInsert(Context, Mockup);
  }

  
  /// \brief Return the prefix of this nested name specifier.
  ///
  /// The prefix contains all of the parts of the nested name
  /// specifier that preced this current specifier. For example, for a
  /// nested name specifier that represents "foo::bar::", the current
  /// specifier will contain "bar::" and the prefix will contain
  /// "foo::".
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::getPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 162,
   FQN="clang::NestedNameSpecifier::getPrefix", NM="_ZNK5clang19NestedNameSpecifier9getPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang19NestedNameSpecifier9getPrefixEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getPrefix() /*const*/ {
    return Prefix.getPointer();
  }

  
  /// \brief Determine what kind of nested name specifier is stored.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 131,
   FQN="clang::NestedNameSpecifier::getKind", NM="_ZNK5clang19NestedNameSpecifier7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang19NestedNameSpecifier7getKindEv")
  //</editor-fold>
  public NestedNameSpecifier.SpecifierKind getKind() /*const*/ {
    if (!(Specifier != null)) {
      return SpecifierKind.Global;
    }
    switch (Prefix.getInt()) {
     case StoredIdentifier:
      return SpecifierKind.Identifier;
     case StoredDecl:
      {
        NamedDecl /*P*/ ND = ((/*static_cast*/NamedDecl /*P*/ )(Specifier));
        if (isa_CXXRecordDecl(ND)) {
          return SpecifierKind.Super;
        }
        return isa_NamespaceDecl(ND) ? SpecifierKind.Namespace : SpecifierKind.NamespaceAlias;
      }
     case StoredTypeSpec:
      return SpecifierKind.TypeSpec;
     case StoredTypeSpecWithTemplate:
      return SpecifierKind.TypeSpecWithTemplate;
    }
    throw new llvm_unreachable("Invalid NNS Kind!");
  }

  
  /// \brief Retrieve the identifier stored in this nested name
  /// specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::getAsIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 169,
   FQN="clang::NestedNameSpecifier::getAsIdentifier", NM="_ZNK5clang19NestedNameSpecifier15getAsIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang19NestedNameSpecifier15getAsIdentifierEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getAsIdentifier() /*const*/ {
    if (Prefix.getInt() == StoredSpecifierKind.StoredIdentifier) {
      return (IdentifierInfo /*P*/ )Specifier;
    }
    
    return null;
  }

  
  /// \brief Retrieve the namespace stored in this nested name
  /// specifier.
  
  /// \brief Retrieve the namespace stored in this nested name specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::getAsNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 157,
   FQN="clang::NestedNameSpecifier::getAsNamespace", NM="_ZNK5clang19NestedNameSpecifier14getAsNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang19NestedNameSpecifier14getAsNamespaceEv")
  //</editor-fold>
  public NamespaceDecl /*P*/ getAsNamespace() /*const*/ {
    if (Prefix.getInt() == StoredSpecifierKind.StoredDecl) {
      return dyn_cast_NamespaceDecl(((/*static_cast*/NamedDecl /*P*/ )(Specifier)));
    }
    
    return null;
  }

  
  /// \brief Retrieve the namespace alias stored in this nested name
  /// specifier.
  
  /// \brief Retrieve the namespace alias stored in this nested name specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::getAsNamespaceAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 165,
   FQN="clang::NestedNameSpecifier::getAsNamespaceAlias", NM="_ZNK5clang19NestedNameSpecifier19getAsNamespaceAliasEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang19NestedNameSpecifier19getAsNamespaceAliasEv")
  //</editor-fold>
  public NamespaceAliasDecl /*P*/ getAsNamespaceAlias() /*const*/ {
    if (Prefix.getInt() == StoredSpecifierKind.StoredDecl) {
      return dyn_cast_NamespaceAliasDecl(((/*static_cast*/NamedDecl /*P*/ )(Specifier)));
    }
    
    return null;
  }

  
  /// \brief Retrieve the record declaration stored in this nested name
  /// specifier.
  
  /// \brief Retrieve the record declaration stored in this nested name specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::getAsRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 173,
   FQN="clang::NestedNameSpecifier::getAsRecordDecl", NM="_ZNK5clang19NestedNameSpecifier15getAsRecordDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang19NestedNameSpecifier15getAsRecordDeclEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getAsRecordDecl() /*const*/ {
    switch (Prefix.getInt()) {
     case StoredIdentifier:
      return null;
     case StoredDecl:
      return dyn_cast_CXXRecordDecl(((/*static_cast*/NamedDecl /*P*/ )(Specifier)));
     case StoredTypeSpec:
     case StoredTypeSpecWithTemplate:
      return getAsType().getAsCXXRecordDecl();
    }
    throw new llvm_unreachable("Invalid NNS Kind!");
  }

  
  /// \brief Retrieve the type stored in this nested name specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::getAsType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 189,
   FQN="clang::NestedNameSpecifier::getAsType", NM="_ZNK5clang19NestedNameSpecifier9getAsTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang19NestedNameSpecifier9getAsTypeEv")
  //</editor-fold>
  public /*const*/ Type /*P*/ getAsType() /*const*/ {
    if (Prefix.getInt() == StoredSpecifierKind.StoredTypeSpec
       || Prefix.getInt() == StoredSpecifierKind.StoredTypeSpecWithTemplate) {
      return (/*const*/ Type /*P*/ )Specifier;
    }
    
    return null;
  }

  
  /// \brief Whether this nested name specifier refers to a dependent
  /// type or not.
  
  /// \brief Whether this nested name specifier refers to a dependent
  /// type or not.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::isDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 191,
   FQN="clang::NestedNameSpecifier::isDependent", NM="_ZNK5clang19NestedNameSpecifier11isDependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang19NestedNameSpecifier11isDependentEv")
  //</editor-fold>
  public boolean isDependent() /*const*/ {
    switch (getKind()) {
     case Identifier:
      // Identifier specifiers always represent dependent types
      return true;
     case Namespace:
     case NamespaceAlias:
     case Global:
      return false;
     case Super:
      {
        CXXRecordDecl /*P*/ RD = ((/*static_cast*/CXXRecordDecl /*P*/ )(Specifier));
        for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.bases())  {
          if (Base.getType().$arrow().isDependentType()) {
            return true;
          }
        }
        
        return false;
      }
     case TypeSpec:
     case TypeSpecWithTemplate:
      return getAsType().isDependentType();
    }
    throw new llvm_unreachable("Invalid NNS Kind!");
  }

  
  /// \brief Whether this nested name specifier involves a template
  /// parameter.
  
  /// \brief Whether this nested name specifier refers to a dependent
  /// type or not.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::isInstantiationDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 221,
   FQN="clang::NestedNameSpecifier::isInstantiationDependent", NM="_ZNK5clang19NestedNameSpecifier24isInstantiationDependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang19NestedNameSpecifier24isInstantiationDependentEv")
  //</editor-fold>
  public boolean isInstantiationDependent() /*const*/ {
    switch (getKind()) {
     case Identifier:
      // Identifier specifiers always represent dependent types
      return true;
     case Namespace:
     case NamespaceAlias:
     case Global:
     case Super:
      return false;
     case TypeSpec:
     case TypeSpecWithTemplate:
      return getAsType().isInstantiationDependentType();
    }
    throw new llvm_unreachable("Invalid NNS Kind!");
  }

  
  /// \brief Whether this nested-name-specifier contains an unexpanded
  /// parameter pack (for C++11 variadic templates).
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::containsUnexpandedParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 241,
   FQN="clang::NestedNameSpecifier::containsUnexpandedParameterPack", NM="_ZNK5clang19NestedNameSpecifier31containsUnexpandedParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang19NestedNameSpecifier31containsUnexpandedParameterPackEv")
  //</editor-fold>
  public boolean containsUnexpandedParameterPack() /*const*/ {
    switch (getKind()) {
     case Identifier:
      return (getPrefix() != null) && getPrefix().containsUnexpandedParameterPack();
     case Namespace:
     case NamespaceAlias:
     case Global:
     case Super:
      return false;
     case TypeSpec:
     case TypeSpecWithTemplate:
      return getAsType().containsUnexpandedParameterPack();
    }
    throw new llvm_unreachable("Invalid NNS Kind!");
  }

  
  /// \brief Print this nested name specifier to the given output
  /// stream.
  
  /// \brief Print this nested name specifier to the given output
  /// stream.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 262,
   FQN="clang::NestedNameSpecifier::print", NM="_ZNK5clang19NestedNameSpecifier5printERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang19NestedNameSpecifier5printERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS, 
       final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    if ((getPrefix() != null)) {
      getPrefix().print(OS, Policy);
    }
    switch (getKind()) {
     case Identifier:
      OS.$out(getAsIdentifier().getName());
      break;
     case Namespace:
      if (getAsNamespace().isAnonymousNamespace()) {
        return;
      }
      
      OS.$out(getAsNamespace().getName());
      break;
     case NamespaceAlias:
      OS.$out(getAsNamespaceAlias().getName());
      break;
     case Global:
      break;
     case Super:
      OS.$out(/*KEEP_STR*/$__super);
      break;
     case TypeSpecWithTemplate:
      OS.$out(/*KEEP_STR*/"template ");
     case TypeSpec:
      {
        /*const*/ Type /*P*/ T = getAsType();
        
        PrintingPolicy InnerPolicy/*J*/= new PrintingPolicy(Policy);
        InnerPolicy.SuppressScope = true;
        
        // Nested-name-specifiers are intended to contain minimally-qualified
        // types. An actual ElaboratedType will not occur, since we'll store
        // just the type that is referred to in the nested-name-specifier (e.g.,
        // a TypedefType, TagType, etc.). However, when we are dealing with
        // dependent template-id types (e.g., Outer<T>::template Inner<U>),
        // the type requires its own nested-name-specifier for uniqueness, so we
        // suppress that nested-name-specifier during printing.
        assert (!isa_ElaboratedType(T)) : "Elaborated type in nested-name-specifier";
        {
          /*const*/ TemplateSpecializationType /*P*/ SpecType = dyn_cast_TemplateSpecializationType(T);
          if ((SpecType != null)) {
            // Print the template name without its corresponding
            // nested-name-specifier.
            SpecType.getTemplateName().print(OS, InnerPolicy, true);
            
            // Print the template argument list.
            TemplateSpecializationType.PrintTemplateArgumentList1(OS, SpecType.template_arguments(), InnerPolicy);
          } else {
            // Print the type normally
            new QualType(T, 0).print(OS, InnerPolicy);
          }
        }
        break;
      }
    }
    
    OS.$out(/*KEEP_STR*/$COLON_COLON);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 213,
   FQN="clang::NestedNameSpecifier::Profile", NM="_ZNK5clang19NestedNameSpecifier7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang19NestedNameSpecifier7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddPointer(Prefix.getOpaqueValue());
    ID.AddPointer(Specifier);
  }

  
  /// \brief Dump the nested name specifier to standard output to aid
  /// in debugging.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 330,
   FQN="clang::NestedNameSpecifier::dump", NM="_ZNK5clang19NestedNameSpecifier4dumpERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang19NestedNameSpecifier4dumpERKNS_11LangOptionsE")
  //</editor-fold>
  public void dump(final /*const*/ LangOptions /*&*/ LO) /*const*/ {
    print(llvm.errs(), new PrintingPolicy(LO));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifier::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 334,
   FQN="clang::NestedNameSpecifier::dump", NM="_ZNK5clang19NestedNameSpecifier4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang19NestedNameSpecifier4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    LangOptions LO/*J*/= new LangOptions();
    print(llvm.errs(), new PrintingPolicy(LO));
  }

  @Override public String toString() {
    return "" + "Prefix=" + Prefix // NOI18N
              + ", Specifier=" + Specifier // NOI18N
              + super.toString(); // NOI18N
  }
}
