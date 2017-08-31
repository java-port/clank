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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clank.support.Native.ComparatorLower;


/// \brief Records preprocessor conditional directive regions and allows
/// querying in which region source locations belong to.
//<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPConditionalDirectiveRecord.h", line = 26,
 FQN = "clang::PPConditionalDirectiveRecord", NM = "_ZN5clang28PPConditionalDirectiveRecordE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecordE")
//</editor-fold>
public class PPConditionalDirectiveRecord extends /*public*/ PPCallbacks implements Destructors.ClassWithDestructor {
  private SourceManager /*&*/ SourceMgr;
  private SmallVector<SourceLocation> CondDirectiveStack;
  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::CondDirectiveLoc">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPConditionalDirectiveRecord.h", line = 31,
   FQN = "clang::PPConditionalDirectiveRecord::CondDirectiveLoc", NM = "_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLocE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLocE")
  //</editor-fold>
  private static class CondDirectiveLoc {
    private SourceLocation Loc;
    private SourceLocation RegionLoc;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::CondDirectiveLoc::CondDirectiveLoc">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPConditionalDirectiveRecord.h", line = 36,
     FQN = "clang::PPConditionalDirectiveRecord::CondDirectiveLoc::CondDirectiveLoc", NM = "_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLocC1ENS_14SourceLocationES2_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLocC1ENS_14SourceLocationES2_")
    //</editor-fold>
    public CondDirectiveLoc(SourceLocation Loc, SourceLocation RegionLoc) {
      /* : Loc(Loc), RegionLoc(RegionLoc)*/ 
      //START JInit
      this.Loc = new SourceLocation(Loc);
      this.RegionLoc = new SourceLocation(RegionLoc);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::CondDirectiveLoc::getLoc">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPConditionalDirectiveRecord.h", line = 39,
     FQN = "clang::PPConditionalDirectiveRecord::CondDirectiveLoc::getLoc", NM = "_ZNK5clang28PPConditionalDirectiveRecord16CondDirectiveLoc6getLocEv",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZNK5clang28PPConditionalDirectiveRecord16CondDirectiveLoc6getLocEv")
    //</editor-fold>
    public SourceLocation getLoc() /*const*/ {
      return Loc;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::CondDirectiveLoc::getRegionLoc">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPConditionalDirectiveRecord.h", line = 40,
     FQN = "clang::PPConditionalDirectiveRecord::CondDirectiveLoc::getRegionLoc", NM = "_ZNK5clang28PPConditionalDirectiveRecord16CondDirectiveLoc12getRegionLocEv",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZNK5clang28PPConditionalDirectiveRecord16CondDirectiveLoc12getRegionLocEv")
    //</editor-fold>
    public SourceLocation getRegionLoc() /*const*/ {
      return RegionLoc;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::CondDirectiveLoc::Comp">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPConditionalDirectiveRecord.h", line = 42,
     FQN = "clang::PPConditionalDirectiveRecord::CondDirectiveLoc::Comp", NM = "_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLoc4CompE",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLoc4CompE")
    //</editor-fold>
    public static class Comp implements ComparatorLower {
      private SourceManager /*&*/ SM;
    /*public:*/
      //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::CondDirectiveLoc::Comp::Comp">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPConditionalDirectiveRecord.h", line = 45,
       FQN = "clang::PPConditionalDirectiveRecord::CondDirectiveLoc::Comp::Comp", NM = "_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLoc4CompC1ERNS_13SourceManagerE",
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLoc4CompC1ERNS_13SourceManagerE")
      //</editor-fold>
      public /*explicit*/ Comp(SourceManager /*&*/ SM) {
        /* : SM(SM)*/ 
        //START JInit
        this.SM = SM;
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::CondDirectiveLoc::Comp::operator()">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPConditionalDirectiveRecord.h", line = 46,
       FQN = "clang::PPConditionalDirectiveRecord::CondDirectiveLoc::Comp::operator()", NM = "_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLoc4CompclERKS1_S4_",
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLoc4CompclERKS1_S4_")
      //</editor-fold>
      public boolean $call(/*const*/CondDirectiveLoc /*&*/ LHS, /*const*/CondDirectiveLoc /*&*/ RHS) {
        return SM.isBeforeInTranslationUnit(LHS.getLoc(), RHS.getLoc());
      }

      //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::CondDirectiveLoc::Comp::operator()">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPConditionalDirectiveRecord.h", line = 50,
       FQN = "clang::PPConditionalDirectiveRecord::CondDirectiveLoc::Comp::operator()", NM = "_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLoc4CompclERKS1_NS_14SourceLocationE",
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLoc4CompclERKS1_NS_14SourceLocationE")
      //</editor-fold>
      public boolean $call(/*const*/CondDirectiveLoc /*&*/ LHS, SourceLocation RHS) {
        return SM.isBeforeInTranslationUnit(LHS.getLoc(), RHS);
      }

      //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::CondDirectiveLoc::Comp::operator()">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPConditionalDirectiveRecord.h", line = 53,
       FQN = "clang::PPConditionalDirectiveRecord::CondDirectiveLoc::Comp::operator()", NM = "_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLoc4CompclENS_14SourceLocationERKS1_",
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLoc4CompclENS_14SourceLocationERKS1_")
      //</editor-fold>
      public boolean $call(SourceLocation LHS, /*const*/CondDirectiveLoc /*&*/ RHS) {
        return SM.isBeforeInTranslationUnit(LHS, RHS.getLoc());
      }

      //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::CondDirectiveLoc::Comp::Comp">
      @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPConditionalDirectiveRecord.h", line = 42,
       FQN = "clang::PPConditionalDirectiveRecord::CondDirectiveLoc::Comp::Comp", NM = "_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLoc4CompC1ERKS2_",
       cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLoc4CompC1ERKS2_")
      //</editor-fold>
      public /*inline*/ Comp(/*const*/Comp /*&*/ $Prm0)/* throw()*/ {
        /* : SM(.SM)*/ 
        //START JInit
        this.SM = $Prm0.SM;
        //END JInit
      }
      
      //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::CondDirectiveLoc::Comp::Comp">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPConditionalDirectiveRecord.h", line = 42,
       FQN="clang::PPConditionalDirectiveRecord::CondDirectiveLoc::Comp::Comp", NM="_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLoc4CompC1EOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLoc4CompC1EOS2_")
      //</editor-fold>
      public /*inline*/ Comp(JD$Move _dparam, Comp /*&&*/$Prm0) {
        /* : SM(static_cast<Comp &&>().SM)*/ 
        //START JInit
        this./*&*/SM=/*&*/$Prm0.SM;
        //END JInit
      }

      @Override
      public boolean $less(Object LHS, Object RHS) {
        if (LHS instanceof CondDirectiveLoc) {
          CondDirectiveLoc cdl = (CondDirectiveLoc)LHS;
          if (RHS instanceof CondDirectiveLoc) {
            return $call((CondDirectiveLoc)LHS, (CondDirectiveLoc)RHS);
          }
          return $call((CondDirectiveLoc)LHS, (SourceLocation)RHS);
        } else {
          return $call((SourceLocation)LHS, (CondDirectiveLoc)RHS);
        }
      }

    };

    public CondDirectiveLoc() {
      /* For default value purposes */
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::CondDirectiveLoc::CondDirectiveLoc">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPConditionalDirectiveRecord.h", line = 31,
     FQN = "clang::PPConditionalDirectiveRecord::CondDirectiveLoc::CondDirectiveLoc", NM = "_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLocC1ERKS1_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLocC1ERKS1_")
    //</editor-fold>
    public /*inline*/ CondDirectiveLoc(/*const*/CondDirectiveLoc /*&*/ $Prm0)/* throw()*/ {
      /* : Loc(.Loc), RegionLoc(.RegionLoc)*/ 
      //START JInit
      this.Loc = new SourceLocation($Prm0.Loc);
      this.RegionLoc = new SourceLocation($Prm0.RegionLoc);
      //END JInit
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::CondDirectiveLoc::CondDirectiveLoc">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPConditionalDirectiveRecord.h", line = 31,
     FQN="clang::PPConditionalDirectiveRecord::CondDirectiveLoc::CondDirectiveLoc", NM="_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLocC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLocC1EOS1_")
    //</editor-fold>
    public /*inline*/ CondDirectiveLoc(JD$Move _dparam, CondDirectiveLoc /*&&*/$Prm0) {
      /* : Loc(static_cast<CondDirectiveLoc &&>().Loc), RegionLoc(static_cast<CondDirectiveLoc &&>().RegionLoc)*/ 
      //START JInit
      this.Loc = new SourceLocation(JD$Move.INSTANCE, $Prm0.Loc);
      this.RegionLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.RegionLoc);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::CondDirectiveLoc::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPConditionalDirectiveRecord.h", line = 31,
     FQN = "clang::PPConditionalDirectiveRecord::CondDirectiveLoc::operator=", NM = "_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLocaSERKS1_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord16CondDirectiveLocaSERKS1_")
    //</editor-fold>
    public /*inline*/ CondDirectiveLoc /*&*/ $assign(/*const*/CondDirectiveLoc /*&*/ $Prm0)/* throw()*/ {
      this.Loc.$assign($Prm0.Loc);
      this.RegionLoc.$assign($Prm0.RegionLoc);
      return /*Deref*/this;
    }

    @Override
    public String toString() {
      return "CondDirectiveLoc{" + "RegionLoc=" + RegionLoc + ", Loc=" + Loc + '}';
    }
  };
  /*typedef std::vector<CondDirectiveLoc> CondDirectiveLocsTy*/
  //public final class CondDirectiveLocsTy extends std.vector<CondDirectiveLoc>{ };
  /// \brief The locations of conditional directives in source order.
  private std.vector<CondDirectiveLoc> CondDirectiveLocs;
  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::addCondDirectiveLoc">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp", line = 66,
   FQN = "clang::PPConditionalDirectiveRecord::addCondDirectiveLoc", NM = "_ZN5clang28PPConditionalDirectiveRecord19addCondDirectiveLocENS0_16CondDirectiveLocE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord19addCondDirectiveLocENS0_16CondDirectiveLocE")
  //</editor-fold>
  private void addCondDirectiveLoc(CondDirectiveLoc DirLoc) {
    // Ignore directives in system headers.
    if (SourceMgr.isInSystemHeader(DirLoc.getLoc())) {
      return;
    }
    assert (CondDirectiveLocs.empty() || 
            SourceMgr.isBeforeInTranslationUnit(CondDirectiveLocs.back().getLoc(), DirLoc.getLoc()));
    CondDirectiveLocs.push_back(DirLoc);
  }

/*public:*/
  /// \brief Construct a new preprocessing record.
  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::PPConditionalDirectiveRecord">
  @Converted(kind = Converted.Kind.AUTO, 
   optimized = Converted.Optimization.VALUE_TYPE/*null def-val*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp", line = 19,
   FQN = "clang::PPConditionalDirectiveRecord::PPConditionalDirectiveRecord", NM = "_ZN5clang28PPConditionalDirectiveRecordC1ERNS_13SourceManagerE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecordC1ERNS_13SourceManagerE")
  //</editor-fold>
  public PPConditionalDirectiveRecord(SourceManager /*&*/ SM) {
    /* : PPCallbacks(), SourceMgr(SM), CondDirectiveStack(), CondDirectiveLocs()*/ 
    //START JInit
    super();
    this.SourceMgr = SM;
    this.CondDirectiveStack = new SmallVector<SourceLocation>(6, new SourceLocation());
    this.CondDirectiveLocs = new std.vector<CondDirectiveLoc>((CondDirectiveLoc)null/*PERF: new CondDirectiveLoc()*/);
    //END JInit
    CondDirectiveStack.push_back(new SourceLocation());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::getTotalMemory">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp", line = 120,
   FQN = "clang::PPConditionalDirectiveRecord::getTotalMemory", NM = "_ZNK5clang28PPConditionalDirectiveRecord14getTotalMemoryEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZNK5clang28PPConditionalDirectiveRecord14getTotalMemoryEv")
  //</editor-fold>
  public /*size_t*/int getTotalMemory() /*const*/ {
    return llvm.capacity_in_bytes(CondDirectiveLocs);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPConditionalDirectiveRecord.h", line = 71,
   FQN = "clang::PPConditionalDirectiveRecord::getSourceManager", NM = "_ZNK5clang28PPConditionalDirectiveRecord16getSourceManagerEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZNK5clang28PPConditionalDirectiveRecord16getSourceManagerEv")
  //</editor-fold>
  public SourceManager /*&*/ getSourceManager() /*const*/ {
    return SourceMgr;
  }

  
  /// \brief Returns true if the given range intersects with a conditional
  /// directive. if a \#if/\#endif block is fully contained within the range,
  /// this function will return false.
  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::rangeIntersectsConditionalDirective">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp", line = 24,
   FQN = "clang::PPConditionalDirectiveRecord::rangeIntersectsConditionalDirective", NM = "_ZNK5clang28PPConditionalDirectiveRecord35rangeIntersectsConditionalDirectiveENS_11SourceRangeE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZNK5clang28PPConditionalDirectiveRecord35rangeIntersectsConditionalDirectiveENS_11SourceRangeE")
  //</editor-fold>
  public boolean rangeIntersectsConditionalDirective(SourceRange Range) /*const*/ {
    if (Range.isInvalid()) {
      return false;
    }
    
    std.vector.iterator<CondDirectiveLoc> low = std.lower_bound(CondDirectiveLocs.begin(), CondDirectiveLocs.end(), Range.getBegin(), new CondDirectiveLoc.Comp(SourceMgr));
    if ($eq___normal_iterator(low, CondDirectiveLocs.end())) {
      return false;
    }
    if (SourceMgr.isBeforeInTranslationUnit(Range.getEnd(), low.$arrow().getLoc())) {
      return false;
    }
    
    std.vector.iterator<CondDirectiveLoc> upp = std.upper_bound(low, CondDirectiveLocs.end(), Range.getEnd(), new CondDirectiveLoc.Comp(SourceMgr));
    SourceLocation uppRegion/*J*/= new SourceLocation();
    if ($noteq___normal_iterator(upp, CondDirectiveLocs.end())) {
      uppRegion.$assign(upp.$arrow().getRegionLoc());
    }
    
    return $noteq_SourceLocation$C(low.$arrow().getRegionLoc(), uppRegion);
  }

  
  /// \brief Returns true if the given locations are in different regions,
  /// separated by conditional directive blocks.
  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::areInDifferentConditionalDirectiveRegion">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPConditionalDirectiveRecord.h", line = 80,
   FQN = "clang::PPConditionalDirectiveRecord::areInDifferentConditionalDirectiveRegion", NM = "_ZNK5clang28PPConditionalDirectiveRecord40areInDifferentConditionalDirectiveRegionENS_14SourceLocationES1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZNK5clang28PPConditionalDirectiveRecord40areInDifferentConditionalDirectiveRegionENS_14SourceLocationES1_")
  //</editor-fold>
  public boolean areInDifferentConditionalDirectiveRegion(SourceLocation LHS, SourceLocation RHS) /*const*/ {
    return $noteq_SourceLocation$C(findConditionalDirectiveRegionLoc(LHS), findConditionalDirectiveRegionLoc(RHS));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::findConditionalDirectiveRegionLoc">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp", line = 48,
   FQN = "clang::PPConditionalDirectiveRecord::findConditionalDirectiveRegionLoc", NM = "_ZNK5clang28PPConditionalDirectiveRecord33findConditionalDirectiveRegionLocENS_14SourceLocationE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZNK5clang28PPConditionalDirectiveRecord33findConditionalDirectiveRegionLocENS_14SourceLocationE")
  //</editor-fold>
  public SourceLocation findConditionalDirectiveRegionLoc(SourceLocation Loc) /*const*/ {
    if (Loc.isInvalid()) {
      return new SourceLocation();
    }
    if (CondDirectiveLocs.empty()) {
      return new SourceLocation();
    }
    if (SourceMgr.isBeforeInTranslationUnit(CondDirectiveLocs.back().getLoc(), Loc)) {
      return CondDirectiveStack.back();
    }
    
    std.vector.iterator<CondDirectiveLoc> low = std.lower_bound(CondDirectiveLocs.begin(), CondDirectiveLocs.end(), Loc, new CondDirectiveLoc.Comp(SourceMgr));
    assert ($noteq___normal_iterator(low, CondDirectiveLocs.end()));
    return low.$arrow().getRegionLoc();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::If">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp", line = 78,
   FQN = "clang::PPConditionalDirectiveRecord::If", NM = "_ZN5clang28PPConditionalDirectiveRecord2IfENS_14SourceLocationENS_11SourceRangeENS_11PPCallbacks18ConditionValueKindE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord2IfENS_14SourceLocationENS_11SourceRangeENS_11PPCallbacks18ConditionValueKindE")
  //</editor-fold>
  @Override public/*private*/ void If(SourceLocation HashLoc, SourceLocation EodLoc,
          SourceLocation Loc, SourceRange ConditionRange, ConditionValueKind ConditionValue) {
    addCondDirectiveLoc(new CondDirectiveLoc(Loc, CondDirectiveStack.back()));
    CondDirectiveStack.push_back(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::Elif">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp", line = 99,
   FQN = "clang::PPConditionalDirectiveRecord::Elif", NM = "_ZN5clang28PPConditionalDirectiveRecord4ElifENS_14SourceLocationENS_11SourceRangeENS_11PPCallbacks18ConditionValueKindES1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord4ElifENS_14SourceLocationENS_11SourceRangeENS_11PPCallbacks18ConditionValueKindES1_")
  //</editor-fold>
  @Override public/*private*/ void Elif(SourceLocation HashLoc, SourceLocation EodLoc,
          SourceLocation Loc, SourceRange ConditionRange, ConditionValueKind ConditionValue, SourceLocation IfLoc) {
    addCondDirectiveLoc(new CondDirectiveLoc(Loc, CondDirectiveStack.back()));
    CondDirectiveStack.back().$assign(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::Ifdef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp", line = 85,
   FQN="clang::PPConditionalDirectiveRecord::Ifdef", NM="_ZN5clang28PPConditionalDirectiveRecord5IfdefENS_14SourceLocationERKNS_5TokenERKNS_15MacroDefinitionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord5IfdefENS_14SourceLocationERKNS_5TokenERKNS_15MacroDefinitionE")
  //</editor-fold>
  @Override public/*private*/ void Ifdef(SourceLocation HashLoc, SourceLocation EodLoc,
       SourceLocation Loc, 
       /*const*/ Token /*&*/ MacroNameTok, 
       /*const*/ MacroDefinition /*&*/ MD)/* override*/ {
    addCondDirectiveLoc(new CondDirectiveLoc(new SourceLocation(Loc), new SourceLocation(CondDirectiveStack.back())));
    CondDirectiveStack.push_back(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::Ifndef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp", line = 92,
   FQN="clang::PPConditionalDirectiveRecord::Ifndef", NM="_ZN5clang28PPConditionalDirectiveRecord6IfndefENS_14SourceLocationERKNS_5TokenERKNS_15MacroDefinitionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord6IfndefENS_14SourceLocationERKNS_5TokenERKNS_15MacroDefinitionE")
  //</editor-fold>
  @Override public/*private*/ void Ifndef(SourceLocation HashLoc, SourceLocation EodLoc,
          SourceLocation Loc, 
          /*const*/Token /*&*/ MacroNameTok, 
          /*const*/MacroDefinition /*P*/ MD) {
    addCondDirectiveLoc(new CondDirectiveLoc(Loc, CondDirectiveStack.back()));
    CondDirectiveStack.push_back(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::Else">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp", line = 107,
   FQN = "clang::PPConditionalDirectiveRecord::Else", NM = "_ZN5clang28PPConditionalDirectiveRecord4ElseENS_14SourceLocationES1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord4ElseENS_14SourceLocationES1_")
  //</editor-fold>
  @Override public/*private*/ void Else(SourceLocation HashLoc, SourceLocation EodLoc,
          SourceLocation Loc, SourceLocation IfLoc) {
    addCondDirectiveLoc(new CondDirectiveLoc(Loc, CondDirectiveStack.back()));
    CondDirectiveStack.back().$assign(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::Endif">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp", line = 113,
   FQN = "clang::PPConditionalDirectiveRecord::Endif", NM = "_ZN5clang28PPConditionalDirectiveRecord5EndifENS_14SourceLocationES1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecord5EndifENS_14SourceLocationES1_")
  //</editor-fold>
  @Override public/*private*/ void Endif(SourceLocation HashLoc, SourceLocation EodLoc,
          SourceLocation Loc, SourceLocation IfLoc) {
    addCondDirectiveLoc(new CondDirectiveLoc(Loc, CondDirectiveStack.back()));
    assert (!CondDirectiveStack.empty());
    CondDirectiveStack.pop_back();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PPConditionalDirectiveRecord::~PPConditionalDirectiveRecord">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PPConditionalDirectiveRecord.h", line = 26,
   FQN = "clang::PPConditionalDirectiveRecord::~PPConditionalDirectiveRecord", NM = "_ZN5clang28PPConditionalDirectiveRecordD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPConditionalDirectiveRecord.cpp -nm=_ZN5clang28PPConditionalDirectiveRecordD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

}
