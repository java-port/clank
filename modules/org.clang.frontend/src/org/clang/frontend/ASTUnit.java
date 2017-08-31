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

package org.clang.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.frontend.FrontendClangGlobals.*;
import static org.clang.frontend.impl.FrontendClangStatics.*;
import static org.clang.frontend.impl.ASTUnitStatics.*;
import static org.clang.frontend.ASTUnit.PreambleFileHash.*;
import org.clang.basic.*;
import org.clang.basic.llvm.*;
import org.clang.basic.target.*;
import org.clang.basic.vfs.*;
import org.clang.ast.llvm.DenseMapInfoCanQual$Type;
import org.clang.clangc.*;
import org.clang.lex.*;
import org.clang.sema.*;
import org.clang.serialization.*;
import static org.clang.sema.SemaClangGlobals.*;
import org.clang.frontend.*;
import org.clang.frontend.impl.*;
import org.llvm.support.sys.*;
import org.clang.lex.llvm.*;
import org.clang.lex.spi.GlobalModuleIndexImplementation;
import org.llvm.bitcode.*;


/// \brief Utility class for loading a ASTContext from an AST file.
///
//<editor-fold defaultstate="collapsed" desc="clang::ASTUnit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 68,
 FQN="clang::ASTUnit", NM="_ZN5clang7ASTUnitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnitE")
//</editor-fold>
public class ASTUnit extends /*public*/ ModuleLoader implements Destructors.ClassWithDestructor {
  
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::StandaloneFixIt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 70,
   FQN="clang::ASTUnit::StandaloneFixIt", NM="_ZN5clang7ASTUnit15StandaloneFixItE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit15StandaloneFixItE")
  //</editor-fold>
  public static class/*struct*/ StandaloneFixIt implements Destructors.ClassWithDestructor, NativeCloneable<StandaloneFixIt>, NativeMoveable<StandaloneFixIt> {
    public std.pairUIntUInt RemoveRange;
    public std.pairUIntUInt InsertFromRange;
    public std.string CodeToInsert;
    public boolean BeforePreviousInsertions;
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::StandaloneFixIt::StandaloneFixIt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 70,
     FQN="clang::ASTUnit::StandaloneFixIt::StandaloneFixIt", NM="_ZN5clang7ASTUnit15StandaloneFixItC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit15StandaloneFixItC1EOS1_")
    //</editor-fold>
    public /*inline*/ StandaloneFixIt(JD$Move _dparam, StandaloneFixIt /*&&*/$Prm0) {
      // : RemoveRange(static_cast<StandaloneFixIt &&>().RemoveRange), InsertFromRange(static_cast<StandaloneFixIt &&>().InsertFromRange), CodeToInsert(static_cast<StandaloneFixIt &&>().CodeToInsert), BeforePreviousInsertions(static_cast<StandaloneFixIt &&>().BeforePreviousInsertions) 
      //START JInit
      this.RemoveRange = new std.pairUIntUInt(JD$Move.INSTANCE, $Prm0.RemoveRange);
      this.InsertFromRange = new std.pairUIntUInt(JD$Move.INSTANCE, $Prm0.InsertFromRange);
      this.CodeToInsert = new std.string(JD$Move.INSTANCE, $Prm0.CodeToInsert);
      this.BeforePreviousInsertions = $Prm0.BeforePreviousInsertions;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::StandaloneFixIt::~StandaloneFixIt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 70,
     FQN="clang::ASTUnit::StandaloneFixIt::~StandaloneFixIt", NM="_ZN5clang7ASTUnit15StandaloneFixItD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit15StandaloneFixItD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      CodeToInsert.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::StandaloneFixIt::StandaloneFixIt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 70,
     FQN="clang::ASTUnit::StandaloneFixIt::StandaloneFixIt", NM="_ZN5clang7ASTUnit15StandaloneFixItC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit15StandaloneFixItC1Ev")
    //</editor-fold>
    public /*inline*/ StandaloneFixIt() {
      // : RemoveRange(), InsertFromRange(), CodeToInsert() 
      //START JInit
      this.RemoveRange = new std.pairUIntUInt();
      this.InsertFromRange = new std.pairUIntUInt();
      this.CodeToInsert = new std.string();
      //END JInit
    }

    public /*inline*/ StandaloneFixIt(StandaloneFixIt /*&&*/$Prm0) {
      // : RemoveRange(static_cast<StandaloneFixIt &&>().RemoveRange), InsertFromRange(static_cast<StandaloneFixIt &&>().InsertFromRange), CodeToInsert(static_cast<StandaloneFixIt &&>().CodeToInsert), BeforePreviousInsertions(static_cast<StandaloneFixIt &&>().BeforePreviousInsertions) 
      //START JInit
      this.RemoveRange = new std.pairUIntUInt($Prm0.RemoveRange);
      this.InsertFromRange = new std.pairUIntUInt($Prm0.InsertFromRange);
      this.CodeToInsert = new std.string($Prm0.CodeToInsert);
      this.BeforePreviousInsertions = $Prm0.BeforePreviousInsertions;
      //END JInit
    }
    
    @Override public StandaloneFixIt clone() {
      return new StandaloneFixIt(this);
    }
    
    @Override public StandaloneFixIt move() {
      return new StandaloneFixIt(JD$Move.INSTANCE, this);
    }
    
    
    @Override public String toString() {
      return "" + "RemoveRange=" + RemoveRange // NOI18N
                + ", InsertFromRange=" + InsertFromRange // NOI18N
                + ", CodeToInsert=" + CodeToInsert // NOI18N
                + ", BeforePreviousInsertions=" + BeforePreviousInsertions; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::StandaloneDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 77,
   FQN="clang::ASTUnit::StandaloneDiagnostic", NM="_ZN5clang7ASTUnit20StandaloneDiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit20StandaloneDiagnosticE")
  //</editor-fold>
  public static class/*struct*/ StandaloneDiagnostic implements Destructors.ClassWithDestructor, NativeCloneable<StandaloneDiagnostic>, NativeMoveable<StandaloneDiagnostic> {
    public /*uint*/int ID;
    public DiagnosticsEngine.Level Level;
    public std.string Message;
    public std.string Filename;
    public /*uint*/int LocOffset;
    public std.vector<std.pairUIntUInt> Ranges;
    public std.vector<StandaloneFixIt> FixIts;
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::StandaloneDiagnostic::StandaloneDiagnostic">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 77,
     FQN="clang::ASTUnit::StandaloneDiagnostic::StandaloneDiagnostic", NM="_ZN5clang7ASTUnit20StandaloneDiagnosticC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit20StandaloneDiagnosticC1EOS1_")
    //</editor-fold>
    public /*inline*/ StandaloneDiagnostic(JD$Move _dparam, StandaloneDiagnostic /*&&*/$Prm0) {
      // : ID(static_cast<StandaloneDiagnostic &&>().ID), Level(static_cast<StandaloneDiagnostic &&>().Level), Message(static_cast<StandaloneDiagnostic &&>().Message), Filename(static_cast<StandaloneDiagnostic &&>().Filename), LocOffset(static_cast<StandaloneDiagnostic &&>().LocOffset), Ranges(static_cast<StandaloneDiagnostic &&>().Ranges), FixIts(static_cast<StandaloneDiagnostic &&>().FixIts) 
      //START JInit
      this.ID = $Prm0.ID;
      this.Level = $Prm0.Level;
      this.Message = new std.string(JD$Move.INSTANCE, $Prm0.Message);
      this.Filename = new std.string(JD$Move.INSTANCE, $Prm0.Filename);
      this.LocOffset = $Prm0.LocOffset;
      this.Ranges = new std.vector<std.pairUIntUInt>(JD$Move.INSTANCE, $Prm0.Ranges);
      this.FixIts = new std.vector<StandaloneFixIt>(JD$Move.INSTANCE, $Prm0.FixIts);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::StandaloneDiagnostic::~StandaloneDiagnostic">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 77,
     FQN="clang::ASTUnit::StandaloneDiagnostic::~StandaloneDiagnostic", NM="_ZN5clang7ASTUnit20StandaloneDiagnosticD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit20StandaloneDiagnosticD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      FixIts.$destroy();
      Ranges.$destroy();
      Filename.$destroy();
      Message.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::StandaloneDiagnostic::StandaloneDiagnostic">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 77,
     FQN="clang::ASTUnit::StandaloneDiagnostic::StandaloneDiagnostic", NM="_ZN5clang7ASTUnit20StandaloneDiagnosticC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit20StandaloneDiagnosticC1Ev")
    //</editor-fold>
    public /*inline*/ StandaloneDiagnostic() {
      // : Message(), Filename(), Ranges(), FixIts() 
      //START JInit
      this.Message = new std.string();
      this.Filename = new std.string();
      this.Ranges = new std.vector<std.pairUIntUInt>(new std.pairUIntUInt());
      this.FixIts = new std.vector<StandaloneFixIt>(new StandaloneFixIt());
      //END JInit
    }

    public /*inline*/ StandaloneDiagnostic(StandaloneDiagnostic /*&&*/$Prm0) {
      // : ID(static_cast<StandaloneDiagnostic &&>().ID), Level(static_cast<StandaloneDiagnostic &&>().Level), Message(static_cast<StandaloneDiagnostic &&>().Message), Filename(static_cast<StandaloneDiagnostic &&>().Filename), LocOffset(static_cast<StandaloneDiagnostic &&>().LocOffset), Ranges(static_cast<StandaloneDiagnostic &&>().Ranges), FixIts(static_cast<StandaloneDiagnostic &&>().FixIts) 
      //START JInit
      this.ID = $Prm0.ID;
      this.Level = $Prm0.Level;
      this.Message = new std.string($Prm0.Message);
      this.Filename = new std.string($Prm0.Filename);
      this.LocOffset = $Prm0.LocOffset;
      this.Ranges = new std.vector<std.pairUIntUInt>($Prm0.Ranges);
      this.FixIts = new std.vector<StandaloneFixIt>($Prm0.FixIts);
      //END JInit
    }
    
    @Override public StandaloneDiagnostic clone() {
      return new StandaloneDiagnostic(this);
    }
    
    @Override public StandaloneDiagnostic move() {
      return new StandaloneDiagnostic(JD$Move.INSTANCE, this);
    }
    
    @Override public String toString() {
      return "" + "ID=" + ID // NOI18N
                + ", Level=" + Level // NOI18N
                + ", Message=" + Message // NOI18N
                + ", Filename=" + Filename // NOI18N
                + ", LocOffset=" + LocOffset // NOI18N
                + ", Ranges=" + Ranges // NOI18N
                + ", FixIts=" + FixIts; // NOI18N
    }
  };
/*private:*/
  private std.shared_ptr<LangOptions> LangOpts;
  private IntrusiveRefCntPtr<DiagnosticsEngine> Diagnostics;
  private IntrusiveRefCntPtr<FileManager> FileMgr;
  private IntrusiveRefCntPtr<SourceManager> SourceMgr;
  private std.unique_ptr<HeaderSearch> HeaderInfo;
  private IntrusiveRefCntPtr<TargetInfo> Target;
  private IntrusiveRefCntPtr<Preprocessor> PP;
  private IntrusiveRefCntPtr<ASTContext> Ctx;
  private std.shared_ptr<TargetOptions> TargetOpts;
  private IntrusiveRefCntPtr<HeaderSearchOptions> HSOpts;
  private IntrusiveRefCntPtr<ASTReader> Reader;
  private boolean HadModuleLoaderFatalFailure;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ASTWriterData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 184,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", old_line = 101,
   FQN="clang::ASTUnit::ASTWriterData", NM="_ZN5clang7ASTUnit13ASTWriterDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit13ASTWriterDataE")
  //</editor-fold>
  private static class/*struct*/ ASTWriterData implements Destructors.ClassWithDestructor {
    public SmallString/*128*/ Buffer;
    public BitstreamWriter Stream;
    public ASTWriter Writer;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ASTWriterData::ASTWriterData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 189,
     FQN="clang::ASTUnit::ASTWriterData::ASTWriterData", NM="_ZN5clang7ASTUnit13ASTWriterDataC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit13ASTWriterDataC1Ev")
    //</editor-fold>
    public ASTWriterData() {
      // : Buffer(), Stream(Buffer), Writer(Stream, {  }) 
      //START JInit
      this.Buffer = new SmallString/*128*/(128);
      this.Stream = new BitstreamWriter(Buffer);
      this.Writer = new ASTWriter(Stream, /*{ */new ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension> >()/* }*/);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ASTWriterData::~ASTWriterData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 184,
     FQN="clang::ASTUnit::ASTWriterData::~ASTWriterData", NM="_ZN5clang7ASTUnit13ASTWriterDataD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit13ASTWriterDataD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Writer.$destroy();
      Stream.$destroy();
      Buffer.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Buffer=" + Buffer // NOI18N
                + ", Stream=" + Stream // NOI18N
                + ", Writer=" + Writer; // NOI18N
    }
  };
  private std.unique_ptr<ASTWriterData> WriterData;
  
  private FileSystemOptions FileSystemOpts;
  
  /// \brief The AST consumer that received information about the translation
  /// unit as it was parsed or loaded.
  private std.unique_ptr<ASTConsumer> Consumer;
  
  /// \brief The semantic analysis object used to type-check the translation
  /// unit.
  private std.unique_ptr<Sema> TheSema;
  
  /// Optional owned invocation, just used to make the invocation used in
  /// LoadFromCommandLine available.
  private IntrusiveRefCntPtr<CompilerInvocation> Invocation;
  
  // OnlyLocalDecls - when true, walking this AST should only visit declarations
  // that come from the AST itself, not from included precompiled headers.
  // FIXME: This is temporary; eventually, CIndex will always do this.
  private boolean OnlyLocalDecls;
  
  /// \brief Whether to capture any diagnostics produced.
  private boolean CaptureDiagnostics;
  
  /// \brief Track whether the main file was loaded from an AST or not.
  private boolean MainFileIsAST;
  
  /// \brief What kind of translation unit this AST represents.
  private TranslationUnitKind TUKind;
  
  /// \brief Whether we should time each operation.
  private boolean WantTiming;
  
  /// \brief Whether the ASTUnit should delete the remapped buffers.
  private boolean OwnsRemappedFileBuffers;
  
  /// Track the top-level decls which appeared in an ASTUnit which was loaded
  /// from a source file.
  //
  // FIXME: This is just an optimization hack to avoid deserializing large parts
  // of a PCH file when using the Index library on an ASTUnit loaded from
  // source. In the long term we should make the Index library use efficient and
  // more scalable search mechanisms.
  private std.vector<Decl /*P*/ > TopLevelDecls;
  
  /// \brief Sorted (by file offset) vector of pairs of file offset/Decl.
  /*typedef SmallVector<std::pair<unsigned int, Decl *>, 64> LocDeclsTy*/
//  public final class LocDeclsTy extends SmallVector<std.pairUIntType<Decl /*P*/ >>{ };
  /*typedef llvm::DenseMap<FileID, LocDeclsTy *> FileDeclsTy*/
//  public final class FileDeclsTy extends DenseMap<FileID, SmallVector<std.pairUIntType<Decl /*P*/ >> /*P*/>{ };
  
  /// \brief Map from FileID to the file-level declarations that it contains.
  /// The files and decls are only local (and non-preamble) ones.
  private DenseMap<FileID, SmallVector<std.pairUIntType<Decl /*P*/ >> /*P*/> FileDecls;
  
  /// The name of the original source file used to generate this ASTUnit.
  private std.string OriginalSourceFile;
  
  /// \brief The set of diagnostics produced when creating the preamble.
  private SmallVector<StandaloneDiagnostic> PreambleDiagnostics;
  
  /// \brief The set of diagnostics produced when creating this
  /// translation unit.
  private SmallVector<StoredDiagnostic> StoredDiagnostics;
  
  /// \brief The set of diagnostics produced when failing to parse, e.g. due
  /// to failure to load the PCH.
  private SmallVector<StoredDiagnostic> FailedParseDiagnostics;
  
  /// \brief The number of stored diagnostics that come from the driver
  /// itself.
  ///
  /// Diagnostics that come from the driver are retained from one parse to
  /// the next.
  private /*uint*/int NumStoredDiagnosticsFromDriver;
  
  /// \brief Counter that determines when we want to try building a
  /// precompiled preamble.
  ///
  /// If zero, we will never build a precompiled preamble. Otherwise,
  /// it's treated as a counter that decrements each time we reparse
  /// without the benefit of a precompiled preamble. When it hits 1,
  /// we'll attempt to rebuild the precompiled header. This way, if
  /// building the precompiled preamble fails, we won't try again for
  /// some number of calls.
  private /*uint*/int PreambleRebuildCounter;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::PreambleData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 188,
   FQN="clang::ASTUnit::PreambleData", NM="_ZN5clang7ASTUnit12PreambleDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit12PreambleDataE")
  //</editor-fold>
  public static class PreambleData implements Destructors.ClassWithDestructor {
    private /*const*/ FileEntry /*P*/ File;
    private std.vectorChar Buffer;
    private /*mutable *//*uint*/int NumLines;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::PreambleData::PreambleData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 194,
     FQN="clang::ASTUnit::PreambleData::PreambleData", NM="_ZN5clang7ASTUnit12PreambleDataC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit12PreambleDataC1Ev")
    //</editor-fold>
    public PreambleData() {
      // : File(null), Buffer(), NumLines(0) 
      //START JInit
      this.File = null;
      this.Buffer = new std.vectorChar();
      this.NumLines = 0;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::PreambleData::assign">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 196,
     FQN="clang::ASTUnit::PreambleData::assign", NM="_ZN5clang7ASTUnit12PreambleData6assignEPKNS_9FileEntryEPKcS6_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit12PreambleData6assignEPKNS_9FileEntryEPKcS6_")
    //</editor-fold>
    public void assign(/*const*/ FileEntry /*P*/ F, /*const*/char$ptr/*char P*/ begin, /*const*/char$ptr/*char P*/ end) {
      File = F;
      Buffer.assign$T(begin, end);
      NumLines = 0;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::PreambleData::clear">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 202,
     FQN="clang::ASTUnit::PreambleData::clear", NM="_ZN5clang7ASTUnit12PreambleData5clearEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit12PreambleData5clearEv")
    //</editor-fold>
    public void clear() {
      Buffer.clear();
      File = null;
      NumLines = 0;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::PreambleData::size">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 204,
     FQN="clang::ASTUnit::PreambleData::size", NM="_ZNK5clang7ASTUnit12PreambleData4sizeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit12PreambleData4sizeEv")
    //</editor-fold>
    public /*size_t*/int size() /*const*/ {
      return Buffer.size();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::PreambleData::empty">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 205,
     FQN="clang::ASTUnit::PreambleData::empty", NM="_ZNK5clang7ASTUnit12PreambleData5emptyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit12PreambleData5emptyEv")
    //</editor-fold>
    public boolean empty() /*const*/ {
      return Buffer.empty();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::PreambleData::getBufferStart">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 207,
     FQN="clang::ASTUnit::PreambleData::getBufferStart", NM="_ZNK5clang7ASTUnit12PreambleData14getBufferStartEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit12PreambleData14getBufferStartEv")
    //</editor-fold>
    public /*const*/char$ptr/*char P*/ getBufferStart() /*const*/ {
      return /*AddrOf*/Buffer.data();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::PreambleData::getNumLines">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 209,
     FQN="clang::ASTUnit::PreambleData::getNumLines", NM="_ZNK5clang7ASTUnit12PreambleData11getNumLinesEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit12PreambleData11getNumLinesEv")
    //</editor-fold>
    public /*uint*/int getNumLines() /*const*/ {
      if ((NumLines != 0)) {
        return NumLines;
      }
      countLines();
      return NumLines;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::PreambleData::getSourceRange">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 216,
     FQN="clang::ASTUnit::PreambleData::getSourceRange", NM="_ZNK5clang7ASTUnit12PreambleData14getSourceRangeERKNS_13SourceManagerE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit12PreambleData14getSourceRangeERKNS_13SourceManagerE")
    //</editor-fold>
    public SourceRange getSourceRange(/*const*/ SourceManager /*&*/ SM) /*const*/ {
      SourceLocation FileLoc = SM.getLocForStartOfFile(SM.getPreambleFileID());
      return new SourceRange(/*NO_COPY*/FileLoc, FileLoc.getLocWithOffset(size() - 1));
    }

  /*private:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::PreambleData::countLines">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2831,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2820,
     FQN="clang::ASTUnit::PreambleData::countLines", NM="_ZNK5clang7ASTUnit12PreambleData10countLinesEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit12PreambleData10countLinesEv")
    //</editor-fold>
    private void countLines() /*const*/ {
      NumLines = 0;
      if (empty()) {
        return;
      }
      
      NumLines = std.count(Buffer.begin$Const(), Buffer.end$Const(), $$LF);
      if (Buffer.back$Const() != $$LF) {
        ++NumLines;
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::PreambleData::~PreambleData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 188,
     FQN="clang::ASTUnit::PreambleData::~PreambleData", NM="_ZN5clang7ASTUnit12PreambleDataD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit12PreambleDataD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Buffer.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "File=" + File // NOI18N
                + ", Buffer=" + Buffer // NOI18N
                + ", NumLines=" + NumLines; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getPreambleData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 225,
   FQN="clang::ASTUnit::getPreambleData", NM="_ZNK5clang7ASTUnit15getPreambleDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit15getPreambleDataEv")
  //</editor-fold>
  public /*const*/ PreambleData /*&*/ getPreambleData() /*const*/ {
    return Preamble;
  }

  
  /// Data used to determine if a file used in the preamble has been changed.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::PreambleFileHash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 230,
   FQN="clang::ASTUnit::PreambleFileHash", NM="_ZN5clang7ASTUnit16PreambleFileHashE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16PreambleFileHashE")
  //</editor-fold>
  public static class/*struct*/ PreambleFileHash implements NativePOD<PreambleFileHash>, NativeMoveable<PreambleFileHash> {
    /// All files have size set.
    public long/*off_t*/ Size;
    
    /// Modification time is set for files that are on disk.  For memory
    /// buffers it is zero.
    public long/*time_t*/ ModTime;
    
    /// Memory buffers have MD5 instead of modification time.  We don't
    /// compute MD5 for on-disk files because we hope that modification time is
    /// enough to tell if the file was changed.
    public byte/*uint8_t*/ MD5[/*16*/] = new byte/*uint8_t*/ [16];
    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::PreambleFileHash::createForFile">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1245,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1246,
     FQN="clang::ASTUnit::PreambleFileHash::createForFile", NM="_ZN5clang7ASTUnit16PreambleFileHash13createForFileEll",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16PreambleFileHash13createForFileEll")
    //</editor-fold>
    public static ASTUnit.PreambleFileHash createForFile(long/*off_t*/ Size, long/*time_t*/ ModTime) {
      PreambleFileHash Result/*J*/= new PreambleFileHash();
      Result.Size = Size;
      Result.ModTime = ModTime;
      memset(Result.MD5, (byte)0, sizeof(Result.MD5));
      return Result;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::PreambleFileHash::createForMemoryBuffer">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1254,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1255,
     FQN="clang::ASTUnit::PreambleFileHash::createForMemoryBuffer", NM="_ZN5clang7ASTUnit16PreambleFileHash21createForMemoryBufferEPKN4llvm12MemoryBufferE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16PreambleFileHash21createForMemoryBufferEPKN4llvm12MemoryBufferE")
    //</editor-fold>
    public static ASTUnit.PreambleFileHash createForMemoryBuffer(/*const*/ MemoryBuffer /*P*/ Buffer) {
      PreambleFileHash Result/*J*/= new PreambleFileHash();
      Result.Size = Buffer.getBufferSize();
      Result.ModTime = 0;
      
      MD5 MD5Ctx/*J*/= new MD5();
      MD5Ctx.update(new StringRef(Buffer.getBuffer().data()));
      MD5Ctx.__final(Result.MD5);
      
      return Result;
    }

    
    /*friend bool operator==(const PreambleFileHash &LHS, 
    const PreambleFileHash &RHS)*/
    
    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 250,
     FQN="clang::operator!=", NM="_ZN5clangneERKNS_7ASTUnit16PreambleFileHashES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clangneERKNS_7ASTUnit16PreambleFileHashES3_")
    //</editor-fold>
    public static boolean $noteq_PreambleFileHash$C(/*const*/ PreambleFileHash /*&*/ LHS, 
                             /*const*/ PreambleFileHash /*&*/ RHS) {
      return !($eq_PreambleFileHash$C(LHS, RHS));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::PreambleFileHash::PreambleFileHash">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 230,
     FQN="clang::ASTUnit::PreambleFileHash::PreambleFileHash", NM="_ZN5clang7ASTUnit16PreambleFileHashC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16PreambleFileHashC1Ev")
    //</editor-fold>
    public /*inline*/ PreambleFileHash() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::PreambleFileHash::PreambleFileHash">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 230,
     FQN="clang::ASTUnit::PreambleFileHash::PreambleFileHash", NM="_ZN5clang7ASTUnit16PreambleFileHashC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16PreambleFileHashC1EOS1_")
    //</editor-fold>
    public /*inline*/ PreambleFileHash(JD$Move _dparam, PreambleFileHash /*&&*/$Prm0) {
      // : Size(static_cast<PreambleFileHash &&>().Size), ModTime(static_cast<PreambleFileHash &&>().ModTime), MD5(static_cast<uint8_t &&>(static_cast<PreambleFileHash &&>().MD5[__i0])) 
      //START JInit
      this.Size = $Prm0.Size;
      this.ModTime = $Prm0.ModTime;
      this.MD5 = $Prm0.MD5;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::PreambleFileHash::operator=">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 230,
     FQN="clang::ASTUnit::PreambleFileHash::operator=", NM="_ZN5clang7ASTUnit16PreambleFileHashaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16PreambleFileHashaSEOS1_")
    //</editor-fold>
    public /*inline*/ PreambleFileHash /*&*/ $assignMove(PreambleFileHash /*&&*/$Prm0) {
      this.Size = $Prm0.Size;
      this.ModTime = $Prm0.ModTime;
      __builtin_memcpy(/*AddrOf*/this.MD5, /*AddrOf*/$Prm0.MD5, sizeof($Prm0.MD5));
      return /*Deref*/this;
    }

    public /*inline*/ PreambleFileHash /*&*/ $assign(PreambleFileHash /*&&*/$Prm0) {
      this.Size = $Prm0.Size;
      this.ModTime = $Prm0.ModTime;
      __builtin_memcpy(/*AddrOf*/this.MD5, /*AddrOf*/$Prm0.MD5, sizeof($Prm0.MD5));
      return /*Deref*/this;
    }
    
    @Override public PreambleFileHash clone() {
      return new PreambleFileHash().$assign(this);
    }

    @Override public PreambleFileHash move() {
      return new PreambleFileHash(JD$Move.INSTANCE, this);
    }
    
    @Override public String toString() {
      return "" + "Size=" + Size // NOI18N
                + ", ModTime=" + ModTime // NOI18N
                + ", MD5=" + MD5; // NOI18N
    }
  };
/*private:*/
  /// \brief The contents of the preamble that has been precompiled to
  /// \c PreambleFile.
  private PreambleData Preamble;
  
  /// \brief Whether the preamble ends at the start of a new line.
  /// 
  /// Used to inform the lexer as to whether it's starting at the beginning of
  /// a line after skipping the preamble.
  private boolean PreambleEndsAtStartOfLine;
  
  /// \brief Keeps track of the files that were used when computing the 
  /// preamble, with both their buffer size and their modification time.
  ///
  /// If any of the files have changed from one compile to the next,
  /// the preamble must be thrown away.
  private StringMap<PreambleFileHash> FilesInPreamble;
  
  /// \brief When non-NULL, this is the buffer used to store the contents of
  /// the main file when it has been padded for use with the precompiled
  /// preamble.
  private std.unique_ptr<MemoryBuffer> SavedMainFileBuffer;
  
  /// \brief When non-NULL, this is the buffer used to store the
  /// contents of the preamble when it has been padded to build the
  /// precompiled preamble.
  private std.unique_ptr<MemoryBuffer> PreambleBuffer;
  
  /// \brief The number of warnings that occurred while parsing the preamble.
  ///
  /// This value will be used to restore the state of the \c DiagnosticsEngine
  /// object when re-using the precompiled preamble. Note that only the
  /// number of warnings matters, since we will not save the preamble
  /// when any errors are present.
  private /*uint*/int NumWarningsInPreamble;
  
  /// \brief A list of the serialization ID numbers for each of the top-level
  /// declarations parsed within the precompiled preamble.
  private std.vectorUInt TopLevelDeclsInPreamble;
  
  /// \brief Whether we should be caching code-completion results.
  private /*JBIT bool*/ boolean ShouldCacheCodeCompletionResults /*: 1*/;
  
  /// \brief Whether to include brief documentation within the set of code
  /// completions cached.
  private /*JBIT bool*/ boolean IncludeBriefCommentsInCodeCompletion /*: 1*/;
  
  /// \brief True if non-system source files should be treated as volatile
  /// (likely to change while trying to use them).
  private /*JBIT bool*/ boolean UserFilesAreVolatile /*: 1*/;
  
  /// \brief The language options used when we load an AST file.
  private LangOptions ASTFileLangOpts;
  
  
  /// \brief Configure the diagnostics object for use with ASTUnit.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ConfigureDiags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 645,
   FQN="clang::ASTUnit::ConfigureDiags", NM="_ZN5clang7ASTUnit14ConfigureDiagsEN4llvm18IntrusiveRefCntPtrINS_17DiagnosticsEngineEEERS0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit14ConfigureDiagsEN4llvm18IntrusiveRefCntPtrINS_17DiagnosticsEngineEEERS0_b")
  //</editor-fold>
  private static void ConfigureDiags(IntrusiveRefCntPtr<DiagnosticsEngine> Diags, 
                ASTUnit /*&*/ AST, boolean CaptureDiagnostics) {
    assert ((Diags.get() != null)) : "no DiagnosticsEngine was provided";
    if (CaptureDiagnostics) {
      Diags.$arrow().setClient(new StoredDiagnosticConsumer(AST.StoredDiagnostics));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::TranslateStoredDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2528,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2517,
   FQN="clang::ASTUnit::TranslateStoredDiagnostics", NM="_ZN5clang7ASTUnit26TranslateStoredDiagnosticsERNS_11FileManagerERNS_13SourceManagerERKN4llvm15SmallVectorImplINS0_20StandaloneDiagnosticEEERNS6_INS_16StoredDiagnosticEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit26TranslateStoredDiagnosticsERNS_11FileManagerERNS_13SourceManagerERKN4llvm15SmallVectorImplINS0_20StandaloneDiagnosticEEERNS6_INS_16StoredDiagnosticEEE")
  //</editor-fold>
  private void TranslateStoredDiagnostics(FileManager /*&*/ FileMgr, 
                            SourceManager /*&*/ SrcMgr, 
                            /*const*/ SmallVectorImpl<StandaloneDiagnostic> /*&*/ Diags, 
                            SmallVectorImpl<StoredDiagnostic> /*&*/ Out) {
    SmallVector<StoredDiagnostic> Result = null;
    try {
      // Map the standalone diagnostic into the new source manager. We also need to
      // remap all the locations to the new view. This includes the diag location,
      // any associated source ranges, and the source ranges of associated fix-its.
      // FIXME: There should be a cleaner way to do this.
      Result/*J*/= new SmallVector<StoredDiagnostic>(4, new StoredDiagnostic());
      Result.reserve(Diags.size());
      for (/*const*/ StandaloneDiagnostic /*&*/ SD : Diags) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Rebuild the StoredDiagnostic.
          if (SD.Filename.empty()) {
            continue;
          }
          /*const*/ FileEntry /*P*/ FE = FileMgr.getFile(new StringRef(SD.Filename));
          if (!(FE != null)) {
            continue;
          }
          FileID FID = SrcMgr.translateFile(FE);
          SourceLocation FileLoc = SrcMgr.getLocForStartOfFile(/*NO_COPY*/FID);
          if (FileLoc.isInvalid()) {
            continue;
          }
          SourceLocation L = FileLoc.getLocWithOffset(SD.LocOffset);
          FullSourceLoc Loc/*J*/= new FullSourceLoc(/*NO_COPY*/L, SrcMgr);
          
          SmallVector<CharSourceRange/*,4*/> Ranges/*J*/= new SmallVector<CharSourceRange/*,4*/>(4, new CharSourceRange());
          Ranges.reserve(SD.Ranges.size());
          for (/*const*/std.pairUIntUInt/*&*/ Range : SD.Ranges) {
            SourceLocation BL = FileLoc.getLocWithOffset(Range.first);
            SourceLocation EL = FileLoc.getLocWithOffset(Range.second);
            Ranges.push_back(CharSourceRange.getCharRange(/*NO_COPY*/BL, /*NO_COPY*/EL));
          }
          
          SmallVector<FixItHint> FixIts/*J*/= new SmallVector<FixItHint>(2, new FixItHint());
          FixIts.reserve(SD.FixIts.size());
          for (/*const*/ StandaloneFixIt /*&*/ FixIt : SD.FixIts) {
            FixIts.push_back_T$RR(new FixItHint());
            FixItHint /*&*/ FH = FixIts.back();
            FH.CodeToInsert.$assign(FixIt.CodeToInsert);
            SourceLocation BL = FileLoc.getLocWithOffset(FixIt.RemoveRange.first);
            SourceLocation EL = FileLoc.getLocWithOffset(FixIt.RemoveRange.second);
            FH.RemoveRange.$assignMove(CharSourceRange.getCharRange(/*NO_COPY*/BL, /*NO_COPY*/EL));
          }
          
          Result.push_back_T$RR($c$.track(new StoredDiagnostic(SD.Level, SD.ID, 
                  new StringRef(SD.Message), new FullSourceLoc(Loc), new ArrayRef<CharSourceRange>(Ranges), new ArrayRef<FixItHint>(FixIts)))); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
      Result.swap(Out);
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::clearFileLevelDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 192,
   FQN="clang::ASTUnit::clearFileLevelDecls", NM="_ZN5clang7ASTUnit19clearFileLevelDeclsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit19clearFileLevelDeclsEv")
  //</editor-fold>
  private void clearFileLevelDecls() {
    llvm.DeleteContainerSeconds(FileDecls);
  }

/*public:*/
  /// \brief A cached code-completion result, which may be introduced in one of
  /// many different contexts.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::CachedCodeCompletionResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 323,
   FQN="clang::ASTUnit::CachedCodeCompletionResult", NM="_ZN5clang7ASTUnit26CachedCodeCompletionResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit26CachedCodeCompletionResultE")
  //</editor-fold>
  public static class/*struct*/ CachedCodeCompletionResult implements NativeCloneable<CachedCodeCompletionResult>, NativeMoveable<CachedCodeCompletionResult> {
    /// \brief The code-completion string corresponding to this completion
    /// result.
    public CodeCompletionString /*P*/ Completion;
    
    /// \brief A bitmask that indicates which code-completion contexts should
    /// contain this completion result.
    ///
    /// The bits in the bitmask correspond to the values of
    /// CodeCompleteContext::Kind. To map from a completion context kind to a
    /// bit, shift 1 by that number of bits. Many completions can occur in
    /// several different contexts.
    public long/*uint64_t*/ ShowInContexts;
    
    /// \brief The priority given to this code-completion result.
    public /*uint*/int Priority;
    
    /// \brief The libclang cursor kind corresponding to this code-completion 
    /// result.
    public CXCursorKind Kind;
    
    /// \brief The availability of this code-completion result.
    public CXAvailabilityKind Availability;
    
    /// \brief The simplified type class for a non-macro completion result.
    public SimplifiedTypeClass TypeClass;
    
    /// \brief The type of a non-macro completion result, stored as a unique
    /// integer used by the string map of cached completion types.
    ///
    /// This value will be zero if the type is not known, or a unique value
    /// determined by the formatted type string. Se \c CachedCompletionTypes
    /// for more information.
    public /*uint*/int Type;
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::CachedCodeCompletionResult::CachedCodeCompletionResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 323,
     FQN="clang::ASTUnit::CachedCodeCompletionResult::CachedCodeCompletionResult", NM="_ZN5clang7ASTUnit26CachedCodeCompletionResultC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit26CachedCodeCompletionResultC1Ev")
    //</editor-fold>
    public /*inline*/ CachedCodeCompletionResult() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::CachedCodeCompletionResult::CachedCodeCompletionResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 323,
     FQN="clang::ASTUnit::CachedCodeCompletionResult::CachedCodeCompletionResult", NM="_ZN5clang7ASTUnit26CachedCodeCompletionResultC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit26CachedCodeCompletionResultC1ERKS1_")
    //</editor-fold>
    public /*inline*/ CachedCodeCompletionResult(/*const*/ CachedCodeCompletionResult /*&*/ $Prm0) {
      // : Completion(.Completion), ShowInContexts(.ShowInContexts), Priority(.Priority), Kind(.Kind), Availability(.Availability), TypeClass(.TypeClass), Type(.Type) 
      //START JInit
      this.Completion = $Prm0.Completion;
      this.ShowInContexts = $Prm0.ShowInContexts;
      this.Priority = $Prm0.Priority;
      this.Kind = $Prm0.Kind;
      this.Availability = $Prm0.Availability;
      this.TypeClass = $Prm0.TypeClass;
      this.Type = $Prm0.Type;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::CachedCodeCompletionResult::CachedCodeCompletionResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 323,
     FQN="clang::ASTUnit::CachedCodeCompletionResult::CachedCodeCompletionResult", NM="_ZN5clang7ASTUnit26CachedCodeCompletionResultC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit26CachedCodeCompletionResultC1EOS1_")
    //</editor-fold>
    public /*inline*/ CachedCodeCompletionResult(JD$Move _dparam, CachedCodeCompletionResult /*&&*/$Prm0) {
      // : Completion(static_cast<CachedCodeCompletionResult &&>().Completion), ShowInContexts(static_cast<CachedCodeCompletionResult &&>().ShowInContexts), Priority(static_cast<CachedCodeCompletionResult &&>().Priority), Kind(static_cast<CachedCodeCompletionResult &&>().Kind), Availability(static_cast<CachedCodeCompletionResult &&>().Availability), TypeClass(static_cast<CachedCodeCompletionResult &&>().TypeClass), Type(static_cast<CachedCodeCompletionResult &&>().Type) 
      //START JInit
      this.Completion = $Prm0.Completion;
      this.ShowInContexts = $Prm0.ShowInContexts;
      this.Priority = $Prm0.Priority;
      this.Kind = $Prm0.Kind;
      this.Availability = $Prm0.Availability;
      this.TypeClass = $Prm0.TypeClass;
      this.Type = $Prm0.Type;
      //END JInit
    }

    @Override public CachedCodeCompletionResult clone() {
      return new CachedCodeCompletionResult(this);
    }

    @Override public CachedCodeCompletionResult move() {
      return new CachedCodeCompletionResult(JD$Move.INSTANCE, this);
    }

    
    @Override public String toString() {
      return "" + "Completion=" + Completion // NOI18N
                + ", ShowInContexts=" + ShowInContexts // NOI18N
                + ", Priority=" + Priority // NOI18N
                + ", Kind=" + Kind // NOI18N
                + ", Availability=" + Availability // NOI18N
                + ", TypeClass=" + TypeClass // NOI18N
                + ", Type=" + Type; // NOI18N
    }
  };
  
  /// \brief Retrieve the mapping from formatted type names to unique type
  /// identifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getCachedCompletionTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 361,
   FQN="clang::ASTUnit::getCachedCompletionTypes", NM="_ZN5clang7ASTUnit24getCachedCompletionTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit24getCachedCompletionTypesEv")
  //</editor-fold>
  public StringMapUInt/*&*/ getCachedCompletionTypes() {
    return CachedCompletionTypes;
  }

  
  /// \brief Retrieve the allocator used to cache global code completions.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getCachedCompletionAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 366,
   FQN="clang::ASTUnit::getCachedCompletionAllocator", NM="_ZN5clang7ASTUnit28getCachedCompletionAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit28getCachedCompletionAllocatorEv")
  //</editor-fold>
  public IntrusiveRefCntPtr<GlobalCodeCompletionAllocator> getCachedCompletionAllocator() {
    return new IntrusiveRefCntPtr<GlobalCodeCompletionAllocator>(CachedCompletionAllocator);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getCodeCompletionTUInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 371,
   FQN="clang::ASTUnit::getCodeCompletionTUInfo", NM="_ZN5clang7ASTUnit23getCodeCompletionTUInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit23getCodeCompletionTUInfoEv")
  //</editor-fold>
  public CodeCompletionTUInfo /*&*/ getCodeCompletionTUInfo() {
    if (!CCTUInfo.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        CCTUInfo.reset(new CodeCompletionTUInfo($c$.track(new IntrusiveRefCntPtr<GlobalCodeCompletionAllocator>(new GlobalCodeCompletionAllocator())))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
    return CCTUInfo.$star();
  }

/*private:*/
  /// \brief Allocator used to store cached code completions.
  private IntrusiveRefCntPtr<GlobalCodeCompletionAllocator> CachedCompletionAllocator;
  
  private std.unique_ptr<CodeCompletionTUInfo> CCTUInfo;
  
  /// \brief The set of cached code-completion results.
  private std.vector<CachedCodeCompletionResult> CachedCompletionResults;
  
  /// \brief A mapping from the formatted type name to a unique number for that
  /// type, which is used for type equality comparisons.
  private StringMapUInt CachedCompletionTypes;
  
  /// \brief A string hash of the top-level declaration and macro definition 
  /// names processed the last time that we reparsed the file.
  ///
  /// This hash value is used to determine when we need to refresh the 
  /// global code-completion cache.
  private /*uint*/int CompletionCacheTopLevelHashValue;
  
  /// \brief A string hash of the top-level declaration and macro definition 
  /// names processed the last time that we reparsed the precompiled preamble.
  ///
  /// This hash value is used to determine when we need to refresh the 
  /// global code-completion cache after a rebuild of the precompiled preamble.
  private /*uint*/int PreambleTopLevelHashValue;
  
  /// \brief The current hash value for the top-level declaration and macro
  /// definition names
  private /*uint*/int CurrentTopLevelHashValue;
  
  /// \brief Bit used by CIndex to mark when a translation unit may be in an
  /// inconsistent state, and is not safe to free.
  private /*JBIT unsigned int*/ boolean UnsafeToFree /*: 1*/;
  
  /// \brief Cache any "global" code-completion results, so that we can avoid
  /// recomputing them with each completion.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::CacheCodeCompletionResults">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 337,
   FQN="clang::ASTUnit::CacheCodeCompletionResults", NM="_ZN5clang7ASTUnit26CacheCodeCompletionResultsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit26CacheCodeCompletionResultsEv")
  //</editor-fold>
  private void CacheCodeCompletionResults() {
    SimpleTimer Timer = null;
    CodeCompletionTUInfo CCTUInfo = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!TheSema.$bool()) {
        return;
      }
      
      Timer/*J*/= new SimpleTimer(WantTiming);
      Timer.setOutput($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"Cache global code completions for ", getMainFileName()));
      
      // Clear out the previous results.
      ClearCachedCompletionResults();
      
      // Gather the set of global code completions.
      /*typedef CodeCompletionResult Result*/
//      final class Result extends CodeCompletionResult{ };
      SmallVector<CodeCompletionResult> Results/*J*/= new SmallVector<CodeCompletionResult>(8, new CodeCompletionResult());
      $c$.clean(CachedCompletionAllocator.$assign($c$.track(new IntrusiveRefCntPtr<GlobalCodeCompletionAllocator>(new GlobalCodeCompletionAllocator()))));
      CCTUInfo/*J*/= $c$.clean(new CodeCompletionTUInfo($c$.track(new IntrusiveRefCntPtr<GlobalCodeCompletionAllocator>(CachedCompletionAllocator))));
      TheSema.$arrow().GatherGlobalCodeCompletions(CachedCompletionAllocator.$star(), 
          CCTUInfo, Results);
      
      // Translate global code completions into cached completions.
      DenseMapTypeUInt<CanQual<Type>> CompletionTypes/*J*/= new DenseMapTypeUInt<CanQual<Type>>(DenseMapInfoCanQual$Type.$Info(), 0);
      CodeCompletionContext CCContext/*J*/= new CodeCompletionContext(CodeCompletionContext.Kind.CCC_TopLevel);
      
      for (CodeCompletionResult /*&*/ R : Results) {
        switch (R.Kind) {
         case RK_Declaration:
          {
            bool$ref IsNestedNameSpecifier = create_bool$ref(false);
            CachedCodeCompletionResult CachedResult/*J*/= new CachedCodeCompletionResult();
            CachedResult.Completion = R.CreateCodeCompletionString(TheSema.$star(), CCContext, CachedCompletionAllocator.$star(), CCTUInfo, 
                IncludeBriefCommentsInCodeCompletion);
            CachedResult.ShowInContexts = $uint2ulong(getDeclShowContexts(R.Declaration, Ctx.$arrow().getLangOpts(), IsNestedNameSpecifier));
            CachedResult.Priority = R.Priority;
            CachedResult.Kind = R.CursorKind;
            CachedResult.Availability = R.Availability;
            
            // Keep track of the type of this completion in an ASTContext-agnostic 
            // way.
            QualType UsageType = getDeclUsageType(Ctx.$star(), R.Declaration);
            if (UsageType.isNull()) {
              CachedResult.TypeClass = SimplifiedTypeClass.STC_Void;
              CachedResult.Type = 0;
            } else {
              CanQual<Type> CanUsageType = Ctx.$arrow().getCanonicalType(UsageType.getUnqualifiedType());
              CachedResult.TypeClass = getSimplifiedTypeClass(new CanQual<Type>(CanUsageType));
              
              // Determine whether we have already seen this type. If so, we save
              // ourselves the work of formatting the type string by using the 
              // temporary, CanQualType-based hash table to find the associated value.
              uint$ref/*uint &*/ TypeValue = CompletionTypes.ref$at(CanUsageType);
              if (TypeValue.$deref() == 0) {
                TypeValue.$set(CompletionTypes.size());
                CachedCompletionTypes.$set(new StringRef(CanUsageType.$QualType().getAsString()), 
                  TypeValue.$deref());
              }
              
              CachedResult.Type = TypeValue.$deref();
            }
            
            CachedCompletionResults.push_back_T$C$R(CachedResult);
            
            /// Handle nested-name-specifiers in C++.
            if (TheSema.$arrow().Context.getLangOpts().CPlusPlus && IsNestedNameSpecifier.$deref()
               && !R.StartsNestedNameSpecifier) {
              // The contexts in which a nested-name-specifier can appear in C++.
              long/*uint64_t*/ NNSContexts = (1L/*LL*/ << CodeCompletionContext.Kind.CCC_TopLevel.getValue())
                 | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ObjCIvarList.getValue())
                 | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ClassStructUnion.getValue())
                 | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_Statement.getValue())
                 | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_Expression.getValue())
                 | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ObjCMessageReceiver.getValue())
                 | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_EnumTag.getValue())
                 | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_UnionTag.getValue())
                 | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ClassOrStructTag.getValue())
                 | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_Type.getValue())
                 | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_PotentiallyQualifiedName.getValue())
                 | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ParenthesizedExpression.getValue());
              if (isa(NamespaceDecl.class, R.Declaration)
                 || isa(NamespaceAliasDecl.class, R.Declaration)) {
                NNSContexts |= (1L/*LL*/ << CodeCompletionContext.Kind.CCC_Namespace.getValue());
              }
              {
                
                /*uint*/int RemainingContexts = $ullong2uint(NNSContexts & ~CachedResult.ShowInContexts);
                if ((RemainingContexts != 0)) {
                  // If there any contexts where this completion can be a 
                  // nested-name-specifier but isn't already an option, create a 
                  // nested-name-specifier completion.
                  R.StartsNestedNameSpecifier = true;
                  CachedResult.Completion = R.CreateCodeCompletionString(TheSema.$star(), CCContext, CachedCompletionAllocator.$star(), CCTUInfo, 
                      IncludeBriefCommentsInCodeCompletion);
                  CachedResult.ShowInContexts = $uint2ulong(RemainingContexts);
                  CachedResult.Priority = CCP_NestedNameSpecifier;
                  CachedResult.TypeClass = SimplifiedTypeClass.STC_Void;
                  CachedResult.Type = 0;
                  CachedCompletionResults.push_back_T$C$R(CachedResult);
                }
              }
            }
            break;
          }
         case RK_Keyword:
         case RK_Pattern:
          // Ignore keywords and patterns; we don't care, since they are so
          // easily regenerated.
          break;
         case RK_Macro:
          {
            CachedCodeCompletionResult CachedResult/*J*/= new CachedCodeCompletionResult();
            CachedResult.Completion = R.CreateCodeCompletionString(TheSema.$star(), CCContext, CachedCompletionAllocator.$star(), CCTUInfo, 
                IncludeBriefCommentsInCodeCompletion);
            CachedResult.ShowInContexts
               = (1L/*LL*/ << CodeCompletionContext.Kind.CCC_TopLevel.getValue())
               | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ObjCInterface.getValue())
               | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ObjCImplementation.getValue())
               | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ObjCIvarList.getValue())
               | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ClassStructUnion.getValue())
               | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_Statement.getValue())
               | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_Expression.getValue())
               | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ObjCMessageReceiver.getValue())
               | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_MacroNameUse.getValue())
               | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_PreprocessorExpression.getValue())
               | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ParenthesizedExpression.getValue())
               | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_OtherWithMacros.getValue());
            
            CachedResult.Priority = R.Priority;
            CachedResult.Kind = R.CursorKind;
            CachedResult.Availability = R.Availability;
            CachedResult.TypeClass = SimplifiedTypeClass.STC_Void;
            CachedResult.Type = 0;
            CachedCompletionResults.push_back_T$C$R(CachedResult);
            break;
          }
        }
      }
      
      // Save the current top-level hash value.
      CompletionCacheTopLevelHashValue = CurrentTopLevelHashValue;
    } finally {
      if (CCTUInfo != null) { CCTUInfo.$destroy(); }
      if (Timer != null) { Timer.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief Clear out and deallocate 
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ClearCachedCompletionResults">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 480,
   FQN="clang::ASTUnit::ClearCachedCompletionResults", NM="_ZN5clang7ASTUnit28ClearCachedCompletionResultsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit28ClearCachedCompletionResultsEv")
  //</editor-fold>
  private void ClearCachedCompletionResults() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CachedCompletionResults.clear();
      CachedCompletionTypes.clear();
      $c$.clean(CachedCompletionAllocator.$assign($c$.track(new IntrusiveRefCntPtr<GlobalCodeCompletionAllocator>((GlobalCodeCompletionAllocator /*P*/ )null))));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ASTUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 421,
   FQN="clang::ASTUnit::ASTUnit", NM="_ZN5clang7ASTUnitC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnitC1ERKS0_")
  //</editor-fold>
  private ASTUnit(/*const*/ ASTUnit /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 422,
   FQN="clang::ASTUnit::operator=", NM="_ZN5clang7ASTUnitaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnitaSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ ASTUnit /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ASTUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 215,
   FQN="clang::ASTUnit::ASTUnit", NM="_ZN5clang7ASTUnitC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnitC1Eb")
  //</editor-fold>
  private ASTUnit(boolean _MainFileIsAST) {
    // : ModuleLoader(), LangOpts(), Diagnostics(), FileMgr(), SourceMgr(), HeaderInfo(), Target(), PP(), Ctx(), TargetOpts(), HSOpts(), Reader(null), HadModuleLoaderFatalFailure(false), WriterData(), FileSystemOpts(), Consumer(), TheSema(), Invocation(), OnlyLocalDecls(false), CaptureDiagnostics(false), MainFileIsAST(_MainFileIsAST), TUKind(TU_Complete), WantTiming(getenv("LIBCLANG_TIMING")), OwnsRemappedFileBuffers(true), TopLevelDecls(), FileDecls(), OriginalSourceFile(), PreambleDiagnostics(), StoredDiagnostics(), FailedParseDiagnostics(), NumStoredDiagnosticsFromDriver(0), PreambleRebuildCounter(0), Preamble(), FilesInPreamble(), SavedMainFileBuffer(), PreambleBuffer(), NumWarningsInPreamble(0), TopLevelDeclsInPreamble(), ShouldCacheCodeCompletionResults(false), IncludeBriefCommentsInCodeCompletion(false), UserFilesAreVolatile(false), ASTFileLangOpts(), CachedCompletionAllocator(), CCTUInfo(), CachedCompletionResults(), CachedCompletionTypes(), CompletionCacheTopLevelHashValue(0), PreambleTopLevelHashValue(0), CurrentTopLevelHashValue(0), UnsafeToFree(false), ConcurrencyCheckValue() 
    //START JInit
    super();
    this.LangOpts = new std.shared_ptr<LangOptions>();
    this.Diagnostics = new IntrusiveRefCntPtr<DiagnosticsEngine>();
    this.FileMgr = new IntrusiveRefCntPtr<FileManager>();
    this.SourceMgr = new IntrusiveRefCntPtr<SourceManager>();
    this.HeaderInfo = new std.unique_ptr<HeaderSearch>();
    this.Target = new IntrusiveRefCntPtr<TargetInfo>();
    this.PP = new IntrusiveRefCntPtr<Preprocessor>();
    this.Ctx = new IntrusiveRefCntPtr<ASTContext>();
    this.TargetOpts = new std.shared_ptr<TargetOptions>();
    this.HSOpts = new IntrusiveRefCntPtr<HeaderSearchOptions>();
    this.Reader = new IntrusiveRefCntPtr<ASTReader>((ASTReader /*P*/ )null);
    this.HadModuleLoaderFatalFailure = false;
    this.WriterData = new std.unique_ptr<ASTWriterData>();
    this.FileSystemOpts = new FileSystemOptions();
    this.Consumer = new std.unique_ptr<ASTConsumer>();
    this.TheSema = new std.unique_ptr<Sema>();
    this.Invocation = new IntrusiveRefCntPtr<CompilerInvocation>();
    this.OnlyLocalDecls = false;
    this.CaptureDiagnostics = false;
    this.MainFileIsAST = _MainFileIsAST;
    this.TUKind = TranslationUnitKind.TU_Complete;
    this.WantTiming = (getenv($("LIBCLANG_TIMING")) != null);
    this.OwnsRemappedFileBuffers = true;
    this.TopLevelDecls = new std.vector<Decl /*P*/ >((Decl /*P*/ )null);
    this.FileDecls = new DenseMap<FileID, SmallVector<std.pairUIntType<Decl /*P*/ >> /*P*/>(DenseMapInfoFileID.$Info(), (SmallVector<std.pairUIntType<Decl /*P*/ >> /*P*/)null);
    this.OriginalSourceFile = new std.string();
    this.PreambleDiagnostics = new SmallVector<StandaloneDiagnostic>(4, new StandaloneDiagnostic());
    this.StoredDiagnostics = new SmallVector<StoredDiagnostic>(4, new StoredDiagnostic());
    this.FailedParseDiagnostics = new SmallVector<StoredDiagnostic>(4, new StoredDiagnostic());
    this.NumStoredDiagnosticsFromDriver = 0;
    this.PreambleRebuildCounter = 0;
    this.Preamble = new PreambleData();
    this.FilesInPreamble = new StringMap<PreambleFileHash>(new PreambleFileHash());
    this.SavedMainFileBuffer = new std.unique_ptr<MemoryBuffer>();
    this.PreambleBuffer = new std.unique_ptr<MemoryBuffer>();
    this.NumWarningsInPreamble = 0;
    this.TopLevelDeclsInPreamble = new std.vectorUInt();
    this.ShouldCacheCodeCompletionResults = false;
    this.IncludeBriefCommentsInCodeCompletion = false;
    this.UserFilesAreVolatile = false;
    this.ASTFileLangOpts = new LangOptions();
    this.CachedCompletionAllocator = new IntrusiveRefCntPtr<GlobalCodeCompletionAllocator>();
    this.CCTUInfo = new std.unique_ptr<CodeCompletionTUInfo>();
    this.CachedCompletionResults = new std.vector<CachedCodeCompletionResult>(new CachedCodeCompletionResult());
    this.CachedCompletionTypes = new StringMapUInt(0);
    this.CompletionCacheTopLevelHashValue = 0;
    this.PreambleTopLevelHashValue = 0;
    this.CurrentTopLevelHashValue = 0;
    this.UnsafeToFree = false;
    this.ConcurrencyCheckValue = new ConcurrencyState();
    //END JInit
    if ((getenv($("LIBCLANG_OBJTRACKING")) != null)) {
      fprintf(stderr, /*KEEP_STR*/"+++ %u translation units\n", ActiveASTUnitObjects.$preInc());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::CleanTemporaryFiles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 196,
   FQN="clang::ASTUnit::CleanTemporaryFiles", NM="_ZN5clang7ASTUnit19CleanTemporaryFilesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit19CleanTemporaryFilesEv")
  //</editor-fold>
  private void CleanTemporaryFiles() {
    getOnDiskData(this).CleanTemporaryFiles();
  }

  
  /// Parse the source file into a translation unit using the given compiler
  /// invocation, replacing the current translation unit.
  ///
  /// \returns True if a failure occurred that causes the ASTUnit not to
  /// contain any translation-unit information, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::Parse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*goto*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1035,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1034,
   FQN="clang::ASTUnit::Parse", NM="_ZN5clang7ASTUnit5ParseESt10shared_ptrINS_22PCHContainerOperationsEESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS6_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit5ParseESt10shared_ptrINS_22PCHContainerOperationsEESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS6_EE")
  //</editor-fold>
  private boolean Parse(std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
       std.unique_ptr<MemoryBuffer> OverrideMainBuffer) {
    std.unique_ptr<CompilerInstance> Clang = null;
    CrashRecoveryContextCleanupRegistrar<CompilerInstance> CICleanup = null;
    IntrusiveRefCntPtr<CompilerInvocation> CCInvocation = null;
    std.unique_ptr<TopLevelDeclTrackerAction> Act = null;
    CrashRecoveryContextCleanupRegistrar<TopLevelDeclTrackerAction> ActCleanup = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SavedMainFileBuffer.reset();
      if (!Invocation.$bool()) {
        return true;
      }
      
      // Create the compiler instance to use for building the AST.
      Clang/*J*/= $c$.clean(new std.unique_ptr<CompilerInstance>(new CompilerInstance($c$.track(new std.shared_ptr<PCHContainerOperations>(JD$Move.INSTANCE, std.move(PCHContainerOps))))));
      
      // Recover resources if we crash before exiting this method.
      CICleanup/*J*/= new CrashRecoveryContextCleanupRegistrar<CompilerInstance>(Clang.get());
      
      CCInvocation/*J*/= new IntrusiveRefCntPtr<CompilerInvocation>(new CompilerInvocation(Invocation.$star()));
      
      Clang.$arrow().setInvocation(CCInvocation.get());
      OriginalSourceFile.$assignMove(Clang.$arrow().getFrontendOpts().Inputs.$at(0).getFile().$string());
      
      // Set up diagnostics, capturing any diagnostics that would
      // otherwise be dropped.
      Clang.$arrow().setDiagnostics(/*AddrOf*/getDiagnostics());
      
      // Create the target instance.
      Clang.$arrow().setTarget(TargetInfo.CreateTargetInfo(Clang.$arrow().getDiagnostics(), Clang.$arrow().getInvocation().TargetOpts));
      if (!Clang.$arrow().hasTarget()) {
        return true;
      }
      
      // Inform the target of the language options.
      //
      // FIXME: We shouldn't need to do this, the target should be immutable once
      // created. This complexity should be lifted elsewhere.
      Clang.$arrow().getTarget().adjust(Clang.$arrow().getLangOpts());
      assert (Clang.$arrow().getFrontendOpts().Inputs.size() == 1) : "Invocation must have exactly one source file!";
      assert (Clang.$arrow().getFrontendOpts().Inputs.$at(0).getKind() != InputKind.IK_AST) : "FIXME: AST inputs not yet supported here!";
      assert (Clang.$arrow().getFrontendOpts().Inputs.$at(0).getKind() != InputKind.IK_LLVM_IR) : "IR inputs not support here!";
      
      // Configure the various subsystems.
      LangOpts.$assign(Clang.$arrow().getInvocation().LangOpts);
      FileSystemOpts.$assign(Clang.$arrow().getFileSystemOpts());
      if (!FileMgr.$bool()) {
        Clang.$arrow().createFileManager();
        $c$.clean(FileMgr.$assign($c$.track(new IntrusiveRefCntPtr<FileManager>(/*AddrOf*/Clang.$arrow().getFileManager()))));
      }
      $c$.clean(SourceMgr.$assign($c$.track(new IntrusiveRefCntPtr<SourceManager>(new SourceManager(getDiagnostics(), FileMgr.$star(), 
                  UserFilesAreVolatile)))));
      TheSema.reset();
      $c$.clean(Ctx.$assign($c$.track(new IntrusiveRefCntPtr<ASTContext>((ASTContext /*P*/ )null))));
      $c$.clean(PP.$assign($c$.track(new IntrusiveRefCntPtr<Preprocessor>((Preprocessor /*P*/ )null))));
      $c$.clean(Reader.$assign($c$.track(new IntrusiveRefCntPtr<ASTReader>((ASTReader /*P*/ )null))));
      
      // Clear out old caches and data.
      TopLevelDecls.clear();
      clearFileLevelDecls();
      CleanTemporaryFiles();
      if (!OverrideMainBuffer.$bool()) {
        checkAndRemoveNonDriverDiags(StoredDiagnostics);
        TopLevelDeclsInPreamble.clear();
      }
      
      // Create a file manager object to provide access to and cache the filesystem.
      Clang.$arrow().setFileManager(/*AddrOf*/getFileManager());
      
      // Create the source manager.
      Clang.$arrow().setSourceManager(/*AddrOf*/getSourceManager());
      
      // If the main file has been overridden due to the use of a preamble,
      // make that override happen and introduce the preamble.
      PreprocessorOptions /*&*/ PreprocessorOpts = Clang.$arrow().getPreprocessorOpts();
      if (OverrideMainBuffer.$bool()) {
        PreprocessorOpts.addRemappedFile(new StringRef(OriginalSourceFile), 
            OverrideMainBuffer.get());
        PreprocessorOpts.PrecompiledPreambleBytes.first = Preamble.size();
        PreprocessorOpts.PrecompiledPreambleBytes.second
           = PreambleEndsAtStartOfLine;
        PreprocessorOpts.ImplicitPCHInclude.$assign(getPreambleFile(this));
        PreprocessorOpts.DisablePCHValidation = true;
        
        // The stored diagnostic has the old source manager in it; update
        // the locations to refer into the new source manager. Since we've
        // been careful to make sure that the source manager's state
        // before and after are identical, so that we can reuse the source
        // location itself.
        checkAndSanitizeDiags(StoredDiagnostics, getSourceManager());
        
        // Keep track of the override buffer;
        SavedMainFileBuffer.$assignMove(std.move(OverrideMainBuffer));
      }
      
      Act/*J*/= new std.unique_ptr<TopLevelDeclTrackerAction>(new TopLevelDeclTrackerAction(/*Deref*/this));
    LOOP: while (true) { // JAVA: loop for goto  
      // Recover resources if we crash before exiting this method.
      ActCleanup/*J*/= new CrashRecoveryContextCleanupRegistrar<TopLevelDeclTrackerAction>(Act.get());
      if (!Act.$arrow().BeginSourceFile(/*Deref*/Clang.get(), Clang.$arrow().getFrontendOpts().Inputs.$at(0))) {
        /*JAVA*/break LOOP;//goto error;
      }
      if (SavedMainFileBuffer.$bool()) {
        TranslateStoredDiagnostics(getFileManager(), getSourceManager(), 
            PreambleDiagnostics, StoredDiagnostics);
      }
      if (!Act.$arrow().Execute()) {
        /*JAVA*/break LOOP;//goto error;
      }
      
      transferASTDataFromCompilerInstance(Clang.$star());
      
      Act.$arrow().EndSourceFile();
      
      FailedParseDiagnostics.clear();
      
      return false;
     } // loop
     error:
      // Remove the overridden buffer we used for the preamble.
      SavedMainFileBuffer.$assign_nullptr_t(null);
      
      // Keep the ownership of the data in the ASTUnit because the client may
      // want to see the diagnostics.
      transferASTDataFromCompilerInstance(Clang.$star());
      FailedParseDiagnostics.swap(StoredDiagnostics);
      StoredDiagnostics.clear();
      NumStoredDiagnosticsFromDriver = 0;
      return true;
    } finally {
      if (ActCleanup != null) { ActCleanup.$destroy(); }
      if (Act != null) { Act.$destroy(); }
      if (CCInvocation != null) { CCInvocation.$destroy(); }
      if (CICleanup != null) { CICleanup.$destroy(); }
      if (Clang != null) { Clang.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ComputedPreamble">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 430,
   FQN="clang::ASTUnit::ComputedPreamble", NM="_ZN5clang7ASTUnit16ComputedPreambleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16ComputedPreambleE")
  //</editor-fold>
  private static class/*struct*/ ComputedPreamble implements Destructors.ClassWithDestructor {
    public MemoryBuffer /*P*/ Buffer;
    public std.unique_ptr<MemoryBuffer> Owner;
    public /*uint*/int Size;
    public boolean PreambleEndsAtStartOfLine;
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ComputedPreamble::ComputedPreamble">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 435,
     FQN="clang::ASTUnit::ComputedPreamble::ComputedPreamble", NM="_ZN5clang7ASTUnit16ComputedPreambleC1EPN4llvm12MemoryBufferESt10unique_ptrIS3_St14default_deleteIS3_EEjb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16ComputedPreambleC1EPN4llvm12MemoryBufferESt10unique_ptrIS3_St14default_deleteIS3_EEjb")
    //</editor-fold>
    public ComputedPreamble(MemoryBuffer /*P*/ Buffer, 
        std.unique_ptr<MemoryBuffer> Owner, /*uint*/int Size, 
        boolean PreambleEndsAtStartOfLine) {
      // : Buffer(Buffer), Owner(std::move(Owner)), Size(Size), PreambleEndsAtStartOfLine(PreambleEndsAtStartOfLine) 
      //START JInit
      this.Buffer = Buffer;
      this.Owner = new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(Owner));
      this.Size = Size;
      this.PreambleEndsAtStartOfLine = PreambleEndsAtStartOfLine;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ComputedPreamble::ComputedPreamble">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 440,
     FQN="clang::ASTUnit::ComputedPreamble::ComputedPreamble", NM="_ZN5clang7ASTUnit16ComputedPreambleC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16ComputedPreambleC1EOS1_")
    //</editor-fold>
    public ComputedPreamble(JD$Move _dparam, ComputedPreamble /*&&*/C) {
      // : Buffer(C.Buffer), Owner(std::move(C.Owner)), Size(C.Size), PreambleEndsAtStartOfLine(C.PreambleEndsAtStartOfLine) 
      //START JInit
      this.Buffer = C.Buffer;
      this.Owner = new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(C.Owner));
      this.Size = C.Size;
      this.PreambleEndsAtStartOfLine = C.PreambleEndsAtStartOfLine;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ComputedPreamble::~ComputedPreamble">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 430,
     FQN="clang::ASTUnit::ComputedPreamble::~ComputedPreamble", NM="_ZN5clang7ASTUnit16ComputedPreambleD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16ComputedPreambleD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Owner.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Buffer=" + Buffer // NOI18N
                + ", Owner=" + Owner // NOI18N
                + ", Size=" + Size // NOI18N
                + ", PreambleEndsAtStartOfLine=" + PreambleEndsAtStartOfLine; // NOI18N
    }
  };
  
  /// \brief Compute the preamble for the main file, providing the source buffer
  /// that corresponds to the main file along with a pair (bytes, start-of-line)
  /// that describes the preamble.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ComputePreamble">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1188,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1189,
   FQN="clang::ASTUnit::ComputePreamble", NM="_ZN5clang7ASTUnit15ComputePreambleERNS_18CompilerInvocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit15ComputePreambleERNS_18CompilerInvocationEj")
  //</editor-fold>
  private ASTUnit.ComputedPreamble ComputePreamble(CompilerInvocation /*&*/ Invocation, /*uint*/int MaxLines) {
    std.unique_ptr<MemoryBuffer> BufferOwner = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      FrontendOptions /*&*/ FrontendOpts = Invocation.getFrontendOpts();
      PreprocessorOptions /*&*/ PreprocessorOpts = Invocation.getPreprocessorOpts();
      
      // Try to determine if the main file has been remapped, either from the 
      // command line (to another file) or directly through the compiler invocation
      // (to a memory buffer).
      MemoryBuffer /*P*/ Buffer = null;
      BufferOwner/*J*/= new std.unique_ptr<MemoryBuffer>();
      std.string MainFilePath/*J*/= FrontendOpts.Inputs.$at(0).getFile().$string();
      fs.UniqueID MainFileID/*J*/= new fs.UniqueID();
      if (!fs.getUniqueID(new Twine(MainFilePath), MainFileID).$bool()) {
        // Check whether there is a file-file remapping of the main file
        for (/*const*/ pair<std.string, std.string> /*&*/ RF : PreprocessorOpts.RemappedFiles) {
          std.string MPath/*J*/= new std.string(RF.first);
          fs.UniqueID MID/*J*/= new fs.UniqueID();
          if (!fs.getUniqueID(new Twine(MPath), MID).$bool()) {
            if (MainFileID.$eq(MID)) {
              // We found a remapping. Try to load the resulting, remapped source.
              $c$.clean(BufferOwner.$assignMove($c$.track(getBufferForFile(new StringRef(RF.second)))));
              if (!BufferOwner.$bool()) {
                return $c$.clean(new ComputedPreamble((MemoryBuffer /*P*/ )null, $c$.track(new std.unique_ptr<MemoryBuffer>(JD$NullPtr.INSTANCE, null)), 0, true));
              }
            }
          }
        }
        
        // Check whether there is a file-buffer remapping. It supercedes the
        // file-file remapping.
        for (/*const*/ pair<std.string, MemoryBuffer /*P*/ > /*&*/ RB : PreprocessorOpts.RemappedFileBuffers) {
          std.string MPath/*J*/= new std.string(RB.first);
          fs.UniqueID MID/*J*/= new fs.UniqueID();
          if (!fs.getUniqueID(new Twine(MPath), MID).$bool()) {
            if (MainFileID.$eq(MID)) {
              // We found a remapping.
              BufferOwner.reset();
              Buffer = ((/*const_cast*/MemoryBuffer /*P*/ )(RB.second));
            }
          }
        }
      }
      
      // If the main source file was not remapped, load it now.
      if (!(Buffer != null) && !BufferOwner.$bool()) {
        $c$.clean(BufferOwner.$assignMove($c$.track(getBufferForFile(FrontendOpts.Inputs.$at(0).getFile()))));
        if (!BufferOwner.$bool()) {
          return $c$.clean(new ComputedPreamble((MemoryBuffer /*P*/ )null, $c$.track(new std.unique_ptr<MemoryBuffer>(JD$NullPtr.INSTANCE, null)), 0, true));
        }
      }
      if (!(Buffer != null)) {
        Buffer = BufferOwner.get();
      }
      std.pairUIntBool Pre = Lexer.ComputePreamble(Buffer.getBuffer(), 
          /*Deref*/Invocation.getLangOpts(), MaxLines);
      return $c$.clean(new ComputedPreamble(Buffer, $c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(BufferOwner))), Pre.first, 
          Pre.second));
    } finally {
      if (BufferOwner != null) { BufferOwner.$destroy(); }
      $c$.$destroy();
    }
  }

  
  
  /// \brief Attempt to build or re-use a precompiled preamble when (re-)parsing
  /// the source file.
  ///
  /// This routine will compute the preamble of the main source file. If a
  /// non-trivial preamble is found, it will precompile that preamble into a 
  /// precompiled header so that the precompiled preamble can be used to reduce
  /// reparsing time. If a precompiled preamble has already been constructed,
  /// this routine will determine if it is still valid and, if so, avoid 
  /// rebuilding the precompiled preamble.
  ///
  /// \param AllowRebuild When true (the default), this routine is
  /// allowed to rebuild the precompiled preamble if it is found to be
  /// out-of-date.
  ///
  /// \param MaxLines When non-zero, the maximum number of lines that
  /// can occur within the preamble.
  ///
  /// \returns If the precompiled preamble can be used, returns a newly-allocated
  /// buffer that should be used in place of the main file when doing so.
  /// Otherwise, returns a NULL pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getMainBufferWithPrecompiledPreamble">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1340,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1341,
   FQN="clang::ASTUnit::getMainBufferWithPrecompiledPreamble", NM="_ZN5clang7ASTUnit36getMainBufferWithPrecompiledPreambleESt10shared_ptrINS_22PCHContainerOperationsEERKNS_18CompilerInvocationEbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit36getMainBufferWithPrecompiledPreambleESt10shared_ptrINS_22PCHContainerOperationsEERKNS_18CompilerInvocationEbj")
  //</editor-fold>
  private std.unique_ptr<MemoryBuffer> getMainBufferWithPrecompiledPreamble(std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                                      /*const*/ CompilerInvocation /*&*/ PreambleInvocationIn) {
    return getMainBufferWithPrecompiledPreamble(PCHContainerOps, 
                                      PreambleInvocationIn, true, 
                                      0);
  }
  private std.unique_ptr<MemoryBuffer> getMainBufferWithPrecompiledPreamble(std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                                      /*const*/ CompilerInvocation /*&*/ PreambleInvocationIn, boolean AllowRebuild/*= true*/) {
    return getMainBufferWithPrecompiledPreamble(PCHContainerOps, 
                                      PreambleInvocationIn, AllowRebuild, 
                                      0);
  }
  private std.unique_ptr<MemoryBuffer> getMainBufferWithPrecompiledPreamble(std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                                      /*const*/ CompilerInvocation /*&*/ PreambleInvocationIn, boolean AllowRebuild/*= true*/, 
                                      /*uint*/int MaxLines/*= 0*/) {
    IntrusiveRefCntPtr<CompilerInvocation> PreambleInvocation = null;
    ComputedPreamble NewPreamble = null;
    SimpleTimer PreambleTimer = null;
    std.unique_ptr<CompilerInstance> Clang = null;
    CrashRecoveryContextCleanupRegistrar<CompilerInstance> CICleanup = null;
    IntrusiveRefCntPtr<FileSystem> VFS = null;
    shared_ptr<DependencyCollector> PreambleDepCollector = null;
    std.unique_ptr<PrecompilePreambleAction> Act = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      PreambleInvocation/*J*/= new IntrusiveRefCntPtr<CompilerInvocation>(new CompilerInvocation(PreambleInvocationIn));
      FrontendOptions /*&*/ FrontendOpts = PreambleInvocation.$arrow().getFrontendOpts();
      PreprocessorOptions /*&*/ PreprocessorOpts = PreambleInvocation.$arrow().getPreprocessorOpts();
      
      NewPreamble = ComputePreamble(PreambleInvocation.$star(), MaxLines);
      if (!(NewPreamble.Size != 0)) {
        // We couldn't find a preamble in the main source. Clear out the current
        // preamble, if we have one. It's obviously no good any more.
        Preamble.clear();
        erasePreambleFile(this);
        
        // The next time we actually see a preamble, precompile it.
        PreambleRebuildCounter = 1;
        return new std.unique_ptr<MemoryBuffer>(JD$NullPtr.INSTANCE, null);
      }
      if (!Preamble.empty()) {
        // We've previously computed a preamble. Check whether we have the same
        // preamble now that we did before, and that there's enough space in
        // the main-file buffer within the precompiled preamble to fit the
        // new main file.
        if (Preamble.size() == NewPreamble.Size
           && PreambleEndsAtStartOfLine == NewPreamble.PreambleEndsAtStartOfLine
           && memcmp(Preamble.getBufferStart(), NewPreamble.Buffer.getBufferStart(), 
            NewPreamble.Size) == 0) {
          std.mapTypeType<fs.UniqueID, PreambleFileHash> OverriddenFiles = null;
          try {
            // The preamble has not changed. We may be able to re-use the precompiled
            // preamble.
            
            // Check that none of the files used by the preamble have changed.
            boolean AnyFileChanged = false;
            
            // First, make a record of those files that have been overridden via
            // remapping or unsaved_files.
            OverriddenFiles/*J*/= new std.mapTypeType<fs.UniqueID, PreambleFileHash>(fs.UniqueID.COMPARATOR, new PreambleFileHash());
            for (/*const*/ pair<std.string, std.string> /*&*/ R : PreprocessorOpts.RemappedFiles) {
              if (AnyFileChanged) {
                break;
              }
              
              Status Status/*J*/= new Status();
              if (FileMgr.$arrow().getNoncachedStatValue(new StringRef(R.second), Status)) {
                // If we can't stat the file we're remapping to, assume that something
                // horrible happened.
                AnyFileChanged = true;
                break;
              }
              
              OverriddenFiles.$at_T$RR(Status.getUniqueID()).$assignMove(PreambleFileHash.createForFile($ulong2long(Status.getSize()), $ulong2long(Status.getLastModificationTime().toEpochTime())));
            }
            
            for (/*const*/ pair<std.string, MemoryBuffer /*P*/ > /*&*/ RB : PreprocessorOpts.RemappedFileBuffers) {
              if (AnyFileChanged) {
                break;
              }
              
              Status Status/*J*/= new Status();
              if (FileMgr.$arrow().getNoncachedStatValue(new StringRef(RB.first), Status)) {
                AnyFileChanged = true;
                break;
              }
              
              OverriddenFiles.$at_T$RR(Status.getUniqueID()).$assignMove(
                  PreambleFileHash.createForMemoryBuffer(RB.second)
              );
            }
            
            // Check whether anything has changed.
            for (StringMapIterator<PreambleFileHash> F = $tryClone(FilesInPreamble.begin()), FEnd = FilesInPreamble.end();
                 !AnyFileChanged && F.$noteq(FEnd);
                 F.$preInc()) {
              Status Status/*J*/= new Status();
              if (FileMgr.$arrow().getNoncachedStatValue(F.$arrow().first(), Status)) {
                // If we can't stat the file, assume that something horrible happened.
                AnyFileChanged = true;
                break;
              }
              
              std.mapTypeType.iterator</*const*/ fs.UniqueID, PreambleFileHash> Overridden = OverriddenFiles.find(Status.getUniqueID());
              if (Overridden.$noteq(OverriddenFiles.end())) {
                // This file was remapped; check whether the newly-mapped file 
                // matches up with the previous mapping.
                if ($noteq_PreambleFileHash$C(Overridden.$arrow().second, F.$arrow().second)) {
                  AnyFileChanged = true;
                }
                continue;
              }
              
              // The file was not remapped; check whether it has changed on disk.
              if (Status.getSize() != ((long/*uint64_t*/)($long2ulong(F.$arrow().second.Size)))
                 || Status.getLastModificationTime().toEpochTime()
                 != ((long/*uint64_t*/)($long2ulong(F.$arrow().second.ModTime)))) {
                AnyFileChanged = true;
              }
            }
            if (!AnyFileChanged) {
              // Okay! We can re-use the precompiled preamble.
              
              // Set the state of the diagnostic object to mimic its state
              // after parsing the preamble.
              getDiagnostics().Reset();
              ProcessWarningOptions(getDiagnostics(), 
                  PreambleInvocation.$arrow().getDiagnosticOpts());
              getDiagnostics().setNumWarnings(NumWarningsInPreamble);
              
              return MemoryBuffer.getMemBufferCopy(NewPreamble.Buffer.getBuffer(), new Twine(FrontendOpts.Inputs.$at(0).getFile()));
            }
          } finally {
            if (OverriddenFiles != null) { OverriddenFiles.$destroy(); }
          }
        }
        
        // If we aren't allowed to rebuild the precompiled preamble, just
        // return now.
        if (!AllowRebuild) {
          return new std.unique_ptr<MemoryBuffer>(JD$NullPtr.INSTANCE, null);
        }
        
        // We can't reuse the previously-computed preamble. Build a new one.
        Preamble.clear();
        PreambleDiagnostics.clear();
        erasePreambleFile(this);
        PreambleRebuildCounter = 1;
      } else if (!AllowRebuild) {
        // We aren't allowed to rebuild the precompiled preamble; just
        // return now.
        return new std.unique_ptr<MemoryBuffer>(JD$NullPtr.INSTANCE, null);
      }
      
      // If the preamble rebuild counter > 1, it's because we previously
      // failed to build a preamble and we're not yet ready to try
      // again. Decrement the counter and return a failure.
      if ($greater_uint(PreambleRebuildCounter, 1)) {
        --PreambleRebuildCounter;
        return new std.unique_ptr<MemoryBuffer>(JD$NullPtr.INSTANCE, null);
      }
      
      // Create a temporary file for the precompiled preamble. In rare 
      // circumstances, this can fail.
      std.string PreamblePCHPath = GetPreamblePCHPath();
      if (PreamblePCHPath.empty()) {
        // Try again next time.
        PreambleRebuildCounter = 1;
        return new std.unique_ptr<MemoryBuffer>(JD$NullPtr.INSTANCE, null);
      }
      
      // We did not previously compute a preamble, or it can't be reused anyway.
      PreambleTimer/*J*/= new SimpleTimer(WantTiming);
      PreambleTimer.setOutput(new Twine(/*KEEP_STR*/"Precompiling preamble"));
      
      // Save the preamble text for later; we'll need to compare against it for
      // subsequent reparses.
      StringRef MainFilename = FrontendOpts.Inputs.$at(0).getFile();
      Preamble.assign(FileMgr.$arrow().getFile(/*NO_COPY*/MainFilename), 
          NewPreamble.Buffer.getBufferStart(), 
          NewPreamble.Buffer.getBufferStart().$add(NewPreamble.Size));
      PreambleEndsAtStartOfLine = NewPreamble.PreambleEndsAtStartOfLine;
      
      $c$.clean(PreambleBuffer.$assignMove($c$.track(MemoryBuffer.getMemBufferCopy(NewPreamble.Buffer.getBuffer().slice(0, Preamble.size()), new Twine(MainFilename)))));
      
      // Remap the main source file to the preamble buffer.
      StringRef MainFilePath = FrontendOpts.Inputs.$at(0).getFile();
      PreprocessorOpts.addRemappedFile(new StringRef(MainFilePath), PreambleBuffer.get());
      
      // Tell the compiler invocation to generate a temporary precompiled header.
      FrontendOpts.ProgramAction = frontend.ActionKind.GeneratePCH;
      // FIXME: Generate the precompiled header into memory?
      FrontendOpts.OutputFile.$assign(PreamblePCHPath);
      PreprocessorOpts.PrecompiledPreambleBytes.first = 0;
      PreprocessorOpts.PrecompiledPreambleBytes.second = false;
      
      // Create the compiler instance to use for building the precompiled preamble.
      Clang/*J*/= $c$.clean(new std.unique_ptr<CompilerInstance>(new CompilerInstance($c$.track(new std.shared_ptr<PCHContainerOperations>(JD$Move.INSTANCE, std.move(PCHContainerOps))))));
      
      // Recover resources if we crash before exiting this method.
      CICleanup/*J*/= new CrashRecoveryContextCleanupRegistrar<CompilerInstance>(Clang.get());
      
      Clang.$arrow().setInvocation(/*AddrOf*/PreambleInvocation.$star());
      OriginalSourceFile.$assignMove(Clang.$arrow().getFrontendOpts().Inputs.$at(0).getFile().$string());
      
      // Set up diagnostics, capturing all of the diagnostics produced.
      Clang.$arrow().setDiagnostics(/*AddrOf*/getDiagnostics());
      
      // Create the target instance.
      Clang.$arrow().setTarget(TargetInfo.CreateTargetInfo(Clang.$arrow().getDiagnostics(), Clang.$arrow().getInvocation().TargetOpts));
      if (!Clang.$arrow().hasTarget()) {
        fs.remove(new Twine(FrontendOpts.OutputFile));
        Preamble.clear();
        PreambleRebuildCounter = DefaultPreambleRebuildInterval;
        PreprocessorOpts.RemappedFileBuffers.pop_back();
        return new std.unique_ptr<MemoryBuffer>(JD$NullPtr.INSTANCE, null);
      }
      
      // Inform the target of the language options.
      //
      // FIXME: We shouldn't need to do this, the target should be immutable once
      // created. This complexity should be lifted elsewhere.
      Clang.$arrow().getTarget().adjust(Clang.$arrow().getLangOpts());
      assert (Clang.$arrow().getFrontendOpts().Inputs.size() == 1) : "Invocation must have exactly one source file!";
      assert (Clang.$arrow().getFrontendOpts().Inputs.$at(0).getKind() != InputKind.IK_AST) : "FIXME: AST inputs not yet supported here!";
      assert (Clang.$arrow().getFrontendOpts().Inputs.$at(0).getKind() != InputKind.IK_LLVM_IR) : "IR inputs not support here!";
      
      // Clear out old caches and data.
      getDiagnostics().Reset();
      ProcessWarningOptions(getDiagnostics(), Clang.$arrow().getDiagnosticOpts());
      checkAndRemoveNonDriverDiags(StoredDiagnostics);
      TopLevelDecls.clear();
      TopLevelDeclsInPreamble.clear();
      PreambleDiagnostics.clear();
      
      VFS = createVFSFromCompilerInvocation(Clang.$arrow().getInvocation(), getDiagnostics());
      if (!VFS.$bool()) {
        return new std.unique_ptr<MemoryBuffer>(JD$NullPtr.INSTANCE, null);
      }
      
      // Create a file manager object to provide access to and cache the filesystem.
      Clang.$arrow().setFileManager(new FileManager(Clang.$arrow().getFileSystemOpts(), $c$.track(new IntrusiveRefCntPtr<FileSystem>(VFS)))); $c$.clean();
      
      // Create the source manager.
      Clang.$arrow().setSourceManager(new SourceManager(getDiagnostics(), 
              Clang.$arrow().getFileManager()));
      
      PreambleDepCollector = std.make_shared(new DependencyCollector());
      Clang.$arrow().addDependencyCollector($c$.track(new std.shared_ptr<DependencyCollector>(PreambleDepCollector))); $c$.clean();
      
      Act/*J*/= new std.unique_ptr<PrecompilePreambleAction>();
      Act.reset(new PrecompilePreambleAction(/*Deref*/this));
      if (!Act.$arrow().BeginSourceFile(/*Deref*/Clang.get(), Clang.$arrow().getFrontendOpts().Inputs.$at(0))) {
        fs.remove(new Twine(FrontendOpts.OutputFile));
        Preamble.clear();
        PreambleRebuildCounter = DefaultPreambleRebuildInterval;
        PreprocessorOpts.RemappedFileBuffers.pop_back();
        return new std.unique_ptr<MemoryBuffer>(JD$NullPtr.INSTANCE, null);
      }
      
      Act.$arrow().Execute();
      
      // Transfer any diagnostics generated when parsing the preamble into the set
      // of preamble diagnostics.
      for (type$ptr<StoredDiagnostic> I = $tryClone(stored_diag_afterDriver_begin()), 
          /*P*/ E = $tryClone(stored_diag_end());
           $noteq_ptr(I, E); I.$preInc())  {
        PreambleDiagnostics.push_back_T$RR($c$.track(makeStandaloneDiagnostic(Clang.$arrow().getLangOpts(), I.$star()))); $c$.clean();
      }
      
      Act.$arrow().EndSourceFile();
      
      checkAndRemoveNonDriverDiags(StoredDiagnostics);
      if (!Act.$arrow().hasEmittedPreamblePCH()) {
        // The preamble PCH failed (e.g. there was a module loading fatal error),
        // so no precompiled header was generated. Forget that we even tried.
        // FIXME: Should we leave a note for ourselves to try again?
        fs.remove(new Twine(FrontendOpts.OutputFile));
        Preamble.clear();
        TopLevelDeclsInPreamble.clear();
        PreambleRebuildCounter = DefaultPreambleRebuildInterval;
        PreprocessorOpts.RemappedFileBuffers.pop_back();
        return new std.unique_ptr<MemoryBuffer>(JD$NullPtr.INSTANCE, null);
      }
      
      // Keep track of the preamble we precompiled.
      setPreambleFile(this, new StringRef(FrontendOpts.OutputFile));
      NumWarningsInPreamble = getDiagnostics().getNumWarnings();
      
      // Keep track of all of the files that the source manager knows about,
      // so we can verify whether they have changed or not.
      FilesInPreamble.clear();
      SourceManager /*&*/ SourceMgr = Clang.$arrow().getSourceManager();
      for (/*const*/std.string/*&*/ Filename : PreambleDepCollector.$arrow().getDependencies()) {
        /*const*/ FileEntry /*P*/ File = Clang.$arrow().getFileManager().getFile(new StringRef(Filename));
        if (!(File != null) || File == SourceMgr.getFileEntryForID(SourceMgr.getMainFileID())) {
          continue;
        }
        {
          long/*time_t*/ ModTime = File.getModificationTime();
          if ((ModTime != 0)) {
            FilesInPreamble.$at(/*STRINGREF_STR*/File.getName()).$assignMove(PreambleFileHash.createForFile(File.getSize(), ModTime));
          } else {
            MemoryBuffer /*P*/ Buffer = SourceMgr.getMemoryBufferForFile(File);
            FilesInPreamble.$at(/*STRINGREF_STR*/File.getName()).$assignMove(
                PreambleFileHash.createForMemoryBuffer(Buffer)
            );
          }
        }
      }
      
      PreambleRebuildCounter = 1;
      PreprocessorOpts.RemappedFileBuffers.pop_back();
      
      // If the hash of top-level entities differs from the hash of the top-level
      // entities the last time we rebuilt the preamble, clear out the completion
      // cache.
      if (CurrentTopLevelHashValue != PreambleTopLevelHashValue) {
        CompletionCacheTopLevelHashValue = 0;
        PreambleTopLevelHashValue = CurrentTopLevelHashValue;
      }
      
      return MemoryBuffer.getMemBufferCopy(NewPreamble.Buffer.getBuffer(), 
          new Twine(MainFilename));
    } finally {
      if (Act != null) { Act.$destroy(); }
      if (PreambleDepCollector != null) { PreambleDepCollector.$destroy(); }
      if (VFS != null) { VFS.$destroy(); }
      if (CICleanup != null) { CICleanup.$destroy(); }
      if (Clang != null) { Clang.$destroy(); }
      if (PreambleTimer != null) { PreambleTimer.$destroy(); }
      if (NewPreamble != null) { NewPreamble.$destroy(); }
      if (PreambleInvocation != null) { PreambleInvocation.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::RealizeTopLevelDeclsFromPreamble">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1650,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1641,
   FQN="clang::ASTUnit::RealizeTopLevelDeclsFromPreamble", NM="_ZN5clang7ASTUnit32RealizeTopLevelDeclsFromPreambleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit32RealizeTopLevelDeclsFromPreambleEv")
  //</editor-fold>
  private void RealizeTopLevelDeclsFromPreamble() {
    std.vector<Decl /*P*/ > Resolved = null;
    try {
      Resolved/*J*/= new std.vector<Decl /*P*/ >((Decl /*P*/ )null);
      Resolved.reserve(TopLevelDeclsInPreamble.size());
      final ExternalASTSource /*&*/ Source = /*Deref*/getASTContext().getExternalSource();
      for (/*uint32_t*/int TopLevelDecl : TopLevelDeclsInPreamble) {
        {
          // Resolve the declaration ID to an actual declaration, possibly
          // deserializing the declaration in the process.
          Decl /*P*/ D = Source.GetExternalDecl(TopLevelDecl);
          if ((D != null)) {
            Resolved.push_back_T$C$R(D);
          }
        }
      }
      TopLevelDeclsInPreamble.clear();
      TopLevelDecls.insert$T((TopLevelDecls.begin()), Resolved.begin(), Resolved.end());
    } finally {
      if (Resolved != null) { Resolved.$destroy(); }
    }
  }

  
  /// \brief Transfers ownership of the objects (like SourceManager) from
  /// \param CI to this ASTUnit.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::transferASTDataFromCompilerInstance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1664,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1655,
   FQN="clang::ASTUnit::transferASTDataFromCompilerInstance", NM="_ZN5clang7ASTUnit35transferASTDataFromCompilerInstanceERNS_16CompilerInstanceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit35transferASTDataFromCompilerInstanceERNS_16CompilerInstanceE")
  //</editor-fold>
  private void transferASTDataFromCompilerInstance(CompilerInstance /*&*/ CI) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Steal the created target, context, and preprocessor if they have been
      // created.
      assert (CI.hasInvocation()) : "missing invocation";
      LangOpts.$assign(CI.getInvocation().LangOpts);
      $c$.clean(TheSema.$assignMove($c$.track(CI.takeSema())));
      $c$.clean(Consumer.$assignMove($c$.track(CI.takeASTConsumer())));
      if (CI.hasASTContext()) {
        $c$.clean(Ctx.$assign($c$.track(new IntrusiveRefCntPtr<ASTContext>(/*AddrOf*/CI.getASTContext()))));
      }
      if (CI.hasPreprocessor()) {
        $c$.clean(PP.$assign($c$.track(new IntrusiveRefCntPtr<Preprocessor>(/*AddrOf*/CI.getPreprocessor()))));
      }
      CI.setSourceManager((SourceManager /*P*/ )null);
      CI.setFileManager((FileManager /*P*/ )null);
      if (CI.hasTarget()) {
        $c$.clean(Target.$assign($c$.track(new IntrusiveRefCntPtr<TargetInfo>(/*AddrOf*/CI.getTarget()))));
      }
      $c$.clean(Reader.$assign($c$.track(CI.getModuleManager())));
      HadModuleLoaderFatalFailure = CI.hadModuleLoaderFatalFailure();
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Allows us to assert that ASTUnit is not being used concurrently,
  /// which is not supported.
  ///
  /// Clients should create instances of the ConcurrencyCheck class whenever
  /// using the ASTUnit in a way that isn't intended to be concurrent, which is
  /// just about any usage.
  /// Becomes a noop in release mode; only useful for debug mode checking.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ConcurrencyState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 464,
   FQN="clang::ASTUnit::ConcurrencyState", NM="_ZN5clang7ASTUnit16ConcurrencyStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16ConcurrencyStateE")
  //</editor-fold>
  private static class ConcurrencyState implements Destructors.ClassWithDestructor {
    private Object/*void P*/ Mutex; // a llvm::sys::MutexImpl in debug;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ConcurrencyState::ConcurrencyState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2843,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2832,
     FQN="clang::ASTUnit::ConcurrencyState::ConcurrencyState", NM="_ZN5clang7ASTUnit16ConcurrencyStateC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16ConcurrencyStateC1Ev")
    //</editor-fold>
    public ConcurrencyState() {
      Mutex = new MutexImpl(/*recursive=*/ true);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ConcurrencyState::~ConcurrencyState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2847,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2836,
     FQN="clang::ASTUnit::ConcurrencyState::~ConcurrencyState", NM="_ZN5clang7ASTUnit16ConcurrencyStateD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16ConcurrencyStateD0Ev")
    //</editor-fold>
    public void $destroy() {
      if (((/*static_cast*/MutexImpl /*P*/ )(Mutex)) != null) { ((/*static_cast*/MutexImpl /*P*/ )(Mutex)).$destroy();};
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ConcurrencyState::start">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2851,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2840,
     FQN="clang::ASTUnit::ConcurrencyState::start", NM="_ZN5clang7ASTUnit16ConcurrencyState5startEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16ConcurrencyState5startEv")
    //</editor-fold>
    public void start() {
      boolean acquired = ((/*static_cast*/MutexImpl /*P*/ )(Mutex)).tryacquire();
      assert (acquired) : "Concurrent access to ASTUnit!";
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ConcurrencyState::finish">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2856,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2845,
     FQN="clang::ASTUnit::ConcurrencyState::finish", NM="_ZN5clang7ASTUnit16ConcurrencyState6finishEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16ConcurrencyState6finishEv")
    //</editor-fold>
    public void finish() {
      ((/*static_cast*/MutexImpl /*P*/ )(Mutex)).release();
    }

    
    @Override public String toString() {
      return "" + "Mutex=" + Mutex; // NOI18N
    }
  };
  private ConcurrencyState ConcurrencyCheckValue;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ConcurrencyCheck">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 477,
   FQN="clang::ASTUnit::ConcurrencyCheck", NM="_ZN5clang7ASTUnit16ConcurrencyCheckE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16ConcurrencyCheckE")
  //</editor-fold>
  public static class ConcurrencyCheck implements Destructors.ClassWithDestructor {
    private ASTUnit /*&*/ Self;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ConcurrencyCheck::ConcurrencyCheck">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 481,
     FQN="clang::ASTUnit::ConcurrencyCheck::ConcurrencyCheck", NM="_ZN5clang7ASTUnit16ConcurrencyCheckC1ERS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16ConcurrencyCheckC1ERS0_")
    //</editor-fold>
    public /*explicit*/ ConcurrencyCheck(ASTUnit /*&*/ Self) {
      // : Self(Self) 
      //START JInit
      this./*&*/Self=/*&*/Self;
      //END JInit
      Self.ConcurrencyCheckValue.start();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::ConcurrencyCheck::~ConcurrencyCheck">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 486,
     FQN="clang::ASTUnit::ConcurrencyCheck::~ConcurrencyCheck", NM="_ZN5clang7ASTUnit16ConcurrencyCheckD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16ConcurrencyCheckD0Ev")
    //</editor-fold>
    public void $destroy() {
      Self.ConcurrencyCheckValue.finish();
    }

    
    @Override public String toString() {
      return "" + "Self=" + Self; // NOI18N
    }
  };
  /*friend  class ConcurrencyCheck*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::~ASTUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 234,
   FQN="clang::ASTUnit::~ASTUnit", NM="_ZN5clang7ASTUnitD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnitD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    // If we loaded from an AST file, balance out the BeginSourceFile call.
    if (MainFileIsAST && (getDiagnostics().getClient() != null)) {
      getDiagnostics().getClient().EndSourceFile();
    }
    
    clearFileLevelDecls();
    
    // Clean up the temporary files and the preamble file.
    removeOnDiskEntry(this);
    
    // Free the buffers associated with remapped files. We are required to
    // perform this operation here because we explicitly request that the
    // compiler instance *not* free these buffers for each invocation of the
    // parser.
    if ((Invocation.get() != null) && OwnsRemappedFileBuffers) {
      PreprocessorOptions /*&*/ PPOpts = Invocation.$arrow().getPreprocessorOpts();
      for (/*const*/ pair<std.string, MemoryBuffer /*P*/ > /*&*/ RB : PPOpts.RemappedFileBuffers)  {
        if (RB.second != null) { RB.second.$destroy();};
      }
    }
    
    ClearCachedCompletionResults();
    if ((getenv($("LIBCLANG_OBJTRACKING")) != null)) {
      fprintf(stderr, /*KEEP_STR*/"--- %u translation units\n", ActiveASTUnitObjects.$preDec());
    }
    //START JDestroy
    ConcurrencyCheckValue.$destroy();
    CachedCompletionTypes.$destroy();
    CachedCompletionResults.$destroy();
    CCTUInfo.$destroy();
    CachedCompletionAllocator.$destroy();
    ASTFileLangOpts.$destroy();
    TopLevelDeclsInPreamble.$destroy();
    PreambleBuffer.$destroy();
    SavedMainFileBuffer.$destroy();
    FilesInPreamble.$destroy();
    Preamble.$destroy();
    FailedParseDiagnostics.$destroy();
    StoredDiagnostics.$destroy();
    PreambleDiagnostics.$destroy();
    OriginalSourceFile.$destroy();
    FileDecls.$destroy();
    TopLevelDecls.$destroy();
    Invocation.$destroy();
    TheSema.$destroy();
    Consumer.$destroy();
    FileSystemOpts.$destroy();
    WriterData.$destroy();
    Reader.$destroy();
    HSOpts.$destroy();
    TargetOpts.$destroy();
    Ctx.$destroy();
    PP.$destroy();
    Target.$destroy();
    HeaderInfo.$destroy();
    SourceMgr.$destroy();
    FileMgr.$destroy();
    Diagnostics.$destroy();
    LangOpts.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::isMainFileAST">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 494,
   FQN="clang::ASTUnit::isMainFileAST", NM="_ZNK5clang7ASTUnit13isMainFileASTEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit13isMainFileASTEv")
  //</editor-fold>
  public boolean isMainFileAST() /*const*/ {
    return MainFileIsAST;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::isUnsafeToFree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 496,
   FQN="clang::ASTUnit::isUnsafeToFree", NM="_ZNK5clang7ASTUnit14isUnsafeToFreeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit14isUnsafeToFreeEv")
  //</editor-fold>
  public boolean isUnsafeToFree() /*const*/ {
    return UnsafeToFree;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::setUnsafeToFree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 497,
   FQN="clang::ASTUnit::setUnsafeToFree", NM="_ZN5clang7ASTUnit15setUnsafeToFreeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit15setUnsafeToFreeEb")
  //</editor-fold>
  public void setUnsafeToFree(boolean Value) {
    UnsafeToFree = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 499,
   FQN="clang::ASTUnit::getDiagnostics", NM="_ZNK5clang7ASTUnit14getDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit14getDiagnosticsEv")
  //</editor-fold>
  public /*const*/ DiagnosticsEngine /*&*/ getDiagnostics$Const() /*const*/ {
    return Diagnostics.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 500,
   FQN="clang::ASTUnit::getDiagnostics", NM="_ZN5clang7ASTUnit14getDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit14getDiagnosticsEv")
  //</editor-fold>
  public DiagnosticsEngine /*&*/ getDiagnostics() {
    return Diagnostics.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 502,
   FQN="clang::ASTUnit::getSourceManager", NM="_ZNK5clang7ASTUnit16getSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit16getSourceManagerEv")
  //</editor-fold>
  public /*const*/ SourceManager /*&*/ getSourceManager$Const() /*const*/ {
    return SourceMgr.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 503,
   FQN="clang::ASTUnit::getSourceManager", NM="_ZN5clang7ASTUnit16getSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16getSourceManagerEv")
  //</editor-fold>
  public SourceManager /*&*/ getSourceManager() {
    return SourceMgr.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getPreprocessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 505,
   FQN="clang::ASTUnit::getPreprocessor", NM="_ZNK5clang7ASTUnit15getPreprocessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit15getPreprocessorEv")
  //</editor-fold>
  public /*const*/ Preprocessor /*&*/ getPreprocessor$Const() /*const*/ {
    return PP.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getPreprocessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 506,
   FQN="clang::ASTUnit::getPreprocessor", NM="_ZN5clang7ASTUnit15getPreprocessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit15getPreprocessorEv")
  //</editor-fold>
  public Preprocessor /*&*/ getPreprocessor() {
    return PP.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 508,
   FQN="clang::ASTUnit::getASTContext", NM="_ZNK5clang7ASTUnit13getASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit13getASTContextEv")
  //</editor-fold>
  public /*const*/ ASTContext /*&*/ getASTContext$Const() /*const*/ {
    return Ctx.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 509,
   FQN="clang::ASTUnit::getASTContext", NM="_ZN5clang7ASTUnit13getASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit13getASTContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getASTContext() {
    return Ctx.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::setASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 511,
   FQN="clang::ASTUnit::setASTContext", NM="_ZN5clang7ASTUnit13setASTContextEPNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit13setASTContextEPNS_10ASTContextE")
  //</editor-fold>
  public void setASTContext(ASTContext /*P*/ ctx) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(Ctx.$assign($c$.track(new IntrusiveRefCntPtr<ASTContext>(ctx))));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::setPreprocessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 261,
   FQN="clang::ASTUnit::setPreprocessor", NM="_ZN5clang7ASTUnit15setPreprocessorEPNS_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit15setPreprocessorEPNS_12PreprocessorE")
  //</editor-fold>
  public void setPreprocessor(Preprocessor /*P*/ pp) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(PP.$assign($c$.track(new IntrusiveRefCntPtr<Preprocessor>(pp))));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::hasSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 514,
   FQN="clang::ASTUnit::hasSema", NM="_ZNK5clang7ASTUnit7hasSemaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit7hasSemaEv")
  //</editor-fold>
  public boolean hasSema() /*const*/ {
    return (boolean)TheSema.$bool();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 515,
   FQN="clang::ASTUnit::getSema", NM="_ZNK5clang7ASTUnit7getSemaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit7getSemaEv")
  //</editor-fold>
  public Sema /*&*/ getSema() /*const*/ {
    assert (TheSema.$bool()) : "ASTUnit does not have a Sema object!";
    return TheSema.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 520,
   FQN="clang::ASTUnit::getLangOpts", NM="_ZNK5clang7ASTUnit11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit11getLangOptsEv")
  //</editor-fold>
  public /*const*/ LangOptions /*&*/ getLangOpts() /*const*/ {
    assert (LangOpts.$bool()) : " ASTUnit does not have language options";
    return LangOpts.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getFileManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 525,
   FQN="clang::ASTUnit::getFileManager", NM="_ZNK5clang7ASTUnit14getFileManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit14getFileManagerEv")
  //</editor-fold>
  public /*const*/ FileManager /*&*/ getFileManager$Const() /*const*/ {
    return FileMgr.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getFileManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 526,
   FQN="clang::ASTUnit::getFileManager", NM="_ZN5clang7ASTUnit14getFileManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit14getFileManagerEv")
  //</editor-fold>
  public FileManager /*&*/ getFileManager() {
    return FileMgr.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getFileSystemOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 528,
   FQN="clang::ASTUnit::getFileSystemOpts", NM="_ZNK5clang7ASTUnit17getFileSystemOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit17getFileSystemOptsEv")
  //</editor-fold>
  public /*const*/ FileSystemOptions /*&*/ getFileSystemOpts() /*const*/ {
    return FileSystemOpts;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getOriginalSourceFileName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 530,
   FQN="clang::ASTUnit::getOriginalSourceFileName", NM="_ZN5clang7ASTUnit25getOriginalSourceFileNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit25getOriginalSourceFileNameEv")
  //</editor-fold>
  public StringRef getOriginalSourceFileName() {
    return new StringRef(OriginalSourceFile);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getASTMutationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 621,
   FQN="clang::ASTUnit::getASTMutationListener", NM="_ZN5clang7ASTUnit22getASTMutationListenerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit22getASTMutationListenerEv")
  //</editor-fold>
  public ASTMutationListener /*P*/ getASTMutationListener() {
    if (WriterData.$bool()) {
      return /*AddrOf*/WriterData.$arrow().Writer;
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getDeserializationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 627,
   FQN="clang::ASTUnit::getDeserializationListener", NM="_ZN5clang7ASTUnit26getDeserializationListenerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit26getDeserializationListenerEv")
  //</editor-fold>
  public ASTDeserializationListener /*P*/ getDeserializationListener() {
    if (WriterData.$bool()) {
      return /*AddrOf*/WriterData.$arrow().Writer;
    }
    return null;
  }

  
  /// \brief Add a temporary file that the ASTUnit depends on.
  ///
  /// This file will be erased when the ASTUnit is destroyed.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::addTemporaryFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 200,
   FQN="clang::ASTUnit::addTemporaryFile", NM="_ZN5clang7ASTUnit16addTemporaryFileEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16addTemporaryFileEN4llvm9StringRefE")
  //</editor-fold>
  public void addTemporaryFile(StringRef TempFile) {
    getOnDiskData(this).TemporaryFiles.push_back_T$RR(TempFile.$string());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getOnlyLocalDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 542,
   FQN="clang::ASTUnit::getOnlyLocalDecls", NM="_ZNK5clang7ASTUnit17getOnlyLocalDeclsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit17getOnlyLocalDeclsEv")
  //</editor-fold>
  public boolean getOnlyLocalDecls() /*const*/ {
    return OnlyLocalDecls;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getOwnsRemappedFileBuffers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 544,
   FQN="clang::ASTUnit::getOwnsRemappedFileBuffers", NM="_ZNK5clang7ASTUnit26getOwnsRemappedFileBuffersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit26getOwnsRemappedFileBuffersEv")
  //</editor-fold>
  public boolean getOwnsRemappedFileBuffers() /*const*/ {
    return OwnsRemappedFileBuffers;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::setOwnsRemappedFileBuffers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 545,
   FQN="clang::ASTUnit::setOwnsRemappedFileBuffers", NM="_ZN5clang7ASTUnit26setOwnsRemappedFileBuffersEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit26setOwnsRemappedFileBuffersEb")
  //</editor-fold>
  public void setOwnsRemappedFileBuffers(boolean val) {
    OwnsRemappedFileBuffers = val;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getMainFileName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1683,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1674,
   FQN="clang::ASTUnit::getMainFileName", NM="_ZNK5clang7ASTUnit15getMainFileNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit15getMainFileNameEv")
  //</editor-fold>
  public StringRef getMainFileName() /*const*/ {
    if (Invocation.$bool() && !Invocation.$arrow().getFrontendOpts().Inputs.empty()) {
      /*const*/ FrontendInputFile /*&*/ Input = Invocation.$arrow().getFrontendOpts().Inputs.$at(0);
      if (Input.isFile()) {
        return Input.getFile();
      } else {
        return new StringRef(Input.getBuffer().getBufferIdentifier());
      }
    }
    if (SourceMgr.$bool()) {
      {
        /*const*/ FileEntry /*P*/ FE = SourceMgr.$arrow().getFileEntryForID(SourceMgr.$arrow().getMainFileID());
        if ((FE != null)) {
          return new StringRef(FE.getName());
        }
      }
    }
    
    return new StringRef();
  }

  
  /// \brief If this ASTUnit came from an AST file, returns the filename for it.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getASTFileName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1701,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1692,
   FQN="clang::ASTUnit::getASTFileName", NM="_ZNK5clang7ASTUnit14getASTFileNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit14getASTFileNameEv")
  //</editor-fold>
  public StringRef getASTFileName() /*const*/ {
    if (!isMainFileAST()) {
      return new StringRef();
    }
    
    ModuleFile /*&*/ Mod = Reader.$arrow().getModuleManager().getPrimaryModule();
    return new StringRef(Mod.FileName);
  }

  
  /*typedef std::vector<Decl *>::iterator top_level_iterator*/
//  public final class top_level_iterator extends std.vector.iterator<Decl/*P*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::top_level_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 554,
   FQN="clang::ASTUnit::top_level_begin", NM="_ZN5clang7ASTUnit15top_level_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit15top_level_beginEv")
  //</editor-fold>
  public std.vector.iterator<Decl/*P*/> top_level_begin() {
    assert (!isMainFileAST()) : "Invalid call for AST based ASTUnit!";
    if (!TopLevelDeclsInPreamble.empty()) {
      RealizeTopLevelDeclsFromPreamble();
    }
    return TopLevelDecls.begin();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::top_level_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 561,
   FQN="clang::ASTUnit::top_level_end", NM="_ZN5clang7ASTUnit13top_level_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit13top_level_endEv")
  //</editor-fold>
  public std.vector.iterator<Decl/*P*/> top_level_end() {
    assert (!isMainFileAST()) : "Invalid call for AST based ASTUnit!";
    if (!TopLevelDeclsInPreamble.empty()) {
      RealizeTopLevelDeclsFromPreamble();
    }
    return TopLevelDecls.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::top_level_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 568,
   FQN="clang::ASTUnit::top_level_size", NM="_ZNK5clang7ASTUnit14top_level_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit14top_level_sizeEv")
  //</editor-fold>
  public /*uint*/int top_level_size() /*const*/ {
    assert (!isMainFileAST()) : "Invalid call for AST based ASTUnit!";
    return TopLevelDeclsInPreamble.size() + TopLevelDecls.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::top_level_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 573,
   FQN="clang::ASTUnit::top_level_empty", NM="_ZNK5clang7ASTUnit15top_level_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit15top_level_emptyEv")
  //</editor-fold>
  public boolean top_level_empty() /*const*/ {
    assert (!isMainFileAST()) : "Invalid call for AST based ASTUnit!";
    return TopLevelDeclsInPreamble.empty() && TopLevelDecls.empty();
  }

  
  /// \brief Add a new top-level declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::addTopLevelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 579,
   FQN="clang::ASTUnit::addTopLevelDecl", NM="_ZN5clang7ASTUnit15addTopLevelDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit15addTopLevelDeclEPNS_4DeclE")
  //</editor-fold>
  public void addTopLevelDecl(Decl /*P*/ D) {
    TopLevelDecls.push_back_T$C$R(D);
  }

  
  /// \brief Add a new local file-level declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::addFileLevelDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2579,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2568,
   FQN="clang::ASTUnit::addFileLevelDecl", NM="_ZN5clang7ASTUnit16addFileLevelDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16addFileLevelDeclEPNS_4DeclE")
  //</editor-fold>
  public void addFileLevelDecl(Decl /*P*/ D) {
    assert (D != null);
    
    // We only care about local declarations.
    if (D.isFromASTFile()) {
      return;
    }
    
    SourceManager /*&*/ SM = SourceMgr.$star();
    SourceLocation Loc = D.getLocation();
    if (Loc.isInvalid() || !SM.isLocalSourceLocation(/*NO_COPY*/Loc)) {
      return;
    }
    
    // We only keep track of the file-level declarations of each file.
    if (!D.getLexicalDeclContext().isFileContext()) {
      return;
    }
    
    SourceLocation FileLoc = SM.getFileLoc(/*NO_COPY*/Loc);
    assert (SM.isLocalSourceLocation(/*NO_COPY*/FileLoc));
    // JAVA: unfold std::tie
    final pairTypeUInt<FileID> $decomposedLoc = SM.getDecomposedLoc(/*NO_COPY*/FileLoc);
    FileID FID/*J*/= new FileID($decomposedLoc.first);
    /*uint*/int Offset = $decomposedLoc.second;
//    std.tie(FID, Offset).$assign_pair$_U1$_U2($decomposedLoc);
    if (FID.isInvalid()) {
      return;
    }
    
    SmallVector<std.pairUIntType<Decl /*P*/ >> /*P*/ /*&*/ Decls = FileDecls.$at(FID);
    if (!(Decls != null)) {
      Decls = new SmallVector<std.pairUIntType<Decl /*P*/ >>(64, new std.pairUIntPtr<Decl /*P*/ >());
    }
    
    std.pairUIntType<Decl /*P*/ > LocDecl/*J*/= new std.pairUIntPtr<Decl /*P*/ >(JD$T$RR_T1$RR.INSTANCE, Offset, D);
    if (Decls.empty() || $lesseq_uint(Decls.back().first, Offset)) {
      Decls.push_back(LocDecl);
      return;
    }
    
    type$ptr<std.pairUIntType<Decl /*P*/ >>  I = std.upper_bound(Decls.begin(), Decls.end(), 
        LocDecl, new less_first_pairUIntType());
    
    Decls.insert(I, LocDecl);
  }

  
  /// \brief Get the decls that are contained in a file in the Offset/Length
  /// range. \p Length can be 0 to indicate a point at \p Offset instead of
  /// a range. 
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::findFileRegionDecls">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2620,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2609,
   FQN="clang::ASTUnit::findFileRegionDecls", NM="_ZN5clang7ASTUnit19findFileRegionDeclsENS_6FileIDEjjRN4llvm15SmallVectorImplIPNS_4DeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit19findFileRegionDeclsENS_6FileIDEjjRN4llvm15SmallVectorImplIPNS_4DeclEEE")
  //</editor-fold>
  public void findFileRegionDecls(FileID File, /*uint*/int Offset, /*uint*/int Length, 
                     SmallVectorImpl<Decl /*P*/ > /*&*/ Decls) {
    if (File.isInvalid()) {
      return;
    }
    if (SourceMgr.$arrow().isLoadedFileID(/*NO_COPY*/File)) {
      assert ((Ctx.$arrow().getExternalSource() != null)) : "No external source!";
      Ctx.$arrow().getExternalSource().FindFileRegionDecls(new FileID(File), Offset, Length, 
          Decls);
      return;
    }
    
    DenseMapIterator<FileID, SmallVector<pairUIntType<Decl>>/*P*/> I = FileDecls.find(File);
    if (I.$eq(/*NO_ITER_COPY*/FileDecls.end())) {
      return;
    }
    
    SmallVector<std.pairUIntType<Decl /*P*/ >> /*&*/ LocDecls = /*Deref*/I.$arrow().second;
    if (LocDecls.empty()) {
      return;
    }
    
    type$ptr<std.pairUIntType<Decl /*P*/ >>  BeginIt = std.lower_bound(LocDecls.begin(), LocDecls.end(), 
        std.make_pair_uint_Ptr(Offset, (Decl /*P*/ )(Decl /*P*/ )null), 
        new less_first_pairUIntType());
    if ($noteq_iter(BeginIt, LocDecls.begin())) {
      BeginIt.$preDec();
    }
    
    // If we are pointing at a top-level decl inside an objc container, we need
    // to backtrack until we find it otherwise we will fail to report that the
    // region overlaps with an objc container.
    while ($noteq_iter(BeginIt, LocDecls.begin())
       && BeginIt./*->*/$star().second.isTopLevelDeclInObjCContainer()) {
      BeginIt.$preDec();
    }
    
    type$ptr<std.pairUIntType<Decl /*P*/ >>  EndIt = std.upper_bound(LocDecls.begin(), LocDecls.end(), 
        std.make_pair_uint_Ptr(Offset + Length, (Decl /*P*/ )(Decl /*P*/ )null), new less_first_pairUIntType());
    if ($noteq_iter(EndIt, LocDecls.end())) {
      EndIt.$preInc();
    }
    
    for (type$ptr<std.pairUIntType<Decl /*P*/ >>  DIt = BeginIt; $noteq_iter(DIt, EndIt); DIt.$preInc())  {
      Decls.push_back(DIt./*->*/$star().second);
    }
  }

  
  /// \brief Add a new top-level declaration, identified by its ID in
  /// the precompiled preamble.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::addTopLevelDeclFromPreamble">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 594,
   FQN="clang::ASTUnit::addTopLevelDeclFromPreamble", NM="_ZN5clang7ASTUnit27addTopLevelDeclFromPreambleEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit27addTopLevelDeclFromPreambleEj")
  //</editor-fold>
  public void addTopLevelDeclFromPreamble(/*uint32_t*/int D) {
    TopLevelDeclsInPreamble.push_back_T$C$R(D);
  }

  
  /// \brief Retrieve a reference to the current top-level name hash value.
  ///
  /// Note: This is used internally by the top-level tracking action
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getCurrentTopLevelHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 601,
   FQN="clang::ASTUnit::getCurrentTopLevelHashValue", NM="_ZN5clang7ASTUnit27getCurrentTopLevelHashValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit27getCurrentTopLevelHashValueEv")
  //</editor-fold>
  public uint$ref/*uint &*/ getCurrentTopLevelHashValue() {
    uint$ref out = new uint$ref() {
      @Override public int $deref() { return CurrentTopLevelHashValue; }
      @Override public int $set(int value) { return CurrentTopLevelHashValue = value; }
    };    
    return out;
  }

  
  /// \brief Get the source location for the given file:line:col triplet.
  ///
  /// The difference with SourceManager::getLocation is that this method checks
  /// whether the requested location points inside the precompiled preamble
  /// in which case the returned source location will be a "loaded" one.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2663,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2652,
   FQN="clang::ASTUnit::getLocation", NM="_ZNK5clang7ASTUnit11getLocationEPKNS_9FileEntryEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit11getLocationEPKNS_9FileEntryEjj")
  //</editor-fold>
  public SourceLocation getLocation(/*const*/ FileEntry /*P*/ File, 
             /*uint*/int Line, /*uint*/int Col) /*const*/ {
    /*const*/ SourceManager /*&*/ SM = getSourceManager$Const();
    SourceLocation Loc = SM.translateFileLineCol(File, Line, Col);
    return SM.getMacroArgExpandedLocation(/*NO_COPY*/Loc);
  }

  
  /// \brief Get the source location for the given file:offset pair.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2670,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2659,
   FQN="clang::ASTUnit::getLocation", NM="_ZNK5clang7ASTUnit11getLocationEPKNS_9FileEntryEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit11getLocationEPKNS_9FileEntryEj")
  //</editor-fold>
  public SourceLocation getLocation(/*const*/ FileEntry /*P*/ File, 
             /*uint*/int Offset) /*const*/ {
    /*const*/ SourceManager /*&*/ SM = getSourceManager$Const();
    SourceLocation FileLoc = SM.translateFileLineCol(File, 1, 1);
    return SM.getMacroArgExpandedLocation(FileLoc.getLocWithOffset(Offset));
  }

  
  /// \brief If \p Loc is a loaded location from the preamble, returns
  /// the corresponding local location of the main file, otherwise it returns
  /// \p Loc.
  
  /// \brief If \arg Loc is a loaded location from the preamble, returns
  /// the corresponding local location of the main file, otherwise it returns
  /// \arg Loc.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::mapLocationFromPreamble">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2680,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2669,
   FQN="clang::ASTUnit::mapLocationFromPreamble", NM="_ZN5clang7ASTUnit23mapLocationFromPreambleENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit23mapLocationFromPreambleENS_14SourceLocationE")
  //</editor-fold>
  public SourceLocation mapLocationFromPreamble(SourceLocation Loc) {
    FileID PreambleID/*J*/= new FileID();
    if (SourceMgr.$bool()) {
      PreambleID.$assignMove(SourceMgr.$arrow().getPreambleFileID());
    }
    if (Loc.isInvalid() || Preamble.empty() || PreambleID.isInvalid()) {
      return new SourceLocation(JD$Move.INSTANCE, Loc);
    }
    
    /*uint*/uint$ptr Offs = create_uint$ptr();
    if (SourceMgr.$arrow().isInFileID(/*NO_COPY*/Loc, /*NO_COPY*/PreambleID, /*AddrOf*/Offs) && $less_uint(Offs, Preamble.size())) {
      SourceLocation FileLoc = SourceMgr.$arrow().getLocForStartOfFile(SourceMgr.$arrow().getMainFileID());
      return FileLoc.getLocWithOffset(Offs.$star());
    }
    
    return new SourceLocation(JD$Move.INSTANCE, Loc);
  }

  
  /// \brief If \p Loc is a local location of the main file but inside the
  /// preamble chunk, returns the corresponding loaded location from the
  /// preamble, otherwise it returns \p Loc.
  
  /// \brief If \arg Loc is a local location of the main file but inside the
  /// preamble chunk, returns the corresponding loaded location from the
  /// preamble, otherwise it returns \arg Loc.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::mapLocationToPreamble">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2701,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2690,
   FQN="clang::ASTUnit::mapLocationToPreamble", NM="_ZN5clang7ASTUnit21mapLocationToPreambleENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit21mapLocationToPreambleENS_14SourceLocationE")
  //</editor-fold>
  public SourceLocation mapLocationToPreamble(SourceLocation Loc) {
    FileID PreambleID/*J*/= new FileID();
    if (SourceMgr.$bool()) {
      PreambleID.$assignMove(SourceMgr.$arrow().getPreambleFileID());
    }
    if (Loc.isInvalid() || Preamble.empty() || PreambleID.isInvalid()) {
      return new SourceLocation(JD$Move.INSTANCE, Loc);
    }
    
    /*uint*/uint$ptr Offs = create_uint$ptr();
    if (SourceMgr.$arrow().isInFileID(/*NO_COPY*/Loc, SourceMgr.$arrow().getMainFileID(), /*AddrOf*/Offs)
       && $less_uint(Offs, Preamble.size())) {
      SourceLocation FileLoc = SourceMgr.$arrow().getLocForStartOfFile(/*NO_COPY*/PreambleID);
      return FileLoc.getLocWithOffset(Offs.$star());
    }
    
    return new SourceLocation(JD$Move.INSTANCE, Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::isInPreambleFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2719,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2708,
   FQN="clang::ASTUnit::isInPreambleFileID", NM="_ZN5clang7ASTUnit18isInPreambleFileIDENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit18isInPreambleFileIDENS_14SourceLocationE")
  //</editor-fold>
  public boolean isInPreambleFileID(SourceLocation Loc) {
    FileID FID/*J*/= new FileID();
    if (SourceMgr.$bool()) {
      FID.$assignMove(SourceMgr.$arrow().getPreambleFileID());
    }
    if (Loc.isInvalid() || FID.isInvalid()) {
      return false;
    }
    
    return SourceMgr.$arrow().isInFileID(/*NO_COPY*/Loc, /*NO_COPY*/FID);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::isInMainFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2730,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2719,
   FQN="clang::ASTUnit::isInMainFileID", NM="_ZN5clang7ASTUnit14isInMainFileIDENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit14isInMainFileIDENS_14SourceLocationE")
  //</editor-fold>
  public boolean isInMainFileID(SourceLocation Loc) {
    FileID FID/*J*/= new FileID();
    if (SourceMgr.$bool()) {
      FID.$assignMove(SourceMgr.$arrow().getMainFileID());
    }
    if (Loc.isInvalid() || FID.isInvalid()) {
      return false;
    }
    
    return SourceMgr.$arrow().isInFileID(/*NO_COPY*/Loc, /*NO_COPY*/FID);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getStartOfMainFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2752,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2741,
   FQN="clang::ASTUnit::getStartOfMainFileID", NM="_ZN5clang7ASTUnit20getStartOfMainFileIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit20getStartOfMainFileIDEv")
  //</editor-fold>
  public SourceLocation getStartOfMainFileID() {
    FileID FID/*J*/= new FileID();
    if (SourceMgr.$bool()) {
      FID.$assignMove(SourceMgr.$arrow().getMainFileID());
    }
    if (FID.isInvalid()) {
      return new SourceLocation();
    }
    
    return SourceMgr.$arrow().getLocForStartOfFile(/*NO_COPY*/FID);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getEndOfPreambleFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2741,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2730,
   FQN="clang::ASTUnit::getEndOfPreambleFileID", NM="_ZN5clang7ASTUnit22getEndOfPreambleFileIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit22getEndOfPreambleFileIDEv")
  //</editor-fold>
  public SourceLocation getEndOfPreambleFileID() {
    FileID FID/*J*/= new FileID();
    if (SourceMgr.$bool()) {
      FID.$assignMove(SourceMgr.$arrow().getPreambleFileID());
    }
    if (FID.isInvalid()) {
      return new SourceLocation();
    }
    
    return SourceMgr.$arrow().getLocForEndOfFile(/*NO_COPY*/FID);
  }

  
  /// \see mapLocationFromPreamble.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::mapRangeFromPreamble">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 630,
   FQN="clang::ASTUnit::mapRangeFromPreamble", NM="_ZN5clang7ASTUnit20mapRangeFromPreambleENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit20mapRangeFromPreambleENS_11SourceRangeE")
  //</editor-fold>
  public SourceRange mapRangeFromPreamble(SourceRange R) {
    return new SourceRange(mapLocationFromPreamble(R.getBegin()), 
        mapLocationFromPreamble(R.getEnd()));
  }

  
  /// \see mapLocationToPreamble.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::mapRangeToPreamble">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 636,
   FQN="clang::ASTUnit::mapRangeToPreamble", NM="_ZN5clang7ASTUnit18mapRangeToPreambleENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit18mapRangeToPreambleENS_11SourceRangeE")
  //</editor-fold>
  public SourceRange mapRangeToPreamble(SourceRange R) {
    return new SourceRange(mapLocationToPreamble(R.getBegin()), 
        mapLocationToPreamble(R.getEnd()));
  }

  
  // Retrieve the diagnostics associated with this AST
  /*typedef StoredDiagnostic *stored_diag_iterator*/
//  public final class stored_diag_iterator extends StoredDiagnostic /*P*/ { };
  /*typedef const StoredDiagnostic *stored_diag_const_iterator*/
//  public final class stored_diag_const_iterator extends /*const*/ StoredDiagnostic /*P*/ { };
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::stored_diag_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 644,
   FQN="clang::ASTUnit::stored_diag_begin", NM="_ZNK5clang7ASTUnit17stored_diag_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit17stored_diag_beginEv")
  //</editor-fold>
  public type$ptr<StoredDiagnostic> stored_diag_begin$Const() /*const*/ {
    return StoredDiagnostics.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::stored_diag_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 647,
   FQN="clang::ASTUnit::stored_diag_begin", NM="_ZN5clang7ASTUnit17stored_diag_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit17stored_diag_beginEv")
  //</editor-fold>
  public type$ptr<StoredDiagnostic> stored_diag_begin() {
    return StoredDiagnostics.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::stored_diag_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 650,
   FQN="clang::ASTUnit::stored_diag_end", NM="_ZNK5clang7ASTUnit15stored_diag_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit15stored_diag_endEv")
  //</editor-fold>
  public type$ptr<StoredDiagnostic> stored_diag_end$Const() /*const*/ {
    return StoredDiagnostics.end$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::stored_diag_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 653,
   FQN="clang::ASTUnit::stored_diag_end", NM="_ZN5clang7ASTUnit15stored_diag_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit15stored_diag_endEv")
  //</editor-fold>
  public type$ptr<StoredDiagnostic> stored_diag_end() {
    return StoredDiagnostics.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::stored_diag_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 656,
   FQN="clang::ASTUnit::stored_diag_size", NM="_ZNK5clang7ASTUnit16stored_diag_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit16stored_diag_sizeEv")
  //</editor-fold>
  public /*uint*/int stored_diag_size() /*const*/ {
    return StoredDiagnostics.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::stored_diag_afterDriver_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 658,
   FQN="clang::ASTUnit::stored_diag_afterDriver_begin", NM="_ZN5clang7ASTUnit29stored_diag_afterDriver_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit29stored_diag_afterDriver_beginEv")
  //</editor-fold>
  public type$ptr<StoredDiagnostic> stored_diag_afterDriver_begin() {
    if ($greater_uint(NumStoredDiagnosticsFromDriver, StoredDiagnostics.size())) {
      NumStoredDiagnosticsFromDriver = 0;
    }
    return StoredDiagnostics.begin().$add(NumStoredDiagnosticsFromDriver);
  }

  
  /*typedef std::vector<CachedCodeCompletionResult>::iterator cached_completion_iterator*/
//  public final class cached_completion_iterator extends std.vector.iterator<CachedCodeCompletionResult /*P*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::cached_completion_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 667,
   FQN="clang::ASTUnit::cached_completion_begin", NM="_ZN5clang7ASTUnit23cached_completion_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit23cached_completion_beginEv")
  //</editor-fold>
  public std.vector.iterator<CachedCodeCompletionResult /*P*/> cached_completion_begin() {
    return CachedCompletionResults.begin();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::cached_completion_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 671,
   FQN="clang::ASTUnit::cached_completion_end", NM="_ZN5clang7ASTUnit21cached_completion_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit21cached_completion_endEv")
  //</editor-fold>
  public std.vector.iterator<CachedCodeCompletionResult /*P*/> cached_completion_end() {
    return CachedCompletionResults.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::cached_completion_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 675,
   FQN="clang::ASTUnit::cached_completion_size", NM="_ZNK5clang7ASTUnit22cached_completion_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit22cached_completion_sizeEv")
  //</editor-fold>
  public /*uint*/int cached_completion_size() /*const*/ {
    return CachedCompletionResults.size();
  }

  
  /// \brief Returns an iterator range for the local preprocessing entities
  /// of the local Preprocessor, if this is a parsed source file, or the loaded
  /// preprocessing entities of the primary module if this is an AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getLocalPreprocessingEntities">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2763,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2752,
   FQN="clang::ASTUnit::getLocalPreprocessingEntities", NM="_ZNK5clang7ASTUnit29getLocalPreprocessingEntitiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit29getLocalPreprocessingEntitiesEv")
  //</editor-fold>
  public iterator_range<PreprocessedEntity> getLocalPreprocessingEntities() /*const*/ {
    if (isMainFileAST()) {
      ModuleFile /*&*/ Mod = Reader.$arrow().getModuleManager().getPrimaryModule();
      return Reader.$arrow().getModulePreprocessedEntities(Mod);
    }
    {
      
      PreprocessingRecord /*P*/ PPRec = PP.$arrow().getPreprocessingRecord();
      if ((PPRec != null)) {
        return llvm.make_range(PPRec.local_begin(), PPRec.local_end());
      }
    }
    
    return llvm.make_range(new PreprocessingRecord.iterator(), 
        new PreprocessingRecord.iterator());
  }

  
  /// \brief Type for a function iterating over a number of declarations.
  /// \returns true to continue iteration and false to abort.
  /*typedef bool (*DeclVisitorFn)(void *, const Decl *)*/;
  
  /// \brief Iterate over local declarations (locally parsed if this is a parsed
  /// source file or the loaded declarations of the primary module if this is an
  /// AST file).
  /// \returns true if the iteration was complete or false if it was aborted.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::visitLocalTopLevelDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2778,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2767,
   FQN="clang::ASTUnit::visitLocalTopLevelDecls", NM="_ZN5clang7ASTUnit23visitLocalTopLevelDeclsEPvPFbS1_PKNS_4DeclEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit23visitLocalTopLevelDeclsEPvPFbS1_PKNS_4DeclEE")
  //</editor-fold>
  public boolean visitLocalTopLevelDecls(Object/*void P*/ context, DeclVisitorFn Fn) {
    if (isMainFileAST()) {
      ModuleFile /*&*/ Mod = Reader.$arrow().getModuleManager().getPrimaryModule();
      for (/*const*/ Decl /*P*/ D : Reader.$arrow().getModuleFileLevelDecls(Mod)) {
        if (!Fn.$call(context, D)) {
          return false;
        }
      }
      
      return true;
    }
    
    for (std.vector.iterator<Decl/*P*/> TL = top_level_begin(), 
        TLEnd = top_level_end();
         $noteq___normal_iterator$C(TL, TLEnd); TL.$preInc()) {
      if (!Fn.$call(context, TL.$star())) {
        return false;
      }
    }
    
    return true;
  }

  
  /// \brief Get the PCH file if one was included.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getPCHFile">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2800,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2789,
   FQN="clang::ASTUnit::getPCHFile", NM="_ZN5clang7ASTUnit10getPCHFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit10getPCHFileEv")
  //</editor-fold>
  public /*const*/ FileEntry /*P*/ getPCHFile() {
    if (!Reader.$bool()) {
      return null;
    }
    
    type$ptr<ModuleFile> /*P*/ Mod = create_type$null$ptr();
    Reader.$arrow().getModuleManager().visit((ModuleFile M) -> 
              {
                switch (M.Kind) {
                 case MK_ImplicitModule:
                 case MK_ExplicitModule:
                  return true; // skip dependencies.
                 case MK_PCH:
                  Mod.$set(/*AddrOf*/M);
                  return true; // found it.
                 case MK_Preamble:
                  return false; // look in dependencies.
                 case MK_MainFile:
                  return false; // look in dependencies.
                }
                
                return true;
              }
    );
    if ((!Mod.$isNull())) {
      return Mod.$arrow().File;
    }
    
    return null;
  }

  
  /// \brief Returns true if the ASTUnit was constructed from a serialized
  /// module file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::isModuleFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2827,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2816,
   FQN="clang::ASTUnit::isModuleFile", NM="_ZN5clang7ASTUnit12isModuleFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit12isModuleFileEv")
  //</editor-fold>
  public boolean isModuleFile() {
    return isMainFileAST() && ASTFileLangOpts.CompilingModule;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getBufferForFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 633,
   FQN="clang::ASTUnit::getBufferForFile", NM="_ZN5clang7ASTUnit16getBufferForFileEN4llvm9StringRefEPSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit16getBufferForFileEN4llvm9StringRefEPSs")
  //</editor-fold>
  public std.unique_ptr<MemoryBuffer> getBufferForFile(StringRef Filename) {
    return getBufferForFile(Filename, (std.string/*P*/ )null);
  }
  public std.unique_ptr<MemoryBuffer> getBufferForFile(StringRef Filename, std.string/*P*/ ErrorStr/*= null*/) {
    ErrorOr<unique_ptr<MemoryBuffer> > Buffer = null;
    try {
      assert ((FileMgr).$bool());
      Buffer = FileMgr.$arrow().getBufferForFile(new StringRef(Filename));
      if (Buffer.$bool()) {
        return new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(Buffer.$star()));
      }
      if ((ErrorStr != null)) {
        /*Deref*/ErrorStr.$assignMove(Buffer.getError().message());
      }
      return new std.unique_ptr<MemoryBuffer>(JD$NullPtr.INSTANCE, null);
    } finally {
      if (Buffer != null) { Buffer.$destroy(); }
    }
  }

  
  /// \brief Determine what kind of translation unit this AST represents.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::getTranslationUnitKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 706,
   FQN="clang::ASTUnit::getTranslationUnitKind", NM="_ZNK5clang7ASTUnit22getTranslationUnitKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang7ASTUnit22getTranslationUnitKindEv")
  //</editor-fold>
  public TranslationUnitKind getTranslationUnitKind() /*const*/ {
    return TUKind;
  }

  
  /// \brief A mapping from a file name to the memory buffer that stores the
  /// remapped contents of that file.
  /*typedef std::pair<std::string, llvm::MemoryBuffer *> RemappedFile*/
//  public final class RemappedFile extends std.pair<std.string, MemoryBuffer /*P*/ >{ };
  
  /// \brief Create a ASTUnit. Gets ownership of the passed CompilerInvocation. 
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1710,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1701,
   FQN="clang::ASTUnit::create", NM="_ZN5clang7ASTUnit6createEPNS_18CompilerInvocationEN4llvm18IntrusiveRefCntPtrINS_17DiagnosticsEngineEEEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit6createEPNS_18CompilerInvocationEN4llvm18IntrusiveRefCntPtrINS_17DiagnosticsEngineEEEbb")
  //</editor-fold>
  public static ASTUnit /*P*/ create(CompilerInvocation /*P*/ CI, 
        IntrusiveRefCntPtr<DiagnosticsEngine> Diags, 
        boolean CaptureDiagnostics, 
        boolean UserFilesAreVolatile) {
    std.unique_ptr<ASTUnit> AST = null;
    IntrusiveRefCntPtr<FileSystem> VFS = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      AST/*J*/= new std.unique_ptr<ASTUnit>();
      AST.reset(new ASTUnit(false));
      ConfigureDiags($c$.track(new IntrusiveRefCntPtr<DiagnosticsEngine>(Diags)), AST.$star(), CaptureDiagnostics); $c$.clean();
      $c$.clean(AST.$arrow().Diagnostics.$assign($c$.track(new IntrusiveRefCntPtr<DiagnosticsEngine>(Diags))));
      $c$.clean(AST.$arrow().Invocation.$assign($c$.track(new IntrusiveRefCntPtr<CompilerInvocation>(CI))));
      AST.$arrow().FileSystemOpts.$assign(CI.getFileSystemOpts());
      VFS = createVFSFromCompilerInvocation(/*Deref*/CI, Diags.$star());
      if (!VFS.$bool()) {
        return null;
      }
      $c$.clean(AST.$arrow().FileMgr.$assign($c$.track(new IntrusiveRefCntPtr<FileManager>(new FileManager(AST.$arrow().FileSystemOpts, $c$.track(new IntrusiveRefCntPtr<FileSystem>(VFS)))))));
      AST.$arrow().UserFilesAreVolatile = UserFilesAreVolatile;
      $c$.clean(AST.$arrow().SourceMgr.$assign($c$.track(new IntrusiveRefCntPtr<SourceManager>(new SourceManager(AST.$arrow().getDiagnostics(), AST.$arrow().FileMgr.$star(), 
                  UserFilesAreVolatile)))));
      
      return AST.release();
    } finally {
      if (VFS != null) { VFS.$destroy(); }
      if (AST != null) { AST.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief Create a ASTUnit from an AST file.
  ///
  /// \param Filename - The AST file to load.
  ///
  /// \param PCHContainerRdr - The PCHContainerOperations to use for loading and
  /// creating modules.
  /// \param Diags - The diagnostics engine to use for reporting errors; its
  /// lifetime is expected to extend past that of the returned ASTUnit.
  ///
  /// \returns - The initialized ASTUnit or null if the AST failed to load.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::LoadFromASTFile">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 652,
   FQN="clang::ASTUnit::LoadFromASTFile", NM="_ZN5clang7ASTUnit15LoadFromASTFileERKSsRKNS_18PCHContainerReaderEN4llvm18IntrusiveRefCntPtrINS_17DiagnosticsEngineEEERKNS_17FileSystemOptionsEbbNS6_8ArrayRefISt4pairISsPNS6_12MemoryBufferEEEEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit15LoadFromASTFileERKSsRKNS_18PCHContainerReaderEN4llvm18IntrusiveRefCntPtrINS_17DiagnosticsEngineEEERKNS_17FileSystemOptionsEbbNS6_8ArrayRefISt4pairISsPNS6_12MemoryBufferEEEEbbb")
  //</editor-fold>
  public static std.unique_ptr<ASTUnit> LoadFromASTFile(/*const*/std.string/*&*/ Filename, /*const*/ PCHContainerReader /*&*/ PCHContainerRdr, 
                 IntrusiveRefCntPtr<DiagnosticsEngine> Diags, 
                 /*const*/ FileSystemOptions /*&*/ FileSystemOpts) {
    return LoadFromASTFile(Filename, PCHContainerRdr, 
                 Diags, 
                 FileSystemOpts, false, 
                 false, new ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > >(None), 
                 false, false, 
                 false);
  }
  public static std.unique_ptr<ASTUnit> LoadFromASTFile(/*const*/std.string/*&*/ Filename, /*const*/ PCHContainerReader /*&*/ PCHContainerRdr, 
                 IntrusiveRefCntPtr<DiagnosticsEngine> Diags, 
                 /*const*/ FileSystemOptions /*&*/ FileSystemOpts, boolean UseDebugInfo/*= false*/) {
    return LoadFromASTFile(Filename, PCHContainerRdr, 
                 Diags, 
                 FileSystemOpts, UseDebugInfo, 
                 false, new ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > >(None), 
                 false, false, 
                 false);
  }
  public static std.unique_ptr<ASTUnit> LoadFromASTFile(/*const*/std.string/*&*/ Filename, /*const*/ PCHContainerReader /*&*/ PCHContainerRdr, 
                 IntrusiveRefCntPtr<DiagnosticsEngine> Diags, 
                 /*const*/ FileSystemOptions /*&*/ FileSystemOpts, boolean UseDebugInfo/*= false*/, 
                 boolean OnlyLocalDecls/*= false*/) {
    return LoadFromASTFile(Filename, PCHContainerRdr, 
                 Diags, 
                 FileSystemOpts, UseDebugInfo, 
                 OnlyLocalDecls, new ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > >(None), 
                 false, false, 
                 false);
  }
  public static std.unique_ptr<ASTUnit> LoadFromASTFile(/*const*/std.string/*&*/ Filename, /*const*/ PCHContainerReader /*&*/ PCHContainerRdr, 
                 IntrusiveRefCntPtr<DiagnosticsEngine> Diags, 
                 /*const*/ FileSystemOptions /*&*/ FileSystemOpts, boolean UseDebugInfo/*= false*/, 
                 boolean OnlyLocalDecls/*= false*/, ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > > RemappedFiles/*= None*/) {
    return LoadFromASTFile(Filename, PCHContainerRdr, 
                 Diags, 
                 FileSystemOpts, UseDebugInfo, 
                 OnlyLocalDecls, RemappedFiles, 
                 false, false, 
                 false);
  }
  public static std.unique_ptr<ASTUnit> LoadFromASTFile(/*const*/std.string/*&*/ Filename, /*const*/ PCHContainerReader /*&*/ PCHContainerRdr, 
                 IntrusiveRefCntPtr<DiagnosticsEngine> Diags, 
                 /*const*/ FileSystemOptions /*&*/ FileSystemOpts, boolean UseDebugInfo/*= false*/, 
                 boolean OnlyLocalDecls/*= false*/, ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > > RemappedFiles/*= None*/, 
                 boolean CaptureDiagnostics/*= false*/) {
    return LoadFromASTFile(Filename, PCHContainerRdr, 
                 Diags, 
                 FileSystemOpts, UseDebugInfo, 
                 OnlyLocalDecls, RemappedFiles, 
                 CaptureDiagnostics, false, 
                 false);
  }
  public static std.unique_ptr<ASTUnit> LoadFromASTFile(/*const*/std.string/*&*/ Filename, /*const*/ PCHContainerReader /*&*/ PCHContainerRdr, 
                 IntrusiveRefCntPtr<DiagnosticsEngine> Diags, 
                 /*const*/ FileSystemOptions /*&*/ FileSystemOpts, boolean UseDebugInfo/*= false*/, 
                 boolean OnlyLocalDecls/*= false*/, ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > > RemappedFiles/*= None*/, 
                 boolean CaptureDiagnostics/*= false*/, boolean AllowPCHWithCompilerErrors/*= false*/) {
    return LoadFromASTFile(Filename, PCHContainerRdr, 
                 Diags, 
                 FileSystemOpts, UseDebugInfo, 
                 OnlyLocalDecls, RemappedFiles, 
                 CaptureDiagnostics, AllowPCHWithCompilerErrors, 
                 false);
  }
  public static std.unique_ptr<ASTUnit> LoadFromASTFile(/*const*/std.string/*&*/ Filename, /*const*/ PCHContainerReader /*&*/ PCHContainerRdr, 
                 IntrusiveRefCntPtr<DiagnosticsEngine> Diags, 
                 /*const*/ FileSystemOptions /*&*/ FileSystemOpts, boolean UseDebugInfo/*= false*/, 
                 boolean OnlyLocalDecls/*= false*/, ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > > RemappedFiles/*= None*/, 
                 boolean CaptureDiagnostics/*= false*/, boolean AllowPCHWithCompilerErrors/*= false*/, 
                 boolean UserFilesAreVolatile/*= false*/) {
    std.unique_ptr<ASTUnit> AST = null;
    CrashRecoveryContextCleanupRegistrar<ASTUnit> ASTUnitCleanup = null;
    CrashRecoveryContextCleanupRegistrar<DiagnosticsEngine> DiagCleanup = null;
    IntrusiveRefCntPtr<FileSystem> VFS = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      AST/*J*/= new std.unique_ptr<ASTUnit>(new ASTUnit(true));
      
      // Recover resources if we crash before exiting this method.
      ASTUnitCleanup/*J*/= new CrashRecoveryContextCleanupRegistrar<ASTUnit>(AST.get());
      DiagCleanup/*J*/= new CrashRecoveryContextCleanupRegistrar<DiagnosticsEngine>(new CrashRecoveryContextReleaseRefCleanup<DiagnosticsEngine>(), Diags.get());
      
      ConfigureDiags($c$.track(new IntrusiveRefCntPtr<DiagnosticsEngine>(Diags)), AST.$star(), CaptureDiagnostics); $c$.clean();
      
      AST.$arrow().OnlyLocalDecls = OnlyLocalDecls;
      AST.$arrow().CaptureDiagnostics = CaptureDiagnostics;
      $c$.clean(AST.$arrow().Diagnostics.$assign($c$.track(new IntrusiveRefCntPtr<DiagnosticsEngine>(Diags))));
      VFS = VfsGlobals.getRealFileSystem();
      $c$.clean(AST.$arrow().FileMgr.$assign($c$.track(new IntrusiveRefCntPtr<FileManager>(new FileManager(FileSystemOpts, $c$.track(new IntrusiveRefCntPtr<FileSystem>(VFS)))))));
      AST.$arrow().UserFilesAreVolatile = UserFilesAreVolatile;
      $c$.clean(AST.$arrow().SourceMgr.$assign($c$.track(new IntrusiveRefCntPtr<SourceManager>(new SourceManager(AST.$arrow().getDiagnostics(), 
                  AST.$arrow().getFileManager(), 
                  UserFilesAreVolatile)))));
      $c$.clean(AST.$arrow().HSOpts.$assign($c$.track(new IntrusiveRefCntPtr<HeaderSearchOptions>(new HeaderSearchOptions()))));
      AST.$arrow().HSOpts.$arrow().ModuleFormat.$assignMove(PCHContainerRdr.getFormat().$string());
      AST.$arrow().HeaderInfo.reset(new HeaderSearch($c$.track(new IntrusiveRefCntPtr<HeaderSearchOptions>(AST.$arrow().HSOpts)), 
              AST.$arrow().getSourceManager(), 
              AST.$arrow().getDiagnostics(), 
              AST.$arrow().ASTFileLangOpts, 
              /*Target=*/ (/*const*/ TargetInfo /*P*/ )null)); $c$.clean();
      
      PreprocessorOptions /*P*/ PPOpts = new PreprocessorOptions();
      
      for (/*const*/ pair<std.string, MemoryBuffer /*P*/ > /*&*/ RemappedFile : RemappedFiles)  {
        PPOpts.addRemappedFile(new StringRef(RemappedFile.first), RemappedFile.second);
      }
      
      // Gather Info for preprocessor construction later on.
      HeaderSearch /*&*/ HeaderInfo = AST.$arrow().HeaderInfo.$star();
      /*uint*/uint$ref Counter = create_uint$ref();
      
      $c$.clean(AST.$arrow().PP.$assign(
          $c$.track(new IntrusiveRefCntPtr<Preprocessor>(new Preprocessor($c$.track(new IntrusiveRefCntPtr<PreprocessorOptions>(PPOpts)), AST.$arrow().getDiagnostics(), AST.$arrow().ASTFileLangOpts, 
                  AST.$arrow().getSourceManager(), HeaderInfo, AST.$star(), 
                  /*IILookup=*/ (IdentifierInfoLookup /*P*/ )null, 
                  /*OwnsHeaderSearch=*/ false)))
      ));
      Preprocessor /*&*/ PP = AST.$arrow().PP.$star();
      
      $c$.clean(AST.$arrow().Ctx.$assign($c$.track(new IntrusiveRefCntPtr<ASTContext>(new ASTContext(AST.$arrow().ASTFileLangOpts, AST.$arrow().getSourceManager(), 
                  PP.getIdentifierTable(), PP.getSelectorTable(), 
                  PP.getBuiltinInfo())))));
      ASTContext /*&*/ Context = AST.$arrow().Ctx.$star();
      
      boolean disableValid = false;
      if ((/*::*/getenv($("LIBCLANG_DISABLE_PCH_VALIDATION")) != null)) {
        disableValid = true;
      }
      $c$.clean(AST.$arrow().Reader.$assign($c$.track(new IntrusiveRefCntPtr<ASTReader>(new ASTReader(PP, Context, PCHContainerRdr, /*{ */new ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension> >()/* }*/, 
                  /*isysroot=*/ new StringRef(/*KEEP_STR*/$EMPTY), 
                  /*DisableValidation=*/ disableValid, 
                  AllowPCHWithCompilerErrors)))));
      
      AST.$arrow().Reader.$arrow().setListener($c$.track(new std.unique_ptr<ASTReaderListener>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ASTInfoCollector(AST.$arrow().PP.$star(), Context, AST.$arrow().ASTFileLangOpts, AST.$arrow().TargetOpts, AST.$arrow().Target, 
                  Counter)))))); $c$.clean();
      
      // Attach the AST reader to the AST context as an external AST
      // source, so that declarations will be deserialized from the
      // AST file as needed.
      // We need the external source to be set up before we read the AST, because
      // eagerly-deserialized declarations may use it.
      Context.setExternalSource($c$.track(new IntrusiveRefCntPtr<ExternalASTSource>(JD$IntrusiveRefCntPtr$X$C.INSTANCE, AST.$arrow().Reader))); $c$.clean();
      switch (AST.$arrow().Reader.$arrow().ReadAST(new StringRef(Filename), ModuleKind.MK_MainFile, 
          new SourceLocation(), ASTReader.LoadFailureCapabilities.ARR_None)) {
       case Success:
        break;
       case Failure:
       case Missing:
       case OutOfDate:
       case VersionMismatch:
       case ConfigurationMismatch:
       case HadErrors:
        $c$.clean($c$.track(AST.$arrow().getDiagnostics().Report(diag.err_fe_unable_to_load_pch)));
        return new std.unique_ptr<ASTUnit>(JD$NullPtr.INSTANCE, null);
      }
      
      AST.$arrow().OriginalSourceFile.$assignMove(AST.$arrow().Reader.$arrow().getOriginalSourceFile().$string());
      
      PP.setCounterValue(Counter.$deref());
      
      // Create an AST consumer, even though it isn't used.
      AST.$arrow().Consumer.reset(new ASTConsumer());
      
      // Create a semantic analysis object and tell the AST reader about it.
      AST.$arrow().TheSema.reset(new Sema(PP, Context, AST.$arrow().Consumer.$star()));
      AST.$arrow().TheSema.$arrow().Initialize();
      AST.$arrow().Reader.$arrow().InitializeSema(AST.$arrow().TheSema.$star());
      
      // Tell the diagnostic client that we have started a source file.
      AST.$arrow().getDiagnostics().getClient().BeginSourceFile(Context.getLangOpts(), /*AddrOf*/PP);
      
      return new std.unique_ptr<ASTUnit>(JD$Move.INSTANCE, AST);
    } finally {
      if (VFS != null) { VFS.$destroy(); }
      if (DiagCleanup != null) { DiagCleanup.$destroy(); }
      if (ASTUnitCleanup != null) { ASTUnitCleanup.$destroy(); }
      if (AST != null) { AST.$destroy(); }
      $c$.$destroy();
    }
  }

/*private:*/
  /// \brief Helper function for \c LoadFromCompilerInvocation() and
  /// \c LoadFromCommandLine(), which loads an AST from a compiler invocation.
  ///
  /// \param PrecompilePreambleAfterNParses After how many parses the preamble
  /// of this translation unit should be precompiled, to improve the performance
  /// of reparsing. Set to zero to disable preambles.
  ///
  /// \returns \c true if a catastrophic failure occurred (which means that the
  /// \c ASTUnit itself is invalid), or \c false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::LoadFromCompilerInvocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1875,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1866,
   FQN="clang::ASTUnit::LoadFromCompilerInvocation", NM="_ZN5clang7ASTUnit26LoadFromCompilerInvocationESt10shared_ptrINS_22PCHContainerOperationsEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit26LoadFromCompilerInvocationESt10shared_ptrINS_22PCHContainerOperationsEEj")
  //</editor-fold>
  private boolean LoadFromCompilerInvocation(std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                            /*uint*/int PrecompilePreambleAfterNParses) {
    std.unique_ptr<MemoryBuffer> OverrideMainBuffer = null;
    SimpleTimer ParsingTimer = null;
    CrashRecoveryContextCleanupRegistrar<MemoryBuffer> MemBufferCleanup = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!Invocation.$bool()) {
        return true;
      }
      
      // We'll manage file buffers ourselves.
      Invocation.$arrow().getPreprocessorOpts().RetainRemappedFileBuffers = true;
      Invocation.$arrow().getFrontendOpts().DisableFree = false;
      ProcessWarningOptions(getDiagnostics(), Invocation.$arrow().getDiagnosticOpts());
      
      OverrideMainBuffer/*J*/= new std.unique_ptr<MemoryBuffer>();
      if ($greater_uint(PrecompilePreambleAfterNParses, 0)) {
        PreambleRebuildCounter = PrecompilePreambleAfterNParses;
        $c$.clean(OverrideMainBuffer.$assignMove(
            $c$.track(getMainBufferWithPrecompiledPreamble($c$.track(new std.shared_ptr<PCHContainerOperations>(PCHContainerOps)), Invocation.$star()))
        ));
      }
      
      ParsingTimer/*J*/= new SimpleTimer(WantTiming);
      ParsingTimer.setOutput($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"Parsing ", getMainFileName()));
      
      // Recover resources if we crash before exiting this method.
      MemBufferCleanup/*J*/= new CrashRecoveryContextCleanupRegistrar<MemoryBuffer>(OverrideMainBuffer.get());
      
      return $c$.clean(Parse($c$.track(new std.shared_ptr<PCHContainerOperations>(JD$Move.INSTANCE, std.move(PCHContainerOps))), $c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(OverrideMainBuffer)))));
    } finally {
      if (MemBufferCleanup != null) { MemBufferCleanup.$destroy(); }
      if (ParsingTimer != null) { ParsingTimer.$destroy(); }
      if (OverrideMainBuffer != null) { OverrideMainBuffer.$destroy(); }
      $c$.$destroy();
    }
  }

/*public:*/
  
  /// \brief Create an ASTUnit from a source file, via a CompilerInvocation
  /// object, by invoking the optionally provided ASTFrontendAction. 
  ///
  /// \param CI - The compiler invocation to use; it must have exactly one input
  /// source file. The ASTUnit takes ownership of the CompilerInvocation object.
  ///
  /// \param PCHContainerOps - The PCHContainerOperations to use for loading and
  /// creating modules.
  ///
  /// \param Diags - The diagnostics engine to use for reporting errors; its
  /// lifetime is expected to extend past that of the returned ASTUnit.
  ///
  /// \param Action - The ASTFrontendAction to invoke. Its ownership is not
  /// transferred.
  ///
  /// \param Unit - optionally an already created ASTUnit. Its ownership is not
  /// transferred.
  ///
  /// \param Persistent - if true the returned ASTUnit will be complete.
  /// false means the caller is only interested in getting info through the
  /// provided \see Action.
  ///
  /// \param ErrAST - If non-null and parsing failed without any AST to return
  /// (e.g. because the PCH could not be loaded), this accepts the ASTUnit
  /// mainly to allow the caller to see the diagnostics.
  /// This will only receive an ASTUnit if a new one was created. If an already
  /// created ASTUnit was passed in \p Unit then the caller can check that.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::LoadFromCompilerInvocationAction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1732,
   FQN="clang::ASTUnit::LoadFromCompilerInvocationAction", NM="_ZN5clang7ASTUnit32LoadFromCompilerInvocationActionEPNS_18CompilerInvocationESt10shared_ptrINS_22PCHContainerOperationsEEN4llvm18IntrusiveRefCntPtrINS_17DiagnosticsEngineEEEPNS_14FrontendActionEPS0_bNS6_9StringRefEbbjbbbPSt10unique_ptrIS0_St14default_deleteIS0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit32LoadFromCompilerInvocationActionEPNS_18CompilerInvocationESt10shared_ptrINS_22PCHContainerOperationsEEN4llvm18IntrusiveRefCntPtrINS_17DiagnosticsEngineEEEPNS_14FrontendActionEPS0_bNS6_9StringRefEbbjbbbPSt10unique_ptrIS0_St14default_deleteIS0_EE")
  //</editor-fold>
  public static ASTUnit /*P*/ LoadFromCompilerInvocationAction(CompilerInvocation /*P*/ CI, 
                                  std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                                  IntrusiveRefCntPtr<DiagnosticsEngine> Diags) {
    return LoadFromCompilerInvocationAction(CI, 
                                  PCHContainerOps, 
                                  Diags, (FrontendAction /*P*/ )null, 
                                  (ASTUnit /*P*/ )null, true, new StringRef(), 
                                  false, false, 
                                  0, false, 
                                  false, false, 
                                  (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCompilerInvocationAction(CompilerInvocation /*P*/ CI, 
                                  std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                                  IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FrontendAction /*P*/ Action/*= null*/) {
    return LoadFromCompilerInvocationAction(CI, 
                                  PCHContainerOps, 
                                  Diags, Action, 
                                  (ASTUnit /*P*/ )null, true, new StringRef(), 
                                  false, false, 
                                  0, false, 
                                  false, false, 
                                  (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCompilerInvocationAction(CompilerInvocation /*P*/ CI, 
                                  std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                                  IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FrontendAction /*P*/ Action/*= null*/, 
                                  ASTUnit /*P*/ Unit/*= null*/) {
    return LoadFromCompilerInvocationAction(CI, 
                                  PCHContainerOps, 
                                  Diags, Action, 
                                  Unit, true, new StringRef(), 
                                  false, false, 
                                  0, false, 
                                  false, false, 
                                  (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCompilerInvocationAction(CompilerInvocation /*P*/ CI, 
                                  std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                                  IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FrontendAction /*P*/ Action/*= null*/, 
                                  ASTUnit /*P*/ Unit/*= null*/, boolean Persistent/*= true*/) {
    return LoadFromCompilerInvocationAction(CI, 
                                  PCHContainerOps, 
                                  Diags, Action, 
                                  Unit, Persistent, new StringRef(), 
                                  false, false, 
                                  0, false, 
                                  false, false, 
                                  (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCompilerInvocationAction(CompilerInvocation /*P*/ CI, 
                                  std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                                  IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FrontendAction /*P*/ Action/*= null*/, 
                                  ASTUnit /*P*/ Unit/*= null*/, boolean Persistent/*= true*/, StringRef ResourceFilesPath/*= StringRef()*/) {
    return LoadFromCompilerInvocationAction(CI, 
                                  PCHContainerOps, 
                                  Diags, Action, 
                                  Unit, Persistent, ResourceFilesPath, 
                                  false, false, 
                                  0, false, 
                                  false, false, 
                                  (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCompilerInvocationAction(CompilerInvocation /*P*/ CI, 
                                  std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                                  IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FrontendAction /*P*/ Action/*= null*/, 
                                  ASTUnit /*P*/ Unit/*= null*/, boolean Persistent/*= true*/, StringRef ResourceFilesPath/*= StringRef()*/, 
                                  boolean OnlyLocalDecls/*= false*/) {
    return LoadFromCompilerInvocationAction(CI, 
                                  PCHContainerOps, 
                                  Diags, Action, 
                                  Unit, Persistent, ResourceFilesPath, 
                                  OnlyLocalDecls, false, 
                                  0, false, 
                                  false, false, 
                                  (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCompilerInvocationAction(CompilerInvocation /*P*/ CI, 
                                  std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                                  IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FrontendAction /*P*/ Action/*= null*/, 
                                  ASTUnit /*P*/ Unit/*= null*/, boolean Persistent/*= true*/, StringRef ResourceFilesPath/*= StringRef()*/, 
                                  boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/) {
    return LoadFromCompilerInvocationAction(CI, 
                                  PCHContainerOps, 
                                  Diags, Action, 
                                  Unit, Persistent, ResourceFilesPath, 
                                  OnlyLocalDecls, CaptureDiagnostics, 
                                  0, false, 
                                  false, false, 
                                  (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCompilerInvocationAction(CompilerInvocation /*P*/ CI, 
                                  std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                                  IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FrontendAction /*P*/ Action/*= null*/, 
                                  ASTUnit /*P*/ Unit/*= null*/, boolean Persistent/*= true*/, StringRef ResourceFilesPath/*= StringRef()*/, 
                                  boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                                  /*uint*/int PrecompilePreambleAfterNParses/*= 0*/) {
    return LoadFromCompilerInvocationAction(CI, 
                                  PCHContainerOps, 
                                  Diags, Action, 
                                  Unit, Persistent, ResourceFilesPath, 
                                  OnlyLocalDecls, CaptureDiagnostics, 
                                  PrecompilePreambleAfterNParses, false, 
                                  false, false, 
                                  (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCompilerInvocationAction(CompilerInvocation /*P*/ CI, 
                                  std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                                  IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FrontendAction /*P*/ Action/*= null*/, 
                                  ASTUnit /*P*/ Unit/*= null*/, boolean Persistent/*= true*/, StringRef ResourceFilesPath/*= StringRef()*/, 
                                  boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                                  /*uint*/int PrecompilePreambleAfterNParses/*= 0*/, boolean CacheCodeCompletionResults/*= false*/) {
    return LoadFromCompilerInvocationAction(CI, 
                                  PCHContainerOps, 
                                  Diags, Action, 
                                  Unit, Persistent, ResourceFilesPath, 
                                  OnlyLocalDecls, CaptureDiagnostics, 
                                  PrecompilePreambleAfterNParses, CacheCodeCompletionResults, 
                                  false, false, 
                                  (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCompilerInvocationAction(CompilerInvocation /*P*/ CI, 
                                  std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                                  IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FrontendAction /*P*/ Action/*= null*/, 
                                  ASTUnit /*P*/ Unit/*= null*/, boolean Persistent/*= true*/, StringRef ResourceFilesPath/*= StringRef()*/, 
                                  boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                                  /*uint*/int PrecompilePreambleAfterNParses/*= 0*/, boolean CacheCodeCompletionResults/*= false*/, 
                                  boolean IncludeBriefCommentsInCodeCompletion/*= false*/) {
    return LoadFromCompilerInvocationAction(CI, 
                                  PCHContainerOps, 
                                  Diags, Action, 
                                  Unit, Persistent, ResourceFilesPath, 
                                  OnlyLocalDecls, CaptureDiagnostics, 
                                  PrecompilePreambleAfterNParses, CacheCodeCompletionResults, 
                                  IncludeBriefCommentsInCodeCompletion, false, 
                                  (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCompilerInvocationAction(CompilerInvocation /*P*/ CI, 
                                  std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                                  IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FrontendAction /*P*/ Action/*= null*/, 
                                  ASTUnit /*P*/ Unit/*= null*/, boolean Persistent/*= true*/, StringRef ResourceFilesPath/*= StringRef()*/, 
                                  boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                                  /*uint*/int PrecompilePreambleAfterNParses/*= 0*/, boolean CacheCodeCompletionResults/*= false*/, 
                                  boolean IncludeBriefCommentsInCodeCompletion/*= false*/, boolean UserFilesAreVolatile/*= false*/) {
    return LoadFromCompilerInvocationAction(CI, 
                                  PCHContainerOps, 
                                  Diags, Action, 
                                  Unit, Persistent, ResourceFilesPath, 
                                  OnlyLocalDecls, CaptureDiagnostics, 
                                  PrecompilePreambleAfterNParses, CacheCodeCompletionResults, 
                                  IncludeBriefCommentsInCodeCompletion, UserFilesAreVolatile, 
                                  (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCompilerInvocationAction(CompilerInvocation /*P*/ CI, 
                                  std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                                  IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FrontendAction /*P*/ Action/*= null*/, 
                                  ASTUnit /*P*/ Unit/*= null*/, boolean Persistent/*= true*/, StringRef ResourceFilesPath/*= StringRef()*/, 
                                  boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                                  /*uint*/int PrecompilePreambleAfterNParses/*= 0*/, boolean CacheCodeCompletionResults/*= false*/, 
                                  boolean IncludeBriefCommentsInCodeCompletion/*= false*/, boolean UserFilesAreVolatile/*= false*/, 
                                  std.unique_ptr<ASTUnit> /*P*/ ErrAST/*= null*/) {
    std.unique_ptr<ASTUnit> OwnAST = null;
    CrashRecoveryContextCleanupRegistrar<ASTUnit> ASTUnitCleanup = null;
    CrashRecoveryContextCleanupRegistrar<DiagnosticsEngine> DiagCleanup = null;
    std.unique_ptr<CompilerInstance> Clang = null;
    CrashRecoveryContextCleanupRegistrar<CompilerInstance> CICleanup = null;
    std.unique_ptr<TopLevelDeclTrackerAction> TrackerAct = null;
    CrashRecoveryContextCleanupRegistrar<TopLevelDeclTrackerAction> ActCleanup = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert ((CI != null)) : "A CompilerInvocation is required";
      
      OwnAST/*J*/= new std.unique_ptr<ASTUnit>();
      ASTUnit /*P*/ AST = Unit;
      if (!(AST != null)) {
        // Create the AST unit.
        OwnAST.reset(create(CI, $c$.track(new IntrusiveRefCntPtr<DiagnosticsEngine>(Diags)), CaptureDiagnostics, UserFilesAreVolatile)); $c$.clean();
        AST = OwnAST.get();
        if (!(AST != null)) {
          return null;
        }
      }
      if (!ResourceFilesPath.empty()) {
        // Override the resources path.
        CI.getHeaderSearchOpts().ResourceDir.$assignMove(ResourceFilesPath.$string());
      }
      AST.OnlyLocalDecls = OnlyLocalDecls;
      AST.CaptureDiagnostics = CaptureDiagnostics;
      if ($greater_uint(PrecompilePreambleAfterNParses, 0)) {
        AST.PreambleRebuildCounter = PrecompilePreambleAfterNParses;
      }
      AST.TUKind = (Action != null) ? Action.getTranslationUnitKind() : TranslationUnitKind.TU_Complete;
      AST.ShouldCacheCodeCompletionResults = CacheCodeCompletionResults;
      AST.IncludeBriefCommentsInCodeCompletion
         = IncludeBriefCommentsInCodeCompletion;
      
      // Recover resources if we crash before exiting this method.
      ASTUnitCleanup/*J*/= new CrashRecoveryContextCleanupRegistrar<ASTUnit>(OwnAST.get());
      DiagCleanup/*J*/= new CrashRecoveryContextCleanupRegistrar<DiagnosticsEngine>(new CrashRecoveryContextReleaseRefCleanup<DiagnosticsEngine>(), Diags.get());
      
      // We'll manage file buffers ourselves.
      CI.getPreprocessorOpts().RetainRemappedFileBuffers = true;
      CI.getFrontendOpts().DisableFree = false;
      ProcessWarningOptions(AST.getDiagnostics(), CI.getDiagnosticOpts());
      
      // Create the compiler instance to use for building the AST.
      Clang/*J*/= $c$.clean(new std.unique_ptr<CompilerInstance>(new CompilerInstance($c$.track(new std.shared_ptr<PCHContainerOperations>(JD$Move.INSTANCE, std.move(PCHContainerOps))))));
      
      // Recover resources if we crash before exiting this method.
      CICleanup/*J*/= new CrashRecoveryContextCleanupRegistrar<CompilerInstance>(Clang.get());
      
      Clang.$arrow().setInvocation(CI);
      AST.OriginalSourceFile.$assignMove(Clang.$arrow().getFrontendOpts().Inputs.$at(0).getFile().$string());
      
      // Set up diagnostics, capturing any diagnostics that would
      // otherwise be dropped.
      Clang.$arrow().setDiagnostics(/*AddrOf*/AST.getDiagnostics());
      
      // Create the target instance.
      Clang.$arrow().setTarget(TargetInfo.CreateTargetInfo(Clang.$arrow().getDiagnostics(), Clang.$arrow().getInvocation().TargetOpts));
      if (!Clang.$arrow().hasTarget()) {
        return null;
      }
      
      // Inform the target of the language options.
      //
      // FIXME: We shouldn't need to do this, the target should be immutable once
      // created. This complexity should be lifted elsewhere.
      Clang.$arrow().getTarget().adjust(Clang.$arrow().getLangOpts());
      assert (Clang.$arrow().getFrontendOpts().Inputs.size() == 1) : "Invocation must have exactly one source file!";
      assert (Clang.$arrow().getFrontendOpts().Inputs.$at(0).getKind() != InputKind.IK_AST) : "FIXME: AST inputs not yet supported here!";
      assert (Clang.$arrow().getFrontendOpts().Inputs.$at(0).getKind() != InputKind.IK_LLVM_IR) : "IR inputs not supported here!";
      
      // Configure the various subsystems.
      AST.TheSema.reset();
      $c$.clean(AST.Ctx.$assign($c$.track(new IntrusiveRefCntPtr<ASTContext>((ASTContext /*P*/ )null))));
      $c$.clean(AST.PP.$assign($c$.track(new IntrusiveRefCntPtr<Preprocessor>((Preprocessor /*P*/ )null))));
      $c$.clean(AST.Reader.$assign($c$.track(new IntrusiveRefCntPtr<ASTReader>((ASTReader /*P*/ )null))));
      
      // Create a file manager object to provide access to and cache the filesystem.
      Clang.$arrow().setFileManager(/*AddrOf*/AST.getFileManager());
      
      // Create the source manager.
      Clang.$arrow().setSourceManager(/*AddrOf*/AST.getSourceManager());
      
      FrontendAction /*P*/ Act = Action;
      
      TrackerAct/*J*/= new std.unique_ptr<TopLevelDeclTrackerAction>();
      if (!(Act != null)) {
        TrackerAct.reset(new TopLevelDeclTrackerAction(/*Deref*/AST));
        Act = TrackerAct.get();
      }
      
      // Recover resources if we crash before exiting this method.
      ActCleanup/*J*/= new CrashRecoveryContextCleanupRegistrar<TopLevelDeclTrackerAction>(TrackerAct.get());
      if (!Act.BeginSourceFile(/*Deref*/Clang.get(), Clang.$arrow().getFrontendOpts().Inputs.$at(0))) {
        AST.transferASTDataFromCompilerInstance(Clang.$star());
        if (OwnAST.$bool() && (ErrAST != null)) {
          ErrAST.swap(OwnAST);
        }
        
        return null;
      }
      if (Persistent && !TrackerAct.$bool()) {
        std.vector<std.unique_ptr<ASTConsumer>> Consumers = null;
        try {
          Clang.$arrow().getPreprocessor().addPPCallbacks($c$.track(new std.unique_ptr<PPCallbacks>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new MacroDefinitionTrackerPPCallbacks(AST.getCurrentTopLevelHashValue())))))); $c$.clean();
          Consumers/*J*/= new std.vector<std.unique_ptr<ASTConsumer>>(new std.unique_ptr<ASTConsumer>());
          if (Clang.$arrow().hasASTConsumer()) {
            Consumers.push_back_T$RR($c$.track(Clang.$arrow().takeASTConsumer())); $c$.clean();
          }
          Consumers.push_back_T$RR($c$.track(new unique_ptr<ASTConsumer>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new TopLevelDeclTrackerConsumer(/*Deref*/AST, AST.getCurrentTopLevelHashValue())))))); $c$.clean();
          Clang.$arrow().setASTConsumer($c$.track(new std.unique_ptr<ASTConsumer>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new MultiplexConsumer(std.move(Consumers))))))); $c$.clean();
        } finally {
          if (Consumers != null) { Consumers.$destroy(); }
        }
      }
      if (!Act.Execute()) {
        AST.transferASTDataFromCompilerInstance(Clang.$star());
        if (OwnAST.$bool() && (ErrAST != null)) {
          ErrAST.swap(OwnAST);
        }
        
        return null;
      }
      
      // Steal the created target, context, and preprocessor.
      AST.transferASTDataFromCompilerInstance(Clang.$star());
      
      Act.EndSourceFile();
      if (OwnAST.$bool()) {
        return OwnAST.release();
      } else {
        return AST;
      }
    } finally {
      if (ActCleanup != null) { ActCleanup.$destroy(); }
      if (TrackerAct != null) { TrackerAct.$destroy(); }
      if (CICleanup != null) { CICleanup.$destroy(); }
      if (Clang != null) { Clang.$destroy(); }
      if (DiagCleanup != null) { DiagCleanup.$destroy(); }
      if (ASTUnitCleanup != null) { ASTUnitCleanup.$destroy(); }
      if (OwnAST != null) { OwnAST.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// LoadFromCompilerInvocation - Create an ASTUnit from a source file, via a
  /// CompilerInvocation object.
  ///
  /// \param CI - The compiler invocation to use; it must have exactly one input
  /// source file. The ASTUnit takes ownership of the CompilerInvocation object.
  ///
  /// \param PCHContainerOps - The PCHContainerOperations to use for loading and
  /// creating modules.
  ///
  /// \param Diags - The diagnostics engine to use for reporting errors; its
  /// lifetime is expected to extend past that of the returned ASTUnit.
  //
  // FIXME: Move OnlyLocalDecls, UseBumpAllocator to setters on the ASTUnit, we
  // shouldn't need to specify them at construction time.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::LoadFromCompilerInvocation">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1903,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1894,
   FQN="clang::ASTUnit::LoadFromCompilerInvocation", NM="_ZN5clang7ASTUnit26LoadFromCompilerInvocationEPNS_18CompilerInvocationESt10shared_ptrINS_22PCHContainerOperationsEEN4llvm18IntrusiveRefCntPtrINS_17DiagnosticsEngineEEEPNS_11FileManagerEbbjNS_19TranslationUnitKindEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit26LoadFromCompilerInvocationEPNS_18CompilerInvocationESt10shared_ptrINS_22PCHContainerOperationsEEN4llvm18IntrusiveRefCntPtrINS_17DiagnosticsEngineEEEPNS_11FileManagerEbbjNS_19TranslationUnitKindEbbb")
  //</editor-fold>
  public static std.unique_ptr<ASTUnit> LoadFromCompilerInvocation(CompilerInvocation /*P*/ CI, 
                            std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                            IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FileManager /*P*/ FileMgr) {
    return LoadFromCompilerInvocation(CI, 
                            PCHContainerOps, 
                            Diags, FileMgr, 
                            false, false, 
                            0, TranslationUnitKind.TU_Complete, 
                            false, false, 
                            false);
  }
  public static std.unique_ptr<ASTUnit> LoadFromCompilerInvocation(CompilerInvocation /*P*/ CI, 
                            std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                            IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FileManager /*P*/ FileMgr, 
                            boolean OnlyLocalDecls/*= false*/) {
    return LoadFromCompilerInvocation(CI, 
                            PCHContainerOps, 
                            Diags, FileMgr, 
                            OnlyLocalDecls, false, 
                            0, TranslationUnitKind.TU_Complete, 
                            false, false, 
                            false);
  }
  public static std.unique_ptr<ASTUnit> LoadFromCompilerInvocation(CompilerInvocation /*P*/ CI, 
                            std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                            IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FileManager /*P*/ FileMgr, 
                            boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/) {
    return LoadFromCompilerInvocation(CI, 
                            PCHContainerOps, 
                            Diags, FileMgr, 
                            OnlyLocalDecls, CaptureDiagnostics, 
                            0, TranslationUnitKind.TU_Complete, 
                            false, false, 
                            false);
  }
  public static std.unique_ptr<ASTUnit> LoadFromCompilerInvocation(CompilerInvocation /*P*/ CI, 
                            std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                            IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FileManager /*P*/ FileMgr, 
                            boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                            /*uint*/int PrecompilePreambleAfterNParses/*= 0*/) {
    return LoadFromCompilerInvocation(CI, 
                            PCHContainerOps, 
                            Diags, FileMgr, 
                            OnlyLocalDecls, CaptureDiagnostics, 
                            PrecompilePreambleAfterNParses, TranslationUnitKind.TU_Complete, 
                            false, false, 
                            false);
  }
  public static std.unique_ptr<ASTUnit> LoadFromCompilerInvocation(CompilerInvocation /*P*/ CI, 
                            std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                            IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FileManager /*P*/ FileMgr, 
                            boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                            /*uint*/int PrecompilePreambleAfterNParses/*= 0*/, TranslationUnitKind TUKind/*= TU_Complete*/) {
    return LoadFromCompilerInvocation(CI, 
                            PCHContainerOps, 
                            Diags, FileMgr, 
                            OnlyLocalDecls, CaptureDiagnostics, 
                            PrecompilePreambleAfterNParses, TUKind, 
                            false, false, 
                            false);
  }
  public static std.unique_ptr<ASTUnit> LoadFromCompilerInvocation(CompilerInvocation /*P*/ CI, 
                            std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                            IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FileManager /*P*/ FileMgr, 
                            boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                            /*uint*/int PrecompilePreambleAfterNParses/*= 0*/, TranslationUnitKind TUKind/*= TU_Complete*/, 
                            boolean CacheCodeCompletionResults/*= false*/) {
    return LoadFromCompilerInvocation(CI, 
                            PCHContainerOps, 
                            Diags, FileMgr, 
                            OnlyLocalDecls, CaptureDiagnostics, 
                            PrecompilePreambleAfterNParses, TUKind, 
                            CacheCodeCompletionResults, false, 
                            false);
  }
  public static std.unique_ptr<ASTUnit> LoadFromCompilerInvocation(CompilerInvocation /*P*/ CI, 
                            std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                            IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FileManager /*P*/ FileMgr, 
                            boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                            /*uint*/int PrecompilePreambleAfterNParses/*= 0*/, TranslationUnitKind TUKind/*= TU_Complete*/, 
                            boolean CacheCodeCompletionResults/*= false*/, boolean IncludeBriefCommentsInCodeCompletion/*= false*/) {
    return LoadFromCompilerInvocation(CI, 
                            PCHContainerOps, 
                            Diags, FileMgr, 
                            OnlyLocalDecls, CaptureDiagnostics, 
                            PrecompilePreambleAfterNParses, TUKind, 
                            CacheCodeCompletionResults, IncludeBriefCommentsInCodeCompletion, 
                            false);
  }
  public static std.unique_ptr<ASTUnit> LoadFromCompilerInvocation(CompilerInvocation /*P*/ CI, 
                            std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                            IntrusiveRefCntPtr<DiagnosticsEngine> Diags, FileManager /*P*/ FileMgr, 
                            boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                            /*uint*/int PrecompilePreambleAfterNParses/*= 0*/, TranslationUnitKind TUKind/*= TU_Complete*/, 
                            boolean CacheCodeCompletionResults/*= false*/, boolean IncludeBriefCommentsInCodeCompletion/*= false*/, 
                            boolean UserFilesAreVolatile/*= false*/) {
    std.unique_ptr<ASTUnit> AST = null;
    CrashRecoveryContextCleanupRegistrar<ASTUnit> ASTUnitCleanup = null;
    CrashRecoveryContextCleanupRegistrar<DiagnosticsEngine> DiagCleanup = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Create the AST unit.
      AST/*J*/= new std.unique_ptr<ASTUnit>(new ASTUnit(false));
      ConfigureDiags($c$.track(new IntrusiveRefCntPtr<DiagnosticsEngine>(Diags)), AST.$star(), CaptureDiagnostics); $c$.clean();
      $c$.clean(AST.$arrow().Diagnostics.$assign($c$.track(new IntrusiveRefCntPtr<DiagnosticsEngine>(Diags))));
      AST.$arrow().OnlyLocalDecls = OnlyLocalDecls;
      AST.$arrow().CaptureDiagnostics = CaptureDiagnostics;
      AST.$arrow().TUKind = TUKind;
      AST.$arrow().ShouldCacheCodeCompletionResults = CacheCodeCompletionResults;
      AST.$arrow().IncludeBriefCommentsInCodeCompletion
         = IncludeBriefCommentsInCodeCompletion;
      $c$.clean(AST.$arrow().Invocation.$assign($c$.track(new IntrusiveRefCntPtr<CompilerInvocation>(CI))));
      AST.$arrow().FileSystemOpts.$assign(FileMgr.getFileSystemOpts());
      $c$.clean(AST.$arrow().FileMgr.$assign($c$.track(new IntrusiveRefCntPtr<FileManager>(FileMgr))));
      AST.$arrow().UserFilesAreVolatile = UserFilesAreVolatile;
      
      // Recover resources if we crash before exiting this method.
      ASTUnitCleanup/*J*/= new CrashRecoveryContextCleanupRegistrar<ASTUnit>(AST.get());
      DiagCleanup/*J*/= new CrashRecoveryContextCleanupRegistrar<DiagnosticsEngine>(new CrashRecoveryContextReleaseRefCleanup<DiagnosticsEngine>(), Diags.get());
      if ($c$.clean(AST.$arrow().LoadFromCompilerInvocation($c$.track(new std.shared_ptr<PCHContainerOperations>(JD$Move.INSTANCE, std.move(PCHContainerOps))), 
          PrecompilePreambleAfterNParses))) {
        return new std.unique_ptr<ASTUnit>(JD$NullPtr.INSTANCE, null);
      }
      return new std.unique_ptr<ASTUnit>(JD$Move.INSTANCE, AST);
    } finally {
      if (DiagCleanup != null) { DiagCleanup.$destroy(); }
      if (ASTUnitCleanup != null) { ASTUnitCleanup.$destroy(); }
      if (AST != null) { AST.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// LoadFromCommandLine - Create an ASTUnit from a vector of command line
  /// arguments, which must specify exactly one source file.
  ///
  /// \param ArgBegin - The beginning of the argument vector.
  ///
  /// \param ArgEnd - The end of the argument vector.
  ///
  /// \param PCHContainerOps - The PCHContainerOperations to use for loading and
  /// creating modules.
  ///
  /// \param Diags - The diagnostics engine to use for reporting errors; its
  /// lifetime is expected to extend past that of the returned ASTUnit.
  ///
  /// \param ResourceFilesPath - The path to the compiler resource files.
  ///
  /// \param ModuleFormat - If provided, uses the specific module format.
  ///
  /// \param ErrAST - If non-null and parsing failed without any AST to return
  /// (e.g. because the PCH could not be loaded), this accepts the ASTUnit
  /// mainly to allow the caller to see the diagnostics.
  ///
  // FIXME: Move OnlyLocalDecls, UseBumpAllocator to setters on the ASTUnit, we
  // shouldn't need to specify them at construction time.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::LoadFromCommandLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1939,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1930,
   FQN="clang::ASTUnit::LoadFromCommandLine", NM="_ZN5clang7ASTUnit19LoadFromCommandLineEPPKcS3_St10shared_ptrINS_22PCHContainerOperationsEEN4llvm18IntrusiveRefCntPtrINS_17DiagnosticsEngineEEENS7_9StringRefEbbNS7_8ArrayRefISt4pairISsPNS7_12MemoryBufferEEEEbjNS_19TranslationUnitKindEbbbbbbNS7_8OptionalISB_EEPSt10unique_ptrIS0_St14default_deleteIS0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit19LoadFromCommandLineEPPKcS3_St10shared_ptrINS_22PCHContainerOperationsEEN4llvm18IntrusiveRefCntPtrINS_17DiagnosticsEngineEEENS7_9StringRefEbbNS7_8ArrayRefISt4pairISsPNS7_12MemoryBufferEEEEbjNS_19TranslationUnitKindEbbbbbbNS7_8OptionalISB_EEPSt10unique_ptrIS0_St14default_deleteIS0_EE")
  //</editor-fold>
  public static ASTUnit /*P*/ LoadFromCommandLine(/*const*/type$ptr<char$ptr>/*char PP*/ ArgBegin, /*const*/type$ptr<char$ptr>/*char PP*/ ArgEnd, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                     IntrusiveRefCntPtr<DiagnosticsEngine> Diags, StringRef ResourceFilesPath) {
    return LoadFromCommandLine(ArgBegin, ArgEnd, 
                     PCHContainerOps, 
                     Diags, ResourceFilesPath, 
                     false, false, 
                     new ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > >(None), true, 
                     0, TranslationUnitKind.TU_Complete, 
                     false, false, 
                     false, false, 
                     false, false, 
                     new Optional<StringRef>(llvm.None), (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCommandLine(/*const*/type$ptr<char$ptr>/*char PP*/ ArgBegin, /*const*/type$ptr<char$ptr>/*char PP*/ ArgEnd, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                     IntrusiveRefCntPtr<DiagnosticsEngine> Diags, StringRef ResourceFilesPath, 
                     boolean OnlyLocalDecls/*= false*/) {
    return LoadFromCommandLine(ArgBegin, ArgEnd, 
                     PCHContainerOps, 
                     Diags, ResourceFilesPath, 
                     OnlyLocalDecls, false, 
                     new ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > >(None), true, 
                     0, TranslationUnitKind.TU_Complete, 
                     false, false, 
                     false, false, 
                     false, false, 
                     new Optional<StringRef>(llvm.None), (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCommandLine(/*const*/type$ptr<char$ptr>/*char PP*/ ArgBegin, /*const*/type$ptr<char$ptr>/*char PP*/ ArgEnd, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                     IntrusiveRefCntPtr<DiagnosticsEngine> Diags, StringRef ResourceFilesPath, 
                     boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/) {
    return LoadFromCommandLine(ArgBegin, ArgEnd, 
                     PCHContainerOps, 
                     Diags, ResourceFilesPath, 
                     OnlyLocalDecls, CaptureDiagnostics, 
                     new ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > >(None), true, 
                     0, TranslationUnitKind.TU_Complete, 
                     false, false, 
                     false, false, 
                     false, false, 
                     new Optional<StringRef>(llvm.None), (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCommandLine(/*const*/type$ptr<char$ptr>/*char PP*/ ArgBegin, /*const*/type$ptr<char$ptr>/*char PP*/ ArgEnd, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                     IntrusiveRefCntPtr<DiagnosticsEngine> Diags, StringRef ResourceFilesPath, 
                     boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                     ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > > RemappedFiles/*= None*/) {
    return LoadFromCommandLine(ArgBegin, ArgEnd, 
                     PCHContainerOps, 
                     Diags, ResourceFilesPath, 
                     OnlyLocalDecls, CaptureDiagnostics, 
                     RemappedFiles, true, 
                     0, TranslationUnitKind.TU_Complete, 
                     false, false, 
                     false, false, 
                     false, false, 
                     new Optional<StringRef>(llvm.None), (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCommandLine(/*const*/type$ptr<char$ptr>/*char PP*/ ArgBegin, /*const*/type$ptr<char$ptr>/*char PP*/ ArgEnd, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                     IntrusiveRefCntPtr<DiagnosticsEngine> Diags, StringRef ResourceFilesPath, 
                     boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                     ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > > RemappedFiles/*= None*/, boolean RemappedFilesKeepOriginalName/*= true*/) {
    return LoadFromCommandLine(ArgBegin, ArgEnd, 
                     PCHContainerOps, 
                     Diags, ResourceFilesPath, 
                     OnlyLocalDecls, CaptureDiagnostics, 
                     RemappedFiles, RemappedFilesKeepOriginalName, 
                     0, TranslationUnitKind.TU_Complete, 
                     false, false, 
                     false, false, 
                     false, false, 
                     new Optional<StringRef>(llvm.None), (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCommandLine(/*const*/type$ptr<char$ptr>/*char PP*/ ArgBegin, /*const*/type$ptr<char$ptr>/*char PP*/ ArgEnd, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                     IntrusiveRefCntPtr<DiagnosticsEngine> Diags, StringRef ResourceFilesPath, 
                     boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                     ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > > RemappedFiles/*= None*/, boolean RemappedFilesKeepOriginalName/*= true*/, 
                     /*uint*/int PrecompilePreambleAfterNParses/*= 0*/) {
    return LoadFromCommandLine(ArgBegin, ArgEnd, 
                     PCHContainerOps, 
                     Diags, ResourceFilesPath, 
                     OnlyLocalDecls, CaptureDiagnostics, 
                     RemappedFiles, RemappedFilesKeepOriginalName, 
                     PrecompilePreambleAfterNParses, TranslationUnitKind.TU_Complete, 
                     false, false, 
                     false, false, 
                     false, false, 
                     new Optional<StringRef>(llvm.None), (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCommandLine(/*const*/type$ptr<char$ptr>/*char PP*/ ArgBegin, /*const*/type$ptr<char$ptr>/*char PP*/ ArgEnd, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                     IntrusiveRefCntPtr<DiagnosticsEngine> Diags, StringRef ResourceFilesPath, 
                     boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                     ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > > RemappedFiles/*= None*/, boolean RemappedFilesKeepOriginalName/*= true*/, 
                     /*uint*/int PrecompilePreambleAfterNParses/*= 0*/, TranslationUnitKind TUKind/*= TU_Complete*/) {
    return LoadFromCommandLine(ArgBegin, ArgEnd, 
                     PCHContainerOps, 
                     Diags, ResourceFilesPath, 
                     OnlyLocalDecls, CaptureDiagnostics, 
                     RemappedFiles, RemappedFilesKeepOriginalName, 
                     PrecompilePreambleAfterNParses, TUKind, 
                     false, false, 
                     false, false, 
                     false, false, 
                     new Optional<StringRef>(llvm.None), (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCommandLine(/*const*/type$ptr<char$ptr>/*char PP*/ ArgBegin, /*const*/type$ptr<char$ptr>/*char PP*/ ArgEnd, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                     IntrusiveRefCntPtr<DiagnosticsEngine> Diags, StringRef ResourceFilesPath, 
                     boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                     ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > > RemappedFiles/*= None*/, boolean RemappedFilesKeepOriginalName/*= true*/, 
                     /*uint*/int PrecompilePreambleAfterNParses/*= 0*/, TranslationUnitKind TUKind/*= TU_Complete*/, 
                     boolean CacheCodeCompletionResults/*= false*/) {
    return LoadFromCommandLine(ArgBegin, ArgEnd, 
                     PCHContainerOps, 
                     Diags, ResourceFilesPath, 
                     OnlyLocalDecls, CaptureDiagnostics, 
                     RemappedFiles, RemappedFilesKeepOriginalName, 
                     PrecompilePreambleAfterNParses, TUKind, 
                     CacheCodeCompletionResults, false, 
                     false, false, 
                     false, false, 
                     new Optional<StringRef>(llvm.None), (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCommandLine(/*const*/type$ptr<char$ptr>/*char PP*/ ArgBegin, /*const*/type$ptr<char$ptr>/*char PP*/ ArgEnd, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                     IntrusiveRefCntPtr<DiagnosticsEngine> Diags, StringRef ResourceFilesPath, 
                     boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                     ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > > RemappedFiles/*= None*/, boolean RemappedFilesKeepOriginalName/*= true*/, 
                     /*uint*/int PrecompilePreambleAfterNParses/*= 0*/, TranslationUnitKind TUKind/*= TU_Complete*/, 
                     boolean CacheCodeCompletionResults/*= false*/, boolean IncludeBriefCommentsInCodeCompletion/*= false*/) {
    return LoadFromCommandLine(ArgBegin, ArgEnd, 
                     PCHContainerOps, 
                     Diags, ResourceFilesPath, 
                     OnlyLocalDecls, CaptureDiagnostics, 
                     RemappedFiles, RemappedFilesKeepOriginalName, 
                     PrecompilePreambleAfterNParses, TUKind, 
                     CacheCodeCompletionResults, IncludeBriefCommentsInCodeCompletion, 
                     false, false, 
                     false, false, 
                     new Optional<StringRef>(llvm.None), (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCommandLine(/*const*/type$ptr<char$ptr>/*char PP*/ ArgBegin, /*const*/type$ptr<char$ptr>/*char PP*/ ArgEnd, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                     IntrusiveRefCntPtr<DiagnosticsEngine> Diags, StringRef ResourceFilesPath, 
                     boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                     ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > > RemappedFiles/*= None*/, boolean RemappedFilesKeepOriginalName/*= true*/, 
                     /*uint*/int PrecompilePreambleAfterNParses/*= 0*/, TranslationUnitKind TUKind/*= TU_Complete*/, 
                     boolean CacheCodeCompletionResults/*= false*/, boolean IncludeBriefCommentsInCodeCompletion/*= false*/, 
                     boolean AllowPCHWithCompilerErrors/*= false*/) {
    return LoadFromCommandLine(ArgBegin, ArgEnd, 
                     PCHContainerOps, 
                     Diags, ResourceFilesPath, 
                     OnlyLocalDecls, CaptureDiagnostics, 
                     RemappedFiles, RemappedFilesKeepOriginalName, 
                     PrecompilePreambleAfterNParses, TUKind, 
                     CacheCodeCompletionResults, IncludeBriefCommentsInCodeCompletion, 
                     AllowPCHWithCompilerErrors, false, 
                     false, false, 
                     new Optional<StringRef>(llvm.None), (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCommandLine(/*const*/type$ptr<char$ptr>/*char PP*/ ArgBegin, /*const*/type$ptr<char$ptr>/*char PP*/ ArgEnd, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                     IntrusiveRefCntPtr<DiagnosticsEngine> Diags, StringRef ResourceFilesPath, 
                     boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                     ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > > RemappedFiles/*= None*/, boolean RemappedFilesKeepOriginalName/*= true*/, 
                     /*uint*/int PrecompilePreambleAfterNParses/*= 0*/, TranslationUnitKind TUKind/*= TU_Complete*/, 
                     boolean CacheCodeCompletionResults/*= false*/, boolean IncludeBriefCommentsInCodeCompletion/*= false*/, 
                     boolean AllowPCHWithCompilerErrors/*= false*/, boolean SkipFunctionBodies/*= false*/) {
    return LoadFromCommandLine(ArgBegin, ArgEnd, 
                     PCHContainerOps, 
                     Diags, ResourceFilesPath, 
                     OnlyLocalDecls, CaptureDiagnostics, 
                     RemappedFiles, RemappedFilesKeepOriginalName, 
                     PrecompilePreambleAfterNParses, TUKind, 
                     CacheCodeCompletionResults, IncludeBriefCommentsInCodeCompletion, 
                     AllowPCHWithCompilerErrors, SkipFunctionBodies, 
                     false, false, 
                     new Optional<StringRef>(llvm.None), (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCommandLine(/*const*/type$ptr<char$ptr>/*char PP*/ ArgBegin, /*const*/type$ptr<char$ptr>/*char PP*/ ArgEnd, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                     IntrusiveRefCntPtr<DiagnosticsEngine> Diags, StringRef ResourceFilesPath, 
                     boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                     ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > > RemappedFiles/*= None*/, boolean RemappedFilesKeepOriginalName/*= true*/, 
                     /*uint*/int PrecompilePreambleAfterNParses/*= 0*/, TranslationUnitKind TUKind/*= TU_Complete*/, 
                     boolean CacheCodeCompletionResults/*= false*/, boolean IncludeBriefCommentsInCodeCompletion/*= false*/, 
                     boolean AllowPCHWithCompilerErrors/*= false*/, boolean SkipFunctionBodies/*= false*/, 
                     boolean UserFilesAreVolatile/*= false*/) {
    return LoadFromCommandLine(ArgBegin, ArgEnd, 
                     PCHContainerOps, 
                     Diags, ResourceFilesPath, 
                     OnlyLocalDecls, CaptureDiagnostics, 
                     RemappedFiles, RemappedFilesKeepOriginalName, 
                     PrecompilePreambleAfterNParses, TUKind, 
                     CacheCodeCompletionResults, IncludeBriefCommentsInCodeCompletion, 
                     AllowPCHWithCompilerErrors, SkipFunctionBodies, 
                     UserFilesAreVolatile, false, 
                     new Optional<StringRef>(llvm.None), (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCommandLine(/*const*/type$ptr<char$ptr>/*char PP*/ ArgBegin, /*const*/type$ptr<char$ptr>/*char PP*/ ArgEnd, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                     IntrusiveRefCntPtr<DiagnosticsEngine> Diags, StringRef ResourceFilesPath, 
                     boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                     ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > > RemappedFiles/*= None*/, boolean RemappedFilesKeepOriginalName/*= true*/, 
                     /*uint*/int PrecompilePreambleAfterNParses/*= 0*/, TranslationUnitKind TUKind/*= TU_Complete*/, 
                     boolean CacheCodeCompletionResults/*= false*/, boolean IncludeBriefCommentsInCodeCompletion/*= false*/, 
                     boolean AllowPCHWithCompilerErrors/*= false*/, boolean SkipFunctionBodies/*= false*/, 
                     boolean UserFilesAreVolatile/*= false*/, boolean ForSerialization/*= false*/) {
    return LoadFromCommandLine(ArgBegin, ArgEnd, 
                     PCHContainerOps, 
                     Diags, ResourceFilesPath, 
                     OnlyLocalDecls, CaptureDiagnostics, 
                     RemappedFiles, RemappedFilesKeepOriginalName, 
                     PrecompilePreambleAfterNParses, TUKind, 
                     CacheCodeCompletionResults, IncludeBriefCommentsInCodeCompletion, 
                     AllowPCHWithCompilerErrors, SkipFunctionBodies, 
                     UserFilesAreVolatile, ForSerialization, 
                     new Optional<StringRef>(llvm.None), (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCommandLine(/*const*/type$ptr<char$ptr>/*char PP*/ ArgBegin, /*const*/type$ptr<char$ptr>/*char PP*/ ArgEnd, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                     IntrusiveRefCntPtr<DiagnosticsEngine> Diags, StringRef ResourceFilesPath, 
                     boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                     ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > > RemappedFiles/*= None*/, boolean RemappedFilesKeepOriginalName/*= true*/, 
                     /*uint*/int PrecompilePreambleAfterNParses/*= 0*/, TranslationUnitKind TUKind/*= TU_Complete*/, 
                     boolean CacheCodeCompletionResults/*= false*/, boolean IncludeBriefCommentsInCodeCompletion/*= false*/, 
                     boolean AllowPCHWithCompilerErrors/*= false*/, boolean SkipFunctionBodies/*= false*/, 
                     boolean UserFilesAreVolatile/*= false*/, boolean ForSerialization/*= false*/, 
                     Optional<StringRef> ModuleFormat/*= llvm::None*/) {
    return LoadFromCommandLine(ArgBegin, ArgEnd, 
                     PCHContainerOps, 
                     Diags, ResourceFilesPath, 
                     OnlyLocalDecls, CaptureDiagnostics, 
                     RemappedFiles, RemappedFilesKeepOriginalName, 
                     PrecompilePreambleAfterNParses, TUKind, 
                     CacheCodeCompletionResults, IncludeBriefCommentsInCodeCompletion, 
                     AllowPCHWithCompilerErrors, SkipFunctionBodies, 
                     UserFilesAreVolatile, ForSerialization, 
                     ModuleFormat, (std.unique_ptr<ASTUnit> /*P*/ )null);
  }
  public static ASTUnit /*P*/ LoadFromCommandLine(/*const*/type$ptr<char$ptr>/*char PP*/ ArgBegin, /*const*/type$ptr<char$ptr>/*char PP*/ ArgEnd, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
                     IntrusiveRefCntPtr<DiagnosticsEngine> Diags, StringRef ResourceFilesPath, 
                     boolean OnlyLocalDecls/*= false*/, boolean CaptureDiagnostics/*= false*/, 
                     ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > > RemappedFiles/*= None*/, boolean RemappedFilesKeepOriginalName/*= true*/, 
                     /*uint*/int PrecompilePreambleAfterNParses/*= 0*/, TranslationUnitKind TUKind/*= TU_Complete*/, 
                     boolean CacheCodeCompletionResults/*= false*/, boolean IncludeBriefCommentsInCodeCompletion/*= false*/, 
                     boolean AllowPCHWithCompilerErrors/*= false*/, boolean SkipFunctionBodies/*= false*/, 
                     boolean UserFilesAreVolatile/*= false*/, boolean ForSerialization/*= false*/, 
                     Optional<StringRef> ModuleFormat/*= llvm::None*/, std.unique_ptr<ASTUnit> /*P*/ ErrAST/*= null*/) {
    SmallVector<StoredDiagnostic> StoredDiagnostics = null;
    IntrusiveRefCntPtr<CompilerInvocation> CI = null;
    std.unique_ptr<ASTUnit> AST = null;
    IntrusiveRefCntPtr<FileSystem> VFS = null;
    CrashRecoveryContextCleanupRegistrar<ASTUnit> ASTUnitCleanup = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert ((Diags.get() != null)) : "no DiagnosticsEngine was provided";
      
      StoredDiagnostics/*J*/= new SmallVector<StoredDiagnostic>(4, new StoredDiagnostic());
      
      CI/*J*/= new IntrusiveRefCntPtr<CompilerInvocation>();
      {
        CaptureDroppedDiagnostics Capture = null;
        try {
          
          Capture/*J*/= new CaptureDroppedDiagnostics(CaptureDiagnostics, Diags.$star(), 
              StoredDiagnostics);
          
          $c$.clean(CI.$assign($c$.track(new IntrusiveRefCntPtr<CompilerInvocation>(createInvocationFromCommandLine(llvm.makeArrayRef(ArgBegin, ArgEnd), 
                      $c$.track(new IntrusiveRefCntPtr<DiagnosticsEngine>(Diags)))))));
          if (!CI.$bool()) {
            return null;
          }
        } finally {
          if (Capture != null) { Capture.$destroy(); }
        }
      }
      
      // Override any files that need remapping
      for (/*const*/ pair<std.string, MemoryBuffer /*P*/ > /*&*/ RemappedFile : RemappedFiles) {
        CI.$arrow().getPreprocessorOpts().addRemappedFile(new StringRef(RemappedFile.first), 
            RemappedFile.second);
      }
      PreprocessorOptions /*&*/ PPOpts = CI.$arrow().getPreprocessorOpts();
      PPOpts.RemappedFilesKeepOriginalName = RemappedFilesKeepOriginalName;
      PPOpts.AllowPCHWithCompilerErrors = AllowPCHWithCompilerErrors;
      
      // Override the resources path.
      CI.$arrow().getHeaderSearchOpts().ResourceDir.$assignMove(ResourceFilesPath.$string());
      
      CI.$arrow().getFrontendOpts().SkipFunctionBodies = SkipFunctionBodies;
      if (ModuleFormat.$bool()) {
        CI.$arrow().getHeaderSearchOpts().ModuleFormat.$assignMove(ModuleFormat.getValue().$string());
      }
      
      // Create the AST unit.
      AST/*J*/= new std.unique_ptr<ASTUnit>();
      AST.reset(new ASTUnit(false));
      ConfigureDiags($c$.track(new IntrusiveRefCntPtr<DiagnosticsEngine>(Diags)), AST.$star(), CaptureDiagnostics); $c$.clean();
      $c$.clean(AST.$arrow().Diagnostics.$assign($c$.track(new IntrusiveRefCntPtr<DiagnosticsEngine>(Diags))));
      AST.$arrow().FileSystemOpts.$assign(CI.$arrow().getFileSystemOpts());
      VFS = createVFSFromCompilerInvocation(CI.$star(), Diags.$star());
      if (!VFS.$bool()) {
        return null;
      }
      $c$.clean(AST.$arrow().FileMgr.$assign($c$.track(new IntrusiveRefCntPtr<FileManager>(new FileManager(AST.$arrow().FileSystemOpts, $c$.track(new IntrusiveRefCntPtr<FileSystem>(VFS)))))));
      AST.$arrow().OnlyLocalDecls = OnlyLocalDecls;
      AST.$arrow().CaptureDiagnostics = CaptureDiagnostics;
      AST.$arrow().TUKind = TUKind;
      AST.$arrow().ShouldCacheCodeCompletionResults = CacheCodeCompletionResults;
      AST.$arrow().IncludeBriefCommentsInCodeCompletion
         = IncludeBriefCommentsInCodeCompletion;
      AST.$arrow().UserFilesAreVolatile = UserFilesAreVolatile;
      AST.$arrow().NumStoredDiagnosticsFromDriver = StoredDiagnostics.size();
      AST.$arrow().StoredDiagnostics.swap(StoredDiagnostics);
      $c$.clean(AST.$arrow().Invocation.$assign($c$.track(new IntrusiveRefCntPtr<CompilerInvocation>(CI))));
      if (ForSerialization) {
        AST.$arrow().WriterData.reset(new ASTWriterData());
      }
      // Zero out now to ease cleanup during crash recovery.
      $c$.clean(CI.$assign($c$.track(new IntrusiveRefCntPtr<CompilerInvocation>((CompilerInvocation /*P*/ )null))));
      $c$.clean(Diags.$assign($c$.track(new IntrusiveRefCntPtr<DiagnosticsEngine>((DiagnosticsEngine /*P*/ )null))));
      
      // Recover resources if we crash before exiting this method.
      ASTUnitCleanup/*J*/= new CrashRecoveryContextCleanupRegistrar<ASTUnit>(AST.get());
      if ($c$.clean(AST.$arrow().LoadFromCompilerInvocation($c$.track(new std.shared_ptr<PCHContainerOperations>(JD$Move.INSTANCE, std.move(PCHContainerOps))), 
          PrecompilePreambleAfterNParses))) {
        // Some error occurred, if caller wants to examine diagnostics, pass it the
        // ASTUnit.
        if ((ErrAST != null)) {
          AST.$arrow().StoredDiagnostics.swap(AST.$arrow().FailedParseDiagnostics);
          ErrAST.swap(AST);
        }
        return null;
      }
      
      return AST.release();
    } finally {
      if (ASTUnitCleanup != null) { ASTUnitCleanup.$destroy(); }
      if (VFS != null) { VFS.$destroy(); }
      if (AST != null) { AST.$destroy(); }
      if (CI != null) { CI.$destroy(); }
      if (StoredDiagnostics != null) { StoredDiagnostics.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief Reparse the source files using the same command-line options that
  /// were originally used to produce this translation unit.
  ///
  /// \returns True if a failure occurred that causes the ASTUnit not to
  /// contain any translation-unit information, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::Reparse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2030,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2021,
   FQN="clang::ASTUnit::Reparse", NM="_ZN5clang7ASTUnit7ReparseESt10shared_ptrINS_22PCHContainerOperationsEEN4llvm8ArrayRefISt4pairISsPNS4_12MemoryBufferEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit7ReparseESt10shared_ptrINS_22PCHContainerOperationsEEN4llvm8ArrayRefISt4pairISsPNS4_12MemoryBufferEEEE")
  //</editor-fold>
  public boolean Reparse(std.shared_ptr<PCHContainerOperations> PCHContainerOps) {
    return Reparse(PCHContainerOps, 
         new ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > >(None));
  }
  public boolean Reparse(std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
         ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > > RemappedFiles/*= None*/) {
    SimpleTimer ParsingTimer = null;
    std.unique_ptr<MemoryBuffer> OverrideMainBuffer = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!Invocation.$bool()) {
        return true;
      }
      
      clearFileLevelDecls();
      
      ParsingTimer/*J*/= new SimpleTimer(WantTiming);
      ParsingTimer.setOutput($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"Reparsing ", getMainFileName()));
      
      // Remap files.
      PreprocessorOptions /*&*/ PPOpts = Invocation.$arrow().getPreprocessorOpts();
      for (/*const*/ pair<std.string, MemoryBuffer /*P*/ > /*&*/ RB : PPOpts.RemappedFileBuffers)  {
        if (RB.second != null) { RB.second.$destroy();};
      }
      
      Invocation.$arrow().getPreprocessorOpts().clearRemappedFiles();
      for (/*const*/ pair<std.string, MemoryBuffer /*P*/ > /*&*/ RemappedFile : RemappedFiles) {
        Invocation.$arrow().getPreprocessorOpts().addRemappedFile(new StringRef(RemappedFile.first), 
            RemappedFile.second);
      }
      
      // If we have a preamble file lying around, or if we might try to
      // build a precompiled preamble, do so now.
      OverrideMainBuffer/*J*/= new std.unique_ptr<MemoryBuffer>();
      if (!getPreambleFile(this).empty() || $greater_uint(PreambleRebuildCounter, 0)) {
        $c$.clean(OverrideMainBuffer.$assignMove(
            $c$.track(getMainBufferWithPrecompiledPreamble($c$.track(new std.shared_ptr<PCHContainerOperations>(PCHContainerOps)), Invocation.$star()))
        ));
      }
      
      // Clear out the diagnostics state.
      FileMgr.reset();
      getDiagnostics().Reset();
      ProcessWarningOptions(getDiagnostics(), Invocation.$arrow().getDiagnosticOpts());
      if (OverrideMainBuffer.$bool()) {
        getDiagnostics().setNumWarnings(NumWarningsInPreamble);
      }
      
      // Parse the sources
      boolean Result = $c$.clean(Parse($c$.track(new std.shared_ptr<PCHContainerOperations>(JD$Move.INSTANCE, std.move(PCHContainerOps))), $c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(OverrideMainBuffer)))));
      
      // If we're caching global code-completion results, and the top-level 
      // declarations have changed, clear out the code-completion cache.
      if (!Result && ShouldCacheCodeCompletionResults
         && CurrentTopLevelHashValue != CompletionCacheTopLevelHashValue) {
        CacheCodeCompletionResults();
      }
      
      // We now need to clear out the completion info related to this translation
      // unit; it'll be recreated if necessary.
      CCTUInfo.reset();
      
      return Result;
    } finally {
      if (OverrideMainBuffer != null) { OverrideMainBuffer.$destroy(); }
      if (ParsingTimer != null) { ParsingTimer.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief Perform code completion at the given file, line, and
  /// column within this translation unit.
  ///
  /// \param File The file in which code completion will occur.
  ///
  /// \param Line The line at which code completion will occur.
  ///
  /// \param Column The column at which code completion will occur.
  ///
  /// \param IncludeMacros Whether to include macros in the code-completion 
  /// results.
  ///
  /// \param IncludeCodePatterns Whether to include code patterns (such as a 
  /// for loop) in the code-completion results.
  ///
  /// \param IncludeBriefComments Whether to include brief documentation within
  /// the set of code completions returned.
  ///
  /// FIXME: The Diag, LangOpts, SourceMgr, FileMgr, StoredDiagnostics, and
  /// OwnedBuffers parameters are all disgusting hacks. They will go away.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::CodeComplete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2318,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2308,
   FQN="clang::ASTUnit::CodeComplete", NM="_ZN5clang7ASTUnit12CodeCompleteEN4llvm9StringRefEjjNS1_8ArrayRefISt4pairISsPNS1_12MemoryBufferEEEEbbbRNS_20CodeCompleteConsumerESt10shared_ptrINS_22PCHContainerOperationsEERNS_17DiagnosticsEngineERNS_11LangOptionsERNS_13SourceManagerERNS_11FileManagerERNS1_15SmallVectorImplINS_16StoredDiagnosticEEERNSM_IPKS5_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit12CodeCompleteEN4llvm9StringRefEjjNS1_8ArrayRefISt4pairISsPNS1_12MemoryBufferEEEEbbbRNS_20CodeCompleteConsumerESt10shared_ptrINS_22PCHContainerOperationsEERNS_17DiagnosticsEngineERNS_11LangOptionsERNS_13SourceManagerERNS_11FileManagerERNS1_15SmallVectorImplINS_16StoredDiagnosticEEERNSM_IPKS5_EE")
  //</editor-fold>
  public void CodeComplete(StringRef File, /*uint*/int Line, /*uint*/int Column, 
              ArrayRef<std.pair<std.string, MemoryBuffer /*P*/ > > RemappedFiles, boolean IncludeMacros, 
              boolean IncludeCodePatterns, boolean IncludeBriefComments, 
              CodeCompleteConsumer /*&*/ Consumer, 
              std.shared_ptr<PCHContainerOperations> PCHContainerOps, 
              DiagnosticsEngine /*&*/ Diag, LangOptions /*&*/ LangOpts, SourceManager /*&*/ SourceMgr, 
              FileManager /*&*/ FileMgr, SmallVectorImpl<StoredDiagnostic> /*&*/ StoredDiagnostics, 
              SmallVectorImpl</*const*/ MemoryBuffer /*P*/ > /*&*/ OwnedBuffers) {
    SimpleTimer CompletionTimer = null;
    IntrusiveRefCntPtr<CompilerInvocation> CCInvocation = null;
    std.unique_ptr<CompilerInstance> Clang = null;
    CrashRecoveryContextCleanupRegistrar<CompilerInstance> CICleanup = null;
    CaptureDroppedDiagnostics Capture = null;
    std.unique_ptr<MemoryBuffer> OverrideMainBuffer = null;
    std.unique_ptr<SyntaxOnlyAction> Act = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!Invocation.$bool()) {
        return;
      }
      
      CompletionTimer/*J*/= new SimpleTimer(WantTiming);
      CompletionTimer.setOutput($add_Twine$C($add_Twine$C($add_Twine$C($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"Code completion @ ", File), new Twine(/*KEEP_STR*/$COLON)), 
                      new Twine(JD$UInt.INSTANCE, Line)), new Twine(/*KEEP_STR*/$COLON)), new Twine(JD$UInt.INSTANCE, Column)));
      
      CCInvocation/*J*/= new IntrusiveRefCntPtr<CompilerInvocation>(new CompilerInvocation(Invocation.$star()));
      
      FrontendOptions /*&*/ FrontendOpts = CCInvocation.$arrow().getFrontendOpts();
      CodeCompleteOptions /*&*/ CodeCompleteOpts = FrontendOpts.CodeCompleteOpts;
      PreprocessorOptions /*&*/ PreprocessorOpts = CCInvocation.$arrow().getPreprocessorOpts();
      
      CodeCompleteOpts.IncludeMacros = IncludeMacros
         && CachedCompletionResults.empty();
      CodeCompleteOpts.IncludeCodePatterns = IncludeCodePatterns;
      CodeCompleteOpts.IncludeGlobals = CachedCompletionResults.empty();
      CodeCompleteOpts.IncludeBriefComments = IncludeBriefComments;
      assert (IncludeBriefComments == this.IncludeBriefCommentsInCodeCompletion);
      
      FrontendOpts.CodeCompletionAt.FileName.$assignMove(File.$string());
      FrontendOpts.CodeCompletionAt.Line = Line;
      FrontendOpts.CodeCompletionAt.Column = Column;
      
      // Set the language options appropriately.
      LangOpts.$assign(/*Deref*/CCInvocation.$arrow().getLangOpts());
      
      // Spell-checking and warnings are wasteful during code-completion.
      LangOpts.SpellChecking = false;
      CCInvocation.$arrow().getDiagnosticOpts().IgnoreWarnings = true;
      
      Clang/*J*/= $c$.clean(new std.unique_ptr<CompilerInstance>(new CompilerInstance($c$.track(new std.shared_ptr<PCHContainerOperations>(PCHContainerOps)))));
      
      // Recover resources if we crash before exiting this method.
      CICleanup/*J*/= new CrashRecoveryContextCleanupRegistrar<CompilerInstance>(Clang.get());
      
      Clang.$arrow().setInvocation(/*AddrOf*/CCInvocation.$star());
      OriginalSourceFile.$assignMove(Clang.$arrow().getFrontendOpts().Inputs.$at(0).getFile().$string());
      
      // Set up diagnostics, capturing any diagnostics produced.
      Clang.$arrow().setDiagnostics(/*AddrOf*/Diag);
      Capture/*J*/= new CaptureDroppedDiagnostics(true, 
          Clang.$arrow().getDiagnostics(), 
          StoredDiagnostics);
      ProcessWarningOptions(Diag, CCInvocation.$arrow().getDiagnosticOpts());
      
      // Create the target instance.
      Clang.$arrow().setTarget(TargetInfo.CreateTargetInfo(Clang.$arrow().getDiagnostics(), Clang.$arrow().getInvocation().TargetOpts));
      if (!Clang.$arrow().hasTarget()) {
        Clang.$arrow().setInvocation((CompilerInvocation /*P*/ )null);
        return;
      }
      
      // Inform the target of the language options.
      //
      // FIXME: We shouldn't need to do this, the target should be immutable once
      // created. This complexity should be lifted elsewhere.
      Clang.$arrow().getTarget().adjust(Clang.$arrow().getLangOpts());
      assert (Clang.$arrow().getFrontendOpts().Inputs.size() == 1) : "Invocation must have exactly one source file!";
      assert (Clang.$arrow().getFrontendOpts().Inputs.$at(0).getKind() != InputKind.IK_AST) : "FIXME: AST inputs not yet supported here!";
      assert (Clang.$arrow().getFrontendOpts().Inputs.$at(0).getKind() != InputKind.IK_LLVM_IR) : "IR inputs not support here!";
      
      // Use the source and file managers that we were given.
      Clang.$arrow().setFileManager(/*AddrOf*/FileMgr);
      Clang.$arrow().setSourceManager(/*AddrOf*/SourceMgr);
      
      // Remap files.
      PreprocessorOpts.clearRemappedFiles();
      PreprocessorOpts.RetainRemappedFileBuffers = true;
      for (/*const*/ pair<std.string, MemoryBuffer /*P*/ > /*&*/ RemappedFile : RemappedFiles) {
        PreprocessorOpts.addRemappedFile(new StringRef(RemappedFile.first), RemappedFile.second);
        OwnedBuffers.push_back(RemappedFile.second);
      }
      
      // Use the code completion consumer we were given, but adding any cached
      // code-completion results.
      AugmentedCodeCompleteConsumer /*P*/ AugmentedConsumer = new AugmentedCodeCompleteConsumer(/*Deref*/this, Consumer, CodeCompleteOpts);
      Clang.$arrow().setCodeCompletionConsumer(AugmentedConsumer);
      
      // If we have a precompiled preamble, try to use it. We only allow
      // the use of the precompiled preamble if we're if the completion
      // point is within the main file, after the end of the precompiled
      // preamble.
      OverrideMainBuffer/*J*/= new std.unique_ptr<MemoryBuffer>();
      if (!getPreambleFile(this).empty()) {
        std.string CompleteFilePath/*J*/= File.$string();
        fs.UniqueID CompleteFileID/*J*/= new fs.UniqueID();
        if (!fs.getUniqueID(new Twine(CompleteFilePath), CompleteFileID).$bool()) {
          std.string MainPath/*J*/= new std.string(OriginalSourceFile);
          fs.UniqueID MainID/*J*/= new fs.UniqueID();
          if (!fs.getUniqueID(new Twine(MainPath), MainID).$bool()) {
            if (CompleteFileID.$eq(MainID) && $greater_uint(Line, 1)) {
              $c$.clean(OverrideMainBuffer.$assignMove($c$.track(getMainBufferWithPrecompiledPreamble($c$.track(new std.shared_ptr<PCHContainerOperations>(PCHContainerOps)), CCInvocation.$star(), false, Line - 1))));
            }
          }
        }
      }
      
      // If the main file has been overridden due to the use of a preamble,
      // make that override happen and introduce the preamble.
      if (OverrideMainBuffer.$bool()) {
        PreprocessorOpts.addRemappedFile(new StringRef(OriginalSourceFile), 
            OverrideMainBuffer.get());
        PreprocessorOpts.PrecompiledPreambleBytes.first = Preamble.size();
        PreprocessorOpts.PrecompiledPreambleBytes.second
           = PreambleEndsAtStartOfLine;
        PreprocessorOpts.ImplicitPCHInclude.$assign(getPreambleFile(this));
        PreprocessorOpts.DisablePCHValidation = true;
        
        OwnedBuffers.push_back(OverrideMainBuffer.release());
      } else {
        PreprocessorOpts.PrecompiledPreambleBytes.first = 0;
        PreprocessorOpts.PrecompiledPreambleBytes.second = false;
      }
      
      // Disable the preprocessing record if modules are not enabled.
      if (!Clang.$arrow().getLangOpts().Modules) {
        PreprocessorOpts.DetailedRecord = false;
      }
      
      Act/*J*/= new std.unique_ptr<SyntaxOnlyAction>();
      Act.reset(new SyntaxOnlyAction());
      if (Act.$arrow().BeginSourceFile(/*Deref*/Clang.get(), Clang.$arrow().getFrontendOpts().Inputs.$at(0))) {
        Act.$arrow().Execute();
        Act.$arrow().EndSourceFile();
      }
    } finally {
      if (Act != null) { Act.$destroy(); }
      if (OverrideMainBuffer != null) { OverrideMainBuffer.$destroy(); }
      if (Capture != null) { Capture.$destroy(); }
      if (CICleanup != null) { CICleanup.$destroy(); }
      if (Clang != null) { Clang.$destroy(); }
      if (CCInvocation != null) { CCInvocation.$destroy(); }
      if (CompletionTimer != null) { CompletionTimer.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief Save this translation unit to a file with the given name.
  ///
  /// \returns true if there was a file error or false if the save was
  /// successful.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::Save">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2466,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2456,
   FQN="clang::ASTUnit::Save", NM="_ZN5clang7ASTUnit4SaveEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit4SaveEN4llvm9StringRefE")
  //</editor-fold>
  public boolean Save(StringRef File) {
    raw_fd_ostream Out = null;
    try {
      if (HadModuleLoaderFatalFailure) {
        return true;
      }
      
      // Write to a temporary file and later rename it to the actual file, to avoid
      // possible race conditions.
      SmallString/*128*/ TempPath/*J*/= new SmallString/*128*/(128);
      TempPath.$assign(/*NO_COPY*/File);
      TempPath.$addassign(/*STRINGREF_STR*/"-%%%%%%%%");
      int$ref fd = create_int$ref();
      if (fs.createUniqueFile(new Twine(TempPath), fd, TempPath).$bool()) {
        return true;
      }
      
      // FIXME: Can we somehow regenerate the stat cache here, or do we need to 
      // unconditionally create a stat cache when we parse the file?
      Out/*J*/= new raw_fd_ostream(fd.$deref(), /*shouldClose=*/ true);
      
      serialize(Out);
      Out.close();
      if (Out.has_error()) {
        Out.clear_error();
        return true;
      }
      if (fs.rename(new Twine(TempPath), new Twine(File)).$bool()) {
        fs.remove(new Twine(TempPath));
        return true;
      }
      
      return false;
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  }

  
  /// \brief Serialize this translation unit with the given output stream.
  ///
  /// \returns True if an error occurred, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::serialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2512,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2502,
   FQN="clang::ASTUnit::serialize", NM="_ZN5clang7ASTUnit9serializeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit9serializeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public boolean serialize(raw_ostream /*&*/ OS) {
    BitstreamWriter Stream = null;
    ASTWriter Writer = null;
    try {
      // For serialization we are lenient if the errors were only warn-as-error kind.
      boolean hasErrors = getDiagnostics().hasUncompilableErrorOccurred();
      if (WriterData.$bool()) {
        return serializeUnit(WriterData.$arrow().Writer, WriterData.$arrow().Buffer, 
            getSema(), hasErrors, OS);
      }
      
      SmallString/*128*/ Buffer/*J*/= new SmallString/*128*/(128);
      Stream/*J*/= new BitstreamWriter(Buffer);
      Writer/*J*/= new ASTWriter(Stream, /*{ */new ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension> >()/* }*/);
      return serializeUnit(Writer, Buffer, getSema(), hasErrors, OS);
    } finally {
      if (Writer != null) { Writer.$destroy(); }
      if (Stream != null) { Stream.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::loadModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 906,
   FQN="clang::ASTUnit::loadModule", NM="_ZN5clang7ASTUnit10loadModuleENS_14SourceLocationEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEENS_6Module18NameVisibilityKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit10loadModuleENS_14SourceLocationEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEENS_6Module18NameVisibilityKindEb")
  //</editor-fold>
  @Override public ModuleLoadResult loadModule(SourceLocation ImportLoc, ModuleIdPath Path, 
            Module.NameVisibilityKind Visibility, 
            boolean IsInclusionDirective)/* override*/ {
    // ASTUnit doesn't know how to load modules (not that this matters).
    return new ModuleLoadResult();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::makeModuleVisible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 913,
   FQN="clang::ASTUnit::makeModuleVisible", NM="_ZN5clang7ASTUnit17makeModuleVisibleEPNS_6ModuleENS1_18NameVisibilityKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit17makeModuleVisibleEPNS_6ModuleENS1_18NameVisibilityKindENS_14SourceLocationE")
  //</editor-fold>
  @Override public void makeModuleVisible(Module /*P*/ Mod, Module.NameVisibilityKind Visibility, 
                   SourceLocation ImportLoc)/* override*/ {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::loadGlobalModuleIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 916,
   FQN="clang::ASTUnit::loadGlobalModuleIndex", NM="_ZN5clang7ASTUnit21loadGlobalModuleIndexENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit21loadGlobalModuleIndexENS_14SourceLocationE")
  //</editor-fold>
  @Override public GlobalModuleIndexImplementation /*P*/ loadGlobalModuleIndex(SourceLocation TriggerLoc)/* override*/ {
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnit::lookupMissingImports">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/ASTUnit.h", line = 918,
   FQN="clang::ASTUnit::lookupMissingImports", NM="_ZN5clang7ASTUnit20lookupMissingImportsEN4llvm9StringRefENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang7ASTUnit20lookupMissingImportsEN4llvm9StringRefENS_14SourceLocationE")
  //</editor-fold>
  @Override public boolean lookupMissingImports(StringRef Name, SourceLocation TriggerLoc)/* override*/ {
    return false;
  }

  
  @Override public String toString() {
    return "" + "LangOpts=" + LangOpts // NOI18N
              /* STACKOVERFLOW: NEVER PRINT Diagnostics + ", Diagnostics=" + Diagnostics // NOI18N */
              /* STACKOVERFLOW: NEVER PRINT FileManager + ", FileMgr=" + FileMgr // NOI18N*/
              /* STACKOVERFLOW: NEVER PRINT SourceManager + ", SourceMgr=" + SourceMgr // NOI18N*/
              + ", HeaderInfo=" + HeaderInfo // NOI18N
              + ", Target=" + Target // NOI18N
              /* STACKOVERFLOW: NEVER PRINT Preprocessor + ", PP=" + PP // NOI18N */
              + ", Ctx=" + Ctx // NOI18N
              + ", TargetOpts=" + TargetOpts // NOI18N
              + ", HSOpts=" + HSOpts // NOI18N
              + ", Reader=" + Reader // NOI18N
              + ", HadModuleLoaderFatalFailure=" + HadModuleLoaderFatalFailure // NOI18N
              + ", WriterData=" + WriterData // NOI18N
              + ", FileSystemOpts=" + FileSystemOpts // NOI18N
              + ", Consumer=" + Consumer // NOI18N
              + ", TheSema=" + TheSema // NOI18N
              + ", Invocation=" + Invocation // NOI18N
              + ", OnlyLocalDecls=" + OnlyLocalDecls // NOI18N
              + ", CaptureDiagnostics=" + CaptureDiagnostics // NOI18N
              + ", MainFileIsAST=" + MainFileIsAST // NOI18N
              + ", TUKind=" + TUKind // NOI18N
              + ", WantTiming=" + WantTiming // NOI18N
              + ", OwnsRemappedFileBuffers=" + OwnsRemappedFileBuffers // NOI18N
              + ", TopLevelDecls=" + TopLevelDecls // NOI18N
              + ", FileDecls=" + FileDecls // NOI18N
              + ", OriginalSourceFile=" + OriginalSourceFile // NOI18N
              + ", PreambleDiagnostics=" + PreambleDiagnostics // NOI18N
              + ", StoredDiagnostics=" + StoredDiagnostics // NOI18N
              + ", FailedParseDiagnostics=" + FailedParseDiagnostics // NOI18N
              + ", NumStoredDiagnosticsFromDriver=" + NumStoredDiagnosticsFromDriver // NOI18N
              + ", PreambleRebuildCounter=" + PreambleRebuildCounter // NOI18N
              + ", Preamble=" + Preamble // NOI18N
              + ", PreambleEndsAtStartOfLine=" + PreambleEndsAtStartOfLine // NOI18N
              + ", FilesInPreamble=" + FilesInPreamble // NOI18N
              + ", SavedMainFileBuffer=" + SavedMainFileBuffer // NOI18N
              + ", PreambleBuffer=" + PreambleBuffer // NOI18N
              + ", NumWarningsInPreamble=" + NumWarningsInPreamble // NOI18N
              + ", TopLevelDeclsInPreamble=" + TopLevelDeclsInPreamble // NOI18N
              + ", ShouldCacheCodeCompletionResults=" + ShouldCacheCodeCompletionResults // NOI18N
              + ", IncludeBriefCommentsInCodeCompletion=" + IncludeBriefCommentsInCodeCompletion // NOI18N
              + ", UserFilesAreVolatile=" + UserFilesAreVolatile // NOI18N
              + ", ASTFileLangOpts=" + ASTFileLangOpts // NOI18N
              + ", CachedCompletionAllocator=" + CachedCompletionAllocator // NOI18N
              + ", CCTUInfo=" + CCTUInfo // NOI18N
              + ", CachedCompletionResults=" + CachedCompletionResults // NOI18N
              + ", CachedCompletionTypes=" + CachedCompletionTypes // NOI18N
              + ", CompletionCacheTopLevelHashValue=" + CompletionCacheTopLevelHashValue // NOI18N
              + ", PreambleTopLevelHashValue=" + PreambleTopLevelHashValue // NOI18N
              + ", CurrentTopLevelHashValue=" + CurrentTopLevelHashValue // NOI18N
              + ", UnsafeToFree=" + UnsafeToFree // NOI18N
              + ", ConcurrencyCheckValue=" + ConcurrencyCheckValue // NOI18N
              + super.toString(); // NOI18N
  }
}
