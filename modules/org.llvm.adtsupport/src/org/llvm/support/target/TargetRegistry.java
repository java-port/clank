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

package org.llvm.support.target;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.java.ADTFunctionPointers.Target2Bool;
import org.llvm.support.target.Target.*;
import org.llvm.support.target.impl.TargetRegistryStatics;
import static org.llvm.support.target.impl.TargetRegistryStatics.FirstTarget;


/// TargetRegistry - Generic interface to target specific features.
//<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 536,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 544,
 FQN="llvm::TargetRegistry", NM="_ZN4llvm14TargetRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistryE")
//</editor-fold>
public class/*struct*/ TargetRegistry {
  // FIXME: Make this a namespace, probably just move all the Register*
  // functions into Target (currently they all just set members on the Target
  // anyway, and Target friends this class so those functions can...
  // function).
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::TargetRegistry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 541,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 549,
   FQN="llvm::TargetRegistry::TargetRegistry", NM="_ZN4llvm14TargetRegistryC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistryC1Ev")
  //</editor-fold>
  public TargetRegistry() { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 543,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 551,
   FQN="llvm::TargetRegistry::iterator", NM="_ZN4llvm14TargetRegistry8iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry8iteratorE")
  //</editor-fold>
  public static class iterator implements /*public*/ std.iterator<std.input_iterator_tag, Target>, /*Native.NativeComparable<iterator>,*/ type$iterator<iterator, Target> {
    private /*const*/ Target /*P*/ Current;
    //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 546,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 554,
     FQN="llvm::TargetRegistry::iterator::iterator", NM="_ZN4llvm14TargetRegistry8iteratorC1EPNS_6TargetE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry8iteratorC1EPNS_6TargetE")
    //</editor-fold>
    private /*explicit*/ iterator(Target /*P*/ T) {
      // : std::iterator<std::forward_iterator_tag, Target, ptrdiff_t>(), Current(T) 
      //START JInit
      $iterator();
      this.Current = T;
      //END JInit
    }

    /*friend  struct TargetRegistry*/
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 550,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 558,
     FQN="llvm::TargetRegistry::iterator::iterator", NM="_ZN4llvm14TargetRegistry8iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry8iteratorC1Ev")
    //</editor-fold>
    public iterator() {
      // : std::iterator<std::forward_iterator_tag, Target, ptrdiff_t>(), Current(null) 
      //START JInit
      $iterator();
      this.Current = null;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 552,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 560,
     FQN="llvm::TargetRegistry::iterator::operator==", NM="_ZNK4llvm14TargetRegistry8iteratoreqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm14TargetRegistry8iteratoreqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ iterator /*&*/ x) /*const*/ {
      return Current == x.Current;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 553,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 561,
     FQN="llvm::TargetRegistry::iterator::operator!=", NM="_ZNK4llvm14TargetRegistry8iteratorneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm14TargetRegistry8iteratorneERKS1_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ iterator /*&*/ x) /*const*/ {
      return !$eq(x);
    }

    
    // Iterator traversal: forward iteration only
    //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 556,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 564,
     FQN="llvm::TargetRegistry::iterator::operator++", NM="_ZN4llvm14TargetRegistry8iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry8iteratorppEv")
    //</editor-fold>
    public iterator /*&*/ $preInc() {
      // Preincrement
      assert ((Current != null)) : "Cannot increment end iterator!";
      Current = Current.getNext();
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 561,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 569,
     FQN="llvm::TargetRegistry::iterator::operator++", NM="_ZN4llvm14TargetRegistry8iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry8iteratorppEi")
    //</editor-fold>
    public iterator $postInc(int $Prm0) {
      // Postincrement
      iterator tmp = new iterator(/*Deref*/this);
      /*Deref*/this.$preInc();
      return tmp;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 567,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 575,
     FQN="llvm::TargetRegistry::iterator::operator*", NM="_ZNK4llvm14TargetRegistry8iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm14TargetRegistry8iteratordeEv")
    //</editor-fold>
    public /*const*/ Target /*&*/ $star() /*const*/ {
      assert ((Current != null)) : "Cannot dereference end iterator!";
      return $Deref(Current);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 572,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 580,
     FQN="llvm::TargetRegistry::iterator::operator->", NM="_ZNK4llvm14TargetRegistry8iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm14TargetRegistry8iteratorptEv")
    //</editor-fold>
    public /*const*/ Target /*P*/ $arrow() /*const*/ {
      return $AddrOf($star());
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 543,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 551,
     FQN="llvm::TargetRegistry::iterator::iterator", NM="_ZN4llvm14TargetRegistry8iteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry8iteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ iterator(final /*const*/ iterator /*&*/ $Prm0) {
      // : std::iterator<std::forward_iterator_tag, Target, ptrdiff_t>(), Current(.Current) 
      //START JInit
      $iterator($Prm0);
      this.Current = $Prm0.Current;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 543,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 551,
     FQN="llvm::TargetRegistry::iterator::iterator", NM="_ZN4llvm14TargetRegistry8iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry8iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ iterator(JD$Move _dparam, final iterator /*&&*/$Prm0) {
      // : std::iterator<std::forward_iterator_tag, Target, ptrdiff_t>(static_cast<iterator &&>()), Current(static_cast<iterator &&>().Current) 
      //START JInit
      $iterator(JD$Move.INSTANCE, $Prm0);
      this.Current = $Prm0.Current;
      //END JInit
    }

    @Override
    public iterator clone() {
      return new iterator(this);
    }

    @Override
    public iterator const_clone() {
      return clone();
    }

    @Override
    public boolean $eq(Object other) {
      return $eq((iterator)other);
    }
    
    @Override public String toString() {
      return "" + "Current=" + Current // NOI18N
                + super.toString(); // NOI18N
    }

  };
  
  /// printRegisteredTargetsForVersion - Print the registered targets
  /// appropriately for inclusion in a tool's version output.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::printRegisteredTargetsForVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp", line = 118,
   old_source = "${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp", old_line = 119,
   FQN="llvm::TargetRegistry::printRegisteredTargetsForVersion", NM="_ZN4llvm14TargetRegistry32printRegisteredTargetsForVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry32printRegisteredTargetsForVersionEv")
  //</editor-fold>
  public static void printRegisteredTargetsForVersion() {
    std.vector<std.pairTypePtr<StringRef, /*const*/ Target /*P*/ >> Targets = null;
    try {
      Targets/*J*/= new std.vector<std.pairTypePtr<StringRef, /*const*/ Target /*P*/ >>(new std.pairTypePtr<StringRef, /*const*/ Target /*P*/ >());
      /*size_t*/int Width = 0;
      for (final /*const*/ Target /*&*/ T : TargetRegistry.targets()) {
        Targets.push_back_T$RR(new std.pairTypePtr<StringRef, /*const*/ Target /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, new StringRef(/*Fwd2*//*Fwd*/T.getName()), /*Fwd2*//*Fwd*/$AddrOf(T)));
        Width = std.max(Width, Targets.back().first.size());
      }
      array_pod_sort(Targets.begin(), Targets.end(), /*FuncRef*/TargetRegistryStatics::TargetArraySortFn);
      
      final raw_ostream /*&*/ OS = outs();
      OS.$out(/*KEEP_STR*/"  Registered Targets:\n");
      for (/*uint*/int i = 0, e = Targets.size(); i != e; ++i) {
        OS.$out(/*KEEP_STR*/"    ").$out(/*NO_COPY*/Targets.$at(i).first);
        OS.indent(Width - Targets.$at(i).first.size()).$out(/*KEEP_STR*/" - ").$out(
            Targets.$at(i).second.getShortDescription()
        ).$out_char($$LF);
      }
      if (Targets.empty()) {
        OS.$out(/*KEEP_STR*/"    (none)\n");
      }
    } finally {
      if (Targets != null) { Targets.$destroy(); }
    }
  }

  
  /// @name Registry Access
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::targets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp", line = 21,
   FQN="llvm::TargetRegistry::targets", NM="_ZN4llvm14TargetRegistry7targetsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry7targetsEv")
  //</editor-fold>
  public static iterator_range</*const*/ Target /*&*/ > targets() {
    return llvm.make_range(new iterator(TargetRegistryStatics.FirstTarget), new iterator());
  }

  
  /// lookupTarget - Lookup a target based on a target triple.
  ///
  /// \param Triple - The triple to use for finding a target.
  /// \param Error - On failure, an error string describing why no target was
  /// found.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::lookupTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp", line = 64,
   FQN="llvm::TargetRegistry::lookupTarget", NM="_ZN4llvm14TargetRegistry12lookupTargetERKSsRSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry12lookupTargetERKSsRSs")
  //</editor-fold>
  public static /*const*/ Target /*P*/ lookupTarget(final /*const*/std.string/*&*/ TT, 
              final std.string/*&*/ Error) {
    // Provide special warning when no targets are initialized.
    if (((iterator)targets().begin()).$eq(((iterator)targets().end()))) {
      Error.$assign_T$C$P(/*KEEP_STR*/"Unable to find target for this triple (no targets are registered)");
      return null;
    }
    Triple.ArchType Arch = new Triple(new Twine(TT)).getArch();
    Target2Bool ArchMatch = /*[&, &Arch]*/ (final /*const*/ Target /*&*/ T) -> {
        return T.ArchMatchFn.$call(Arch);
      };
    iterator I = std.find_if(((iterator)targets().begin()), ((iterator)targets().end()), ArchMatch);
    if (I.$eq(((iterator)targets().end()))) {
      Error.$assign_T$C$P(/*KEEP_STR*/"No available targets are compatible with this triple.");
      return null;
    }
    
    iterator J = std.find_if(std.next(new iterator(I)), ((iterator)targets().end()), ArchMatch);
    if (J.$noteq(((iterator)targets().end()))) {
      Error.$assignMove($add_string_T$C$P($add_string_T$C$P($add_string_T$C$P($add_string_T$C$P(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"Cannot choose between targets \""), I.$arrow().Name), 
                      /*KEEP_STR*/"\" and \""), J.$arrow().Name), /*KEEP_STR*/"\""));
      return null;
    }
    
    return $AddrOf(I.$star());
  }

  
  /// lookupTarget - Lookup a target based on an architecture name
  /// and a target triple.  If the architecture name is non-empty,
  /// then the lookup is done by architecture.  Otherwise, the target
  /// triple is used.
  ///
  /// \param ArchName - The architecture to use for finding a target.
  /// \param TheTriple - The triple to use for finding a target.  The
  /// triple is updated with canonical architecture name if a lookup
  /// by architecture is done.
  /// \param Error - On failure, an error string describing why no target was
  /// found.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::lookupTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp", line = 25,
   FQN="llvm::TargetRegistry::lookupTarget", NM="_ZN4llvm14TargetRegistry12lookupTargetERKSsRNS_6TripleERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry12lookupTargetERKSsRNS_6TripleERSs")
  //</editor-fold>
  public static /*const*/ Target /*P*/ lookupTarget(final /*const*/std.string/*&*/ ArchName, 
              final Triple /*&*/ TheTriple, 
              final std.string/*&*/ Error) {
    // Allocate target machine.  First, check whether the user has explicitly
    // specified an architecture to compile for. If so we have to look it up by
    // name, because it might be a backend that has no mapping to a target triple.
    /*const*/ Target /*P*/ TheTarget = null;
    if (!ArchName.empty()) {
      iterator I = std.find_if(((iterator)targets().begin()), ((iterator)targets().end()), 
          /*[&, &ArchName]*/ (final /*const*/ Target /*&*/ T) -> {
                return $eq_string$C_T$C$P(ArchName, T.getName());
              });
      if (I.$eq(((iterator)targets().end()))) {
        Error.$assignMove($add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"error: invalid target '", ArchName), /*KEEP_STR*/"'.\n"));
        return null;
      }
      
      TheTarget = $AddrOf(I.$star());
      
      // Adjust the triple to match (if known), otherwise stick with the
      // given triple.
      Triple.ArchType Type = Triple.getArchTypeForLLVMName(new StringRef(ArchName));
      if (Type != Triple.ArchType.UnknownArch) {
        TheTriple.setArch(Type);
      }
    } else {
      // Get the target specific parser.
      std.string TempError/*J*/= new std.string();
      TheTarget = TargetRegistry.lookupTarget(TheTriple.getTriple(), TempError);
      if (!(TheTarget != null)) {
        Error.$assignMove($add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/": error: unable to get target for '", 
                    TheTriple.getTriple()), 
                /*KEEP_STR*/"', see --version and --triple.\n"));
        return null;
      }
    }
    
    return TheTarget;
  }

  
  /// @}
  /// @name Target Registration
  /// @{
  
  /// RegisterTarget - Register the given target. Attempts to register a
  /// target which has already been registered will be ignored.
  ///
  /// Clients are responsible for ensuring that registration doesn't occur
  /// while another thread is attempting to access the registry. Typically
  /// this is done by initializing all targets at program startup.
  ///
  /// @param T - The target being registered.
  /// @param Name - The target name. This should be a static string.
  /// @param ShortDesc - A short target description. This should be a static
  /// string.
  /// @param ArchMatchFn - The arch match checking function for this target.
  /// @param HasJIT - Whether the target supports JIT code
  /// generation.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp", line = 90,
   old_source = "${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp", old_line = 91,
   FQN="llvm::TargetRegistry::RegisterTarget", NM="_ZN4llvm14TargetRegistry14RegisterTargetERNS_6TargetEPKcS4_PFbNS_6Triple8ArchTypeEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry14RegisterTargetERNS_6TargetEPKcS4_PFbNS_6Triple8ArchTypeEEb")
  //</editor-fold>
  public static void RegisterTarget(final Target /*&*/ T, 
                /*const*/char$ptr/*char P*/ Name, 
                /*const*/char$ptr/*char P*/ ShortDesc, 
                ArchMatchFnTy ArchMatchFn) {
    RegisterTarget(T, 
                Name, 
                ShortDesc, 
                ArchMatchFn, 
                false);
  }
  public static void RegisterTarget(final Target /*&*/ T, 
                /*const*/char$ptr/*char P*/ Name, 
                /*const*/char$ptr/*char P*/ ShortDesc, 
                ArchMatchFnTy ArchMatchFn, 
                boolean HasJIT/*= false*/) {
    assert (Native.$bool(Name) && Native.$bool(ShortDesc) && (ArchMatchFn != null)) : "Missing required target information!";
    
    // Check if this target has already been initialized, we allow this as a
    // convenience to some clients.
    if (Native.$bool(T.Name)) {
      return;
    }
    
    // Add to the list of targets.
    T.Next = FirstTarget;
    FirstTarget = $AddrOf(T);
    
    T.Name = $tryClone(Name);
    T.ShortDesc = $tryClone(ShortDesc);
    T.ArchMatchFn = $tryClone(ArchMatchFn);
    T.HasJIT = HasJIT;
  }

  
  /// RegisterMCAsmInfo - Register a MCAsmInfo implementation for the
  /// given target.
  ///
  /// Clients are responsible for ensuring that registration doesn't occur
  /// while another thread is attempting to access the registry. Typically
  /// this is done by initializing all targets at program startup.
  ///
  /// @param T - The target being registered.
  /// @param Fn - A function to construct a MCAsmInfo for the target.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterMCAsmInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 637,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 645,
   FQN="llvm::TargetRegistry::RegisterMCAsmInfo", NM="_ZN4llvm14TargetRegistry17RegisterMCAsmInfoERNS_6TargetEPFPNS_9MCAsmInfoERKNS_14MCRegisterInfoERKNS_6TripleEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry17RegisterMCAsmInfoERNS_6TargetEPFPNS_9MCAsmInfoERKNS_14MCRegisterInfoERKNS_6TripleEE")
  //</editor-fold>
  public static void RegisterMCAsmInfo(final Target /*&*/ T, Target.MCAsmInfoCtorFnTy Fn) {
    T.MCAsmInfoCtorFn = Fn;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::registerMCAdjustCodeGenOpts">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 641,
   FQN="llvm::TargetRegistry::registerMCAdjustCodeGenOpts", NM="_ZN4llvm14TargetRegistry27registerMCAdjustCodeGenOptsERNS_6TargetEPFvRKNS_6TripleENS_5Reloc5ModelERNS_9CodeModel5ModelEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry27registerMCAdjustCodeGenOptsERNS_6TargetEPFvRKNS_6TripleENS_5Reloc5ModelERNS_9CodeModel5ModelEE")
  //</editor-fold>
  public static void registerMCAdjustCodeGenOpts(final Target /*&*/ T, Target.MCAdjustCodeGenOptsFnTy Fn) {
    T.MCAdjustCodeGenOptsFn = Fn;
  }

  
  /// RegisterMCInstrInfo - Register a MCInstrInfo implementation for the
  /// given target.
  ///
  /// Clients are responsible for ensuring that registration doesn't occur
  /// while another thread is attempting to access the registry. Typically
  /// this is done by initializing all targets at program startup.
  ///
  /// @param T - The target being registered.
  /// @param Fn - A function to construct a MCInstrInfo for the target.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterMCInstrInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 655,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 672,
   FQN="llvm::TargetRegistry::RegisterMCInstrInfo", NM="_ZN4llvm14TargetRegistry19RegisterMCInstrInfoERNS_6TargetEPFPNS_11MCInstrInfoEvE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry19RegisterMCInstrInfoERNS_6TargetEPFPNS_11MCInstrInfoEvE")
  //</editor-fold>
  public static void RegisterMCInstrInfo(final Target /*&*/ T, Target.MCInstrInfoCtorFnTy Fn) {
    T.MCInstrInfoCtorFn = Fn;
  }

  
  /// RegisterMCInstrAnalysis - Register a MCInstrAnalysis implementation for
  /// the given target.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterMCInstrAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 661,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 678,
   FQN="llvm::TargetRegistry::RegisterMCInstrAnalysis", NM="_ZN4llvm14TargetRegistry23RegisterMCInstrAnalysisERNS_6TargetEPFPNS_15MCInstrAnalysisEPKNS_11MCInstrInfoEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry23RegisterMCInstrAnalysisERNS_6TargetEPFPNS_15MCInstrAnalysisEPKNS_11MCInstrInfoEE")
  //</editor-fold>
  public static void RegisterMCInstrAnalysis(final Target /*&*/ T, 
                         Target.MCInstrAnalysisCtorFnTy Fn) {
    T.MCInstrAnalysisCtorFn = Fn;
  }

  
  /// RegisterMCRegInfo - Register a MCRegisterInfo implementation for the
  /// given target.
  ///
  /// Clients are responsible for ensuring that registration doesn't occur
  /// while another thread is attempting to access the registry. Typically
  /// this is done by initializing all targets at program startup.
  ///
  /// @param T - The target being registered.
  /// @param Fn - A function to construct a MCRegisterInfo for the target.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterMCRegInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 675,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 692,
   FQN="llvm::TargetRegistry::RegisterMCRegInfo", NM="_ZN4llvm14TargetRegistry17RegisterMCRegInfoERNS_6TargetEPFPNS_14MCRegisterInfoERKNS_6TripleEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry17RegisterMCRegInfoERNS_6TargetEPFPNS_14MCRegisterInfoERKNS_6TripleEE")
  //</editor-fold>
  public static void RegisterMCRegInfo(final Target /*&*/ T, Target.MCRegInfoCtorFnTy Fn) {
    T.MCRegInfoCtorFn = Fn;
  }

  
  /// RegisterMCSubtargetInfo - Register a MCSubtargetInfo implementation for
  /// the given target.
  ///
  /// Clients are responsible for ensuring that registration doesn't occur
  /// while another thread is attempting to access the registry. Typically
  /// this is done by initializing all targets at program startup.
  ///
  /// @param T - The target being registered.
  /// @param Fn - A function to construct a MCSubtargetInfo for the target.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterMCSubtargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 688,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 705,
   FQN="llvm::TargetRegistry::RegisterMCSubtargetInfo", NM="_ZN4llvm14TargetRegistry23RegisterMCSubtargetInfoERNS_6TargetEPFPNS_15MCSubtargetInfoERKNS_6TripleENS_9StringRefES8_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry23RegisterMCSubtargetInfoERNS_6TargetEPFPNS_15MCSubtargetInfoERKNS_6TripleENS_9StringRefES8_E")
  //</editor-fold>
  public static void RegisterMCSubtargetInfo(final Target /*&*/ T, 
                         Target.MCSubtargetInfoCtorFnTy Fn) {
    T.MCSubtargetInfoCtorFn = Fn;
  }

  
  /// RegisterTargetMachine - Register a TargetMachine implementation for the
  /// given target.
  ///
  /// Clients are responsible for ensuring that registration doesn't occur
  /// while another thread is attempting to access the registry. Typically
  /// this is done by initializing all targets at program startup.
  ///
  /// @param T - The target being registered.
  /// @param Fn - A function to construct a TargetMachine for the target.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterTargetMachine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 702,
   FQN="llvm::TargetRegistry::RegisterTargetMachine", NM="_ZN4llvm14TargetRegistry21RegisterTargetMachineERNS_6TargetEPFPNS_13TargetMachineERKS1_RKNS_6TripleENS_9StringRefESA_RKNS_13TargetOptionsENS_8OptionalINS_5Reloc5ModelEEENS_9CodeModel5ModelENS_10CodeGenOpt5LevelEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry21RegisterTargetMachineERNS_6TargetEPFPNS_13TargetMachineERKS1_RKNS_6TripleENS_9StringRefESA_RKNS_13TargetOptionsENS_8OptionalINS_5Reloc5ModelEEENS_9CodeModel5ModelENS_10CodeGenOpt5LevelEE")
  //</editor-fold>
  public static void RegisterTargetMachine(final Target /*&*/ T, Target.TargetMachineCtorTy Fn) {
    T.TargetMachineCtorFn = Fn;
  }

  
  /// RegisterMCAsmBackend - Register a MCAsmBackend implementation for the
  /// given target.
  ///
  /// Clients are responsible for ensuring that registration doesn't occur
  /// while another thread is attempting to access the registry. Typically
  /// this is done by initializing all targets at program startup.
  ///
  /// @param T - The target being registered.
  /// @param Fn - A function to construct an AsmBackend for the target.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterMCAsmBackend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 715,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 732,
   FQN="llvm::TargetRegistry::RegisterMCAsmBackend", NM="_ZN4llvm14TargetRegistry20RegisterMCAsmBackendERNS_6TargetEPFPNS_12MCAsmBackendERKS1_RKNS_14MCRegisterInfoERKNS_6TripleENS_9StringRefEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry20RegisterMCAsmBackendERNS_6TargetEPFPNS_12MCAsmBackendERKS1_RKNS_14MCRegisterInfoERKNS_6TripleENS_9StringRefEE")
  //</editor-fold>
  public static void RegisterMCAsmBackend(final Target /*&*/ T, Target.MCAsmBackendCtorTy Fn) {
    T.MCAsmBackendCtorFn = Fn;
  }

  
  /// RegisterMCAsmParser - Register a MCTargetAsmParser implementation for
  /// the given target.
  ///
  /// Clients are responsible for ensuring that registration doesn't occur
  /// while another thread is attempting to access the registry. Typically
  /// this is done by initializing all targets at program startup.
  ///
  /// @param T - The target being registered.
  /// @param Fn - A function to construct an MCTargetAsmParser for the target.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterMCAsmParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 728,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 745,
   FQN="llvm::TargetRegistry::RegisterMCAsmParser", NM="_ZN4llvm14TargetRegistry19RegisterMCAsmParserERNS_6TargetEPFPNS_17MCTargetAsmParserERKNS_15MCSubtargetInfoERNS_11MCAsmParserERKNS_11MCInstrInfoERKNS_15MCTargetOptionsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry19RegisterMCAsmParserERNS_6TargetEPFPNS_17MCTargetAsmParserERKNS_15MCSubtargetInfoERNS_11MCAsmParserERKNS_11MCInstrInfoERKNS_15MCTargetOptionsEE")
  //</editor-fold>
  public static void RegisterMCAsmParser(final Target /*&*/ T, Target.MCAsmParserCtorTy Fn) {
    T.MCAsmParserCtorFn = Fn;
  }

  
  /// RegisterAsmPrinter - Register an AsmPrinter implementation for the given
  /// target.
  ///
  /// Clients are responsible for ensuring that registration doesn't occur
  /// while another thread is attempting to access the registry. Typically
  /// this is done by initializing all targets at program startup.
  ///
  /// @param T - The target being registered.
  /// @param Fn - A function to construct an AsmPrinter for the target.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterAsmPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 741,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 758,
   FQN="llvm::TargetRegistry::RegisterAsmPrinter", NM="_ZN4llvm14TargetRegistry18RegisterAsmPrinterERNS_6TargetEPFPNS_10AsmPrinterERNS_13TargetMachineEOSt10unique_ptrINS_10MCStreamerESt14default_deleteIS8_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry18RegisterAsmPrinterERNS_6TargetEPFPNS_10AsmPrinterERNS_13TargetMachineEOSt10unique_ptrINS_10MCStreamerESt14default_deleteIS8_EEE")
  //</editor-fold>
  public static void RegisterAsmPrinter(final Target /*&*/ T, Target.AsmPrinterCtorTy Fn) {
    T.AsmPrinterCtorFn = Fn;
  }

  
  /// RegisterMCDisassembler - Register a MCDisassembler implementation for
  /// the given target.
  ///
  /// Clients are responsible for ensuring that registration doesn't occur
  /// while another thread is attempting to access the registry. Typically
  /// this is done by initializing all targets at program startup.
  ///
  /// @param T - The target being registered.
  /// @param Fn - A function to construct an MCDisassembler for the target.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterMCDisassembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 754,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 771,
   FQN="llvm::TargetRegistry::RegisterMCDisassembler", NM="_ZN4llvm14TargetRegistry22RegisterMCDisassemblerERNS_6TargetEPFPNS_14MCDisassemblerERKS1_RKNS_15MCSubtargetInfoERNS_9MCContextEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry22RegisterMCDisassemblerERNS_6TargetEPFPNS_14MCDisassemblerERKS1_RKNS_15MCSubtargetInfoERNS_9MCContextEE")
  //</editor-fold>
  public static void RegisterMCDisassembler(final Target /*&*/ T, 
                        Target.MCDisassemblerCtorTy Fn) {
    T.MCDisassemblerCtorFn = Fn;
  }

  
  /// RegisterMCInstPrinter - Register a MCInstPrinter implementation for the
  /// given target.
  ///
  /// Clients are responsible for ensuring that registration doesn't occur
  /// while another thread is attempting to access the registry. Typically
  /// this is done by initializing all targets at program startup.
  ///
  /// @param T - The target being registered.
  /// @param Fn - A function to construct an MCInstPrinter for the target.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterMCInstPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 768,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 785,
   FQN="llvm::TargetRegistry::RegisterMCInstPrinter", NM="_ZN4llvm14TargetRegistry21RegisterMCInstPrinterERNS_6TargetEPFPNS_13MCInstPrinterERKNS_6TripleEjRKNS_9MCAsmInfoERKNS_11MCInstrInfoERKNS_14MCRegisterInfoEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry21RegisterMCInstPrinterERNS_6TargetEPFPNS_13MCInstPrinterERKNS_6TripleEjRKNS_9MCAsmInfoERKNS_11MCInstrInfoERKNS_14MCRegisterInfoEE")
  //</editor-fold>
  public static void RegisterMCInstPrinter(final Target /*&*/ T, Target.MCInstPrinterCtorTy Fn) {
    T.MCInstPrinterCtorFn = Fn;
  }

  
  /// RegisterMCCodeEmitter - Register a MCCodeEmitter implementation for the
  /// given target.
  ///
  /// Clients are responsible for ensuring that registration doesn't occur
  /// while another thread is attempting to access the registry. Typically
  /// this is done by initializing all targets at program startup.
  ///
  /// @param T - The target being registered.
  /// @param Fn - A function to construct an MCCodeEmitter for the target.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterMCCodeEmitter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 781,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 798,
   FQN="llvm::TargetRegistry::RegisterMCCodeEmitter", NM="_ZN4llvm14TargetRegistry21RegisterMCCodeEmitterERNS_6TargetEPFPNS_13MCCodeEmitterERKNS_11MCInstrInfoERKNS_14MCRegisterInfoERNS_9MCContextEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry21RegisterMCCodeEmitterERNS_6TargetEPFPNS_13MCCodeEmitterERKNS_11MCInstrInfoERKNS_14MCRegisterInfoERNS_9MCContextEE")
  //</editor-fold>
  public static void RegisterMCCodeEmitter(final Target /*&*/ T, Target.MCCodeEmitterCtorTy Fn) {
    T.MCCodeEmitterCtorFn = Fn;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterCOFFStreamer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 785,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 802,
   FQN="llvm::TargetRegistry::RegisterCOFFStreamer", NM="_ZN4llvm14TargetRegistry20RegisterCOFFStreamerERNS_6TargetEPFPNS_10MCStreamerERNS_9MCContextERNS_12MCAsmBackendERNS_17raw_pwrite_streamEPNS_13MCCodeEmitterEbbE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry20RegisterCOFFStreamerERNS_6TargetEPFPNS_10MCStreamerERNS_9MCContextERNS_12MCAsmBackendERNS_17raw_pwrite_streamEPNS_13MCCodeEmitterEbbE")
  //</editor-fold>
  public static void RegisterCOFFStreamer(final Target /*&*/ T, COFFStreamerCtorTy Fn) {
    T.COFFStreamerCtorFn = Fn;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterMachOStreamer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 789,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 806,
   FQN="llvm::TargetRegistry::RegisterMachOStreamer", NM="_ZN4llvm14TargetRegistry21RegisterMachOStreamerERNS_6TargetEPFPNS_10MCStreamerERNS_9MCContextERNS_12MCAsmBackendERNS_17raw_pwrite_streamEPNS_13MCCodeEmitterEbbE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry21RegisterMachOStreamerERNS_6TargetEPFPNS_10MCStreamerERNS_9MCContextERNS_12MCAsmBackendERNS_17raw_pwrite_streamEPNS_13MCCodeEmitterEbbE")
  //</editor-fold>
  public static void RegisterMachOStreamer(final Target /*&*/ T, MachOStreamerCtorTy Fn) {
    T.MachOStreamerCtorFn = Fn;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterELFStreamer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 793,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 810,
   FQN="llvm::TargetRegistry::RegisterELFStreamer", NM="_ZN4llvm14TargetRegistry19RegisterELFStreamerERNS_6TargetEPFPNS_10MCStreamerERKNS_6TripleERNS_9MCContextERNS_12MCAsmBackendERNS_17raw_pwrite_streamEPNS_13MCCodeEmitterEbE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry19RegisterELFStreamerERNS_6TargetEPFPNS_10MCStreamerERKNS_6TripleERNS_9MCContextERNS_12MCAsmBackendERNS_17raw_pwrite_streamEPNS_13MCCodeEmitterEbE")
  //</editor-fold>
  public static void RegisterELFStreamer(final Target /*&*/ T, ELFStreamerCtorTy Fn) {
    T.ELFStreamerCtorFn = Fn;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterNullTargetStreamer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 797,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 814,
   FQN="llvm::TargetRegistry::RegisterNullTargetStreamer", NM="_ZN4llvm14TargetRegistry26RegisterNullTargetStreamerERNS_6TargetEPFPNS_16MCTargetStreamerERNS_10MCStreamerEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry26RegisterNullTargetStreamerERNS_6TargetEPFPNS_16MCTargetStreamerERNS_10MCStreamerEE")
  //</editor-fold>
  public static void RegisterNullTargetStreamer(final Target /*&*/ T, NullTargetStreamerCtorTy Fn) {
    T.NullTargetStreamerCtorFn = Fn;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterAsmTargetStreamer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 802,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 819,
   FQN="llvm::TargetRegistry::RegisterAsmTargetStreamer", NM="_ZN4llvm14TargetRegistry25RegisterAsmTargetStreamerERNS_6TargetEPFPNS_16MCTargetStreamerERNS_10MCStreamerERNS_21formatted_raw_ostreamEPNS_13MCInstPrinterEbE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry25RegisterAsmTargetStreamerERNS_6TargetEPFPNS_16MCTargetStreamerERNS_10MCStreamerERNS_21formatted_raw_ostreamEPNS_13MCInstPrinterEbE")
  //</editor-fold>
  public static void RegisterAsmTargetStreamer(final Target /*&*/ T, AsmTargetStreamerCtorTy Fn) {
    T.AsmTargetStreamerCtorFn = Fn;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterObjectTargetStreamer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 807,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 824,
   FQN="llvm::TargetRegistry::RegisterObjectTargetStreamer", NM="_ZN4llvm14TargetRegistry28RegisterObjectTargetStreamerERNS_6TargetEPFPNS_16MCTargetStreamerERNS_10MCStreamerERKNS_15MCSubtargetInfoEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry28RegisterObjectTargetStreamerERNS_6TargetEPFPNS_16MCTargetStreamerERNS_10MCStreamerERKNS_15MCSubtargetInfoEE")
  //</editor-fold>
  public static void RegisterObjectTargetStreamer(final Target /*&*/ T, ObjectTargetStreamerCtorTy Fn) {
    T.ObjectTargetStreamerCtorFn = Fn;
  }

  
  /// RegisterMCRelocationInfo - Register an MCRelocationInfo
  /// implementation for the given target.
  ///
  /// Clients are responsible for ensuring that registration doesn't occur
  /// while another thread is attempting to access the registry. Typically
  /// this is done by initializing all targets at program startup.
  ///
  /// @param T - The target being registered.
  /// @param Fn - A function to construct an MCRelocationInfo for the target.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterMCRelocationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 822,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 839,
   FQN="llvm::TargetRegistry::RegisterMCRelocationInfo", NM="_ZN4llvm14TargetRegistry24RegisterMCRelocationInfoERNS_6TargetEPFPNS_16MCRelocationInfoERKNS_6TripleERNS_9MCContextEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry24RegisterMCRelocationInfoERNS_6TargetEPFPNS_16MCRelocationInfoERKNS_6TripleERNS_9MCContextEE")
  //</editor-fold>
  public static void RegisterMCRelocationInfo(final Target /*&*/ T, 
                          Target.MCRelocationInfoCtorTy Fn) {
    T.MCRelocationInfoCtorFn = Fn;
  }

  
  /// RegisterMCSymbolizer - Register an MCSymbolizer
  /// implementation for the given target.
  ///
  /// Clients are responsible for ensuring that registration doesn't occur
  /// while another thread is attempting to access the registry. Typically
  /// this is done by initializing all targets at program startup.
  ///
  /// @param T - The target being registered.
  /// @param Fn - A function to construct an MCSymbolizer for the target.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRegistry::RegisterMCSymbolizer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 836,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 853,
   FQN="llvm::TargetRegistry::RegisterMCSymbolizer", NM="_ZN4llvm14TargetRegistry20RegisterMCSymbolizerERNS_6TargetEPFPNS_12MCSymbolizerERKNS_6TripleEPFiPvyyyiS8_EPFPKcS8_yPyyPSC_ES8_PNS_9MCContextEOSt10unique_ptrINS_16MCRelocationInfoESt14default_deleteISK_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm14TargetRegistry20RegisterMCSymbolizerERNS_6TargetEPFPNS_12MCSymbolizerERKNS_6TripleEPFiPvyyyiS8_EPFPKcS8_yPyyPSC_ES8_PNS_9MCContextEOSt10unique_ptrINS_16MCRelocationInfoESt14default_deleteISK_EEE")
  //</editor-fold>
  public static void RegisterMCSymbolizer(final Target /*&*/ T, Target.MCSymbolizerCtorTy Fn) {
    T.MCSymbolizerCtorFn = Fn;
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
/// @}
}
