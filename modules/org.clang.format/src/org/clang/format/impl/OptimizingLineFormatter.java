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

package org.clang.format.impl;

import java.util.Comparator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.format.*;
import static org.clang.format.impl.FormatStatics.*;


/// \brief Finds the best way to break lines.
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::OptimizingLineFormatter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 621,
 FQN="clang::format::(anonymous namespace)::OptimizingLineFormatter", NM="_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatterE")
//</editor-fold>
public class OptimizingLineFormatter extends /*public*/ LineFormatter implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::OptimizingLineFormatter::OptimizingLineFormatter">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 623,
   FQN="clang::format::(anonymous namespace)::OptimizingLineFormatter::OptimizingLineFormatter", NM="_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatterC1EPNS0_20ContinuationIndenterEPNS0_17WhitespaceManagerERKNS0_11FormatStyleEPNS0_22UnwrappedLineFormatterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatterC1EPNS0_20ContinuationIndenterEPNS0_17WhitespaceManagerERKNS0_11FormatStyleEPNS0_22UnwrappedLineFormatterE")
  //</editor-fold>
  public OptimizingLineFormatter(ContinuationIndenter /*P*/ Indenter, 
      WhitespaceManager /*P*/ Whitespaces, 
      final /*const*/ FormatStyle /*&*/ Style, 
      UnwrappedLineFormatter /*P*/ BlockFormatter) {
    // : LineFormatter(Indenter, Whitespaces, Style, BlockFormatter), Allocator() 
    //START JInit
    super(Indenter, Whitespaces, Style, BlockFormatter);
    this.Allocator = new SpecificBumpPtrAllocator<StateNode>(StateNode.class);
    //END JInit
  }

  
  /// \brief Formats the line by finding the best line breaks with line lengths
  /// below the column limit.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::OptimizingLineFormatter::formatLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 631,
   FQN="clang::format::(anonymous namespace)::OptimizingLineFormatter::formatLine", NM="_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatter10formatLineERKNS0_13AnnotatedLineEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatter10formatLineERKNS0_13AnnotatedLineEjb")
  //</editor-fold>
  @Override public /*uint*/int formatLine(final /*const*/ AnnotatedLine /*&*/ Line, /*uint*/int FirstIndent, 
            boolean DryRun)/* override*/ {
    LineState State = null;
    try {
      State = Indenter.getInitialState(FirstIndent, /*AddrOf*/Line, DryRun);
      
      // If the ObjC method declaration does not fit on a line, we should format
      // it with one arg per line.
      if (State.Line.Type == LineType.LT_ObjCMethodDecl) {
        State.Stack.back().BreakBeforeParameter = true;
      }
      
      // Find best solution in solution space.
      return analyzeSolutionSpace(State, DryRun);
    } finally {
      if (State != null) { State.$destroy(); }
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::OptimizingLineFormatter::CompareLineStatePointers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 645,
   FQN="clang::format::(anonymous namespace)::OptimizingLineFormatter::CompareLineStatePointers", NM="_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatter24CompareLineStatePointersE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatter24CompareLineStatePointersE")
  //</editor-fold>
  private static class/*struct*/ CompareLineStatePointers implements Compare<LineState> {
    //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::OptimizingLineFormatter::CompareLineStatePointers::operator()">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 646,
     FQN="clang::format::(anonymous namespace)::OptimizingLineFormatter::CompareLineStatePointers::operator()", NM="_ZNK5clang6format12_GLOBAL__N_123OptimizingLineFormatter24CompareLineStatePointersclEPNS0_9LineStateES5_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZNK5clang6format12_GLOBAL__N_123OptimizingLineFormatter24CompareLineStatePointersclEPNS0_9LineStateES5_")
    //</editor-fold>
    public boolean $call(LineState /*P*/ obj1, LineState /*P*/ obj2) /*const*/ {
      return /*Deref*/obj1.$less(/*Deref*/obj2);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public CompareLineStatePointers() { }
    
    @Override
    public boolean compare(LineState a, LineState b) {
      return $call(a, b);
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
  /// \brief A pair of <penalty, count> that is used to prioritize the BFS on.
  ///
  /// In case of equal penalties, we want to prefer states that were inserted
  /// first. During state generation we make sure that we insert states first
  /// that break the line as late as possible.
  // JAVA: typedef std::pair<unsigned int, unsigned int> OrderedPenalty
//  public final class OrderedPenalty extends std.pairUIntUInt{ };
  
  /// \brief An edge in the solution space from \c Previous->State to \c State,
  /// inserting a newline dependent on the \c NewLine.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::OptimizingLineFormatter::StateNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 660,
   FQN="clang::format::(anonymous namespace)::OptimizingLineFormatter::StateNode", NM="_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatter9StateNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatter9StateNodeE")
  //</editor-fold>
  private static class/*struct*/ StateNode implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::OptimizingLineFormatter::StateNode::StateNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 661,
     FQN="clang::format::(anonymous namespace)::OptimizingLineFormatter::StateNode::StateNode", NM="_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatter9StateNodeC1ERKNS0_9LineStateEbPS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatter9StateNodeC1ERKNS0_9LineStateEbPS3_")
    //</editor-fold>
    public StateNode(final /*const*/ LineState /*&*/ State, boolean NewLine, StateNode /*P*/ Previous) {
      // : State(State), NewLine(NewLine), Previous(Previous) 
      //START JInit
      this.State = new LineState(State);
      this.NewLine = NewLine;
      this.Previous = Previous;
      //END JInit
    }

    public LineState State;
    public boolean NewLine;
    public StateNode /*P*/ Previous;
    //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::OptimizingLineFormatter::StateNode::~StateNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 660,
     FQN="clang::format::(anonymous namespace)::OptimizingLineFormatter::StateNode::~StateNode", NM="_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatter9StateNodeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatter9StateNodeD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      State.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "State=" + State // NOI18N
                + ", NewLine=" + NewLine // NOI18N
                + ", Previous=" + Previous; // NOI18N
    }
  };
  
  /// \brief An item in the prioritized BFS search queue. The \c StateNode's
  /// \c State has the given \c OrderedPenalty.
  // JAVA: typedef std::pair<OrderedPenalty, StateNode *> QueueItem
//  public final class QueueItem extends std.pair<std.pairUIntUInt, StateNode /*P*/ >{ };
  
  /// \brief The BFS queue type.
  // JAVA: typedef std::priority_queue<QueueItem, std::vector<QueueItem>, std::greater<QueueItem> > QueueType
//  public final class QueueType extends std.priority_queue<std.pair<std.pairUIntUInt, StateNode /*P*/ >, std.vector<std.pair<std.pairUIntUInt, StateNode /*P*/ >>, std.greater<std.pair<std.pairUIntUInt, StateNode /*P*/ > > >{ };
  
  /// \brief Analyze the entire solution space starting from \p InitialState.
  ///
  /// This implements a variant of Dijkstra's algorithm on the graph that spans
  /// the solution space (\c LineStates are the nodes). The algorithm tries to
  /// find the shortest path (the one with lowest penalty) from \p InitialState
  /// to a state where all tokens are placed. Returns the penalty.
  ///
  /// If \p DryRun is \c false, directly applies the changes.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::OptimizingLineFormatter::analyzeSolutionSpace">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 684,
   FQN="clang::format::(anonymous namespace)::OptimizingLineFormatter::analyzeSolutionSpace", NM="_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatter20analyzeSolutionSpaceERNS0_9LineStateEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatter20analyzeSolutionSpaceERNS0_9LineStateEb")
  //</editor-fold>
  private /*uint*/int analyzeSolutionSpace(final LineState /*&*/ InitialState, boolean DryRun) {
    std.setPtr<LineState /*P*/ > Seen = null;
    std.priority_queue<std.pair<std.pairUIntUInt, StateNode /*P*/ >> Queue = null;
    try {
      Seen/*J*/= new std.setPtr<LineState /*P*/ >(new CompareLineStatePointers());
      
      // Increasing count of \c StateNode items we have created. This is used to
      // create a deterministic order independent of the container.
      uint$ptr Count = create_uint$ptr(0);
      Queue/*J*/ = new std.priority_queue<std.pair<std.pairUIntUInt, StateNode /*P*/>>(
                      new Comparator<std.pair<std.pairUIntUInt, StateNode /*P*/>>() {
                @Override
                public int compare(std.pair<std.pairUIntUInt, StateNode /*P*/> left, std.pair<std.pairUIntUInt, StateNode /*P*/> right) {
                  int res = left.first.first - right.first.first;
                  if (res == 0) {
                    res = left.first.second - right.first.second;
                    if (res == 0) {
                      //is need greate for StateNode?
                    }
                  }
                  return res;
                }
              });
      
      // Insert start element into queue.
      StateNode /*P*/ Node = ((/*JCast*/StateNode /*P*/ )(/*NEW_EXPR [System]*//*Allocator.Allocate() =*/ /*new (Allocator.Allocate())*/ $new_uint_voidPtr(Allocator.Allocate(), (type$ptr<?> New$Mem)->{
          return new StateNode(InitialState, false, (StateNode /*P*/ )null);
       })));
      Queue.push_value_type(new std.pairTypePtr<std.pairUIntUInt, StateNode /*P*/ >(JD$T$RR_T1$RR.INSTANCE, new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, 0, Count.$star()), Node));
      Count.$set$preInc(0);
      
      /*uint*/int Penalty = 0;
      
      // While not empty, take first element and follow edges.
      while (!Queue.empty()) {
        Penalty = Queue.top().first.first;
        StateNode /*P*/ Node$1 = Queue.top().second;
        if (!(Node$1.State.NextToken != null)) {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-formatter")) {
              llvm.dbgs().$out(/*KEEP_STR*/"\n---\nPenalty for line: ").$out_uint(Penalty).$out(/*KEEP_STR*/$LF);
            }
          } while (false);
          break;
        }
        Queue.pop();
        
        // Cut off the analysis of certain solutions if the analysis gets too
        // complex. See description of IgnoreStackForComparison.
        if ($greater_uint(Count.$star(), 50000)) {
          Node$1.State.IgnoreStackForComparison = true;
        }
        if (!Seen.insert_T$RR(/*AddrOf*/Node$1.State).second) {
          // State already examined with lower penalty.
          continue;
        }
        
        FormatDecision LastFormat = Node$1.State.NextToken.Decision;
        if (LastFormat == FormatDecision.FD_Unformatted || LastFormat == FormatDecision.FD_Continue) {
          addNextStateToQueue(Penalty, Node$1, /*NewLine=*/ false, /*AddrOf*/Count, /*AddrOf*/Queue);
        }
        if (LastFormat == FormatDecision.FD_Unformatted || LastFormat == FormatDecision.FD_Break) {
          addNextStateToQueue(Penalty, Node$1, /*NewLine=*/ true, /*AddrOf*/Count, /*AddrOf*/Queue);
        }
      }
      if (Queue.empty()) {
        // We were unable to find a solution, do nothing.
        // FIXME: Add diagnostic?
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-formatter")) {
            llvm.dbgs().$out(/*KEEP_STR*/"Could not find a solution.\n");
          }
        } while (false);
        return 0;
      }
      
      // Reconstruct the solution.
      if (!DryRun) {
        reconstructPath(InitialState, Queue.top().second);
      }
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-formatter")) {
          llvm.dbgs().$out(/*KEEP_STR*/"Total number of analyzed states: ").$out_uint(Count.$star()).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-formatter")) {
          llvm.dbgs().$out(/*KEEP_STR*/"---\n");
        }
      } while (false);
      
      return Penalty;
    } finally {
      if (Queue != null) { Queue.$destroy(); }
      if (Seen != null) { Seen.$destroy(); }
    }
  }

  
  /// \brief Add the following state to the analysis queue \c Queue.
  ///
  /// Assume the current state is \p PreviousNode and has been reached with a
  /// penalty of \p Penalty. Insert a line break if \p NewLine is \c true.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::OptimizingLineFormatter::addNextStateToQueue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 747,
   FQN="clang::format::(anonymous namespace)::OptimizingLineFormatter::addNextStateToQueue", NM="_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatter19addNextStateToQueueEjPNS2_9StateNodeEbPjPSt14priority_queueISt4pairIS7_IjjES4_ESt6vectorIS9_SaIS9_EESt7greaterIS9_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatter19addNextStateToQueueEjPNS2_9StateNodeEbPjPSt14priority_queueISt4pairIS7_IjjES4_ESt6vectorIS9_SaIS9_EESt7greaterIS9_EE")
  //</editor-fold>
  private void addNextStateToQueue(/*uint*/int Penalty, StateNode /*P*/ PreviousNode, 
                   boolean NewLine, uint$ptr/*uint P*/ Count, std.priority_queue<std.pair<std.pairUIntUInt, StateNode /*P*/ >> /*P*/ Queue) {
    if (NewLine && !Indenter.canBreak(PreviousNode.State)) {
      return;
    }
    if (!NewLine && Indenter.mustBreak(PreviousNode.State)) {
      return;
    }
    uint$ref Penalty_ref = create_uint$ref(Penalty);
    StateNode /*P*/ Node = ((/*JCast*/StateNode /*P*/ )(/*NEW_EXPR [System]*//*Allocator.Allocate() =*/ /*new (Allocator.Allocate())*/ $new_uint_voidPtr(Allocator.Allocate(), (type$ptr<?> New$Mem)->{
        return new StateNode(PreviousNode.State, NewLine, PreviousNode);
     })));
    if (!formatChildren(Node.State, NewLine, /*DryRun=*/ true, Penalty_ref)) {
      return;
    }
    
    Penalty_ref.$set$addassign(Indenter.addTokenToState(Node.State, NewLine, true));
    
    Queue.push_value_type(new std.pairTypePtr<std.pairUIntUInt, StateNode /*P*/ >(JD$T$RR_T1$RR.INSTANCE, new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, Penalty_ref.$deref(), Count.$star()), Node));
    Count.$set$preInc(0);
  }

  
  /// \brief Applies the best formatting by reconstructing the path in the
  /// solution space that leads to \c Best.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::OptimizingLineFormatter::reconstructPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 767,
   FQN="clang::format::(anonymous namespace)::OptimizingLineFormatter::reconstructPath", NM="_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatter15reconstructPathERNS0_9LineStateEPNS2_9StateNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatter15reconstructPathERNS0_9LineStateEPNS2_9StateNodeE")
  //</editor-fold>
  private void reconstructPath(final LineState /*&*/ State, StateNode /*P*/ Best) {
    std.deque<StateNode /*P*/ > Path = null;
    try {
      Path/*J*/= new std.deque<StateNode /*P*/ >(true);
      // We do not need a break before the initial token.
      while ((Best.Previous != null)) {
        Path.push_front_T$C$R(Best);
        Best = Best.Previous;
      }
      for (std_deque.deque.iterator<StateNode /*P*/ > I = Path.begin(), E = Path.end();
           $noteq__Deque_iterator$_Tp$_Ref$_Ptr$C(I, E); I.$preInc()) {
        uint$ref Penalty = create_uint$ref(0);
        formatChildren(State, (I.$star()).NewLine, /*DryRun=*/ false, Penalty);
        Penalty.$set$addassign(Indenter.addTokenToState(State, (I.$star()).NewLine, false));
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-formatter")) {
            {
              printLineState((I.$star()).Previous.State);
              if ((I.$star()).NewLine) {
                llvm.dbgs().$out(/*KEEP_STR*/"Penalty for placing ").$out((I.$star()).Previous.State.NextToken.Tok.getName()).$out(/*KEEP_STR*/": ").$out_uint(Penalty.$deref()).$out(/*KEEP_STR*/$LF);
              }
            }
            ;
          }
        } while (false);
      }
    } finally {
      if (Path != null) { Path.$destroy(); }
    }
  }

  
  private SpecificBumpPtrAllocator<StateNode> Allocator;
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::OptimizingLineFormatter::~OptimizingLineFormatter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 621,
   FQN="clang::format::(anonymous namespace)::OptimizingLineFormatter::~OptimizingLineFormatter", NM="_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_123OptimizingLineFormatterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Allocator.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Allocator=" + Allocator // NOI18N
              + super.toString(); // NOI18N
  }
}
