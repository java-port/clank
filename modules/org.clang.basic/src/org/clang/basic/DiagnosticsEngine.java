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

package org.clang.basic;

import java.util.Iterator;
import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.basic.FullSourceLoc.*;

import static org.clang.basic.impl.DiagnosticIDsStatics.GetDefaultDiagMapping;
import org.clang.basic.impl.DiagnosticStatics;
import org.clang.basic.java.diagJava;
import org.clank.support.aliases.JavaIterator;


/// \brief Concrete class used by the front-end to report problems and issues.
///
/// This massages the diagnostics (e.g. handling things like "report warnings
/// as errors" and passes them off to the DiagnosticConsumer for reporting to
/// the user. DiagnosticsEngine is tied to one translation unit and one
/// SourceManager.
//<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 135,
 FQN="clang::DiagnosticsEngine", NM="_ZN5clang17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngineE")
//</editor-fold>
public class DiagnosticsEngine extends/*public*/ RefCountedBase<DiagnosticsEngine> implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::DiagnosticsEngine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 136,
   FQN="clang::DiagnosticsEngine::DiagnosticsEngine", NM="_ZN5clang17DiagnosticsEngineC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngineC1ERKS0_")
  //</editor-fold>
  private DiagnosticsEngine(/*const*/ DiagnosticsEngine /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 137,
   FQN="clang::DiagnosticsEngine::operator=", NM="_ZN5clang17DiagnosticsEngineaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngineaSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ DiagnosticsEngine /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  /// \brief The level of the diagnostic, after it has been through mapping.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::Level">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 141,
   FQN="clang::DiagnosticsEngine::Level", NM="_ZN5clang17DiagnosticsEngine5LevelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine5LevelE")
  //</editor-fold>
  public enum Level implements Native.ComparableLower {
    Ignored(DiagnosticIDs.Level.Ignored.getValue()),
    Note(DiagnosticIDs.Level.Note.getValue()),
    Remark(DiagnosticIDs.Level.Remark.getValue()),
    Warning(DiagnosticIDs.Level.Warning.getValue()),
    Error(DiagnosticIDs.Level.Error.getValue()),
    Fatal(DiagnosticIDs.Level.Fatal.getValue());

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Level valueOf(int val) {
      Level out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Level[] VALUES;
      private static final Level[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Level kind : Level.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Level[min < 0 ? (1-min) : 0];
        VALUES = new Level[max >= 0 ? (1+max) : 0];
        for (Level kind : Level.values()) {
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
    private Level(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Level)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Level)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::ArgumentKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 150,
   FQN="clang::DiagnosticsEngine::ArgumentKind", NM="_ZN5clang17DiagnosticsEngine12ArgumentKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine12ArgumentKindE")
  //</editor-fold>
  public enum ArgumentKind implements Native.ComparableLower {
    ak_std_string(0), ///< std::string
    ak_c_string(ak_std_string.getValue() + 1), ///< const char *
    ak_sint(ak_c_string.getValue() + 1), ///< int
    ak_uint(ak_sint.getValue() + 1), ///< unsigned
    ak_tokenkind(ak_uint.getValue() + 1), ///< enum TokenKind : unsigned
    ak_identifierinfo(ak_tokenkind.getValue() + 1), ///< IdentifierInfo
    ak_qualtype(ak_identifierinfo.getValue() + 1), ///< QualType
    ak_declarationname(ak_qualtype.getValue() + 1), ///< DeclarationName
    ak_nameddecl(ak_declarationname.getValue() + 1), ///< NamedDecl *
    ak_nestednamespec(ak_nameddecl.getValue() + 1), ///< NestedNameSpecifier *
    ak_declcontext(ak_nestednamespec.getValue() + 1), ///< DeclContext *
    ak_qualtype_pair(ak_declcontext.getValue() + 1), ///< pair<QualType, QualType>
    ak_attr(ak_qualtype_pair.getValue() + 1); ///< Attr *

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ArgumentKind valueOf(int val) {
      ArgumentKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ArgumentKind[] VALUES;
      private static final ArgumentKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ArgumentKind kind : ArgumentKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ArgumentKind[min < 0 ? (1-min) : 0];
        VALUES = new ArgumentKind[max >= 0 ? (1+max) : 0];
        for (ArgumentKind kind : ArgumentKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ArgumentKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ArgumentKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ArgumentKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Represents on argument value, which is a union discriminated
  /// by ArgumentKind, with a value.
  /*typedef std::pair<ArgumentKind, intptr_t> ArgumentValue*/
//  public final class ArgumentValue extends std.pair<ArgumentKind, Object/*intptr_t*/>{ };
/*private:*/
  /*friend*/ /*uchar*/byte AllExtensionsSilenced; // Used by __extension__
  /*friend*/ boolean IgnoreAllWarnings; // Ignore all warnings: -w
  /*friend*/ boolean WarningsAsErrors; // Treat warnings like errors.
  /*friend*/ boolean EnableAllWarnings; // Enable all warnings.
  /*friend*/ boolean ErrorsAsFatal; // Treat errors like fatal errors.
  /*friend*/ boolean FatalsAsError; // Treat fatal errors like errors.
  /*friend*/ boolean SuppressSystemWarnings; // Suppress warnings in system headers.
  /*friend*/ boolean SuppressAllDiagnostics; // Suppress all diagnostics.
  /*friend*/ boolean ElideType; // Elide common types of templates.
  /*friend*/ boolean PrintTemplateTree; // Print a tree when comparing templates.
  /*friend*/ boolean ShowColors; // Color printing is enabled.
  private OverloadsShown ShowOverloads; // Which overload candidates to show.
  /*friend*/ /*uint*/int ErrorLimit; // Cap of # errors emitted, 0 -> no limit.
  private /*uint*/int TemplateBacktraceLimit; // Cap on depth of template backtrace stack,
  // 0 -> no limit.
  private /*uint*/int ConstexprBacktraceLimit; // Cap on depth of constexpr evaluation
  // backtrace stack, 0 -> no limit.
  /*friend*/ diag.Severity ExtBehavior; // Map extensions to warnings or errors?
  private IntrusiveRefCntPtr<DiagnosticIDs> Diags;
  private IntrusiveRefCntPtr<DiagnosticOptions> DiagOpts;
  /*friend*/ DiagnosticConsumer /*P*/ Client;
  private std.unique_ptr<DiagnosticConsumer> Owner;
  private SourceManager /*P*/ SourceMgr;
  
  /// \brief Mapping information for diagnostics.
  ///
  /// Mapping info is packed into four bits per diagnostic.  The low three
  /// bits are the mapping (an instance of diag::Severity), or zero if unset.
  /// The high bit is set when the mapping was established as a user mapping.
  /// If the high bit is clear, then the low bits are set to the default
  /// value, and should be mapped with -pedantic, -Werror, etc.
  ///
  /// A new DiagState is created and kept around when diagnostic pragmas modify
  /// the state so that we know what is the diagnostic state at any given
  /// source location.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::DiagState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 206,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 205,
   FQN="clang::DiagnosticsEngine::DiagState", NM="_ZN5clang17DiagnosticsEngine9DiagStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine9DiagStateE")
  //</editor-fold>
  /*friend*/ public/*private*/ static class DiagState implements NativeCloneable<DiagState>, Iterable<std.pairUIntType<DiagnosticMapping>>, Destructors.ClassWithDestructor {
    private DenseMapUIntType<DiagnosticMapping> DiagMap;
  /*public:*/
    /*typedef llvm::DenseMap<unsigned int, DiagnosticMapping>::iterator iterator*/
//    public final class iterator extends DenseMapIteratorUIntType<DiagnosticMapping>{ };
    /*typedef llvm::DenseMap<unsigned int, DiagnosticMapping>::const_iterator const_iterator*/
//    public final class const_iterator extends DenseMapIteratorUIntType<DiagnosticMapping>{ };
    
    //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::DiagState::setMapping">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 214,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 213,
     FQN="clang::DiagnosticsEngine::DiagState::setMapping", NM="_ZN5clang17DiagnosticsEngine9DiagState10setMappingEjNS_17DiagnosticMappingE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine9DiagState10setMappingEjNS_17DiagnosticMappingE")
    //</editor-fold>
    public void setMapping(/*uint*/int Diag, DiagnosticMapping Info) {
      DiagMap.$at(Diag).$assign(Info);
    }

    
    // Unfortunately, the split between DiagnosticIDs and Diagnostic is not
    // particularly clean, but for now we just implement this method here so we can
    // access GetDefaultDiagMapping.
    //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::DiagState::getOrAddMapping">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 197,
     FQN="clang::DiagnosticsEngine::DiagState::getOrAddMapping", NM="_ZN5clang17DiagnosticsEngine9DiagState15getOrAddMappingEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang17DiagnosticsEngine9DiagState15getOrAddMappingEj")
    //</editor-fold>
    public DiagnosticMapping /*&*/ getOrAddMapping(/*uint*/int Diag) {
      std.pairTypeBool<DenseMapIteratorUIntType<DiagnosticMapping>> Result = DiagMap.insert(std.make_pair_uint_T(Diag, new DiagnosticMapping()));
      
      // Initialize the entry if we added it.
      if (Result.second) {
        Result.first.$star().second.$assignMove(GetDefaultDiagMapping(Diag));
      }
      
      return Result.first.$star().second;
    }

    
    
    //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::DiagState::begin">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 220,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 219,
     FQN="clang::DiagnosticsEngine::DiagState::begin", NM="_ZNK5clang17DiagnosticsEngine9DiagState5beginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine9DiagState5beginEv")
    //</editor-fold>
    public DenseMapIteratorUIntType<DiagnosticMapping> begin() /*const*/ {
      return DiagMap.begin();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::DiagState::end">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 221,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 220,
     FQN="clang::DiagnosticsEngine::DiagState::end", NM="_ZNK5clang17DiagnosticsEngine9DiagState3endEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine9DiagState3endEv")
    //</editor-fold>
    public DenseMapIteratorUIntType<DiagnosticMapping> end() /*const*/ {
      return DiagMap.end();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::DiagState::~DiagState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 206,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 205,
     FQN="clang::DiagnosticsEngine::DiagState::~DiagState", NM="_ZN5clang17DiagnosticsEngine9DiagStateD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine9DiagStateD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      DiagMap.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::DiagState::DiagState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 206,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 205,
     FQN="clang::DiagnosticsEngine::DiagState::DiagState", NM="_ZN5clang17DiagnosticsEngine9DiagStateC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine9DiagStateC1ERKS1_")
    //</editor-fold>
    public /*inline*/ DiagState(/*const*/ DiagState /*&*/ $Prm0) {
      /* : DiagMap(.DiagMap)*/ 
      //START JInit
      this.DiagMap = new DenseMapUIntType<DiagnosticMapping>($Prm0.DiagMap);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::DiagState::DiagState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 206,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 205,
     FQN="clang::DiagnosticsEngine::DiagState::DiagState", NM="_ZN5clang17DiagnosticsEngine9DiagStateC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine9DiagStateC1Ev")
    //</editor-fold>
    public /*inline*/ DiagState() {
      /* : DiagMap()*/ 
      //START JInit
      this.DiagMap = new DenseMapUIntType<DiagnosticMapping>(DenseMapInfoUInt.$Info(), new DiagnosticMapping());
      //END JInit
    }

    @Override public DiagState clone() { return new DiagState(this); }
    
    @Override
    public Iterator<std.pairUIntType<DiagnosticMapping>> iterator() {
      return new JavaIterator(begin(), end());
    }

    public String toString() {
      return "" + "DiagMap=" + DiagMap; // NOI18N
    }

  };
  
  /// \brief Keeps and automatically disposes all DiagStates that we create.
  /*friend*/public std.list<DiagState> DiagStates;
  
  /// \brief Represents a point in source where the diagnostic state was
  /// modified because of a pragma.
  ///
  /// 'Loc' can be null if the point represents the diagnostic state
  /// modifications done through the command-line.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::DiagStatePoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 232,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 231,
   FQN="clang::DiagnosticsEngine::DiagStatePoint", NM="_ZN5clang17DiagnosticsEngine14DiagStatePointE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine14DiagStatePointE")
  //</editor-fold>
  /*friend*/ public static class/*struct*/ DiagStatePoint implements NativeCloneable<DiagStatePoint> {
    public DiagState /*P*/ State;
    public FullSourceLoc Loc;

    public DiagStatePoint() {
      this.State = null;
      this.Loc = new FullSourceLoc();
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::DiagStatePoint::DiagStatePoint">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 235,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 234,
     FQN="clang::DiagnosticsEngine::DiagStatePoint::DiagStatePoint", NM="_ZN5clang17DiagnosticsEngine14DiagStatePointC1EPNS0_9DiagStateENS_13FullSourceLocE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine14DiagStatePointC1EPNS0_9DiagStateENS_13FullSourceLocE")
    //</editor-fold>
    public DiagStatePoint(DiagState /*P*/ State, FullSourceLoc Loc) {
      /* : State(State), Loc(Loc)*/ 
      //START JInit
      this.State = State;
      this.Loc = new FullSourceLoc(Loc);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::DiagStatePoint::operator<">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 238,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 237,
     FQN="clang::DiagnosticsEngine::DiagStatePoint::operator<", NM="_ZNK5clang17DiagnosticsEngine14DiagStatePointltERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine14DiagStatePointltERKS1_")
    //</editor-fold>
    public boolean $less(/*const*/ DiagStatePoint /*&*/ RHS) /*const*/ {
      // If Loc is invalid it means it came from <command-line>, in which case
      // we regard it as coming before any valid source location.
      if (RHS.Loc.isInvalid()) {
        return false;
      }
      if (Loc.isInvalid()) {
        return true;
      }
      return Loc.isBeforeInTranslationUnitThan(/*NO_COPY*/RHS.Loc);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::DiagStatePoint::DiagStatePoint">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 232,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 231,
     FQN="clang::DiagnosticsEngine::DiagStatePoint::DiagStatePoint", NM="_ZN5clang17DiagnosticsEngine14DiagStatePointC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine14DiagStatePointC1EOS1_")
    //</editor-fold>
    public /*inline*/ DiagStatePoint(JD$Move _dparam, DiagStatePoint /*&&*/$Prm0) {
      /* : State(static_cast<DiagStatePoint &&>().State), Loc(static_cast<DiagStatePoint &&>().Loc)*/ 
      //START JInit
      this.State = $Prm0.State;
      this.Loc = new FullSourceLoc(JD$Move.INSTANCE, $Prm0.Loc);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::DiagStatePoint::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 232,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 231,
     FQN="clang::DiagnosticsEngine::DiagStatePoint::operator=", NM="_ZN5clang17DiagnosticsEngine14DiagStatePointaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine14DiagStatePointaSEOS1_")
    //</editor-fold>
    public /*inline*/ DiagStatePoint /*&*/ $assignMove(DiagStatePoint /*&&*/$Prm0) {
      this.State = $Prm0.State;
      this.Loc.$assignMove($Prm0.Loc);
      return /*Deref*/this;
    }

    @Override public DiagStatePoint clone() { return new DiagStatePoint(this.State, this.Loc); }
    
    public String toString() {
      return "" + "State=" + State // NOI18N
                + ", Loc=" + Loc; // NOI18N
    }
  };
  
  // JAVA PERF: to prevent Native.$less complexity
  private static final Native.ComparatorLower DiagStatePointComparator = new Native.ComparatorLower<DiagStatePoint, DiagStatePoint>() {
    @Override
    public boolean $less(DiagStatePoint one, DiagStatePoint other) {
      return one.$less(other);
    }
  };
  
  /// \brief A sorted vector of all DiagStatePoints representing changes in
  /// diagnostic state due to diagnostic pragmas.
  ///
  /// The vector is always sorted according to the SourceLocation of the
  /// DiagStatePoint.
  /*typedef std::vector<DiagStatePoint> DiagStatePointsTy*/
//  public final class DiagStatePointsTy extends std.vector<DiagStatePoint>{ };
  /*friend*/public /*mutable */std.vector<DiagStatePoint> DiagStatePoints;
  
  /// \brief Keeps the DiagState that was active during each diagnostic 'push'
  /// so we can get back at it when we 'pop'.
  private std.vector<DiagState /*P*/ > DiagStateOnPushStack;
  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::GetCurDiagState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 261,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 260,
   FQN="clang::DiagnosticsEngine::GetCurDiagState", NM="_ZNK5clang17DiagnosticsEngine15GetCurDiagStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine15GetCurDiagStateEv")
  //</editor-fold>
  /*friend*/public DiagState /*P*/ GetCurDiagState() /*const*/ {
    assert (!DiagStatePoints.empty());
    return DiagStatePoints.back().State;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::PushDiagStatePoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 266,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 265,
   FQN="clang::DiagnosticsEngine::PushDiagStatePoint", NM="_ZN5clang17DiagnosticsEngine18PushDiagStatePointEPNS0_9DiagStateENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine18PushDiagStatePointEPNS0_9DiagStateENS_14SourceLocationE")
  //</editor-fold>
  private void PushDiagStatePoint(DiagState /*P*/ State, SourceLocation L) {
    FullSourceLoc Loc/*J*/= new FullSourceLoc(/*NO_COPY*/L, getSourceManager());
    // Make sure that DiagStatePoints is always sorted according to Loc.
    assert (Loc.isValid()) : "Adding invalid loc point";
    assert (!DiagStatePoints.empty() && (DiagStatePoints.back().Loc.isInvalid() || DiagStatePoints.back().Loc.isBeforeInTranslationUnitThan(/*NO_COPY*/Loc))) : "Previous point loc comes after or is the same as new one";
    DiagStatePoints.push_back(new DiagStatePoint(State, /*NO_COPY*/Loc));
  }

  
  /// \brief Finds the DiagStatePoint that contains the diagnostic state of
  /// the given source location.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::GetDiagStatePointForLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 158,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 157,
   FQN="clang::DiagnosticsEngine::GetDiagStatePointForLoc", NM="_ZNK5clang17DiagnosticsEngine23GetDiagStatePointForLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine23GetDiagStatePointForLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*//*private*/ DiagnosticsEngine.DiagStatePoint GetDiagStatePointForLoc(SourceLocation L) /*const*/ {
    assert (!DiagStatePoints.empty());
    return DiagStatePoints.$at(GetDiagStatePointForLocIndex(L));
  }
  
  // Extracted from GetDiagStatePointForLoc
  @Converted(kind = Converted.Kind.MANUAL_ADDED, optimized = Converted.Optimization.COMPLEX)
  /*friend*//*private*/ /*std.vector.iterator<DiagStatePoint>*/int GetDiagStatePointForLocIndex(SourceLocation L) /*const*/ {
    assert (!DiagStatePoints.empty());
    assert (DiagStatePoints.front().Loc.isInvalid()) : "Should have created a DiagStatePoint for command-line";
    if (!(SourceMgr != null)) {
      return DiagStatePoints.size() - 1;
    }
    
    FullSourceLoc Loc/*J*/= new FullSourceLoc(/*NO_COPY*/L, $Deref(SourceMgr));
    if (Loc.isInvalid()) {
      return DiagStatePoints.size() - 1;
    }
    
    int Pos = DiagStatePoints.size();
    FullSourceLoc LastStateChangePos = new FullSourceLoc(DiagStatePoints.back().Loc);
    if (LastStateChangePos.isValid()
       && Loc.isBeforeInTranslationUnitThan(/*NO_COPY*/LastStateChangePos)) {
      // JAVA PERF: pass comparator
      Pos = std.upper_bound(DiagStatePoints.begin(), DiagStatePoints.end(), 
              new DiagStatePoint((DiagState /*P*/ )null, /*NO_COPY*/Loc), DiagStatePointComparator).$index();
    }
    --Pos;
    return Pos;
  }

  
  /// \brief Sticky flag set to \c true when an error is emitted.
  public /*friend*/ boolean ErrorOccurred;
  
  /// \brief Sticky flag set to \c true when an "uncompilable error" occurs.
  /// I.e. an error that was not upgraded from a warning by -Werror.
  public /*friend*/ boolean UncompilableErrorOccurred;
  
  /// \brief Sticky flag set to \c true when a fatal error is emitted.
  /*friend*/ boolean FatalErrorOccurred;
  
  /// \brief Indicates that an unrecoverable error has occurred.
  public /*friend*/ boolean UnrecoverableErrorOccurred;
  
  /// \brief Counts for DiagnosticErrorTrap to check whether an error occurred
  /// during a parsing section, e.g. during parsing a function.
  /*friend*/ /*uint*/int TrapNumErrorsOccurred;
  /*friend*/ /*uint*/int TrapNumUnrecoverableErrorsOccurred;
  
  /// \brief The level of the last diagnostic emitted.
  ///
  /// This is used to emit continuation diagnostics with the same level as the
  /// diagnostic that they follow.
  /*friend*/ DiagnosticIDs.Level LastDiagLevel;
  
  /*friend*/ /*uint*/int NumWarnings; ///< Number of warnings reported
  /*friend*/ /*uint*/int NumErrors; ///< Number of errors reported
  
  /// \brief A function pointer that converts an opaque diagnostic
  /// argument to a strings.
  ///
  /// This takes the modifiers and argument that was present in the diagnostic.
  ///
  /// The PrevArgs array indicates the previous arguments formatted for this
  /// diagnostic.  Implementations of this function can use this information to
  /// avoid redundancy across arguments.
  ///
  /// This is a hack to avoid a layering violation between libbasic and libsema.
  /*typedef void (*ArgToStringFnTy)(ArgumentKind, intptr_t, StringRef, StringRef, ArrayRef<ArgumentValue>, SmallVectorImpl<char> &, void *, ArrayRef<intptr_t>)*/;
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public interface ArgToStringFn {
    void $call(ArgumentKind Kind, Object/*intptr_t*/ Val, 
                    StringRef Modifier, StringRef Argument, 
                    ArrayRef<std.pair<DiagnosticsEngine.ArgumentKind, ?/*,intptr_t*/>> PrevArgs, 
                    SmallString/*&*/ Output, 
                    Object/*void P*/ Cookie, 
                    ArrayRef<Object/*intptr_t*/> QualTypeVals);
  }
  
  private Object/*void P*/ ArgToStringCookie;
  private ArgToStringFn ArgToStringFn;
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private static final ArgToStringFn DummyArgToStringFn = new ArgToStringFn() {
    @Override
    public void $call(ArgumentKind Kind, Object/*intptr_t*/ Val, 
                    StringRef Modifier, StringRef Argument, 
                    ArrayRef<std.pair<DiagnosticsEngine.ArgumentKind, ?/*,intptr_t*/>> PrevArgs, 
                    SmallString/*&*/ Output, 
                    Object/*void P*/ Cookie, 
                    ArrayRef<Object/*intptr_t*/> QualTypeVals) {
      DiagnosticStatics.DummyArgToStringFn(Kind, Val, Modifier, Argument, PrevArgs, Output, 
        Cookie, QualTypeVals);
    }
  };
  
  /// \brief ID of the "delayed" diagnostic, which is a (typically
  /// fatal) diagnostic that had to be delayed because it was found
  /// while emitting another diagnostic.
  private /*uint*/int DelayedDiagID;
  
  /// \brief First string argument for the delayed diagnostic.
  private std.string DelayedDiagArg1;
  
  /// \brief Second string argument for the delayed diagnostic.
  private std.string DelayedDiagArg2;
  
  /// \brief Optional flag value.
  ///
  /// Some flags accept values, for instance: -Wframe-larger-than=<value> and
  /// -Rpass=<value>. The content of this string is emitted after the flag name
  /// and '='.
  /*friend*/ std.string FlagValue;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::DiagnosticsEngine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 58,
   FQN="clang::DiagnosticsEngine::DiagnosticsEngine", NM="_ZN5clang17DiagnosticsEngineC1ERKN4llvm18IntrusiveRefCntPtrINS_13DiagnosticIDsEEEPNS_17DiagnosticOptionsEPNS_18DiagnosticConsumerEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngineC1ERKN4llvm18IntrusiveRefCntPtrINS_13DiagnosticIDsEEEPNS_17DiagnosticOptionsEPNS_18DiagnosticConsumerEb")
  //</editor-fold>
  public DiagnosticsEngine(/*const*/ IntrusiveRefCntPtr<DiagnosticIDs> /*&*/ diags, DiagnosticOptions /*P*/ DiagOpts) {
    this(diags, DiagOpts, 
      (DiagnosticConsumer /*P*/ )null, true);
  }
  public DiagnosticsEngine(/*const*/ IntrusiveRefCntPtr<DiagnosticIDs> /*&*/ diags, DiagnosticOptions /*P*/ DiagOpts, 
      DiagnosticConsumer /*P*/ client/*= null*/) {
    this(diags, DiagOpts, 
      client, true);
  }
  public DiagnosticsEngine(/*const*/ IntrusiveRefCntPtr<DiagnosticIDs> /*&*/ diags, DiagnosticOptions /*P*/ DiagOpts, 
      DiagnosticConsumer /*P*/ client/*= null*/, boolean ShouldOwnClient/*= true*/) {
    /* : RefCountedBase<DiagnosticsEngine>(), Diags(diags), DiagOpts(DiagOpts), Client(null), Owner(), SourceMgr(null), DiagStates(), DiagStatePoints(), DiagStateOnPushStack(), DelayedDiagArg1(), DelayedDiagArg2(), FlagValue(), CurDiagLoc(), DiagArgumentsStr(), DiagRanges(), DiagFixItHints()*/ 
    //START JInit
    super();
    this.Diags = new IntrusiveRefCntPtr<DiagnosticIDs>(diags);
    this.DiagOpts = new IntrusiveRefCntPtr<DiagnosticOptions>(DiagOpts);
    this.Client = null;
    this.Owner = new std.unique_ptr<DiagnosticConsumer>();
    this.SourceMgr = null;
    this.DiagStates = new std.list<DiagState>(new DiagState());
    this.DiagStatePoints = new std.vector<DiagStatePoint>(new DiagStatePoint());
    this.DiagStateOnPushStack = new std.vector<DiagState /*P*/ >((DiagState) null);
    this.DelayedDiagArg1 = new std.string();
    this.DelayedDiagArg2 = new std.string();
    this.FlagValue = new std.string();
    this.CurDiagLoc = new SourceLocation();
    this.DiagArgumentsStr = new$T(new std.string [10], ()->new std.string());
    this.DiagRanges = new SmallVector<CharSourceRange/*,8*/>(8, new CharSourceRange());
    this.DiagFixItHints = new SmallVector<FixItHint>(8, new FixItHint());
    //END JInit
    setClient(client, ShouldOwnClient);
    ArgToStringFn = DummyArgToStringFn;
    ArgToStringCookie = null;
    
    AllExtensionsSilenced = 0;
    IgnoreAllWarnings = false;
    WarningsAsErrors = false;
    EnableAllWarnings = false;
    ErrorsAsFatal = false;
    FatalsAsError = false;
    SuppressSystemWarnings = false;
    SuppressAllDiagnostics = false;
    ElideType = true;
    PrintTemplateTree = false;
    ShowColors = false;
    ShowOverloads = OverloadsShown.Ovl_All;
    ExtBehavior = diag.Severity.Ignored;
    
    ErrorLimit = 0;
    TemplateBacktraceLimit = 0;
    ConstexprBacktraceLimit = 0;
    
    Reset();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::~DiagnosticsEngine">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 87,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 86,
   FQN="clang::DiagnosticsEngine::~DiagnosticsEngine", NM="_ZN5clang17DiagnosticsEngineD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngineD0Ev")
  //</editor-fold>
  public void $destroy() {
    // If we own the diagnostic client, destroy it first so that it can access the
    // engine from its destructor.
    setClient((DiagnosticConsumer /*P*/ )null);
    //START JDestroy
    DiagFixItHints.$destroy();
    DiagRanges.$destroy();
    //DiagArgumentsStr.$destroy();
    FlagValue.$destroy();
    DelayedDiagArg2.$destroy();
    DelayedDiagArg1.$destroy();
    DiagStateOnPushStack.$destroy();
    DiagStatePoints.$destroy();
    DiagStates.$destroy();
    Owner.$destroy();
    DiagOpts.$destroy();
    Diags.$destroy();
    super.$destroy();//~RefCountedBase<DiagnosticsEngine>;
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getDiagnosticIDs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 354,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 353,
   FQN="clang::DiagnosticsEngine::getDiagnosticIDs", NM="_ZNK5clang17DiagnosticsEngine16getDiagnosticIDsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine16getDiagnosticIDsEv")
  //</editor-fold>
  public /*const*/ IntrusiveRefCntPtr<DiagnosticIDs> /*&*/ getDiagnosticIDs() /*const*/ {
    return Diags;
  }

  
  /// \brief Retrieve the diagnostic options.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getDiagnosticOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 359,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 358,
   FQN="clang::DiagnosticsEngine::getDiagnosticOptions", NM="_ZNK5clang17DiagnosticsEngine20getDiagnosticOptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine20getDiagnosticOptionsEv")
  //</editor-fold>
  public DiagnosticOptions /*&*/ getDiagnosticOptions() /*const*/ {
    return DiagOpts.$star();
  }

  
  /*typedef llvm::iterator_range<DiagState::const_iterator> diag_mapping_range*/
//  public final class diag_mapping_range extends iterator_range<DenseMapIteratorUIntType<DiagnosticMapping> >{ };
  
  /// \brief Get the current set of diagnostic mappings.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getDiagnosticMappings">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 364,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 363,
   FQN="clang::DiagnosticsEngine::getDiagnosticMappings", NM="_ZNK5clang17DiagnosticsEngine21getDiagnosticMappingsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine21getDiagnosticMappingsEv")
  //</editor-fold>
  public iterator_range<std.pairUIntType<DiagnosticMapping>> getDiagnosticMappings() /*const*/ {
    /*const*/ DiagState /*&*/ DS = $Deref(GetCurDiagState());
    return new iterator_range<std.pairUIntType<DiagnosticMapping>>(DS.begin(), DS.end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getClient">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 369,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 368,
   FQN="clang::DiagnosticsEngine::getClient", NM="_ZN5clang17DiagnosticsEngine9getClientEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine9getClientEv")
  //</editor-fold>
  public DiagnosticConsumer /*P*/ getClient() {
    return Client;
  }

  ////<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getClient">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 370,
//   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 369,
//   FQN="clang::DiagnosticsEngine::getClient", NM="_ZNK5clang17DiagnosticsEngine9getClientEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine9getClientEv")
//  //</editor-fold>
//  public /*const*/ DiagnosticConsumer /*P*/ getClient() /*const*/ {
//    return Client;
//  }

  
  /// \brief Determine whether this \c DiagnosticsEngine object own its client.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::ownsClient">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 373,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 372,
   FQN="clang::DiagnosticsEngine::ownsClient", NM="_ZNK5clang17DiagnosticsEngine10ownsClientEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine10ownsClientEv")
  //</editor-fold>
  public boolean ownsClient() /*const*/ {
    return $noteq_unique_ptr$C_nullptr_t(Owner, null);
  }

  
  /// \brief Return the current diagnostic client along with ownership of that
  /// client.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::takeClient">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 377,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 376,
   FQN="clang::DiagnosticsEngine::takeClient", NM="_ZN5clang17DiagnosticsEngine10takeClientEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine10takeClientEv")
  //</editor-fold>
  public std.unique_ptr<DiagnosticConsumer> takeClient() {
    return new std.unique_ptr<DiagnosticConsumer>(JD$Move.INSTANCE, std.move(Owner));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::hasSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 379,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 378,
   FQN="clang::DiagnosticsEngine::hasSourceManager", NM="_ZNK5clang17DiagnosticsEngine16hasSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine16hasSourceManagerEv")
  //</editor-fold>
  public boolean hasSourceManager() /*const*/ {
    return SourceMgr != null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 380,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 379,
   FQN="clang::DiagnosticsEngine::getSourceManager", NM="_ZNK5clang17DiagnosticsEngine16getSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine16getSourceManagerEv")
  //</editor-fold>
  public SourceManager /*&*/ getSourceManager() /*const*/ {
    assert ((SourceMgr != null)) : "SourceManager not set!";
    return $Deref(SourceMgr);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 384,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 383,
   FQN="clang::DiagnosticsEngine::setSourceManager", NM="_ZN5clang17DiagnosticsEngine16setSourceManagerEPNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine16setSourceManagerEPNS_13SourceManagerE")
  //</editor-fold>
  public void setSourceManager(SourceManager /*P*/ SrcMgr) {
    SourceMgr = SrcMgr;
  }

  
  //===--------------------------------------------------------------------===//
  //  DiagnosticsEngine characterization methods, used by a client to customize
  //  how diagnostics are emitted.
  //
  
  /// \brief Copies the current DiagMappings and pushes the new copy
  /// onto the top of the stack.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::pushMappings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 99,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 98,
   FQN="clang::DiagnosticsEngine::pushMappings", NM="_ZN5clang17DiagnosticsEngine12pushMappingsENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine12pushMappingsENS_14SourceLocationE")
  //</editor-fold>
  public void pushMappings(SourceLocation Loc) {
    DiagStateOnPushStack.push_back(GetCurDiagState());
  }

  
  /// \brief Pops the current DiagMappings off the top of the stack,
  /// causing the new top of the stack to be the active mappings.
  ///
  /// \returns \c true if the pop happens, \c false if there is only one
  /// DiagMapping on the stack.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::popMappings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 103,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 102,
   FQN="clang::DiagnosticsEngine::popMappings", NM="_ZN5clang17DiagnosticsEngine11popMappingsENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine11popMappingsENS_14SourceLocationE")
  //</editor-fold>
  public boolean popMappings(SourceLocation Loc) {
    if (DiagStateOnPushStack.empty()) {
      return false;
    }
    if (DiagStateOnPushStack.back() != GetCurDiagState()) {
      // State changed at some point between push/pop.
      PushDiagStatePoint(DiagStateOnPushStack.back(), /*NO_COPY*/Loc);
    }
    DiagStateOnPushStack.pop_back();
    return true;
  }

  
  /// \brief Set the diagnostic client associated with this diagnostic object.
  ///
  /// \param ShouldOwnClient true if the diagnostic object should take
  /// ownership of \c client.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setClient">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 93,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 92,
   FQN="clang::DiagnosticsEngine::setClient", NM="_ZN5clang17DiagnosticsEngine9setClientEPNS_18DiagnosticConsumerEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine9setClientEPNS_18DiagnosticConsumerEb")
  //</editor-fold>
  public void setClient(DiagnosticConsumer /*P*/ client) {
    setClient(client, 
           true);
  }
  public void setClient(DiagnosticConsumer /*P*/ client, 
           boolean ShouldOwnClient/*= true*/) {
    Owner.reset(ShouldOwnClient ? client : (DiagnosticConsumer /*P*/ )null);
    Client = client;
  }

  
  /// \brief Specify a limit for the number of errors we should
  /// emit before giving up.
  ///
  /// Zero disables the limit.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setErrorLimit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 412,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 411,
   FQN="clang::DiagnosticsEngine::setErrorLimit", NM="_ZN5clang17DiagnosticsEngine13setErrorLimitEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine13setErrorLimitEj")
  //</editor-fold>
  public void setErrorLimit(/*uint*/int Limit) {
    ErrorLimit = Limit;
  }

  
  /// \brief Specify the maximum number of template instantiation
  /// notes to emit along with a given diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setTemplateBacktraceLimit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 416,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 415,
   FQN="clang::DiagnosticsEngine::setTemplateBacktraceLimit", NM="_ZN5clang17DiagnosticsEngine25setTemplateBacktraceLimitEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine25setTemplateBacktraceLimitEj")
  //</editor-fold>
  public void setTemplateBacktraceLimit(/*uint*/int Limit) {
    TemplateBacktraceLimit = Limit;
  }

  
  /// \brief Retrieve the maximum number of template instantiation
  /// notes to emit along with a given diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getTemplateBacktraceLimit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 422,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 421,
   FQN="clang::DiagnosticsEngine::getTemplateBacktraceLimit", NM="_ZNK5clang17DiagnosticsEngine25getTemplateBacktraceLimitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine25getTemplateBacktraceLimitEv")
  //</editor-fold>
  public /*uint*/int getTemplateBacktraceLimit() /*const*/ {
    return TemplateBacktraceLimit;
  }

  
  /// \brief Specify the maximum number of constexpr evaluation
  /// notes to emit along with a given diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setConstexprBacktraceLimit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 428,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 427,
   FQN="clang::DiagnosticsEngine::setConstexprBacktraceLimit", NM="_ZN5clang17DiagnosticsEngine26setConstexprBacktraceLimitEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine26setConstexprBacktraceLimitEj")
  //</editor-fold>
  public void setConstexprBacktraceLimit(/*uint*/int Limit) {
    ConstexprBacktraceLimit = Limit;
  }

  
  /// \brief Retrieve the maximum number of constexpr evaluation
  /// notes to emit along with a given diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getConstexprBacktraceLimit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 434,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 433,
   FQN="clang::DiagnosticsEngine::getConstexprBacktraceLimit", NM="_ZNK5clang17DiagnosticsEngine26getConstexprBacktraceLimitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine26getConstexprBacktraceLimitEv")
  //</editor-fold>
  public /*uint*/int getConstexprBacktraceLimit() /*const*/ {
    return ConstexprBacktraceLimit;
  }

  
  /// \brief When set to true, any unmapped warnings are ignored.
  ///
  /// If this and WarningsAsErrors are both set, then this one wins.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setIgnoreAllWarnings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 441,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 440,
   FQN="clang::DiagnosticsEngine::setIgnoreAllWarnings", NM="_ZN5clang17DiagnosticsEngine20setIgnoreAllWarningsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine20setIgnoreAllWarningsEb")
  //</editor-fold>
  public void setIgnoreAllWarnings(boolean Val) {
    IgnoreAllWarnings = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getIgnoreAllWarnings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 442,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 441,
   FQN="clang::DiagnosticsEngine::getIgnoreAllWarnings", NM="_ZNK5clang17DiagnosticsEngine20getIgnoreAllWarningsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine20getIgnoreAllWarningsEv")
  //</editor-fold>
  public boolean getIgnoreAllWarnings() /*const*/ {
    return IgnoreAllWarnings;
  }

  
  /// \brief When set to true, any unmapped ignored warnings are no longer
  /// ignored.
  ///
  /// If this and IgnoreAllWarnings are both set, then that one wins.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setEnableAllWarnings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 448,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 447,
   FQN="clang::DiagnosticsEngine::setEnableAllWarnings", NM="_ZN5clang17DiagnosticsEngine20setEnableAllWarningsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine20setEnableAllWarningsEb")
  //</editor-fold>
  public void setEnableAllWarnings(boolean Val) {
    EnableAllWarnings = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getEnableAllWarnings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 449,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 448,
   FQN="clang::DiagnosticsEngine::getEnableAllWarnings", NM="_ZNK5clang17DiagnosticsEngine20getEnableAllWarningsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine20getEnableAllWarningsEv")
  //</editor-fold>
  public boolean getEnableAllWarnings() /*const*/ {
    return EnableAllWarnings;
  }

  
  /// \brief When set to true, any warnings reported are issued as errors.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setWarningsAsErrors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 452,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 451,
   FQN="clang::DiagnosticsEngine::setWarningsAsErrors", NM="_ZN5clang17DiagnosticsEngine19setWarningsAsErrorsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine19setWarningsAsErrorsEb")
  //</editor-fold>
  public void setWarningsAsErrors(boolean Val) {
    WarningsAsErrors = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getWarningsAsErrors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 453,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 452,
   FQN="clang::DiagnosticsEngine::getWarningsAsErrors", NM="_ZNK5clang17DiagnosticsEngine19getWarningsAsErrorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine19getWarningsAsErrorsEv")
  //</editor-fold>
  public boolean getWarningsAsErrors() /*const*/ {
    return WarningsAsErrors;
  }

  
  /// \brief When set to true, any error reported is made a fatal error.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setErrorsAsFatal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 456,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 455,
   FQN="clang::DiagnosticsEngine::setErrorsAsFatal", NM="_ZN5clang17DiagnosticsEngine16setErrorsAsFatalEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine16setErrorsAsFatalEb")
  //</editor-fold>
  public void setErrorsAsFatal(boolean Val) {
    ErrorsAsFatal = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getErrorsAsFatal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 457,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 456,
   FQN="clang::DiagnosticsEngine::getErrorsAsFatal", NM="_ZNK5clang17DiagnosticsEngine16getErrorsAsFatalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine16getErrorsAsFatalEv")
  //</editor-fold>
  public boolean getErrorsAsFatal() /*const*/ {
    return ErrorsAsFatal;
  }

  
  /// \brief When set to true, any fatal error reported is made an error.
  ///
  /// This setting takes precedence over the setErrorsAsFatal setting above.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setFatalsAsError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 462,
   FQN="clang::DiagnosticsEngine::setFatalsAsError", NM="_ZN5clang17DiagnosticsEngine16setFatalsAsErrorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine16setFatalsAsErrorEb")
  //</editor-fold>
  public void setFatalsAsError(boolean Val) {
    FatalsAsError = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getFatalsAsError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 463,
   FQN="clang::DiagnosticsEngine::getFatalsAsError", NM="_ZNK5clang17DiagnosticsEngine16getFatalsAsErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine16getFatalsAsErrorEv")
  //</editor-fold>
  public boolean getFatalsAsError() /*const*/ {
    return FatalsAsError;
  }

  
  /// \brief When set to true mask warnings that come from system headers.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setSuppressSystemWarnings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 466,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 459,
   FQN="clang::DiagnosticsEngine::setSuppressSystemWarnings", NM="_ZN5clang17DiagnosticsEngine25setSuppressSystemWarningsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine25setSuppressSystemWarningsEb")
  //</editor-fold>
  public void setSuppressSystemWarnings(boolean Val) {
    SuppressSystemWarnings = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getSuppressSystemWarnings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 467,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 460,
   FQN="clang::DiagnosticsEngine::getSuppressSystemWarnings", NM="_ZNK5clang17DiagnosticsEngine25getSuppressSystemWarningsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine25getSuppressSystemWarningsEv")
  //</editor-fold>
  public boolean getSuppressSystemWarnings() /*const*/ {
    return SuppressSystemWarnings;
  }

  
  /// \brief Suppress all diagnostics, to silence the front end when we 
  /// know that we don't want any more diagnostics to be passed along to the
  /// client
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setSuppressAllDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 472,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 465,
   FQN="clang::DiagnosticsEngine::setSuppressAllDiagnostics", NM="_ZN5clang17DiagnosticsEngine25setSuppressAllDiagnosticsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine25setSuppressAllDiagnosticsEb")
  //</editor-fold>
  public void setSuppressAllDiagnostics() {
    setSuppressAllDiagnostics(true);
  }
  public void setSuppressAllDiagnostics(boolean Val/*= true*/) {
    SuppressAllDiagnostics = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getSuppressAllDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 475,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 468,
   FQN="clang::DiagnosticsEngine::getSuppressAllDiagnostics", NM="_ZNK5clang17DiagnosticsEngine25getSuppressAllDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine25getSuppressAllDiagnosticsEv")
  //</editor-fold>
  public boolean getSuppressAllDiagnostics() /*const*/ {
    return SuppressAllDiagnostics;
  }

  
  /// \brief Set type eliding, to skip outputting same types occurring in
  /// template types.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setElideType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 479,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 472,
   FQN="clang::DiagnosticsEngine::setElideType", NM="_ZN5clang17DiagnosticsEngine12setElideTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine12setElideTypeEb")
  //</editor-fold>
  public void setElideType() {
    setElideType(true);
  }
  public void setElideType(boolean Val/*= true*/) {
    ElideType = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getElideType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 480,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 473,
   FQN="clang::DiagnosticsEngine::getElideType", NM="_ZN5clang17DiagnosticsEngine12getElideTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine12getElideTypeEv")
  //</editor-fold>
  public boolean getElideType() {
    return ElideType;
  }

  
  /// \brief Set tree printing, to outputting the template difference in a
  /// tree format.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setPrintTemplateTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 484,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 477,
   FQN="clang::DiagnosticsEngine::setPrintTemplateTree", NM="_ZN5clang17DiagnosticsEngine20setPrintTemplateTreeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine20setPrintTemplateTreeEb")
  //</editor-fold>
  public void setPrintTemplateTree() {
    setPrintTemplateTree(false);
  }
  public void setPrintTemplateTree(boolean Val/*= false*/) {
    PrintTemplateTree = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getPrintTemplateTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 485,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 478,
   FQN="clang::DiagnosticsEngine::getPrintTemplateTree", NM="_ZN5clang17DiagnosticsEngine20getPrintTemplateTreeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine20getPrintTemplateTreeEv")
  //</editor-fold>
  public boolean getPrintTemplateTree() {
    return PrintTemplateTree;
  }

  
  /// \brief Set color printing, so the type diffing will inject color markers
  /// into the output.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setShowColors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 489,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 482,
   FQN="clang::DiagnosticsEngine::setShowColors", NM="_ZN5clang17DiagnosticsEngine13setShowColorsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine13setShowColorsEb")
  //</editor-fold>
  public void setShowColors() {
    setShowColors(false);
  }
  public void setShowColors(boolean Val/*= false*/) {
    ShowColors = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getShowColors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 490,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 483,
   FQN="clang::DiagnosticsEngine::getShowColors", NM="_ZN5clang17DiagnosticsEngine13getShowColorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine13getShowColorsEv")
  //</editor-fold>
  public boolean getShowColors() {
    return ShowColors;
  }

  
  /// \brief Specify which overload candidates to show when overload resolution
  /// fails.
  ///
  /// By default, we show all candidates.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setShowOverloads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 496,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 489,
   FQN="clang::DiagnosticsEngine::setShowOverloads", NM="_ZN5clang17DiagnosticsEngine16setShowOverloadsENS_14OverloadsShownE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine16setShowOverloadsENS_14OverloadsShownE")
  //</editor-fold>
  public void setShowOverloads(OverloadsShown Val) {
    ShowOverloads = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getShowOverloads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 499,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 492,
   FQN="clang::DiagnosticsEngine::getShowOverloads", NM="_ZNK5clang17DiagnosticsEngine16getShowOverloadsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine16getShowOverloadsEv")
  //</editor-fold>
  public OverloadsShown getShowOverloads() /*const*/ {
    return ShowOverloads;
  }

  
  /// \brief Pretend that the last diagnostic issued was ignored, so any
  /// subsequent notes will be suppressed.
  ///
  /// This can be used by clients who suppress diagnostics themselves.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setLastDiagnosticIgnored">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 505,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 498,
   FQN="clang::DiagnosticsEngine::setLastDiagnosticIgnored", NM="_ZN5clang17DiagnosticsEngine24setLastDiagnosticIgnoredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine24setLastDiagnosticIgnoredEv")
  //</editor-fold>
  public void setLastDiagnosticIgnored() {
    if (LastDiagLevel == DiagnosticIDs.Level.Fatal) {
      FatalErrorOccurred = true;
    }
    LastDiagLevel = DiagnosticIDs.Level.Ignored;
  }

  
  /// \brief Determine whether the previous diagnostic was ignored. This can
  /// be used by clients that want to determine whether notes attached to a
  /// diagnostic will be suppressed.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::isLastDiagnosticIgnored">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 514,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 507,
   FQN="clang::DiagnosticsEngine::isLastDiagnosticIgnored", NM="_ZNK5clang17DiagnosticsEngine23isLastDiagnosticIgnoredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine23isLastDiagnosticIgnoredEv")
  //</editor-fold>
  public boolean isLastDiagnosticIgnored() /*const*/ {
    return LastDiagLevel == DiagnosticIDs.Level.Ignored;
  }

  
  /// \brief Controls whether otherwise-unmapped extension diagnostics are
  /// mapped onto ignore/warning/error. 
  ///
  /// This corresponds to the GCC -pedantic and -pedantic-errors option.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setExtensionHandlingBehavior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 522,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 515,
   FQN="clang::DiagnosticsEngine::setExtensionHandlingBehavior", NM="_ZN5clang17DiagnosticsEngine28setExtensionHandlingBehaviorENS_4diag8SeverityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine28setExtensionHandlingBehaviorENS_4diag8SeverityE")
  //</editor-fold>
  public void setExtensionHandlingBehavior(diag.Severity H) {
    ExtBehavior = H;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getExtensionHandlingBehavior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 523,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 516,
   FQN="clang::DiagnosticsEngine::getExtensionHandlingBehavior", NM="_ZNK5clang17DiagnosticsEngine28getExtensionHandlingBehaviorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine28getExtensionHandlingBehaviorEv")
  //</editor-fold>
  public diag.Severity getExtensionHandlingBehavior() /*const*/ {
    return ExtBehavior;
  }

  
  /// \brief Counter bumped when an __extension__  block is/ encountered.
  ///
  /// When non-zero, all extension diagnostics are entirely silenced, no
  /// matter how they are mapped.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::IncrementAllExtensionsSilenced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 529,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 522,
   FQN="clang::DiagnosticsEngine::IncrementAllExtensionsSilenced", NM="_ZN5clang17DiagnosticsEngine30IncrementAllExtensionsSilencedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine30IncrementAllExtensionsSilencedEv")
  //</editor-fold>
  public void IncrementAllExtensionsSilenced() {
    ++AllExtensionsSilenced;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::DecrementAllExtensionsSilenced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 530,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 523,
   FQN="clang::DiagnosticsEngine::DecrementAllExtensionsSilenced", NM="_ZN5clang17DiagnosticsEngine30DecrementAllExtensionsSilencedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine30DecrementAllExtensionsSilencedEv")
  //</editor-fold>
  public void DecrementAllExtensionsSilenced() {
    --AllExtensionsSilenced;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::hasAllExtensionsSilenced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 531,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 524,
   FQN="clang::DiagnosticsEngine::hasAllExtensionsSilenced", NM="_ZN5clang17DiagnosticsEngine24hasAllExtensionsSilencedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine24hasAllExtensionsSilencedEv")
  //</editor-fold>
  public boolean hasAllExtensionsSilenced() {
    return $uchar2int(AllExtensionsSilenced) != 0;
  }

  
  /// \brief This allows the client to specify that certain warnings are
  /// ignored.
  ///
  /// Notes can never be mapped, errors can only be mapped to fatal, and
  /// WARNINGs and EXTENSIONs can be mapped arbitrarily.
  ///
  /// \param Loc The source location that this change of diagnostic state should
  /// take affect. It can be null if we are setting the latest state.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setSeverity">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, // JAVA PERF: use int as Pos
   optimized = Converted.Optimization.COMPLEX,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 181,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 180,
   FQN="clang::DiagnosticsEngine::setSeverity", NM="_ZN5clang17DiagnosticsEngine11setSeverityEjNS_4diag8SeverityENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine11setSeverityEjNS_4diag8SeverityENS_14SourceLocationE")
  //</editor-fold>
  public void setSeverity(/*uint*/int Diag, diag.Severity Map, 
             SourceLocation L) {
    assert ($less_uint(Diag, diag.DIAG_UPPER_LIMIT)) : "Can only map builtin diagnostics";
    assert ((Diags.$arrow().isBuiltinWarningOrExtension(Diag) || (Map == diag.Severity.Fatal || Map == diag.Severity.Error))) : "Cannot map errors into warnings!";
    assert (!DiagStatePoints.empty());
    assert ((L.isInvalid() || (SourceMgr != null))) : "No SourceMgr for valid location";
    
    FullSourceLoc Loc = (SourceMgr != null) ? new FullSourceLoc(/*NO_COPY*/L, $Deref(SourceMgr)) : new FullSourceLoc();
    FullSourceLoc LastStateChangePos = new FullSourceLoc(DiagStatePoints.back().Loc);
    // Don't allow a mapping to a warning override an error/fatal mapping.
    if (Map == diag.Severity.Warning) {
      DiagnosticMapping /*&*/ Info = GetCurDiagState().getOrAddMapping(Diag);
      if (Info.getSeverity() == diag.Severity.Error
         || Info.getSeverity() == diag.Severity.Fatal) {
        Map = Info.getSeverity();
      }
    }
    DiagnosticMapping Mapping = makeUserMapping(Map, /*NO_COPY*/L);
    
    // Common case; setting all the diagnostics of a group in one place.
    if (Loc.isInvalid() || $eq_FullSourceLoc$C(Loc, LastStateChangePos)) {
      GetCurDiagState().setMapping(Diag, new DiagnosticMapping(Mapping));
      return;
    }
    
    // Another common case; modifying diagnostic state in a source location
    // after the previous one.
    if ((Loc.isValid() && LastStateChangePos.isInvalid())
       || LastStateChangePos.isBeforeInTranslationUnitThan(/*NO_COPY*/Loc)) {
      // A diagnostic pragma occurred, create a new DiagState initialized with
      // the current one and a new DiagStatePoint to record at which location
      // the new state became active.
      DiagStates.push_back($Deref(GetCurDiagState()));
      PushDiagStatePoint($AddrOf(DiagStates.back()), /*NO_COPY*/Loc);
      GetCurDiagState().setMapping(Diag, new DiagnosticMapping(Mapping));
      return;
    }
    
    // We allow setting the diagnostic state in random source order for
    // completeness but it should not be actually happening in normal practice.
    /*JAVA PERF: StdVector.iterator<DiagStatePoint>*/int $Pos = GetDiagStatePointForLocIndex(Loc);
    assert ($Pos != DiagStatePoints.size());
    DiagStatePoint $at$Pos = DiagStatePoints.$at($Pos);
    
    // Update all diagnostic states that are active after the given location.
    for (/*JAVA PERF: std.vector.iterator<DiagStatePoint>*/int I = $Pos + 1, E = DiagStatePoints.size(); I != E; ++I) {
      DiagStatePoints.$at(I).State.setMapping(Diag, new DiagnosticMapping(Mapping));
    }
    
    // If the location corresponds to an existing point, just update its state.
    if ($eq_FullSourceLoc$C($at$Pos.Loc, Loc)) {
      $at$Pos.State.setMapping(Diag, new DiagnosticMapping(Mapping));
      return;
    }
    
    // Create a new state/point and fit it into the vector of DiagStatePoints
    // so that the vector is always ordered according to location.
    assert ($at$Pos.Loc.isBeforeInTranslationUnitThan(/*NO_COPY*/Loc));
    DiagStates.push_back($Deref($at$Pos.State));
    DiagState /*P*/ NewState = $AddrOf(DiagStates.back());
    NewState.setMapping(Diag, new DiagnosticMapping(Mapping));
    std.vector.iterator<DiagStatePoint> Pos$Add$1 = DiagStatePoints.begin().$add($Pos + 1);
    DiagStatePoints.insert(Pos$Add$1, new DiagStatePoint(NewState, 
            new FullSourceLoc(/*NO_COPY*/Loc, $Deref(SourceMgr))));
  }

  
  /// \brief Change an entire diagnostic group (e.g. "unknown-pragmas") to
  /// have the specified mapping.
  ///
  /// \returns true (and ignores the request) if "Group" was unknown, false
  /// otherwise.
  ///
  /// \param Flavor The flavor of group to affect. -Rfoo does not affect the
  /// state of the -Wfoo group and vice versa.
  ///
  /// \param Loc The source location that this change of diagnostic state should
  /// take affect. It can be null if we are setting the state from command-line.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setSeverityForGroup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 249,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 248,
   FQN="clang::DiagnosticsEngine::setSeverityForGroup", NM="_ZN5clang17DiagnosticsEngine19setSeverityForGroupENS_4diag6FlavorEN4llvm9StringRefENS1_8SeverityENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine19setSeverityForGroupENS_4diag6FlavorEN4llvm9StringRefENS1_8SeverityENS_14SourceLocationE")
  //</editor-fold>
  public boolean setSeverityForGroup(diag.Flavor Flavor, 
                     StringRef Group, diag.Severity Map) {
    return setSeverityForGroup(Flavor, 
                     Group, Map, 
                     new SourceLocation());
  }
  public boolean setSeverityForGroup(diag.Flavor Flavor, 
                     StringRef Group, diag.Severity Map, 
                     SourceLocation Loc/*= SourceLocation()*/) {
    // Get the diagnostics in this group.
    SmallVectorUInt/*diag.kind*/ GroupDiags/*J*/= new SmallVectorUInt/*diag.kind*/(256, 0);
    if (Diags.$arrow().getDiagnosticsInGroup(Flavor, /*NO_COPY*/Group, GroupDiags)) {
      return true;
    }
    
    // Set the mapping.
    for (/*uint*/int Diag : GroupDiags)  {
      setSeverity(Diag, Map, /*NO_COPY*/Loc);
    }
    
    return false;
  }

  
  /// \brief Set the warning-as-error flag for the given diagnostic group.
  ///
  /// This function always only operates on the current diagnostic state.
  ///
  /// \returns True if the given group is unknown, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setDiagnosticGroupWarningAsError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 264,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 263,
   FQN="clang::DiagnosticsEngine::setDiagnosticGroupWarningAsError", NM="_ZN5clang17DiagnosticsEngine32setDiagnosticGroupWarningAsErrorEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine32setDiagnosticGroupWarningAsErrorEN4llvm9StringRefEb")
  //</editor-fold>
  public boolean setDiagnosticGroupWarningAsError(StringRef Group, 
                                  boolean Enabled) {
    // If we are enabling this feature, just set the diagnostic mappings to map to
    // errors.
    if (Enabled) {
      return setSeverityForGroup(diag.Flavor.WarningOrError, /*NO_COPY*/Group, 
          diag.Severity.Error);
    }
    
    // Otherwise, we want to set the diagnostic mapping's "no Werror" bit, and
    // potentially downgrade anything already mapped to be a warning.
    
    // Get the diagnostics in this group.
    SmallVectorUInt/*diag.kind*/ GroupDiags/*J*/= new SmallVectorUInt/*diag.kind*/(8, 0);
    if (Diags.$arrow().getDiagnosticsInGroup(diag.Flavor.WarningOrError, /*NO_COPY*/Group, 
        GroupDiags)) {
      return true;
    }
    
    // Perform the mapping change.
    for (/*uint*/int Diag : GroupDiags) {
      DiagnosticMapping /*&*/ Info = GetCurDiagState().getOrAddMapping(Diag);
      if (Info.getSeverity() == diag.Severity.Error
         || Info.getSeverity() == diag.Severity.Fatal) {
        Info.setSeverity(diag.Severity.Warning);
      }
      
      Info.setNoWarningAsError(true);
    }
    
    return false;
  }

  
  /// \brief Set the error-as-fatal flag for the given diagnostic group.
  ///
  /// This function always only operates on the current diagnostic state.
  ///
  /// \returns True if the given group is unknown, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setDiagnosticGroupErrorAsFatal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 295,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 294,
   FQN="clang::DiagnosticsEngine::setDiagnosticGroupErrorAsFatal", NM="_ZN5clang17DiagnosticsEngine30setDiagnosticGroupErrorAsFatalEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine30setDiagnosticGroupErrorAsFatalEN4llvm9StringRefEb")
  //</editor-fold>
  public boolean setDiagnosticGroupErrorAsFatal(StringRef Group, 
                                boolean Enabled) {
    // If we are enabling this feature, just set the diagnostic mappings to map to
    // fatal errors.
    if (Enabled) {
      return setSeverityForGroup(diag.Flavor.WarningOrError, /*NO_COPY*/Group, 
          diag.Severity.Fatal);
    }
    
    // Otherwise, we want to set the diagnostic mapping's "no Werror" bit, and
    // potentially downgrade anything already mapped to be an error.
    
    // Get the diagnostics in this group.
    SmallVectorUInt/*diag.kind*/ GroupDiags/*J*/= new SmallVectorUInt/*diag.kind*/(8, 0);
    if (Diags.$arrow().getDiagnosticsInGroup(diag.Flavor.WarningOrError, /*NO_COPY*/Group, 
        GroupDiags)) {
      return true;
    }
    
    // Perform the mapping change.
    for (/*uint*/int Diag : GroupDiags) {
      DiagnosticMapping /*&*/ Info = GetCurDiagState().getOrAddMapping(Diag);
      if (Info.getSeverity() == diag.Severity.Fatal) {
        Info.setSeverity(diag.Severity.Error);
      }
      
      Info.setNoErrorAsFatal(true);
    }
    
    return false;
  }

  
  /// \brief Add the specified mapping to all diagnostics of the specified
  /// flavor.
  ///
  /// Mainly to be used by -Wno-everything to disable all warnings but allow
  /// subsequent -W options to enable specific warnings.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setSeverityForAll">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 325,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 324,
   FQN="clang::DiagnosticsEngine::setSeverityForAll", NM="_ZN5clang17DiagnosticsEngine17setSeverityForAllENS_4diag6FlavorENS1_8SeverityENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine17setSeverityForAllENS_4diag6FlavorENS1_8SeverityENS_14SourceLocationE")
  //</editor-fold>
  public void setSeverityForAll(diag.Flavor Flavor, 
                   diag.Severity Map) {
    setSeverityForAll(Flavor, 
                   Map, 
                   new SourceLocation());
  }
  public void setSeverityForAll(diag.Flavor Flavor, 
                   diag.Severity Map, 
                   SourceLocation Loc/*= SourceLocation()*/) {
    // Get all the diagnostics.
    SmallVectorUInt/*diag.kind*/ AllDiags/*J*/= new SmallVectorUInt/*diag.kind*/(64, 0);
    Diags.$arrow().getAllDiagnostics(Flavor, AllDiags);
    
    // Set the mapping.
    for (/*uint*/int Diag : AllDiags)  {
      if (Diags.$arrow().isBuiltinWarningOrExtension(Diag)) {
        setSeverity(Diag, Map, /*NO_COPY*/Loc);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::hasErrorOccurred">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 580,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 573,
   FQN="clang::DiagnosticsEngine::hasErrorOccurred", NM="_ZNK5clang17DiagnosticsEngine16hasErrorOccurredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine16hasErrorOccurredEv")
  //</editor-fold>
  public boolean hasErrorOccurred() /*const*/ {
    return ErrorOccurred;
  }

  
  /// \brief Errors that actually prevent compilation, not those that are
  /// upgraded from a warning by -Werror.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::hasUncompilableErrorOccurred">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 584,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 577,
   FQN="clang::DiagnosticsEngine::hasUncompilableErrorOccurred", NM="_ZNK5clang17DiagnosticsEngine28hasUncompilableErrorOccurredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine28hasUncompilableErrorOccurredEv")
  //</editor-fold>
  public boolean hasUncompilableErrorOccurred() /*const*/ {
    return UncompilableErrorOccurred;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::hasFatalErrorOccurred">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 587,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 580,
   FQN="clang::DiagnosticsEngine::hasFatalErrorOccurred", NM="_ZNK5clang17DiagnosticsEngine21hasFatalErrorOccurredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine21hasFatalErrorOccurredEv")
  //</editor-fold>
  public boolean hasFatalErrorOccurred() /*const*/ {
    return FatalErrorOccurred;
  }

  
  /// \brief Determine whether any kind of unrecoverable error has occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::hasUnrecoverableErrorOccurred">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 590,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 583,
   FQN="clang::DiagnosticsEngine::hasUnrecoverableErrorOccurred", NM="_ZNK5clang17DiagnosticsEngine29hasUnrecoverableErrorOccurredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine29hasUnrecoverableErrorOccurredEv")
  //</editor-fold>
  public boolean hasUnrecoverableErrorOccurred() /*const*/ {
    return FatalErrorOccurred || UnrecoverableErrorOccurred;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getNumWarnings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 594,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 587,
   FQN="clang::DiagnosticsEngine::getNumWarnings", NM="_ZNK5clang17DiagnosticsEngine14getNumWarningsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine14getNumWarningsEv")
  //</editor-fold>
  public /*uint*/int getNumWarnings() /*const*/ {
    return NumWarnings;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::setNumWarnings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 596,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 589,
   FQN="clang::DiagnosticsEngine::setNumWarnings", NM="_ZN5clang17DiagnosticsEngine14setNumWarningsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine14setNumWarningsEj")
  //</editor-fold>
  public void setNumWarnings(/*uint*/int NumWarnings) {
    this.NumWarnings = NumWarnings;
  }

  
  /// \brief Return an ID for a diagnostic with the specified format string and
  /// level.
  ///
  /// If this is the first request for this diagnostic, it is registered and
  /// created, otherwise the existing ID is returned.
  ///
  /// \param FormatString A fixed diagnostic format string that will be hashed
  /// and mapped to a unique DiagID.
  /*template <unsigned int N> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getCustomDiagID">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 609,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 601,
   FQN="clang::DiagnosticsEngine::getCustomDiagID", NM="Tpl__ZN5clang17DiagnosticsEngine15getCustomDiagIDENS0_5LevelERAT__Kc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=Tpl__ZN5clang17DiagnosticsEngine15getCustomDiagIDENS0_5LevelERAT__Kc")
  //</editor-fold>
  public /*<uint N>*/ /*uint*/int getCustomDiagID(Level L, String FormatString) {
    return Diags.$arrow().getCustomDiagID(DiagnosticIDs.Level.valueOf(L.getValue()), 
        new StringRef(FormatString));
  }

  
  /// \brief Converts a diagnostic argument (as an intptr_t) into the string
  /// that represents it.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::ConvertArgToString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 616,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 609,
   FQN="clang::DiagnosticsEngine::ConvertArgToString", NM="_ZNK5clang17DiagnosticsEngine18ConvertArgToStringENS0_12ArgumentKindEiN4llvm9StringRefES3_NS2_8ArrayRefISt4pairIS1_iEEERNS2_15SmallVectorImplIcEENS4_IiEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine18ConvertArgToStringENS0_12ArgumentKindEiN4llvm9StringRefES3_NS2_8ArrayRefISt4pairIS1_iEEERNS2_15SmallVectorImplIcEENS4_IiEE")
  //</editor-fold>
  public void ConvertArgToString(ArgumentKind Kind, Object/*intptr_t*/ Val, 
                    StringRef Modifier, StringRef Argument, 
                    ArrayRef<std.pair<DiagnosticsEngine.ArgumentKind, ?/*,intptr_t*/> > PrevArgs, 
                    SmallString/*&*/ Output, 
                    ArrayRef<Object/*intptr_t*/> QualTypeVals) /*const*/ {
    ArgToStringFn.$call(Kind, Val, /*NO_COPY*/Modifier, /*NO_COPY*/Argument, /*NO_COPY*/PrevArgs, Output, 
        ArgToStringCookie, /*NO_COPY*/QualTypeVals);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::SetArgToStringFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 625,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 618,
   FQN="clang::DiagnosticsEngine::SetArgToStringFn", NM="_ZN5clang17DiagnosticsEngine16SetArgToStringFnEPFvNS0_12ArgumentKindEiN4llvm9StringRefES3_NS2_8ArrayRefISt4pairIS1_iEEERNS2_15SmallVectorImplIcEEPvNS4_IiEEESB_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine16SetArgToStringFnEPFvNS0_12ArgumentKindEiN4llvm9StringRefES3_NS2_8ArrayRefISt4pairIS1_iEEERNS2_15SmallVectorImplIcEEPvNS4_IiEEESB_")
  //</editor-fold>
  public void SetArgToStringFn(ArgToStringFn Fn, Object/*void P*/ Cookie) {
    ArgToStringFn = $tryClone(Fn);
    ArgToStringCookie = $tryClone(Cookie);
  }

  
  /// \brief Note that the prior diagnostic was emitted by some other
  /// \c DiagnosticsEngine, and we may be attaching a note to that diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::notePriorDiagnosticFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 632,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 625,
   FQN="clang::DiagnosticsEngine::notePriorDiagnosticFrom", NM="_ZN5clang17DiagnosticsEngine23notePriorDiagnosticFromERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine23notePriorDiagnosticFromERKS0_")
  //</editor-fold>
  public void notePriorDiagnosticFrom(/*const*/ DiagnosticsEngine /*&*/ Other) {
    LastDiagLevel = Other.LastDiagLevel;
  }

  
  /// \brief Reset the state of the diagnostic object to its initial 
  /// configuration.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::Reset">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*clear stack used by debug*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 115,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 114,
   FQN="clang::DiagnosticsEngine::Reset", NM="_ZN5clang17DiagnosticsEngine5ResetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine5ResetEv")
  //</editor-fold>
  public void Reset() {
    ErrorOccurred = false;
    UncompilableErrorOccurred = false;
    FatalErrorOccurred = false;
    UnrecoverableErrorOccurred = false;
    
    NumWarnings = 0;
    NumErrors = 0;
    TrapNumErrorsOccurred = 0;
    TrapNumUnrecoverableErrorsOccurred = 0;
    
    CurDiagID = ~0/*U*/;
    assert clearDiagnosticsReportStack();
    
    LastDiagLevel = DiagnosticIDs.Level.Ignored;
    DelayedDiagID = 0;
    
    // Clear state related to #pragma diagnostic.
    DiagStates.clear();
    DiagStatePoints.clear();
    DiagStateOnPushStack.clear();
    
    // Create a DiagState and DiagStatePoint representing diagnostic changes
    // through command-line.
    DiagStates.emplace_back();
    DiagStatePoints.push_back(new DiagStatePoint($AddrOf(DiagStates.back()), new FullSourceLoc()));
  }

  
  //===--------------------------------------------------------------------===//
  // DiagnosticsEngine classification and reporting interfaces.
  //
  
  /// \brief Determine whether the diagnostic is known to be ignored.
  ///
  /// This can be used to opportunistically avoid expensive checks when it's
  /// known for certain that the diagnostic has been suppressed at the
  /// specified location \p Loc.
  ///
  /// \param Loc The source location we are interested in finding out the
  /// diagnostic state. Can be null in order to query the latest state.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::isIgnored">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 652,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 645,
   FQN="clang::DiagnosticsEngine::isIgnored", NM="_ZNK5clang17DiagnosticsEngine9isIgnoredEjNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine9isIgnoredEjNS_14SourceLocationE")
  //</editor-fold>
  public boolean isIgnored(/*uint*/int DiagID, SourceLocation Loc) /*const*/ {
    return Diags.$arrow().getDiagnosticSeverity(DiagID, /*NO_COPY*/Loc, /*Deref*/this)
       == diag.Severity.Ignored;
  }
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::isIgnored">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 652,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 645,
   FQN="clang::DiagnosticsEngine::isIgnored", NM="_ZNK5clang17DiagnosticsEngine9isIgnoredEjNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine9isIgnoredEjNS_14SourceLocationE")
  //</editor-fold>
  public boolean isIgnored(/*uint*/int DiagID, /*SourceLocation*/int Loc) /*const*/ {
    return isIgnored(DiagID, SourceLocation.getFromRawEncoding(Loc));
  }

  
  /// \brief Based on the way the client configured the DiagnosticsEngine
  /// object, classify the specified diagnostic ID into a Level, consumable by
  /// the DiagnosticConsumer.
  ///
  /// To preserve invariant assumptions, this function should not be used to
  /// influence parse or semantic analysis actions. Instead consider using
  /// \c isIgnored().
  ///
  /// \param Loc The source location we are interested in finding out the
  /// diagnostic state. Can be null in order to query the latest state.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getDiagnosticLevel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 667,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 660,
   FQN="clang::DiagnosticsEngine::getDiagnosticLevel", NM="_ZNK5clang17DiagnosticsEngine18getDiagnosticLevelEjNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine18getDiagnosticLevelEjNS_14SourceLocationE")
  //</editor-fold>
  public Level getDiagnosticLevel(/*uint*/int DiagID, SourceLocation Loc) /*const*/ {
    return Level.valueOf(Diags.$arrow().getDiagnosticLevel(DiagID, /*NO_COPY*/Loc, /*Deref*/this).getValue());
  }
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getDiagnosticLevel">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 667,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 660,
   FQN="clang::DiagnosticsEngine::getDiagnosticLevel", NM="_ZNK5clang17DiagnosticsEngine18getDiagnosticLevelEjNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine18getDiagnosticLevelEjNS_14SourceLocationE")
  //</editor-fold>
  public Level getDiagnosticLevel(/*uint*/int DiagID, /*SourceLocation*/int Loc) /*const*/ {
    return getDiagnosticLevel(DiagID, SourceLocation.getFromRawEncoding(Loc));
  }

  
  /// \brief Issue the message to the client.
  ///
  /// This actually returns an instance of DiagnosticBuilder which emits the
  /// diagnostics (through @c ProcessDiag) when it is destroyed.
  ///
  /// \param DiagID A member of the @c diag::kind enum.
  /// \param Loc Represents the source location associated with the diagnostic,
  /// which can be an invalid location if no position information is available.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::Report">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*init stack used by debug*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1124,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1117,
   FQN="clang::DiagnosticsEngine::Report", NM="_ZN5clang17DiagnosticsEngine6ReportENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine6ReportENS_14SourceLocationEj")
  //</editor-fold>
  public /*inline*/ DiagnosticBuilder Report(SourceLocation Loc, 
        /*uint*/int DiagID) {
    assert assertSingleDiagnostics(DiagID) : "Multiple diagnostics in flight at once!" + diagJava.$name(CurDiagID) + " can not replace by " + diagJava.$name(DiagID);
    CurDiagLoc.$assign(Loc);
    CurDiagID = DiagID;    
    // in debug mode initialize stack
    assert initDiagnosticsReportStack();
    FlagValue.clear();
    return new DiagnosticBuilder(this);
  }
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::Report">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1124,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1117,
   FQN="clang::DiagnosticsEngine::Report", NM="_ZN5clang17DiagnosticsEngine6ReportENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine6ReportENS_14SourceLocationEj")
  //</editor-fold>
  public /*inline*/ DiagnosticBuilder Report(/*SourceLocation*/int Loc, 
        /*uint*/int DiagID) {
    return Report(SourceLocation.getFromRawEncoding(Loc), DiagID);
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::Report">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1133,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1126,
   FQN="clang::DiagnosticsEngine::Report", NM="_ZN5clang17DiagnosticsEngine6ReportEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine6ReportEj")
  //</editor-fold>
  public /*inline*/ DiagnosticBuilder Report(/*uint*/int DiagID) {
    return Report(new SourceLocation(), DiagID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::Report">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*stack used by debug*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 338,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 337,
   FQN="clang::DiagnosticsEngine::Report", NM="_ZN5clang17DiagnosticsEngine6ReportERKNS_16StoredDiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine6ReportERKNS_16StoredDiagnosticE")
  //</editor-fold>
  public void Report(/*const*/ StoredDiagnostic /*&*/ storedDiag) {
    assert assertSingleDiagnostics(storedDiag.getID()) : "Multiple diagnostics in flight at once!" + diagJava.$name(CurDiagID) + " can not replace by " + diagJava.$name(storedDiag.getID());
    
    CurDiagLoc.$assign(storedDiag.getLocation());
    CurDiagID = storedDiag.getID();
    assert initDiagnosticsReportStack();
    NumDiagArgs = 0;
    
    DiagRanges.clear();
    DiagRanges.append_T(storedDiag.range_begin(), storedDiag.range_end());
    
    DiagFixItHints.clear();
    DiagFixItHints.append_T(storedDiag.fixit_begin(), storedDiag.fixit_end());
    assert ((Client != null)) : "DiagnosticConsumer not set!";
    Level DiagLevel = storedDiag.getLevel();
    Diagnostic Info/*J*/= new Diagnostic(this, storedDiag.getMessage());
    Client.HandleDiagnostic(DiagLevel, Info);
    if (Client.IncludeInDiagnosticCounts()) {
      if (DiagLevel == DiagnosticsEngine.Level.Warning) {
        ++NumWarnings;
      }
    }
    
    CurDiagID = ~0/*U*/;
    assert clearDiagnosticsReportStack();
  }

  
  /// \brief Determine whethere there is already a diagnostic in flight.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::isDiagnosticInFlight">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 685,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 678,
   FQN="clang::DiagnosticsEngine::isDiagnosticInFlight", NM="_ZNK5clang17DiagnosticsEngine20isDiagnosticInFlightEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine20isDiagnosticInFlightEv")
  //</editor-fold>
  public boolean isDiagnosticInFlight() /*const*/ {
    return CurDiagID != ~0/*U*/;
  }

  
  /// \brief Set the "delayed" diagnostic that will be emitted once
  /// the current diagnostic completes.
  ///
  ///  If a diagnostic is already in-flight but the front end must
  ///  report a problem (e.g., with an inconsistent file system
  ///  state), this routine sets a "delayed" diagnostic that will be
  ///  emitted after the current diagnostic completes. This should
  ///  only be used for fatal errors detected at inconvenient
  ///  times. If emitting a delayed diagnostic causes a second delayed
  ///  diagnostic to be introduced, that second delayed diagnostic
  ///  will be ignored.
  ///
  /// \param DiagID The ID of the diagnostic being delayed.
  ///
  /// \param Arg1 A string argument that will be provided to the
  /// diagnostic. A copy of this string will be stored in the
  /// DiagnosticsEngine object itself.
  ///
  /// \param Arg2 A string argument that will be provided to the
  /// diagnostic. A copy of this string will be stored in the
  /// DiagnosticsEngine object itself.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::SetDelayedDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 141,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 140,
   FQN="clang::DiagnosticsEngine::SetDelayedDiagnostic", NM="_ZN5clang17DiagnosticsEngine20SetDelayedDiagnosticEjN4llvm9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine20SetDelayedDiagnosticEjN4llvm9StringRefES2_")
  //</editor-fold>
  public void SetDelayedDiagnostic(/*uint*/int DiagID) {
    SetDelayedDiagnostic(DiagID, StringRef.R$EMPTY, 
                      StringRef.R$EMPTY);
  }
  public void SetDelayedDiagnostic(/*uint*/int DiagID, StringRef Arg1/*= ""*/) {
    SetDelayedDiagnostic(DiagID, Arg1, 
                      StringRef.R$EMPTY);
  }
  public void SetDelayedDiagnostic(/*uint*/int DiagID, StringRef Arg1/*= ""*/, 
                      StringRef Arg2/*= ""*/) {
    if ((DelayedDiagID != 0)) {
      return;
    }
    
    DelayedDiagID = DiagID;
    DelayedDiagArg1.$assignMove(Arg1.str());
    DelayedDiagArg2.$assignMove(Arg2.str());
  }

  
  /// \brief Clear out the current diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::Clear">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*clear stack used by debug*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 712,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 705,
   FQN="clang::DiagnosticsEngine::Clear", NM="_ZN5clang17DiagnosticsEngine5ClearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine5ClearEv")
  //</editor-fold>
  public void Clear() {
    CurDiagID = ~0/*U*/;
    assert clearDiagnosticsReportStack();
  }

  
  /// \brief Return the value associated with this diagnostic flag.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getFlagValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 715,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 708,
   FQN="clang::DiagnosticsEngine::getFlagValue", NM="_ZNK5clang17DiagnosticsEngine12getFlagValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine12getFlagValueEv")
  //</editor-fold>
  public StringRef getFlagValue() /*const*/ {
    return new StringRef(FlagValue);
  }

/*private:*/
  /// \brief Report the delayed diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::ReportDelayed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 151,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 150,
   FQN="clang::DiagnosticsEngine::ReportDelayed", NM="_ZN5clang17DiagnosticsEngine13ReportDelayedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine13ReportDelayedEv")
  //</editor-fold>
  private void ReportDelayed() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Report(DelayedDiagID)), new StringRef(DelayedDiagArg1)), new StringRef(DelayedDiagArg2)));
      DelayedDiagID = 0;
      DelayedDiagArg1.clear();
      DelayedDiagArg2.clear();
    } finally {
      $c$.$destroy();
    }
  }

  
  // This is private state used by DiagnosticBuilder.  We put it here instead of
  // in DiagnosticBuilder in order to keep DiagnosticBuilder a small lightweight
  // object.  This implementation choice means that we can only have one
  // diagnostic "in flight" at a time, but this seems to be a reasonable
  // tradeoff to keep these objects small.  Assertions verify that only one
  // diagnostic is in flight at a time.
  /*friend  class DiagnosticIDs*/
  /*friend  class DiagnosticBuilder*/
  /*friend  class Diagnostic*/
  /*friend  class PartialDiagnostic*/
  /*friend  class DiagnosticErrorTrap*/
  
  /// \brief The location of the current diagnostic that is in flight.
  /*friend*/ SourceLocation CurDiagLoc;
  
  /// \brief The ID of the current diagnostic that is in flight.
  ///
  /// This is set to ~0U when there is no diagnostic in flight.
  /*friend*/ /*uint*/int CurDiagID;  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 741,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 734,
   FQN="clang::DiagnosticsEngine::(anonymous)", NM="_ZN5clang17DiagnosticsEngineE_Unnamed_enum2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngineE_Unnamed_enum2")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    /// \brief The maximum number of arguments we can hold.
    ///
    /// We currently only support up to 10 arguments (%0-%9).  A single
    /// diagnostic with more than that almost certainly has to be simplified
    /// anyway.
    public static final int MaxArguments = 10;
  /*}*/;
  
  /// \brief The number of entries in Arguments.
  /*friend*/ /*schar*/byte NumDiagArgs;
  
  /// \brief Specifies whether an argument is in DiagArgumentsStr or
  /// in DiagArguments.
  ///
  /// This is an array of ArgumentKind::ArgumentKind enum values, one for each
  /// argument.
  /*friend*/ /*uchar*/DiagnosticsEngine.ArgumentKind DiagArgumentsKind[/*10*/] = new /*uchar*/DiagnosticsEngine.ArgumentKind [10];
  
  /// \brief Holds the values of each string argument for the current
  /// diagnostic.
  ///
  /// This is only used when the corresponding ArgumentKind is ak_std_string.
  /*friend*/ std.string DiagArgumentsStr[/*10*/] = new std.string [10];
  
  /// \brief The values for the various substitution positions.
  ///
  /// This is used when the argument is not an std::string.  The specific
  /// value is mangled into an intptr_t and the interpretation depends on
  /// exactly what sort of argument kind it is.
  /*friend*/ Object/*intptr_t*/ DiagArgumentsVal[/*10*/] = new Object/*intptr_t*/ [10];
  
  /// \brief The list of ranges added to this diagnostic.
  /*friend*/ SmallVector<CharSourceRange/*,8*/> DiagRanges;
  
  /// \brief If valid, provides a hint with some code to insert, remove,
  /// or modify at a particular position.
  /*friend*/ SmallVector<FixItHint> DiagFixItHints;
  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::makeUserMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 780,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 773,
   FQN="clang::DiagnosticsEngine::makeUserMapping", NM="_ZN5clang17DiagnosticsEngine15makeUserMappingENS_4diag8SeverityENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine15makeUserMappingENS_4diag8SeverityENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public DiagnosticMapping makeUserMapping(diag.Severity Map, SourceLocation L) {
    boolean isPragma = L.isValid();
    DiagnosticMapping Mapping = DiagnosticMapping.Make(Map, /*IsUser=*/ true, isPragma);
    
    // If this is a pragma mapping, then set the diagnostic mapping flags so
    // that we override command line options.
    if (isPragma) {
      Mapping.setNoWarningAsError(true);
      Mapping.setNoErrorAsFatal(true);
    }
    
    return Mapping;
  }

  
  /// \brief Used to report a diagnostic that is finally fully formed.
  ///
  /// \returns true if the diagnostic was emitted, false if it was suppressed.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::ProcessDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 798,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 791,
   FQN="clang::DiagnosticsEngine::ProcessDiag", NM="_ZN5clang17DiagnosticsEngine11ProcessDiagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine11ProcessDiagEv")
  //</editor-fold>
  private boolean ProcessDiag() {
    return Diags.$arrow().ProcessDiag(/*Deref*/this);
  }


  /// @name Diagnostic Emission
  /// @{
/*protected:*/
  // Sema requires access to the following functions because the current design
  // of SFINAE requires it to use its own SemaDiagnosticBuilder, which needs to
  // access us directly to ensure we minimize the emitted code for the common
  // Sema::Diag() patterns.
  /*friend  class Sema*/
  
  /// \brief Emit the current diagnostic and clear the diagnostic state.
  ///
  /// \param Force Emit the diagnostic regardless of suppression settings.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::EmitCurrentDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 363,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", old_line = 362,
   FQN="clang::DiagnosticsEngine::EmitCurrentDiagnostic", NM="_ZN5clang17DiagnosticsEngine21EmitCurrentDiagnosticEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticsEngine21EmitCurrentDiagnosticEb")
  //</editor-fold>
  /*friend*/public boolean EmitCurrentDiagnostic() {
    return EmitCurrentDiagnostic(false);
  }
  protected boolean EmitCurrentDiagnostic(boolean Force/*= false*/) {
    assert ((getClient() != null)) : "DiagnosticClient not set!";
    
    boolean Emitted;
    if (Force) {
      Diagnostic Info/*J*/= new Diagnostic(this);
      
      // Figure out the diagnostic level of this message.
      DiagnosticIDs.Level DiagLevel = Diags.$arrow().getDiagnosticLevel(Info.getID(), /*NO_COPY*/Info.getLocation(), /*Deref*/this);
      
      Emitted = (DiagLevel != DiagnosticIDs.Level.Ignored);
      if (Emitted) {
        // Emit the diagnostic regardless of suppression level.
        Diags.$arrow().EmitDiag(/*Deref*/this, DiagLevel);
      }
    } else {
      // Process the diagnostic, sending the accumulated information to the
      // DiagnosticConsumer.
      Emitted = ProcessDiag();
    }
    
    // Clear out the current diagnostic object.
    /*uint*/int DiagID = CurDiagID;
    Clear();
    
    // If there was a delayed diagnostic, emit it now.
    if (!Force && (DelayedDiagID != 0) && DelayedDiagID != DiagID) {
      ReportDelayed();
    }
    
    return Emitted;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getCurrentDiagID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 816,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 809,
   FQN="clang::DiagnosticsEngine::getCurrentDiagID", NM="_ZNK5clang17DiagnosticsEngine16getCurrentDiagIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine16getCurrentDiagIDEv")
  //</editor-fold>
  /*friend*/public /*uint*/int getCurrentDiagID() /*const*/ {
    return CurDiagID;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticsEngine::getCurrentDiagLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 818,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 811,
   FQN="clang::DiagnosticsEngine::getCurrentDiagLoc", NM="_ZNK5clang17DiagnosticsEngine17getCurrentDiagLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticsEngine17getCurrentDiagLocEv")
  //</editor-fold>
  /*friend*/public SourceLocation getCurrentDiagLoc() /*const*/ {
    return new SourceLocation(CurDiagLoc);
  }

  
  /// @}
  /*friend  class ASTReader*/
  /*friend  class ASTWriter*/
  
  // JAVA: to keep stack in debug mode for finding errors 
  // like: "Multiple diagnostics in flight at once"
  private Exception Debug$CurDiagReportStack; 
  
  private boolean assertSingleDiagnostics(int DiagID) {
    if (CurDiagID != ~0/*U*/) {    
      String text = diagJava.$name(CurDiagID) + " can not replace by " + diagJava.$name(DiagID);
      assert this.Debug$CurDiagReportStack != null : "stack in debug mode must be initialized! " + text;
      NativeTrace.printDebuggingStackFrames(this.Debug$CurDiagReportStack);
      return false;
    }
    return true;
  }
  
  private boolean initDiagnosticsReportStack() {
    if (Debug$CurDiagReportStack != null) {
      NativeTrace.printDebuggingStackFrames(Debug$CurDiagReportStack);
      return false;
    }
    Debug$CurDiagReportStack = new Exception("First Report stack for " + diagJava.$name(CurDiagID));
    return true;
  }
  
  /*friend*/ boolean clearDiagnosticsReportStack() {
    Debug$CurDiagReportStack = null;
    return true;
  }
  
  public String toString() {
    return "" + "CurDiagID=" + diagJava.$name(CurDiagID) + "[" + CurDiagID + "]"// NOI18N
              + ", CurDiagLoc=" + CurDiagLoc // NOI18N
              + ", NumDiagArgs=" + NumDiagArgs // NOI18N
              + ", DiagArgumentsKind=" + DiagArgumentsKind // NOI18N
              + ", DiagArgumentsStr=" + DiagArgumentsStr // NOI18N
              + ", DiagArgumentsVal=" + DiagArgumentsVal // NOI18N
              + ", DiagRanges=" + DiagRanges // NOI18N
              + ", DiagFixItHints=" + DiagFixItHints // NOI18N
              + ",\n AllExtensionsSilenced=" + AllExtensionsSilenced // NOI18N
              + ", IgnoreAllWarnings=" + IgnoreAllWarnings // NOI18N
              + ", WarningsAsErrors=" + WarningsAsErrors // NOI18N
              + ", EnableAllWarnings=" + EnableAllWarnings // NOI18N
              + ", ErrorsAsFatal=" + ErrorsAsFatal // NOI18N
              + ", FatalsAsError=" + FatalsAsError // NOI18N
              + ", SuppressSystemWarnings=" + SuppressSystemWarnings // NOI18N
              + ", SuppressAllDiagnostics=" + SuppressAllDiagnostics // NOI18N
              + ", ElideType=" + ElideType // NOI18N
              + ", PrintTemplateTree=" + PrintTemplateTree // NOI18N
              + ", ShowColors=" + ShowColors // NOI18N
              + ", ShowOverloads=" + ShowOverloads // NOI18N
              + ", ErrorLimit=" + ErrorLimit // NOI18N
              + ", TemplateBacktraceLimit=" + TemplateBacktraceLimit // NOI18N
              + ", ConstexprBacktraceLimit=" + ConstexprBacktraceLimit // NOI18N
              + ", ExtBehavior=" + ExtBehavior // NOI18N
              /* STACKOVERFLOW: NEVER PRINT DIAGS + ", Diags=" + Diags // NOI18N*/
              + ", DiagOpts=" + DiagOpts // NOI18N
              + ", Client=" + Client // NOI18N
              + ", Owner=" + Owner // NOI18N
              /* STACKOVERFLOW: NEVER PRINT SourceManager + ", SourceMgr=" + SourceMgr // NOI18N*/
              + ", DiagStates=" + DiagStates // NOI18N
              + ", DiagStatePoints=" + DiagStatePoints // NOI18N
              + ", DiagStateOnPushStack=" + DiagStateOnPushStack // NOI18N
              + ", ErrorOccurred=" + ErrorOccurred // NOI18N
              + ", UncompilableErrorOccurred=" + UncompilableErrorOccurred // NOI18N
              + ", FatalErrorOccurred=" + FatalErrorOccurred // NOI18N
              + ", UnrecoverableErrorOccurred=" + UnrecoverableErrorOccurred // NOI18N
              + ", TrapNumErrorsOccurred=" + TrapNumErrorsOccurred // NOI18N
              + ", TrapNumUnrecoverableErrorsOccurred=" + TrapNumUnrecoverableErrorsOccurred // NOI18N
              + ", LastDiagLevel=" + LastDiagLevel // NOI18N
              + ", NumWarnings=" + NumWarnings // NOI18N
              + ", NumErrors=" + NumErrors // NOI18N
              + ", ArgToStringCookie=" + ArgToStringCookie // NOI18N
              + ", ArgToStringFn=" + ArgToStringFn // NOI18N
              + ", DelayedDiagID=" + DelayedDiagID // NOI18N
              + ", DelayedDiagArg1=" + DelayedDiagArg1 // NOI18N
              + ", DelayedDiagArg2=" + DelayedDiagArg2 // NOI18N
              + ", FlagValue=" + FlagValue // NOI18N
              + super.toString(); // NOI18N
  }
}
