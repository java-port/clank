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

package org.clang.serialization;

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.llvm.bitcode.java.BitcodeFunctionPointers.*;
import org.clang.serialization.java.SerializationFunctionPointers.*;
import org.clang.serialization.spi.PCHContainerReaderImplementation;
import org.clang.basic.vfs.Status;
import org.llvm.adt.*;
import static org.llvm.adt.ADTAliases.$noteq_reverse_iterator$C;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import static org.llvm.support.AdtsupportLlvmGlobals.ViewGraph;
import static org.llvm.support.llvm.*;


/// \brief Manages the set of modules loaded by an AST reader.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleManager.h", line = 32,
 FQN="clang::serialization::ModuleManager", NM="_ZN5clang13serialization13ModuleManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManagerE")
//</editor-fold>
public class ModuleManager implements NativeReverseIterable<std.reverse_iterator<ModuleFile>>, Iterable<ModuleFile>, Destructors.ClassWithDestructor {
  /// \brief The chain of AST files, in the order in which we started to load
  /// them (this order isn't really useful for anything).
  private SmallVector<ModuleFile /*P*/ > Chain;
  
  /// \brief The chain of non-module PCH files. The first entry is the one named
  /// by the user, the last one is the one that doesn't depend on anything
  /// further.
  private SmallVector<ModuleFile /*P*/ > PCHChain;
  
  // \brief The roots of the dependency DAG of AST files. This is used
  // to implement short-circuiting logic when running DFS over the dependencies.
  private SmallVector<ModuleFile /*P*/ > Roots;
  
  /// \brief All loaded modules, indexed by name.
  private DenseMap</*const*/ FileEntry /*P*/ , ModuleFile /*P*/ > Modules;
  
  /// \brief FileManager that handles translating between filenames and
  /// FileEntry *.
  private final FileManager /*&*/ FileMgr;
  
  /// \brief Knows how to unwrap module containers.
  private final /*const*/PCHContainerReaderImplementation/*&*/ PCHContainerRdr;
  
  /// \brief A lookup of in-memory (virtual file) buffers
  private DenseMap</*const*/ FileEntry /*P*/ , std.unique_ptr<MemoryBuffer>> InMemoryBuffers;
  
  /// \brief The visitation order.
  private SmallVector<ModuleFile /*P*/ > VisitOrder;
  
  /// \brief The list of module files that both we and the global module index
  /// know about.
  ///
  /// Either the global index or the module manager may have modules that the
  /// other does not know about, because the global index can be out-of-date
  /// (in which case the module manager could have modules it does not) and
  /// this particular translation unit might not have loaded all of the modules
  /// known to the global index.
  private SmallVector<ModuleFile /*P*/ > ModulesInCommonWithGlobalIndex;
  
  /// \brief The global module index, if one is attached.
  ///
  /// The global module index will actually be owned by the ASTReader; this is
  /// just an non-owning pointer.
  private GlobalModuleIndex /*P*/ GlobalIndex;
  
  /// \brief State used by the "visit" operation to avoid malloc traffic in
  /// calls to visit().
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::VisitState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleManager.h", line = 81,
   FQN="clang::serialization::ModuleManager::VisitState", NM="_ZN5clang13serialization13ModuleManager10VisitStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager10VisitStateE")
  //</editor-fold>
  private static class/*struct*/ VisitState implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::VisitState::VisitState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleManager.h", line = 82,
     FQN="clang::serialization::ModuleManager::VisitState::VisitState", NM="_ZN5clang13serialization13ModuleManager10VisitStateC1Ej",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager10VisitStateC1Ej")
    //</editor-fold>
    public /*explicit*/ VisitState(/*uint*/int N) {
      // : Stack(), VisitNumber(N, 0), NextVisitNumber(1), NextState(null) 
      //START JInit
      this.Stack = new SmallVector<ModuleFile /*P*/ >(4, (ModuleFile /*P*/ )null);
      this.VisitNumber = new SmallVectorUInt(JD$UInt_T$C$R.INSTANCE, 4, N, 0, 0);
      this.NextVisitNumber = 1;
      this.NextState = null;
      //END JInit
      Stack.reserve(N);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::VisitState::~VisitState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleManager.h", line = 88,
     FQN="clang::serialization::ModuleManager::VisitState::~VisitState", NM="_ZN5clang13serialization13ModuleManager10VisitStateD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager10VisitStateD0Ev")
    //</editor-fold>
    public void $destroy() {
      if (NextState != null) { NextState.$destroy();};
      //START JDestroy
      VisitNumber.$destroy();
      Stack.$destroy();
      //END JDestroy
    }

    
    /// \brief The stack used when marking the imports of a particular module
    /// as not-to-be-visited.
    public SmallVector<ModuleFile /*P*/ > Stack;
    
    /// \brief The visit number of each module file, which indicates when
    /// this module file was last visited.
    public SmallVectorUInt VisitNumber;
    
    /// \brief The next visit number to use to mark visited module files.
    public /*uint*/int NextVisitNumber;
    
    /// \brief The next visit state.
    public VisitState /*P*/ NextState;
    
    @Override public String toString() {
      return "" + "Stack=" + Stack // NOI18N
                + ", VisitNumber=" + VisitNumber // NOI18N
                + ", NextVisitNumber=" + NextVisitNumber // NOI18N
                + ", NextState=" + NextState; // NOI18N
    }
  };
  
  /// \brief The first visit() state in the chain.
  private VisitState /*P*/ FirstVisitState;
  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::allocateVisitState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 255,
   FQN="clang::serialization::ModuleManager::allocateVisitState", NM="_ZN5clang13serialization13ModuleManager18allocateVisitStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager18allocateVisitStateEv")
  //</editor-fold>
  private ModuleManager.VisitState /*P*/ allocateVisitState() {
    // Fast path: if we have a cached state, use it.
    if ((FirstVisitState != null)) {
      VisitState /*P*/ Result = FirstVisitState;
      FirstVisitState = FirstVisitState.NextState;
      Result.NextState = null;
      return Result;
    }
    
    // Allocate and return a new state.
    return new VisitState(size());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::returnVisitState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 268,
   FQN="clang::serialization::ModuleManager::returnVisitState", NM="_ZN5clang13serialization13ModuleManager16returnVisitStateEPNS1_10VisitStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager16returnVisitStateEPNS1_10VisitStateE")
  //</editor-fold>
  private void returnVisitState(VisitState /*P*/ State) {
    assert (State.NextState == null) : "Visited state is in list?";
    State.NextState = FirstVisitState;
    FirstVisitState = State;
  }

/*public:*/
  // JAVA: typedef SmallVectorImpl<ModuleFile *>::iterator ModuleIterator
//  public final class ModuleIterator extends type$ptr<ModuleFile /*P*/ /*P*/>{ };
  // JAVA: typedef SmallVectorImpl<ModuleFile *>::const_iterator ModuleConstIterator
//  public final class ModuleConstIterator extends type$ptr<ModuleFile /*P*/ /*P*/>{ };
  // JAVA: typedef SmallVectorImpl<ModuleFile *>::reverse_iterator ModuleReverseIterator
//  public final class ModuleReverseIterator extends std.reverse_iterator<ModuleFile /*P*/ >{ };
  // JAVA: typedef std::pair<uint32_t, StringRef> ModuleOffset
//  public final class ModuleOffset extends std.pairUIntType<StringRef>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::ModuleManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 297,
   FQN="clang::serialization::ModuleManager::ModuleManager", NM="_ZN5clang13serialization13ModuleManagerC1ERNS_11FileManagerERKNS_18PCHContainerReaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManagerC1ERNS_11FileManagerERKNS_18PCHContainerReaderE")
  //</editor-fold>
  public ModuleManager(final FileManager /*&*/ FileMgr, 
      final /*const*/PCHContainerReaderImplementation/*&*/ PCHContainerRdr) {
    // : Chain(), PCHChain(), Roots(), Modules(), FileMgr(FileMgr), PCHContainerRdr(PCHContainerRdr), InMemoryBuffers(), VisitOrder(), ModulesInCommonWithGlobalIndex(), GlobalIndex(implicit GlobalModuleIndex * ()), FirstVisitState(null) 
    //START JInit
    this.Chain = new SmallVector<ModuleFile /*P*/ >(2, (ModuleFile /*P*/ )null);
    this.PCHChain = new SmallVector<ModuleFile /*P*/ >(2, (ModuleFile /*P*/ )null);
    this.Roots = new SmallVector<ModuleFile /*P*/ >(2, (ModuleFile /*P*/ )null);
    this.Modules = new DenseMap</*const*/ FileEntry /*P*/ , ModuleFile /*P*/ >(DenseMapInfo$LikePtr.$Info(), (ModuleFile /*P*/ )null);
    this./*&*/FileMgr=/*&*/FileMgr;
    this./*&*/PCHContainerRdr=/*&*/PCHContainerRdr;
    this.InMemoryBuffers = new DenseMap</*const*/ FileEntry /*P*/ , std.unique_ptr<MemoryBuffer>>(DenseMapInfo$LikePtr.$Info(), new std.unique_ptr<MemoryBuffer>());
    this.VisitOrder = new SmallVector<ModuleFile /*P*/ >(4, (ModuleFile /*P*/ )null);
    this.ModulesInCommonWithGlobalIndex = new SmallVector<ModuleFile /*P*/ >(4, (ModuleFile /*P*/ )null);
    this.GlobalIndex = /*implicit-init*/((GlobalModuleIndex /*P*/ )/*zero-init*/null);
    this.FirstVisitState = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::~ModuleManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 302,
   FQN="clang::serialization::ModuleManager::~ModuleManager", NM="_ZN5clang13serialization13ModuleManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManagerD0Ev")
  //</editor-fold>
  public void $destroy() {
    for (/*uint*/int i = 0, e = Chain.size(); i != e; ++i)  {
      if (Chain.$at(e - i - 1) != null) { Chain.$at(e - i - 1).$destroy();};
    }
    if (FirstVisitState != null) { FirstVisitState.$destroy();};
    //START JDestroy
    ModulesInCommonWithGlobalIndex.$destroy();
    VisitOrder.$destroy();
    InMemoryBuffers.$destroy();
    Modules.$destroy();
    Roots.$destroy();
    PCHChain.$destroy();
    Chain.$destroy();
    //END JDestroy
  }

  
  /// \brief Forward iterator to traverse all loaded modules.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleManager.h", line = 124,
   FQN="clang::serialization::ModuleManager::begin", NM="_ZN5clang13serialization13ModuleManager5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager5beginEv")
  //</editor-fold>
  public type$ptr<ModuleFile /*P*/ /*P*/> begin() {
    return Chain.begin();
  }

  /// \brief Forward iterator end-point to traverse all loaded modules
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleManager.h", line = 126,
   FQN="clang::serialization::ModuleManager::end", NM="_ZN5clang13serialization13ModuleManager3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager3endEv")
  //</editor-fold>
  public type$ptr<ModuleFile /*P*/ /*P*/> end() {
    return Chain.end();
  }

  
  /// \brief Const forward iterator to traverse all loaded modules.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleManager.h", line = 129,
   FQN="clang::serialization::ModuleManager::begin", NM="_ZNK5clang13serialization13ModuleManager5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZNK5clang13serialization13ModuleManager5beginEv")
  //</editor-fold>
  public type$ptr<ModuleFile /*P*/ /*P*/> begin$Const() /*const*/ {
    return Chain.begin$Const();
  }

  /// \brief Const forward iterator end-point to traverse all loaded modules
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleManager.h", line = 131,
   FQN="clang::serialization::ModuleManager::end", NM="_ZNK5clang13serialization13ModuleManager3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZNK5clang13serialization13ModuleManager3endEv")
  //</editor-fold>
  public type$ptr<ModuleFile /*P*/ /*P*/> end$Const() /*const*/ {
    return Chain.end$Const();
  }

  
  /// \brief Reverse iterator to traverse all loaded modules.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleManager.h", line = 134,
   FQN="clang::serialization::ModuleManager::rbegin", NM="_ZN5clang13serialization13ModuleManager6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<ModuleFile /*P*/ > rbegin() {
    return Chain.rbegin();
  }

  /// \brief Reverse iterator end-point to traverse all loaded modules.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleManager.h", line = 136,
   FQN="clang::serialization::ModuleManager::rend", NM="_ZN5clang13serialization13ModuleManager4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager4rendEv")
  //</editor-fold>
  public std.reverse_iterator<ModuleFile /*P*/ > rend() {
    return Chain.rend();
  }

  
  /// \brief A range covering the PCH and preamble module files loaded.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::pch_modules">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleManager.h", line = 139,
   FQN="clang::serialization::ModuleManager::pch_modules", NM="_ZNK5clang13serialization13ModuleManager11pch_modulesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZNK5clang13serialization13ModuleManager11pch_modulesEv")
  //</editor-fold>
  public iterator_range<ModuleFile /*P*/ /*const*/> pch_modules() /*const*/ {
    return llvm.make_range(PCHChain.begin$Const(), PCHChain.end$Const());
  }

  
  /// \brief Returns the primary module associated with the manager, that is,
  /// the first module loaded
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::getPrimaryModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleManager.h", line = 145,
   FQN="clang::serialization::ModuleManager::getPrimaryModule", NM="_ZN5clang13serialization13ModuleManager16getPrimaryModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager16getPrimaryModuleEv")
  //</editor-fold>
  public ModuleFile /*&*/ getPrimaryModule() {
    return $Deref(Chain.$at(0));
  }

  
  /// \brief Returns the primary module associated with the manager, that is,
  /// the first module loaded.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::getPrimaryModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleManager.h", line = 149,
   FQN="clang::serialization::ModuleManager::getPrimaryModule", NM="_ZNK5clang13serialization13ModuleManager16getPrimaryModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZNK5clang13serialization13ModuleManager16getPrimaryModuleEv")
  //</editor-fold>
  public ModuleFile /*&*/ getPrimaryModule$Const() /*const*/ {
    return $Deref(Chain.$at$Const(0));
  }

  
  /// \brief Returns the module associated with the given index
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleManager.h", line = 152,
   FQN="clang::serialization::ModuleManager::operator[]", NM="_ZNK5clang13serialization13ModuleManagerixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZNK5clang13serialization13ModuleManagerixEj")
  //</editor-fold>
  public ModuleFile /*&*/ $at(/*uint*/int Index) /*const*/ {
    return $Deref(Chain.$at$Const(Index));
  }

  
  /// \brief Returns the module associated with the given name
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::lookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 31,
   FQN="clang::serialization::ModuleManager::lookup", NM="_ZN5clang13serialization13ModuleManager6lookupEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager6lookupEN4llvm9StringRefE")
  //</editor-fold>
  public ModuleFile /*P*/ lookup(StringRef Name) {
    /*const*/ FileEntry /*P*/ Entry = FileMgr.getFile(/*NO_COPY*/Name, /*openFile=*/ false, 
        /*cacheFailure=*/ false);
    if ((Entry != null)) {
      return lookup(Entry);
    }
    
    return null;
  }

  
  /// \brief Returns the module associated with the given module file.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::lookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 40,
   FQN="clang::serialization::ModuleManager::lookup", NM="_ZN5clang13serialization13ModuleManager6lookupEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager6lookupEPKNS_9FileEntryE")
  //</editor-fold>
  public ModuleFile /*P*/ lookup(/*const*/ FileEntry /*P*/ File) {
    DenseMapIterator</*const*/ FileEntry /*P*/ , ModuleFile /*P*/ > Known = Modules.find(File);
    if (Known.$eq(/*NO_ITER_COPY*/Modules.end())) {
      return null;
    }
    
    return Known.$arrow().second;
  }

  
  /// \brief Returns the in-memory (virtual file) buffer with the given name
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::lookupBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 49,
   FQN="clang::serialization::ModuleManager::lookupBuffer", NM="_ZN5clang13serialization13ModuleManager12lookupBufferEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager12lookupBufferEN4llvm9StringRefE")
  //</editor-fold>
  public std.unique_ptr<MemoryBuffer> lookupBuffer(StringRef Name) {
    /*const*/ FileEntry /*P*/ Entry = FileMgr.getFile(/*NO_COPY*/Name, /*openFile=*/ false, 
        /*cacheFailure=*/ false);
    return new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(InMemoryBuffers.$at_T1$C$R(Entry)));
  }

  
  /// \brief Number of modules loaded
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleManager.h", line = 164,
   FQN="clang::serialization::ModuleManager::size", NM="_ZNK5clang13serialization13ModuleManager4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZNK5clang13serialization13ModuleManager4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Chain.size();
  }

  
  /// \brief The result of attempting to add a new module.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::AddModuleResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ModuleManager.h", line = 167,
   FQN="clang::serialization::ModuleManager::AddModuleResult", NM="_ZN5clang13serialization13ModuleManager15AddModuleResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager15AddModuleResultE")
  //</editor-fold>
  public enum AddModuleResult implements Native.NativeUIntEnum {
    /// \brief The module file had already been loaded.
    AlreadyLoaded(0),
    /// \brief The module file was just loaded in response to this call.
    NewlyLoaded(AlreadyLoaded.getValue() + 1),
    /// \brief The module file is missing.
    Missing(NewlyLoaded.getValue() + 1),
    /// \brief The module file is out-of-date.
    OutOfDate(Missing.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AddModuleResult valueOf(int val) {
      AddModuleResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final AddModuleResult[] VALUES;
      private static final AddModuleResult[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AddModuleResult kind : AddModuleResult.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AddModuleResult[min < 0 ? (1-min) : 0];
        VALUES = new AddModuleResult[max >= 0 ? (1+max) : 0];
        for (AddModuleResult kind : AddModuleResult.values()) {
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
    private AddModuleResult(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  // JAVA: typedef ASTFileSignature (*ASTFileSignatureReader)(llvm::BitstreamReader &);
  
  /// \brief Attempts to create a new module and add it to the list of known
  /// modules.
  ///
  /// \param FileName The file name of the module to be loaded.
  ///
  /// \param Type The kind of module being loaded.
  ///
  /// \param ImportLoc The location at which the module is imported.
  ///
  /// \param ImportedBy The module that is importing this module, or NULL if
  /// this module is imported directly by the user.
  ///
  /// \param Generation The generation in which this module was loaded.
  ///
  /// \param ExpectedSize The expected size of the module file, used for
  /// validation. This will be zero if unknown.
  ///
  /// \param ExpectedModTime The expected modification time of the module
  /// file, used for validation. This will be zero if unknown.
  ///
  /// \param ExpectedSignature The expected signature of the module file, used
  /// for validation. This will be zero if unknown.
  ///
  /// \param ReadSignature Reads the signature from an AST file without actually
  /// loading it.
  ///
  /// \param Module A pointer to the module file if the module was successfully
  /// loaded.
  ///
  /// \param ErrorStr Will be set to a non-empty string if any errors occurred
  /// while trying to load the module.
  ///
  /// \return A pointer to the module that corresponds to this file name,
  /// and a value indicating whether the module was loaded.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::addModule">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 56,
   FQN="clang::serialization::ModuleManager::addModule", NM="_ZN5clang13serialization13ModuleManager9addModuleEN4llvm9StringRefENS0_10ModuleKindENS_14SourceLocationEPNS0_10ModuleFileEjlljPFjRNS2_15BitstreamReaderEERS7_RSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager9addModuleEN4llvm9StringRefENS0_10ModuleKindENS_14SourceLocationEPNS0_10ModuleFileEjlljPFjRNS2_15BitstreamReaderEERS7_RSs")
  //</editor-fold>
  public ModuleManager.AddModuleResult addModule(StringRef FileName, ModuleKind Type, 
           SourceLocation ImportLoc, ModuleFile /*P*/ ImportedBy, 
           /*uint*/int Generation, 
           long/*off_t*/ ExpectedSize, long/*time_t*/ ExpectedModTime, 
           /*uint*/int ExpectedSignature, 
           BitstreamReader$Ref2UInt ReadSignature, 
           final type$ref<ModuleFile /*P*/ /*&*/> Module, 
           final std.string/*&*/ ErrorStr) {
    Module.$set(null);
    
    // Look for the file entry. This only fails if the expected size or
    // modification time differ.
    type$ref</*const*/ FileEntry /*P*/ > Entry = create_type$ref();
    if (Type == ModuleKind.MK_ExplicitModule) {
      // If we're not expecting to pull this file out of the module cache, it
      // might have a different mtime due to being moved across filesystems in
      // a distributed build. The size must still match, though. (As must the
      // contents, but we can't check that.)
      ExpectedModTime = 0;
    }
    if (lookupModuleFile(new StringRef(FileName), ExpectedSize, ExpectedModTime, Entry)) {
      ErrorStr.$assign_T$C$P(/*KEEP_STR*/"module file out of date");
      return AddModuleResult.OutOfDate;
    }
    if (!(Entry.$deref() != null) && $noteq_StringRef(/*NO_COPY*/FileName, /*STRINGREF_STR*/"-")) {
      ErrorStr.$assign_T$C$P(/*KEEP_STR*/"module file not found");
      return AddModuleResult.Missing;
    }
    
    // Check whether we already loaded this module, before
    final type$ref<ModuleFile /*P*/ /*&*/> ModuleEntry = Modules.ref$at(Entry.$deref());
    boolean NewModule = false;
    if (!(ModuleEntry.$deref() != null)) {
      // Allocate a new module.
      ModuleFile /*P*/ New = new ModuleFile(Type, Generation);
      New.Index = Chain.size();
      New.FileName.$assignMove(FileName.str());
      New.File = Entry.$deref();
      New.ImportLoc.$assign(ImportLoc);
      Chain.push_back(New);
      if (!New.isModule()) {
        PCHChain.push_back(New);
      }
      if (!(ImportedBy != null)) {
        Roots.push_back(New);
      }
      NewModule = true;
      ModuleEntry.$set(New);
      
      New.InputFilesValidationTimestamp = $int2ulong(0);
      if (New.Kind == ModuleKind.MK_ImplicitModule) {
        std.string TimestampFilename = New.getTimestampFilename();
        Status $Status/*J*/= new Status();
        // A cached stat value would be fine as well.
        if (!FileMgr.getNoncachedStatValue(new StringRef(TimestampFilename), $Status)) {
          New.InputFilesValidationTimestamp
             = $Status.getLastModificationTime().toEpochTime();
        }
      }
      {
        std.unique_ptr<MemoryBuffer> Buffer = null;
        try {
          
          // Load the contents of the module
          Buffer = lookupBuffer(new StringRef(FileName));
          if (Buffer.$bool()) {
            // The buffer was already provided for us.
            New.Buffer.$assignMove(std.move(Buffer));
          } else {
            ErrorOr<std.unique_ptr<MemoryBuffer> > Buf = null;
            try {
              // Open the AST file.
              Buf/*J*/= new ErrorOr<std.unique_ptr<MemoryBuffer> >((new std.error_code()));
              if ($eq_StringRef(/*NO_COPY*/FileName, /*STRINGREF_STR*/"-")) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean(Buf.$assignMove($c$.track(MemoryBuffer.getSTDIN())));
                } finally {
                  $c$.$destroy();
                }
              } else {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  // Leave the FileEntry open so if it gets read again by another
                  // ModuleManager it must be the same underlying file.
                  // FIXME: Because FileManager::getFile() doesn't guarantee that it will
                  // give us an open file, this may not be 100% reliable.
                  $c$.clean(Buf.$assignMove($c$.track(FileMgr.getBufferForFile(New.File, 
                          /*IsVolatile=*/ false, 
                          /*ShouldClose=*/ false))));
                } finally {
                  $c$.$destroy();
                }
              }
              if (!Buf.$bool()) {
                ErrorStr.$assignMove(Buf.getError().message());
                return AddModuleResult.Missing;
              }
              
              New.Buffer.$assignMove(std.move(Buf.$star()));
            } finally {
              if (Buf != null) { Buf.$destroy(); }
            }
          }
        } finally {
          if (Buffer != null) { Buffer.$destroy(); }
        }
      }
      
      // Initialize the stream.
      PCHContainerRdr.ExtractPCH(New.Buffer.$arrow().getMemBufferRef(), New.StreamFile);
    }
    if ((ExpectedSignature != 0)) {
      if (NewModule) {
        ModuleEntry.$deref().Signature = ReadSignature.$call(ModuleEntry.$deref().StreamFile);
      } else {
        assert (ModuleEntry.$deref().Signature == ReadSignature.$call(ModuleEntry.$deref().StreamFile));
      }
      if (ModuleEntry.$deref().Signature != ExpectedSignature) {
        ErrorStr.$assign_T$C$P((ModuleEntry.$deref().Signature != 0) ? $("signature mismatch") : $("could not read module signature"));
        if (NewModule) {
          // Remove the module file immediately, since removeModules might try to
          // invalidate the file cache for Entry, and that is not safe if this
          // module is *itself* up to date, but has an out-of-date importer.
          Modules.erase(Entry.$deref());
          assert (Chain.back() == ModuleEntry.$deref());
          Chain.pop_back();
          if (!ModuleEntry.$deref().isModule()) {
            PCHChain.pop_back();
          }
          if (Roots.back() == ModuleEntry.$deref()) {
            Roots.pop_back();
          } else {
            assert Native.$bool(ImportedBy);
          }
          if (ModuleEntry.$deref() != null) { ModuleEntry.$deref().$destroy();};
        }
        return AddModuleResult.OutOfDate;
      }
    }
    if ((ImportedBy != null)) {
      ModuleEntry.$deref().ImportedBy.insert(ImportedBy);
      ImportedBy.Imports.insert(ModuleEntry.$deref());
    } else {
      if (!ModuleEntry.$deref().DirectlyImported) {
        ModuleEntry.$deref().ImportLoc.$assign(ImportLoc);
      }
      
      ModuleEntry.$deref().DirectlyImported = true;
    }
    
    Module.$set(ModuleEntry.$deref());
    return NewModule ? AddModuleResult.NewlyLoaded : AddModuleResult.AlreadyLoaded;
  }

  
  /// \brief Remove the given set of modules.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::removeModules">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 190,
   FQN="clang::serialization::ModuleManager::removeModules", NM="_ZN5clang13serialization13ModuleManager13removeModulesEPPNS0_10ModuleFileES4_RN4llvm15SmallPtrSetImplIS3_EEPNS_9ModuleMapE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager13removeModulesEPPNS0_10ModuleFileES4_RN4llvm15SmallPtrSetImplIS3_EEPNS_9ModuleMapE")
  //</editor-fold>
  public void removeModules(type$ptr<ModuleFile /*P*/ /*P*/> first, type$ptr<ModuleFile /*P*/ /*P*/> last, 
               final SmallPtrSetImpl<ModuleFile /*P*/ > /*&*/ LoadedSuccessfully, 
               ModuleMap /*P*/ modMap) {
    if ($eq_ptr(first, last)) {
      return;
    }
    
    // Explicitly clear VisitOrder since we might not notice it is stale.
    VisitOrder.clear();
    
    // Collect the set of module file pointers that we'll be removing.
    SmallPtrSet<ModuleFile /*P*/> victimSet/*J*/= new SmallPtrSet<ModuleFile /*P*/>(DenseMapInfo$LikePtr.$Info(), first, last, 4);
    
    ModuleFile2Size_type IsVictim = /*[&, &victimSet]*/ (ModuleFile /*P*/ MF) -> {
          return victimSet.count(MF) != 0;
        };
    // Remove any references to the now-destroyed modules.
    for (/*uint*/int i = 0, n = Chain.size(); i != n; ++i) {
      Chain.$at(i).ImportedBy.remove_if(IsVictim);
    }
    Roots.erase(std.remove_if(Roots.begin(), Roots.end(), IsVictim), 
        Roots.end());
    
    // Remove the modules from the PCH chain.
    for (type$ptr<ModuleFile /*P*/ /*P*/> I = $tryClone(first); $noteq_ptr(I, last); I.$preInc()) {
      if (!(I.$star()).isModule()) {
        PCHChain.erase(std.find(PCHChain.begin(), PCHChain.end(), I.$star()), 
            PCHChain.end());
        break;
      }
    }
    
    // Delete the modules and erase them from the various structures.
    for (type$ptr<ModuleFile /*P*/ /*P*/> victim = $tryClone(first); $noteq_ptr(victim, last); victim.$preInc()) {
      Modules.erase((victim.$star()).File);
      if ((modMap != null)) {
        StringRef ModuleName = new StringRef((victim.$star()).ModuleName);
        {
          Module /*P*/ mod = modMap.findModule(/*NO_COPY*/ModuleName);
          if ((mod != null)) {
            mod.setASTFile((/*const*/ FileEntry /*P*/ )null);
          }
        }
      }
      
      // Files that didn't make it through ReadASTCore successfully will be
      // rebuilt (or there was an error). Invalidate them so that we can load the
      // new files that will be renamed over the old ones.
      if (LoadedSuccessfully.count(victim.$star()) == 0) {
        FileMgr.invalidateCache((victim.$star()).File);
      }
      
      if (victim.$star() != null) { victim.$star().$destroy();};
    }
    
    // Remove the modules from the chain.
    Chain.erase(first, last);
  }

  
  /// \brief Add an in-memory buffer the list of known buffers
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::addInMemoryBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 246,
   FQN="clang::serialization::ModuleManager::addInMemoryBuffer", NM="_ZN5clang13serialization13ModuleManager17addInMemoryBufferEN4llvm9StringRefESt10unique_ptrINS2_12MemoryBufferESt14default_deleteIS5_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager17addInMemoryBufferEN4llvm9StringRefESt10unique_ptrINS2_12MemoryBufferESt14default_deleteIS5_EE")
  //</editor-fold>
  public void addInMemoryBuffer(StringRef FileName, 
                   std.unique_ptr<MemoryBuffer> Buffer) {
    
    /*const*/ FileEntry /*P*/ Entry = FileMgr.getVirtualFile(new StringRef(FileName), Buffer.$arrow().getBufferSize(), 0);
    InMemoryBuffers.$at_T1$C$R(Entry).$assignMove(std.move(Buffer));
  }

  
  /// \brief Set the global module index.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::setGlobalIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 274,
   FQN="clang::serialization::ModuleManager::setGlobalIndex", NM="_ZN5clang13serialization13ModuleManager14setGlobalIndexEPNS_17GlobalModuleIndexE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager14setGlobalIndexEPNS_17GlobalModuleIndexE")
  //</editor-fold>
  public void setGlobalIndex(GlobalModuleIndex /*P*/ Index) {
    GlobalIndex = Index;
    if (!(GlobalIndex != null)) {
      ModulesInCommonWithGlobalIndex.clear();
      return;
    }
    
    // Notify the global module index about all of the modules we've already
    // loaded.
    for (/*uint*/int I = 0, N = Chain.size(); I != N; ++I) {
      if (!GlobalIndex.loadedModuleFile(Chain.$at(I))) {
        ModulesInCommonWithGlobalIndex.push_back(Chain.$at(I));
      }
    }
  }

  
  /// \brief Notification from the AST reader that the given module file
  /// has been "accepted", and will not (can not) be unloaded.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::moduleFileAccepted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 290,
   FQN="clang::serialization::ModuleManager::moduleFileAccepted", NM="_ZN5clang13serialization13ModuleManager18moduleFileAcceptedEPNS0_10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager18moduleFileAcceptedEPNS0_10ModuleFileE")
  //</editor-fold>
  public void moduleFileAccepted(ModuleFile /*P*/ MF) {
    if (!(GlobalIndex != null) || GlobalIndex.loadedModuleFile(MF)) {
      return;
    }
    
    ModulesInCommonWithGlobalIndex.push_back(MF);
  }

  
  /// \brief Visit each of the modules.
  ///
  /// This routine visits each of the modules, starting with the
  /// "root" modules that no other loaded modules depend on, and
  /// proceeding to the leaf modules, visiting each module only once
  /// during the traversal.
  ///
  /// This traversal is intended to support various "lookup"
  /// operations that can find data in any of the loaded modules.
  ///
  /// \param Visitor A visitor function that will be invoked with each
  /// module. The return value must be convertible to bool; when false, the
  /// visitation continues to modules that the current module depends on. When
  /// true, the visitation skips any modules that the current module depends on.
  ///
  /// \param ModuleFilesHit If non-NULL, contains the set of module files
  /// that we know we need to visit because the global module index told us to.
  /// Any module that is known to both the global module index and the module
  /// manager that is *not* in this set can be skipped.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 308,
   FQN="clang::serialization::ModuleManager::visit", NM="_ZN5clang13serialization13ModuleManager5visitEN4llvm12function_refIFbRNS0_10ModuleFileEEEEPNS2_15SmallPtrSetImplIPS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager5visitEN4llvm12function_refIFbRNS0_10ModuleFileEEEEPNS2_15SmallPtrSetImplIPS4_EE")
  //</editor-fold>
  public void visit(ModuleFile$Ref2Bool Visitor) {
    visit(Visitor, 
       (SmallPtrSetImpl<ModuleFile /*P*/ > /*P*/ )null);
  }
  public void visit(ModuleFile$Ref2Bool Visitor, 
       SmallPtrSetImpl<ModuleFile /*P*/ > /*P*/ ModuleFilesHit/*= null*/) {
    // If the visitation order vector is the wrong size, recompute the order.
    if (VisitOrder.size() != Chain.size()) {
      /*uint*/int N = size();
      VisitOrder.clear();
      VisitOrder.reserve(N);
      
      // Record the number of incoming edges for each module. When we
      // encounter a module with no incoming edges, push it into the queue
      // to seed the queue.
      SmallVector<ModuleFile /*P*/ > Queue/*J*/= new SmallVector<ModuleFile /*P*/ >(4, (ModuleFile /*P*/ )null);
      Queue.reserve(N);
      SmallVectorUInt UnusedIncomingEdges/*J*/= new SmallVectorUInt(4, 0);
      UnusedIncomingEdges.resize(size());
      for (ModuleFile /*P*/ M : llvm.reverse$HasRBegin(/*Deref*/this)) {
        /*uint*/int Size = M.ImportedBy.size();
        UnusedIncomingEdges.$set(M.Index, Size);
        if (!(Size != 0)) {
          Queue.push_back(M);
        }
      }
      
      // Traverse the graph, making sure to visit a module before visiting any
      // of its dependencies.
      while (!Queue.empty()) {
        ModuleFile /*P*/ CurrentModule = Queue.pop_back_val();
        VisitOrder.push_back(CurrentModule);
        
        // For any module that this module depends on, push it on the
        // stack (if it hasn't already been marked as visited).
        for (std.reverse_iterator</*const*/ ModuleFile /*&*/ > M = CurrentModule.Imports.rbegin(), 
            MEnd = CurrentModule.Imports.rend();
             $noteq_reverse_iterator$C(M, MEnd); M.$preInc()) {
          // Remove our current module as an impediment to visiting the
          // module we depend on. If we were the last unvisited module
          // that depends on this particular module, push it into the
          // queue to be visited.
          final uint$ref/*uint &*/ NumUnusedEdges = UnusedIncomingEdges.ref$at((M.$star()).Index);
          if ((NumUnusedEdges.$deref() != 0) && (NumUnusedEdges.$set$preDec() == 0)) {
            Queue.push_back(M.$star());
          }
        }
      }
      assert (VisitOrder.size() == N) : "Visitation order is wrong?";
      
      if (FirstVisitState != null) { FirstVisitState.$destroy();};
      FirstVisitState = null;
    }
    
    VisitState /*P*/ State = allocateVisitState();
    /*uint*/int VisitNumber = State.NextVisitNumber++;
    
    // If the caller has provided us with a hit-set that came from the global
    // module index, mark every module file in common with the global module
    // index that is *not* in that set as 'visited'.
    if ((ModuleFilesHit != null) && !ModulesInCommonWithGlobalIndex.empty()) {
      for (/*uint*/int I = 0, N = ModulesInCommonWithGlobalIndex.size(); I != N; ++I) {
        ModuleFile /*P*/ M = ModulesInCommonWithGlobalIndex.$at(I);
        if (!(ModuleFilesHit.count(M) != 0)) {
          State.VisitNumber.$set(M.Index, VisitNumber);
        }
      }
    }
    
    for (/*uint*/int I = 0, N = VisitOrder.size(); I != N; ++I) {
      ModuleFile /*P*/ CurrentModule = VisitOrder.$at(I);
      // Should we skip this module file?
      if (State.VisitNumber.$at(CurrentModule.Index) == VisitNumber) {
        continue;
      }
      
      // Visit the module.
      assert (State.VisitNumber.$at(CurrentModule.Index) == VisitNumber - 1);
      State.VisitNumber.$set(CurrentModule.Index, VisitNumber);
      if (!Visitor.$call($Deref(CurrentModule))) {
        continue;
      }
      
      // The visitor has requested that cut off visitation of any
      // module that the current module depends on. To indicate this
      // behavior, we mark all of the reachable modules as having been visited.
      ModuleFile /*P*/ NextModule = CurrentModule;
      do {
        // For any module that this module depends on, push it on the
        // stack (if it hasn't already been marked as visited).
        for (std.vector.iterator</*const*/ ModuleFile /*P*/ > M = NextModule.Imports.begin(), 
            MEnd = NextModule.Imports.end();
             $noteq___normal_iterator$C(M, MEnd); M.$preInc()) {
          if (State.VisitNumber.$at((M.$star()).Index) != VisitNumber) {
            State.Stack.push_back(M.$star());
            State.VisitNumber.$set((M.$star()).Index, VisitNumber);
          }
        }
        if (State.Stack.empty()) {
          break;
        }
        
        // Pop the next module off the stack.
        NextModule = State.Stack.pop_back_val();
      } while (true);
    }
    
    returnVisitState(State);
  }

  
  /// \brief Attempt to resolve the given module file name to a file entry.
  ///
  /// \param FileName The name of the module file.
  ///
  /// \param ExpectedSize The size that the module file is expected to have.
  /// If the actual size differs, the resolver should return \c true.
  ///
  /// \param ExpectedModTime The modification time that the module file is
  /// expected to have. If the actual modification time differs, the resolver
  /// should return \c true.
  ///
  /// \param File Will be set to the file if there is one, or null
  /// otherwise.
  ///
  /// \returns True if a file exists but does not meet the size/
  /// modification time criteria, false if the file is either available and
  /// suitable, or is missing.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::lookupModuleFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 412,
   FQN="clang::serialization::ModuleManager::lookupModuleFile", NM="_ZN5clang13serialization13ModuleManager16lookupModuleFileEN4llvm9StringRefEllRPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager16lookupModuleFileEN4llvm9StringRefEllRPKNS_9FileEntryE")
  //</editor-fold>
  public boolean lookupModuleFile(StringRef FileName, 
                  long/*off_t*/ ExpectedSize, 
                  long/*time_t*/ ExpectedModTime, 
                  final type$ref</*const*/ FileEntry /*P*/ /*&*/> File) {
    // Open the file immediately to ensure there is no race between stat'ing and
    // opening the file.
    File.$set(FileMgr.getFile(/*NO_COPY*/FileName, /*openFile=*/ true, /*cacheFailure=*/ false));
    if (!(File.$deref() != null) && $noteq_StringRef(/*NO_COPY*/FileName, /*STRINGREF_STR*/"-")) {
      return false;
    }
    if (((ExpectedSize != 0) && ExpectedSize != File.$deref().getSize())
       || ((ExpectedModTime != 0) && ExpectedModTime != File.$deref().getModificationTime())) {
      // Do not destroy File, as it may be referenced. If we need to rebuild it,
      // it will be destroyed by removeModules.
      return true;
    }
    
    return false;
  }

  
  /// \brief View the graphviz representation of the module graph.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleManager::viewGraph">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 473,
   FQN="clang::serialization::ModuleManager::viewGraph", NM="_ZN5clang13serialization13ModuleManager9viewGraphEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN5clang13serialization13ModuleManager9viewGraphEv")
  //</editor-fold>
  public void viewGraph() {
    ViewGraph(/*Deref*/this, new Twine(/*KEEP_STR*/"Modules"));
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public Iterator<ModuleFile> iterator() {
    return new JavaIterator<ModuleFile>(begin(), end());
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Chain=" + Chain // NOI18N
              + ", PCHChain=" + PCHChain // NOI18N
              + ", Roots=" + Roots // NOI18N
              + ", Modules=" + Modules // NOI18N
              + ", FileMgr=" + "[FileManager]" // NOI18N
              + ", PCHContainerRdr=" + PCHContainerRdr // NOI18N
              + ", InMemoryBuffers=" + InMemoryBuffers // NOI18N
              + ", VisitOrder=" + VisitOrder // NOI18N
              + ", ModulesInCommonWithGlobalIndex=" + ModulesInCommonWithGlobalIndex // NOI18N
              + ", GlobalIndex=" + GlobalIndex // NOI18N
              + ", FirstVisitState=" + FirstVisitState; // NOI18N
  }
}
