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

package org.clang.lex;

import static org.clank.support.Native.*;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.impl.*;
import static org.clang.lex.impl.PreprocessingRecordStatics.*;
import static org.clank.support.Unsigned.*;

/// \brief A record of the steps taken while preprocessing a source file,
/// including the various preprocessing directives processed, macros 
/// expanded, etc.
//<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 290,
 FQN="clang::PreprocessingRecord", NM="_ZN5clang19PreprocessingRecordE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecordE")
//</editor-fold>
public class PreprocessingRecord extends /*public*/ PPCallbacks implements Destructors.ClassWithDestructor {
  private SourceManager /*&*/ SourceMgr;
  
  /// \brief Allocator used to store preprocessing objects.
  private BumpPtrAllocator BumpAlloc;
  
  /// \brief The set of preprocessed entities in this record, in order they
  /// were seen.
  private std.vector<PreprocessedEntity /*P*/ > PreprocessedEntities;
  
  /// \brief The set of preprocessed entities in this record that have been
  /// loaded from external sources.
  ///
  /// The entries in this vector are loaded lazily from the external source,
  /// and are referenced by the iterator using negative indices.
  private std.vector<PreprocessedEntity /*P*/ > LoadedPreprocessedEntities;
  
  /// \brief The set of ranges that were skipped by the preprocessor,
  private std.vector<SourceRange> SkippedRanges;
  
  /// \brief Global (loaded or local) ID for a preprocessed entity.
  /// Negative values are used to indicate preprocessed entities
  /// loaded from the external source while non-negative values are used to
  /// indicate preprocessed entities introduced by the current preprocessor.
  /// Value -1 corresponds to element 0 in the loaded entities vector,
  /// value -2 corresponds to element 1 in the loaded entities vector, etc.
  /// Value 0 is an invalid value, the index to local entities is 1-based,
  /// value 1 corresponds to element 0 in the local entities vector,
  /// value 2 corresponds to element 1 in the local entities vector, etc.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::PPEntityID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 319,
   FQN="clang::PreprocessingRecord::PPEntityID", NM="_ZN5clang19PreprocessingRecord10PPEntityIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord10PPEntityIDE")
  //</editor-fold>
  public static class PPEntityID {
    private int ID;
    //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::PPEntityID::PPEntityID">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 321,
     FQN="clang::PreprocessingRecord::PPEntityID::PPEntityID", NM="_ZN5clang19PreprocessingRecord10PPEntityIDC1Ei",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord10PPEntityIDC1Ei")
    //</editor-fold>
    private /*explicit*/ PPEntityID(int ID) {
      /* : ID(ID)*/ 
      //START JInit
      this.ID = ID;
      //END JInit
    }

    /*friend  class PreprocessingRecord*/
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::PPEntityID::PPEntityID">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 324,
     FQN="clang::PreprocessingRecord::PPEntityID::PPEntityID", NM="_ZN5clang19PreprocessingRecord10PPEntityIDC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord10PPEntityIDC1Ev")
    //</editor-fold>
    public PPEntityID() {
      /* : ID(0)*/ 
      //START JInit
      this.ID = 0;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::PPEntityID::PPEntityID">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 319,
     FQN="clang::PreprocessingRecord::PPEntityID::PPEntityID", NM="_ZN5clang19PreprocessingRecord10PPEntityIDC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord10PPEntityIDC1ERKS1_")
    //</editor-fold>
    public /*inline*/ PPEntityID(/*const*/ PPEntityID /*&*/ $Prm0) {
      /* : ID(.ID)*/ 
      //START JInit
      this.ID = $Prm0.ID;
      //END JInit
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::PPEntityID::PPEntityID">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 319,
     FQN="clang::PreprocessingRecord::PPEntityID::PPEntityID", NM="_ZN5clang19PreprocessingRecord10PPEntityIDC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord10PPEntityIDC1EOS1_")
    //</editor-fold>
    public /*inline*/ PPEntityID(JD$Move _dparam, PPEntityID /*&&*/$Prm0) {
      /* : ID(static_cast<PPEntityID &&>().ID)*/ 
      //START JInit
      this.ID = $Prm0.ID;
      //END JInit
    }

    
    public String toString() {
      return "" + "ID=" + ID; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::getPPEntityID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 327,
   FQN="clang::PreprocessingRecord::getPPEntityID", NM="_ZN5clang19PreprocessingRecord13getPPEntityIDEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord13getPPEntityIDEjb")
  //</editor-fold>
  /*friend*/public static PPEntityID getPPEntityID(/*uint*/int Index, boolean isLoaded) {
    return isLoaded ? new PPEntityID(-((int)(Index)) - 1) : new PPEntityID(Index + 1);
  }

  
  /// \brief Mapping from MacroInfo structures to their definitions.
  private DenseMap</*const*/ MacroInfo /*P*/ , MacroDefinitionRecord /*P*/ > MacroDefinitions;
  
  /// \brief External source of preprocessed entities.
  private ExternalPreprocessingRecordSource /*P*/ ExternalSource;
  
  /// \brief Retrieve the preprocessed entity at the given ID.
  
  /// \brief Retrieve the preprocessed entity at the given ID.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::getPreprocessedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 327,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 328,
   FQN="clang::PreprocessingRecord::getPreprocessedEntity", NM="_ZN5clang19PreprocessingRecord21getPreprocessedEntityENS0_10PPEntityIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord21getPreprocessedEntityENS0_10PPEntityIDE")
  //</editor-fold>
  /*friend*/public PreprocessedEntity /*P*/ getPreprocessedEntity(PPEntityID PPID) {
    if (PPID.ID < 0) {
      /*uint*/int Index = -PPID.ID - 1;
      assert ($less_uint(Index, LoadedPreprocessedEntities.size())) : "Out-of bounds loaded preprocessed entity";
      return getLoadedPreprocessedEntity(Index);
    }
    if (PPID.ID == 0) {
      return null;
    }
    /*uint*/int Index = PPID.ID - 1;
    assert ($less_uint(Index, PreprocessedEntities.size())) : "Out-of bounds local preprocessed entity";
    return PreprocessedEntities.$at(Index);
  }

  
  /// \brief Retrieve the loaded preprocessed entity at the given index.
  
  /// \brief Retrieve the loaded preprocessed entity at the given index.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::getLoadedPreprocessedEntity">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 344,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 345,
   FQN="clang::PreprocessingRecord::getLoadedPreprocessedEntity", NM="_ZN5clang19PreprocessingRecord27getLoadedPreprocessedEntityEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord27getLoadedPreprocessedEntityEj")
  //</editor-fold>
  /*friend*/public PreprocessedEntity /*P*/ getLoadedPreprocessedEntity(/*uint*/int Index) {
    assert ($less_uint(Index, LoadedPreprocessedEntities.size())) : "Out-of bounds loaded preprocessed entity";
    assert ((ExternalSource != null)) : "No external source to load from";
    // JAVA: MANUAL_SEMANTIC this is reference into internal array
    PreprocessedEntity /*P*/ /*&*/ Entity = LoadedPreprocessedEntities.$at(Index);
    if (!(Entity != null)) {
      Entity = ExternalSource.ReadPreprocessedEntity(Index);
      if (!(Entity != null)) {
        // Failed to load.
        Entity = new /*(*this)*/ PreprocessedEntity(PreprocessedEntity.EntityKind.InvalidKind, new SourceRange());
      }
      // JAVA: MANUAL_SEMANTIC put back into array
      LoadedPreprocessedEntities.$set(Index, Entity);
    }
    return Entity;
  }

  
  /// \brief Determine the number of preprocessed entities that were
  /// loaded (or can be loaded) from an external source.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::getNumLoadedPreprocessedEntities">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 345,
   FQN="clang::PreprocessingRecord::getNumLoadedPreprocessedEntities", NM="_ZNK5clang19PreprocessingRecord32getNumLoadedPreprocessedEntitiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang19PreprocessingRecord32getNumLoadedPreprocessedEntitiesEv")
  //</editor-fold>
  /*friend*/public /*uint*/int getNumLoadedPreprocessedEntities() /*const*/ {
    return LoadedPreprocessedEntities.size();
  }

  
  /// \brief Returns a pair of [Begin, End) indices of local preprocessed
  /// entities that \p Range encompasses.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::findLocalPreprocessedEntitiesInRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 156,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 158,
   FQN="clang::PreprocessingRecord::findLocalPreprocessedEntitiesInRange", NM="_ZNK5clang19PreprocessingRecord36findLocalPreprocessedEntitiesInRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang19PreprocessingRecord36findLocalPreprocessedEntitiesInRangeENS_11SourceRangeE")
  //</editor-fold>
  private std.pairUIntUInt findLocalPreprocessedEntitiesInRange(SourceRange Range) /*const*/ {
    if (Range.isInvalid()) {
      return std.make_pair_uint_uint(0, 0);
    }
    assert (!SourceMgr.isBeforeInTranslationUnit(Range.getEnd(), Range.getBegin()));
    
    /*uint*/int Begin = findBeginLocalPreprocessedEntity(Range.getBegin());
    /*uint*/int End = findEndLocalPreprocessedEntity(Range.getEnd());
    return std.make_pair_uint_uint(Begin, End);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::findBeginLocalPreprocessedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 200,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 202,
   FQN="clang::PreprocessingRecord::findBeginLocalPreprocessedEntity", NM="_ZNK5clang19PreprocessingRecord32findBeginLocalPreprocessedEntityENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang19PreprocessingRecord32findBeginLocalPreprocessedEntityENS_14SourceLocationE")
  //</editor-fold>
  private /*uint*/int findBeginLocalPreprocessedEntity(SourceLocation Loc) /*const*/ {
    if (SourceMgr.isLoadedSourceLocation(/*NO_COPY*/Loc)) {
      return 0;
    }
    
    /*size_t*/int Count = PreprocessedEntities.size();
    /*size_t*/int Half;
    std.vector.iterator<PreprocessedEntity/*P*/> First = PreprocessedEntities.begin();
    std.vector.iterator<PreprocessedEntity/*P*/> I/*J*/= new std.vector.iterator<PreprocessedEntity/*P*/>(PreprocessedEntities, 0, false);
    
    // Do a binary search manually instead of using std::lower_bound because
    // The end locations of entities may be unordered (when a macro expansion
    // is inside another macro argument), but for this case it is not important
    // whether we get the first macro expansion or its containing macro.
    while ($greater_uint(Count, 0)) {
      Half = Count / 2;
      I.$assign(First);
      std.advance(I, Half);
      if (SourceMgr.isBeforeInTranslationUnit((I.$star()).getSourceRange().getEnd(), 
          /*NO_COPY*/Loc)) {
        First.$assign(I);
        First.$preInc();
        Count = Count - Half - 1;
      } else {
        Count = Half;
      }
    }
    
    return $sub___normal_iterator$C(First, PreprocessedEntities.begin());
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::findEndLocalPreprocessedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 231,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 233,
   FQN="clang::PreprocessingRecord::findEndLocalPreprocessedEntity", NM="_ZNK5clang19PreprocessingRecord30findEndLocalPreprocessedEntityENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang19PreprocessingRecord30findEndLocalPreprocessedEntityENS_14SourceLocationE")
  //</editor-fold>
  private /*uint*/int findEndLocalPreprocessedEntity(SourceLocation Loc) /*const*/ {
    if (SourceMgr.isLoadedSourceLocation(/*NO_COPY*/Loc)) {
      return 0;
    }
    
    std.vector.iterator<PreprocessedEntity/*P*/> I = std.upper_bound(PreprocessedEntities.begin(), 
        PreprocessedEntities.end(), 
        Loc, 
        new PPEntityComp(SourceMgr, (SourceRange obj)->obj.getBegin()));
    return $sub___normal_iterator$C(I, PreprocessedEntities.begin());
  }

  
  /// \brief Allocate space for a new set of loaded preprocessed entities.
  ///
  /// \returns The index into the set of loaded preprocessed entities, which
  /// corresponds to the first newly-allocated entity.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::allocateLoadedEntities">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 314,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 315,
   FQN="clang::PreprocessingRecord::allocateLoadedEntities", NM="_ZN5clang19PreprocessingRecord22allocateLoadedEntitiesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord22allocateLoadedEntitiesEj")
  //</editor-fold>
  /*friend*/public /*uint*/int allocateLoadedEntities(/*uint*/int NumEntities) {
    /*uint*/int Result = LoadedPreprocessedEntities.size();
    LoadedPreprocessedEntities.resize(LoadedPreprocessedEntities.size()
            + NumEntities);
    return Result;
  }

  
  /// \brief Register a new macro definition.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::RegisterMacroDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 321,
   FQN="clang::PreprocessingRecord::RegisterMacroDefinition", NM="_ZN5clang19PreprocessingRecord23RegisterMacroDefinitionEPNS_9MacroInfoEPNS_21MacroDefinitionRecordE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord23RegisterMacroDefinitionEPNS_9MacroInfoEPNS_21MacroDefinitionRecordE")
  //</editor-fold>
  /*friend*/public void RegisterMacroDefinition(MacroInfo /*P*/ Macro, 
                         MacroDefinitionRecord /*P*/ Def) {
    MacroDefinitions.$set(Macro, Def);
  }

/*public:*/
  /// \brief Construct a new preprocessing record.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::PreprocessingRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 41,
   FQN="clang::PreprocessingRecord::PreprocessingRecord", NM="_ZN5clang19PreprocessingRecordC1ERNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecordC1ERNS_13SourceManagerE")
  //</editor-fold>
  public PreprocessingRecord(SourceManager /*&*/ SM) {
    /* : PPCallbacks(), SourceMgr(SM), BumpAlloc(), PreprocessedEntities(), LoadedPreprocessedEntities(), SkippedRanges(), MacroDefinitions(), ExternalSource(null), CachedRangeQuery()*/ 
    //START JInit
    super();
    this./*&*/SourceMgr=/*&*/SM;
    this.BumpAlloc = new BumpPtrAllocator();
    this.PreprocessedEntities = new std.vector<PreprocessedEntity /*P*/ >((PreprocessedEntity /*P*/ ) null);
    this.LoadedPreprocessedEntities = new std.vector<PreprocessedEntity /*P*/ >((PreprocessedEntity /*P*/ ) null);
    this.SkippedRanges = new std.vector<SourceRange>(SourceRange.EMPTY);
    this.MacroDefinitions = new DenseMap</*const*/ MacroInfo /*P*/ , MacroDefinitionRecord /*P*/ >(DenseMapInfo$LikePtr.$Info(), (MacroDefinitionRecord /*P*/ )null);
    this.ExternalSource = null;
    this.CachedRangeQuery = new Unnamed_struct3();
    //END JInit
  }

  
  /// \brief Allocate memory in the preprocessing record.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::Allocate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 370,
   FQN="clang::PreprocessingRecord::Allocate", NM="_ZN5clang19PreprocessingRecord8AllocateEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord8AllocateEjj")
  //</editor-fold>
  public char$ptr/*void P*/ Allocate(/*uint*/int Size) {
    return Allocate(Size, 8);
  }
  public char$ptr/*void P*/ Allocate(/*uint*/int Size, /*uint*/int Align/*= 8*/) {
    return BumpAlloc.Allocate(Size, Align);
  }

  
  /// \brief Deallocate memory in the preprocessing record.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::Deallocate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 375,
   FQN="clang::PreprocessingRecord::Deallocate", NM="_ZN5clang19PreprocessingRecord10DeallocateEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord10DeallocateEPv")
  //</editor-fold>
  public void Deallocate(Object/*void P*/ Ptr) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::getTotalMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 483,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 485,
   FQN="clang::PreprocessingRecord::getTotalMemory", NM="_ZNK5clang19PreprocessingRecord14getTotalMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang19PreprocessingRecord14getTotalMemoryEv")
  //</editor-fold>
  public /*size_t*/long getTotalMemory() /*const*/ {
    return BumpAlloc.getTotalMemory() 
            + llvm.capacity_in_bytes(MacroDefinitions) 
            + llvm.capacity_in_bytes(PreprocessedEntities) 
            + llvm.capacity_in_bytes(LoadedPreprocessedEntities);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 379,
   FQN="clang::PreprocessingRecord::getSourceManager", NM="_ZNK5clang19PreprocessingRecord16getSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang19PreprocessingRecord16getSourceManagerEv")
  //</editor-fold>
  public SourceManager /*&*/ getSourceManager() /*const*/ {
    return SourceMgr;
  }

  
  /// Iteration over the preprocessed entities.
  ///
  /// In a complete iteration, the iterator walks the range [-M, N),
  /// where negative values are used to indicate preprocessed entities
  /// loaded from the external source while non-negative values are used to
  /// indicate preprocessed entities introduced by the current preprocessor.
  /// However, to provide iteration in source order (for, e.g., chained
  /// precompiled headers), dereferencing the iterator flips the negative
  /// values (corresponding to loaded entities), so that position -M 
  /// corresponds to element 0 in the loaded entities vector, position -M+1
  /// corresponds to element 1 in the loaded entities vector, etc. This
  /// gives us a reasonably efficient, source-order walk.
  ///
  /// We define this as a wrapping iterator around an int. The
  /// iterator_adaptor_base class forwards the iterator methods to basic
  /// integer arithmetic.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::iterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 397,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 382,
   FQN="clang::PreprocessingRecord::iterator", NM="_ZN5clang19PreprocessingRecord8iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord8iteratorE")
  //</editor-fold>
  public static class iterator extends /*public*/ iterator_adaptor$Int_base<iterator/*, int*/, std.random_access_iterator_tag, PreprocessedEntity /*P*/> {
    private PreprocessingRecord /*P*/ Self;
    
    //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 403,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 408,
     FQN="clang::PreprocessingRecord::iterator::iterator", NM="_ZN5clang19PreprocessingRecord8iteratorC1EPS0_i",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord8iteratorC1EPS0_i")
    //</editor-fold>
    private iterator(PreprocessingRecord /*P*/ Self, int Position) {
      /* : iterator::iterator_adaptor_base<iterator, int, random_access_iterator_tag, PreprocessedEntity * , int, PreprocessedEntity * , PreprocessedEntity * , iterator_traits<int> >(Position), Self(Self)*/ 
      //START JInit
      super(JD$NotBaseOfRemoveCVRef.INSTANCE, Position);
      this.Self = Self;
      //END JInit
    }

    /*friend  class PreprocessingRecord*/
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 408,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 406,
     FQN="clang::PreprocessingRecord::iterator::iterator", NM="_ZN5clang19PreprocessingRecord8iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord8iteratorC1Ev")
    //</editor-fold>
    public iterator() {
      /* : iterator(null, 0)*/
      //START JInit
      this((PreprocessingRecord /*P*/ )null, 0);
      //END JInit
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::iterator::operator*">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 410,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 411,
     FQN="clang::PreprocessingRecord::iterator::operator*", NM="_ZNK5clang19PreprocessingRecord8iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang19PreprocessingRecord8iteratordeEv")
    //</editor-fold>
    public PreprocessedEntity /*P*/ $star() /*const*/ {
      boolean isLoaded = this.I.$deref() < 0;
      /*uint*/int Index = isLoaded ? Self.LoadedPreprocessedEntities.size() + this.I.$deref() : this.I.$deref();
      PPEntityID ID = Self.getPPEntityID(Index, isLoaded);
      return Self.getPreprocessedEntity(/*NO_COPY*/ID);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 417,
     FQN="clang::PreprocessingRecord::iterator::operator->", NM="_ZNK5clang19PreprocessingRecord8iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang19PreprocessingRecord8iteratorptEv")
    //</editor-fold>
    public PreprocessedEntity /*P*/ $arrow() /*const*/ {
      return /*Deref*/this.$star();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 397,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 382,
     FQN="clang::PreprocessingRecord::iterator::iterator", NM="_ZN5clang19PreprocessingRecord8iteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord8iteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ iterator(/*const*/ iterator /*&*/ $Prm0) {
      /* : iterator_adaptor_base<iterator, int, std::random_access_iterator_tag, PreprocessedEntity * , int, PreprocessedEntity * , PreprocessedEntity * >(), Self(.Self)*/ 
      //START JInit
      super($Prm0);
      this.Self = $Prm0.Self;
      //END JInit
    }
//    
//    // JAVA PERF: to prevent extra iterators creation, override it here
//    // JAVA: use the same logic as in $star, but with shift by D
//    @Converted(kind = Converted.Kind.MANUAL_ADDED)
//    public PreprocessedEntity $at(int D) {
////      return ($add_iterator_difference_type(/*Deref*/this, D)).$star();
//      // return *(*this + D);
//      boolean isLoaded = I < 0;
//      /*uint*/int Index = isLoaded ? Self.LoadedPreprocessedEntities.size() + I : I;
//      PPEntityID ID = Self.getPPEntityID(Index + D, isLoaded);
//      return Self.getPreprocessedEntity(ID);       
//    }

    //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 397,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 382,
     FQN="clang::PreprocessingRecord::iterator::iterator", NM="_ZN5clang19PreprocessingRecord8iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord8iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ iterator(JD$Move _dparam, iterator /*&&*/$Prm0) {
      /* : iterator_adaptor_base<iterator, int, std::random_access_iterator_tag, PreprocessedEntity * , int, PreprocessedEntity * , PreprocessedEntity * >(static_cast<iterator &&>()), Self(static_cast<iterator &&>().Self)*/ 
      //START JInit
      super(JD$Move.INSTANCE, $Prm0);
      this.Self = $Prm0.Self;
      //END JInit
    }
    
    @Override public iterator clone() { return new iterator(this); }
    
    public String toString() {
      return "" + "Self=" + Self // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  /// \brief Begin iterator for all preprocessed entities.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 421,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 502,
   FQN="clang::PreprocessingRecord::begin", NM="_ZN5clang19PreprocessingRecord5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord5beginEv")
  //</editor-fold>
  public iterator begin() {
    return new iterator(this, -(int)LoadedPreprocessedEntities.size());
  }

  
  /// \brief End iterator for all preprocessed entities.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 426,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 507,
   FQN="clang::PreprocessingRecord::end", NM="_ZN5clang19PreprocessingRecord3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord3endEv")
  //</editor-fold>
  public iterator end() {
    return new iterator(this, PreprocessedEntities.size());
  }

  
  /// \brief Begin iterator for local, non-loaded, preprocessed entities.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::local_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 431,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 512,
   FQN="clang::PreprocessingRecord::local_begin", NM="_ZN5clang19PreprocessingRecord11local_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord11local_beginEv")
  //</editor-fold>
  public iterator local_begin() {
    return new iterator(this, 0);
  }

  
  /// \brief End iterator for local, non-loaded, preprocessed entities.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::local_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 436,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 517,
   FQN="clang::PreprocessingRecord::local_end", NM="_ZN5clang19PreprocessingRecord9local_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord9local_endEv")
  //</editor-fold>
  public iterator local_end() {
    return new iterator(this, PreprocessedEntities.size());
  }

  
  /// \brief iterator range for the given range of loaded
  /// preprocessed entities.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::getIteratorsForLoadedRange">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 442,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 523,
   FQN="clang::PreprocessingRecord::getIteratorsForLoadedRange", NM="_ZN5clang19PreprocessingRecord26getIteratorsForLoadedRangeEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord26getIteratorsForLoadedRangeEjj")
  //</editor-fold>
  public iterator_range<PreprocessedEntity> getIteratorsForLoadedRange(/*uint*/int start, 
          /*uint*/int count) {
    /*uint*/int end = start + count;
    assert ($lesseq_uint(end, LoadedPreprocessedEntities.size()));
    return llvm.make_range(new iterator(this, ((int)(start)) - LoadedPreprocessedEntities.size()), 
            new iterator(this, ((int)(end)) - LoadedPreprocessedEntities.size()));
  }

  
  /// \brief Returns a range of preprocessed entities that source range \p R
  /// encompasses.
  ///
  /// \param R the range to look for preprocessed entities.
  ///
  
  /// \brief Returns a pair of [Begin, End) iterators of preprocessed entities
  /// that source range \p Range encompasses.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::getPreprocessedEntitiesInRange">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 48,
   FQN="clang::PreprocessingRecord::getPreprocessedEntitiesInRange", NM="_ZN5clang19PreprocessingRecord30getPreprocessedEntitiesInRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord30getPreprocessedEntitiesInRangeENS_11SourceRangeE")
  //</editor-fold>
  public iterator_range<PreprocessedEntity> getPreprocessedEntitiesInRange(SourceRange Range) {
    if (Range.isInvalid()) {
      return llvm.make_range(new iterator(), new iterator());
    }
    if (CachedRangeQuery.Range.$eq(Range)) {
      return llvm.make_range(new iterator(this, CachedRangeQuery.Result.first), 
              new iterator(this, CachedRangeQuery.Result.second));
    }
    
    std.pairIntInt Res = getPreprocessedEntitiesInRangeSlow(Range);
    
    CachedRangeQuery.Range.$assign(Range);
    CachedRangeQuery.Result.$assign(Res);
    
    return llvm.make_range(new iterator(this, Res.first), 
        new iterator(this, Res.second));
  }

  
  /// \brief Returns true if the preprocessed entity that \p PPEI iterator
  /// points to is coming from the file \p FID.
  ///
  /// Can be used to avoid implicit deserializations of preallocated
  /// preprocessed entities if we only care about entities of a specific file
  /// and not from files \#included in the range given at
  /// \see getPreprocessedEntitiesInRange.
  
  /// \brief Returns true if the preprocessed entity that \arg PPEI iterator
  /// points to is coming from the file \arg FID.
  ///
  /// Can be used to avoid implicit deserializations of preallocated
  /// preprocessed entities if we only care about entities of a specific file
  /// and not from files \#included in the range given at
  /// \see getPreprocessedEntitiesInRange.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::isEntityInFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 87,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 89,
   FQN="clang::PreprocessingRecord::isEntityInFileID", NM="_ZN5clang19PreprocessingRecord16isEntityInFileIDENS0_8iteratorENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord16isEntityInFileIDENS0_8iteratorENS_6FileIDE")
  //</editor-fold>
  public boolean isEntityInFileID(iterator PPEI, FileID FID) {
    if (FID.isInvalid()) {
      return false;
    }
    
    int Pos = std.distance(new iterator(this, 0), new iterator(PPEI));
    if (Pos < 0) {
      if ($greatereq_uint(((/*uint*/int)(-Pos - 1)), LoadedPreprocessedEntities.size())) {
        assert (false) : "Out-of bounds loaded preprocessed entity";
        return false;
      }
      assert ((ExternalSource != null)) : "No external source to load from";
      /*uint*/int LoadedIndex = LoadedPreprocessedEntities.size() + Pos;
      {
        PreprocessedEntity /*P*/ PPE = LoadedPreprocessedEntities.$at(LoadedIndex);
        if ((PPE != null)) {
          return isPreprocessedEntityIfInFileID(PPE, /*NO_COPY*/FID, SourceMgr);
        }
      }
      
      // See if the external source can see if the entity is in the file without
      // deserializing it.
      OptionalBool IsInFile = ExternalSource.isPreprocessedEntityInFileID(LoadedIndex, /*NO_COPY*/FID);
      if (IsInFile.hasValue()) {
        return IsInFile.getValue();
      }
      
      // The external source did not provide a definite answer, go and deserialize
      // the entity to check it.
      return isPreprocessedEntityIfInFileID(getLoadedPreprocessedEntity(LoadedIndex), 
              /*NO_COPY*/FID, SourceMgr);
    }
    if ($greatereq_uint(((/*uint*/int)(Pos)), PreprocessedEntities.size())) {
      assert (false) : "Out-of bounds local preprocessed entity";
      return false;
    }
    return isPreprocessedEntityIfInFileID(PreprocessedEntities.$at(Pos), 
            /*NO_COPY*/FID, SourceMgr);
  }

  
  /// \brief Add a new preprocessed entity to this record.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::addPreprocessedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 244,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 246,
   FQN="clang::PreprocessingRecord::addPreprocessedEntity", NM="_ZN5clang19PreprocessingRecord21addPreprocessedEntityEPNS_18PreprocessedEntityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord21addPreprocessedEntityEPNS_18PreprocessedEntityE")
  //</editor-fold>
  public PreprocessingRecord.PPEntityID addPreprocessedEntity(PreprocessedEntity /*P*/ Entity) {
    assert (Entity != null);
    SourceLocation BeginLoc = Entity.getSourceRange().getBegin();
    if (isa(MacroDefinitionRecord.class, Entity)) {
      assert ((PreprocessedEntities.empty() || !SourceMgr.isBeforeInTranslationUnit(/*NO_COPY*/BeginLoc, PreprocessedEntities.back().getSourceRange().getBegin()))) : "a macro definition was encountered out-of-order";
      PreprocessedEntities.push_back(Entity);
      return getPPEntityID(PreprocessedEntities.size() - 1, /*isLoaded=*/ false);
    }
    
    // Check normal case, this entity begin location is after the previous one.
    if (PreprocessedEntities.empty() 
        || !SourceMgr.isBeforeInTranslationUnit(/*NO_COPY*/BeginLoc, 
         PreprocessedEntities.back().getSourceRange().getBegin())) {
      PreprocessedEntities.push_back(Entity);
      return getPPEntityID(PreprocessedEntities.size() - 1, /*isLoaded=*/ false);
    }
    
    // The entity's location is not after the previous one; this can happen with
    // include directives that form the filename using macros, e.g:
    // "#include MACRO(STUFF)"
    // or with macro expansions inside macro arguments where the arguments are
    // not expanded in the same order as listed, e.g:
    // \code
    //  #define M1 1
    //  #define M2 2
    //  #define FM(x,y) y x
    //  FM(M1, M2)
    // \endcode
    /*typedef std::vector<PreprocessedEntity *>::iterator pp_iter*/
//    final class pp_iter extends std.vector.iterator<PreprocessedEntity/*P*/>{ };
    
    // Usually there are few macro expansions when defining the filename, do a
    // linear search for a few entities.
    /*uint*/int count = 0;
    for (std.vector.iterator<PreprocessedEntity/*P*/> RI = PreprocessedEntities.end(), 
        Begin = PreprocessedEntities.begin(); 
         $noteq___normal_iterator$C(RI, Begin) && $less_uint(count, 4); RI.$preDec() , ++count) {
      std.vector.iterator<PreprocessedEntity/*P*/> I = new std.vector.iterator<PreprocessedEntity/*P*/>(RI);
      I.$preDec();
      if (!SourceMgr.isBeforeInTranslationUnit(/*NO_COPY*/BeginLoc, 
              (I.$star()).getSourceRange().getBegin())) {
        std.vector.iterator<PreprocessedEntity/*P*/> insertI = PreprocessedEntities.insert(RI, Entity);
        return getPPEntityID($sub___normal_iterator$C(insertI, PreprocessedEntities.begin()), 
                /*isLoaded=*/ false);
      }
    }
    
    // Linear search unsuccessful. Do a binary search.
    std.vector.iterator<PreprocessedEntity/*P*/> I = std.upper_bound(PreprocessedEntities.begin(), 
            PreprocessedEntities.end(), 
            BeginLoc, 
            new PPEntityComp(SourceMgr, (SourceRange obj)->obj.getBegin()));
    std.vector.iterator<PreprocessedEntity/*P*/> insertI = PreprocessedEntities.insert(I, Entity);
    return getPPEntityID($sub___normal_iterator(insertI, PreprocessedEntities.begin()), 
            /*isLoaded=*/ false);
  }

  
  /// \brief Set the external source for preprocessed entities.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::SetExternalSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 307,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 308,
   FQN="clang::PreprocessingRecord::SetExternalSource", NM="_ZN5clang19PreprocessingRecord17SetExternalSourceERNS_33ExternalPreprocessingRecordSourceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord17SetExternalSourceERNS_33ExternalPreprocessingRecordSourceE")
  //</editor-fold>
  public void SetExternalSource(ExternalPreprocessingRecordSource /*&*/ Source) {
    assert (!(ExternalSource != null)) : "Preprocessing record already has an external source";
    ExternalSource = $AddrOf(Source);
  }

  
  /// \brief Retrieve the external source for preprocessed entities.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::getExternalSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 475,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 555,
   FQN="clang::PreprocessingRecord::getExternalSource", NM="_ZNK5clang19PreprocessingRecord17getExternalSourceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang19PreprocessingRecord17getExternalSourceEv")
  //</editor-fold>
  public ExternalPreprocessingRecordSource /*P*/ getExternalSource() /*const*/ {
    return ExternalSource;
  }

  
  /// \brief Retrieve the macro definition that corresponds to the given
  /// \c MacroInfo.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::findMacroDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 359,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 360,
   FQN="clang::PreprocessingRecord::findMacroDefinition", NM="_ZN5clang19PreprocessingRecord19findMacroDefinitionEPKNS_9MacroInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord19findMacroDefinitionEPKNS_9MacroInfoE")
  //</editor-fold>
  public MacroDefinitionRecord /*P*/ findMacroDefinition(/*const*/ MacroInfo /*P*/ MI) {
    DenseMapIterator</*const*/ MacroInfo /*P*/ , MacroDefinitionRecord /*P*/ > Pos = MacroDefinitions.find(MI);
    if (Pos.$eq(/*NO_ITER_COPY*/MacroDefinitions.end())) {
      return null;
    }
    
    return Pos.$arrow().second;
  }
  
  
  /// \brief Retrieve all ranges that got skipped while preprocessing.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::getSkippedRanges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 484,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 564,
   FQN="clang::PreprocessingRecord::getSkippedRanges", NM="_ZNK5clang19PreprocessingRecord16getSkippedRangesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang19PreprocessingRecord16getSkippedRangesEv")
  //</editor-fold>
  public /*const*/std.vector<SourceRange> /*&*/ getSkippedRanges() /*const*/ {
    return SkippedRanges;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::MacroExpands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 412,
   FQN="clang::PreprocessingRecord::MacroExpands", NM="_ZN5clang19PreprocessingRecord12MacroExpandsERKNS_5TokenERKNS_15MacroDefinitionENS_11SourceRangeEPKNS_9MacroArgsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord12MacroExpandsERKNS_5TokenERKNS_15MacroDefinitionENS_11SourceRangeEPKNS_9MacroArgsE")
  //</editor-fold>
  @Override public/*private*/ void MacroExpands(/*const*/ Token /*&*/ Id, 
              /*const*/ MacroDefinition /*&*/ MD, 
              SourceRange Range, 
              /*const*/ MacroArgs /*P*/ Args)/* override*/ {
    addMacroExpansion(Id, MD.getMacroInfo(), /*NO_COPY*/Range);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::MacroDefined">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 419,
   FQN="clang::PreprocessingRecord::MacroDefined", NM="_ZN5clang19PreprocessingRecord12MacroDefinedERKNS_5TokenEPKNS_14MacroDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord12MacroDefinedERKNS_5TokenEPKNS_14MacroDirectiveE")
  //</editor-fold>
  @Override public/*private*/ void MacroDefined(SourceLocation HashLoc, SourceLocation EodLoc, /*MANUAL_SEMANTIC*/
          /*const*/Token /*&*/ Id, /*const*/ MacroDirective /*P*/ MD)/* override*/ {
    /*const*/ MacroInfo /*P*/ MI = MD.getMacroInfo();
    SourceRange R/*J*/= new SourceRange(MI.$getDefinitionLoc(), MI.$getDefinitionEndLoc());
    MacroDefinitionRecord /*P*/ Def = /*FIXME:*//*new (*this)*/ new MacroDefinitionRecord(Id.getIdentifierInfo(), /*NO_COPY*/R);
    addPreprocessedEntity(Def);
    MacroDefinitions.$set(MI, Def);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::MacroUndefined">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 429,
   FQN="clang::PreprocessingRecord::MacroUndefined", NM="_ZN5clang19PreprocessingRecord14MacroUndefinedERKNS_5TokenERKNS_15MacroDefinitionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord14MacroUndefinedERKNS_5TokenERKNS_15MacroDefinitionE")
  //</editor-fold>
  @Override public/*private*/ void MacroUndefined(SourceLocation HashLoc, SourceLocation EodLoc,/*MANUAL_SEMANTIC*/
          /*const*/ Token /*&*/ Id, 
          /*const*/ MacroDefinition /*&*/ MD)/* override*/ {
    MD.forAllDefinitions(/*[&]*/(MacroInfo /*P*/ MI) -> { MacroDefinitions.erase(MI); });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::InclusionDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 434,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 436,
   FQN = "clang::PreprocessingRecord::InclusionDirective", NM = "_ZN5clang19PreprocessingRecord18InclusionDirectiveENS_14SourceLocationERKNS_5TokenEN4llvm9StringRefEbNS_15CharSourceRangeEPKNS_9FileEntryES6_S6_PKNS_6ModuleE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord18InclusionDirectiveENS_14SourceLocationERKNS_5TokenEN4llvm9StringRefEbNS_15CharSourceRangeEPKNS_9FileEntryES6_S6_PKNS_6ModuleE")
  //</editor-fold>
  @Override public/*private*/ void InclusionDirective(SourceLocation HashLoc, SourceLocation EodLoc,                   
                  /*const*/ Token /*&*/ IncludeTok, 
                  StringRef FileName, 
                  boolean IsAngled, 
                  CharSourceRange FilenameRange, 
                  /*const*/ FileEntry /*P*/ File, 
                  StringRef SearchPath, 
                  StringRef RelativePath, 
                  /*const*/ Module /*P*/ Imported)/* override*/ {
    InclusionDirective.InclusionKind Kind = InclusionDirective.InclusionKind.Include;
    switch (IncludeTok.getIdentifierInfo().getPPKeywordID()) {
     case tok.PPKeywordKind.pp_include:
      Kind = InclusionDirective.InclusionKind.Include;
      break;
     case tok.PPKeywordKind.pp_import:
      Kind = InclusionDirective.InclusionKind.Import;
      break;
     case tok.PPKeywordKind.pp_include_next:
      Kind = InclusionDirective.InclusionKind.IncludeNext;
      break;
     case tok.PPKeywordKind.pp___include_macros:
      Kind = InclusionDirective.InclusionKind.IncludeMacros;
      break;
     default:
      throw new llvm_unreachable("Unknown include directive kind");
    }
    
    SourceLocation EndLoc/*J*/= new SourceLocation();
    if (!IsAngled) {
      EndLoc.$assignMove(FilenameRange.getBegin());
    } else {
      EndLoc.$assignMove(FilenameRange.getEnd());
      if (FilenameRange.isCharRange()) {
        EndLoc.$assignMove(EndLoc.getLocWithOffset(-1)); // the InclusionDirective expects
        // a token range.
      }
    }
    InclusionDirective /*P*/ ID = /*FIXME:*//*new (*this)*/ new InclusionDirective(/*Deref*/this, Kind, /*NO_COPY*/FileName, !IsAngled, 
            (boolean)(Imported != null), 
        File, new SourceRange(/*NO_COPY*/HashLoc, /*NO_COPY*/EndLoc));
    addPreprocessedEntity(ID);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::Ifdef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 383,
   FQN="clang::PreprocessingRecord::Ifdef", NM="_ZN5clang19PreprocessingRecord5IfdefENS_14SourceLocationERKNS_5TokenERKNS_15MacroDefinitionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord5IfdefENS_14SourceLocationERKNS_5TokenERKNS_15MacroDefinitionE")
  //</editor-fold>
  @Override public/*private*/ void Ifdef(SourceLocation HashLoc, SourceLocation EodLoc,/*MANUAL_SEMANTIC*/
          SourceLocation Loc, /*const*/ Token /*&*/ MacroNameTok, 
          /*const*/ MacroDefinition /*&*/ MD)/* override*/ {
    // This is not actually a macro expansion but record it as a macro reference.
    if (MD.$bool()) {
      addMacroExpansion(MacroNameTok, MD.getMacroInfo(), 
          new SourceRange(MacroNameTok.$getLocation()));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::Ifndef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 391,
   FQN="clang::PreprocessingRecord::Ifndef", NM="_ZN5clang19PreprocessingRecord6IfndefENS_14SourceLocationERKNS_5TokenERKNS_15MacroDefinitionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord6IfndefENS_14SourceLocationERKNS_5TokenERKNS_15MacroDefinitionE")
  //</editor-fold>
  @Override public/*private*/ void Ifndef(SourceLocation HashLoc, SourceLocation EodLoc, /*MANUAL_SEMANTIC*/
          SourceLocation Loc, /*const*/Token /*&*/ MacroNameTok, 
          /*const*/ MacroDefinition /*&*/ MD)/* override*/ {
    // This is not actually a macro expansion but record it as a macro reference.
    if (MD.$bool()) {
      addMacroExpansion(MacroNameTok, MD.getMacroInfo(), 
          new SourceRange(MacroNameTok.$getLocation()));
    }
  }

  /// \brief Hook called whenever the 'defined' operator is seen.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::Defined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 399,
   FQN="clang::PreprocessingRecord::Defined", NM="_ZN5clang19PreprocessingRecord7DefinedERKNS_5TokenERKNS_15MacroDefinitionENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord7DefinedERKNS_5TokenERKNS_15MacroDefinitionENS_11SourceRangeE")
  //</editor-fold>
  @Override public/*private*/ void Defined(/*const*/ Token /*&*/ MacroNameTok, 
         /*const*/ MacroDefinition /*&*/ MD, 
         SourceRange Range)/* override*/ {
    // This is not actually a macro expansion but record it as a macro reference.
    if (MD.$bool()) {
      addMacroExpansion(MacroNameTok, MD.getMacroInfo(), 
          new SourceRange(MacroNameTok.$getLocation()));
    }
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::SourceRangeSkipped">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 408,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 409,
   FQN="clang::PreprocessingRecord::SourceRangeSkipped", NM="_ZN5clang19PreprocessingRecord18SourceRangeSkippedENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord18SourceRangeSkippedENS_11SourceRangeE")
  //</editor-fold>
  @Override public/*private*/ void SourceRangeSkipped(SourceRange Range)/* override*/ {
    SkippedRanges.push_back(Range);
  }
  

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::addMacroExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 369,
   FQN="clang::PreprocessingRecord::addMacroExpansion", NM="_ZN5clang19PreprocessingRecord17addMacroExpansionERKNS_5TokenEPKNS_9MacroInfoENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord17addMacroExpansionERKNS_5TokenEPKNS_9MacroInfoENS_11SourceRangeE")
  //</editor-fold>
  private void addMacroExpansion(/*const*/ Token /*&*/ Id, 
                    /*const*/ MacroInfo /*P*/ MI, 
                    SourceRange Range) {
    // We don't record nested macro expansions.
    if (SourceLocation.isMacroID(Id.$getLocation())) {
      return;
    }
    if (MI.isBuiltinMacro()) {
      addPreprocessedEntity(/*FIXME:*//*new (*this)*/ new MacroExpansion(Id.getIdentifierInfo(), /*NO_COPY*/Range));
    } else {
      MacroDefinitionRecord /*P*/ Def = findMacroDefinition(MI);
      if ((Def != null)) {
        addPreprocessedEntity(/*FIXME:*//*new (*this)*/ new MacroExpansion(Def, /*NO_COPY*/Range));
      }
    }
  }

  
  /// \brief Cached result of the last \see getPreprocessedEntitiesInRange
  /// query.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 514,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 594,
   FQN="clang::PreprocessingRecord::(anonymous)", NM="_ZN5clang19PreprocessingRecordE_Unnamed_struct3",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecordE_Unnamed_struct3")
  //</editor-fold>
  private static class/*struct*/ Unnamed_struct3 {
    public SourceRange Range;
    public std.pairIntInt Result;
    //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::(anonymous struct)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 514,
     FQN="clang::PreprocessingRecord::(anonymous struct)::", NM="_ZN5clang19PreprocessingRecordUt_C1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecordUt_C1Ev")
    //</editor-fold>
    public /*inline*/ Unnamed_struct3() {
      /* : Range(), Result()*/ 
      //START JInit
      this.Range = new SourceRange();
      this.Result = new std.pairIntInt();
      //END JInit
    }

    
    public String toString() {
      return "" + "Range=" + Range // NOI18N
                + ", Result=" + Result; // NOI18N
    }
  };
  private Unnamed_struct3 CachedRangeQuery;
  
  
  /// \brief Returns a pair of [Begin, End) iterators of preprocessed entities
  /// that source range \arg R encompasses.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::getPreprocessedEntitiesInRangeSlow">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 126,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", old_line = 128,
   FQN="clang::PreprocessingRecord::getPreprocessedEntitiesInRangeSlow", NM="_ZN5clang19PreprocessingRecord34getPreprocessedEntitiesInRangeSlowENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecord34getPreprocessedEntitiesInRangeSlowENS_11SourceRangeE")
  //</editor-fold>
  private std.pairIntInt getPreprocessedEntitiesInRangeSlow(SourceRange Range) {
    assert (Range.isValid());
    assert (!SourceMgr.isBeforeInTranslationUnit(Range.getEnd(), Range.getBegin()));
    
    std.pairUIntUInt Local = findLocalPreprocessedEntitiesInRange(/*NO_COPY*/Range);
    
    // Check if range spans local entities.
    if (!(ExternalSource != null) || SourceMgr.isLocalSourceLocation(Range.getBegin())) {
      return std.make_pair_int_int(Local.first, Local.second);
    }
    
    std.pairUIntUInt Loaded = ExternalSource.findPreprocessedEntitiesInRange(/*NO_COPY*/Range);
    
    // Check if range spans local entities.
    if (Loaded.first == Loaded.second) {
      return std.make_pair_int_int(Local.first, Local.second);
    }
    
    /*uint*/int TotalLoaded = LoadedPreprocessedEntities.size();
    
    // Check if range spans loaded entities.
    if (Local.first == Local.second) {
      return std.make_pair_int_int(((int)(Loaded.first)) - TotalLoaded, 
              ((int)(Loaded.second)) - TotalLoaded);
    }
    
    // Range spands loaded and local entities.
    return std.make_pair_int_int(((int)(Loaded.first)) - TotalLoaded, Local.second);
  }

  
  /*friend  class ASTReader*/
  /*friend  class ASTWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::~PreprocessingRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 290,
   FQN="clang::PreprocessingRecord::~PreprocessingRecord", NM="_ZN5clang19PreprocessingRecordD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang19PreprocessingRecordD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    MacroDefinitions.$destroy();
    SkippedRanges.$destroy();
    LoadedPreprocessedEntities.$destroy();
    PreprocessedEntities.$destroy();
    BumpAlloc.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" /* STACKOVERFLOW: NEVER PRINT SourceManager + ", SourceMgr=" + SourceMgr // NOI18N*/
              + ", BumpAlloc=" + BumpAlloc // NOI18N
              + ", PreprocessedEntities=" + PreprocessedEntities // NOI18N
              + ", LoadedPreprocessedEntities=" + LoadedPreprocessedEntities // NOI18N
              + ", SkippedRanges=" + SkippedRanges // NOI18N
              + ", MacroDefinitions=" + MacroDefinitions // NOI18N
              + ", ExternalSource=" + ExternalSource // NOI18N
              + ", CachedRangeQuery=" + CachedRangeQuery // NOI18N
              + super.toString(); // NOI18N
  }
}
