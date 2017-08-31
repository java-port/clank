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

package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.profiledata.coverage.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;


/// \brief A StmtVisitor that creates coverage mapping regions which map
/// from the source code locations to the PGO counters.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 364,
 FQN="(anonymous namespace)::CounterCoverageMappingBuilder", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilderE")
//</editor-fold>
public class/*struct*/ CounterCoverageMappingBuilder extends /*public*/ CoverageMappingBuilder implements /*public*/ ConstStmtVisitorVoid<CounterCoverageMappingBuilder>, Destructors.ClassWithDestructor {
  /// \brief The map of statements to count values.
  public final DenseMapTypeUInt</*const*/ Stmt /*P*/ > /*&*/ CounterMap;
  
  /// \brief A stack of currently live regions.
  public std.vector<SourceMappingRegion> RegionStack;
  
  public CounterExpressionBuilder Builder;
  
  /// \brief A location in the most recently visited file or macro.
  ///
  /// This is used to adjust the active source regions appropriately when
  /// expressions cross file or macro boundaries.
  public SourceLocation MostRecentLocation;
  
  /// \brief Return a counter for the subtraction of \c RHS from \c LHS
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::subtractCounters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 382,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::subtractCounters", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder16subtractCountersEN4llvm8coverage7CounterES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder16subtractCountersEN4llvm8coverage7CounterES3_")
  //</editor-fold>
  public Counter subtractCounters(Counter LHS, Counter RHS) {
    return Builder.subtract(new Counter(LHS), new Counter(RHS));
  }

  
  /// \brief Return a counter for the sum of \c LHS and \c RHS.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::addCounters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 387,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::addCounters", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder11addCountersEN4llvm8coverage7CounterES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder11addCountersEN4llvm8coverage7CounterES3_")
  //</editor-fold>
  public Counter addCounters(Counter LHS, Counter RHS) {
    return Builder.add(new Counter(LHS), new Counter(RHS));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::addCounters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 391,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::addCounters", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder11addCountersEN4llvm8coverage7CounterES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder11addCountersEN4llvm8coverage7CounterES3_S3_")
  //</editor-fold>
  public Counter addCounters(Counter C1, Counter C2, Counter C3) {
    return addCounters(addCounters(new Counter(C1), new Counter(C2)), new Counter(C3));
  }

  
  /// \brief Return the region counter for the given statement.
  ///
  /// This should only be called on statements that have a dedicated counter.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::getRegionCounter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 398,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::getRegionCounter", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder16getRegionCounterEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder16getRegionCounterEPKN5clang4StmtE")
  //</editor-fold>
  public Counter getRegionCounter(/*const*/ Stmt /*P*/ S) {
    return Counter.getCounter(CounterMap.$at_T1$C$R(S));
  }

  
  /// \brief Push a region onto the stack.
  ///
  /// Returns the index on the stack where the region was pushed. This can be
  /// used with popRegions to exit a "scope", ending the region that was pushed.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::pushRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 406,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::pushRegion", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder10pushRegionEN4llvm8coverage7CounterENS1_8OptionalIN5clang14SourceLocationEEES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder10pushRegionEN4llvm8coverage7CounterENS1_8OptionalIN5clang14SourceLocationEEES7_")
  //</editor-fold>
  public /*size_t*/int pushRegion(Counter Count) {
    return pushRegion(Count, new Optional<SourceLocation>(None), 
            new Optional<SourceLocation>(None));
  }
  public /*size_t*/int pushRegion(Counter Count, Optional<SourceLocation> StartLoc/*= None*/) {
    return pushRegion(Count, StartLoc, 
            new Optional<SourceLocation>(None));
  }
  public /*size_t*/int pushRegion(Counter Count, Optional<SourceLocation> StartLoc/*= None*/, 
            Optional<SourceLocation> EndLoc/*= None*/) {
    if (StartLoc.$bool()) {
      MostRecentLocation.$assign(StartLoc.$star());
    }
    RegionStack.emplace_back(new SourceMappingRegion(Count, StartLoc, EndLoc));
    
    return RegionStack.size() - 1;
  }

  
  /// \brief Pop regions from the stack into the function's list of regions.
  ///
  /// Adds all regions from \c ParentIndex to the top of the stack to the
  /// function's \c SourceRegions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::popRegions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 419,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::popRegions", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder10popRegionsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder10popRegionsEj")
  //</editor-fold>
  public void popRegions(/*size_t*/int ParentIndex) {
    assert ($greatereq_uint(RegionStack.size(), ParentIndex)) : "parent not in stack";
    while ($greater_uint(RegionStack.size(), ParentIndex)) {
      final SourceMappingRegion /*&*/ Region = RegionStack.back();
      if (Region.hasStartLoc()) {
        SourceLocation StartLoc = Region.getStartLoc();
        SourceLocation EndLoc = Region.hasEndLoc() ? Region.getEndLoc() : RegionStack.$at(ParentIndex).getEndLoc();
        while (!SM.isWrittenInSameFile(/*NO_COPY*/StartLoc, /*NO_COPY*/EndLoc)) {
          // The region ends in a nested file or macro expansion. Create a
          // separate region for each expansion.
          SourceLocation NestedLoc = getStartOfFileOrMacro(new SourceLocation(EndLoc));
          assert (SM.isWrittenInSameFile(/*NO_COPY*/NestedLoc, /*NO_COPY*/EndLoc));
          
          SourceRegions.emplace_back(new SourceMappingRegion(Region.getCounter(), NestedLoc, EndLoc));
          
          EndLoc.$assignMove(getPreciseTokenLocEnd(getIncludeOrExpansionLoc(new SourceLocation(EndLoc))));
          if (EndLoc.isInvalid()) {
            llvm.report_fatal_error($("File exit not handled before popRegions"));
          }
        }
        Region.setEndLoc(new SourceLocation(EndLoc));
        
        MostRecentLocation.$assign(EndLoc);
        // If this region happens to span an entire expansion, we need to make
        // sure we don't overlap the parent region with it.
        if ($eq_SourceLocation$C(StartLoc, getStartOfFileOrMacro(new SourceLocation(StartLoc)))
           && $eq_SourceLocation$C(EndLoc, getEndOfFileOrMacro(new SourceLocation(EndLoc)))) {
          MostRecentLocation.$assignMove(getIncludeOrExpansionLoc(new SourceLocation(EndLoc)));
        }
        assert (SM.isWrittenInSameFile(Region.getStartLoc(), /*NO_COPY*/EndLoc));
        SourceRegions.push_back_T$C$R(Region);
      }
      RegionStack.pop_back();
    }
  }

  
  /// \brief Return the currently active region.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::getRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 457,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::getRegion", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder9getRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder9getRegionEv")
  //</editor-fold>
  public SourceMappingRegion /*&*/ getRegion() {
    assert (!RegionStack.empty()) : "statement has no region";
    return RegionStack.back();
  }

  
  /// \brief Propagate counts through the children of \c S.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::propagateCounts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 463,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::propagateCounts", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder15propagateCountsEN4llvm8coverage7CounterEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder15propagateCountsEN4llvm8coverage7CounterEPKN5clang4StmtE")
  //</editor-fold>
  public Counter propagateCounts(Counter TopCount, /*const*/ Stmt /*P*/ S) {
    /*size_t*/int Index = pushRegion(new Counter(TopCount), new Optional<SourceLocation>(JD$T$RR.INSTANCE, getStart(S)), new Optional<SourceLocation>(JD$T$RR.INSTANCE, getEnd(S)));
    Visit(S);
    Counter ExitCount = new Counter(getRegion().getCounter());
    popRegions(Index);
    
    // The statement may be spanned by an expansion. Make sure we handle a file
    // exit out of this expansion before moving to the next statement.
    if (SM.isBeforeInTranslationUnit(getStart(S), S.getLocStart())) {
      MostRecentLocation.$assignMove(getEnd(S));
    }
    
    return ExitCount;
  }

  
  /// \brief Check whether a region with bounds \c StartLoc and \c EndLoc
  /// is already added to \c SourceRegions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::isRegionAlreadyAdded">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 479,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::isRegionAlreadyAdded", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder20isRegionAlreadyAddedEN5clang14SourceLocationES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder20isRegionAlreadyAddedEN5clang14SourceLocationES2_")
  //</editor-fold>
  public boolean isRegionAlreadyAdded(SourceLocation StartLoc, SourceLocation EndLoc) {
    return $noteq_reverse_iterator$C(SourceRegions.rend(), 
        std.find_if(SourceRegions.rbegin(), SourceRegions.rend(), 
            /*[&, &StartLoc, &EndLoc]*/ (final /*const*/ SourceMappingRegion /*&*/ Region) -> {
                  return $eq_SourceLocation$C(Region.getStartLoc(), StartLoc)
                     && $eq_SourceLocation$C(Region.getEndLoc(), EndLoc);
                }));
  }

  
  /// \brief Adjust the most recently visited location to \c EndLoc.
  ///
  /// This should be used after visiting any statements in non-source order.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::adjustForOutOfOrderTraversal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 491,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::adjustForOutOfOrderTraversal", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder28adjustForOutOfOrderTraversalEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder28adjustForOutOfOrderTraversalEN5clang14SourceLocationE")
  //</editor-fold>
  public void adjustForOutOfOrderTraversal(SourceLocation EndLoc) {
    MostRecentLocation.$assign(EndLoc);
    // The code region for a whole macro is created in handleFileExit() when
    // it detects exiting of the virtual file of that macro. If we visited
    // statements in non-source order, we might already have such a region
    // added, for example, if a body of a loop is divided among multiple
    // macros. Avoid adding duplicate regions in such case.
    if (getRegion().hasEndLoc()
       && $eq_SourceLocation$C(MostRecentLocation, getEndOfFileOrMacro(new SourceLocation(MostRecentLocation)))
       && isRegionAlreadyAdded(getStartOfFileOrMacro(new SourceLocation(MostRecentLocation)), 
        new SourceLocation(MostRecentLocation))) {
      MostRecentLocation.$assignMove(getIncludeOrExpansionLoc(new SourceLocation(MostRecentLocation)));
    }
  }

  
  /// \brief Adjust regions and state when \c NewLoc exits a file.
  ///
  /// If moving from our most recently tracked location to \c NewLoc exits any
  /// files, this adjusts our current region stack and creates the file regions
  /// for the exited file.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::handleFileExit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 510,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::handleFileExit", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder14handleFileExitEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder14handleFileExitEN5clang14SourceLocationE")
  //</editor-fold>
  public void handleFileExit(SourceLocation NewLoc) {
    SmallSet<SourceLocation> StartLocs = null;
    try {
      if (NewLoc.isInvalid()
         || SM.isWrittenInSameFile(/*NO_COPY*/MostRecentLocation, /*NO_COPY*/NewLoc)) {
        return;
      }
      
      // If NewLoc is not in a file that contains MostRecentLocation, walk up to
      // find the common ancestor.
      SourceLocation LCA = new SourceLocation(NewLoc);
      FileID ParentFile = SM.getFileID(/*NO_COPY*/LCA);
      while (!isNestedIn(new SourceLocation(MostRecentLocation), new FileID(ParentFile))) {
        LCA.$assignMove(getIncludeOrExpansionLoc(new SourceLocation(LCA)));
        if (LCA.isInvalid() || SM.isWrittenInSameFile(/*NO_COPY*/LCA, /*NO_COPY*/MostRecentLocation)) {
          // Since there isn't a common ancestor, no file was exited. We just need
          // to adjust our location to the new file.
          MostRecentLocation.$assign(NewLoc);
          return;
        }
        ParentFile.$assignMove(SM.getFileID(/*NO_COPY*/LCA));
      }
      
      StartLocs/*J*/= new SmallSet<SourceLocation>(8, SourceLocation.DEFAULT, SourceLocation.COMPARATOR);
      Optional<Counter> ParentCounter/*J*/= new Optional<Counter>();
      for (final SourceMappingRegion /*&*/ I : llvm.reverse$NotHasRBegin(RegionStack)) {
        if (!I.hasStartLoc()) {
          continue;
        }
        SourceLocation Loc = I.getStartLoc();
        if (!isNestedIn(new SourceLocation(Loc), new FileID(ParentFile))) {
          ParentCounter.$assign_T$C$R(I.getCounter());
          break;
        }
        while (!SM.isInFileID(/*NO_COPY*/Loc, /*NO_COPY*/ParentFile)) {
          // The most nested region for each start location is the one with the
          // correct count. We avoid creating redundant regions by stopping once
          // we've seen this region.
          if (StartLocs.insert(Loc)/*.second*/) {
            SourceRegions.emplace_back(new SourceMappingRegion(I.getCounter(), Loc, 
                getEndOfFileOrMacro(new SourceLocation(Loc))));
          }
          Loc.$assignMove(getIncludeOrExpansionLoc(new SourceLocation(Loc)));
        }
        I.setStartLoc(getPreciseTokenLocEnd(new SourceLocation(Loc)));
      }
      if (ParentCounter.$bool()) {
        // If the file is contained completely by another region and doesn't
        // immediately start its own region, the whole file gets a region
        // corresponding to the parent.
        SourceLocation Loc = new SourceLocation(MostRecentLocation);
        while (isNestedIn(new SourceLocation(Loc), new FileID(ParentFile))) {
          SourceLocation FileStart = getStartOfFileOrMacro(new SourceLocation(Loc));
          if (StartLocs.insert(FileStart)/*.second*/) {
            SourceRegions.emplace_back(new SourceMappingRegion(ParentCounter.$star(), FileStart, 
                getEndOfFileOrMacro(new SourceLocation(Loc))));
          }
          Loc.$assignMove(getIncludeOrExpansionLoc(new SourceLocation(Loc)));
        }
      }
      
      MostRecentLocation.$assign(NewLoc);
    } finally {
      if (StartLocs != null) { StartLocs.$destroy(); }
    }
  }

  
  /// \brief Ensure that \c S is included in the current region.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::extendRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 571,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::extendRegion", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder12extendRegionEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder12extendRegionEPKN5clang4StmtE")
  //</editor-fold>
  public void extendRegion(/*const*/ Stmt /*P*/ S) {
    final SourceMappingRegion /*&*/ Region = getRegion();
    SourceLocation StartLoc = getStart(S);
    
    handleFileExit(new SourceLocation(StartLoc));
    if (!Region.hasStartLoc()) {
      Region.setStartLoc(new SourceLocation(StartLoc));
    }
  }

  
  /// \brief Mark \c S as a terminator, starting a zero region.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::terminateRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 581,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::terminateRegion", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder15terminateRegionEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder15terminateRegionEPKN5clang4StmtE")
  //</editor-fold>
  public void terminateRegion(/*const*/ Stmt /*P*/ S) {
    extendRegion(S);
    final SourceMappingRegion /*&*/ Region = getRegion();
    if (!Region.hasEndLoc()) {
      Region.setEndLoc(getEnd(S));
    }
    pushRegion(Counter.getZero());
  }

  
  /// \brief Keep counts of breaks and continues inside loops.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::BreakContinue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 590,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::BreakContinue", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder13BreakContinueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder13BreakContinueE")
  //</editor-fold>
  public static class/*struct*/ BreakContinue {
    public Counter BreakCount;
    public Counter ContinueCount;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::BreakContinue::BreakContinue">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 590,
     FQN="(anonymous namespace)::CounterCoverageMappingBuilder::BreakContinue::BreakContinue", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder13BreakContinueC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder13BreakContinueC1Ev")
    //</editor-fold>
    public /*inline*/ BreakContinue() {
      // : BreakCount(), ContinueCount() 
      //START JInit
      this.BreakCount = new Counter();
      this.ContinueCount = new Counter();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::BreakContinue::BreakContinue">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 590,
     FQN="(anonymous namespace)::CounterCoverageMappingBuilder::BreakContinue::BreakContinue", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder13BreakContinueC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder13BreakContinueC1EOS1_")
    //</editor-fold>
    public /*inline*/ BreakContinue(JD$Move _dparam, final BreakContinue /*&&*/$Prm0) {
      // : BreakCount(static_cast<BreakContinue &&>().BreakCount), ContinueCount(static_cast<BreakContinue &&>().ContinueCount) 
      //START JInit
      this.BreakCount = new Counter(JD$Move.INSTANCE, $Prm0.BreakCount);
      this.ContinueCount = new Counter(JD$Move.INSTANCE, $Prm0.ContinueCount);
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "BreakCount=" + BreakCount // NOI18N
                + ", ContinueCount=" + ContinueCount; // NOI18N
    }
  };
  public SmallVector<BreakContinue> BreakContinueStack;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::CounterCoverageMappingBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 596,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::CounterCoverageMappingBuilder", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilderC1ERN5clang7CodeGen24CoverageMappingModuleGenERN4llvm8DenseMapIPKNS1_4StmtEjNS5_12DenseMapInfoIS9_EENS5_6detail12DenseMapPairIS9_jEEEERNS1_13SourceManagerERKNS1_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilderC1ERN5clang7CodeGen24CoverageMappingModuleGenERN4llvm8DenseMapIPKNS1_4StmtEjNS5_12DenseMapInfoIS9_EENS5_6detail12DenseMapPairIS9_jEEEERNS1_13SourceManagerERKNS1_11LangOptionsE")
  //</editor-fold>
  public CounterCoverageMappingBuilder(final CoverageMappingModuleGen /*&*/ CVM, 
      final DenseMapTypeUInt</*const*/ Stmt /*P*/ > /*&*/ CounterMap, final SourceManager /*&*/ SM, 
      final /*const*/ LangOptions /*&*/ LangOpts) {
    // : CoverageMappingBuilder(CVM, SM, LangOpts), ConstStmtVisitor<CounterCoverageMappingBuilder>(), CounterMap(CounterMap), RegionStack(), Builder(), MostRecentLocation(), BreakContinueStack() 
    //START JInit
    super(CVM, SM, LangOpts);
    $ConstStmtVisitor();
    this./*&*/CounterMap=/*&*/CounterMap;
    this.RegionStack = new std.vector<SourceMappingRegion>(new SourceMappingRegion());
    this.Builder = new CounterExpressionBuilder();
    this.MostRecentLocation = new SourceLocation();
    this.BreakContinueStack = new SmallVector<BreakContinue>(8, new BreakContinue());
    //END JInit
  }

  
  /// \brief Write the mapping data to the output stream
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::write">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 603,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::write", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder5writeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder5writeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void write(final raw_ostream /*&*/ OS) {
    SmallVectorUInt VirtualFileMapping/*J*/= new SmallVectorUInt(8, 0);
    gatherFileIDs(VirtualFileMapping);
    emitSourceRegions();
    emitExpansionRegions();
    gatherSkippedRegions();
    if (MappingRegions.empty()) {
      return;
    }
    
    CoverageMappingWriter Writer/*J*/= new CoverageMappingWriter(new ArrayRefUInt(VirtualFileMapping), Builder.getExpressions(), 
        new MutableArrayRef<CounterMappingRegion>(MappingRegions, false));
    Writer.write(OS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 618,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitStmt", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder9VisitStmtEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder9VisitStmtEPKN5clang4StmtE")
  //</editor-fold>
  public void VisitStmt(/*const*/ Stmt /*P*/ S) {
    if (S.getLocStart().isValid()) {
      extendRegion(S);
    }
    for (/*const*/ Stmt /*P*/ Child : S.children$Const())  {
      if ((Child != null)) {
        /*J:ToBase*/ConstStmtVisitorVoid /*P*/ .super.Visit(Child);
      }
    }
    handleFileExit(getEnd(S));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 627,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitDecl", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder9VisitDeclEPKN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder9VisitDeclEPKN5clang4DeclE")
  //</editor-fold>
  public void VisitDecl(/*const*/ Decl /*P*/ D) {
    Stmt /*P*/ Body = D.getBody();
    
    // Do not propagate region counts into system headers.
    if ((Body != null) && SM.isInSystemHeader(SM.getSpellingLoc(getStart(Body)))) {
      return;
    }
    
    propagateCounts(getRegionCounter(Body), Body);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitReturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 637,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitReturnStmt", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder15VisitReturnStmtEPKN5clang10ReturnStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder15VisitReturnStmtEPKN5clang10ReturnStmtE")
  //</editor-fold>
  public void VisitReturnStmt(/*const*/ ReturnStmt /*P*/ S) {
    extendRegion(S);
    if ((S.getRetValue$Const() != null)) {
      Visit(S.getRetValue$Const());
    }
    terminateRegion(S);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitCXXThrowExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 644,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitCXXThrowExpr", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder17VisitCXXThrowExprEPKN5clang12CXXThrowExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder17VisitCXXThrowExprEPKN5clang12CXXThrowExprE")
  //</editor-fold>
  public void VisitCXXThrowExpr(/*const*/ CXXThrowExpr /*P*/ E) {
    extendRegion(E);
    if ((E.getSubExpr$Const() != null)) {
      Visit(E.getSubExpr$Const());
    }
    terminateRegion(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 651,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitGotoStmt", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder13VisitGotoStmtEPKN5clang8GotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder13VisitGotoStmtEPKN5clang8GotoStmtE")
  //</editor-fold>
  public void VisitGotoStmt(/*const*/ GotoStmt /*P*/ S) {
    terminateRegion(S);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitLabelStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 653,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitLabelStmt", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder14VisitLabelStmtEPKN5clang9LabelStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder14VisitLabelStmtEPKN5clang9LabelStmtE")
  //</editor-fold>
  public void VisitLabelStmt(/*const*/ LabelStmt /*P*/ S) {
    SourceLocation Start = getStart(S);
    // We can't extendRegion here or we risk overlapping with our new region.
    handleFileExit(new SourceLocation(Start));
    pushRegion(getRegionCounter(S), new Optional<SourceLocation>(JD$T$C$R.INSTANCE, Start));
    Visit(S.getSubStmt$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitBreakStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 661,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitBreakStmt", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder14VisitBreakStmtEPKN5clang9BreakStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder14VisitBreakStmtEPKN5clang9BreakStmtE")
  //</editor-fold>
  public void VisitBreakStmt(/*const*/ BreakStmt /*P*/ S) {
    assert (!BreakContinueStack.empty()) : "break not in a loop or switch!";
    BreakContinueStack.back().BreakCount.$assignMove(addCounters(new Counter(BreakContinueStack.back().BreakCount), new Counter(getRegion().getCounter())));
    terminateRegion(S);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitContinueStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 668,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitContinueStmt", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder17VisitContinueStmtEPKN5clang12ContinueStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder17VisitContinueStmtEPKN5clang12ContinueStmtE")
  //</editor-fold>
  public void VisitContinueStmt(/*const*/ ContinueStmt /*P*/ S) {
    assert (!BreakContinueStack.empty()) : "continue stmt not in a loop!";
    BreakContinueStack.back().ContinueCount.$assignMove(addCounters(new Counter(BreakContinueStack.back().ContinueCount), new Counter(getRegion().getCounter())));
    terminateRegion(S);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitWhileStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 675,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitWhileStmt", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder14VisitWhileStmtEPKN5clang9WhileStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder14VisitWhileStmtEPKN5clang9WhileStmtE")
  //</editor-fold>
  public void VisitWhileStmt(/*const*/ WhileStmt /*P*/ S) {
    extendRegion(S);
    
    Counter ParentCount = new Counter(getRegion().getCounter());
    Counter BodyCount = getRegionCounter(S);
    
    // Handle the body first so that we can get the backedge count.
    BreakContinueStack.push_back(new BreakContinue());
    extendRegion(S.getBody$Const());
    Counter BackedgeCount = propagateCounts(new Counter(BodyCount), S.getBody$Const());
    BreakContinue BC = BreakContinueStack.pop_back_val();
    
    // Go back to handle the condition.
    Counter CondCount = addCounters(new Counter(ParentCount), new Counter(BackedgeCount), new Counter(BC.ContinueCount));
    propagateCounts(new Counter(CondCount), S.getCond$Const());
    adjustForOutOfOrderTraversal(getEnd(S));
    
    Counter OutCount = addCounters(new Counter(BC.BreakCount), subtractCounters(new Counter(CondCount), new Counter(BodyCount)));
    if (Counter.$noteq_Counter$C(OutCount, ParentCount)) {
      pushRegion(new Counter(OutCount));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitDoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 699,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitDoStmt", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder11VisitDoStmtEPKN5clang6DoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder11VisitDoStmtEPKN5clang6DoStmtE")
  //</editor-fold>
  public void VisitDoStmt(/*const*/ DoStmt /*P*/ S) {
    extendRegion(S);
    
    Counter ParentCount = new Counter(getRegion().getCounter());
    Counter BodyCount = getRegionCounter(S);
    
    BreakContinueStack.push_back(new BreakContinue());
    extendRegion(S.getBody$Const());
    Counter BackedgeCount = propagateCounts(addCounters(new Counter(ParentCount), new Counter(BodyCount)), S.getBody$Const());
    BreakContinue BC = BreakContinueStack.pop_back_val();
    
    Counter CondCount = addCounters(new Counter(BackedgeCount), new Counter(BC.ContinueCount));
    propagateCounts(new Counter(CondCount), S.getCond$Const());
    
    Counter OutCount = addCounters(new Counter(BC.BreakCount), subtractCounters(new Counter(CondCount), new Counter(BodyCount)));
    if (Counter.$noteq_Counter$C(OutCount, ParentCount)) {
      pushRegion(new Counter(OutCount));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitForStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 720,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitForStmt", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder12VisitForStmtEPKN5clang7ForStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder12VisitForStmtEPKN5clang7ForStmtE")
  //</editor-fold>
  public void VisitForStmt(/*const*/ ForStmt /*P*/ S) {
    extendRegion(S);
    if ((S.getInit$Const() != null)) {
      Visit(S.getInit$Const());
    }
    
    Counter ParentCount = new Counter(getRegion().getCounter());
    Counter BodyCount = getRegionCounter(S);
    
    // Handle the body first so that we can get the backedge count.
    BreakContinueStack.push_back(new BreakContinue());
    extendRegion(S.getBody$Const());
    Counter BackedgeCount = propagateCounts(new Counter(BodyCount), S.getBody$Const());
    BreakContinue BC = BreakContinueStack.pop_back_val();
    {
      
      // The increment is essentially part of the body but it needs to include
      // the count for all the continue statements.
      /*const*/ Stmt /*P*/ Inc = S.getInc$Const();
      if ((Inc != null)) {
        propagateCounts(addCounters(new Counter(BackedgeCount), new Counter(BC.ContinueCount)), Inc);
      }
    }
    
    // Go back to handle the condition.
    Counter CondCount = addCounters(new Counter(ParentCount), new Counter(BackedgeCount), new Counter(BC.ContinueCount));
    {
      /*const*/ Expr /*P*/ Cond = S.getCond$Const();
      if ((Cond != null)) {
        propagateCounts(new Counter(CondCount), Cond);
        adjustForOutOfOrderTraversal(getEnd(S));
      }
    }
    
    Counter OutCount = addCounters(new Counter(BC.BreakCount), subtractCounters(new Counter(CondCount), new Counter(BodyCount)));
    if (Counter.$noteq_Counter$C(OutCount, ParentCount)) {
      pushRegion(new Counter(OutCount));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitCXXForRangeStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 753,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitCXXForRangeStmt", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder20VisitCXXForRangeStmtEPKN5clang15CXXForRangeStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder20VisitCXXForRangeStmtEPKN5clang15CXXForRangeStmtE")
  //</editor-fold>
  public void VisitCXXForRangeStmt(/*const*/ CXXForRangeStmt /*P*/ S) {
    extendRegion(S);
    Visit(S.getLoopVarStmt$Const());
    Visit(S.getRangeStmt$Const());
    
    Counter ParentCount = new Counter(getRegion().getCounter());
    Counter BodyCount = getRegionCounter(S);
    
    BreakContinueStack.push_back(new BreakContinue());
    extendRegion(S.getBody$Const());
    Counter BackedgeCount = propagateCounts(new Counter(BodyCount), S.getBody$Const());
    BreakContinue BC = BreakContinueStack.pop_back_val();
    
    Counter LoopCount = addCounters(new Counter(ParentCount), new Counter(BackedgeCount), new Counter(BC.ContinueCount));
    Counter OutCount = addCounters(new Counter(BC.BreakCount), subtractCounters(new Counter(LoopCount), new Counter(BodyCount)));
    if (Counter.$noteq_Counter$C(OutCount, ParentCount)) {
      pushRegion(new Counter(OutCount));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitObjCForCollectionStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 774,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitObjCForCollectionStmt", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder26VisitObjCForCollectionStmtEPKN5clang21ObjCForCollectionStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder26VisitObjCForCollectionStmtEPKN5clang21ObjCForCollectionStmtE")
  //</editor-fold>
  public void VisitObjCForCollectionStmt(/*const*/ ObjCForCollectionStmt /*P*/ S) {
    extendRegion(S);
    Visit(S.getElement$Const());
    
    Counter ParentCount = new Counter(getRegion().getCounter());
    Counter BodyCount = getRegionCounter(S);
    
    BreakContinueStack.push_back(new BreakContinue());
    extendRegion(S.getBody$Const());
    Counter BackedgeCount = propagateCounts(new Counter(BodyCount), S.getBody$Const());
    BreakContinue BC = BreakContinueStack.pop_back_val();
    
    Counter LoopCount = addCounters(new Counter(ParentCount), new Counter(BackedgeCount), new Counter(BC.ContinueCount));
    Counter OutCount = addCounters(new Counter(BC.BreakCount), subtractCounters(new Counter(LoopCount), new Counter(BodyCount)));
    if (Counter.$noteq_Counter$C(OutCount, ParentCount)) {
      pushRegion(new Counter(OutCount));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitSwitchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 794,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitSwitchStmt", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder15VisitSwitchStmtEPKN5clang10SwitchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder15VisitSwitchStmtEPKN5clang10SwitchStmtE")
  //</editor-fold>
  public void VisitSwitchStmt(/*const*/ SwitchStmt /*P*/ S) {
    extendRegion(S);
    Visit(S.getCond$Const());
    
    BreakContinueStack.push_back(new BreakContinue());
    
    /*const*/ Stmt /*P*/ Body = S.getBody$Const();
    extendRegion(Body);
    {
      /*const*/ CompoundStmt /*P*/ CS = dyn_cast_CompoundStmt(Body);
      if ((CS != null)) {
        if (!CS.body_empty()) {
          // The body of the switch needs a zero region so that fallthrough counts
          // behave correctly, but it would be misleading to include the braces of
          // the compound statement in the zeroed area, so we need to handle this
          // specially.
          /*size_t*/int Index = pushRegion(Counter.getZero(), new Optional<SourceLocation>(JD$T$RR.INSTANCE, getStart(CS.body_front$Const())), 
              new Optional<SourceLocation>(JD$T$RR.INSTANCE, getEnd(CS.body_back$Const())));
          for (/*const*/ Stmt /*P*/ Child : CS.children$Const())  {
            Visit(Child);
          }
          popRegions(Index);
        }
      } else {
        propagateCounts(Counter.getZero(), Body);
      }
    }
    BreakContinue BC = BreakContinueStack.pop_back_val();
    if (!BreakContinueStack.empty()) {
      BreakContinueStack.back().ContinueCount.$assignMove(addCounters(new Counter(BreakContinueStack.back().ContinueCount), new Counter(BC.ContinueCount)));
    }
    
    Counter ExitCount = getRegionCounter(S);
    SourceLocation ExitLoc = getEnd(S);
    pushRegion(new Counter(ExitCount), new Optional<SourceLocation>(JD$T$RR.INSTANCE, getStart(S)), new Optional<SourceLocation>(JD$T$C$R.INSTANCE, ExitLoc));
    handleFileExit(new SourceLocation(ExitLoc));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitSwitchCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 829,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitSwitchCase", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder15VisitSwitchCaseEPKN5clang10SwitchCaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder15VisitSwitchCaseEPKN5clang10SwitchCaseE")
  //</editor-fold>
  public void VisitSwitchCase(/*const*/ SwitchCase /*P*/ S) {
    extendRegion(S);
    
    final SourceMappingRegion /*&*/ Parent = getRegion();
    
    Counter Count = addCounters(new Counter(Parent.getCounter()), getRegionCounter(S));
    // Reuse the existing region if it starts at our label. This is typical of
    // the first case in a switch.
    if (Parent.hasStartLoc() && $eq_SourceLocation$C(Parent.getStartLoc(), getStart(S))) {
      Parent.setCounter(new Counter(Count));
    } else {
      pushRegion(new Counter(Count), new Optional<SourceLocation>(JD$T$RR.INSTANCE, getStart(S)));
    }
    {
      
      /*const*/ CaseStmt /*P*/ CS = dyn_cast_CaseStmt(S);
      if ((CS != null)) {
        Visit(CS.getLHS$Const());
        {
          /*const*/ Expr /*P*/ RHS = CS.getRHS$Const();
          if ((RHS != null)) {
            Visit(RHS);
          }
        }
      }
    }
    Visit(S.getSubStmt$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitIfStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 850,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitIfStmt", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder11VisitIfStmtEPKN5clang6IfStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder11VisitIfStmtEPKN5clang6IfStmtE")
  //</editor-fold>
  public void VisitIfStmt(/*const*/ IfStmt /*P*/ S) {
    extendRegion(S);
    // Extend into the condition before we propagate through it below - this is
    // needed to handle macros that generate the "if" but not the condition.
    extendRegion(S.getCond$Const());
    
    Counter ParentCount = new Counter(getRegion().getCounter());
    Counter ThenCount = getRegionCounter(S);
    
    // Emitting a counter for the condition makes it easier to interpret the
    // counter for the body when looking at the coverage.
    propagateCounts(new Counter(ParentCount), S.getCond$Const());
    
    extendRegion(S.getThen$Const());
    Counter OutCount = propagateCounts(new Counter(ThenCount), S.getThen$Const());
    
    Counter ElseCount = subtractCounters(new Counter(ParentCount), new Counter(ThenCount));
    {
      /*const*/ Stmt /*P*/ Else = S.getElse$Const();
      if ((Else != null)) {
        extendRegion(S.getElse$Const());
        OutCount.$assignMove(addCounters(new Counter(OutCount), propagateCounts(new Counter(ElseCount), Else)));
      } else {
        OutCount.$assignMove(addCounters(new Counter(OutCount), new Counter(ElseCount)));
      }
    }
    if (Counter.$noteq_Counter$C(OutCount, ParentCount)) {
      pushRegion(new Counter(OutCount));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitCXXTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 877,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitCXXTryStmt", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder15VisitCXXTryStmtEPKN5clang10CXXTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder15VisitCXXTryStmtEPKN5clang10CXXTryStmtE")
  //</editor-fold>
  public void VisitCXXTryStmt(/*const*/ CXXTryStmt /*P*/ S) {
    extendRegion(S);
    // Handle macros that generate the "try" but not the rest.
    extendRegion(S.getTryBlock$Const());
    
    Counter ParentCount = new Counter(getRegion().getCounter());
    propagateCounts(new Counter(ParentCount), S.getTryBlock$Const());
    
    for (/*uint*/int I = 0, E = S.getNumHandlers(); $less_uint(I, E); ++I)  {
      Visit(S.getHandler$Const(I));
    }
    
    Counter ExitCount = getRegionCounter(S);
    pushRegion(new Counter(ExitCount));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitCXXCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 892,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitCXXCatchStmt", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder17VisitCXXCatchStmtEPKN5clang12CXXCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder17VisitCXXCatchStmtEPKN5clang12CXXCatchStmtE")
  //</editor-fold>
  public void VisitCXXCatchStmt(/*const*/ CXXCatchStmt /*P*/ S) {
    propagateCounts(getRegionCounter(S), S.getHandlerBlock());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitAbstractConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 896,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitAbstractConditionalOperator", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder32VisitAbstractConditionalOperatorEPKN5clang27AbstractConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder32VisitAbstractConditionalOperatorEPKN5clang27AbstractConditionalOperatorE")
  //</editor-fold>
  public void VisitAbstractConditionalOperator(/*const*/ AbstractConditionalOperator /*P*/ E) {
    extendRegion(E);
    
    Counter ParentCount = new Counter(getRegion().getCounter());
    Counter TrueCount = getRegionCounter(E);
    
    Visit(E.getCond());
    if (!isa_BinaryConditionalOperator(E)) {
      extendRegion(E.getTrueExpr());
      propagateCounts(new Counter(TrueCount), E.getTrueExpr());
    }
    extendRegion(E.getFalseExpr());
    propagateCounts(subtractCounters(new Counter(ParentCount), new Counter(TrueCount)), 
        E.getFalseExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitBinLAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 913,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitBinLAnd", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder12VisitBinLAndEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder12VisitBinLAndEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinLAnd(/*const*/ org.clang.ast.BinaryOperator /*P*/ E) {
    extendRegion(E);
    Visit(E.getLHS());
    
    extendRegion(E.getRHS());
    propagateCounts(getRegionCounter(E), E.getRHS());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitBinLOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 921,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitBinLOr", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder11VisitBinLOrEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder11VisitBinLOrEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinLOr(/*const*/ org.clang.ast.BinaryOperator /*P*/ E) {
    extendRegion(E);
    Visit(E.getLHS());
    
    extendRegion(E.getRHS());
    propagateCounts(getRegionCounter(E), E.getRHS());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::VisitLambdaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 929,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::VisitLambdaExpr", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder15VisitLambdaExprEPKN5clang10LambdaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilder15VisitLambdaExprEPKN5clang10LambdaExprE")
  //</editor-fold>
  public void VisitLambdaExpr(/*const*/ LambdaExpr /*P*/ LE) {
    // Lambdas are treated as their own functions for now, so we shouldn't
    // propagate counts into them.
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CounterCoverageMappingBuilder::~CounterCoverageMappingBuilder">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 364,
   FQN="(anonymous namespace)::CounterCoverageMappingBuilder::~CounterCoverageMappingBuilder", NM="_ZN12_GLOBAL__N_129CounterCoverageMappingBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_129CounterCoverageMappingBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    BreakContinueStack.$destroy();
    Builder.$destroy();
    RegionStack.$destroy();
    super.$destroy();
    ConstStmtVisitorVoid.super.$destroy$ConstStmtVisitor();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "CounterMap=" + "[DenseMapTypeUInt$Stmt]" // NOI18N
              + ", RegionStack=" + RegionStack // NOI18N
              + ", Builder=" + "[CounterExpressionBuilder]" // NOI18N
              + ", MostRecentLocation=" + MostRecentLocation // NOI18N
              + ", BreakContinueStack=" + BreakContinueStack // NOI18N
              + super.toString(); // NOI18N
  }
}
