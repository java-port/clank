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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import java.util.Iterator;
import org.clang.ast.*;
import org.clang.ast.llvm.*;
import org.clang.basic.*;
import static org.clang.sema.impl.SemaLookupStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// @brief Represents the results of name lookup.
///
/// An instance of the LookupResult class captures the results of a
/// single name lookup, which can return no result (nothing found),
/// a single declaration, a set of overloaded functions, or an
/// ambiguity. Use the getKind() method to determine which of these
/// results occurred for a given lookup.
//<editor-fold defaultstate="collapsed" desc="clang::LookupResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 30,
 FQN="clang::LookupResult", NM="_ZN5clang12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResultE")
//</editor-fold>
public class LookupResult implements Iterable<NamedDecl>, NativeIterable<UnresolvedSetIterator>, Destructors.ClassWithDestructor, NativeMoveable<LookupResult> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::LookupResultKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 32,
   FQN="clang::LookupResult::LookupResultKind", NM="_ZN5clang12LookupResult16LookupResultKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult16LookupResultKindE")
  //</editor-fold>
  public enum LookupResultKind implements Native.ComparableLower {
    /// @brief No entity found met the criteria.
    NotFound(0),
    
    /// @brief No entity found met the criteria within the current 
    /// instantiation,, but there were dependent base classes of the 
    /// current instantiation that could not be searched.
    NotFoundInCurrentInstantiation(NotFound.getValue() + 1),
    
    /// @brief Name lookup found a single declaration that met the
    /// criteria.  getFoundDecl() will return this declaration.
    Found(NotFoundInCurrentInstantiation.getValue() + 1),
    
    /// @brief Name lookup found a set of overloaded functions that
    /// met the criteria.
    FoundOverloaded(Found.getValue() + 1),
    
    /// @brief Name lookup found an unresolvable value declaration
    /// and cannot yet complete.  This only happens in C++ dependent
    /// contexts with dependent using declarations.
    FoundUnresolvedValue(FoundOverloaded.getValue() + 1),
    
    /// @brief Name lookup results in an ambiguity; use
    /// getAmbiguityKind to figure out what kind of ambiguity
    /// we have.
    Ambiguous(FoundUnresolvedValue.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static LookupResultKind valueOf(int val) {
      LookupResultKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final LookupResultKind[] VALUES;
      private static final LookupResultKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (LookupResultKind kind : LookupResultKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new LookupResultKind[min < 0 ? (1-min) : 0];
        VALUES = new LookupResultKind[max >= 0 ? (1+max) : 0];
        for (LookupResultKind kind : LookupResultKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private LookupResultKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((LookupResultKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((LookupResultKind)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::AmbiguityKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 60,
   FQN="clang::LookupResult::AmbiguityKind", NM="_ZN5clang12LookupResult13AmbiguityKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult13AmbiguityKindE")
  //</editor-fold>
  public enum AmbiguityKind implements Native.ComparableLower {
    /// Name lookup results in an ambiguity because multiple
    /// entities that meet the lookup criteria were found in
    /// subobjects of different types. For example:
    /// @code
    /// struct A { void f(int); }
    /// struct B { void f(double); }
    /// struct C : A, B { };
    /// void test(C c) {
    ///   c.f(0); // error: A::f and B::f come from subobjects of different
    ///           // types. overload resolution is not performed.
    /// }
    /// @endcode
    AmbiguousBaseSubobjectTypes(0),
    
    /// Name lookup results in an ambiguity because multiple
    /// nonstatic entities that meet the lookup criteria were found
    /// in different subobjects of the same type. For example:
    /// @code
    /// struct A { int x; };
    /// struct B : A { };
    /// struct C : A { };
    /// struct D : B, C { };
    /// int test(D d) {
    ///   return d.x; // error: 'x' is found in two A subobjects (of B and C)
    /// }
    /// @endcode
    AmbiguousBaseSubobjects(AmbiguousBaseSubobjectTypes.getValue() + 1),
    
    /// Name lookup results in an ambiguity because multiple definitions
    /// of entity that meet the lookup criteria were found in different
    /// declaration contexts.
    /// @code
    /// namespace A {
    ///   int i;
    ///   namespace B { int i; }
    ///   int test() {
    ///     using namespace B;
    ///     return i; // error 'i' is found in namespace A and A::B
    ///    }
    /// }
    /// @endcode
    AmbiguousReference(AmbiguousBaseSubobjects.getValue() + 1),
    
    /// Name lookup results in an ambiguity because an entity with a
    /// tag name was hidden by an entity with an ordinary name from
    /// a different context.
    /// @code
    /// namespace A { struct Foo {}; }
    /// namespace B { void Foo(); }
    /// namespace C {
    ///   using namespace A;
    ///   using namespace B;
    /// }
    /// void test() {
    ///   C::Foo(); // error: tag 'A::Foo' is hidden by an object in a
    ///             // different namespace
    /// }
    /// @endcode
    AmbiguousTagHiding(AmbiguousReference.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AmbiguityKind valueOf(int val) {
      AmbiguityKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final AmbiguityKind[] VALUES;
      private static final AmbiguityKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AmbiguityKind kind : AmbiguityKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AmbiguityKind[min < 0 ? (1-min) : 0];
        VALUES = new AmbiguityKind[max >= 0 ? (1+max) : 0];
        for (AmbiguityKind kind : AmbiguityKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private AmbiguityKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((AmbiguityKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((AmbiguityKind)obj).value);}
    //</editor-fold>
  };
  
  /// A little identifier for flagging temporary lookup results.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::TemporaryToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 123,
   FQN="clang::LookupResult::TemporaryToken", NM="_ZN5clang12LookupResult14TemporaryTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult14TemporaryTokenE")
  //</editor-fold>
  public enum TemporaryToken implements Native.ComparableLower {
    Temporary(0);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TemporaryToken valueOf(int val) {
      TemporaryToken out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final TemporaryToken[] VALUES;
      private static final TemporaryToken[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TemporaryToken kind : TemporaryToken.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TemporaryToken[min < 0 ? (1-min) : 0];
        VALUES = new TemporaryToken[max >= 0 ? (1+max) : 0];
        for (TemporaryToken kind : TemporaryToken.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private TemporaryToken(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TemporaryToken)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TemporaryToken)obj).value);}
    //</editor-fold>
  };
  
  /*typedef UnresolvedSetImpl::iterator iterator*/
//  public final class iterator extends UnresolvedSetIterator{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::LookupResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 129,
   FQN="clang::LookupResult::LookupResult", NM="_ZN5clang12LookupResultC1ERNS_4SemaERKNS_19DeclarationNameInfoENS1_14LookupNameKindENS1_17RedeclarationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResultC1ERNS_4SemaERKNS_19DeclarationNameInfoENS1_14LookupNameKindENS1_17RedeclarationKindE")
  //</editor-fold>
  public LookupResult(final Sema /*&*/ SemaRef, final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
      Sema.LookupNameKind LookupKind) {
    this(SemaRef, NameInfo, 
      LookupKind, 
      Sema.RedeclarationKind.NotForRedeclaration);
  }
  public LookupResult(final Sema /*&*/ SemaRef, final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
      Sema.LookupNameKind LookupKind, 
      Sema.RedeclarationKind Redecl/*= Sema::NotForRedeclaration*/) {
    // : ResultKind(NotFound), Decls(), Paths(null), NamingClass(null), BaseObjectType(), SemaPtr(&SemaRef), NameInfo(NameInfo), NameContextRange(), LookupKind(LookupKind), IDNS(0), Redecl(Redecl != Sema::NotForRedeclaration), HideTags(true), Diagnose(Redecl == Sema::NotForRedeclaration), AllowHidden(false), Shadowed(false) 
    //START JInit
    this.ResultKind = LookupResultKind.NotFound;
    this.Decls = new UnresolvedSet(8);
    this.Paths = null;
    this.NamingClass = null;
    this.BaseObjectType = new QualType();
    this.SemaPtr = $AddrOf(SemaRef);
    this.NameInfo = new DeclarationNameInfo(NameInfo);
    this.NameContextRange = new SourceRange();
    this.LookupKind = LookupKind;
    this.IDNS = 0;
    this.Redecl = Redecl != Sema.RedeclarationKind.NotForRedeclaration;
    this.HideTags = true;
    this.Diagnose = Redecl == Sema.RedeclarationKind.NotForRedeclaration;
    this.AllowHidden = false;
    this.Shadowed = false;
    //END JInit
    configure();
  }

  
  // TODO: consider whether this constructor should be restricted to take
  // as input a const IndentifierInfo* (instead of Name),
  // forcing other cases towards the constructor taking a DNInfo.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::LookupResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 151,
   FQN="clang::LookupResult::LookupResult", NM="_ZN5clang12LookupResultC1ERNS_4SemaENS_15DeclarationNameENS_14SourceLocationENS1_14LookupNameKindENS1_17RedeclarationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResultC1ERNS_4SemaENS_15DeclarationNameENS_14SourceLocationENS1_14LookupNameKindENS1_17RedeclarationKindE")
  //</editor-fold>
  public LookupResult(final Sema /*&*/ SemaRef, DeclarationName Name, 
      SourceLocation NameLoc, Sema.LookupNameKind LookupKind) {
    this(SemaRef, Name, 
      NameLoc, LookupKind, 
      Sema.RedeclarationKind.NotForRedeclaration);
  }
  public LookupResult(final Sema /*&*/ SemaRef, DeclarationName Name, 
      SourceLocation NameLoc, Sema.LookupNameKind LookupKind, 
      Sema.RedeclarationKind Redecl/*= Sema::NotForRedeclaration*/) {
    // : ResultKind(NotFound), Decls(), Paths(null), NamingClass(null), BaseObjectType(), SemaPtr(&SemaRef), NameInfo(Name, NameLoc), NameContextRange(), LookupKind(LookupKind), IDNS(0), Redecl(Redecl != Sema::NotForRedeclaration), HideTags(true), Diagnose(Redecl == Sema::NotForRedeclaration), AllowHidden(false), Shadowed(false) 
    //START JInit
    this.ResultKind = LookupResultKind.NotFound;
    this.Decls = new UnresolvedSet(8);
    this.Paths = null;
    this.NamingClass = null;
    this.BaseObjectType = new QualType();
    this.SemaPtr = $AddrOf(SemaRef);
    this.NameInfo = new DeclarationNameInfo(new DeclarationName(Name), new SourceLocation(NameLoc));
    this.NameContextRange = new SourceRange();
    this.LookupKind = LookupKind;
    this.IDNS = 0;
    this.Redecl = Redecl != Sema.RedeclarationKind.NotForRedeclaration;
    this.HideTags = true;
    this.Diagnose = Redecl == Sema.RedeclarationKind.NotForRedeclaration;
    this.AllowHidden = false;
    this.Shadowed = false;
    //END JInit
    configure();
  }

  
  /// Creates a temporary lookup result, initializing its core data
  /// using the information from another result.  Diagnostics are always
  /// disabled.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::LookupResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 173,
   FQN="clang::LookupResult::LookupResult", NM="_ZN5clang12LookupResultC1ENS0_14TemporaryTokenERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResultC1ENS0_14TemporaryTokenERKS0_")
  //</editor-fold>
  public LookupResult(TemporaryToken _, final /*const*/ LookupResult /*&*/ Other) {
    // : ResultKind(NotFound), Decls(), Paths(null), NamingClass(null), BaseObjectType(), SemaPtr(Other.SemaPtr), NameInfo(Other.NameInfo), NameContextRange(), LookupKind(Other.LookupKind), IDNS(Other.IDNS), Redecl(Other.Redecl), HideTags(Other.HideTags), Diagnose(false), AllowHidden(Other.AllowHidden), Shadowed(false) 
    //START JInit
    this.ResultKind = LookupResultKind.NotFound;
    this.Decls = new UnresolvedSet(8);
    this.Paths = null;
    this.NamingClass = null;
    this.BaseObjectType = new QualType();
    this.SemaPtr = Other.SemaPtr;
    this.NameInfo = new DeclarationNameInfo(Other.NameInfo);
    this.NameContextRange = new SourceRange();
    this.LookupKind = Other.LookupKind;
    this.IDNS = Other.IDNS;
    this.Redecl = Other.Redecl;
    this.HideTags = Other.HideTags;
    this.Diagnose = false;
    this.AllowHidden = Other.AllowHidden;
    this.Shadowed = false;
    //END JInit
  }

  
  // FIXME: Remove these deleted methods once the default build includes
  // -Wdeprecated.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::LookupResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 190,
   FQN="clang::LookupResult::LookupResult", NM="_ZN5clang12LookupResultC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResultC1ERKS0_")
  //</editor-fold>
  public LookupResult(final /*const*/ LookupResult /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 191,
   FQN="clang::LookupResult::operator=", NM="_ZN5clang12LookupResultaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResultaSERKS0_")
  //</editor-fold>
  public LookupResult /*&*/ $assign(final /*const*/ LookupResult /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::LookupResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 193,
   FQN="clang::LookupResult::LookupResult", NM="_ZN5clang12LookupResultC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResultC1EOS0_")
  //</editor-fold>
  public LookupResult(JD$Move _dparam, final LookupResult /*&&*/Other) {
    // : ResultKind(std::move(Other.ResultKind)), Ambiguity(std::move(Other.Ambiguity)), Decls(std::move(Other.Decls)), Paths(std::move(Other.Paths)), NamingClass(std::move(Other.NamingClass)), BaseObjectType(std::move(Other.BaseObjectType)), SemaPtr(std::move(Other.SemaPtr)), NameInfo(std::move(Other.NameInfo)), NameContextRange(std::move(Other.NameContextRange)), LookupKind(std::move(Other.LookupKind)), IDNS(std::move(Other.IDNS)), Redecl(std::move(Other.Redecl)), HideTags(std::move(Other.HideTags)), Diagnose(std::move(Other.Diagnose)), AllowHidden(std::move(Other.AllowHidden)), Shadowed(std::move(Other.Shadowed)) 
    //START JInit
    this.ResultKind = std.move(Other.ResultKind);
    this.Ambiguity = std.move(Other.Ambiguity);
    this.Decls = new UnresolvedSet(JD$Move.INSTANCE, std.move(Other.Decls));
    this.Paths = std.move(Other.Paths);
    this.NamingClass = std.move(Other.NamingClass);
    this.BaseObjectType = new QualType(JD$Move.INSTANCE, std.move(Other.BaseObjectType));
    this.SemaPtr = std.move(Other.SemaPtr);
    this.NameInfo = new DeclarationNameInfo(JD$Move.INSTANCE, std.move(Other.NameInfo));
    this.NameContextRange = new SourceRange(JD$Move.INSTANCE, std.move(Other.NameContextRange));
    this.LookupKind = std.move(Other.LookupKind);
    this.IDNS = std.move(Other.IDNS);
    this.Redecl = std.move(Other.Redecl);
    this.HideTags = std.move(Other.HideTags);
    this.Diagnose = std.move(Other.Diagnose);
    this.AllowHidden = std.move(Other.AllowHidden);
    this.Shadowed = std.move(Other.Shadowed);
    //END JInit
    Other.Paths = null;
    Other.Diagnose = false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 209,
   FQN="clang::LookupResult::operator=", NM="_ZN5clang12LookupResultaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResultaSEOS0_")
  //</editor-fold>
  public LookupResult /*&*/ $assignMove(final LookupResult /*&&*/Other) {
    ResultKind = std.move(Other.ResultKind);
    Ambiguity = std.move(Other.Ambiguity);
    Decls.$assignMove(std.move(Other.Decls));
    Paths = std.move(Other.Paths);
    NamingClass = std.move(Other.NamingClass);
    BaseObjectType.$assignMove(std.move(Other.BaseObjectType));
    SemaPtr = std.move(Other.SemaPtr);
    NameInfo.$assignMove(std.move(Other.NameInfo));
    NameContextRange.$assignMove(std.move(Other.NameContextRange));
    LookupKind = std.move(Other.LookupKind);
    IDNS = std.move(Other.IDNS);
    Redecl = std.move(Other.Redecl);
    HideTags = std.move(Other.HideTags);
    Diagnose = std.move(Other.Diagnose);
    AllowHidden = std.move(Other.AllowHidden);
    Shadowed = std.move(Other.Shadowed);
    Other.Paths = null;
    Other.Diagnose = false;
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::~LookupResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 231,
   FQN="clang::LookupResult::~LookupResult", NM="_ZN5clang12LookupResultD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResultD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (Diagnose) {
      diagnose();
    }
    if ((Paths != null)) {
      deletePaths(Paths);
    }
    //START JDestroy
    Decls.$destroy();
    //END JDestroy
  }

  
  /// Gets the name info to look up.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::getLookupNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 237,
   FQN="clang::LookupResult::getLookupNameInfo", NM="_ZNK5clang12LookupResult17getLookupNameInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult17getLookupNameInfoEv")
  //</editor-fold>
  public /*const*/ DeclarationNameInfo /*&*/ getLookupNameInfo() /*const*/ {
    return NameInfo;
  }

  
  /// \brief Sets the name info to look up.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::setLookupNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 242,
   FQN="clang::LookupResult::setLookupNameInfo", NM="_ZN5clang12LookupResult17setLookupNameInfoERKNS_19DeclarationNameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult17setLookupNameInfoERKNS_19DeclarationNameInfoE")
  //</editor-fold>
  public void setLookupNameInfo(final /*const*/ DeclarationNameInfo /*&*/ NameInfo) {
    this.NameInfo.$assign(NameInfo);
  }

  
  /// Gets the name to look up.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::getLookupName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 247,
   FQN="clang::LookupResult::getLookupName", NM="_ZNK5clang12LookupResult13getLookupNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult13getLookupNameEv")
  //</editor-fold>
  public DeclarationName getLookupName() /*const*/ {
    return NameInfo.getName();
  }

  
  /// \brief Sets the name to look up.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::setLookupName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 252,
   FQN="clang::LookupResult::setLookupName", NM="_ZN5clang12LookupResult13setLookupNameENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult13setLookupNameENS_15DeclarationNameE")
  //</editor-fold>
  public void setLookupName(DeclarationName Name) {
    NameInfo.setName(new DeclarationName(Name));
  }

  
  /// Gets the kind of lookup to perform.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::getLookupKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 257,
   FQN="clang::LookupResult::getLookupKind", NM="_ZNK5clang12LookupResult13getLookupKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult13getLookupKindEv")
  //</editor-fold>
  public Sema.LookupNameKind getLookupKind() /*const*/ {
    return LookupKind;
  }

  
  /// True if this lookup is just looking for an existing declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::isForRedeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 262,
   FQN="clang::LookupResult::isForRedeclaration", NM="_ZNK5clang12LookupResult18isForRedeclarationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult18isForRedeclarationEv")
  //</editor-fold>
  public boolean isForRedeclaration() /*const*/ {
    return Redecl;
  }

  
  /// \brief Specify whether hidden declarations are visible, e.g.,
  /// for recovery reasons.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::setAllowHidden">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 268,
   FQN="clang::LookupResult::setAllowHidden", NM="_ZN5clang12LookupResult14setAllowHiddenEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult14setAllowHiddenEb")
  //</editor-fold>
  public void setAllowHidden(boolean AH) {
    AllowHidden = AH;
  }

  
  /// \brief Determine whether this lookup is permitted to see hidden
  /// declarations, such as those in modules that have not yet been imported.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::isHiddenDeclarationVisible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 274,
   FQN="clang::LookupResult::isHiddenDeclarationVisible", NM="_ZNK5clang12LookupResult26isHiddenDeclarationVisibleEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult26isHiddenDeclarationVisibleEPNS_9NamedDeclE")
  //</editor-fold>
  public boolean isHiddenDeclarationVisible(NamedDecl /*P*/ ND) /*const*/ {
    return AllowHidden
       || (isForRedeclaration() && ND.isExternallyVisible());
  }

  
  /// Sets whether tag declarations should be hidden by non-tag
  /// declarations during resolution.  The default is true.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::setHideTags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 281,
   FQN="clang::LookupResult::setHideTags", NM="_ZN5clang12LookupResult11setHideTagsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult11setHideTagsEb")
  //</editor-fold>
  public void setHideTags(boolean Hide) {
    HideTags = Hide;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::isAmbiguous">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 285,
   FQN="clang::LookupResult::isAmbiguous", NM="_ZNK5clang12LookupResult11isAmbiguousEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult11isAmbiguousEv")
  //</editor-fold>
  public boolean isAmbiguous() /*const*/ {
    return getResultKind() == LookupResultKind.Ambiguous;
  }

  
  /// Determines if this names a single result which is not an
  /// unresolved value using decl.  If so, it is safe to call
  /// getFoundDecl().
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::isSingleResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 292,
   FQN="clang::LookupResult::isSingleResult", NM="_ZNK5clang12LookupResult14isSingleResultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult14isSingleResultEv")
  //</editor-fold>
  public boolean isSingleResult() /*const*/ {
    return getResultKind() == LookupResultKind.Found;
  }

  
  /// Determines if the results are overloaded.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::isOverloadedResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 297,
   FQN="clang::LookupResult::isOverloadedResult", NM="_ZNK5clang12LookupResult18isOverloadedResultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult18isOverloadedResultEv")
  //</editor-fold>
  public boolean isOverloadedResult() /*const*/ {
    return getResultKind() == LookupResultKind.FoundOverloaded;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::isUnresolvableResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 301,
   FQN="clang::LookupResult::isUnresolvableResult", NM="_ZNK5clang12LookupResult20isUnresolvableResultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult20isUnresolvableResultEv")
  //</editor-fold>
  public boolean isUnresolvableResult() /*const*/ {
    return getResultKind() == LookupResultKind.FoundUnresolvedValue;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::getResultKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 305,
   FQN="clang::LookupResult::getResultKind", NM="_ZNK5clang12LookupResult13getResultKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult13getResultKindEv")
  //</editor-fold>
  public LookupResultKind getResultKind() /*const*/ {
    assert (sanity());
    return ResultKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::getAmbiguityKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 310,
   FQN="clang::LookupResult::getAmbiguityKind", NM="_ZNK5clang12LookupResult16getAmbiguityKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult16getAmbiguityKindEv")
  //</editor-fold>
  public AmbiguityKind getAmbiguityKind() /*const*/ {
    assert (isAmbiguous());
    return Ambiguity;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::asUnresolvedSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 315,
   FQN="clang::LookupResult::asUnresolvedSet", NM="_ZNK5clang12LookupResult15asUnresolvedSetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult15asUnresolvedSetEv")
  //</editor-fold>
  public /*const*/ UnresolvedSetImpl /*&*/ asUnresolvedSet() /*const*/ {
    return Decls;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 319,
   FQN="clang::LookupResult::begin", NM="_ZNK5clang12LookupResult5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult5beginEv")
  //</editor-fold>
  public UnresolvedSetIterator begin() /*const*/ {
    return Decls.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 320,
   FQN="clang::LookupResult::end", NM="_ZNK5clang12LookupResult3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult3endEv")
  //</editor-fold>
  public UnresolvedSetIterator end() /*const*/ {
    return Decls.end$Const();
  }

  
  /// \brief Return true if no decls were found
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 323,
   FQN="clang::LookupResult::empty", NM="_ZNK5clang12LookupResult5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Decls.empty();
  }

  
  /// \brief Return the base paths structure that's associated with
  /// these results, or null if none is.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::getBasePaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 327,
   FQN="clang::LookupResult::getBasePaths", NM="_ZNK5clang12LookupResult12getBasePathsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult12getBasePathsEv")
  //</editor-fold>
  public CXXBasePaths /*P*/ getBasePaths() /*const*/ {
    return Paths;
  }

  
  /// \brief Determine whether the given declaration is visible to the
  /// program.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::isVisible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 333,
   FQN="clang::LookupResult::isVisible", NM="_ZN5clang12LookupResult9isVisibleERNS_4SemaEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult9isVisibleERNS_4SemaEPNS_9NamedDeclE")
  //</editor-fold>
  public static boolean isVisible(final Sema /*&*/ SemaRef, NamedDecl /*P*/ D) {
    // If this declaration is not hidden, it's visible.
    if (!D.isHidden()) {
      return true;
    }
    
    // During template instantiation, we can refer to hidden declarations, if
    // they were visible in any module along the path of instantiation.
    return isVisibleSlow(SemaRef, D);
  }

  
  /// \brief Retrieve the accepted (re)declaration of the given declaration,
  /// if there is one.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::getAcceptableDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 345,
   FQN="clang::LookupResult::getAcceptableDecl", NM="_ZNK5clang12LookupResult17getAcceptableDeclEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult17getAcceptableDeclEPNS_9NamedDeclE")
  //</editor-fold>
  public NamedDecl /*P*/ getAcceptableDecl(NamedDecl /*P*/ D) /*const*/ {
    if (!D.isInIdentifierNamespace(IDNS)) {
      return null;
    }
    if (isVisible(getSema(), D) || isHiddenDeclarationVisible(D)) {
      return D;
    }
    
    return getAcceptableDeclSlow(D);
  }

/*private:*/
  
  /// \brief Determine whether a declaration is visible to name lookup.
  ///
  /// This routine determines whether the declaration D is visible in the current
  /// lookup context, taking into account the current template instantiation
  /// stack. During template instantiation, a declaration is visible if it is
  /// visible from a module containing any entity on the template instantiation
  /// path (by instantiating a template, you allow it to see the declarations that
  /// your module can see, including those later on in your module).
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::isVisibleSlow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1521,
   FQN="clang::LookupResult::isVisibleSlow", NM="_ZN5clang12LookupResult13isVisibleSlowERNS_4SemaEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult13isVisibleSlowERNS_4SemaEPNS_9NamedDeclE")
  //</editor-fold>
  private static boolean isVisibleSlow(final Sema /*&*/ SemaRef, NamedDecl /*P*/ D) {
    assert (D.isHidden()) : "should not call this: not in slow case";
    Module /*P*/ DeclModule = null;
    if (SemaRef.getLangOpts().ModulesLocalVisibility) {
      DeclModule = SemaRef.getOwningModule(D);
      if (!(DeclModule != null)) {
        // getOwningModule() may have decided the declaration should not be hidden.
        assert (!D.isHidden()) : "hidden decl not from a module";
        return true;
      }
      
      // If the owning module is visible, and the decl is not module private,
      // then the decl is visible too. (Module private is ignored within the same
      // top-level module.)
      if ((!D.isFromASTFile() || !D.isModulePrivate())
         && (SemaRef.isModuleVisible(DeclModule)
         || SemaRef.hasVisibleMergedDefinition(D))) {
        return true;
      }
    }
    
    // If this declaration is not at namespace scope nor module-private,
    // then it is visible if its lexical parent has a visible definition.
    DeclContext /*P*/ DC = D.getLexicalDeclContext();
    if (!D.isModulePrivate()
       && (DC != null) && !DC.isFileContext() && !isa_LinkageSpecDecl(DC)) {
      // For a parameter, check whether our current template declaration's
      // lexical context is visible, not whether there's some other visible
      // definition of it, because parameters aren't "within" the definition.
      if ((D.isTemplateParameter() || isa_ParmVarDecl(D)) ? isVisible(SemaRef, cast_NamedDecl(DC)) : SemaRef.hasVisibleDefinition(cast_NamedDecl(DC))) {
        if (SemaRef.ActiveTemplateInstantiations.empty()
          // FIXME: Do something better in this case.
           && !SemaRef.getLangOpts().ModulesLocalVisibility) {
          // Cache the fact that this declaration is implicitly visible because
          // its parent has a visible definition.
          D.setHidden(false);
        }
        return true;
      }
      return false;
    }
    
    // Find the extra places where we need to look.
    final DenseSet<Module /*P*/ > /*&*/ LookupModules = SemaRef.getLookupModules();
    if (LookupModules.empty()) {
      return false;
    }
    if (!(DeclModule != null)) {
      DeclModule = SemaRef.getOwningModule(D);
      assert ((DeclModule != null)) : "hidden decl not from a module";
    }
    
    // If our lookup set contains the decl's module, it's visible.
    if ((LookupModules.count(DeclModule) != 0)) {
      return true;
    }
    
    // If the declaration isn't exported, it's not visible in any other module.
    if (D.isModulePrivate()) {
      return false;
    }
    
    // Check whether DeclModule is transitively exported to an import of
    // the lookup set.
    Module DeclModuleFinal = DeclModule;
    return std.any_of(LookupModules.begin(), LookupModules.end(), 
         (M) -> 
          {
            return M.isModuleVisible(DeclModuleFinal);
          }
);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::getAcceptableDeclSlow">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1647,
   FQN="clang::LookupResult::getAcceptableDeclSlow", NM="_ZNK5clang12LookupResult21getAcceptableDeclSlowEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult21getAcceptableDeclSlowEPNS_9NamedDeclE")
  //</editor-fold>
  private NamedDecl /*P*/ getAcceptableDeclSlow(NamedDecl /*P*/ D) /*const*/ {
    {
      NamespaceDecl /*P*/ ND = dyn_cast_NamespaceDecl(D);
      if ((ND != null)) {
        // Namespaces are a bit of a special case: we expect there to be a lot of
        // redeclarations of some namespaces, all declarations of a namespace are
        // essentially interchangeable, all declarations are found by name lookup
        // if any is, and namespaces are never looked up during template
        // instantiation. So we benefit from caching the check in this case, and
        // it is correct to do so.
        NamespaceDecl /*P*/ Key = ND.getCanonicalDecl();
        {
          NamedDecl /*P*/ Acceptable = getSema().VisibleNamespaceCache.lookup(Key);
          if ((Acceptable != null)) {
            return Acceptable;
          }
        }
        NamedDecl /*P*/ Acceptable = isVisible(getSema(), Key) ? Key : findAcceptableDecl(getSema(), Key);
        if ((Acceptable != null)) {
          getSema().VisibleNamespaceCache.insert_pair$KeyT$ValueT(std.make_pair_Ptr_Ptr((NamedDecl /*P*/)Key, (NamedDecl /*P*/)Acceptable));
        }
        return Acceptable;
      }
    }
    
    return findAcceptableDecl(getSema(), D);
  }

/*public:*/
  /// \brief Returns the identifier namespace mask for this lookup.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::getIdentifierNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 361,
   FQN="clang::LookupResult::getIdentifierNamespace", NM="_ZNK5clang12LookupResult22getIdentifierNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult22getIdentifierNamespaceEv")
  //</editor-fold>
  public /*uint*/int getIdentifierNamespace() /*const*/ {
    return IDNS;
  }

  
  /// \brief Returns whether these results arose from performing a
  /// lookup into a class.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::isClassLookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 367,
   FQN="clang::LookupResult::isClassLookup", NM="_ZNK5clang12LookupResult13isClassLookupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult13isClassLookupEv")
  //</editor-fold>
  public boolean isClassLookup() /*const*/ {
    return NamingClass != null;
  }

  
  /// \brief Returns the 'naming class' for this lookup, i.e. the
  /// class which was looked into to find these results.
  ///
  /// C++0x [class.access.base]p5:
  ///   The access to a member is affected by the class in which the
  ///   member is named. This naming class is the class in which the
  ///   member name was looked up and found. [Note: this class can be
  ///   explicit, e.g., when a qualified-id is used, or implicit,
  ///   e.g., when a class member access operator (5.2.5) is used
  ///   (including cases where an implicit "this->" is added). If both
  ///   a class member access operator and a qualified-id are used to
  ///   name the member (as in p->T::m), the class naming the member
  ///   is the class named by the nested-name-specifier of the
  ///   qualified-id (that is, T). -- end note ]
  ///
  /// This is set by the lookup routines when they find results in a class.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::getNamingClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 387,
   FQN="clang::LookupResult::getNamingClass", NM="_ZNK5clang12LookupResult14getNamingClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult14getNamingClassEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getNamingClass() /*const*/ {
    return NamingClass;
  }

  
  /// \brief Sets the 'naming class' for this lookup.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::setNamingClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 392,
   FQN="clang::LookupResult::setNamingClass", NM="_ZN5clang12LookupResult14setNamingClassEPNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult14setNamingClassEPNS_13CXXRecordDeclE")
  //</editor-fold>
  public void setNamingClass(CXXRecordDecl /*P*/ Record) {
    NamingClass = Record;
  }

  
  /// \brief Returns the base object type associated with this lookup;
  /// important for [class.protected].  Most lookups do not have an
  /// associated base object.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::getBaseObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 399,
   FQN="clang::LookupResult::getBaseObjectType", NM="_ZNK5clang12LookupResult17getBaseObjectTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult17getBaseObjectTypeEv")
  //</editor-fold>
  public QualType getBaseObjectType() /*const*/ {
    return new QualType(BaseObjectType);
  }

  
  /// \brief Sets the base object type for this lookup.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::setBaseObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 404,
   FQN="clang::LookupResult::setBaseObjectType", NM="_ZN5clang12LookupResult17setBaseObjectTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult17setBaseObjectTypeENS_8QualTypeE")
  //</editor-fold>
  public void setBaseObjectType(QualType T) {
    BaseObjectType.$assign(T);
  }

  
  /// \brief Add a declaration to these results with its natural access.
  /// Does not test the acceptance criteria.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::addDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 410,
   FQN="clang::LookupResult::addDecl", NM="_ZN5clang12LookupResult7addDeclEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult7addDeclEPNS_9NamedDeclE")
  //</editor-fold>
  public void addDecl(NamedDecl /*P*/ D) {
    addDecl(D, D.getAccess());
  }

  
  /// \brief Add a declaration to these results with the given access.
  /// Does not test the acceptance criteria.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::addDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 416,
   FQN="clang::LookupResult::addDecl", NM="_ZN5clang12LookupResult7addDeclEPNS_9NamedDeclENS_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult7addDeclEPNS_9NamedDeclENS_15AccessSpecifierE")
  //</editor-fold>
  public void addDecl(NamedDecl /*P*/ D, AccessSpecifier AS) {
    Decls.addDecl(D, AS);
    ResultKind = LookupResultKind.Found;
  }

  
  /// \brief Add all the declarations from another set of lookup
  /// results.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::addAllDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 423,
   FQN="clang::LookupResult::addAllDecls", NM="_ZN5clang12LookupResult11addAllDeclsERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult11addAllDeclsERKS0_")
  //</editor-fold>
  public void addAllDecls(final /*const*/ LookupResult /*&*/ Other) {
    Decls.append(Other.Decls.begin$Const(), Other.Decls.end$Const());
    ResultKind = LookupResultKind.Found;
  }

  
  /// \brief Determine whether no result was found because we could not
  /// search into dependent base classes of the current instantiation.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::wasNotFoundInCurrentInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 430,
   FQN="clang::LookupResult::wasNotFoundInCurrentInstantiation", NM="_ZNK5clang12LookupResult33wasNotFoundInCurrentInstantiationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult33wasNotFoundInCurrentInstantiationEv")
  //</editor-fold>
  public boolean wasNotFoundInCurrentInstantiation() /*const*/ {
    return ResultKind == LookupResultKind.NotFoundInCurrentInstantiation;
  }

  
  /// \brief Note that while no result was found in the current instantiation,
  /// there were dependent base classes that could not be searched.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::setNotFoundInCurrentInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 436,
   FQN="clang::LookupResult::setNotFoundInCurrentInstantiation", NM="_ZN5clang12LookupResult33setNotFoundInCurrentInstantiationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult33setNotFoundInCurrentInstantiationEv")
  //</editor-fold>
  public void setNotFoundInCurrentInstantiation() {
    assert (ResultKind == LookupResultKind.NotFound && Decls.empty());
    ResultKind = LookupResultKind.NotFoundInCurrentInstantiation;
  }

  
  /// \brief Determine whether the lookup result was shadowed by some other
  /// declaration that lookup ignored.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::isShadowed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 443,
   FQN="clang::LookupResult::isShadowed", NM="_ZNK5clang12LookupResult10isShadowedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult10isShadowedEv")
  //</editor-fold>
  public boolean isShadowed() /*const*/ {
    return Shadowed;
  }

  
  /// \brief Note that we found and ignored a declaration while performing
  /// lookup.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::setShadowed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 447,
   FQN="clang::LookupResult::setShadowed", NM="_ZN5clang12LookupResult11setShadowedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult11setShadowedEv")
  //</editor-fold>
  public void setShadowed() {
    Shadowed = true;
  }

  
  /// \brief Resolves the result kind of the lookup, possibly hiding
  /// decls.
  ///
  /// This should be called in any environment where lookup might
  /// generate multiple lookup results.
  
  /// Resolves the result kind of this lookup.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::resolveKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 470,
   FQN="clang::LookupResult::resolveKind", NM="_ZN5clang12LookupResult11resolveKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult11resolveKindEv")
  //</editor-fold>
  public void resolveKind() {
    /*uint*/int N = Decls.size();
    
    // Fast case: no possible ambiguity.
    if (N == 0) {
      assert (ResultKind == LookupResultKind.NotFound || ResultKind == LookupResultKind.NotFoundInCurrentInstantiation);
      return;
    }
    
    // If there's a single decl, we need to examine it to decide what
    // kind of lookup this is.
    if (N == 1) {
      NamedDecl /*P*/ D = (Decls.begin().$star()).getUnderlyingDecl();
      if (isa_FunctionTemplateDecl(D)) {
        ResultKind = LookupResultKind.FoundOverloaded;
      } else if (isa_UnresolvedUsingValueDecl(D)) {
        ResultKind = LookupResultKind.FoundUnresolvedValue;
      }
      return;
    }
    
    // Don't do any extra resolution if we've already resolved as ambiguous.
    if (ResultKind == LookupResultKind.Ambiguous) {
      return;
    }
    
    SmallDenseMapTypeUInt<NamedDecl /*P*/ > Unique/*J*/= new SmallDenseMapTypeUInt<NamedDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16, 0);
    SmallDenseMapTypeUInt<QualType> UniqueTypes/*J*/= new SmallDenseMapTypeUInt<QualType>(DenseMapInfoQualType.$Info(), 16, (/*uint*/int)0);
    
    boolean Ambiguous = false;
    boolean HasTag = false, HasFunction = false;
    boolean HasFunctionTemplate = false, HasUnresolved = false;
    NamedDecl /*P*/ HasNonFunction = null;
    
    SmallVector<NamedDecl /*P*/ > EquivalentNonFunctions/*J*/= new SmallVector<NamedDecl /*P*/ >(4, (NamedDecl /*P*/ )null);
    
    /*uint*/int UniqueTagIndex = 0;
    
    /*uint*/int I = 0;
    while ($less_uint(I, N)) {
      NamedDecl /*P*/ D = Decls.$at(I).$arrow().getUnderlyingDecl();
      D = cast_NamedDecl(D.getCanonicalDecl());
      
      // Ignore an invalid declaration unless it's the only one left.
      if (D.isInvalidDecl() && !(I == 0 && N == 1)) {
        Decls.$at(I).$assign(Decls.$at(--N));
        continue;
      }
      
      OptionalUInt ExistingI/*J*/= new OptionalUInt();
      {
        
        // Redeclarations of types via typedef can occur both within a scope
        // and, through using declarations and directives, across scopes. There is
        // no ambiguity if they all refer to the same type, so unique based on the
        // canonical type.
        TypeDecl /*P*/ TD = dyn_cast_TypeDecl(D);
        if ((TD != null)) {
          QualType T = getSema().Context.getTypeDeclType(TD);
          std.pairTypeBool<DenseMapIteratorTypeUInt<QualType>> UniqueResult = UniqueTypes.insert_pair$KeyT$ValueT(std.make_pair_T_uint(getSema().Context.getCanonicalType(new QualType(T)).$QualType(), I));
          if (!UniqueResult.second) {
            // The type is not unique.
            ExistingI.$assign_T$C$R(UniqueResult.first.$arrow().second);
          }
        }
      }
      
      // For non-type declarations, check for a prior lookup result naming this
      // canonical declaration.
      if (!ExistingI.$bool()) {
        std.pairTypeBool<DenseMapIteratorTypeUInt<NamedDecl /*P*/ /*P*/>> UniqueResult = Unique.insert_pair$KeyT$ValueT(std.make_pair_Ptr_uint(D, I));
        if (!UniqueResult.second) {
          // We've seen this entity before.
          ExistingI.$assign_T$C$R(UniqueResult.first.$arrow().second);
        }
      }
      if (ExistingI.$bool()) {
        // This is not a unique lookup result. Pick one of the results and
        // discard the other.
        if (isPreferredLookupResult(getSema(), getLookupKind(), Decls.$at(I).$NamedDecl$P(), 
            Decls.$at(ExistingI.$star()).$NamedDecl$P())) {
          Decls.$at(ExistingI.$star()).$assign(Decls.$at(I));
        }
        Decls.$at(I).$assign(Decls.$at(--N));
        continue;
      }
      
      // Otherwise, do some decl type analysis and then continue.
      if (isa_UnresolvedUsingValueDecl(D)) {
        HasUnresolved = true;
      } else if (isa_TagDecl(D)) {
        if (HasTag) {
          Ambiguous = true;
        }
        UniqueTagIndex = I;
        HasTag = true;
      } else if (isa_FunctionTemplateDecl(D)) {
        HasFunction = true;
        HasFunctionTemplate = true;
      } else if (isa_FunctionDecl(D)) {
        HasFunction = true;
      } else {
        if ((HasNonFunction != null)) {
          // If we're about to create an ambiguity between two declarations that
          // are equivalent, but one is an internal linkage declaration from one
          // module and the other is an internal linkage declaration from another
          // module, just skip it.
          if (getSema().isEquivalentInternalLinkageDeclaration(HasNonFunction, 
              D)) {
            EquivalentNonFunctions.push_back(D);
            Decls.$at(I).$assign(Decls.$at(--N));
            continue;
          }
          
          Ambiguous = true;
        }
        HasNonFunction = D;
      }
      I++;
    }
    
    // C++ [basic.scope.hiding]p2:
    //   A class name or enumeration name can be hidden by the name of
    //   an object, function, or enumerator declared in the same
    //   scope. If a class or enumeration name and an object, function,
    //   or enumerator are declared in the same scope (in any order)
    //   with the same name, the class or enumeration name is hidden
    //   wherever the object, function, or enumerator name is visible.
    // But it's still an error if there are distinct tag types found,
    // even if they're not visible. (ref?)
    if ($greater_uint(N, 1) && HideTags && HasTag && !Ambiguous
       && (HasFunction || (HasNonFunction != null) || HasUnresolved)) {
      NamedDecl /*P*/ OtherDecl = Decls.$at((UniqueTagIndex != 0) ? 0 : N - 1).$NamedDecl$P();
      if (isa_TagDecl(Decls.$at(UniqueTagIndex).$arrow().getUnderlyingDecl())
         && getContextForScopeMatching(Decls.$at(UniqueTagIndex).$NamedDecl$P()).Equals(getContextForScopeMatching(OtherDecl))
         && canHideTag(OtherDecl)) {
        Decls.$at(UniqueTagIndex).$assign(Decls.$at(--N));
      } else {
        Ambiguous = true;
      }
    }
    
    // FIXME: This diagnostic should really be delayed until we're done with
    // the lookup result, in case the ambiguity is resolved by the caller.
    if (!EquivalentNonFunctions.empty() && !Ambiguous) {
      getSema().diagnoseEquivalentInternalLinkageDeclarations(getNameLoc(), HasNonFunction, new ArrayRef</*const*/ NamedDecl /*P*/ >(JD$Convertible.INSTANCE, EquivalentNonFunctions, true));
    }
    
    Decls.set_size(N);
    if ((HasNonFunction != null) && (HasFunction || HasUnresolved)) {
      Ambiguous = true;
    }
    if (Ambiguous) {
      setAmbiguous(LookupResult.AmbiguityKind.AmbiguousReference);
    } else if (HasUnresolved) {
      ResultKind = LookupResult.LookupResultKind.FoundUnresolvedValue;
    } else if ($greater_uint(N, 1) || HasFunctionTemplate) {
      ResultKind = LookupResult.LookupResultKind.FoundOverloaded;
    } else {
      ResultKind = LookupResult.LookupResultKind.Found;
    }
  }

  
  /// \brief Re-resolves the result kind of the lookup after a set of
  /// removals has been performed.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::resolveKindAfterFilter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 458,
   FQN="clang::LookupResult::resolveKindAfterFilter", NM="_ZN5clang12LookupResult22resolveKindAfterFilterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult22resolveKindAfterFilterEv")
  //</editor-fold>
  public void resolveKindAfterFilter() {
    if (Decls.empty()) {
      if (ResultKind != LookupResultKind.NotFoundInCurrentInstantiation) {
        ResultKind = LookupResultKind.NotFound;
      }
      if ((Paths != null)) {
        deletePaths(Paths);
        Paths = null;
      }
    } else {
      AmbiguityKind SavedAK = AmbiguityKind.AmbiguousBaseSubobjectTypes;
      boolean WasAmbiguous = false;
      if (ResultKind == LookupResultKind.Ambiguous) {
        SavedAK = Ambiguity;
        WasAmbiguous = true;
      }
      ResultKind = LookupResultKind.Found;
      resolveKind();
      
      // If we didn't make the lookup unambiguous, restore the old
      // ambiguity kind.
      if (ResultKind == LookupResultKind.Ambiguous) {
        ///*J:(void)*/WasAmbiguous;
        assert (WasAmbiguous);
        Ambiguity = SavedAK;
      } else if ((Paths != null)) {
        deletePaths(Paths);
        Paths = null;
      }
    }
  }

  
  /*template <class DeclClass> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::getAsSingle">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 491,
   FQN="clang::LookupResult::getAsSingle", NM="Tpl__ZNK5clang12LookupResult11getAsSingleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=Tpl__ZNK5clang12LookupResult11getAsSingleEv")
  //</editor-fold>
  public </*class*/ DeclClass> DeclClass /*P*/ getAsSingle(Class<DeclClass> clazz) /*const*/ {
    if (getResultKind() != LookupResultKind.Found) {
      return null;
    }
    return dyn_cast(clazz, getFoundDecl());
  }

  
  /// \brief Fetch the unique decl found by this lookup.  Asserts
  /// that one was found.
  ///
  /// This is intended for users who have examined the result kind
  /// and are certain that there is only one result.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::getFoundDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 501,
   FQN="clang::LookupResult::getFoundDecl", NM="_ZNK5clang12LookupResult12getFoundDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult12getFoundDeclEv")
  //</editor-fold>
  public NamedDecl /*P*/ getFoundDecl() /*const*/ {
    assert (getResultKind() == LookupResultKind.Found) : "getFoundDecl called on non-unique result";
    return (begin().$star()).getUnderlyingDecl();
  }

  
  /// Fetches a representative decl.  Useful for lazy diagnostics.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::getRepresentativeDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 508,
   FQN="clang::LookupResult::getRepresentativeDecl", NM="_ZNK5clang12LookupResult21getRepresentativeDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult21getRepresentativeDeclEv")
  //</editor-fold>
  public NamedDecl /*P*/ getRepresentativeDecl() /*const*/ {
    assert (!Decls.empty()) : "cannot get representative of empty set";
    return begin().$star();
  }

  
  /// \brief Asks if the result is a single tag decl.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::isSingleTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 514,
   FQN="clang::LookupResult::isSingleTagDecl", NM="_ZNK5clang12LookupResult15isSingleTagDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult15isSingleTagDeclEv")
  //</editor-fold>
  public boolean isSingleTagDecl() /*const*/ {
    return getResultKind() == LookupResultKind.Found && isa_TagDecl(getFoundDecl());
  }

  
  /// \brief Make these results show that the name was found in
  /// base classes of different types.
  ///
  /// The given paths object is copied and invalidated.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::setAmbiguousBaseSubobjectTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 645,
   FQN="clang::LookupResult::setAmbiguousBaseSubobjectTypes", NM="_ZN5clang12LookupResult30setAmbiguousBaseSubobjectTypesERNS_12CXXBasePathsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult30setAmbiguousBaseSubobjectTypesERNS_12CXXBasePathsE")
  //</editor-fold>
  public void setAmbiguousBaseSubobjectTypes(final CXXBasePaths /*&*/ P) {
    Paths = new CXXBasePaths();
    Paths.swap(P);
    addDeclsFromBasePaths($Deref(Paths));
    resolveKind();
    setAmbiguous(AmbiguityKind.AmbiguousBaseSubobjectTypes);
  }

  
  /// \brief Make these results show that the name was found in
  /// distinct base classes of the same type.
  ///
  /// The given paths object is copied and invalidated.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::setAmbiguousBaseSubobjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 637,
   FQN="clang::LookupResult::setAmbiguousBaseSubobjects", NM="_ZN5clang12LookupResult26setAmbiguousBaseSubobjectsERNS_12CXXBasePathsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult26setAmbiguousBaseSubobjectsERNS_12CXXBasePathsE")
  //</editor-fold>
  public void setAmbiguousBaseSubobjects(final CXXBasePaths /*&*/ P) {
    Paths = new CXXBasePaths();
    Paths.swap(P);
    addDeclsFromBasePaths($Deref(Paths));
    resolveKind();
    setAmbiguous(AmbiguityKind.AmbiguousBaseSubobjects);
  }

  
  /// \brief Make these results show that the name was found in
  /// different contexts and a tag decl was hidden by an ordinary
  /// decl in a different context.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::setAmbiguousQualifiedTagHiding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 533,
   FQN="clang::LookupResult::setAmbiguousQualifiedTagHiding", NM="_ZN5clang12LookupResult30setAmbiguousQualifiedTagHidingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult30setAmbiguousQualifiedTagHidingEv")
  //</editor-fold>
  public void setAmbiguousQualifiedTagHiding() {
    setAmbiguous(AmbiguityKind.AmbiguousTagHiding);
  }

  
  /// \brief Clears out any current state.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 538,
   FQN="clang::LookupResult::clear", NM="_ZN5clang12LookupResult5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult5clearEv")
  //</editor-fold>
  public void clear() {
    ResultKind = LookupResultKind.NotFound;
    Decls.clear();
    if ((Paths != null)) {
      deletePaths(Paths);
    }
    Paths = null;
    NamingClass = null;
    Shadowed = false;
  }

  
  /// \brief Clears out any current state and re-initializes for a
  /// different kind of lookup.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 549,
   FQN="clang::LookupResult::clear", NM="_ZN5clang12LookupResult5clearENS_4Sema14LookupNameKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult5clearENS_4Sema14LookupNameKindE")
  //</editor-fold>
  public void clear(Sema.LookupNameKind Kind) {
    clear();
    LookupKind = Kind;
    configure();
  }

  
  /// \brief Change this lookup's redeclaration kind.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::setRedeclarationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 556,
   FQN="clang::LookupResult::setRedeclarationKind", NM="_ZN5clang12LookupResult20setRedeclarationKindENS_4Sema17RedeclarationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult20setRedeclarationKindENS_4Sema17RedeclarationKindE")
  //</editor-fold>
  public void setRedeclarationKind(Sema.RedeclarationKind RK) {
    Redecl = (RK.getValue() != 0);
    configure();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 664,
   FQN="clang::LookupResult::dump", NM="_ZN5clang12LookupResult4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult4dumpEv")
  //</editor-fold>
  public void dump()/* __attribute__((used)) __attribute__((noinline))*/ {
    llvm.errs().$out(/*KEEP_STR*/"lookup results for ").$out(getLookupName().getAsString()).$out(
        /*KEEP_STR*/$COLON_LF
    );
    for (NamedDecl /*P*/ D : /*Deref*/this)  {
      D.dump();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 653,
   FQN="clang::LookupResult::print", NM="_ZN5clang12LookupResult5printERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult5printERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ Out) {
    Out.$out_uint(Decls.size()).$out(/*KEEP_STR*/" result(s)");
    if (isAmbiguous()) {
      Out.$out(/*KEEP_STR*/", ambiguous");
    }
    if ((Paths != null)) {
      Out.$out(/*KEEP_STR*/", base paths present");
    }
    
    for (UnresolvedSetIterator I = begin(), E = end(); I.$noteq(E); I.$preInc()) {
      Out.$out(/*KEEP_STR*/$LF);
      (I.$star()).print(Out, 2);
    }
  }

  
  /// Suppress the diagnostics that would normally fire because of this
  /// lookup.  This happens during (e.g.) redeclaration lookups.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::suppressDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 566,
   FQN="clang::LookupResult::suppressDiagnostics", NM="_ZN5clang12LookupResult19suppressDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult19suppressDiagnosticsEv")
  //</editor-fold>
  public void suppressDiagnostics() {
    Diagnose = false;
  }

  
  /// Determines whether this lookup is suppressing diagnostics.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::isSuppressingDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 571,
   FQN="clang::LookupResult::isSuppressingDiagnostics", NM="_ZNK5clang12LookupResult24isSuppressingDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult24isSuppressingDiagnosticsEv")
  //</editor-fold>
  public boolean isSuppressingDiagnostics() /*const*/ {
    return !Diagnose;
  }

  
  /// Sets a 'context' source range.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::setContextRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 576,
   FQN="clang::LookupResult::setContextRange", NM="_ZN5clang12LookupResult15setContextRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult15setContextRangeENS_11SourceRangeE")
  //</editor-fold>
  public void setContextRange(SourceRange SR) {
    NameContextRange.$assign(SR);
  }

  
  /// Gets the source range of the context of this name; for C++
  /// qualified lookups, this is the source range of the scope
  /// specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::getContextRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 583,
   FQN="clang::LookupResult::getContextRange", NM="_ZNK5clang12LookupResult15getContextRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult15getContextRangeEv")
  //</editor-fold>
  public SourceRange getContextRange() /*const*/ {
    return new SourceRange(NameContextRange);
  }

  
  /// Gets the location of the identifier.  This isn't always defined:
  /// sometimes we're doing lookups on synthesized names.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::getNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 589,
   FQN="clang::LookupResult::getNameLoc", NM="_ZNK5clang12LookupResult10getNameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult10getNameLocEv")
  //</editor-fold>
  public SourceLocation getNameLoc() /*const*/ {
    return NameInfo.getLoc();
  }

  
  /// \brief Get the Sema object that this lookup result is searching
  /// with.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::getSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 595,
   FQN="clang::LookupResult::getSema", NM="_ZNK5clang12LookupResult7getSemaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult7getSemaEv")
  //</editor-fold>
  public Sema /*&*/ getSema() /*const*/ {
    return $Deref(SemaPtr);
  }

  
  /// A class for iterating through a result set and possibly
  /// filtering out results.  The results returned are possibly
  /// sugared.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::Filter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 600,
   FQN="clang::LookupResult::Filter", NM="_ZN5clang12LookupResult6FilterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult6FilterE")
  //</editor-fold>
  public static class Filter implements Destructors.ClassWithDestructor {
    private final LookupResult /*&*/ Results;
    private UnresolvedSetIterator I;
    private boolean Changed;
    private boolean CalledDone;
    
    /*friend  class LookupResult*/
    //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::Filter::Filter">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 607,
     FQN="clang::LookupResult::Filter::Filter", NM="_ZN5clang12LookupResult6FilterC1ERS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult6FilterC1ERS0_")
    //</editor-fold>
    private Filter(final LookupResult /*&*/ Results) {
      // : Results(Results), I(Results.begin()), Changed(false), CalledDone(false) 
      //START JInit
      this./*&*/Results=/*&*/Results;
      this.I = $tryClone(Results.begin());
      this.Changed = false;
      this.CalledDone = false;
      //END JInit
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::Filter::Filter">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 612,
     FQN="clang::LookupResult::Filter::Filter", NM="_ZN5clang12LookupResult6FilterC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult6FilterC1EOS1_")
    //</editor-fold>
    public Filter(JD$Move _dparam, final Filter /*&&*/F) {
      // : Results(F.Results), I(F.I), Changed(F.Changed), CalledDone(F.CalledDone) 
      //START JInit
      this./*&*/Results=/*&*/F.Results;
      this.I = $tryClone(new UnresolvedSetIterator(F.I));
      this.Changed = F.Changed;
      this.CalledDone = F.CalledDone;
      //END JInit
      F.CalledDone = true;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::Filter::~Filter">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 617,
     FQN="clang::LookupResult::Filter::~Filter", NM="_ZN5clang12LookupResult6FilterD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult6FilterD0Ev")
    //</editor-fold>
    public void $destroy() {
      assert (CalledDone) : "LookupResult::Filter destroyed without done() call";
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::Filter::hasNext">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 622,
     FQN="clang::LookupResult::Filter::hasNext", NM="_ZNK5clang12LookupResult6Filter7hasNextEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult6Filter7hasNextEv")
    //</editor-fold>
    public boolean hasNext() /*const*/ {
      return I.$noteq(Results.end());
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::Filter::next">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 626,
     FQN="clang::LookupResult::Filter::next", NM="_ZN5clang12LookupResult6Filter4nextEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult6Filter4nextEv")
    //</editor-fold>
    public NamedDecl /*P*/ next() {
      assert (I.$noteq(Results.end())) : "next() called on empty filter";
      return I.$postInc(0).$star();
    }

    
    /// Restart the iteration.
    //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::Filter::restart">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 632,
     FQN="clang::LookupResult::Filter::restart", NM="_ZN5clang12LookupResult6Filter7restartEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult6Filter7restartEv")
    //</editor-fold>
    public void restart() {
      I.$assignMove(Results.begin());
    }

    
    /// Erase the last element returned from this iterator.
    //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::Filter::erase">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 637,
     FQN="clang::LookupResult::Filter::erase", NM="_ZN5clang12LookupResult6Filter5eraseEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult6Filter5eraseEv")
    //</editor-fold>
    public void erase() {
      Results.Decls.erase(new UnresolvedSetIterator(I.$preDec()));
      Changed = true;
    }

    
    /// Replaces the current entry with the given one, preserving the
    /// access bits.
    //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::Filter::replace">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 644,
     FQN="clang::LookupResult::Filter::replace", NM="_ZN5clang12LookupResult6Filter7replaceEPNS_9NamedDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult6Filter7replaceEPNS_9NamedDeclE")
    //</editor-fold>
    public void replace(NamedDecl /*P*/ D) {
      Results.Decls.replace(I.$sub(1), D);
      Changed = true;
    }

    
    /// Replaces the current entry with the given one.
    //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::Filter::replace">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 650,
     FQN="clang::LookupResult::Filter::replace", NM="_ZN5clang12LookupResult6Filter7replaceEPNS_9NamedDeclENS_15AccessSpecifierE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult6Filter7replaceEPNS_9NamedDeclENS_15AccessSpecifierE")
    //</editor-fold>
    public void replace(NamedDecl /*P*/ D, AccessSpecifier AS) {
      Results.Decls.replace(I.$sub(1), D, AS);
      Changed = true;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::Filter::done">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 655,
     FQN="clang::LookupResult::Filter::done", NM="_ZN5clang12LookupResult6Filter4doneEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult6Filter4doneEv")
    //</editor-fold>
    public void done() {
      assert (!CalledDone) : "done() called twice";
      CalledDone = true;
      if (Changed) {
        Results.resolveKindAfterFilter();
      }
    }

    
    @Override public String toString() {
      return "" + "Results=" + Results // NOI18N
                + ", I=" + I // NOI18N
                + ", Changed=" + Changed // NOI18N
                + ", CalledDone=" + CalledDone; // NOI18N
    }
  };
  
  /// Create a filter for this result set.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::makeFilter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 665,
   FQN="clang::LookupResult::makeFilter", NM="_ZN5clang12LookupResult10makeFilterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult10makeFilterEv")
  //</editor-fold>
  public Filter makeFilter() {
    return new Filter(/*Deref*/this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::setFindLocalExtern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 669,
   FQN="clang::LookupResult::setFindLocalExtern", NM="_ZN5clang12LookupResult18setFindLocalExternEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult18setFindLocalExternEb")
  //</editor-fold>
  public void setFindLocalExtern(boolean FindLocalExtern) {
    if (FindLocalExtern) {
      IDNS |= Decl.IdentifierNamespace.IDNS_LocalExtern;
    } else {
      IDNS &= ~Decl.IdentifierNamespace.IDNS_LocalExtern;
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::diagnose">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 677,
   FQN="clang::LookupResult::diagnose", NM="_ZN5clang12LookupResult8diagnoseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult8diagnoseEv")
  //</editor-fold>
  private void diagnose() {
    if (isAmbiguous()) {
      getSema().DiagnoseAmbiguousLookup(/*Deref*/this);
    } else if (isClassLookup() && getSema().getLangOpts().AccessControl) {
      getSema().CheckLookupAccess(/*Deref*/this);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::setAmbiguous">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 684,
   FQN="clang::LookupResult::setAmbiguous", NM="_ZN5clang12LookupResult12setAmbiguousENS0_13AmbiguityKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult12setAmbiguousENS0_13AmbiguityKindE")
  //</editor-fold>
  private void setAmbiguous(AmbiguityKind AK) {
    ResultKind = LookupResultKind.Ambiguous;
    Ambiguity = AK;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::addDeclsFromBasePaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 629,
   FQN="clang::LookupResult::addDeclsFromBasePaths", NM="_ZN5clang12LookupResult21addDeclsFromBasePathsERKNS_12CXXBasePathsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult21addDeclsFromBasePathsERKNS_12CXXBasePathsE")
  //</editor-fold>
  private void addDeclsFromBasePaths(final /*const*/ CXXBasePaths /*&*/ P) {
    std.list.iterator<CXXBasePath> I/*J*/= new std.list.iterator<CXXBasePath>(), E/*J*/= new std.list.iterator<CXXBasePath>();
    for (I.$assignMove(P.begin$Const()) , E.$assignMove(P.end$Const()); I.$noteq(E); I.$preInc())  {
      for (DeclContextLookupResult.iterator DI = I.$arrow().Decls.begin(), 
          DE = I.$arrow().Decls.end(); DI.$noteq(DE); DI.$preInc())  {
        addDecl(DI.$star());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::configure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 295,
   FQN="clang::LookupResult::configure", NM="_ZN5clang12LookupResult9configureEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult9configureEv")
  //</editor-fold>
  private void configure() {
    IDNS = getIDNS(LookupKind, getSema().getLangOpts().CPlusPlus, 
        isForRedeclaration());
    
    // If we're looking for one of the allocation or deallocation
    // operators, make sure that the implicitly-declared new and delete
    // operators can be found.
    switch (NameInfo.getName().getCXXOverloadedOperator()) {
     case OO_New:
     case OO_Delete:
     case OO_Array_New:
     case OO_Array_Delete:
      getSema().DeclareGlobalNewDelete();
      break;
     default:
      break;
    }
    {
      
      // Compiler builtins are always visible, regardless of where they end
      // up being declared.
      IdentifierInfo /*P*/ Id = NameInfo.getName().getAsIdentifierInfo();
      if ((Id != null)) {
        {
          /*uint*/int BuiltinID = Id.getBuiltinID();
          if ((BuiltinID != 0)) {
            if (!getSema().Context.BuiltinInfo.isPredefinedLibFunction(BuiltinID)) {
              AllowHidden = true;
            }
          }
        }
      }
    }
  }

  
  // Sanity checks.
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::sanity">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assert messages*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 324,
   FQN="clang::LookupResult::sanity", NM="_ZNK5clang12LookupResult6sanityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult6sanityEv")
  //</editor-fold>
  private boolean sanity() /*const*/ {
    // This function is never called by NDEBUG builds.
    assert (ResultKind != LookupResultKind.NotFound || Decls.size() == 0) : "ResultKind=" + ResultKind + "; Decls size=" + Decls.size();
    assert (ResultKind != LookupResultKind.Found || Decls.size() == 1) : "ResultKind=" + ResultKind + "; Decls size=" + Decls.size();
    assert (ResultKind != LookupResultKind.FoundOverloaded || $greater_uint(Decls.size(), 1) || (Decls.size() == 1 && isa_FunctionTemplateDecl((begin().$star()).getUnderlyingDecl()))) : "ResultKind=" + ResultKind + "; Decls size=" + Decls.size();
    assert (ResultKind != LookupResultKind.FoundUnresolvedValue || sanityCheckUnresolved()) : "ResultKind=" + ResultKind + "; sanityCheckUnresolved =" + sanityCheckUnresolved();
    assert (ResultKind != LookupResultKind.Ambiguous || $greater_uint(Decls.size(), 1) || (Decls.size() == 1 && (Ambiguity == AmbiguityKind.AmbiguousBaseSubobjects || Ambiguity == AmbiguityKind.AmbiguousBaseSubobjectTypes)))
             : "ResultKind=" + ResultKind + "; Ambiguity=" + Ambiguity + "; Decls size=" + Decls.size();
    assert ((Paths != null) == (ResultKind == LookupResultKind.Ambiguous && (Ambiguity == AmbiguityKind.AmbiguousBaseSubobjectTypes || Ambiguity == AmbiguityKind.AmbiguousBaseSubobjects)))
            : "ResultKind=" + ResultKind + "; Ambiguity=" + Ambiguity + "; Decls size=" + Decls.size();
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::sanityCheckUnresolved">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 695,
   FQN="clang::LookupResult::sanityCheckUnresolved", NM="_ZNK5clang12LookupResult21sanityCheckUnresolvedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang12LookupResult21sanityCheckUnresolvedEv")
  //</editor-fold>
  private boolean sanityCheckUnresolved() /*const*/ {
    for (UnresolvedSetIterator I = begin(), E = end(); I.$noteq(E); I.$preInc())  {
      if (isa_UnresolvedUsingValueDecl((I.$star()).getUnderlyingDecl())) {
        return true;
      }
    }
    return false;
  }

  
  
  // Necessary because CXXBasePaths is not complete in Sema.h
  //<editor-fold defaultstate="collapsed" desc="clang::LookupResult::deletePaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 342,
   FQN="clang::LookupResult::deletePaths", NM="_ZN5clang12LookupResult11deletePathsEPNS_12CXXBasePathsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang12LookupResult11deletePathsEPNS_12CXXBasePathsE")
  //</editor-fold>
  private static void deletePaths(CXXBasePaths /*P*/ Paths) {
    if (Paths != null) { Paths.$destroy();};
  }

  
  // Results.
  private LookupResultKind ResultKind;
  private AmbiguityKind Ambiguity; // ill-defined unless ambiguous
  private UnresolvedSet Decls;
  private CXXBasePaths /*P*/ Paths;
  private CXXRecordDecl /*P*/ NamingClass;
  private QualType BaseObjectType;
  
  // Parameters.
  private Sema /*P*/ SemaPtr;
  private DeclarationNameInfo NameInfo;
  private SourceRange NameContextRange;
  private Sema.LookupNameKind LookupKind;
  private /*uint*/int IDNS; // set by configure()
  
  private boolean Redecl;
  
  /// \brief True if tag declarations should be hidden if non-tags
  ///   are present
  private boolean HideTags;
  
  private boolean Diagnose;
  
  /// \brief True if we should allow hidden declarations to be 'visible'.
  private boolean AllowHidden;
  
  /// \brief True if the found declarations were shadowed by some other
  /// declaration that we skipped. This only happens when \c LookupKind
  /// is \c LookupRedeclarationWithLinkage.
  private boolean Shadowed;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public Iterator<NamedDecl> iterator() {return new JavaIterator(begin(), end());}

  @Override public LookupResult move() { return new LookupResult(JD$Move.INSTANCE, this); }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "ResultKind=" + ResultKind // NOI18N
              + ", Ambiguity=" + Ambiguity // NOI18N
              + ", Decls=" + Decls // NOI18N
              + ", Paths=" + Paths // NOI18N
              + ", NamingClass=" + NamingClass // NOI18N
              + ", BaseObjectType=" + BaseObjectType // NOI18N
              + ", SemaPtr=" + "[Sema]" // NOI18N
              + ", NameInfo=" + NameInfo // NOI18N
              + ", NameContextRange=" + NameContextRange // NOI18N
              + ", LookupKind=" + LookupKind // NOI18N
              + ", IDNS=" + IDNS // NOI18N
              + ", Redecl=" + Redecl // NOI18N
              + ", HideTags=" + HideTags // NOI18N
              + ", Diagnose=" + Diagnose // NOI18N
              + ", AllowHidden=" + AllowHidden // NOI18N
              + ", Shadowed=" + Shadowed; // NOI18N
  }
}
