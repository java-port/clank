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

package org.clang.staticanalyzer.core.bugreporter.ento;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import java.util.Comparator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.java.StaticAnalyzerFunctionPointers.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.staticanalyzer.core.impl.PathDiagnosticStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 55,
 FQN="clang::ento::PathDiagnosticConsumer", NM="_ZN5clang4ento22PathDiagnosticConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento22PathDiagnosticConsumerE")
//</editor-fold>
public abstract class PathDiagnosticConsumer implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::PDFileEntry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 57,
   FQN="clang::ento::PathDiagnosticConsumer::PDFileEntry", NM="_ZN5clang4ento22PathDiagnosticConsumer11PDFileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento22PathDiagnosticConsumer11PDFileEntryE")
  //</editor-fold>
  public static class PDFileEntry extends FoldingSetImpl.NodeImpl implements /*public*/ FoldingSetImpl.Node, Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::PDFileEntry::PDFileEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 59,
     FQN="clang::ento::PathDiagnosticConsumer::PDFileEntry::PDFileEntry", NM="_ZN5clang4ento22PathDiagnosticConsumer11PDFileEntryC1ERN4llvm16FoldingSetNodeIDE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento22PathDiagnosticConsumer11PDFileEntryC1ERN4llvm16FoldingSetNodeIDE")
    //</editor-fold>
    public PDFileEntry(final FoldingSetNodeID /*&*/ NodeID) {
      // : FoldingSetNode(), files(), NodeID(NodeID) 
      //START JInit
      $Node();
      this.files = new std.vector<std.pairTypeType<StringRef, StringRef>>(new std.pairTypeType<StringRef, StringRef>(new StringRef(), new StringRef()));
      this.NodeID = new FoldingSetNodeID(NodeID);
      //END JInit
    }

    
    // JAVA: typedef std::vector<std::pair<StringRef, StringRef> > ConsumerFiles
//    public final class ConsumerFiles extends std.vector<std.pairTypeType<StringRef, StringRef>>{ };
    
    /// \brief A vector of <consumer,file> pairs.
    public std.vector<std.pairTypeType<StringRef, StringRef>> files;
    
    /// \brief A precomputed hash tag used for uniquing PDFileEntry objects.
    public /*const*/ FoldingSetNodeID NodeID;
    
    /// \brief Used for profiling in the FoldingSet.
    //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::PDFileEntry::Profile">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 70,
     FQN="clang::ento::PathDiagnosticConsumer::PDFileEntry::Profile", NM="_ZN5clang4ento22PathDiagnosticConsumer11PDFileEntry7ProfileERN4llvm16FoldingSetNodeIDE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento22PathDiagnosticConsumer11PDFileEntry7ProfileERN4llvm16FoldingSetNodeIDE")
    //</editor-fold>
    @Override public/*public*/ void Profile(final FoldingSetNodeID /*&*/ ID) {
      ID.$assign(NodeID);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::PDFileEntry::~PDFileEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 57,
     FQN="clang::ento::PathDiagnosticConsumer::PDFileEntry::~PDFileEntry", NM="_ZN5clang4ento22PathDiagnosticConsumer11PDFileEntryD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticConsumer11PDFileEntryD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      NodeID.$destroy();
      files.$destroy();
      FoldingSetImpl.Node.super.$destroy$Node();
      //END JDestroy
    }


    
    @Override public String toString() {
      return "" + "files=" + files // NOI18N
                + ", NodeID=" + NodeID // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::FilesMade">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 73,
   FQN="clang::ento::PathDiagnosticConsumer::FilesMade", NM="_ZN5clang4ento22PathDiagnosticConsumer9FilesMadeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento22PathDiagnosticConsumer9FilesMadeE")
  //</editor-fold>
  public static class FilesMade implements Destructors.ClassWithDestructor {
    private BumpPtrAllocatorImpl Alloc;
    private FoldingSet<PDFileEntry> Set;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::FilesMade::~FilesMade">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 455,
     FQN="clang::ento::PathDiagnosticConsumer::FilesMade::~FilesMade", NM="_ZN5clang4ento22PathDiagnosticConsumer9FilesMadeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticConsumer9FilesMadeD0Ev")
    //</editor-fold>
    public void $destroy() {
      for (final PDFileEntry /*&*/ Entry : Set)  {
        Entry.$destroy();
      }
      //START JDestroy
      Set.$destroy();
      Alloc.$destroy();
      //END JDestroy
    }


    
    //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::FilesMade::empty">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 80,
     FQN="clang::ento::PathDiagnosticConsumer::FilesMade::empty", NM="_ZNK5clang4ento22PathDiagnosticConsumer9FilesMade5emptyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZNK5clang4ento22PathDiagnosticConsumer9FilesMade5emptyEv")
    //</editor-fold>
    public boolean empty() /*const*/ {
      return Set.empty();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::FilesMade::addDiagnostic">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 460,
     FQN="clang::ento::PathDiagnosticConsumer::FilesMade::addDiagnostic", NM="_ZN5clang4ento22PathDiagnosticConsumer9FilesMade13addDiagnosticERKNS0_14PathDiagnosticEN4llvm9StringRefES7_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticConsumer9FilesMade13addDiagnosticERKNS0_14PathDiagnosticEN4llvm9StringRefES7_")
    //</editor-fold>
    public void addDiagnostic(final /*const*/ PathDiagnostic /*&*/ PD, 
                 StringRef ConsumerName, 
                 StringRef FileName) {
      FoldingSetNodeID NodeID/*J*/= new FoldingSetNodeID();
      NodeID.Add(PD);
      final type$ref<type$ptr<PDFileEntry /*P*/>/*void P*/ > InsertPos = create_type$ref();
      PDFileEntry /*P*/ Entry = Set.FindNodeOrInsertPos(NodeID, InsertPos);
      if (!(Entry != null)) {
        Entry = Alloc.<PDFileEntry>Allocate$T(PDFileEntry.class);
        Entry = ((/*JCast*/PDFileEntry /*P*/ )(/*NEW_EXPR [System]*/Entry = /*new (Entry)*/ $new_uint_voidPtr(Entry, (type$ptr<?> New$Mem)->{
            return new PDFileEntry(NodeID);
         })));
        Set.InsertNode(Entry, InsertPos.$deref());
      }
      
      // Allocate persistent storage for the file name.
      char$ptr/*char P*/ FileName_cstr = $tryClone(reinterpret_cast(char$ptr/*char P*/ .class, Alloc.Allocate(FileName.size(), 1)));
      memcpy(FileName_cstr, FileName.data(), FileName.size());
      
      Entry.files.push_back_T$RR(std.make_pair($Clone(ConsumerName), $Move(new StringRef(FileName_cstr, 
        FileName.size()))
              ));
    }


    //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::FilesMade::getFiles">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 482,
     FQN="clang::ento::PathDiagnosticConsumer::FilesMade::getFiles", NM="_ZN5clang4ento22PathDiagnosticConsumer9FilesMade8getFilesERKNS0_14PathDiagnosticE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticConsumer9FilesMade8getFilesERKNS0_14PathDiagnosticE")
    //</editor-fold>
    public std.vector<std.pairTypeType<StringRef, StringRef>> /*P*/ getFiles(final /*const*/ PathDiagnostic /*&*/ PD) {
      FoldingSetNodeID NodeID/*J*/= new FoldingSetNodeID();
      NodeID.Add(PD);
      final type$ref<type$ptr<PDFileEntry /*P*/>/*void P*/ > InsertPos = create_type$ref();
      PDFileEntry /*P*/ Entry = Set.FindNodeOrInsertPos(NodeID, InsertPos);
      if (!(Entry != null)) {
        return null;
      }
      return $AddrOf(Entry.files);
    }


    //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::FilesMade::FilesMade">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 73,
     FQN="clang::ento::PathDiagnosticConsumer::FilesMade::FilesMade", NM="_ZN5clang4ento22PathDiagnosticConsumer9FilesMadeC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento22PathDiagnosticConsumer9FilesMadeC1Ev")
    //</editor-fold>
    public /*inline*/ FilesMade() {
      // : Alloc(), Set() 
      //START JInit
      this.Alloc = new BumpPtrAllocatorImpl();
      this.Set = new FoldingSet<PDFileEntry>(PDFileEntry.$Trait());
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Alloc=" + "[BumpPtrAllocatorImpl]" // NOI18N
                + ", Set=" + Set; // NOI18N
    }
  };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 186,
   FQN="clang::ento::PathDiagnosticConsumer::anchor", NM="_ZN5clang4ento22PathDiagnosticConsumer6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticConsumer6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::PathDiagnosticConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 92,
   FQN="clang::ento::PathDiagnosticConsumer::PathDiagnosticConsumer", NM="_ZN5clang4ento22PathDiagnosticConsumerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento22PathDiagnosticConsumerC1Ev")
  //</editor-fold>
  public PathDiagnosticConsumer() {
    // : flushed(false), Diags() 
    //START JInit
    this.flushed = false;
    this.Diags = new FoldingSet<PathDiagnostic>(PathDiagnostic.$Trait());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::~PathDiagnosticConsumer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 188,
   FQN="clang::ento::PathDiagnosticConsumer::~PathDiagnosticConsumer", NM="_ZN5clang4ento22PathDiagnosticConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticConsumerD0Ev")
  //</editor-fold>
  public void $destroy() {
    // Delete the contents of the FoldingSet if it isn't empty already.
    for (FoldingSetIterator<PathDiagnostic> it = Diags.begin(), et = Diags.end(); it.$noteq(et); it.$preInc()) {
      if (/*AddrOf*/it.$star() != null) { /*AddrOf*/it.$star().$destroy();};
    }
    //START JDestroy
    Diags.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::FlushDiagnostics">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 416,
   FQN="clang::ento::PathDiagnosticConsumer::FlushDiagnostics", NM="_ZN5clang4ento22PathDiagnosticConsumer16FlushDiagnosticsEPNS1_9FilesMadeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticConsumer16FlushDiagnosticsEPNS1_9FilesMadeE")
  //</editor-fold>
  public void FlushDiagnostics(PathDiagnosticConsumer.FilesMade /*P*/ Files) {
    std.vector</*const*/ PathDiagnostic /*P*/ > BatchDiags = null;
    try {
      if (flushed) {
        return;
      }
      
      flushed = true;
      
      BatchDiags/*J*/= new std.vector</*const*/ PathDiagnostic /*P*/ >((/*const*/ PathDiagnostic /*P*/ )null);
      for (FoldingSetIterator<PathDiagnostic> it = Diags.begin(), 
          et = Diags.end(); it.$noteq(et); it.$preInc()) {
        /*const*/ PathDiagnostic /*P*/ D = $AddrOf(it.$star());
        assert BatchDiags.find(D) == std.string.npos : "JAVA: Must be unique, but found at " + BatchDiags.find(D);
        BatchDiags.push_back_T$C$R(D);
      }
      
      // Sort the diagnostics so that they are always emitted in a deterministic
      // order.
      PathDiagnosticPathDiagnostic2Int Comp = /*[]*/ (/*const*/ PathDiagnostic /*P*/ /*const*/ /*P*/ X, /*const*/ PathDiagnostic /*P*/ /*const*/ /*P*/ Y) -> {
            if (X == Y) return 0; // JAVA: for some reason it is called for the same objects from qsort impl...
            assert (X != Y) : "PathDiagnostics not uniqued!";
            if (compare($Deref(X), $Deref(Y))) {
              return -1;
            }
            assert (compare($Deref(Y), $Deref(X))) : "Not a total order!";
            return 1;
          };//.$PathDiagnosticPathDiagnostic2Int();
      
      llvm.array_pod_sort(BatchDiags.begin().toPointer(), BatchDiags.end().toPointer(), new Comparator<PathDiagnostic>(){
        @Override
        public int compare(PathDiagnostic a, PathDiagnostic b) {
          return Comp.$call(a, b);
        }
      });
      
      FlushDiagnosticsImpl(BatchDiags, Files);
      
      // Delete the flushed diagnostics.
      for (std.vector.iterator</*const*/ PathDiagnostic /*P*/ > it = BatchDiags.begin(), 
          et = BatchDiags.end(); $noteq___normal_iterator$C(it, et); it.$preInc()) {
        /*const*/ PathDiagnostic /*P*/ D = it.$star();
        if (D != null) { D.$destroy();};
      }
      
      // Clear out the FoldingSet.
      Diags.clear();
    } finally {
      if (BatchDiags != null) { BatchDiags.$destroy(); }
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::FlushDiagnosticsImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 97,
   FQN="clang::ento::PathDiagnosticConsumer::FlushDiagnosticsImpl", NM="_ZN5clang4ento22PathDiagnosticConsumer20FlushDiagnosticsImplERSt6vectorIPKNS0_14PathDiagnosticESaIS5_EEPNS1_9FilesMadeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento22PathDiagnosticConsumer20FlushDiagnosticsImplERSt6vectorIPKNS0_14PathDiagnosticESaIS5_EEPNS1_9FilesMadeE")
  //</editor-fold>
  public abstract /*virtual*/ void FlushDiagnosticsImpl(final std.vector</*const*/ PathDiagnostic /*P*/ > /*&*/ Diags, 
                      FilesMade /*P*/ filesMade)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 100,
   FQN="clang::ento::PathDiagnosticConsumer::getName", NM="_ZNK5clang4ento22PathDiagnosticConsumer7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZNK5clang4ento22PathDiagnosticConsumer7getNameEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef getName() /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::HandlePathDiagnostic">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 196,
   FQN="clang::ento::PathDiagnosticConsumer::HandlePathDiagnostic", NM="_ZN5clang4ento22PathDiagnosticConsumer20HandlePathDiagnosticESt10unique_ptrINS0_14PathDiagnosticESt14default_deleteIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticConsumer20HandlePathDiagnosticESt10unique_ptrINS0_14PathDiagnosticESt14default_deleteIS3_EE")
  //</editor-fold>
  public void HandlePathDiagnostic(std.unique_ptr<PathDiagnostic> D) {
    if (!D.$bool() || D.$arrow()._path.empty()) {
      return;
    }
    
    // We need to flatten the locations (convert Stmt* to locations) because
    // the referenced statements may be freed by the time the diagnostics
    // are emitted.
    D.$arrow().flattenLocations();
    
    // If the PathDiagnosticConsumer does not support diagnostics that
    // cross file boundaries, prune out such diagnostics now.
    if (!supportsCrossFileDiagnostics()) {
      // Verify that the entire path is from the same FileID.
      FileID FID/*J*/= new FileID();
      final /*const*/ SourceManager /*&*/ SMgr = D.$arrow()._path.front$Const().$arrow().getLocation().getManager();
      SmallVector</*const*/ PathPieces /*P*/ > WorkList/*J*/= new SmallVector</*const*/ PathPieces /*P*/ >(5, (/*const*/ PathPieces /*P*/ )null);
      WorkList.push_back($AddrOf(D.$arrow()._path));
      while (!WorkList.empty()) {
        final /*const*/ PathPieces /*&*/ _path = $Deref(WorkList.pop_back_val());
        
        for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = _path.begin$Const(), E = _path.end$Const(); I.$noteq(E);
             I.$preInc()) {
          /*const*/ PathDiagnosticPiece /*P*/ piece = I.$arrow().get();
          FullSourceLoc L = piece.getLocation().asLocation().getExpansionLoc();
          if (FID.isInvalid()) {
            FID.$assignMove(SMgr.getFileID(/*NO_COPY*/L));
          } else if (SMgr.getFileID(/*NO_COPY*/L).$noteq(FID)) {
            return; // FIXME: Emit a warning?
          }
          
          // Check the source ranges.
          ArrayRef<SourceRange> Ranges = piece.getRanges();
          for (type$ptr<SourceRange> I$1 = $tryClone(Ranges.begin()), 
              /*P*/ E$1 = $tryClone(Ranges.end()); $noteq_ptr(I$1, E$1); I$1.$preInc()) {
            SourceLocation L$1 = SMgr.getExpansionLoc(I$1./*->*/$star().getBegin());
            if (!L$1.isFileID() || SMgr.getFileID(/*NO_COPY*/L$1).$noteq(FID)) {
              return; // FIXME: Emit a warning?
            }
            L$1.$assignMove(SMgr.getExpansionLoc(I$1./*->*/$star().getEnd()));
            if (!L$1.isFileID() || SMgr.getFileID(/*NO_COPY*/L$1).$noteq(FID)) {
              return; // FIXME: Emit a warning?
            }
          }
          {
            
            /*const*/ PathDiagnosticCallPiece /*P*/ call = dyn_cast_PathDiagnosticCallPiece(piece);
            if ((call != null)) {
              WorkList.push_back($AddrOf(call._path));
            } else {
              /*const*/ PathDiagnosticMacroPiece /*P*/ macro = dyn_cast_PathDiagnosticMacroPiece(piece);
              if ((macro != null)) {
                WorkList.push_back($AddrOf(macro.subPieces));
              }
            }
          }
        }
      }
      if (FID.isInvalid()) {
        return; // FIXME: Emit a warning?
      }
    }
    
    // Profile the node to see if we already have something matching it
    FoldingSetNodeID profile/*J*/= new FoldingSetNodeID();
    D.$arrow().Profile(profile);
    final type$ref<type$ptr<PathDiagnostic /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    {
      
      PathDiagnostic /*P*/ orig = Diags.FindNodeOrInsertPos(profile, InsertPos);
      if ((orig != null)) {
        // Keep the PathDiagnostic with the shorter path.
        // Note, the enclosing routine is called in deterministic order, so the
        // results will be consistent between runs (no reason to break ties if the
        // size is the same).
        /*const*//*uint*/int orig_size = orig.full_size();
        /*const*//*uint*/int new_size = D.$arrow().full_size();
        if ($lesseq_uint(orig_size, new_size)) {
          return;
        }
        assert (orig != D.get());
        Diags.RemoveNode(orig);
        if (orig != null) { orig.$destroy();};
      }
    }
    
    Diags.InsertNode(D.release());
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::PathGenerationScheme">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 104,
   FQN="clang::ento::PathDiagnosticConsumer::PathGenerationScheme", NM="_ZN5clang4ento22PathDiagnosticConsumer20PathGenerationSchemeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZN5clang4ento22PathDiagnosticConsumer20PathGenerationSchemeE")
  //</editor-fold>
  public enum PathGenerationScheme implements Native.NativeUIntEnum {
    None(0),
    Minimal(None.getValue() + 1),
    Extensive(Minimal.getValue() + 1),
    AlternateExtensive(Extensive.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static PathGenerationScheme valueOf(int val) {
      PathGenerationScheme out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final PathGenerationScheme[] VALUES;
      private static final PathGenerationScheme[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (PathGenerationScheme kind : PathGenerationScheme.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new PathGenerationScheme[min < 0 ? (1-min) : 0];
        VALUES = new PathGenerationScheme[max >= 0 ? (1+max) : 0];
        for (PathGenerationScheme kind : PathGenerationScheme.values()) {
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
    private PathGenerationScheme(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::getGenerationScheme">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 105,
   FQN="clang::ento::PathDiagnosticConsumer::getGenerationScheme", NM="_ZNK5clang4ento22PathDiagnosticConsumer19getGenerationSchemeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZNK5clang4ento22PathDiagnosticConsumer19getGenerationSchemeEv")
  //</editor-fold>
  public /*virtual*/ PathGenerationScheme getGenerationScheme() /*const*/ {
    return PathGenerationScheme.Minimal;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::supportsLogicalOpControlFlow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 106,
   FQN="clang::ento::PathDiagnosticConsumer::supportsLogicalOpControlFlow", NM="_ZNK5clang4ento22PathDiagnosticConsumer28supportsLogicalOpControlFlowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZNK5clang4ento22PathDiagnosticConsumer28supportsLogicalOpControlFlowEv")
  //</editor-fold>
  public /*virtual*/ boolean supportsLogicalOpControlFlow() /*const*/ {
    return false;
  }

  
  /// Return true if the PathDiagnosticConsumer supports individual
  /// PathDiagnostics that span multiple files.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticConsumer::supportsCrossFileDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 110,
   FQN="clang::ento::PathDiagnosticConsumer::supportsCrossFileDiagnostics", NM="_ZNK5clang4ento22PathDiagnosticConsumer28supportsCrossFileDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalysisManager.cpp -nm=_ZNK5clang4ento22PathDiagnosticConsumer28supportsCrossFileDiagnosticsEv")
  //</editor-fold>
  public /*virtual*/ boolean supportsCrossFileDiagnostics() /*const*/ {
    return false;
  }

/*protected:*/
  protected boolean flushed;
  protected FoldingSet<PathDiagnostic> Diags;
  
  @Override public String toString() {
    return "" + "flushed=" + flushed // NOI18N
              + ", Diags=" + "[FoldingSet$PathDiagnostic]"; // NOI18N
  }
}
